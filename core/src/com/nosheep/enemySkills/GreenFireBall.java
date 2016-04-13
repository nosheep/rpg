package com.nosheep.enemySkills;

import com.nosheep.assets.AssetLoader;
import com.nosheep.player.Player;

public class GreenFireBall extends EnemyProjectile{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7778437597274520002L;

	public GreenFireBall(int positionX, int positionY, int width, int height,
			int damage, Player p) {
		super(positionX, positionY, width, height, damage, p);
		setName("Green FireBall");
		setImage(AssetLoader.gFireBall);
		setHitAnimation(AssetLoader.greenFireBall);
		setAnimationWidth(64);
		setAnimationHeight(64);
		setSpeed(10);
	}

}
