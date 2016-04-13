package com.nosheep.enemySkills;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface EnemySkill {

	void render(SpriteBatch batch);

	void update();

	boolean getActive();

	boolean getDisplayDamage();

}
