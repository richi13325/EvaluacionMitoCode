package com.mitocode.evalumitocode.controller;

import com.mitocode.evalumitocode.dto.StudentDTO;
import com.mitocode.evalumitocode.model.Student;
import com.mitocode.evalumitocode.service.IStudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final IStudentService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<StudentDTO>> findAll() throws Exception {
        List<StudentDTO> list = service.findAll().stream().map(this::convertoDTO).toList();

         return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> findById(@PathVariable ("id")Integer id) throws Exception {
        Student obj = service.findById(id);

        return ResponseEntity.ok(convertoDTO(obj));
    }

    @PostMapping
    public ResponseEntity<StudentDTO> save(@Valid @RequestBody StudentDTO dto ) throws Exception {
        Student obj = service.save(converToEntity(dto));

        return new ResponseEntity<>(convertoDTO(obj), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> update(@Valid  @PathVariable("id") Integer id, @RequestBody StudentDTO dto) throws Exception {
        Student obj = service.save(converToEntity(dto));
        return ResponseEntity.ok(convertoDTO(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/ordered")
    public ResponseEntity<List<StudentDTO>> getStudentsOrderedByAge() throws Exception {
        List<StudentDTO> list = service.getStudentsByAge()
                .stream()
                .map(this::convertoDTO)
                .toList();

        return ResponseEntity.ok(list);
    }

    private StudentDTO convertoDTO(Student obj) {
        return modelMapper.map(obj, StudentDTO.class);
    }

    private Student converToEntity(StudentDTO obj) {
        return modelMapper.map(obj, Student.class);
    }


}
