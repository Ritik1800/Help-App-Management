package com.nagarro.HelpInfo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class HelpInfo {
	@Id  @GeneratedValue
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
	
}
