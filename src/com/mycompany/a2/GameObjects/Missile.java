package com.mycompany.a2.GameObjects;

public class Missile extends Moveable{
	
	private int fuel;
	
	public Missile(int direction, int speed, double x, double y) {
		super.set_direction(direction); // set current direction of missile, gets from missile gun/spaceship heading
		super.set_speed(speed+10); 		// sets initial speed of missile when fired
		super.point_location(x, y);// sets location of missile when fired, gets from spaceship
		this.fuel = 10;
		super.setColor(255, 255, 0);
	}
	
	public void move() {	// as move function is invoked, it reduces fuel level by 1 unit
		this.fuel -= 1;
		super.move();
	}
	
	public void set_fuel(int fuelLevel) { // setting fuel of missile
		this.fuel = fuelLevel;
	}
	
	public int get_fuel() {	 // returns fuel level of missile
		return this.fuel;
	}
	
	public String toString() {
		return "Missile: " + super.toString() + " fuel= " + this.fuel; 
	}
	
	
	
}