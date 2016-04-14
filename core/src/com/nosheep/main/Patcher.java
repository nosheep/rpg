package com.nosheep.main;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Patcher extends ApplicationAdapter {

	SpriteBatch batch;
	Sprite bg;
	Sprite bgImage;
	
	@Override
	public void create() {
		// TODO Auto-generated method stub
		super.create();
		batch = new SpriteBatch();
		bg = new Sprite(new Texture("patcher/patcherbg.png"));
		bgImage = new Sprite(new Texture("patcher/dragon.png"));
		Pixmap pm = new Pixmap(Gdx.files.internal("cursor/cursor.png"));
		Gdx.input.setCursorImage(pm, 0, 0);
		pm.dispose();
	}
	
	private void update(){

	}
	
	@Override
	public void render() {
		// TODO Auto-generated method stub
		super.render();
		update();
		batch.begin();
			batch.draw(bg, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
			batch.draw(bgImage, -54, -64, 300, 300);
		batch.end();
	}
	
}
