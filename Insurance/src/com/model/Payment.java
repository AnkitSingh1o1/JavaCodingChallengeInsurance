package com.model;

public class Payment {

	private int paymentId;
	private String paymenyDate;
	private double paymentAmount;
	private int clientId;
	
	
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Payment(int paymentId, String paymenyDate, double paymentAmount, int clientId) {
		super();
		this.paymentId = paymentId;
		this.paymenyDate = paymenyDate;
		this.paymentAmount = paymentAmount;
		this.clientId = clientId;
	}
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", paymenyDate=" + paymenyDate + ", paymentAmount=" + paymentAmount
				+ ", clientId=" + clientId + "]";
	}
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public String getPaymenyDate() {
		return paymenyDate;
	}
	public void setPaymenyDate(String paymenyDate) {
		this.paymenyDate = paymenyDate;
	}
	public double getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	
	
}
