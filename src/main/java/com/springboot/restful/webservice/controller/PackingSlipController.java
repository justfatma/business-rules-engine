package com.springboot.restful.webservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.springboot.restful.webservice.model.PackingSlip;
import com.springboot.restful.webservice.serviceimpl.PackingSlipServiceImpl;

@RestController
public class PackingSlipController {

	
	@Autowired
	private PackingSlipServiceImpl packingSlipServiceImpl;
	
	@GetMapping("/packingslips")
    public List<PackingSlip> getPackingSlips() {	
    	List<PackingSlip> packingSlipList= packingSlipServiceImpl.getPackingSlipList();
    	if (packingSlipList!= null && packingSlipList.size()>0) {
    		return packingSlipList;
    	}else {
    		throw new ResponseStatusException(HttpStatus.NOT_FOUND) ;
    	}
    }
	
	@GetMapping("/packingslips/{packingSlipId}")
	public PackingSlip getPackingSlipById(@PathVariable Long packingSlipId) {
				
		return Optional.ofNullable(packingSlipServiceImpl.getPackingSlipById(packingSlipId))
    			.get()
    			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@GetMapping("/generatepackingslips")
	public String getAndGeneratePackingSlips() {
				
		return packingSlipServiceImpl.generatePackingSlips();
	}
	
}
