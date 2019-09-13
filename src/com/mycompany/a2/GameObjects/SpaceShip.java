package com.mycompany.a2.GameObjects;

import com.mycompany.a2.Interfaces.ISteerable;

public class SpaceShip extends Moveable implements ISteerable{
	
	private int missileCount = 10;
	
	public SpaceShip() {
		super.point_location(512,384); // default location
		super.point_location(512, 384);
		super.set_speed(0);	// speed set to 0
		super.set_direction(0); // setting to north
		super.setColor(0, 255, 0);
	}
	
	public SpaceShip(int x, int y, int speed, int direction, int r, int g, int b) {
		super.point_location(x, y);
		super.set_speed(speed);
		super.set_direction(direction);
		super.setColor(r, g, b);	
	}
	
	public void defaultLocation() {
		this.set_speed(0);
		this.point_location(512, 384);
		this.set_direction(0);
	}
	
	public void move() {
		super.move();
	}
	
	public int get_speed() {
		return super.get_speed();
	}
		
	// missile fire method
	public void fire_missile() {	// user enters command 'f'
		if(missileCount <= 0) { // checks if ship has fired all of its missiles
			missileCount = 0;
			System.out.println("Ship has fired all of its missiles. Please return to Space Station to reload.\n");
		}else {
			System.out.println("Ship fired a missile :)");
			missileCount--; 
			System.out.println("Remaining missiles = " + missileCount);
		}
			 
	}
	
	public int get_missile() {
		return this.missileCount;
	}
	
	// reload missile function
	public void reload_missile() { // ship goes to space station or user enters command 'n'
		if(missileCount == 10) {
			System.out.println("Captain, Your ship is already locked and loaded to the MAXIMUM\n");
		}else {
			this.missileCount = 10;
			System.out.println("Captain, Your ship is reloaded to the MAXIMUM\n");
		}
	}
	
	
	
	//*************************************MAKE SURE -10 DOESNT GOTO NEGATIVE*********************
	// implementing ISteerable interface
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
	
	// methods to control speed
	public void accelerate() {
		int speed = super.get_speed();	// gets current speed of the ship 
		if(speed == 10) {
			System.out.println("Captain, we are cruising at the MAXIMUM SPEED !!\n");
		}else {
			super.set_speed(speed+1);	// increment speed by 1 
			System.out.println("Captain, our current speed is "+ super.get_speed());
		}
		
	}
	public void deAccelerate() {
		int speed = super.get_speed();
		if(speed == 0) {
			System.out.println("Captain, the ship is already stopped !!\n");
		}else {
			super.set_speed(speed-1);	// decrement speed by 1
			System.out.println("Captain, our current speed is "+ super.get_speed());
		}
		
	}
	
	public void set_Location(int x, int y) {
		super.point_location(x, y);
	}
	
	public String toString() {
		return "Ship: " + super.toString() + " Missiles=" + missileCount ;
	}
	
	
	
}