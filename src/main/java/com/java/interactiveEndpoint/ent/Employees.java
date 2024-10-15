package com.java.interactiveEndpoint.ent;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="employees")
public class Employees {

	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private int id;
	 
	 private String name;
	 private String email;
	 private String phone;
	 
	 @Column(name = "department_id")
	 private int departmentId;
	 
	 private double salary;
	 private String position;
	 private Date createDate;
	 private String createdBy;
	 private Date updateDate;
	
	 
	 @ManyToOne
	 @JoinColumn(name = "department_id" , referencedColumnName = "id"
	 , insertable=false, updatable=false)
	 Department departments;
	  
	 
	 public Department getDepartments() {
		return departments;
	}

	public void setDepartments(Department departments) {
		this.departments = departments;
	}

	 
	 public Employees() {
		 
	 }
	 
     public Employees(int id, String name, String email, String phone, int departmentId
    , double salary,String position, Date createdDate, String createdBy) {
		
    	 this.id = id;
    	 this.name = name;
    	 this.phone = phone;
    	 this.email = email;
    	 this.departmentId = departmentId;
    	 this.salary = salary;
    	 this.position = position;
    	 this.createDate = createdDate;
    	 this.createdBy = createdBy;
    	 
	 }
	 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	
}
