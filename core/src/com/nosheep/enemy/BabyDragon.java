package com.nosheep.enemy;

import com.nosheep.assets.AssetLoader;
import com.nosheep.enemySkills.GreenFireBall;
import com.nosheep.items.IronHelmet;
import com.nosheep.main.rpgGame;

public class BabyDragon extends Enemy{

	private static final long serialVersionUID = 1265154672460627983L;
	private int attackCounter = 0;
	
	public BabyDragon(int level) {
		super(level);
		// TODO Auto-generated constructor stub
	}
	public BabyDragon(int positionX, int positionY, int level) {
		super(positionX, positionY, level);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void init() {
		width = 108;
		height = 100;
		setName("Baby Dragon");
		setWalkAnimation(AssetLoader.unknownDragonFlyDown);
		setWalkAnimation2(AssetLoader.unknownDragonFlyUp);
		setAttackAnimation(AssetLoader.unknownDragonFlyDown);
		setSpeed(6);
		setCombatSpeed(2);
		setXp(100);
		setDamage(3);
		setAttackSpeed(10);
		super.init();
	}
	
	@Override
	protected void loot() {
		int loot = (int) (Math.random() * 50);
		if(loot == 1){
			rpgGame.map.get(rpgGame.mapIndex).loot.add(new IronHelmet(positionX, positionY));
		}
		super.loot();
	}
	
	@Override
	protected void attack() {
		if(combat){
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
		attack();
		super.update();
	}
	
}
