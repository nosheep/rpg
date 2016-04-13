package com.nosheep.skills;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nosheep.assets.AssetLoader;
import com.nosheep.enemy.Enemy;
import com.nosheep.player.Player;

public class FireBall extends Projectile{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2720811736549221081L;

	public FireBall(){
		super();
		setRange(300);
		setIcon(AssetLoader.fireBallIcon);
	}
	public FireBall(int positionX, int positionY, int width, int height,
			int damage, Enemy e, Player player) {
		super(positionX, positionY, width, height, damage, e, player);
	}
	@Override
	public void init() {
		setName("FireBall");
		setAllImage(AssetLoader.fireBall);
		setHitAnimation(AssetLoader.explosion);
		setAnimationWidth(64);
		setAnimationHeight(64);
		setSpeed(4);
		setDamage(10);
		setRange(300);
		super.init();
	}
	
	@Override
	public void render(SpriteBatch batch) {
		super.render(batch);
		if(active)
			batch.draw(getImageUp(), positionX - 10, positionY - 10, width + 20, height + 20);
	}

}
