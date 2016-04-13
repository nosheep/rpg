package com.nosheep.enemySkills;

import com.nosheep.assets.AssetLoader;
import com.nosheep.player.Player;

public class EnemyPunch extends EnemyMelee{

	private static final long serialVersionUID = -3369681706403506255L;

	public EnemyPunch(int positionX, int positionY, int width, int height, int damage, Player p) {
		super(positionX, positionY, width, height, damage, p);
		setName("Punch");
		setImage(AssetLoader.punchIcon);
		setDamage(5);
	}
}
