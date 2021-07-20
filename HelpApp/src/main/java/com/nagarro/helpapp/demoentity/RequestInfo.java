package com.nagarro.helpapp.demoentity;

public class RequestInfo {
	
	int id;
	
	String requestof;
	String email;
	Long contact;
	String location;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRequestof() {
		return requestof;
	}
	public void setRequestof(String requestof) {
		this.requestof = requestof;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getContact() {
		return contact;
	}
	public void setContact(Long contact) {
		this.contact = contact;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "RequestInfo [id=" + id + ", requestof=" + requestof + ", email=" + email + ", contact=" + contact
				+ ", location=" + location + "]";
	}
	public RequestInfo(String requestof, String email, Long contact, String location) {
		super();
		this.requestof = requestof;
		this.email = email;
		this.contact = contact;
		this.location = location;
	}
	public RequestInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
