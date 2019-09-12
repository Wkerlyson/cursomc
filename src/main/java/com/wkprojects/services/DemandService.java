package com.wkprojects.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wkprojects.domain.Demand;
import com.wkprojects.repositories.DemandRepository;
import com.wkprojects.services.exceptions.ObjectNotFoundException;

@Service
public class DemandService {

	@Autowired
	private DemandRepository repo;

	public Demand find(Integer id) {
		Optional<Demand> demand = repo.findById(id);
		return demand.orElseThrow(
				() -> new ObjectNotFoundException("Object not found! Id: " + id + ", Type: " + Demand.class.getName()));
	}
}
