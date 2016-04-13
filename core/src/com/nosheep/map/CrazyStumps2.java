package com.nosheep.map;

import com.nosheep.assets.AssetLoader;
import com.nosheep.enemy.Stump;
import com.nosheep.player.Player;

public class CrazyStumps2 extends Map{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6209407637730873203L;

	public CrazyStumps2(Player player) {
		super(player);
	}
	
	@Override
	public void init(Player player) {
		setName("Crazy Stumps 2");
		setArea("Haunted Woods");
		setImage(AssetLoader.moss);
		setWeatherRotaion(true);
		setWeather(Weather.sunny);
		
		enemies.add(new Stump(1));
		enemies.add(new Stump(1));
		
		borderUp = AssetLoader.treeBorderUp;
		borderRight = AssetLoader.treeBorderRight;
		super.init(player);
	}
	
}
