package be.technofutur.segment;

public class Triangle {

	protected Point a, b, c, obj;
	protected double s, area, l1, l2, l3;
	
	/**
	 * Triangle 
	 * 
	 * @param a
	 * @param b
	 * @param c
	 */
	public Triangle(Point a, Point b, Point c) {
		
		this.a = a;
		this.b = b;
		this.c = c;	
		
		this.obj = new Point();
	}
	
	/**
	 * Triangle 
	 * 
	 * @param ax
	 * @param ay
	 * @param bx
	 * @param by
	 * @param cx
	 * @param cy
	 * 
	 */
	public Triangle(double ax, double ay, double bx, double by, double cx, double cy) {
		
		this.a = new Point(ax, ay);
		this.b = new Point(bx, by);
		this.c = new Point(cx, cy);
	}
	
	/**
	 * calculatePerimeter
	 * 
	 * @return double
	 */
	public double calculatePerimeter() {
		
		return (this.obj.getDistanceXY(this.a, this.b) + this.obj.getDistanceXY(this.b, this.c) + this.obj.getDistanceXY(this.c, this.a));
	}
	
	/**
	 * calculateArea
	 * 
	 * @return area
	 */
	public double calculateArea() {
		
		s = (this.calculatePerimeter()) / 2;
		
		area = Math.sqrt(s * ((s - this.obj.getDistanceXY(this.a, this.b)) * (s - this.obj.getDistanceXY(this.b, this.c)) * (s - this.obj.getDistanceXY(this.c, this.a))));
		
		return area;
	}
	
	public boolean isRectangle() {
		
		l1 = this.obj.getDistanceXY(this.a, this.b);
		l2 = this.obj.getDistanceXY(this.b, this.c);
		l3 = this.obj.getDistanceXY(this.c, this.a);
		
		return (l1 == l2 && l1 == l3) || (l2 == l1 && l2 == l3) || (l3 == l1 && l3 == l2);
	}
	
	
}
