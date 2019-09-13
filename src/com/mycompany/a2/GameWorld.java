package com.mycompany.a2;

import java.util.Observable;
import java.util.Random;

import com.codename1.ui.geom.Point2D;
import com.mycompany.a2.GameCommands.Ship;
import com.mycompany.a2.GameObjects.Asteroid;
import com.mycompany.a2.GameObjects.*;
import com.mycompany.a2.GameObjects.GameObjectCollection;
import com.mycompany.a2.GameObjects.SpaceShip;
import com.mycompany.a2.Interfaces.IGameWorld;
import com.mycompany.a2.Interfaces.IIterator;
import com.mycompany.a2.Interfaces.IMoveable;
@SuppressWarnings("unused")
public class GameWorld extends Observable implements IGameWorld{
	
	private GameObjectCollection gameObjects;
	private Asteroid myAsteroid;
	private SpaceShip myShip;
	private MissileGun myGun;
	private SpaceStation myStation;
	private Missile myMissile;
	private int time;
	private int score;
	private int lives;
	private int missileCount;
	private boolean sound;
	private Point2D point;
	private Random rand;
	private IIterator itr;
	
	
	
	public GameWorld() {
		point = new Point2D(0,0);
		this.init();
	}
	
	public void init() {
		gameObjects = new GameObjectCollection();
		this.time = 0;
		this.score = 0;
		this.lives = 3;	
	}

	// add asteroid
	public void add_asteroid() {
		System.out.println("Asteroid added!!");
		myAsteroid = new Asteroid();
		gameObjects.addObject(myAsteroid);
		setChanged();
		notifyObservers(new GameWorldProxy(this));
	}
	
	
	public void add_station() {
		System.out.println("Station added");
		myStation = new SpaceStation();
		gameObjects.addObject(myStation);
		setChanged();
		notifyObservers(new GameWorldProxy(this));
		
	}
	public void add_Ship() {
		itr = gameObjects.getIterator();
		
		while(itr.hasnext() == true) {
			GameObject obj = itr.getNext();
			if(obj instanceof SpaceShip) {
				System.out.println("Ship already in map!!!");	
				return;
			}
		}
		if(lives<=0) {
			System.out.println("You are out of lives!!!");
			System.exit(0);
		}
		myShip = new SpaceShip();
		myGun = new MissileGun(myShip.get_x(), myShip.get_y());
		missileCount = myShip.get_missile();
		System.out.println("Ship created!!!");
		gameObjects.addObject(myShip);
		gameObjects.addObject(myGun);
		setChanged();
		notifyObservers(new GameWorldProxy(this));
	}
	
	public void accelerate() {
		SpaceShip s = null;
		itr = gameObjects.getIterator();
		while(itr.hasnext()) {
			GameObject obj = itr.getNext();
			if(obj instanceof SpaceShip) {
				s= (SpaceShip) obj;
			}
		}
		if(s== null) {
			System.out.println("No Ship in Game!!!");
		}
		else {
			s.accelerate();
		}
		setChanged();
		notifyObservers(new GameWorldProxy(this));
	}
	public void de_accelerate() {
		SpaceShip s = null;
		itr = gameObjects.getIterator();
		while(itr.hasnext()) {
			GameObject obj = itr.getNext();
			if(obj instanceof SpaceShip) {
				s= (SpaceShip) obj;
			}
		}
		if(s== null) {
			System.out.println("No Ship in Game!!!");
		}
		else {
			s.deAccelerate();
		}
		setChanged();
		notifyObservers(new GameWorldProxy(this));
	}
	public void turn_left() {
		SpaceShip s = null;
		itr = gameObjects.getIterator();
		while(itr.hasnext()) {
			GameObject obj = itr.getNext();
			if(obj instanceof SpaceShip) {
				s= (SpaceShip) obj;
			}
		}
		if(s== null) {
			System.out.println("No Ship in Game!!!");
		}
		else {
			s.steerLeft();
		}
		setChanged();
		notifyObservers(new GameWorldProxy(this));
	}
	
