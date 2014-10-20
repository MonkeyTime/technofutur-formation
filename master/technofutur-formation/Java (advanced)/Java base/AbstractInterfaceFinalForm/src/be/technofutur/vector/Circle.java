package be.technofutur.vector;

public class Circle implements IVector {

	protected double area;
	
	/**
	 * Constructor
	 * 
	 * @param area
	 * 
	 */
	public Circle(double area) {
		
		this.area = area;
	}
	
	/**
	 * perimeter
	 * 
	 * @return double 	The perimeter
	 * 
	 */
	public double perimeter() {
		
		return (2 * Math.PI * area);
	}
	
	/**
	 * area
	 * 
	 * @return double 	The area
	 * 
	 */
	public double area() {
		
		return (Math.PI * Math.pow(this.area, 2));
	}

}
