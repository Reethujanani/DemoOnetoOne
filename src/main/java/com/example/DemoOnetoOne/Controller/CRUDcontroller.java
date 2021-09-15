package com.example.DemoOnetoOne.Controller;

import com.example.DemoOnetoOne.BaseResponse.BaseResponse;
import com.example.DemoOnetoOne.DTO.GeneralDTO;
import com.example.DemoOnetoOne.ModelOrEntity.Student;
import com.example.DemoOnetoOne.Repository.BookRepo;
import com.example.DemoOnetoOne.Repository.StudentRepo;
import com.example.DemoOnetoOne.Service.CRUDservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/onetoone")
public class CRUDcontroller {

    @Autowired
   private CRUDservice crudservice;

    @Autowired
    BookRepo bookRepo;

    @Autowired
    StudentRepo studentRepo;



    @PostMapping("/insert")
    public BaseResponse insert(@RequestBody GeneralDTO generalDTO)
    {

        BaseResponse insert = crudservice.insert(generalDTO);
        return insert;
    }
    @GetMapping("/get")
    public Iterable<Student> get()
    {
        List<Student> raina =studentRepo.findAll();
        return raina;
    }

    @GetMapping("/getbyid/{studentid}")
    public Optional getbyid(@PathVariable int studentid)
    {
        return crudservice.getbyid(studentid);
    }

    @DeleteMapping("/deletebyid/{studentid}")
    public BaseResponse deletebyid(@PathVariable int studentid)
    {
        return crudservice.deletebyid(studentid);
    }

    @PutMapping("/put")
    public BaseResponse put(@RequestBody GeneralDTO generalDTO)
    {
        return crudservice.put(generalDTO);
    }

}
