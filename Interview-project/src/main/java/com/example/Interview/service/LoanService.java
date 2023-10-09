package com.example.Interview.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Interview.model.Loan;
import com.example.Interview.model.LoanAggregation;
import com.example.Interview.repo.LoanRepository;

//LoanService.java
@Service
public class LoanService {

 @Autowired
 private LoanRepository loanRepository;

 public List<Loan> getAllLoans() {
     return loanRepository.findAll();
 }

 public String addLoan(Loan loan) {
     // Validation logic
     if (loan.getPaymentDate().isAfter(loan.getDueDate())) {
         throw new IllegalArgumentException("Payment date cannot be greater than the due date.");
     }

     // Save the loan
     loanRepository.save(loan);
     return "Loan added successfully.";
 }

 public Loan getLoanById(String loanId) {
     return loanRepository.findByLoanId(loanId)
             .orElseThrow(() -> new NoSuchElementException("Loan not found with ID: " + loanId));
 }

 public List<Loan> getLoansByCustomerId(String customerId) {
     return loanRepository.findByCustomerId(customerId);
 }

 public List<Loan> getLoansByLenderId(String lenderId) {
     return loanRepository.findByLenderId(lenderId);
 }

 public LoanAggregation getAggregateLoansByLender() {
     List<Loan> loans = loanRepository.findAll();

     double totalRemainingAmount = loans.stream()
             .collect(Collectors.summingDouble(Loan::getRemainingAmount));

     double totalInterest = loans.stream()
             .collect(Collectors.summingDouble(loan -> calculateInterest(loan)));

     double totalPenalty = loans.stream()
             .collect(Collectors.summingDouble(loan -> calculatePenalty(loan)));

     return new LoanAggregation(totalRemainingAmount, totalInterest, totalPenalty);
 }

 public LoanAggregation getAggregateLoansByCustomer(String customerId) {
     List<Loan> loans = loanRepository.findByCustomerId(customerId);

     double totalRemainingAmount = loans.stream()
             .collect(Collectors.summingDouble(Loan::getRemainingAmount));

     double totalInterest = loans.stream()
             .collect(Collectors.summingDouble(loan -> calculateInterest(loan)));

     double totalPenalty = loans.stream()
             .collect(Collectors.summingDouble(loan -> calculatePenalty(loan)));

     return new LoanAggregation(totalRemainingAmount, totalInterest, totalPenalty);
 }

 public LoanAggregation getAggregateLoansByInterest(int interest) {
     List<Loan> loans = loanRepository.findAll();

     double totalRemainingAmount = loans.stream()
             .filter(loan -> loan.getInterestPerDay() == interest)
             .collect(Collectors.summingDouble(Loan::getRemainingAmount));

     double totalInterest = loans.stream()
             .filter(loan -> loan.getInterestPerDay() == interest)
             .collect(Collectors.summingDouble(loan -> calculateInterest(loan)));

     double totalPenalty = loans.stream()
             .filter(loan -> loan.getInterestPerDay() == interest)
             .collect(Collectors.summingDouble(loan -> calculatePenalty(loan)));

     return new LoanAggregation(totalRemainingAmount, totalInterest, totalPenalty);
 }

 // Utility method to calculate interest for a loan
 private double calculateInterest(Loan loan) {
     // Implement your interest calculation logic here
     // For example, simple interest: (amount * interest rate * days) / 100
     // This is just a placeholder, replace it with your actual logic
     return (loan.getAmount() * loan.getInterestPerDay() * 30) / 100;
 }

 // Utility method to calculate penalty for a loan
 private double calculatePenalty(Loan loan) {
     // Implement your penalty calculation logic here
     // This is just a placeholder, replace it with your actual logic
     return (loan.getPenaltyPerDay() * loan.getRemainingAmount()) / 100;
 }
}
