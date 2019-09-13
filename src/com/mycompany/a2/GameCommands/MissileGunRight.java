package com.mycompany.a2.GameCommands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class MissileGunRight extends Command{
	private GameWorld gw;
	
	public MissileGunRight(GameWorld gw) {
		super("Gun_Right"); // command name
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		gw.gun_right(); // call adding asteroid function from gameworld.java
	}
	
}