package com.mycompany.a2.GameObjects;

public abstract class FixedObject extends GameObject{	// space station
	private static int uniqueId = 1;
	private int id;
	
	public FixedObject() {
		id = uniqueId;
		FixedObject.uniqueId++;		
	}
	
	public void set_location(int getX, int getY) {
		super.point_location(getX, getY);
	}
	
	public int getID() {
		return this.id;
	}
	public String toString() {
		return super.toString() + " ID = " + this.id;
	}
	
	
	
}