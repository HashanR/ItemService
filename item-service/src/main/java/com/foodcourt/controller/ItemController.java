package com.foodcourt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.foodcourt.model.Item;

import javassist.tools.rmi.ObjectNotFoundException;


@RestController
@RequestMapping(value="item")
public class ItemController {

	@Autowired
	ItemService itemService;
	
	@RequestMapping(value="item" , method = RequestMethod.POST)
	public Item save(@RequestBody Item item){
		return itemService.save(item);	
	}
	
	@RequestMapping(value="item",method = RequestMethod.GET)
	public List<Item> fetchAllItems(){
		return itemService.fetchAllItems();
	}
	
	@RequestMapping(value="item/{id}",method = RequestMethod.GET)
	public ResponseEntity<Item> fetchItem(@PathVariable Integer id) {
			if(itemService.fetchItemById(id)!=null) {
				return ResponseEntity.ok(itemService.fetchItemById(id));
			}
			else {
				//throw new IdNotFound("Can't find this id : " + id);
				return null;
			}
	}
	
	@RequestMapping(value="item",method = RequestMethod.PUT)
	public ResponseEntity<Item> updateItem(@RequestBody Item item) throws ObjectNotFoundException{
			if(itemService.updateItem(item)!=null) {
				return ResponseEntity.ok(itemService.updateItem(item));
			}
			else {
				//return ResponseEntity.notFound().build();
				throw new ObjectNotFoundException("Cant find this item");
			}
	}
	
	@RequestMapping(value="item",method = RequestMethod.DELETE)
	void deleteItem(@RequestBody Item item) {
		itemService.deleteItem(item);
	}
}