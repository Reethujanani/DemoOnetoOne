package com.example.DemoOnetoOne.ModelOrEntity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Entity
@Data
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int studentid;

    @Column(name = "name")
    private String name;

    @Column(name = "city")
    private String city;

    @OneToOne
    @JoinColumn(name = "bookid")
    private Book book;

    @OneToMany(mappedBy = "student")
    private List<Accessories> accessoriesList;


}
