package com.mycompany.a2.Interfaces;

import com.mycompany.a2.GameObjects.GameObjectCollection;

public interface IGameWorld {

	public int getScore();
	public int getMissiles();
	public int getElapsedTime();
	public boolean getSound();
	public int getLives();
	public GameObjectCollection getObjects();
	
	
}
