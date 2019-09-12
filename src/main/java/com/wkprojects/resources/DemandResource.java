package com.wkprojects.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wkprojects.domain.Demand;
import com.wkprojects.services.DemandService;

@RestController
@RequestMapping("/demands")
public class DemandResource {
	
	@Autowired
	private DemandService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<Demand> find(@PathVariable Integer id){
		Demand demand = service.find(id);
		return ResponseEntity.ok(demand);
	}
}
