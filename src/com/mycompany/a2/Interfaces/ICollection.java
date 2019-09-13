package com.mycompany.a2.Interfaces;

import com.mycompany.a2.GameObjects.GameObject;

public interface ICollection {
	public void addObject(GameObject obj);
	public IIterator getIterator();
	public void remove(GameObject obj);
}
