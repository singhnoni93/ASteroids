package com.mycompany.a2.GameView;


import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.plaf.Border;
import com.mycompany.a2.GameObjects.GameObject;
import com.mycompany.a2.Interfaces.IGameWorld;
import com.mycompany.a2.Interfaces.IIterator;

public class MapView extends Container implements Observer{
	
	public MapView() {
		this.getStyle().setBorder(Border.createLineBorder(2, ColorUtil.BLACK));
	}

	@Override
	public void update(Observable observable, Object data) {
		IGameWorld gw = (IGameWorld) data;
		System.out.println("");
		IIterator itr = gw.getObjects().getIterator();
		if(!itr.hasnext()) {
			System.out.println("Game World is empty!!!!");
		}
		
		while(itr.hasnext()) {
			GameObject obj = (GameObject) itr.getNext();
			System.out.println(obj);
		}	
	}
	
}