package com.nosheep.items;

import com.nosheep.assets.AssetLoader;

public class KingBatStaff extends Weapon{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5785122956432934795L;

	public KingBatStaff(int positionX, int positionY) {
		super(positionX, positionY);
	}

	public KingBatStaff() {
		super();
	}

	public void init() {
		setType(Type.STAFF);
		setName("King Bat Staff");
		setBack(AssetLoader.kingBatStaffBack);
		setFront(AssetLoader.kingBatStaffFront);
		setRare(true);
		rangedDamage = 0;
		magicDamage = 25;
		meleeDamage = 0;
		setOnBackImages(AssetLoader.nonCombatKingBatStaffFront, AssetLoader.nonCombatKingBatStaffBack);
	}
	
}
