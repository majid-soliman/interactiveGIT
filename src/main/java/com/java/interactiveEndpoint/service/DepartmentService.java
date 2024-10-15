package com.java.interactiveEndpoint.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.interactiveEndpoint.dao.DepartmentsDAO;
import com.java.interactiveEndpoint.dao.EmployeesDAO;
import com.java.interactiveEndpoint.ent.Department;
import com.java.interactiveEndpoint.ent.Employees;

@Service
public class DepartmentService {

	@Autowired
	DepartmentsDAO dao;
	
    public Map<String, Object> saveDepartment(Map<String, Object> reqMap) {
        Department reqBody = new Department();
    	reqBody.setDepartmentName(reqMap.get("name").toString());
    	reqBody.setDescription(reqMap.get("description").toString());
    	reqBody.setCreatedOn(new Date());
    	
      return dao.saveDepartment(reqBody);
   }
    
    public Map<String, Object> updateDepartment(Map<String, Object> reqMap) {
    	      return dao.updateDepartment(reqMap);
   } 
    
    public int deleteDepartment(int id) {
	    return dao.deleteDepartment(id);   
    }
    
    public List<Department> getAllDepartments(Integer pageNo, Integer pageSize){
    	return dao.getAllDepartments(pageNo, pageSize);
    }
    
    
	
	
	
}
