package com.java.interactiveEndpoint.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.java.interactiveEndpoint.ent.Employees;

@Repository
public interface EmployeesRepo extends PagingAndSortingRepository<Employees, Integer> {

	 @Modifying
     @Transactional
     @Query("DELETE FROM Employees e WHERE e.id = :id")
     int deleteByQuery(@Param("id") int id);
}
