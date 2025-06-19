package com.mitocode.evalumitocode.service.Impl;

import com.mitocode.evalumitocode.model.Matricula;
import com.mitocode.evalumitocode.repo.IGenericRepo;
import com.mitocode.evalumitocode.repo.IMatriculaRepo;
import com.mitocode.evalumitocode.service.IMatriculaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MatriculaServiceImpl extends CRUDImpl<Matricula, Integer> implements IMatriculaService {

    private final IMatriculaRepo repo;


    @Override
    protected IGenericRepo<Matricula, Integer> getRepo() {
        return repo;
    }

    @Override
    public Matricula save(Matricula matricula) throws Exception {
        return super.save(matricula);
    }

    @Override
    public Map<String, List<String>> getCoursesWithStudents() {
        return repo.findAll().stream()
                .map(Matricula::getDetails) 
                .flatMap(Collection::stream) 
                .collect(Collectors.groupingBy(d -> d.getCourse().getName(),Collectors.mapping(
                                d -> d.getMatricula().getStudent().getName(), 
                                Collectors.toList()
                        )
                ));
    }

}
