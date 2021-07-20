package com.nagarro.LoginInfo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.LoginInfo.dao.LoginInfoDao;
import com.nagarro.LoginInfo.entity.LoginInfo;

@RestController
@RequestMapping("/login")
public class LoginInfoController {

	@Autowired
	LoginInfoDao dao;
	
	//get all login info
	@GetMapping("/LoginInfo")
	public List<LoginInfo> getLoginInfo()
	{
		return dao.findAll();
	}
	//get specific info
	@GetMapping("/LoginInfo/{email}")
	public Optional<LoginInfo> getIngoByEmail(@PathVariable String email)
	{
		return dao.findById(email);
	}
	
	//add info
	@PostMapping("/LoginInfo")
	public LoginInfo addInfo(@RequestBody LoginInfo info)
	{
		
		return dao.save(info);
	}
	
}
