package com.example.Interview.project;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.Interview.model.Loan;
import com.example.Interview.repo.LoanRepository;
import com.example.Interview.service.LoanService;


@RunWith(MockitoJUnitRunner.class)
public class LoanServiceTest {

    @Mock
    private LoanRepository loanRepository;

    @InjectMocks
    private LoanService loanService;

    @Test
    public void testGetAllLoans() {
        // Arrange
        when(loanRepository.findAll()).thenReturn(Arrays.asList(
                new Loan(/* loan details */),
                new Loan(/* loan details */)
        ));

        // Act
        List<Loan> loans = loanService.getAllLoans();

        // Assert
        assertEquals(2, loans.size());
    }

    @Test
    public void testAddLoan_ValidLoan() {
        // Arrange
        Loan loan = new Loan(/* valid loan details */);

        // Act
        String result = loanService.addLoan(loan);

        // Assert
        assertEquals("Loan added successfully.", result);
        verify(loanRepository, times(1)).save(loan);
    }

    @Test
    public void testAddLoan_InvalidPaymentDate() {
        // Arrange
        Loan loan = new Loan(/* invalid loan details with payment date > due date */);

        // Act/Assert
        assertThrows(IllegalArgumentException.class, () -> loanService.addLoan(loan));
        verify(loanRepository, never()).save(loan);
    }

    // Add more tests for other service methods
}

