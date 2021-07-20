package com.nagarro.providerregistration.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.providerregistration.dao.ProviderInfoDao;
import com.nagarro.providerregistration.entity.ProviderInfo;

@RestController
@RequestMapping("/provider")
public class ProviderController {
	
	@Autowired
	private ProviderInfoDao dao;
	
	//get all provider info
	@GetMapping("/ProviderInfo")
	public List<ProviderInfo> getProviderInfo()
	{
		return dao.findAll();
	}
	
	//get specific provider info
	@GetMapping("/ProviderInfo/{email}")
	public Optional<ProviderInfo> getInfoByEmail(@PathVariable String email)
	{
		return dao.findById(email);
	}

	@PostMapping("/ProviderInfo")
	public ProviderInfo addProvider(@RequestBody ProviderInfo info)
	{
		return dao.save(info);
	}
}
