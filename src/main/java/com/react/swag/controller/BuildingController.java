package com.react.swag.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.react.swag.entity.Building;
import com.react.swag.service.IBuildingService;

@CrossOrigin(originPatterns = "http://localhost:3000")
@RestController
@RequestMapping(value = "/api")
public class BuildingController {

	private IBuildingService service;
	
	@Autowired
	public void setService(IBuildingService service) {
		this.service = service;
	}

	@GetMapping(value = "/")
	public String home(String name) {
		return "HELLO HI ' "+name+" ' Welcome to GP_HOMES ";
		
	}
	
	@PostMapping(value = "/EnterBuildingDetails")
	public ResponseEntity<String>insertBuildingDetails(@RequestBody @Validated Building bill)
	{
		service.saveData(bill);
		
		return new ResponseEntity<>("Details Added Succesfully ",HttpStatus.OK);
	}
	
	@GetMapping("/search/{bid}")
	public Optional<Building> gettingBuildingDetails(@PathVariable("bid") int id){
		
		return service.getBuildingData(id);
		
	}
	
	@GetMapping("/fetchAll")
	public List<Building>fetchAll(){
		
		return service.fetchData();
				
	}
	
	@PutMapping("/update")
	public Building update( @RequestBody  Building build) 
	{
		return service.updateById(build);
	}
	
	@DeleteMapping("/delete/{bid}")
	public void deleteByBuilding(@PathVariable("bid") int id) 
	{
	service.deleteBuilding(id);
	}
	
}
