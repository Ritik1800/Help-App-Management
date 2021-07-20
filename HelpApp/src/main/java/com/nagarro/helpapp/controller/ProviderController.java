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
public class ProviderController {

	@Autowired
	private RestTemplate restTemplate;
	
	
	@RequestMapping("allHelp")
	public String getAllHelp(HttpSession session) throws JsonMappingException, JsonProcessingException
	{
		if(session.getAttribute("user")==null)
		{
			return "Login";
		}
		HttpEntity<String> entity = restTemplate.getForEntity("http://GATEWAY-SERVICE/help/HelpInfo", String.class);
		String body=entity.getBody();
		HelpInfo[] temp=new ObjectMapper().readValue(body, HelpInfo[].class);
		ArrayList<HelpInfo> reqs = new ArrayList<HelpInfo>();
		for(HelpInfo i:temp)
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
			if(i.getHelperemail().equalsIgnoreCase((String)session.getAttribute("user")))
			{
				reqs1.add(i);
			}
		}
		session.setAttribute("reqs1", reqs1);
		
		return "ProviderView";
	}
	
	@RequestMapping("AddHelp")
	public String giveAddHelpPage(HttpSession session)
	{
		if(session.getAttribute("user")==null)
		{
			return "Login";
		}
		return "AddHelp";
	}
	@RequestMapping("addHelpRequest")
	public String addHelp(HttpSession session,@RequestParam String helpOf,@RequestParam String location) throws JsonMappingException, JsonProcessingException
	{
		HelpInfo info=new HelpInfo((String)session.getAttribute("user"),(Long)session.getAttribute("providercontact"),helpOf,location);
		HttpEntity<String> entity = restTemplate.getForEntity("http://GATEWAY-SERVICE/request/RequestInfo", String.class);
		String body=entity.getBody();
		RequestInfo[] requests=new ObjectMapper().readValue(body, RequestInfo[].class);
		for(RequestInfo request: requests)
		{
			if(request.getRequestof().equalsIgnoreCase(helpOf))
			{
				RequestHelpPair rh = new RequestHelpPair(info.getEmail(),info.getContact(),info.getLocation(),info.getHelpOf(),request.getEmail(),request.getContact(),request.getLocation());
				HttpHeaders headers = new HttpHeaders();
			    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			    HttpEntity<RequestHelpPair> entity1 = new HttpEntity<RequestHelpPair>(rh,headers);
			    restTemplate.exchange("http://GATEWAY-SERVICE/request-help/pair", HttpMethod.POST, entity1, String.class).getBody();
			    restTemplate.delete("http://GATEWAY-SERVICE/request/RequestInfo/{id}",request.getId());
			    
			    return "redirect:/allHelp";
			}
		}
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity<HelpInfo> entity1 = new HttpEntity<HelpInfo>(info,headers);
	    
	    restTemplate.exchange("http://GATEWAY-SERVICE/help/HelpInfo", HttpMethod.POST, entity1, String.class).getBody();
	    return "redirect:/allHelp";
	}
	
	
}
