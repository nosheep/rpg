package com.nosheep.items;

import com.nosheep.assets.AssetLoader;

public class KingBatSword extends Weapon{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8755582836221820015L;

	public KingBatSword(int positionX, int positionY) {
		super(positionX, positionY);
	}

	public KingBatSword() {
		super();
	}

	public void init() {
		setType(Type.SWORD);
		setName("King Bat Sword");
		setBack(AssetLoader.kingBatSwordBack);
		setFront(AssetLoader.kingBatSwordFront);
		setRare(true);
		rangedDamage = 0;
		magicDamage = 0;
		meleeDamage = 30;
		setOnBackImages(AssetLoader.nonCombatKingBatSwordFront, AssetLoader.nonCombatKingBatSwordBack);
	}
	
}
