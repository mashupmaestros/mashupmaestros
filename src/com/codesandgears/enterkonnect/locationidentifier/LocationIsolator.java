package com.codesandgears.enterkonnect.locationidentifier;

public class LocationIsolator {

	private FieldOfInteraction field1;
	private FieldOfInteraction field2;
	private double x0,y0,r0,x1,y1,r1; 
	
	public LocationIsolator(String bssid1, double signalStrength1, String bssid2, double signalStrength2 ) {
		// 
		field1 = new FieldOfInteraction(bssid1, signalStrength1);
		field2 = new FieldOfInteraction(bssid2, signalStrength2);
		/* get values from first circle */
		x0 = field1.getDisposition().getxCoordinate();
		y0 = field1.getDisposition().getyCoordinate();
		r0 = field1.getRadius();
		/* get values from second circle */
		x1 = field2.getDisposition().getxCoordinate();
		y1 = field2.getDisposition().getyCoordinate();
		r1 = field2.getRadius();
		
	}
	
	/**
	 * This method is used to check if the two fields obtained are actually intersecting
	 * @param values
	 * @return if the fields intersect
	 */
	public boolean checkIfIntersecting(){
		return (Math.abs(r0 - r1) <= Math.sqrt(Math.pow((x0 - x1), 2) + Math.pow((y0 - y1), 2)))&& (Math.sqrt(Math.pow((x0 - x1), 2) + Math.pow((y0 - y1), 2)) <= (r0 + r1));
	}
	
	
	public Point findCentriod(){
		
		// dx and dy are the vertical And horizontal distances between the circle centers.
	    double dx = x1 - x0;
	    double dy = y1 - y0;
	    
	    //Determine the straight-Line distance between the centers.
	    double d = Math.sqrt((dy*dy) + (dx*dx));
	    
	    //point 2 is the point where the Line through the circle intersection points crosses the Line between the circle centers. Determine the distance from point 0 To point 2.
	    double a = ((r0*r0) - (r1*r1) + (d*d)) / (2.0 * d);
	 
	    //Determine the coordinates of point 2.
	    double x2 = x0 + (dx * a/d);
	    double y2 = y0 + (dy * a/d);
	    
		return new Point(x2,y2);
	}
	
	/*public static void main(String args[]){
		double x0 = 2,y0 = 3,r0 = 3;
		double x1 = 1,y1 = -1, r1 = 4;
		
		// dx and dy are the vertical And horizontal distances between the circle centers.
	    double dx = x1 - x0;
	    double dy = y1 - y0;
	    
	    //Determine the straight-Line distance between the centers.
	    double d = Math.sqrt(((dy*dy) + (dx*dx)));
	    
	    //point 2 is the point where the Line through the circle intersection points crosses the Line between the circle centers. Determine the distance from point 0 To point 2.
	    double a = ((r0*r0) - (r1*r1) + (d*d)) / (2.0 * d);
	 
	    //Determine the coordinates of point 2.
	    double x2 = x0 + (dx * a/d);
	    double y2 = y0 + (dy * a/d);
	    
	    System.out.println(x2+":"+y2);
	    //Determine the distance from point 2 To either of the
	    //intersection points.
	    double h = Math.sqrt((r0*r0) - (a*a));
	 
	    double rx = (0-dy) * (h/d);
	    double ry = dx * (h/d);
	 
	    double xi1 = x2 + rx;
	    double xi2 = x2 - rx;
	    double yi1 = y2 + ry;
	    double yi2 = y2 - ry;
	    
	    System.out.println(xi1+":"+yi1);
	    System.out.println(xi2+":"+yi2);
	    

	}*/

}
