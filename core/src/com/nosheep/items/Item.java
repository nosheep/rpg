package com.nosheep.items;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nosheep.player.Player;

public interface Item {
	public void render(SpriteBatch batch);
	public void update();
	public boolean checkPlayer(Player player);
	public int getLootTimer();
	public String getName();
}
