package com.nosheep.items;

import com.nosheep.assets.AssetLoader;

public class BatBow extends Weapon{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6569922564593173653L;
	public BatBow(int positionX, int positionY) {
		super(positionX, positionY);
	}
	public BatBow() {
		super();
	}
	public void init() {
		setType(Type.BOW);
		setName("Bat Bow");
		setBack(AssetLoader.batBowBack);
		setFront(AssetLoader.batBowFront);
		rangedDamage = 10;
		magicDamage = 0;
		meleeDamage = 0;
		setOnBackImages(AssetLoader.nonCombatBatBowFront, AssetLoader.nonCombatBatBowBack);
	}

}
