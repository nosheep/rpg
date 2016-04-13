package com.nosheep.skills;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nosheep.assets.AssetLoader;
import com.nosheep.enemy.Enemy;
import com.nosheep.main.rpgGame;
import com.nosheep.player.Player;

public class LavaCarpet extends AoE{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2784040968438100760L;
	
	public LavaCarpet(){
		super();
		setIcon(AssetLoader.lavaCarpet);
		setCoolDownTimer(500);
		setReuiredLevel(5);
	}
	public LavaCarpet(int magicAttack, List<Enemy> enemies, Player player) {
		super(magicAttack, enemies, player);
	}
	@Override
	public void init() {
		setImage(AssetLoader.lavaCarpet);
		direction = player.getDirection();
		super.init();
	}
	
	@Override
	protected void attack() {
		onGround = true;
		for(Enemy e: enemies){
			if(positionX + width >= e.getPositionX() &&
					positionX <= (e.getPositionX() + e.getWidth()) &&
					positionY + height >= e.getPositionY() &&
					positionY <= (e.getPositionY() + e.getHeight())){
				if(groundCounter % 30 == 0){
					damage = (int)(Math.random() * magicAttack * 3);
					e.setCurrentHealth(e.getCurrentHealth()-damage);
				}
			}
		}
	}
	@Override
	public void render(SpriteBatch batch) {
		if(image != null && active)
			batch.draw(image, positionX, positionY, width, height);
		
		for(Enemy e: enemies){
			if(positionX + width >= e.getPositionX() &&
					positionX <= (e.getPositionX() + e.getWidth()) &&
					positionY + height >= e.getPositionY() &&
					positionY <= (e.getPositionY() + e.getHeight())){
				//e.render(batch);
				if(onGround && e.isAlive()){
					batch.draw(AssetLoader.burn, e.getPositionX() - 30, e.getPositionY() - 120, 64, 64);
					rpgGame.font.setColor(Color.BLACK);
					rpgGame.font.draw(batch, Integer.toString(damage), e.getPositionX() - 15, e.getPositionY() - 100);
				}
			}
		}
	}
	private void checkDirection(){
		if(Gdx.input.isKeyPressed(Keys.W)){
			direction = Player.DIRECTION.UP;
			image = AssetLoader.lavaCarpet;
		}
		if(Gdx.input.isKeyPressed(Keys.S)){
			direction = Player.DIRECTION.DOWN;
			image = AssetLoader.lavaCarpet;
		}
		if(Gdx.input.isKeyPressed(Keys.A)){
			direction = Player.DIRECTION.LEFT;
			image = AssetLoader.lavaCarpetSide;
		}
		if(Gdx.input.isKeyPressed(Keys.D)){
			direction = Player.DIRECTION.RIGHT;
			image = AssetLoader.lavaCarpetSide;
		}
	}
	@Override
	public void update() {
		if(!onGround){
			checkDirection();
			if(direction == Player.DIRECTION.UP){
				positionX = player.getPositionX() + 5;
				positionY = player.getPositionY() - 310;
				width = 100;
				height = 300;
			}
			if(direction == Player.DIRECTION.DOWN){
				positionX = player.getPositionX() - 5;
				positionY = player.getPositionY() + 110;
				width = 100;
				height = 300;
			}
			if(direction == Player.DIRECTION.LEFT){
				positionX = player.getPositionX() - 320;
				positionY = player.getPositionY();
				width = 300;
				height = 100;
			}
			if(direction == Player.DIRECTION.RIGHT){
				positionX = player.getPositionX() + 100;
				positionY = player.getPositionY();
				width = 300;
				height = 100;
			}
		}
		else{
			groundCounter++;
		}
		
		if(groundCounter >= 300)
			active = false;
		
		if(!onGround && active && Gdx.input.justTouched()){
			attacking = true;
		}
		if(attacking && active)
			attack();
	}

}
