package be.reference;

import java.awt.Point;

public class Main {

	public static void main(String[] args) {
		Point p1 = new Point(0,0);
		Point p2 = new Point(1,1);
		swap(p1, p2);
		System.out.println(p1.toString() + " " + p2.toString());
		
		/*int u = 20;
		change(u);
		System.out.println(u);
		
		Boolean b = true;
		changing(b);
		System.out.println(b);
		
		Point p3 = new Point(2,2);
		changePoint(p3);
		System.out.println(p3);*/
	}
	
	public static void swap(Point a, Point b) {
		System.out.println(a + " " + b);
		Point tmp = a;
		a = b;
		b = tmp;
		System.out.println(a + " " + b);
	}
	
	public static void change(int i) {
		i=50;
	}
	
	public static void changing(Boolean b) {
		b=false;
	}
	
	public static void changePoint(Point p) {
		p = new Point(88,88);
	}
}
