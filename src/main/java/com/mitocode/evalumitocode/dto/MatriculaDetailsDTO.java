package com.mitocode.evalumitocode.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MatriculaDetailsDTO {


    @JsonBackReference
    private MatriculaDTO matricula;

    @NotNull
    private CourseDTO Course;

    @NotNull
    @Pattern(
            regexp = "^[A-Z][1-9]|1[0-9]|20$",
            message = "El aula debe ser una letra mayúscula (A-Z) seguida de un número entre 1 y 20 (ej: A5, B20)"
    )
    private String aula;
}