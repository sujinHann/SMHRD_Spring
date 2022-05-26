package com.smhrd.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.myapp.domain.Member;
import com.smhrd.myapp.service.MemberService;

@RestController
public class Rcontroller {
	
	@Autowired
	MemberService service;
	
	@RequestMapping("/memberMB")
	public List<Member> dataFindAllMB(){
		
		return service.dataFindAllMB();
	}
	
	@RequestMapping("/memberJAP")
	public List<Member> dataFindAllJAP(){
		return service.dataFindAllJPA();
	}
	
	@RequestMapping("/memberJAP/admin")
	public Member findAdmin(String id){
		return service.findAdmin(id);
	}
}
