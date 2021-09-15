package com.example.DemoOnetoOne.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class StudentDTO {
    private int studentid;
    private String name;
    private String city;
    private int foreignkeybookid;

}

