package com.codesandgears.enterkonnect.locationidentifier;

import java.util.Properties;

/**
 * Used to resemble each access point in the coordinate system provided.
 * 
 * @author anand
 *
 */

public class AccessPoints {

	//Used to uniquely identify the access point
	private String uniqueID;
	
	private FieldOfInteraction properties;
	
	private Properties accessPointsConfig;
	
	final private String XCOORD = "XCOORD";
	final private String YCOORD = "YCOORD";
	final private String FIELD_STRENGTH_DEGRADATION = "FIELD_STRENGTH_DEGRADATION"; 
	
	public AccessPoints(String uniqueID){
		this.uniqueID = uniqueID;
		accessPointsConfig = AccessPointConfigLoader.getConfigLoaderInstance().getAccessPointProperty();
		loadAccessPointProperties();
		getDisposition();
	}
	
	private void loadAccessPointProperties() {
		// Used to load the Access Point properties like location, strength degradation etc.
		
		// Get Fixed values and Update them here
		properties = new FieldOfInteraction();
		
	}

	public Point getDisposition(){
		//Used to get the actual location of the Access Point in the Coordinate System (Map) provides
		
		return null;
	}
	
	public String getUniqueID() {
		return uniqueID;
	}

}
