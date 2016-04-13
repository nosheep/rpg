package com.nosheep.map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nosheep.enemy.Bat;
import com.nosheep.enemy.KingBat;
import com.nosheep.assets.AssetLoader;
import com.nosheep.main.rpgGame;
import com.nosheep.player.Player;
import com.nosheep.tools.Portal;

public class AlphaCave1 extends Map{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3379141457661621318L;
	private Portal caveExit;
	
	public AlphaCave1(Player player){
		super(player);
		name = "Cave1";
		area = "Alpha Caves";
		setImage(AssetLoader.rock);
		setWeatherRotaion(false);
		setWeather(Map.Weather.sunny);
		enemies.add(new Bat(10));
		enemies.add(new Bat(10));
		enemies.add(new Bat(10));
		enemies.add(new Bat(10));
		enemies.add(new Bat(10));
		enemies.add(new Bat(10));
		enemies.add(new KingBat(20));
		enemies.get(6).setAlive(false);
		
		Portal caveExit = new Portal(player, 1540, 360, true);
		caveExit.setType(Portal.Type.ZONE);
		caveExit.setZone(rpgGame.kingsForest);
		caveExit.setMapIndex((byte)(27));
		portals.add(caveExit);
		
	}
	
	@Override
	public void render(SpriteBatch batch) {
		super.render(batch);
		for(Portal p : portals){
			p.render(batch);
		}
	}

	public Portal getCaveExit() {
		return caveExit;
	}

	public void setCaveExit(Portal caveExit) {
		this.caveExit = caveExit;
	}
}
