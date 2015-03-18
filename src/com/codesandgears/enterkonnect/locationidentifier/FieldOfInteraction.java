/**
 * 
 */
package com.codesandgears.enterkonnect.locationidentifier;

/**
 * @author anand
 *
 */
public class FieldOfInteraction {
	
	private Point origin;
	
	private double radius;
	
	private double strengthDegradationScale;
	
	private double areaOfInteraction;

	public FieldOfInteraction() {
		origin = new Point(0,0);
		setStrengthDegradationScale(0);
	}
	
	public FieldOfInteraction(double xCoord, double yCoord, double degradeScale){
		setStrengthDegradationScale(degradeScale);
	}
	
	
	public Point getOrigin() {
		return origin;
	}

	public void setOrigin(Point origin) {
		this.origin = origin;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getStrengthDegradationScale() {
		return strengthDegradationScale;
	}

	public void setStrengthDegradationScale(double strengthDegradationScale) {
		this.strengthDegradationScale = strengthDegradationScale;
	}

	public double getAreaOfInteraction() {
		return areaOfInteraction;
	}

	public void setAreaOfInteraction(double areaOfInteraction) {
		this.areaOfInteraction = areaOfInteraction;
	}

}
