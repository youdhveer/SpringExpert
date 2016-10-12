package com.cpt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cpt.dto.BusDTO;
import com.cpt.service.TransportService;

@Controller
public class TransportController {

	private static Logger logger=LoggerFactory.getLogger(TransportController.class.getName());
			
	@Autowired
	private TransportService transportService;
	
	@RequestMapping(value = "/rest/addBus", method = RequestMethod.POST)
    public  @ResponseBody String saveBus(@RequestParam("registrationId") String registrationId, 
    		@RequestParam("routeId") String routeId, @RequestParam("busTerminusId") String busTerminusId,
    		@RequestParam("busTerminusName") String busTerminusName,
    		@RequestParam("manufacturerCompnay") String manufacturerCompnay,
    		@RequestParam("manufacturerYear") String manufacturerYear,
    		@RequestParam("capacity") String capacity) {    	
		
		BusDTO busDTO=new BusDTO();
		busDTO.setBusTerminusId(busTerminusId);
		busDTO.setBusTerminusName(busTerminusName);
		busDTO.setCapacity(capacity);
		busDTO.setRouteId(routeId);
		busDTO.setManufacturerYear(manufacturerYear);
		busDTO.setManufacturerCompnay(manufacturerCompnay);
		busDTO.setRegistrationId(registrationId);
		
		String status="";
		try {
			transportService.addBus(busDTO);
			logger.info("Bus object saved in database with registerationId : "+busDTO.getRegistrationId());
			status="Sucess !";
		} catch (Exception e) {
			status="Failed !";
			logger.error("Exception :: "+e.getMessage());
			e.printStackTrace();
		}
        
        return status;
    }
		
	
}
