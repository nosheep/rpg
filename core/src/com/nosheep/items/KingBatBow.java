package com.nosheep.items;

import com.nosheep.assets.AssetLoader;

public class KingBatBow extends Weapon{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8596480008890013514L;

	public KingBatBow(int positionX, int positionY) {
		super(positionX, positionY);
	}

	public KingBatBow() {
		super();
	}

	public void init() {
		setType(Type.BOW);
		setName("King Bat Bow");
		setBack(AssetLoader.kingBatBowFront);
		setFront(AssetLoader.kingBatBowBack);
		setRare(true);
		rangedDamage = 20;
		magicDamage = 0;
		meleeDamage = 0;
		setOnBackImages(AssetLoader.nonCombatKingBatBowFront, AssetLoader.nonCombatKingBatBowBack);
	}
	
}
