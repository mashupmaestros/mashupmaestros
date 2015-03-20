package com.codesandgears.enterkonnect.locationidentifier;

public class Point {

	private double xCoordinate;
	private double yCoordinate;
	
	public Point(double x,double y) {
		xCoordinate = x;
		yCoordinate = y;
	}
	
	public double getxCoordinate() {
		return xCoordinate;
	}
	public void setxCoordinate(double xCoordinate) {
		this.xCoordinate = xCoordinate;
	}
	public double getyCoordinate() {
		return yCoordinate;
	}
	public void setyCoordinate(double yCoordinate) {
		this.yCoordinate = yCoordinate;
	}
	
	public void translate(double xIncrease, double yIncrease){
		setxCoordinate(xCoordinate + xIncrease);
		setyCoordinate(yCoordinate + yIncrease);
	}

	@Override
	public String toString() {
		return "Point [xCoordinate=" + xCoordinate + ", yCoordinate="
				+ yCoordinate + "]";
	}
	
	
}
