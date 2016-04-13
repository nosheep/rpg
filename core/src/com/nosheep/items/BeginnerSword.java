package com.nosheep.items;

import com.nosheep.assets.AssetLoader;

public class BeginnerSword extends Weapon{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4952881311465246732L;
	public BeginnerSword(){
		super();
	}
	public BeginnerSword(int positionX, int positionY){
		super(positionX, positionY);
	}
	public void init(){
		setType(Type.SWORD);
		setName("Beginner Sword");
		setBack(AssetLoader.beginnerSwordBack);
		setFront(AssetLoader.beginnerSwordFront);
		meleeDamage = 15;
		rangedDamage = 0;
		magicDamage = 0;
		setOnBackImages(AssetLoader.nonCombatBeginnerSwordFront, AssetLoader.nonCombatBeginnerSwordBack);
	}
	
}
