package com.java.interactiveEndpoint.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.interactiveEndpoint.dao.EmployeesDAO;
import com.java.interactiveEndpoint.ent.Employees;

@Service
public class EmployeeService {

	@Autowired
	EmployeesDAO dao;
	
    public Map<String, Object> saveEmployee(Map<String, Object> reqMap) {
    	Employees reqBody = new Employees();
    	reqBody.setName(reqMap.get("name").toString());
    	reqBody.setEmail(reqMap.get("email").toString());
    	reqBody.setPhone(reqMap.get("phone").toString());
    	reqBody.setDepartmentId(Integer.parseInt(reqMap.get("departmentId").toString()));
    	reqBody.setSalary((Double.parseDouble(reqMap.get("salary").toString())));
    	reqBody.setPosition(reqMap.get("position").toString());
    	reqBody.setCreateDate(new Date());
    	
      return dao.saveEmployee(reqBody);
   }
    
    public Map<String, Object> updateEmployee(Map<String, Object> reqMap) {
    	      return dao.updateEmployee(reqMap);
   } 
    
    public int deleteEmployee(int id) {
	    return dao.deleteEmployee(id);   
} 
    
	
	
	
}
