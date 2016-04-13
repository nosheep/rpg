package com.nosheep.map;

import com.nosheep.assets.AssetLoader;
import com.nosheep.enemy.Stump;
import com.nosheep.player.Player;

public class CrazyStumps3 extends Map{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2590419585636070379L;

	public CrazyStumps3(Player player) {
		super(player);
	}
	
	@Override
	public void init(Player player) {
		setName("Crazy Stumps 3");
		setArea("Haunted Woods");
		setImage(AssetLoader.moss);
		setWeatherRotaion(true);
		setWeather(Weather.sunny);
		
		enemies.add(new Stump(1));
		enemies.add(new Stump(1));
		
		borderLeft = AssetLoader.treeBorderLeft;
		borderDown = AssetLoader.treeBorderDown;
		super.init(player);
	}
	
}
