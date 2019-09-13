package com.mycompany.a2.GameObjects;

import java.util.ArrayList;
import com.mycompany.a2.Interfaces.ICollection;
import com.mycompany.a2.Interfaces.IIterator;

public class GameObjectCollection implements ICollection{
	private ArrayList<GameObject> gameObjects;
	
	// constructor
	public GameObjectCollection() {
		gameObjects = new ArrayList<GameObject>();
	}
	
	public void addObject(GameObject obj) {
		gameObjects.add(obj); 
		
	}

	public IIterator getIterator() {
		return new GameObjectIterator();
	}

	
	public void remove(GameObject obj) {
		gameObjects.remove(obj);
		
	}
	
	
	private class GameObjectIterator implements IIterator{
		private int currentIndex = -1;
		
		public boolean hasnext() {
			if(currentIndex < gameObjects.size() - 1)
				return true;
			return false;
		}

		public GameObject getNext() {
			if(hasnext() == true) {
			return gameObjects.get(++currentIndex);
			} return null;
				
		}
		
	}


	
}