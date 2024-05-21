package com.backendServer2.entity;

public class TransactionResponseEntity {
	private String accountNumber;
    private TransactionEntity[] failure;
    
	public TransactionResponseEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TransactionResponseEntity(String accountNumber, TransactionEntity[] failure) {
		super();
		this.accountNumber = accountNumber;
		this.failure = failure;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public TransactionEntity[] getFailure() {
		return failure;
	}
	public void setFailure(TransactionEntity[] failure) {
		this.failure = failure;
	}
    
}

