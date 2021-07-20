package com.nagarro.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class RequestHelpPair {

	@Id @GeneratedValue
	int id;
	
	String helperemail;
	Long helpercontact;
	String helperlocation;
	
	String helpOf;
	
	String requesteremail;
	Long requesteremailcontact;
	String requesteremaillocation;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHelperemail() {
		return helperemail;
	}
	public void setHelperemail(String helperemail) {
		this.helperemail = helperemail;
	}
	public Long getHelpercontact() {
		return helpercontact;
	}
	public void setHelpercontact(Long helpercontact) {
		this.helpercontact = helpercontact;
	}
	public String getHelperlocation() {
		return helperlocation;
	}
	public void setHelperlocation(String helperlocation) {
		this.helperlocation = helperlocation;
	}
	public String getHelpOf() {
		return helpOf;
	}
	public void setHelpOf(String helpOf) {
		this.helpOf = helpOf;
	}
	public String getRequesteremail() {
		return requesteremail;
	}
	public void setRequesteremail(String requesteremail) {
		this.requesteremail = requesteremail;
	}
	public Long getRequesteremailcontact() {
		return requesteremailcontact;
	}
	public void setRequesteremailcontact(Long requesteremailcontact) {
		this.requesteremailcontact = requesteremailcontact;
	}
	public String getRequesteremaillocation() {
		return requesteremaillocation;
	}
	public void setRequesteremaillocation(String requesteremaillocation) {
		this.requesteremaillocation = requesteremaillocation;
	}
	@Override
	public String toString() {
		return "RequestHelpPair [id=" + id + ", helperemail=" + helperemail + ", helpercontact=" + helpercontact
				+ ", helperlocation=" + helperlocation + ", helpOf=" + helpOf + ", requesteremail=" + requesteremail
				+ ", requesteremailcontact=" + requesteremailcontact + ", requesteremaillocation="
				+ requesteremaillocation + "]";
	}
	
	
	
	
}
