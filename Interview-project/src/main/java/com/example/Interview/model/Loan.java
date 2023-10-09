package com.example.Interview.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//Loan.java
@Entity
public class Loan {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 private String loanId;
 private String customerId;
 private String lenderId;
 private double amount;
 private double remainingAmount;
 private LocalDate paymentDate;
 private int interestPerDay;
 private LocalDate dueDate;
 private double penaltyPerDay;
 private boolean cancel;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getLoanId() {
	return loanId;
}
public void setLoanId(String loanId) {
	this.loanId = loanId;
}
public String getCustomerId() {
	return customerId;
}
public void setCustomerId(String customerId) {
	this.customerId = customerId;
}
public String getLenderId() {
	return lenderId;
}
public void setLenderId(String lenderId) {
	this.lenderId = lenderId;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public double getRemainingAmount() {
	return remainingAmount;
}
public void setRemainingAmount(double remainingAmount) {
	this.remainingAmount = remainingAmount;
}
public LocalDate getPaymentDate() {
	return paymentDate;
}
public void setPaymentDate(LocalDate paymentDate) {
	this.paymentDate = paymentDate;
}
public int getInterestPerDay() {
	return interestPerDay;
}
public void setInterestPerDay(int interestPerDay) {
	this.interestPerDay = interestPerDay;
}
public LocalDate getDueDate() {
	return dueDate;
}
public void setDueDate(LocalDate dueDate) {
	this.dueDate = dueDate;
}
public double getPenaltyPerDay() {
	return penaltyPerDay;
}
public void setPenaltyPerDay(double penaltyPerDay) {
	this.penaltyPerDay = penaltyPerDay;
}
public boolean isCancel() {
	return cancel;
}
public void setCancel(boolean cancel) {
	this.cancel = cancel;
}
public Loan(Long id, String loanId, String customerId, String lenderId, double amount, double remainingAmount,
		LocalDate paymentDate, int interestPerDay, LocalDate dueDate, double penaltyPerDay, boolean cancel) {
	super();
	this.id = id;
	this.loanId = loanId;
	this.customerId = customerId;
	this.lenderId = lenderId;
	this.amount = amount;
	this.remainingAmount = remainingAmount;
	this.paymentDate = paymentDate;
	this.interestPerDay = interestPerDay;
	this.dueDate = dueDate;
	this.penaltyPerDay = penaltyPerDay;
	this.cancel = cancel;
}
public Loan() {
	
}
 
 

 // Constructors, getters, and setters
}
