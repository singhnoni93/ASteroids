package com.mycompany.a2.GameObjects;

import com.mycompany.a2.Interfaces.IMoveable;

public abstract class Moveable extends GameObject implements IMoveable{

	private int speed;
	private int direction;
	
	// constructor
	public  Moveable() {
		speed = 0;   
		direction = 0; 
	}
		// +++++++++++++++++++++++set color for the object R,G,B+++++++++++++++++++++++
	
	public Moveable(int r, int g, int b) {
		super.setColor(r, g, b);
	}
	
	
	//+++++++++++++++++implement MOVE method++++++++++++++++++++
	public void move() {
		double theta = 90 - this.direction;
		float deltaX = (float)Math.cos(Math.toRadians(theta))  * this.speed;
		float deltaY = (float)Math.sin(Math.toRadians(theta)) * this.speed;
		//super.set_location(deltaX + super.get_x(), deltaY + super.get_y());
		super.point_location(deltaX + super.get_x(), deltaY + super.get_y());
		
	}
	
	// getters and setters for speed and direction
	public void set_speed(int newS) {
		this.speed = newS;
	}
	public int get_speed() {
		return this.speed;
	}
	
	public void set_direction(int newD) {
		this.direction = newD;
	}
	public int get_direction() {
		return this.direction;
	}
	
	// prints speed and direction
	public String toString() {
		// added super.toString() to print location from parent class i.e. Objects.java
		return super.toString() + " Speed=" + this.speed + " Direction=" + this.direction + " ";
	}
	
	
	
	
	
}