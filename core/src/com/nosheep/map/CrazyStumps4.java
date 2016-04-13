package com.nosheep.map;

import com.nosheep.assets.AssetLoader;
import com.nosheep.enemy.Stump;
import com.nosheep.main.rpgGame;
import com.nosheep.player.Player;
import com.nosheep.tools.Portal;

public class CrazyStumps4 extends Map{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7077280311014276752L;

	public CrazyStumps4(Player player) {
		super(player);
	}
	
	@Override
	public void init(Player player) {
		setName("Crazy Stumps 4");
		setArea("Haunted Woods");
		setImage(AssetLoader.moss);
		setWeatherRotaion(true);
		setWeather(Weather.sunny);
		
		enemies.add(new Stump(1));
		enemies.add(new Stump(1));
		
		borderUp = AssetLoader.treeBorderUp;
		borderLeft = AssetLoader.treeBorderLeft;
		borderRight = AssetLoader.treeBorderRight;
	
		Portal cavePortal = new Portal(player, 1740, 60, 128, 128, false);
		cavePortal.setType(Portal.Type.ZONE);
		cavePortal.setZone(rpgGame.batCave);
		cavePortal.setMapIndex((byte)45);
		cavePortal.setText("Enter");
		cavePortal.setImage(AssetLoader.cave);
		cavePortal.setVisible(true);
		portals.add(cavePortal);
		super.init(player);
	}
	
}
