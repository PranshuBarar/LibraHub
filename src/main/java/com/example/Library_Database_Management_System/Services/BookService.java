package com.example.Library_Database_Management_System.Services;

import com.example.Library_Database_Management_System.DTOs.BookRequestDto;
import com.example.Library_Database_Management_System.Models.Author;
import com.example.Library_Database_Management_System.Models.Book;
import com.example.Library_Database_Management_System.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    AuthorRepository authorRepository;
    //


    public String addBook(BookRequestDto bookRequestDto){
        //I want to get the AuthorEntity ??? How will I be able to do it ???
        int authorId = bookRequestDto.getAuthorId();

        //Now I will be fetching the authorEntity
        Author author = authorRepository.findById(authorId).get();
        //Do Exception Handling here

        //Basic attributes are already set from postman

        //Setting the foreign key attr in the child class :

        //We have created this entity so that we can save in the db
        //====================
        //CONVERTOR
        //====================
        Book book = new Book();

        //Basic attributes are being set from Dto to the Entity layer
        book.setGenre(bookRequestDto.getGenre());
        book.setIssued(false);
        book.setAuthor(author);
        book.setPages(bookRequestDto.getPages());

        //We need to update the listOfBooks written in the parent class


        List<Book> currentBooksWritten = author.getBooksWritten();
        currentBooksWritten.add(book);


        //Now the book is to be saved, but also author is alsoooo to be saved.
        //Why do we need to again save (updating) the author ?? bcz
        //because the author Entity has been updated...we need to resave/update it.

        authorRepository.save(author); //Date was modified
        //.save works both as 'save' also and 'update' also

        //bookRepo.save is not required : bcz it will be autocalled by cascading effect

        return "Book added successfully";
    }
}
