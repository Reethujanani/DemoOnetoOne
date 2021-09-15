package com.example.DemoOnetoOne.ModelOrEntity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.transaction.Transactional;

@Entity


@Data
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookid")
    private int bookid;

    @Column(name = "bookname")
    private String bookname;

    @Column(name = "authorname")
    private String authorname;

    @Column(name = "pages")
    private int pages;


}
