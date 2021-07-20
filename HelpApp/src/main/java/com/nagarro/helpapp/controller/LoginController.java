package com.nagarro.helpapp.controller;

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
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nagarro.helpapp.demoentity.LoginInfo;
import com.nagarro.helpapp.demoentity.ProviderInfo;
import com.nagarro.helpapp.demoentity.ReceiverInfo;

@Controller
public class LoginController {

	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/")
	public String login()
	{
		return "login.html";
	}
	@RequestMapping("login")
	public String loginpage()
	{
		return "login.html";
	}
	
	@RequestMapping("ProviderRegistration")
	public String goToProviderRegistration()
	{
		return "ProviderRegistration.html";
	}

	@RequestMapping("ReceiverRegistration")
	public String goToReceiverRegistration()
	{
		return "ReceiverRegistration.html";
	}
		
	@RequestMapping("validate")
	public String validateUser(ModelAndView model,HttpSession session,@RequestParam String userid,@RequestParam String password) throws JsonMappingException, JsonProcessingException
	{
		HttpEntity<String> entity = restTemplate.getForEntity("http://GATEWAY-SERVICE/login/LoginInfo", String.class);
		String body=entity.getBody();
		LoginInfo[] users=new ObjectMapper().readValue(body, LoginInfo[].class);
		
		for(LoginInfo user:users)
		{
			if((user.getEmail().equals(userid))&&(user.getPassword().equals(password)))
			{
				session.setAttribute("user", user.getEmail());
				if(user.getType().equalsIgnoreCase("provider"))
				{
					HttpEntity<String> entity1 = restTemplate.getForEntity("http://GATEWAY-SERVICE/provider/ProviderInfo", String.class);
					String body1=entity1.getBody();
					ProviderInfo[] u1=new ObjectMapper().readValue(body1, ProviderInfo[].class);
					System.out.println(u1[0].getContact());
					session.setAttribute("providercontact", u1[0].getContact());
					return "redirect:/allHelp";
				}
				if(user.getType().equalsIgnoreCase("receiver"))
				{
					HttpEntity<String> entity1 = restTemplate.getForEntity("http://GATEWAY-SERVICE/receiver/ReceiverInfo", String.class);
					String body1=entity1.getBody();
					ReceiverInfo[] u1=new ObjectMapper().readValue(body1, ReceiverInfo[].class);
					System.out.println(u1[0].getContact());
					session.setAttribute("receivercontact", u1[0].getContact());
					session.setAttribute("receiverlocation", u1[0].getLocation());
					return "redirect:/addRequest";
				}
			}
		}
		session.setAttribute("msg", "user not registered");
		return "login.html";
	}
	
	@RequestMapping(value = "logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/login";
	}
	
	@RequestMapping("registerProvider")
	public ModelAndView registerProvider(HttpSession session,ProviderInfo info)
	{
		 HttpHeaders headers = new HttpHeaders();
	     headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	     HttpEntity<ProviderInfo> entity = new HttpEntity<ProviderInfo>(info,headers);
	     restTemplate.exchange("http://GATEWAY-SERVICE/provider/ProviderInfo", HttpMethod.POST, entity, String.class).getBody();
	     
	     LoginInfo info1=new LoginInfo();
	     info1.setEmail(info.getEmail());
	     info1.setPassword(info.getPassword());
	     info1.setType("provider");
	     HttpEntity<LoginInfo> entity1=new HttpEntity<LoginInfo>(info1,headers);
	     restTemplate.exchange("http://GATEWAY-SERVICE/login/LoginInfo", HttpMethod.POST, entity1, String.class).getBody();
	     
	     
	     ModelAndView mv=new ModelAndView("login");
	     session.setAttribute("msg", "User Registered");
	     return mv;
	}
	
	@RequestMapping("registerReceiver")
	public ModelAndView registerReceiver(HttpSession session, ReceiverInfo info)
	{
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity<ReceiverInfo> entity = new HttpEntity<ReceiverInfo>(info,headers);
	    restTemplate.exchange("http://GATEWAY-SERVICE/receiver/ReceiverInfo", HttpMethod.POST, entity, String.class).getBody();
	    
	    LoginInfo info1=new LoginInfo();
	    info1.setEmail(info.getEmail());
	    info1.setPassword(info.getPassword());
	    info1.setType("receiver");
	    HttpEntity<LoginInfo> entity1=new HttpEntity<LoginInfo>(info1,headers);
	    restTemplate.exchange("http://GATEWAY-SERVICE/login/LoginInfo", HttpMethod.POST, entity1, String.class).getBody();
	 
	    ModelAndView mv=new ModelAndView("login");
	    session.setAttribute("msg", "User Registered");
	    return mv;    
	}
	
}
