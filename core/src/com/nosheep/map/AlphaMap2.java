package com.nosheep.map;

import com.nosheep.assets.AssetLoader;
import com.nosheep.enemy.BabyDragon;
import com.nosheep.enemy.Enemy;
import com.nosheep.main.rpgGame;
import com.nosheep.objects.RegularTree;
import com.nosheep.player.Player;
import com.nosheep.tools.Portal;

public class AlphaMap2 extends Map{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2318790368090632080L;

	public AlphaMap2(Player player) {
		super(player);
		name = "Crazy Stumps 2";
		area = "Forest of Alpha";
		setImage(AssetLoader.grass);
		setWeatherRotaion(true);
		trees.add(new RegularTree(600, 100));
		trees.add(new RegularTree(200, 300));
		trees.add(new RegularTree(800, 200));
		trees.add(new RegularTree(100, 500));
		trees.add(new RegularTree(900, 400));
		trees.add(new RegularTree(1500, 700));
		
		enemies.add(new BabyDragon(20));
		enemies.add(new BabyDragon(20));
		enemies.add(new BabyDragon(20));
		enemies.add(new BabyDragon(20));
		enemies.add(new BabyDragon(20));
		for(Enemy e : enemies) {
			e.setWidth(150);
			e.setHeight(170);
			e.setMaxHealth(500);
			e.setCombat(false);
		}
		
		Portal cavePortal = new Portal(player, 1540, 360, 128, 128, false);
		cavePortal.setType(Portal.Type.ZONE);
		cavePortal.setZone(rpgGame.alphaCave);
		cavePortal.setText("Enter");
		cavePortal.setImage(AssetLoader.cave);
		cavePortal.setVisible(true);
		portals.add(cavePortal);
	}
	
}
