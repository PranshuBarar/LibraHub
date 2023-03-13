package com.example.Library_Database_Management_System.Services;

import com.example.Library_Database_Management_System.DTOs.AuthorEntryDto;
import com.example.Library_Database_Management_System.Models.Author;
import com.example.Library_Database_Management_System.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public String createAuthor(AuthorEntryDto authorEntryDto){

        //Important Step is : in the params : the object is of type Dto but the
        //repository interacts with only with entities

        //===================
        //CONVERTOR
        //===================

        //Solution : Convert authorEntryDto -----> Author
        Author author = new Author();

        //We are setting its attribute so that we cane save
        //correct values in the db.
        author.setName(authorEntryDto.getName());
        author.setAge(authorEntryDto.getAge());
        author.setRating(authorEntryDto.getRating());
        author.setCountry((authorEntryDto.getCountry()));

        authorRepository.save(author);
        return "Author added successfully";
    }
}