	public void turn_right() {
		SpaceShip s = null;
		itr = gameObjects.getIterator();
		while(itr.hasnext()) {
			GameObject obj = itr.getNext();
			if(obj instanceof SpaceShip) {
				s= (SpaceShip) obj;
			}
		}
		if(s== null) {
			System.out.println("No Ship in Game!!!");
		}
		else {
			s.steerRight();
		}
		setChanged();
		notifyObservers(new GameWorldProxy(this));
	}
	public void fire_missile() {
		SpaceShip s = null;
		itr = gameObjects.getIterator();
		while(itr.hasnext()) {
			GameObject obj = itr.getNext();
			if(obj instanceof SpaceShip) {
				s= (SpaceShip) obj;
			}
		}
		if(s== null) {
			System.out.println("No Ship in Game!!!");
		}
		else {
			myMissile = new Missile(myGun.get_direction(),s.get_speed(),s.get_x(),s.get_y());
			s.fire_missile(); // get directions from gun and speed from ship and location from shp
			this.missileCount = s.get_missile();
			gameObjects.addObject(myMissile);
		}
		
		setChanged();
		notifyObservers(new GameWorldProxy(this));
	}
	public void jump_hyperspace() {
		SpaceShip s = null;
		itr = gameObjects.getIterator();
		while(itr.hasnext()) {
			GameObject obj = itr.getNext();
			if(obj instanceof SpaceShip) {
				s= (SpaceShip) obj;
			}
		}
		if(s== null) {
			System.out.println("No Ship in Game!!!");
		}
		else {
			s.defaultLocation();
			System.out.println("Jumped to HyperSpace\n"+s.toString());
		}
		setChanged();
		notifyObservers(new GameWorldProxy(this));
	}
	public void reload_missile() {
		
		SpaceShip s = null;
		itr = gameObjects.getIterator();
		while(itr.hasnext()) {
			GameObject obj = itr.getNext();
			if(obj instanceof SpaceShip) {
				s= (SpaceShip) obj;
			}
		}
		if(s== null) {
			System.out.println("No Ship in Game!!!");
		}
		else {
			s.reload_missile();
			this.missileCount = 10;
		}
		setChanged();
		notifyObservers(new GameWorldProxy(this));
	}
	public void asteroid_killed() {
		Asteroid a = null;
		Missile m = null;
		itr = gameObjects.getIterator();
		while(itr.hasnext()) {
			GameObject obj = itr.getNext();
			if(obj instanceof Asteroid && a == null) {
				a = (Asteroid) obj;
			}
			if(obj instanceof Missile && m == null) {
				m = (Missile) obj;
			}
		}
		if(m == null) {
			System.out.println("No Miisile in Game!!!");
			return;
		}
		if(a==null) {
			System.out.println("No Asteroid in Game!!!");
			return;
		}
		gameObjects.remove(m);
		gameObjects.remove(a);
		this.score += 100;
		setChanged();
		notifyObservers(new GameWorldProxy(this));
	}
	public void ship_crash() {
		Asteroid a = null;
		SpaceShip s = null;
		MissileGun g = null;
		itr = gameObjects.getIterator();
		while(itr.hasnext()) {
			GameObject obj = itr.getNext();
			if(obj instanceof Asteroid && a == null) {
				a = (Asteroid) obj;
			}
			if(obj instanceof SpaceShip && s == null) {
				s = (SpaceShip) obj;
			}
			if(obj instanceof MissileGun && g == null) {
				g = (MissileGun) obj;
			}
		}
		if(s == null) {
			System.out.println("No Ship in Game!!!");
			return;
		}
		if(a==null) {
			System.out.println("No Asteroid in Game!!!");
			return;
		}
		gameObjects.remove(s);
		gameObjects.remove(a);
		gameObjects.remove(g);
		System.out.println("CRASH: Ship collided with ASteroid");
		this.lives--;
		if(this.lives<=0) {
			System.out.println("No more lives remaining\nGAME OVER!!!!");
			System.exit(0);
		}
		setChanged();
		notifyObservers(new GameWorldProxy(this));
	}
	public void asteroid_collided() {
		Asteroid a1 = null;
		Asteroid a2 = null;
		itr = gameObjects.getIterator();
		while(itr.hasnext()) {
			
			GameObject obj = itr.getNext();
			if(a1 == null && obj instanceof Asteroid) {
				a1 = (Asteroid) obj;
				obj = itr.getNext();
			}
		
			if(a2 == null && obj instanceof Asteroid ){
				a2 = (Asteroid) obj;
			}
		}
		if(a1 == null) {
			System.out.println("Not enough asteroids in Game!!!");
			return;
		}
		if(a2 == null) {
			System.out.println("Only one asteroid found");
			return;
		}
		gameObjects.remove(a1);
		gameObjects.remove(a2);
		System.out.println("2 Asteroids collided!!!");
		this.score += 100;
		setChanged();
		notifyObservers(new GameWorldProxy(this));
	}
	public void game_clock() {
		itr = gameObjects.getIterator();
		double x_loc = 0;
		double y_loc = 0;
		while(itr.hasnext()) {
			GameObject obj = itr.getNext();
			if(obj instanceof IMoveable ) {
				IMoveable mObj = (IMoveable) obj;
				mObj.move();
				if(obj instanceof SpaceShip) { // if ship found, save the location
					x_loc = ((SpaceShip)obj).get_x();
					y_loc = ((SpaceShip)obj).get_y();
				}
				if(obj instanceof MissileGun) {
					((MissileGun)obj).set_Location(x_loc, y_loc); // change the location of gun to ships new location
				}
				
			}
			if(obj instanceof Missile && ((Missile) obj).get_fuel() == 0) {
				gameObjects.remove(obj);
			}
			if(obj instanceof SpaceStation) {
				if(this.time % (((SpaceStation) obj).getBlinkRate()) == 0) {
					((SpaceStation) obj).blinkColor();
				}
			}			
		}
		System.out.println("Time Ticked by 1 unit");
		this.time++;
		setChanged();
		notifyObservers(new GameWorldProxy(this));
	}
	public void print_map() {
		System.out.println("-----------------------Printing Current Updated Map--------------------------------");
		itr = gameObjects.getIterator();
		while(itr.hasnext()) {
			GameObject obj = itr.getNext();
			obj.toString();	
		}
		setChanged();
		notifyObservers(new GameWorldProxy(this));
		System.out.println("-----------------------------------------------------------------------------------\n\n");
		
	}
	
