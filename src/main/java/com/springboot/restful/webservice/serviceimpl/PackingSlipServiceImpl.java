package com.springboot.restful.webservice.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.restful.webservice.exception.RecordNotFoundException;
import com.springboot.restful.webservice.model.PackingSlip;
import com.springboot.restful.webservice.packingslip.GeneratingPackingSlip;
import com.springboot.restful.webservice.repository.PackingSlipRepository;
import com.springboot.restful.webservice.service.PackingSlipService;

@Service
public class PackingSlipServiceImpl implements PackingSlipService{

	@Autowired
	private GeneratingPackingSlip generatingPackingSlip;
	
	@Autowired
	private PackingSlipRepository packingSlipRepository;

	@Override
	public Optional<PackingSlip> getPackingSlipById(Long packingSlipId) {
		Optional<PackingSlip> packingSlip =  packingSlipRepository.findById(packingSlipId);
		
		if (!packingSlip.isPresent()) {   
			throw new RecordNotFoundException("PackingSlipServiceImpl/getPackingSlipById : Packing slip not found. packingSlipId -> " + packingSlipId);
		}
				
		return packingSlip;
	}

	@Override
	public List<PackingSlip> getPackingSlipList() {
		List<PackingSlip> packingSlipList = packingSlipRepository.findAll();
		
		if (packingSlipList == null || packingSlipList.size() == 0) {
			throw new RecordNotFoundException("PackingSlipServiceImpl/getPackingSlipList: Packing slip list is empty. ");
		}
		
		return packingSlipList;
	}

	@Override
	public String generatePackingSlips() {
		
		List<PackingSlip> packingSlipList =(List<PackingSlip>) packingSlipRepository.findAll().stream()
                .filter(p -> !(p.isPressed()))
                .collect(Collectors.toList());
    	
		PackingSlip packingSlip = new PackingSlip();
	
		if (packingSlipList != null && packingSlipList.size()>0) {
			for (int i = 0; i < packingSlipList.size(); i++) {
				packingSlip = packingSlipList.get(i);
				
				if (packingSlip.isNeededForShipping()) {
					generatingPackingSlip.setMemberOrder(packingSlip.getMemberOrder());
					generatingPackingSlip.setForWhom("ForShipping");
					generatingPackingSlip.setNeedFirstAidVideo(packingSlip.isNeededFirstAidVideo());
					generatingPackingSlip.generatePackingSlip();
					
				}
				
				if (packingSlip.isNeededForRoyaltyDep()) {
					generatingPackingSlip.setMemberOrder(packingSlip.getMemberOrder());
					generatingPackingSlip.setForWhom("ForRoyaltyDep");
					generatingPackingSlip.setNeedFirstAidVideo(packingSlip.isNeededFirstAidVideo());
					generatingPackingSlip.generatePackingSlip();
				}
					
				packingSlip.setPressed(true);
				packingSlipRepository.save(packingSlip);
			}
			
			return "Packing slips were generated successfully. The folder can be checked.";
		}
		
		
		return "Packing slips were already generated. \n"
				+ "If the order is not for a physical product, packing slip is not generated.";
	}
	

}
