package com.mycompany.a2.GameCommands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class ShipRightTurn extends Command{
	private GameWorld gw;
	
	public ShipRightTurn(GameWorld gw) {
		super("Ship_Right"); // command name
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		gw.turn_right(); // call adding asteroid function from gameworld.java
	}
	
}