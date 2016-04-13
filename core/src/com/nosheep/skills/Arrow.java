package com.nosheep.skills;

import com.nosheep.assets.AssetLoader;
import com.nosheep.enemy.Enemy;
import com.nosheep.player.Player;

public class Arrow extends Projectile{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3779975984847622182L;

	public Arrow(){
		super();
		setRange(400);
		setIcon(AssetLoader.arrowIcon);
	}
	public Arrow(int positionX, int positionY, int width, int height,
			int damage, Enemy e, Player player) {
		super(positionX, positionY, width, height, damage, e, player);
	}
	@Override
	public void init() {
		setName("Arrow");
		setImageUp(AssetLoader.arrowUp);
		setImageDown(AssetLoader.arrowDown);
		setImageLeft(AssetLoader.arrowLeft);
		setImageRight(AssetLoader.arrowRight);
		setHitAnimation(AssetLoader.bleeding);
		setAnimationWidth(32);
		setAnimationHeight(32);
		setSpeed(15);
		setDamage(5);
		setRange(400);
		super.init();
	}
}
