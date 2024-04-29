package com.model;

public class Claim {

	private int claimId;
	private int claimNumber;
	private String claimDate;
	private double claimAmount;
	private String claimStatus;
	
	private int clientId;
	private int policyId;
	
	
	public Claim() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Claim(int claimId, int claimNumber, String claimDate, double claimAmount, String claimStatus, int clientId,
			int policyId) {
		super();
		this.claimId = claimId;
		this.claimNumber = claimNumber;
		this.claimDate = claimDate;
		this.claimAmount = claimAmount;
		this.claimStatus = claimStatus;
		this.clientId = clientId;
		this.policyId = policyId;
	}
	@Override
	public String toString() {
		return "Claim [claimId=" + claimId + ", claimNumber=" + claimNumber + ", claimDate=" + claimDate
				+ ", claimAmount=" + claimAmount + ", claimStatus=" + claimStatus + ", clientId=" + clientId
				+ ", policyId=" + policyId + "]";
	}
	public int getClaimId() {
		return claimId;
	}
	public void setClaimId(int claimId) {
		this.claimId = claimId;
	}
	public int getClaimNumber() {
		return claimNumber;
	}
	public void setClaimNumber(int claimNumber) {
		this.claimNumber = claimNumber;
	}
	public String getClaimDate() {
		return claimDate;
	}
	public void setClaimDate(String claimDate) {
		this.claimDate = claimDate;
	}
	public double getClaimAmount() {
		return claimAmount;
	}
	public void setClaimAmount(double claimAmount) {
		this.claimAmount = claimAmount;
	}
	public String getClaimStatus() {
		return claimStatus;
	}
	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public int getPolicyId() {
		return policyId;
	}
	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}
	
	
}
