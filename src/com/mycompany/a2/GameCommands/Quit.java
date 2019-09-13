package com.mycompany.a2.GameCommands;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class Quit extends Command{
	private GameWorld gw;
	
	public Quit(GameWorld gw) {
		super("Quit"); // command name
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Boolean b = Dialog.show("Confirm quit", "Are you sure you want to quit?", "Ok", "Cancel"); 
		if (b)
		{
			Display.getInstance().exitApplication(); 
		} 
	}
	
}