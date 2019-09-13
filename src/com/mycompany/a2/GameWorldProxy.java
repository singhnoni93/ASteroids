package com.mycompany.a2;

import java.util.Observable;

import com.mycompany.a2.GameObjects.GameObjectCollection;
import com.mycompany.a2.Interfaces.IGameWorld;

public class GameWorldProxy extends Observable implements IGameWorld{

	private GameWorld gw;
	
	
	public GameWorldProxy(GameWorld gameWorld) {
		gw = gameWorld;
	}
	
	/*
	 * 
	 * (non-Javadoc)
	 * @see com.mycompany.a2.Interfaces.IGameWorld#getPoints()
	 */
	public int getScore() {
		return gw.getScore();
	}

	/*
	 * (non-Javadoc)
	 * @see com.mycompany.a2.Interfaces.IGameWorld#getMissiles()
	 */
	public int getMissiles() {
		return gw.getMissiles();
	}
	
	/* 
	 * (non-Javadoc)
	 * @see com.mycompany.a2.Interfaces.IGameWorld#getElapsedTime()
	 */
	
	public int getElapsedTime() {
		return gw.getTime();
	}
	/*
	 * (non-Javadoc)
	 * @see com.mycompany.a2.Interfaces.IGameWorld#getSound()
	 */

	public boolean getSound() {
		return gw.getSound();
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.mycompany.a2.Interfaces.IGameWorld#getLives()
	 */

	
	public int getLives() {
		return gw.getLives();
	}

	/*
	 * (non-Javadoc)
	 * @see com.mycompany.a2.Interfaces.IGameWorld#getObjects()
	 */
	public GameObjectCollection getObjects() {
		return gw.getObjects();
	}
	
	
	
	
	
	
	
}