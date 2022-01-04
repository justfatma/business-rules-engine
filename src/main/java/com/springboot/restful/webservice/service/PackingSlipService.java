package com.springboot.restful.webservice.service;

import java.util.List;
import java.util.Optional;
import com.springboot.restful.webservice.model.PackingSlip;

public interface PackingSlipService {
	
	public Optional<PackingSlip> getPackingSlipById(Long packingSlipId);
	public List<PackingSlip> getPackingSlipList();
	public String generatePackingSlips();
	
}
