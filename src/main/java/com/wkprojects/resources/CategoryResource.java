package com.wkprojects.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wkprojects.domain.Category;
import com.wkprojects.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService service;

	@GetMapping("/{id}")
	public ResponseEntity<Category> find(@PathVariable Integer id) {
		
		Category obj = service.find(id);
		
		return ResponseEntity.ok(obj);
	}

}
