package com.codesandgears.enterkonnect.beans;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
@Entity
public class Person {
	
	@Id
    Long id;

    private String Name;
    private int empId;
    private Device device;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public Device getDevice() {
		return device;
	}
	public void setDevice(Device device) {
		this.device = device;
	}
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", Name=" + Name + ", empId=" + empId
				+ ", device=" + device + "]";
	}
	
	
    

}
