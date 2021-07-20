package com.nagarro.receiverregistration.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ReceiverInfo {
	String name;
	@Id
	String email;
	Long contact;
	String location;
	String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "ReceiverInfo [name=" + name + ", email=" + email + ", contact=" + contact + ", location=" + location
				+ ", password=" + password + "]";
	}
	
}
