package com.java.interactiveEndpoint.ent;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="department")
public class Department {

	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private int id;
     public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	@Column(name = "department_name") 	 
	 private String departmentName;
     private String description;
     @Column(name = "created_on")
     private Date createdOn;
     
     
     public Department() {
    	 
     }
     
     public Department(int id, String departmentName, String description, Date createdOn) {
     this.id = id;
     this.departmentName = departmentName;
     this.description = description;
     this.createdOn = createdOn;
     }
     
     
	 
	
}
