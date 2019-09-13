package com.mycompany.a2.GameCommands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class HyperSpace extends Command{
	private GameWorld gw;
	
	public HyperSpace(GameWorld gw) {
		super("HyperSpace"); // command name
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		gw.jump_hyperspace(); // call adding asteroid function from gameworld.java
	}
	
}