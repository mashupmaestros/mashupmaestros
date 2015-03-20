package com.codesandgears.enterkonnect.locationidentifier;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * @author anand
 *
 */
public class AccessPointConfigLoader {
	public static AccessPointConfigLoader configLoader = null;
	
	private static String CONFIGFILE = "AccessPointConfig.properties";
	
	private static Properties accessPointProperty;
	
	public AccessPointConfigLoader() throws IOException{
		accessPointProperty = new Properties();
		InputStream propFile = getClass().getClassLoader().getResourceAsStream(CONFIGFILE);
		if(propFile != null){
			accessPointProperty.load(propFile);
		}else{
			throw new FileNotFoundException("Configuration file '"+CONFIGFILE+"' not found, please configure the access point environment properly");
		}
	}

	public Properties getAccessPointProperty() {
		if(configLoader == null)
			getConfigLoaderInstance();
		return accessPointProperty;
	}

	public static AccessPointConfigLoader getConfigLoaderInstance() {
		if(configLoader == null)
			try {
				configLoader = new AccessPointConfigLoader();
			} catch (IOException e) {
				e.printStackTrace();
			}
		return configLoader;
	}
	
	public double getConfiguration(String keyWord){
		return Double.parseDouble(configLoader.getAccessPointProperty().getProperty(keyWord));
	}

}