	public void gun_left() {
		SpaceShip s = null;
		itr = gameObjects.getIterator();
		while(itr.hasnext()) {
			GameObject obj = itr.getNext();
			if(obj instanceof SpaceShip) {
				s = (SpaceShip) obj;
			}
		}
		if(s == null) {
			System.out.println("No ship in game!!!");
			return;
		}
		myGun.steerLeft();		
		System.out.println("gun left");
		setChanged();
		notifyObservers(new GameWorldProxy(this));
	}
	public void gun_right() {
		SpaceShip s = null;
		itr = gameObjects.getIterator();
		while(itr.hasnext()) {
			GameObject obj = itr.getNext();
			if(obj instanceof SpaceShip) {
				s = (SpaceShip) obj;
			}
		}
		if(s == null) {
			System.out.println("No ship in game!!!");
			return;
		}
		myGun.steerRight();		
		System.out.println("gun Right");
		setChanged();
		notifyObservers(new GameWorldProxy(this));
	}
	
	public int getScore() {
		return this.score;
	}
	
	public int getTime() {
		return this.time;
	}

	public int getLives() {
		return this.lives;
	}
	public int getMissiles() {
		return this.missileCount;
	}

	public boolean getSound() {
		return this.sound;
	}
	
	public void setSound(boolean newSound) {
		this.sound = newSound;
		setChanged();
		notifyObservers(new GameWorldProxy(this));
	}

	public GameObjectCollection getObjects() {
		return gameObjects;
	}
	
	public int getElapsedTime() {
		return this.time;
	}

	public void setWidth(int width2) {
		point.setX(width2);
		
	}

	public void setHeight(int height2) {
		point.setY(height2);
		
	}
	
}