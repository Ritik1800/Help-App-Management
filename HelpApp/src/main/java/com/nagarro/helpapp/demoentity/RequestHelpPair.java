package com.nagarro.helpapp.demoentity;

public class RequestHelpPair {
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
	public RequestHelpPair(String helperemail, Long helpercontact, String helperlocation, String helpOf,
			String requesteremail, Long requesteremailcontact, String requesteremaillocation) {
		super();
		this.helperemail = helperemail;
		this.helpercontact = helpercontact;
		this.helperlocation = helperlocation;
		this.helpOf = helpOf;
		this.requesteremail = requesteremail;
		this.requesteremailcontact = requesteremailcontact;
		this.requesteremaillocation = requesteremaillocation;
	}
	public RequestHelpPair() {
		super();
		// TODO Auto-generated constructor stub
	}

		
}
