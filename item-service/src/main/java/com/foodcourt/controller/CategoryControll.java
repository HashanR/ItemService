package com.foodcourt.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.foodcourt.model.Category;
import com.foodcourt.service.CategoryService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/category")
public class CategoryControll {

	@Autowired
	CategoryService categoryService;

	@RequestMapping(value = "/category", method = RequestMethod.POST)
	public Category save(@RequestBody Category category) {
		return categoryService.save(category);
	}

	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public List<Category> FetchAllCategory() {
		return categoryService.fetchAllCategory();
	}

	@RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
	public ResponseEntity<Category> FetchCategory(@PathVariable Integer id)  {
		Category category1 = new Category();
		category1.setId(id);
		Category category2 = categoryService.fetchCategory(category1);
		if (category2 == null) {
			//throw new IdNotFound("Can't find this id : " + id);
			return null;
		} else {
			return new ResponseEntity<Category>(category2, HttpStatus.OK);
		}

	}

	@RequestMapping(value = "/category/{id}", method = RequestMethod.PUT)
	public Category updateCategory(@RequestBody Category category, @PathVariable Integer id) {
		return categoryService.updateCategory(category);

	}

	@RequestMapping(value = "/category/{id}", method = RequestMethod.DELETE)
	public void deleteCategory(@RequestBody Category category, @PathVariable Integer id) {
		categoryService.deleteCategory(category);
	}

}
