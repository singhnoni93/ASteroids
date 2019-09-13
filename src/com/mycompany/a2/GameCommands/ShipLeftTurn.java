package com.mycompany.a2.GameCommands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class ShipLeftTurn extends Command{
	private GameWorld gw;
	
	public ShipLeftTurn(GameWorld gw) {
		super("Ship_Left"); // command name
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		gw.turn_left(); // call adding asteroid function from gameworld.java
	}
	
}