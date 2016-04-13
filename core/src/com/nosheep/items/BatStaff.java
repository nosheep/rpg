package com.nosheep.items;

import com.nosheep.assets.AssetLoader;

public class BatStaff extends Weapon{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4713866555143018823L;
	public BatStaff(int positionX, int positionY) {
		super(positionX, positionY);
	}
	public BatStaff() {
		super();
	}
	public void init() {
		setType(Type.STAFF);
		setName("Bat Staff");
		setBack(AssetLoader.batStaffBack);
		setFront(AssetLoader.batStaffFront);
		rangedDamage = 0;
		magicDamage = 15;
		meleeDamage = 0;
		setOnBackImages(AssetLoader.nonCombatBatStaffFront, AssetLoader.nonCombatBatStaffBack);
	}
}
