package com.nosheep.map;

import com.nosheep.assets.AssetLoader;
import com.nosheep.enemy.Stump;
import com.nosheep.player.Player;

public class CrazyStumps extends Map{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1055618706199768076L;
	public CrazyStumps(Player player) {
		super(player);
	}
	@Override
	public void init(Player player) {
		setName("Crazy Stumps 1");
		setArea("Haunted Woods");
		setImage(AssetLoader.moss);
		setWeatherRotaion(true);
		setWeather(Weather.sunny);
		
		enemies.add(new Stump(1));
		enemies.add(new Stump(1));
		
		borderDown = AssetLoader.treeBorderDown;
		borderLeft = AssetLoader.treeBorderLeft;
		borderRight = AssetLoader.treeBorderRight;
		super.init(player);
	}

}
