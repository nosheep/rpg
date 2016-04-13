package com.nosheep.map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nosheep.enemy.UnknownWizard;
import com.nosheep.assets.AssetLoader;
import com.nosheep.player.Player;

public class Unknown extends Map{

	/**
	 * 
	 */
	private static final long serialVersionUID = -500973872251528014L;

	public Unknown(Player player){
		super(player);
		setArea("??????");
		setName("??????");
		setImage(AssetLoader.rock);
		setWeatherRotaion(false);
		setWeather(Map.Weather.sunny);
		enemies.add(new UnknownWizard(-1));
	}
	
	@Override
	public void render(SpriteBatch batch) {
		super.render(batch);
	}
	
	@Override
	public void renderEnvironment(SpriteBatch batch) {
		super.renderEnvironment(batch);
		batch.draw(AssetLoader.bloodstain, 500, 300, 96, 128);
		batch.draw(AssetLoader.bones, 210, 1110, 96, 96);
		batch.draw(AssetLoader.bloodstain, 1510, 1010, 96, 128);
		batch.draw(AssetLoader.bones, 1510, 1010, 96, 96);
		batch.draw(AssetLoader.bones, 510, 310, 96, 96);
		batch.draw(AssetLoader.bones, 710, 810, 96, 96);
		batch.draw(AssetLoader.bones, 1210, 610, 96, 96);
	}
	
}
