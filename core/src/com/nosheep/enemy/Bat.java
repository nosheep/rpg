package com.nosheep.enemy;

import com.nosheep.assets.AssetLoader;
import com.nosheep.items.BatBow;
import com.nosheep.items.BatStaff;
import com.nosheep.items.BatSword;
import com.nosheep.items.BeginnerBody;
import com.nosheep.items.BeginnerLegs;
import com.nosheep.main.rpgGame;

public class Bat extends Enemy{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3696116019088624821L;

	public Bat(int level) {
		super(level);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void init() {
		width = 108;
		height = 100;
		setName("Bat");
		setWalkAnimation(AssetLoader.batFly);
		setWalkAnimation2(AssetLoader.batFly);
		setAttackAnimation(AssetLoader.batFly);
		super.init();
		setSpeed(7);
		setCombatSpeed(3);
		setAttackSpeed(50);
	}
	
	@Override
	protected void loot() {
		int loot = (int) (Math.random() * 50);
		if(loot == 1){
			rpgGame.map.get(rpgGame.mapIndex).loot.add(new BatBow(positionX, positionY));
		}
		if(loot == 2){
			rpgGame.map.get(rpgGame.mapIndex).loot.add(new BatStaff(positionX, positionY));
		}
		if(loot == 3)
		{
			rpgGame.map.get(rpgGame.mapIndex).loot.add(new BatSword(positionX, positionY));
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
