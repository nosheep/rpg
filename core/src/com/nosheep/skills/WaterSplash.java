package com.nosheep.skills;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nosheep.assets.AssetLoader;
import com.nosheep.enemy.Enemy;
import com.nosheep.main.rpgGame;
import com.nosheep.player.Player;

public class WaterSplash extends Projectile{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3375780158554703075L;
	private int x, y1, y2, y3;
	
	public WaterSplash(){
		super();
		setRange(300);
		setIcon(AssetLoader.waterSplashTexture);
	}
	public WaterSplash(int positionX, int positionY, int width, int height,
			int damage, Enemy e, Player player) {
		super(positionX, positionY, width, height, damage, e, player);
	}

	@Override
	public void init() {
		setName("WaterSplash");
		setAllImage(AssetLoader.waterSplashTexture);
		setHitAnimation(AssetLoader.waterSplash);
		setAnimationWidth(64);
		setAnimationHeight(64);
		setSpeed(2);
		setDamage(1);
		setRange(300);
		x = player.getPositionX();
		y1 = player.getPositionY() - 5;
		y2 = player.getPositionY();
		y3 = player.getPositionY() + 10;
		if(player.getCurrentHealth() < player.getMaxHealth()){
			player.setCurrentHealth(player.getCurrentHealth() + (int)(player.getMaxHealth() * 0.01));
		}
		super.init();
	}
	
	@Override
	public void render(SpriteBatch batch) {
		super.render(batch);
		if(active){
			batch.draw(AssetLoader.waterSplashTexture, positionX - 10, positionY - 10, width + 20, height + 20);
		}
		if(damageCounter < 20){
			batch.draw(AssetLoader.black, x - 5, y1--, 50, 50);
			batch.draw(AssetLoader.green, x, y2--, 40, 40);
			rpgGame.font.setColor(Color.BLACK);
			rpgGame.font.draw(batch, "+" + Integer.toString((int)(player.getMaxHealth() * 0.01)), x + 5, y3--);
		}
		System.out.println((int)(player.getMaxHealth() * 0.01));
	}

}
