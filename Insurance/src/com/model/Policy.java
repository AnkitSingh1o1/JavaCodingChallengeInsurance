package com.model;

public class Policy {

	private int policyId;
	private String policyName;
	private double policyCost;
	private String isActive;
	
	
	public Policy(int policyId, String policyName, double policyCost, String isActive) {
		super();
		this.policyId = policyId;
		this.policyName = policyName;
		this.policyCost = policyCost;
		this.isActive = isActive;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public Policy() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String toString() {
		return "Policy [policyId=" + policyId + ", policyName=" + policyName + ", policyCost=" + policyCost
				+ ", isActive=" + isActive + "]";
	}
	public int getPolicyId() {
		return policyId;
	}
	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public double getPolicyCost() {
		return policyCost;
	}
	public void setPolicyCost(double policyCost) {
		this.policyCost = policyCost;
	}
	
	
}
