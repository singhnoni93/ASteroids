package com.mycompany.a2.GameCommands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class MissileGunLeft extends Command{
	private GameWorld gw;
	
	public MissileGunLeft(GameWorld gw) {
		super("Gun_Left"); // command name
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		gw.gun_left(); // call adding asteroid function from gameworld.java
	}
	
}