package com.mycompany.a2.GameObjects;

import com.mycompany.a2.Interfaces.ISteerable;

public class MissileGun extends Moveable implements ISteerable{	
	public MissileGun(double x, double y) {
		super.point_location(x, y);
		super.set_direction(0); // default direction to up north
		super.setColor(0, 142, 256); // no idea what this color is, randomly selected
	}
	
	
	public void steerLeft() {
		int currentDirection = super.get_direction();
		if(currentDirection == 0) {
			currentDirection = 360-10;	// change 0 to 360 to avoid negative angle
		}else currentDirection = currentDirection-10;
		super.set_direction(currentDirection);
		
	}

	
	public void steerRight() {
		int currentDirection = super.get_direction();
		if(currentDirection == 350) {
			currentDirection = 0;
		} else currentDirection = currentDirection + 10;
		super.set_direction(currentDirection);
		
	}
	public void move() {
		super.move();
	}
		

	public void set_Location(double x_loc, double y_loc) {
		super.point_location(x_loc, y_loc);
	}

	
	public String toString() {
		return "GUN: " + super.toString();
	}
	
	
	
}