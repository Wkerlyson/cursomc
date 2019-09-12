package com.wkprojects.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.wkprojects.domain.Category;
import com.wkprojects.repositories.CategoryRepository;
import com.wkprojects.services.exceptions.DataIntegretyException;
import com.wkprojects.services.exceptions.ObjectNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repo;

	public Category find(Integer id) {
		Optional<Category> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Object not found! Id: " + id + ", Type: " + Category.class.getName()));
	}
	
	public Category insert(Category category) {
		return repo.save(category);
	}

	public Category update(Category category, Integer id) {
		find(id);
		category.setId(id);
		return repo.save(category);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegretyException("Unable to delete a category that has produtcs");
		}
	}
}
