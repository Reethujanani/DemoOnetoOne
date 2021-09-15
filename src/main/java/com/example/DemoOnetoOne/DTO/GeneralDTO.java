package com.example.DemoOnetoOne.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Setter
@Getter
public class GeneralDTO {
    private int bookid;
    private String bookname;
    private String authorname;
    private  int pages;
    private int studentid;
    private String name;
    private String city;
    private List<AssersoriesDTO> assersoriesDTOList;


}

