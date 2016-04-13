package com.nosheep.player;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import javax.swing.JOptionPane;

import com.nosheep.assets.AssetLoader;
import com.nosheep.enemy.Enemy;
import com.nosheep.main.rpgGame;
import com.nosheep.map.Map;
import com.nosheep.tools.InventorySlot;
import com.nosheep.tools.Window;

public class Data {
	
	private static boolean windowFlag = false;
	
	public static Player load(String userName){
		Player player = null;
		try{
			System.out.println("Fetching data..");
			FileInputStream fis = new FileInputStream(userName);
			ObjectInputStream ois = new ObjectInputStream(fis);
			player = (Player) ois.readObject();
			ois.close();
		}
		catch(FileNotFoundException ex){
			player = new Player(userName, 700, 500, 90, 100, 1);
			/*player.bag.add(new BeginnerStaff());
			player.bag.add(new BeginnerBow());
			player.bag.add(new BeginnerSword());*/
		}
		catch(NotSerializableException ex){
			ex.printStackTrace();
			player.hasTarget = false;
		}
		catch(IOException ex){
			ex.printStackTrace();
			player = new Player(userName, 700, 500, 90, 100, 1);
			/*player.bag.add(new BeginnerStaff());
			player.bag.add(new BeginnerBow());
			player.bag.add(new BeginnerSword());*/
		}
		catch(ClassNotFoundException ex){
			ex.printStackTrace();
		}
		catch(Exception ex){
			player = new Player(userName, 700, 500, 90, 100, 1);
			/*player.bag.add(new BeginnerStaff());
			player.bag.add(new BeginnerBow());
			player.bag.add(new BeginnerSword());*/
		}
		System.out.println(player.getName());
		for(Window w : rpgGame.windows){
			if(w.equals(player.getBag()))
				windowFlag = true;
				break;
		}
		if(!windowFlag){
			rpgGame.windows.add(player.getBag());
			rpgGame.windows.add(player.getCharacterMenu());
			rpgGame.windows.add(player.getMap());
		}
		
		if(player.getMainHand() != null){
			player.getMainHand().init();
			player.getMainHand().direction = player.getDirection();
		}
		if(player.getBody() != null){
			player.getBody().init();
			player.getBody().direction = player.getDirection();
		}
		if(player.getLegs() != null){
			player.getLegs().init();
			player.getLegs().direction = player.getDirection();
		}
		if(player.getBackpiece() != null){
			player.getBackpiece().init();
			player.getBackpiece().direction = player.getDirection();
		}
		if(player.getHelmet() != null){
			player.getHelmet().init();
			player.getHelmet().direction = player.getDirection();
		}
		
		for(InventorySlot s : player.getBag().slots){
			if(s.getWeapon() != null)
				s.getWeapon().init();
			if(s.getBody() != null)
				s.getBody().init();
			if(s.getLegs() != null)
				s.getLegs().init();
			if(s.getBackpiece() != null)
				s.getBackpiece().init();
			if(s.getBackpiece() != null)
				s.getBackpiece().init();
			if(s.getHelmet() != null)
				s.getHelmet().init();
		}
		
		player.getBag().setActive(false);
		player.getCharacterMenu().setActive(false);
		player.getMap().setActive(false);
		player.hasTarget = false;
		player.autoAttacking = false;
		player.activeSkills.clear();
		player.skillRemove.clear();
		player.outOfRange = false;

		new AssetLoader();
		
		for(Enemy e : rpgGame.map.get(rpgGame.mapIndex).enemies){
			e.init();
			e.setTarget(false);
			e.setCurrentHealth(e.getMaxHealth());
		}
		
		player.initAssets();
		
		if(player.zone != null && player.mapIndex != -1) {
			for(Map m : player.zone)
				m.init(player);
			rpgGame.map = rpgGame.zone.get(1);
			rpgGame.mapIndex = 45;
			rpgGame.map = player.zone;
			rpgGame.mapIndex = player.mapIndex;
		}
		
		return player;
	}
	public static void save(Player player){
		try{
			FileOutputStream fos = new FileOutputStream(player.getName());
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(player);
			oos.close();
		}
		catch(NotSerializableException ex){
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public static void loadJSON(){
		
	}
	public static void saveJSON(){
		
	}
}
