package com.mycompany.a2.GameCommands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class ShipCrash extends Command{
	private GameWorld gw;
	
	public ShipCrash(GameWorld gw) {
		super("Ship_Crash"); // command name
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		gw.ship_crash();; // call adding asteroid function from gameworld.java
	}
	
}