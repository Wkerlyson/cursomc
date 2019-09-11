package com.wkprojects.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wkprojects.domain.Client;
import com.wkprojects.services.ClientService;

@RestController()
@RequestMapping("/clients")
public class ClientResource {
	
	@Autowired
	private ClientService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<Client> find(@PathVariable Integer id ){
		Client client = service.find(id);
		return ResponseEntity.ok(client);
	}
	
}
