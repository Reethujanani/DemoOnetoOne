package com.example.DemoOnetoOne.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class BookDTO {
    private int bookid;
    private String bookname;
    private String authorname;
    private  int pages;
    private int studentid;
    private String name;
    private String city;
    private int foreignkeybookid;

}

