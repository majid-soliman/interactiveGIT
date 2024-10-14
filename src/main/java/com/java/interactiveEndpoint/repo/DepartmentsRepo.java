package com.java.interactiveEndpoint.repo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.java.interactiveEndpoint.ent.Department;
import com.java.interactiveEndpoint.ent.Employees;

public interface DepartmentsRepo extends PagingAndSortingRepository<Department, Integer>  {
	
	 @Modifying
     @Transactional
     @Query("DELETE FROM Department dep WHERE dep.id = :id")
     int deleteByQuery(@Param("id") int id);

}
