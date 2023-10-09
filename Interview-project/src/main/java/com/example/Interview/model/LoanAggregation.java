package com.example.Interview.model;

//LoanAggregation.java
public class LoanAggregation {

 private double totalRemainingAmount;
 private double totalInterest;
 private double totalPenalty;
public double getTotalRemainingAmount() {
	return totalRemainingAmount;
}
public void setTotalRemainingAmount(double totalRemainingAmount) {
	this.totalRemainingAmount = totalRemainingAmount;
}
public double getTotalInterest() {
	return totalInterest;
}
public void setTotalInterest(double totalInterest) {
	this.totalInterest = totalInterest;
}
public double getTotalPenalty() {
	return totalPenalty;
}
public void setTotalPenalty(double totalPenalty) {
	this.totalPenalty = totalPenalty;
}
public LoanAggregation(double totalRemainingAmount, double totalInterest, double totalPenalty) {
	super();
	this.totalRemainingAmount = totalRemainingAmount;
	this.totalInterest = totalInterest;
	this.totalPenalty = totalPenalty;
}
public LoanAggregation() {
	//super();
	// TODO Auto-generated constructor stub
}
 
 

 // Constructors, getters, and setters
}

