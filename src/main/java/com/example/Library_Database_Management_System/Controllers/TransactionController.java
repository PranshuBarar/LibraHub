package com.example.Library_Database_Management_System.Controllers;

import com.example.Library_Database_Management_System.DTOs.IssueBookRequestDto;
import com.example.Library_Database_Management_System.Services.ServicesImpl.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    TransactionServiceImpl transactionServiceImpl;

    @PostMapping("issuebook")
    public String issueBook(@RequestBody IssueBookRequestDto issueBookRequestDto) throws Exception {
        try{
            return transactionServiceImpl.issueBook(issueBookRequestDto);
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }
}
