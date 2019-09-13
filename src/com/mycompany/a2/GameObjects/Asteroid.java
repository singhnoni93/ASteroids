package com.mycompany.a2.GameObjects;

import java.util.Random;

public class Asteroid extends Moveable {
	private int size;
	private Random randomNum = new Random();;
	
	public Asteroid() {
		this.size = (1 + randomNum.nextInt(5));
		super.point_location(RandNumX(), RandNumY());
		super.set_speed( 1 + randomNum.nextInt(10));
		super.set_direction(0 + randomNum.nextInt(359));
		super.setColor(128, 128, 128);
		
	}
	
	
	public void move() {
		super.move();
	}
	
	public void setSize(int newSize) {
		this.size = newSize;
	}
	
	public int getsize() {
		return this.size;
	}

	// random numbers start from 1 because space station has location of (0,0), and asteroid can not start from this location
	private int RandNumX() {	// random number generator for location
		int random = 1 + randomNum.nextInt(1024); // location X
		return random;
	}
	private int RandNumY() {	// random number generator for location
		int random = 1 + randomNum.nextInt(768); // location y
		return random;
	}
	
	
	public String toString() {
		return "Asteroid: " + super.toString() + " size = " + this.size;
	}
	
	
}