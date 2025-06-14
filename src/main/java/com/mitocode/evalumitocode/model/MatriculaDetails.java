package com.mitocode.evalumitocode.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class MatriculaDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idMatriculaDetails;

    @ManyToOne
    @JoinColumn(name = "id_course",nullable = false, foreignKey = @ForeignKey (name = "FK_DETALLEMATRICULA_COURSE"))
    private Course course;

    @ManyToOne
    @JoinColumn(name = "id_matricula", nullable = false, foreignKey = @ForeignKey(name = "FK_DETAIL_SALE"))
    private Matricula matricula;


    @Column(length = 50, nullable = false)
    private String aula;
}
