package com.mycompany.a2;


import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.mycompany.a2.GameCommands.*;
import com.mycompany.a2.GameView.MapView;
import com.mycompany.a2.GameView.ScoreView;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.Container;


public class Game extends Form{
	private GameWorld gw;
	private MapView mv;	
	private ScoreView sv;	// views for MVC
	private Container leftButtons; // container for map
	private Accelerate ship_accelerate_command;
	private Button ship_accelerate_button;
	
	private AsteroidCollide asteroid_collide_command;
	private Button asteroid_collide_button;
	
	private AsteroidKill asteroid_kill_command;
	private Button asteroid_kill_button;
	
	private Asteroids add_asteroid_command;
	private Button add_asteroid_button;
	
	private DeAccelerate ship_deAccelerate_command;
	private Button 	ship_deAccelerate_button;
	
	private FireMissile missile_command;
	private Button missile_button;
	
	private HyperSpace hyperspace_command;
	private Button hyperspace_button;
	
	private MissileGunLeft gun_left_command;
	private Button gun_left_button;
	
	private MissileGunRight gun_right_command;
	private Button gun_right_button;
	
	private PrintMap map_command;
	private Button map_button;
	
	private Quit quit_command;
	private Button quit_button;
	
	private ReloadMissile reload_command;
	private Button reload_button;
	
	private Ship add_ship_command;
	private Button add_ship_button;
	
	private ShipCrash crash_command;
	private Button crash_button;
	
	private ShipLeftTurn turn_left_command;
	private Button turn_left_button;
	
	private ShipRightTurn turn_right_command;
	private Button turn_right_button;
	
	private Station add_station_command;
	private Button add_station_button;
	
	private Time time_command;
	private Button time_button;
	
