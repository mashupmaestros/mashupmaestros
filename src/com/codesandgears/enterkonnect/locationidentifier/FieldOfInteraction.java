/**
 * 
 */
package com.codesandgears.enterkonnect.locationidentifier;

/**
 * @author anand
 *
 */
public class FieldOfInteraction {
	
	private double signalStrength;
	private AccessPoint ap;
	
	public FieldOfInteraction(String bssid, double signalStrength ){
		setSignalStrength(signalStrength);
		ap = new AccessPoint(bssid);
	}
	

	public double getRadius() { 
		return Math.abs((ap.getMaxSignalStrength() - signalStrength)  * ap.getStrengthDegradationScale());
	}

	public double getSignalStrength() {
		return signalStrength;
	}

	public void setSignalStrength(double signalStrength) {
		this.signalStrength = signalStrength;
	}

	public Point getDisposition(){
		return ap.getDisposition();
	}
}
