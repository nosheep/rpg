package com.nosheep.skills;

import com.nosheep.assets.AssetLoader;
import com.nosheep.enemy.Enemy;
import com.nosheep.player.Player;

public class Punch extends Melee{
	
	private static final long serialVersionUID = 5650866216740570873L;

	public Punch(){
		setRange(100);
		setIcon(AssetLoader.punchIcon);
	}
	public Punch(int positionX, int positionY, int width, int height,
			int damage, Enemy e, Player player){
		super(positionX, positionY, width, height, damage, e, player);
	}
	@Override
	public void init() {
		setName("Punch");
		setAllImage(AssetLoader.punchIcon);
		setDamage(5);
		setRange(100);
		super.init();
	}
	
}
