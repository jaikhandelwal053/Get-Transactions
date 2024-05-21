package com.transactions.model;

public class TransactionResponseFailureModel {
	
	private String accountNumber;
    private Transaction[] failure;
    
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Transaction[] getFailure() {
		return failure;
	}
	public void setFailure(Transaction[] failure) {
		this.failure = failure;
	}
	public TransactionResponseFailureModel(String accountNumber, Transaction[] failure) {
		super();
		this.accountNumber = accountNumber;
		this.failure = failure;
	}
    

}
