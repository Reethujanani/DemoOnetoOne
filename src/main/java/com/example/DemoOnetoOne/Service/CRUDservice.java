package com.example.DemoOnetoOne.Service;

import com.example.DemoOnetoOne.BaseResponse.BaseResponse;
import com.example.DemoOnetoOne.DTO.BookDTO;
import com.example.DemoOnetoOne.DTO.GeneralDTO;
import com.example.DemoOnetoOne.DTO.StudentDTO;
import com.example.DemoOnetoOne.ModelOrEntity.Accessories;
import com.example.DemoOnetoOne.ModelOrEntity.Book;
import com.example.DemoOnetoOne.ModelOrEntity.Student;
import com.example.DemoOnetoOne.Repository.AsseroriesRepository;
import com.example.DemoOnetoOne.Repository.BookRepo;
import com.example.DemoOnetoOne.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service

public class CRUDservice {

    @Autowired
    BookRepo bookRepo;

    @Autowired
    StudentRepo studentRepo;

    @Autowired
    private AsseroriesRepository asseroriesRepository;

    @Transactional
    public  BaseResponse insert(@RequestBody GeneralDTO generalDTO)
    {
        try {
            BaseResponse baseResponse = new BaseResponse();
            Book book = new Book();
            Student student = new Student();
            book.setBookname(generalDTO.getBookname());
            book.setAuthorname(generalDTO.getAuthorname());
            book.setPages(generalDTO.getPages());
            bookRepo.save(book);
            student.setName(generalDTO.getName());
            student.setCity(generalDTO.getCity());
            student.setBook(book);
            studentRepo.save(student);
            List<Accessories> accessoriesList = new LinkedList<>();
            generalDTO.getAssersoriesDTOList().stream().forEachOrdered(action->{
                Accessories accessories = new Accessories();
                accessories.setName(action.getName());
                accessories.setStudent(student);
                accessoriesList.add(accessories);
            });
            asseroriesRepository.saveAll(accessoriesList);
            baseResponse.setStatuscode("200");
            baseResponse.setStatusmessage("Succesfully inserted the data in both Book Table and Student Table");
            baseResponse.setData(student);
            // baseResponse.setData(book);
            return baseResponse;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public Optional getbyid(int studentid) {
        BaseResponse baseResponse= new BaseResponse();
        Optional<Student> sabari = studentRepo.findById(studentid);
        return sabari;
    }

    public BaseResponse deletebyid(int studentid) {
        BaseResponse baseResponse= new BaseResponse();
        studentRepo.deleteById(studentid);

        baseResponse.setStatuscode("200");
        baseResponse.setStatusmessage("succesfully is deleted");
        return baseResponse;
    }


    public BaseResponse put(GeneralDTO generalDTO) {

        BaseResponse baseResponse = new BaseResponse();
        Book book= new Book();
        Student student = new Student();

        Optional<Student> raina = studentRepo.findById(generalDTO.getStudentid());
        if(raina.isPresent()) {
            // studentRepo.getById(generalDTO.getStudentid());

            raina.get().setName(generalDTO.getName());
            raina.get().setCity(generalDTO.getCity());
            student = studentRepo.save(student);

            book.setBookname(generalDTO.getBookname());
            book.setAuthorname(generalDTO.getAuthorname());
            book.setPages(generalDTO.getPages());
            book = bookRepo.save(book);

            baseResponse.setStatuscode("200");
            baseResponse.setStatusmessage("Updating  the data in both Book Table and Student Table using put operation");
            baseResponse.setData(student);
            // baseResponse.setData(book);
        }
        else {
            baseResponse.setStatuscode("100");
            baseResponse.setStatusmessage("DATA Not found");
        }

        return baseResponse;

    }
}

