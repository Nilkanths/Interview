package com.example.Interview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Interview.model.Loan;
import com.example.Interview.model.LoanAggregation;
import com.example.Interview.service.LoanService;

//LoanController.java
@RestController
@RequestMapping("/loans")
public class LoanController {

 @Autowired
 private LoanService loanService;

 @GetMapping("/all")
 public ResponseEntity<List<Loan>> getAllLoans() {
     List<Loan> loans = loanService.getAllLoans();
     return new ResponseEntity<>(loans, HttpStatus.OK);
 }

 @PostMapping("/add")
 public ResponseEntity<String> addLoan(@RequestBody Loan loan) {
     try {
         String result = loanService.addLoan(loan);
         return new ResponseEntity<>(result, HttpStatus.CREATED);
     } catch (IllegalArgumentException e) {
         return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
     }
 }

 @GetMapping("/{loanId}")
 public ResponseEntity<Loan> getLoanById(@PathVariable String loanId) {
     Loan loan = loanService.getLoanById(loanId);
     return new ResponseEntity<>(loan, HttpStatus.OK);
 }

 @GetMapping("/customer/{customerId}")
 public ResponseEntity<List<Loan>> getLoansByCustomerId(@PathVariable String customerId) {
     List<Loan> loans = loanService.getLoansByCustomerId(customerId);
     return new ResponseEntity<>(loans, HttpStatus.OK);
 }

 @GetMapping("/lender/{lenderId}")
 public ResponseEntity<List<Loan>> getLoansByLenderId(@PathVariable String lenderId) {
     List<Loan> loans = loanService.getLoansByLenderId(lenderId);
     return new ResponseEntity<>(loans, HttpStatus.OK);
 }

 @GetMapping("/aggregate/lender")
 public ResponseEntity<LoanAggregation> getAggregateLoansByLender() {
     LoanAggregation aggregation = loanService.getAggregateLoansByLender();
     return new ResponseEntity<>(aggregation, HttpStatus.OK);
 }

 @GetMapping("/aggregate/customer/{customerId}")
 public ResponseEntity<LoanAggregation> getAggregateLoansByCustomer(@PathVariable String customerId) {
     LoanAggregation aggregation = loanService.getAggregateLoansByCustomer(customerId);
     return new ResponseEntity<>(aggregation, HttpStatus.OK);
 }

 @GetMapping("/aggregate/interest/{interest}")
 public ResponseEntity<LoanAggregation> getAggregateLoansByInterest(@PathVariable int interest) {
     LoanAggregation aggregation = loanService.getAggregateLoansByInterest(interest);
     return new ResponseEntity<>(aggregation, HttpStatus.OK);
 }

 // Exception handling can be added here if needed
}

