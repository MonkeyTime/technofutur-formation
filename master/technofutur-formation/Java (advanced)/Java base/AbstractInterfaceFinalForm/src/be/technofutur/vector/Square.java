package be.technofutur.vector;

public class Square implements IVector {
	
	protected double side = 0;
	
	/**
	 * Constructor
	 * 
	 * @param side
	 * 
	 */
	public Square(double side) {
		
		this.side = side;
	}
	
	/**
	 * perimeter
	 * 
	 * @return double
	 * 
	 */
	public double perimeter() {
		
		return (this.side * 4);
	}
	
	/**
	 * area
	 * 
	 * @return double
	 * 
	 */
	public double area() {
		
		return Math.pow(this.side, 2);
	}
}
