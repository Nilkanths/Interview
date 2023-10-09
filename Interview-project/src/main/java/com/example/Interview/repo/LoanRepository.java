package com.example.Interview.repo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Interview.model.Loan;

//LoanRepository.java
@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

 List<Loan> findByCustomerId(String customerId);

 List<Loan> findByLenderId(String lenderId);

 Optional<Loan> findByLoanId(String loanId);

 List<Loan> findByDueDateBeforeAndRemainingAmountGreaterThan(LocalDate currentDate, double remainingAmount);

 // Additional custom queries if needed
}

