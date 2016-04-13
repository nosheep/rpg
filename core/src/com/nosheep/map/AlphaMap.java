package com.nosheep.map;

import com.nosheep.assets.AssetLoader;
import com.nosheep.enemy.Stump;
import com.nosheep.objects.RegularTree;
import com.nosheep.player.Player;


public class AlphaMap extends Map{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1233253998578034487L;

	public AlphaMap(Player player) {
		super(player);
		name = "Crazy Stumps 1";
		area = "Forest of Alpha";
		setImage(AssetLoader.moss);
		setWeatherRotaion(true);
		setWeather(Map.Weather.sunny);
		trees.add(new RegularTree(400, 100));
		trees.add(new RegularTree(600, 200));
		trees.add(new RegularTree(200, 300));
		trees.add(new RegularTree(300, 400));
		trees.add(new RegularTree(900, 500));
		trees.add(new RegularTree(1200, 600));
		trees.add(new RegularTree(1400, 700));
		trees.add(new RegularTree(100, 800));
		trees.add(new RegularTree(200, 900));
		trees.add(new RegularTree(300, 1000));
		trees.add(new RegularTree(400, 100));
		trees.add(new RegularTree(500, 200));
		trees.add(new RegularTree(800, 300));
		
		enemies.add(new Stump(1));
		enemies.add(new Stump(2));
		enemies.add(new Stump(2));
		enemies.add(new Stump(1));
		enemies.add(new Stump(2));
	}

}
