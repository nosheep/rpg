package com.nosheep.enemy;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nosheep.assets.AssetLoader;
import com.nosheep.enemySkills.GreenFireBall;
import com.nosheep.items.LavaCape;
import com.nosheep.main.rpgGame;

public class UnknownWizard extends Enemy{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1338005734403509030L;
	private STAGE stage = STAGE.second;
	private int attackCounter = 0;
	
	public UnknownWizard(int level){
		super(level);
	}
	
	public UnknownWizard(int positionX, int positionY, int level) {
		super(positionX, positionY, level);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void init() {
		super.init();
		setWalkAnimation(AssetLoader.unknownDragonFlyDown);
		setWalkAnimation2(AssetLoader.unknownDragonFlyUp);
		setAttackAnimation(AssetLoader.unknownDragonFlyDown);
		setName("??????");
		setBOSS(true);
		setMaxHealth(10000);
		setCurrentHealth(getMaxHealth() - 1);
		setXp(25000);
		setCombatSpeed(2);
		setSpeed(5);
		setAttackSpeed(100);
		setDamage(30);
		setWidth(248);
		setHeight(264);
		setRespawnTime(3000);
	}
	
	@Override
	protected void loot() {
		rpgGame.map.get(rpgGame.mapIndex).loot.add(new LavaCape(positionX, positionY));
		super.loot();
	}
	
	@Override
	protected void attack() {
		if(stage == STAGE.second){
			if(alive && !isFrozen() && getPlayer() != null){
				attackCounter++;
				if(attackCounter >= getAttackSpeed()){
					skills.add(new GreenFireBall(positionX + width / 2, positionY, 64, 64, getDamage(), getPlayer()));
					attackCounter = 0;
				}
			}
		}
	}
	@Override
	protected void update() {
		super.update();
		combat = true;
		attack();
	}
	@Override
	public void render(SpriteBatch batch) {
		super.render(batch);
		if(!alive){
			AssetLoader.unknownPortal.setPosition(getPositionX() + 60, getPositionY() + 30);
			AssetLoader.unknownPortal.draw(batch);
			batch.draw(AssetLoader.ui, getPositionX() - 5, getPositionY() - 5, 330, 35);
			rpgGame.font.setColor(Color.PINK);
			rpgGame.font.draw(batch, "Press 'R' to return", getPositionX(), getPositionY());
			if(Gdx.input.isKeyJustPressed(Keys.R)){
				respawnCounter = respawnTime - 5;
				rpgGame.map = rpgGame.kingsForest;
				rpgGame.mapIndex = 0;
			}
		}
	}
	@Override
	protected void respawn() {
		// TODO Auto-generated method stub
		super.respawn();
		setCurrentHealth(getCurrentHealth() - 1);
	}

}
