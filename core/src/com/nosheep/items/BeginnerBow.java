package com.nosheep.items;

import com.nosheep.assets.AssetLoader;

public class BeginnerBow extends Weapon{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2475681146877908014L;
	public BeginnerBow(){
		super();
	}
	public BeginnerBow(int positionX, int positionY){
		super(positionX, positionY);
	}
	public void init(){
		setType(Type.BOW);
		setName("Beginner Bow");
		setBack(AssetLoader.beginnerBowBack);
		setFront(AssetLoader.beginnerBowFront);
		rangedDamage = 5;
		magicDamage = 0;
		meleeDamage = 0;
		setOnBackImages(AssetLoader.nonCombatBeginnerBowFront, AssetLoader.nonCombatBeginnerBowBack);
	}
	
}
