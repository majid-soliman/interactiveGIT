package com.java.interactiveEndpoint.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.java.interactiveEndpoint.exceptions.*;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.java.interactiveEndpoint.ent.Department;
import com.java.interactiveEndpoint.ent.Employees;
import com.java.interactiveEndpoint.repo.DepartmentsRepo;

@Component
public class DepartmentsDAO {

	@Autowired
	DepartmentsRepo repo;
	
	public Map<String, Object> saveDepartment(Department dep) {
		Map<String, Object> resMap =new HashMap<String,Object>();
		Department resDep = null;
		try {
			resDep = repo.save(dep);
			resMap.put("Success", resDep);
		}
		catch(Exception exception) {
			exception.printStackTrace();
			resMap.put("Error", exception.getMessage());
			}
		return resMap;
	}
	
	
	//Update Employee
	@Transactional
	public Map<String, Object> updateDepartment(Map<String, Object> reqMap) {
		Map<String, Object> resMap =new HashMap<String,Object>();
	try {
		Department dep = repo.findById(Integer.parseInt(reqMap.get("depId")
		.toString())).orElseThrow(()-> new DepartmentNotfoundException("Department not found!"));
		
		dep.setDepartmentName(reqMap.get("name").toString());
		resMap.put("Success", repo.save(dep));		
	}
	catch(Exception exception) {
		exception.printStackTrace();
		resMap.put("Error", exception.getMessage());
		}
     	return resMap;
		
	}
	
	//Delete Employee
	@Transactional
	public int deleteDepartment(int departmentId) {
	   return repo.deleteByQuery(departmentId);
	}
	
	//Pagenation select
		public List<Department> getAllDepartments(Integer pageNo, Integer pageSize)
		    {  Pageable paging = PageRequest.of(pageNo, pageSize);

		        Page<Department> pagedResult = repo.findAll(paging);
		        
		        if(pagedResult.hasContent()) {
		            return pagedResult.getContent();
		        } else {
		            return new ArrayList<Department>();
		        }
		    }

		
		
	
	
	
}
