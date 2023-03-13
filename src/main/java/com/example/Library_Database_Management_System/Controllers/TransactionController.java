package com.example.Library_Database_Management_System.Controllers;

import com.example.Library_Database_Management_System.DTOs.IssueBookRequestDto;
import com.example.Library_Database_Management_System.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("issuebook")
    public String issueBook(@RequestBody IssueBookRequestDto issueBookRequestDto) throws Exception {
        try{
            return transactionService.issueBook(issueBookRequestDto);
        }
        catch (Exception e) {
            return e.getMessage();
        }
    }
}
