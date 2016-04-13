package com.nosheep.map;

import com.nosheep.assets.AssetLoader;
import com.nosheep.enemy.Bat;
import com.nosheep.main.rpgGame;
import com.nosheep.player.Player;
import com.nosheep.tools.Portal;

public class BatCave extends Map{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6281733520034499892L;

	public BatCave(Player player){
		super(player);
	}

	@Override
	public void init(Player player) {
		name = "";
		area = "Bat Cave";
		setImage(AssetLoader.rock);
		setWeatherRotaion(false);
		setWeather(Map.Weather.sunny);
		enemies.add(new Bat(3));
		enemies.add(new Bat(3));
		enemies.add(new Bat(3));
		
		Portal caveExit = new Portal(player, 1640, 160, true);
		caveExit.setType(Portal.Type.ZONE);
		caveExit.setZone(rpgGame.hauntedWoods);
		caveExit.setMapIndex((byte)(30));
		portals.add(caveExit);
		super.init(player);
	}
	
}
