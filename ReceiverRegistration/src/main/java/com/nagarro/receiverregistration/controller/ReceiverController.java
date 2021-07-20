package com.nagarro.receiverregistration.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.receiverregistration.dao.ReceiverInfoDao;
import com.nagarro.receiverregistration.entity.ReceiverInfo;

@RestController
@RequestMapping("/receiver")
public class ReceiverController {
	
	@Autowired
	ReceiverInfoDao dao;

	//get all receiver info
	@GetMapping("/ReceiverInfo")
	public List<ReceiverInfo> getAllReceiverInfo()
	{
		return dao.findAll();
	}
	
	@PostMapping("/ReceiverInfo")
	public ReceiverInfo addReceiver(@RequestBody ReceiverInfo info)
	{
		return dao.save(info);
	}
	
	@GetMapping("/ReceiverInfo/{email}")
	public Optional<ReceiverInfo> getReceiverByEmail(@PathVariable String email)
	{
		return dao.findById(email);
	}
}
