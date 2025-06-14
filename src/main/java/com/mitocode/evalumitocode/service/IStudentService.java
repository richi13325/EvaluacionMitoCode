package com.mitocode.evalumitocode.service;

import com.mitocode.evalumitocode.model.Student;

import java.util.List;

public interface IStudentService extends ICRUD<Student, Integer> {

    List<Student> getStudentsByAge();


}
