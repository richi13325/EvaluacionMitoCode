package com.mitocode.evalumitocode.controller;

import com.mitocode.evalumitocode.dto.CourseDTO;
import com.mitocode.evalumitocode.model.Course;
import com.mitocode.evalumitocode.service.ICourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

    private final ICourseService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<CourseDTO>> findAll() throws Exception {
        List<CourseDTO> list = service.findAll().stream().map(this::convertoDTO).toList();

         return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> findById(@PathVariable ("id")Integer id) throws Exception {
        Course obj = service.findById(id);

        return ResponseEntity.ok(convertoDTO(obj));
    }

    @PostMapping
    public ResponseEntity<CourseDTO> save(@Valid @RequestBody CourseDTO dto ) throws Exception {
        Course obj = service.save(converToEntity(dto));

        return new ResponseEntity<>(convertoDTO(obj), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDTO> update(@Valid  @PathVariable("id") Integer id, @RequestBody CourseDTO dto) throws Exception {
        Course obj = service.save(converToEntity(dto));
        return ResponseEntity.ok(convertoDTO(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private CourseDTO convertoDTO(Course obj) {
        return modelMapper.map(obj, CourseDTO.class);
    }

    private Course converToEntity(CourseDTO obj) {
        return modelMapper.map(obj, Course.class);
    }


}
