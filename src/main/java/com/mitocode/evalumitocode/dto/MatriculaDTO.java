package com.mitocode.evalumitocode.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mitocode.evalumitocode.model.Student;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MatriculaDTO {


    private Integer idMatricula;

    @NotNull
    private Student student;

    @NotNull
    @JsonManagedReference
    private List<MatriculaDetailsDTO> detailsDTO;

    @NotNull
    private LocalDateTime dateMatricula;

    @NotNull
    private boolean status;

}
