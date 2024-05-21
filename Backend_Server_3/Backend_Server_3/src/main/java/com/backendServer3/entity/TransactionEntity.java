package com.backendServer3.entity;


public class TransactionEntity {
	
    private String transactionid;
    private String status;
    private String amount;
    private String date;
    
	public TransactionEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TransactionEntity(String transactionid, String status, String amount, String date) {
		super();
		this.transactionid = transactionid;
		this.status = status;
		this.amount = amount;
		this.date = date;
	}
	public String getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
    
	    
}
