package com.mycompany.a2.GameObjects;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;

public class SpaceStation extends FixedObject{
	private int blinkRate;

	public SpaceStation() {
		super.set_location(0, 0);
		super.setColor(0, 0, 142); // navy blue 
		blinkRate = rate();
	}
	
	private int rate() {
		Random rand = new Random();
		return (1 + rand.nextInt(10));	
	}
	
	public int getBlinkRate() {
		return this.blinkRate;
	}
	
	/*
	 * following function switches blinking colors from space station
	 */
	public void blinkColor() {
		if(this.getColor() == ColorUtil.rgb(0, 0, 142)) { // if navy blue
			this.setColor(255, 0, 0);	// set blinking to red
		}
		else if(this.getColor() == ColorUtil.rgb(255,0,0)) {	// if red
			this.setColor(0, 0, 142);	// set blinking to navy blue
		}
	}
	
		
	public String toString() {
		return "SpaceStation: " + super.toString() + " Blink Rate: "+ this.blinkRate + " Missile Supply: UNLIMITED";
	}
	
	
}