package com.codesandgears.enterkonnect.beans;

import com.googlecode.objectify.annotation.Id;

import com.googlecode.objectify.annotation.Entity;

@Entity
public class Device {
	
	@Id
    Long id;

    private String macid;
    private float position;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMacid() {
		return macid;
	}
	public void setMacid(String macid) {
		this.macid = macid;
	}
	public float getPosition() {
		return position;
	}
	public void setPosition(float position) {
		this.position = position;
	}
    
    
}
