package com.java.interactiveEndpoint.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.interactiveEndpoint.ent.Department;
import com.java.interactiveEndpoint.ent.Employees;
import com.java.interactiveEndpoint.service.DepartmentService;
import com.java.interactiveEndpoint.service.EmployeeService;

@RestController
@RequestMapping("/departmentAPI")
@CrossOrigin("*")
public class DepartmentController {
	
	@Autowired
	DepartmentService service;
	
	@PostMapping("/saveDepartment")
	public Map<String, Object> saveDepartment(@RequestBody Map<String, Object> reqMap){
     return service.saveDepartment(reqMap);		
	}
	
	@PatchMapping("/updateDepartment")
	public Map<String, Object> updateDepartment(@RequestBody Map<String, Object> reqMap){
     return service.updateDepartment(reqMap);		
    }
	
	@DeleteMapping("/deleteDepartment")
	public int deleteDepartment(@RequestParam int id){
     return service.deleteDepartment(id);
				
    }
	
	
	 @GetMapping("/getAllDepartments")
	    public ResponseEntity<List<Department>> getAllDepartments(
	    @RequestParam(defaultValue = "0") Integer pageNo,
	    @RequestParam(defaultValue = "10") Integer pageSize
	                      )
	    {
	        List<Department> list = service.getAllDepartments(pageNo, pageSize);

	        return new ResponseEntity<List<Department>>(list, new HttpHeaders(), HttpStatus.OK);
	    }

	

}
