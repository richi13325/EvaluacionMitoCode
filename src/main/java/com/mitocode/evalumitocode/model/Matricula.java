package com.mitocode.evalumitocode.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idMatricula;

    @ManyToOne
    @JoinColumn(name = "idStudent", nullable = false, foreignKey = @ForeignKey(name = "FK_MATRICULA_STUDENT"))
    private Student student;


    @OneToMany(mappedBy = "matricula", cascade = CascadeType.ALL)
    private List<MatriculaDetails> details;

    @Column(nullable = false)
    private LocalDateTime dateMatricula;


    @Column(nullable = false)
    private boolean status;

}
