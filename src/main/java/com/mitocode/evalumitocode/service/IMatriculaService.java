package com.mitocode.evalumitocode.service;

import com.mitocode.evalumitocode.model.Matricula;

import java.util.List;
import java.util.Map;

public interface IMatriculaService extends ICRUD<Matricula, Integer> {

    Map<String, List<String>> getCoursesWithStudents();

}
