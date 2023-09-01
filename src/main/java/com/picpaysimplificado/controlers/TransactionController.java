package com.picpaysimplificado.controlers;

import com.picpaysimplificado.domain.transaction.Transaction;
import com.picpaysimplificado.dtos.TransactionDTO;
import com.picpaysimplificado.services.TransactionServices;
import org.omg.IOP.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionServices transactionServices;

    @PostMapping
    public ResponseEntity<Transaction> createTransaction (@RequestBody TransactionDTO transaction) throws Exception{
        Transaction newTransaction = this.transactionServices.createTransaction(transaction);
        return new ResponseEntity<>(newTransaction, HttpStatus.OK);
    }
}
