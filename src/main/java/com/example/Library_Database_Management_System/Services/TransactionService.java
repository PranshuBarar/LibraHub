package com.example.Library_Database_Management_System.Services;

import com.example.Library_Database_Management_System.DTOs.IssueBookRequestDto;

public interface TransactionService {
    public String issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception;
}
