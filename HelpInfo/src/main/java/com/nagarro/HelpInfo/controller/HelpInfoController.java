package com.nagarro.HelpInfo.controller;

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

import com.nagarro.HelpInfo.dao.HelpInfoDao;
import com.nagarro.HelpInfo.entity.HelpInfo;

@RestController
@RequestMapping("/help")
public class HelpInfoController {

	@Autowired
	private HelpInfoDao dao;
	
	//get all help info
	@GetMapping("/HelpInfo")
	public List<HelpInfo> getHelpInfo()
	{
		return dao.findAll();
	}
	
	//get help by id
	@GetMapping("/HelpInfo/{id}")
	public Optional<HelpInfo> getHelpInfoById(@PathVariable int id)
	{
		return dao.findById(id);
	}
	
	//add help
	@PostMapping("/HelpInfo")
	public HelpInfo addHelpInfo(@RequestBody HelpInfo info)
	{
		return dao.save(info);
	}
	
	//delete helpInfo
	@DeleteMapping("/HelpInfo/{id}")
	public void deleteHelpInfo(@PathVariable int id)
	{
		dao.deleteById(id);
	}
	
}








