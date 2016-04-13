package com.nosheep.enemy;

import com.nosheep.assets.AssetLoader;
import com.nosheep.items.BeginnerBody;
import com.nosheep.items.BeginnerBow;
import com.nosheep.items.BeginnerLegs;
import com.nosheep.items.BeginnerStaff;
import com.nosheep.items.BeginnerSword;
import com.nosheep.main.rpgGame;

public class Stump extends Enemy{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2519010804342553690L;

	public Stump(int level) {
		super(level);
	}
	public Stump(int positionX, int positionY, int level) {
		super(positionX, positionY, level);
	}

	@Override
	public void init() {
		width = 76;
		height = 108;
		setName("Stump");
		setWalkAnimation(AssetLoader.stumpWalk);
		setWalkAnimation2(AssetLoader.stumpWalk);
		setAttackAnimation(AssetLoader.stumpAttack);
		setAttackSpeed(50);
		super.init();
	}
	
	@Override
	protected void loot() {
		int loot = (int) (Math.random() * 10);
		if(loot == 1){
			rpgGame.map.get(rpgGame.mapIndex).loot.add(new BeginnerBow(positionX, positionY));
		}
		if(loot == 2){
			rpgGame.map.get(rpgGame.mapIndex).loot.add(new BeginnerStaff(positionX, positionY));
		}
		if(loot == 3)
		{
			rpgGame.map.get(rpgGame.mapIndex).loot.add(new BeginnerSword(positionX, positionY));
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
