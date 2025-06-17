package com.mitocode.evalumitocode.service.Impl;

import com.mitocode.evalumitocode.model.Student;
import com.mitocode.evalumitocode.repo.IGenericRepo;
import com.mitocode.evalumitocode.repo.IStudentRepo;
import com.mitocode.evalumitocode.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl extends CRUDImpl<Student, Integer> implements IStudentService {

    private final IStudentRepo repo;


    @Override
    protected IGenericRepo<Student, Integer> getRepo() {
        return repo;
    }

    @Override
    public Student save(Student student) throws Exception {
        return super.save(student);
    }

    @Override
    public List<Student> getStudentsByAge() {
        return repo.findAll()
                .stream()
                .sorted(Comparator.comparing(Student::getAge).reversed())
                .toList();
    }
}
