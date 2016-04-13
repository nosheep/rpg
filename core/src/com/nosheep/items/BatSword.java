package com.nosheep.items;

import com.nosheep.assets.AssetLoader;

public class BatSword extends Weapon{

	/**
	 * 
	 */
	private static final long serialVersionUID = -68509073130911285L;
	public BatSword(int positionX, int positionY) {
		super(positionX, positionY);
	}
	public BatSword() {
		super();
	}
	public void init() {
		setType(Type.SWORD);
		setName("Bat Sword");
		setBack(AssetLoader.batSwordBack);
		setFront(AssetLoader.batSwordFront);
		rangedDamage = 0;
		magicDamage = 0;
		meleeDamage = 20;
		setOnBackImages(AssetLoader.nonCombatBatSwordFront, AssetLoader.nonCombatBatSwordBack);
	}
}
