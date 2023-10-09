package com.example.Interview.project;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.Interview.controller.LoanController;
import com.example.Interview.model.Loan;
import com.example.Interview.service.LoanService;

@RunWith(SpringRunner.class)
@WebMvcTest(LoanController.class)
public class LoanControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LoanService loanService;

    @Test
    public void testGetAllLoans() throws Exception {
        // Arrange
        when(loanService.getAllLoans()).thenReturn(Arrays.asList(
                new Loan(/* loan details */),
                new Loan(/* loan details */)
        ));

        // Act/Assert
        mockMvc.perform(get("/loans/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    public void testAddLoan_ValidLoan() throws Exception {
        // Arrange
        Loan loan = new Loan(/* valid loan details */);
        when(loanService.addLoan(loan)).thenReturn("Loan added successfully.");

        // Act/Assert
        mockMvc.perform(post("/loans/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(loan)))
                .andExpect(status().isCreated())
                .andExpect(content().string("Loan added successfully."));
    }

    private byte[] asJsonString(Loan loan) {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
    public void testAddLoan_InvalidPaymentDate() throws Exception {
        // Arrange
        Loan loan = new Loan(/* invalid loan details with payment date > due date */);
        when(loanService.addLoan(loan)).thenThrow(new IllegalArgumentException("Invalid payment date."));

        // Act/Assert
        mockMvc.perform(post("/loans/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(loan)))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Invalid payment date."));
    }

    // Add more tests for other controller endpoints
}

