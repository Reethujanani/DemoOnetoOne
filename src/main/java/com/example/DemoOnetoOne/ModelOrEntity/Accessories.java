package com.example.DemoOnetoOne.ModelOrEntity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity


@Data
@Table(name = "accessories")
public class Accessories implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;



}
