package com.foodcourt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.foodcourt.exception.ItemException;
import com.foodcourt.model.Item;
import com.foodcourt.service.ItemService;

import javassist.tools.rmi.ObjectNotFoundException;


@RestController
@RequestMapping(value="item")
public class ItemController {

	@Autowired
	ItemService itemService;
	
	@RequestMapping( method = RequestMethod.POST)
	public Item save(@RequestBody Item item){
			return itemService.save(item);	
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Item> fetchAll(){
		return itemService.fetchAll();
	}
	
	@RequestMapping(value="{id}",method = RequestMethod.GET)
	public ResponseEntity<Item> fetch(@PathVariable Long id) {
				return ResponseEntity.ok(itemService.fetchOne(id));	
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Item> update(@RequestBody Item item) throws ObjectNotFoundException{
				return ResponseEntity.ok(itemService.update(item));	
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	void delete(@RequestBody Item item) {
		itemService.delete(item);
	}
	
	@RequestMapping(value = "critical" ,method = RequestMethod.GET)
	public List<Item> critical(){
		return itemService.critical();
	}
}
