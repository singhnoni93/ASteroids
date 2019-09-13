package com.mycompany.a2.GameCommands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class ReloadMissile extends Command{
	private GameWorld gw;
	
	public ReloadMissile(GameWorld gw) {
		super("Reload_Missile"); // command name
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		gw.reload_missile();; // call adding asteroid function from gameworld.java
	}
	
}