package be.technofutur.point;

import java.math.*;

public class Point {
	
	protected double x;
	protected double y;
	protected String str;
	protected static int count = 0;
	protected double distance = 0;
	
	/**
	 * constructor
	 * 
	 */
	public Point() {
		
		this.x = 0.0;
		this.y = 0.0;
		
		this.count++;
		
	}
	
	/**
	 * Constructor
	 * 
	 * @param x axe x
	 * @param y axe y
	 */
	public Point(double x, double y) {
		
		this.x = x;
		this.y = y;
		
		this.count++;
	}
	
	/**
	 * getX
	 * 
	 * @return double
	 */
	public double getX() {
		
		return this.x;
	}
	
	/**
	 * getY
	 * 
	 * @return double
	 */
	public double getY() {
		
		return this.y;
	}
	
	/**
	 * toString
	 * 
	 * @return 	String 	x and y position
	 */
	public String toString() {
		
		str = "x value: " + this.x + ", y value: " + this.y;
		
		return str;
	}
	
	/**
	 * translateXY
	 * 
	 * translation plan
	 * 
	 * @param double
	 * @param double
	 */
	public void translateXY(double x, double y) {
		
		this.x += x;
		this.y += y;
	}
	
	/**
	 * static total
	 * 
	 * @return total of point instances
	 */
	public static int total() {
		
		return count;
	}
	
	/**
	 * getDistanceFromXPoints
	 * 
	 * @param Point
	 * @param Point
	 * 
	 * @return double
	 */
	public double getDistanceFromXPoints(Point From, Point To) {
		
		return To.x - From.x;
	}
	
	/**
	 * getDistanceFromYPoints
	 * 
	 * @param Point
	 * @param Point
	 * 
	 * @return double
	 */
	public double getDistanceFromYPoints(Point From, Point To) {
		
		return To.y - From.y;
	}
	
	/**
	 * getDistanceXY
	 * 
	 * @param Point
	 * @param Point
	 * 
	 * @return double
	 */
	public double getDistanceXY(Point X, Point Y) {

		distance = Math.pow(X.y - X.y, 2) + Math.pow(Y.x - Y.x, 2);
		
		return (distance * distance);
	}
	
	/**
	 * axiallySymmetry
	 * 
	 * @param p1
	 * @param p2
	 * 
	 * @return double
	 */
	public double axiallySymmetry(Point p1, Point p2) {
		
		return (this.getDistanceXY(p1, p2) / 2);
	}	
}
