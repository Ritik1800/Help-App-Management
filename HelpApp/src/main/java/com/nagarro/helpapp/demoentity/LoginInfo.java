package com.nagarro.helpapp.demoentity;

public class LoginInfo {
	String email;
	String password;
	String type;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "LoginInfo [email=" + email + ", password=" + password + ", type=" + type + "]";
	}
	
	
}
