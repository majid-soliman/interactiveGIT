package com.java.interactiveEndpoint.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.interactiveEndpoint.service.EmployeeService;

@RestController
@RequestMapping("/employeeAPI")
@CrossOrigin("*")
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@PostMapping("/saveEmployee")
	public Map<String, Object> saveEmployee(@RequestBody Map<String, Object> reqMap){
     return service.saveEmployee(reqMap);		
	}
	
	@PatchMapping("/updateEmployee")
	public Map<String, Object> updateEmployee(@RequestBody Map<String, Object> reqMap){
     return service.updateEmployee(reqMap);		
    }
	
	@DeleteMapping("/deleteEmployee")
	public int deleteEmployee(@RequestParam int id){
     return service.deleteEmployee(id);
				
    }


}
