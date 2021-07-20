package com.nagarro.RequestInfo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.RequestInfo.dao.RequestInfoDao;
import com.nagarro.RequestInfo.entity.RequestInfo;

@RestController
@RequestMapping("/request")
public class RequestInfoController {

	@Autowired
	private RequestInfoDao dao;
	
	//get all provider info
	@GetMapping("/RequestInfo")
	public List<RequestInfo> getRequestInfo()
	{
		return dao.findAll();
	}
	
	@GetMapping("/RequestInfo/{id}")
	public Optional<RequestInfo> getRequestInfoById(@PathVariable int id)
	{
		return dao.findById(id);
	}
	
	//add request
	@PostMapping("/RequestInfo")
	public RequestInfo addRequestInfo(@RequestBody RequestInfo info)
	{
		return dao.save(info);
	}
	
	//delete request
	@DeleteMapping("/RequestInfo/{id}")
	public void deleteRequestInfo(@PathVariable int id)
	{
		dao.deleteById(id);
	}
	
}
