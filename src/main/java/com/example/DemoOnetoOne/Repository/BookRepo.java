package com.example.DemoOnetoOne.Repository;

import com.example.DemoOnetoOne.ModelOrEntity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Book,Integer> {
}

