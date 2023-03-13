package com.example.Library_Database_Management_System.Services;

import com.example.Library_Database_Management_System.DTOs.IssueBookRequestDto;
import com.example.Library_Database_Management_System.Enums.CardStatus;
import com.example.Library_Database_Management_System.Enums.TransactionStatus;
import com.example.Library_Database_Management_System.Models.Book;
import com.example.Library_Database_Management_System.Models.Card;
import com.example.Library_Database_Management_System.Models.Transactions;
import com.example.Library_Database_Management_System.Repositories.BookRepository;
import com.example.Library_Database_Management_System.Repositories.CardRepository;
import com.example.Library_Database_Management_System.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CardRepository cardRepository;


    public String issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception{
        int bookId = issueBookRequestDto.getBookId();
        int cardId = issueBookRequestDto.getCardId();

        //Get the book entity and card entity ??? Why do we need this
        //We need this bcz we want to set the Transaction attributes

        Book book = bookRepository.findById(bookId).get();

        Card card = cardRepository.findById(cardId).get();

        Transactions transaction = new Transactions();


        //========================================
        //setting the attributes
        //========================================
        transaction.setBook(book);
        transaction.setCard(card);
        transaction.setIssuedOperation(true);
        transaction.setTransactionStatus(TransactionStatus.PENDING);



        //========================================
        //attribute left is success/failure
        //Check for some validations
        //========================================
        if(book == null || book.isIssued()){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Book is not available");
        }

        if(card==null || card.getCardStatus()!=CardStatus.ACTIVATED){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Car is not valid");
        }

        //We have reached a success case now.
        transaction.setTransactionStatus(TransactionStatus.SUCCESSFUL);

        //set attributes of book
        book.setIssued(true);

        //B/w the book and transaction : bidirectional
        List<Transactions> listOfTransactionForBook = book.getTransactionsList();
        listOfTransactionForBook.add(transaction);
        book.setTransactionsList((listOfTransactionForBook));

        //make changes in the card also
        //Book and the card
        List<Book> issuedBooksForCard = card.getBooksIssued();
        issuedBooksForCard.add(book);
        card.setBooksIssued(issuedBooksForCard);

        //Card and the Transaction : bidirectional (parent class)
        List<Transactions> transactionsListForCard = card.getTransactionsList();
        transactionsListForCard.add(transaction);
        card.setTransactionsList(transactionsListForCard);

        //save the parent
        cardRepository.save(card);
        //automatically by cascading : book and transaction will be saved.
        //Saving the parent

        return "Book issued successfully";

    }

}
