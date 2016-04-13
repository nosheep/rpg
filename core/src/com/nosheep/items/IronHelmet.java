package com.nosheep.items;

import com.nosheep.assets.AssetLoader;

public class IronHelmet extends Helmet{

	private static final long serialVersionUID = -6731757829439604812L;

	public IronHelmet() {
		super();
	}
	public IronHelmet(int positionX, int positionY) {
		super(positionX, positionY);
	}
	
	@Override
	public void init() {
		setName("Iron Helmet");
		setHelmetBack(AssetLoader.ironHelmetBack);
		setHelmetFront(AssetLoader.ironHelmetFront);
		setRangedDamage(0);
		setMagicDamage(0);
		setMeleeDamage(10);
		super.init();
	}
	
}
