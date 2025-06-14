package com.mitocode.evalumitocode.service.Impl;

import com.mitocode.evalumitocode.model.Course;
import com.mitocode.evalumitocode.repo.IGenericRepo;
import com.mitocode.evalumitocode.repo.ICourseRepo;
import com.mitocode.evalumitocode.service.ICourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl extends CRUDImpl<Course, Integer> implements ICourseService {

    private final ICourseRepo repo;


    @Override
    protected IGenericRepo<Course, Integer> getRepo() {
        return repo;
    }


}
