package com.example.Library_Database_Management_System.Controllers;

import com.example.Library_Database_Management_System.DTOs.AuthorEntryDto;
import com.example.Library_Database_Management_System.Services.ServicesImpl.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorServiceImpl authorServiceImpl;

    @PostMapping("/add")
    public String addAuthor(@RequestBody AuthorEntryDto authorEntryDto){
        return authorServiceImpl.createAuthor(authorEntryDto);
    }
}
