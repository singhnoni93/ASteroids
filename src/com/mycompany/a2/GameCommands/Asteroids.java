package com.mycompany.a2.GameCommands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class Asteroids extends Command{
	private GameWorld gw;
	
	public Asteroids(GameWorld gw) {
		super("Asteroid"); // command name
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		gw.add_asteroid(); // call adding asteroid function from gameworld.java
	}
	
}