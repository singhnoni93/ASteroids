package com.mycompany.a2.GameObjects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.geom.Point2D;

public abstract class GameObject{
	private  int R,G,B, myColor;
	private Point2D point;
	private int size;
	
	
	public GameObject() {
	}
	
	public GameObject(Point2D location, int color, int newSize) {
		this.point = location;
		this.myColor = color;
		this.size = newSize;
	}
	
	
	public void setColor(int r, int g, int b) {
		this.R = r;
		this.G= g;
		this.B = b;
		myColor = ColorUtil.rgb(R, G, B);
	}
	
	public void set_size(int newSize) {
		this.size = newSize;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public int getColor() {
		return this.myColor;
	}
	
	public void point_location(double x, double y) {
			point = new Point2D(x,y); // using Point2D format
	}
	
	
	// getters for x and y for location
	public double get_x() {
		return this.point.getX();
		
	}
	public double get_y() {
		return this.point.getY();
	}
	
	// location toString method
	public String toString() {
		return "Location=(" + Math.round(point.getX())/1.0 + ","+Math.round(point.getY())/1.0  + ") Color=[" 
				+ ColorUtil.red(myColor) + ","+ColorUtil.green(myColor) +","+ ColorUtil.blue(myColor) +"]";
	}
	
	
	
}