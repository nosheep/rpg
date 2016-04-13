package com.nosheep.skills;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface Skill {
	public void update();
	public void render(SpriteBatch batch);
	public void setActive(boolean active);
	public boolean getActive();
	public boolean getDisplayDamage();
	public int getRange();
	public Sprite getIcon();
	public boolean isCoolDown();
	public void setCoolDown(boolean cd);
	public int getRequiredLevel();
	public void updateCoolDown();
}
