package com.codesandgears.enterkonnect.beans;

import com.google.appengine.api.datastore.Blob;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class Device {
	
	@Id
    private String macid;	
    private String position;
    private String timeStamp;
    @Index
    private String firstname;
    private Blob profilepicture;
    private double xcord;
    private double ycord;
	
	public String getMacid() {
		return macid;
	}
	public void setMacid(String macid) {
		this.macid = macid;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public Blob getProfilepicture() {
		return profilepicture;
	}
	public void setProfilepicture(Blob profilepicture) {
		this.profilepicture = profilepicture;
	}
	public double getXcord() {
		return xcord;
	}
	public void setXcord(double xcord) {
		this.xcord = xcord;
	}
	public double getYcord() {
		return ycord;
	}
	public void setYcord(double ycord) {
		this.ycord = ycord;
	}
    
    
}
