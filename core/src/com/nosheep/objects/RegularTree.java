package com.nosheep.objects;

import com.nosheep.assets.AssetLoader;

public class RegularTree extends Tree{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5470459765860798504L;

	public RegularTree(int positionX, int positionY) {
		super(positionX, positionY);
	}
	
	@Override
	public void init() {
		setWidth(160);
		setHeight(220);
		setTreeAnim(AssetLoader.regularTree);
		setImageCut(AssetLoader.regularTreeCutDown);
		super.init();
	}

}