	public Game() {
		gw = new GameWorld();
		mv = new MapView();
		mv.getAllStyles().setBorder(Border.createLineBorder(2));
		
		sv = new ScoreView();
		sv.setScrollableX(true);
		
		
		this.setTitle("Asteroid Game");
		
		
		this.setLayout(new BorderLayout());
		gw.addObserver(sv);
		this.add(BorderLayout.NORTH, sv);
		
		gw.addObserver(mv);
		this.add(BorderLayout.CENTER,mv); // add map view to center

		
		
		leftButtons = new Container(new BoxLayout(BoxLayout.Y_AXIS)); // button container for commands
		leftButtons.add(new Label("Ship Commands"));
		
		// add asteroid button
		add_asteroid_button = new Button("Asteroid");
		add_asteroid_command = new Asteroids(gw);
		add_asteroid_button.setCommand(add_asteroid_command);
		this.addKeyListener('a', add_asteroid_command);
		myBorder(add_asteroid_button);
		leftButtons.add(add_asteroid_button);
		
		// add Station button
		add_station_button = new Button("Station");
		add_station_command = new Station(gw);
		add_station_button.setCommand(add_station_command);
		this.addKeyListener('b', add_station_command);
		myBorder(add_station_button);
		leftButtons.add(add_station_button);
		
		
		// add Space ship button
		
		add_ship_button = new Button("Ship");
		add_ship_command = new Ship(gw);
		add_ship_button.setCommand(add_ship_command);
		this.addKeyListener('s', add_ship_command);
		myBorder(add_ship_button);
		leftButtons.add(add_ship_button);
		
		// accelerate
		ship_accelerate_button = new Button("Accelerate");
		ship_accelerate_command = new Accelerate(gw);
		ship_accelerate_button.setCommand(ship_accelerate_command);
		this.addKeyListener(-91 ,ship_accelerate_command); // up arrow
		myBorder(ship_accelerate_button);
		leftButtons.add(ship_accelerate_button);
		
		//deAccelerate
		ship_deAccelerate_button = new Button("DeAccelerate");
		ship_deAccelerate_command = new DeAccelerate(gw);
		ship_deAccelerate_button.setCommand(ship_deAccelerate_command);
		this.addKeyListener(-92,ship_deAccelerate_command); // down arrow
		myBorder(ship_deAccelerate_button);
		leftButtons.add(ship_deAccelerate_button);
		
		
		// turn left
		turn_left_button = new Button("Ship_Left");
		turn_left_command = new ShipLeftTurn(gw);
		turn_left_button.setCommand(turn_left_command);
		this.addKeyListener(-93, turn_left_command); // left arrow
		myBorder(turn_left_button);
		leftButtons.add(turn_left_button);
		
		// turn right
		turn_right_button = new Button("Ship_Right");
		turn_right_command = new ShipRightTurn(gw);
		turn_right_button.setCommand(turn_right_command);
		this.addKeyListener(-94, turn_right_command); // right arrow
		myBorder(turn_right_button);
		leftButtons.add(turn_right_button);
		
		// fire missile
		missile_button = new Button("Fire_Missile");
		missile_command = new FireMissile(gw);
		missile_button.setCommand(missile_command);
		this.addKeyListener('f', missile_command); // space key
		myBorder(missile_button);
		leftButtons.add(missile_button);
	
		//gun right
		gun_right_button = new Button("Gun_Right");
		gun_right_command = new MissileGunRight(gw);
		gun_right_button.setCommand(gun_right_command);
		this.addKeyListener('r', gun_right_command);
		myBorder(gun_right_button);
		leftButtons.add(gun_right_button);		

		//gun left
		gun_left_button = new Button("Gun_Left");
		gun_left_command = new MissileGunLeft(gw);
		gun_left_button.setCommand(gun_left_command);
		this.addKeyListener('l', gun_left_command);
		myBorder(gun_left_button);
		leftButtons.add(gun_left_button);		
		
		
		
		// jump hyper space
		hyperspace_button = new Button("HyperSpace");
		hyperspace_command = new HyperSpace(gw);
		hyperspace_button.setCommand(hyperspace_command);
		this.addKeyListener('j', hyperspace_command);
		myBorder(hyperspace_button);
		leftButtons.add(hyperspace_button);
		
		// reload missile
		reload_button = new Button("HyperSpace");
		reload_command = new ReloadMissile(gw);
		reload_button.setCommand(reload_command);
		this.addKeyListener('n', reload_command);
		myBorder(reload_button);
		leftButtons.add(reload_button);
		
		// asteroid killed
		asteroid_kill_button = new Button("Kill");
		asteroid_kill_command = new AsteroidKill(gw);
		asteroid_kill_button.setCommand(asteroid_kill_command);
		this.addKeyListener('k', asteroid_kill_command);
		myBorder(asteroid_kill_button);
		leftButtons.add(asteroid_kill_button);
		
		// ship crash
		crash_button = new Button("Crash");
		crash_command = new ShipCrash(gw);
		crash_button.setCommand(crash_command);
		this.addKeyListener('c', crash_command);
		myBorder(crash_button);
		leftButtons.add(crash_button);
		
		//asteroid collide
		asteroid_collide_button = new Button("Collide");
		asteroid_collide_command = new AsteroidCollide(gw);
		asteroid_collide_button.setCommand(asteroid_collide_command);
		this.addKeyListener('x', asteroid_collide_command);
		myBorder(asteroid_collide_button);
		leftButtons.add(asteroid_collide_button);

		//time function
		time_button = new Button("Time");
		time_command = new Time(gw);
		time_button.setCommand(time_command);
		this.addKeyListener('t', time_command);
		myBorder(time_button);
		leftButtons.add(time_button);		
	

		//print map
		map_button = new Button("Map");
		map_command = new PrintMap(gw);
		map_button.setCommand(map_command);
		this.addKeyListener('m', map_command);
		myBorder(map_button);
		leftButtons.add(map_button);		
		
		//quit
		quit_button = new Button("Quit");
		quit_command = new Quit(gw);
		quit_button.setCommand(quit_command);
		this.addKeyListener('q', quit_command);
		myBorder(quit_button);
		leftButtons.add(quit_button);		


		leftButtons.getAllStyles().setBgColor(ColorUtil.WHITE);
		leftButtons.getAllStyles().setPadding(5, 5, 2, 2);		
		add(BorderLayout.WEST,leftButtons);	
		this.show();
		
		gw.setWidth(mv.getWidth());
		gw.setHeight(mv.getHeight());
		
		
		
	}
	private void myBorder(Button myButton) {
		myButton.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLACK));
		}

}