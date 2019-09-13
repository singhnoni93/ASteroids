package com.mycompany.a2.GameView;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Component;
import com.codename1.ui.Label;
import com.codename1.ui.Container;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.mycompany.a2.Interfaces.IGameWorld;

public class ScoreView extends Container implements Observer{
	private Mylabel totalScore, totalMissiles, totalTime, sound, lives;
	
	
	public ScoreView() {
	this.setLayout(new FlowLayout(Component.LEFT));	
	this.getStyle().setBorder(Border.createLineBorder(2, ColorUtil.BLACK));
	
	//score label
	this.add(new Label("Score: "));
	totalScore = new Mylabel("-/-");
	this.add(totalScore);
	
	//missile label
	this.add(new Label("Missiles: "));
	totalMissiles = new Mylabel("-/-");
	this.add(totalMissiles);
	
	//time label
	this.add(new Label("Elapsed Time: "));
	totalTime = new Mylabel("-/-");
	this.add(totalTime);
	
	//sound label
	this.add(new Label("Sound:"));
	sound = new Mylabel("-/-");
	this.add(sound);
	
	//remaining lives label
	this.add(new Label("Lives: "));
	lives= new Mylabel("-/-");
	this.add(lives);
	
	}


	@Override
	public void update(Observable observable, Object data) {
		IGameWorld gw = (IGameWorld) data;
		totalScore.setText(""+gw.getScore());
		totalMissiles.setText(""+gw.getMissiles());
		totalTime.setText(""+gw.getElapsedTime());
		lives.setText(""+gw.getLives());
		
		if(gw.getSound() == true) {
			sound.setText("ON");
		}else {
			sound.setText("OFF");
		}
		this.repaint();
	}
	
}