package com.mycompany.a2.GameCommands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class AsteroidKill extends Command{
	private GameWorld gw;
	
	public AsteroidKill(GameWorld gw) {
		super("Asteroid_Kill"); // command name
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		gw.asteroid_killed(); // call adding asteroid function from gameworld.java
	}
	
}