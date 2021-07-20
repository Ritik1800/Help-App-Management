package com.nagarro.helpapp.demoentity;

public class HelpInfo {
	
	int id;
	String email;
	Long contact;
	String helpOf;
	String location;
	
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHelpOf() {
		return helpOf;
	}
	public void setHelpOf(String helpOf) {
		this.helpOf = helpOf;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "HelpInfo [id=" + id + ", email=" + email + ", contact=" + contact + ", helpOf=" + helpOf + ", location="
				+ location + "]";
	}
	public HelpInfo(String email, Long contact, String helpOf, String location) {
		super();
		this.email = email;
		this.contact = contact;
		this.helpOf = helpOf;
		this.location = location;
	}
	public HelpInfo() {
		super();
	}
	
}
