package be.technofutur.vector;

public class Triangle implements IVector {

	double base, height, a, b, c = 0;
	
	/**
	 * Constructor
	 * 
	 * @param base
	 * @param height
	 * 
	 */
	public Triangle(double base, double height) {
		
		this.base = base;
		this.height = height;
		
	}
	
	/**
	 * Constructor
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * 
	 */
	public Triangle(double a, double b, double c) {
		
		this.a = a;
		this.b = b;
		this.c = c;
		
	}
	
	/**
	 * perimeter
	 * 
	 * @return double
	 * 
	 */
	public double perimeter() {
		
		return this.a + this.b + this.c;
	}
	
	/**
	 * area
	 * 
	 * @return double
	 * 
	 */
	public double area() {
		
		return (this.base * this.height) / 2;
	}

}
