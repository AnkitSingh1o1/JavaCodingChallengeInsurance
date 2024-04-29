package com.model;

public class Client {
	private int clientId;
	private String clientName;
	private long contactInfo;
	private int userId;
	private int policyId;
	
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client(int clientId, String clientName, long contactInfo, int userId, int policyId) {
		super();
		this.clientId = clientId;
		this.clientName = clientName;
		this.contactInfo = contactInfo;
		this.userId = userId;
		this.policyId = policyId;
	}
	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", clientName=" + clientName + ", contactInfo=" + contactInfo
				+ ", userId=" + userId + ", policyId=" + policyId + "]";
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public long getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(long contactInfo) {
		this.contactInfo = contactInfo;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getPolicyId() {
		return policyId;
	}
	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}
	
	
	
}
