package com.nosheep.skills;

import com.nosheep.assets.AssetLoader;
import com.nosheep.enemy.Enemy;
import com.nosheep.player.Player;

public class Cleave extends Melee{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1110648056111544007L;

	public Cleave(){
		super();
		setRange(100);
		setIcon(AssetLoader.cleaveIcon);
	}
	public Cleave(int positionX, int positionY, int width, int height,
			int damage, Enemy e, Player player) {
		super(positionX, positionY, width, height, damage, e, player);
	}
	@Override
	public void init() {
		setName("Cleave");
		setAllImage(AssetLoader.cleave);
		setDamage(30);
		setRange(100);
		super.init();
	}
}
