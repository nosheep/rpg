package com.nosheep.enemy;

import com.nosheep.assets.AssetLoader;
import com.nosheep.main.rpgGame;
import com.nosheep.items.BeginnerBody;
import com.nosheep.items.BeginnerLegs;
import com.nosheep.items.KingBatBow;
import com.nosheep.items.KingBatStaff;
import com.nosheep.items.KingBatSword;

public class KingBat extends Enemy{

	/**
	 * 
	 */
	private static final long serialVersionUID = -511744850379038480L;

	public KingBat(int level) {
		super(level);
	}
	
	public KingBat(int positionX, int positionY, int level) {
		super(positionX, positionY, level);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {
		width = 256;
		height = 240;
		setName("King Bat");
		setWalkAnimation(AssetLoader.kingBatFly);
		setWalkAnimation2(AssetLoader.kingBatFly);
		setAttackAnimation(AssetLoader.kingBatFly);
		super.init();
		setRespawnTime(2000);
		setMaxHealth(3000);
		setCurrentHealth(getMaxHealth());
		setDamage(getDamage() * 2);
		setSpeed(7);
		setCombatSpeed(3);
		setAttackSpeed(50);
		setBOSS(true);
	}
	
	@Override
	protected void loot() {
		int loot = (int) (Math.random() * 20);
		if(loot == 1){
			rpgGame.map.get(rpgGame.mapIndex).loot.add(new KingBatBow(positionX, positionY));
		}
		if(loot == 2){
			rpgGame.map.get(rpgGame.mapIndex).loot.add(new KingBatStaff(positionX, positionY));
		}
		if(loot == 3)
		{
			rpgGame.map.get(rpgGame.mapIndex).loot.add(new KingBatSword(positionX, positionY));
		}
		if(loot == 4){
			rpgGame.map.get(rpgGame.mapIndex).loot.add(new BeginnerLegs(positionX, positionY));
		}
		if(loot == 5){
			rpgGame.map.get(rpgGame.mapIndex).loot.add(new BeginnerBody(positionX, positionY));
		}
		super.loot();
	}
	
}
