package com.mycompany.a2.GameCommands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class PrintMap extends Command{
	private GameWorld gw;
	
	public PrintMap(GameWorld gw) {
		super("Map"); // command name
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		gw.print_map();; // call adding asteroid function from gameworld.java
	}
	
}