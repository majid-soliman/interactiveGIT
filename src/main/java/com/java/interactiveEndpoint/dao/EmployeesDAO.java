package com.java.interactiveEndpoint.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.java.interactiveEndpoint.ent.Employees;
import com.java.interactiveEndpoint.repo.EmployeesRepo;
import com.java.interactiveEndpoint.exceptions.*;

@Component
public class EmployeesDAO {

	@Autowired
	EmployeesRepo repo;
	
	
	public Map<String, Object> saveEmployee(Employees emp) {
		Map<String, Object> resMap =new HashMap<String,Object>();
		Employees Emp = null;
		try {
			emp = repo.save(emp);
			resMap.put("Success", emp);
		}
		catch(Exception exception) {
			exception.printStackTrace();
			resMap.put("Error", exception.getMessage());
			}
		return resMap;
	}
	
	
	//Update Employee
	@Transactional
	public Map<String, Object> updateEmployee(Map<String, Object> reqMap) {
		Map<String, Object> resMap =new HashMap<String,Object>();
	try {
		Employees employee = repo.findById(Integer.parseInt(reqMap.get("empId")
				.toString())).orElseThrow(()-> new EmployeeNotfoundException("Employee Not Found"));
				employee.setPhone(reqMap.get("phone").toString());
				employee.setEmail(reqMap.get("email").toString());
	      resMap.put("Success", repo.save(employee));		
	}
	catch(Exception exception) {
		exception.printStackTrace();
		resMap.put("Error", exception.getMessage());
		}
     	return resMap;
		
	}
	
	//Delete Employee
	@Transactional
	public int deleteEmployee(int id) {
	   return repo.deleteByQuery(id);
	}
	
	//Pagenation select
	public List<Employees> getAllEmployees(Integer pageNo, Integer pageSize)
	    {  Pageable paging = PageRequest.of(pageNo, pageSize);

	        Page<Employees> pagedResult = repo.findAll(paging);

	        if(pagedResult.hasContent()) {
	            return pagedResult.getContent();
	        } else {
	            return new ArrayList<Employees>();
	        }
	    }
	
	
	
}
