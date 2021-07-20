package com.nagarro.controller;

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

import com.nagarro.dao.RequestHelpPairDao;
import com.nagarro.entity.RequestHelpPair;

@RestController
@RequestMapping("/request-help")
public class RequestHelpPairController {

	@Autowired
	private RequestHelpPairDao dao;
	
	//get all pair info
	@GetMapping("/pair")
	public List<RequestHelpPair> getAllPair()
	{
		return dao.findAll();
	}
	
	//get pair by requestId
	@GetMapping("/pair/{id}")
	public Optional<RequestHelpPair> getPairById(@PathVariable int id)
	{
		return dao.findById(id);
	}
	
	//add pair
	@PostMapping("/pair")
	public RequestHelpPair addPair(@RequestBody RequestHelpPair pair)
	{
		return dao.save(pair);
	}
	
	@DeleteMapping("/pair/{id}")
	public void deletePair(@PathVariable int id)
	{
		dao.deleteById(id);
	}
	
}







