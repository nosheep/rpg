package com.nosheep.map;

import com.nosheep.assets.AssetLoader;
import com.nosheep.player.Player;

public class NullMap extends Map{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2509055288376004016L;

	public NullMap(Player player) {
		super(player);
	}
	
	@Override
	public void init(Player player) {
		setArea("null");
		setName("null");
		setWeatherRotaion(false);
		setWeather(Weather.sunny);
		setImage(AssetLoader.black);
		super.init(player);
	}

}
