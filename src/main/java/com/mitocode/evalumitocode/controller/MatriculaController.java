package com.mitocode.evalumitocode.controller;

import com.mitocode.evalumitocode.dto.MatriculaDTO;
import com.mitocode.evalumitocode.model.Matricula;
import com.mitocode.evalumitocode.service.IMatriculaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/matriculas")
@RequiredArgsConstructor
public class MatriculaController {

    private final IMatriculaService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<MatriculaDTO>> findAll() throws Exception {
        List<MatriculaDTO> list = service.findAll().stream().map(this::convertoDTO).toList();

         return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatriculaDTO> findById(@PathVariable ("id")Integer id) throws Exception {
        Matricula obj = service.findById(id);

        return ResponseEntity.ok(convertoDTO(obj));
    }

    @PostMapping
    public ResponseEntity<MatriculaDTO> save(@Valid @RequestBody MatriculaDTO dto ) throws Exception {
        Matricula obj = service.save(converToEntity(dto));

        return new ResponseEntity<>(convertoDTO(obj), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MatriculaDTO> update(@Valid @PathVariable("id") Integer id,@RequestBody MatriculaDTO dto) throws Exception {
        Matricula obj = service.save(converToEntity(dto));
        return ResponseEntity.ok(convertoDTO(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/courses&students")
    public ResponseEntity<Map<String, List<String>>> getCoursesWithStudents() {
        return ResponseEntity.ok(service.getCoursesWithStudents());
    }


    private MatriculaDTO convertoDTO(Matricula obj) {
        return modelMapper.map(obj, MatriculaDTO.class);
    }

    private Matricula converToEntity(MatriculaDTO obj) {
        return modelMapper.map(obj, Matricula.class);
    }


}
