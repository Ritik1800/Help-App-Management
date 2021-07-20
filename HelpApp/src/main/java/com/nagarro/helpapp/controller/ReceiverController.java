package com.nagarro.helpapp.controller;

import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagarro.helpapp.demoentity.HelpInfo;
import com.nagarro.helpapp.demoentity.RequestHelpPair;
import com.nagarro.helpapp.demoentity.RequestInfo;

@Controller
public class ReceiverController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("ReceiverDefaultPage")
	public String receiverDefaultPage(HttpSession session)
	{
		if(session.getAttribute("user")==null)
		{
			return "Login";
		}
		return "ReceiverView";
	}
	@RequestMapping("AddRequest")
	public String giveRequestPage(HttpSession session)
	{
		if(session.getAttribute("user")==null)
		{
			return "Login";
		}
		return "AddRequest";
	}
	
	@RequestMapping("addRequest")
	public String addRequest(HttpSession session) throws JsonMappingException, JsonProcessingException
	{
		if(session.getAttribute("user")==null)
		{
			return "Login";
		}
		HttpEntity<String> entity = restTemplate.getForEntity("http://GATEWAY-SERVICE/request/RequestInfo", String.class);
		String body=entity.getBody();
		RequestInfo[] temp=new ObjectMapper().readValue(body, RequestInfo[].class);
		ArrayList<RequestInfo> reqs = new ArrayList<RequestInfo>();
		for(RequestInfo i:temp)
		{
			if(i.getEmail().equalsIgnoreCase((String)session.getAttribute("user")))
			{
				reqs.add(i);
			}
		}
		session.setAttribute("reqs", reqs);
		
		entity = restTemplate.getForEntity("http://GATEWAY-SERVICE/request-help/pair", String.class);
		body=entity.getBody();
		RequestHelpPair[] temp2=new ObjectMapper().readValue(body, RequestHelpPair[].class);
		ArrayList<RequestHelpPair> reqs1 = new ArrayList<RequestHelpPair>();
		for(RequestHelpPair i:temp2)
		{
			if(i.getRequesteremail().equalsIgnoreCase((String)session.getAttribute("user")))
			{
				System.out.println(i.getRequesteremail()+" hello");
				reqs1.add(i);
			}
		}
		session.setAttribute("reqs1", reqs1);
		
		return "ReceiverView";
	}
	
	@RequestMapping("addUserRequest")
	public String addUserRequest(HttpSession session,@RequestParam String requestof) throws JsonMappingException, JsonProcessingException
	{
		RequestInfo info=new RequestInfo(requestof,(String)session.getAttribute("user"),(Long)session.getAttribute("receivercontact"),(String)session.getAttribute("receiverlocation"));
		
		HttpEntity<String> entity = restTemplate.getForEntity("http://GATEWAY-SERVICE/help/HelpInfo", String.class);
		String body=entity.getBody();
		HelpInfo[] helps=new ObjectMapper().readValue(body, HelpInfo[].class);
		
		for(HelpInfo help: helps)
		{
			if(help.getHelpOf().equalsIgnoreCase(info.getRequestof()))
			{
				RequestHelpPair rh = new RequestHelpPair(help.getEmail(),help.getContact(),help.getLocation(),help.getHelpOf(),info.getEmail(),info.getContact(),info.getLocation());
				HttpHeaders headers = new HttpHeaders();
			    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			    HttpEntity<RequestHelpPair> entity1 = new HttpEntity<RequestHelpPair>(rh,headers);
			    restTemplate.exchange("http://GATEWAY-SERVICE/request-help/pair", HttpMethod.POST, entity1, String.class).getBody();
			    restTemplate.delete("http://GATEWAY-SERVICE/help/HelpInfo/{id}",help.getId());
			    
				return "redirect:/addRequest";
			}
		}
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity<RequestInfo> entity1 = new HttpEntity<RequestInfo>(info,headers);
	    restTemplate.exchange("http://GATEWAY-SERVICE/request/RequestInfo", HttpMethod.POST, entity1, String.class).getBody();
	    
	    return "redirect:/addRequest";
	} 
	
}
