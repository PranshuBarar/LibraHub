package com.example.Library_Database_Management_System.Controllers;

import com.example.Library_Database_Management_System.DTOs.BookRequestDto;
import com.example.Library_Database_Management_System.Services.ServicesImpl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookServiceImpl bookServiceImpl;

    @PostMapping("/add")
    public String addBook(@RequestBody BookRequestDto bookRequestDto){
        return bookServiceImpl.addBook(bookRequestDto);
    }
}
