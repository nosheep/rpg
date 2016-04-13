package com.nosheep.objects;

import java.io.Serializable;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.nosheep.assets.AssetLoader;
import com.nosheep.main.rpgGame;
import com.nosheep.player.Player;

import net.dermetfan.gdx.graphics.g2d.AnimatedSprite;

public abstract class Tree implements Environment, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -31827500706323851L;
	protected boolean cutDown = false;
	private transient Sprite imageCut;
	private transient AnimatedSprite treeAnim;
	protected int positionX, positionY, width, height;
	protected int timer = 0;
	protected int respawnTime = 500;
	protected boolean onPlayer = false;
	
	public Tree(int positionX, int positionY){
		this.positionX = positionX;
		this.positionY = positionY;
		init();
	}
	public void init(){
		
	}
	public void checkPlayer(Player player){
			if(player.getPositionX()>= getPositionX() &&
					player.getPositionX() <= (getPositionX() + getWidth()) &&
					(player.getPositionX() + player.getWidth()) >= getPositionX() &&
					player.getPositionY() >= getPositionY() &&
					player.getPositionY() <= (getPositionY() + getHeight()) &&
					(player.getPositionY() + player.getHeight()) >= getPositionY()){
				onPlayer = true;
			}
			else
				onPlayer = false;
	}
	private void update(){
		if(onPlayer && Gdx.input.isKeyJustPressed(Keys.F)){
			cutDown = true;
		}
		if(cutDown){
			timer++;
			if(timer >= respawnTime){
				cutDown = false;
				timer = 0;
			}
		}
	}
	public void render(SpriteBatch batch){
		update();
		if(!cutDown){	
			AssetLoader.regularTree.setPosition(positionX, positionY);
			AssetLoader.regularTree.setSize(width, height);
			AssetLoader.regularTree.draw(batch);
		}
		else{
			batch.draw(imageCut, positionX + 20, positionY + height - 80, 100, 80);
		}
		if(onPlayer && !cutDown){
			batch.draw(AssetLoader.ui, positionX + 45, positionY - 5, 120, 35);
			batch.draw(AssetLoader.blackBorder, positionX + 45, positionY - 5, 120, 35);
			rpgGame.font.setColor(Color.ORANGE);
			rpgGame.font.draw(batch, "Cut (F)", positionX + 50, positionY);
		}
	}
	public void sRenderFill(ShapeRenderer render){
		
	}
	public void sRenderLine(ShapeRenderer render){
		
	}

	public Sprite getImageCut() {
		return imageCut;
	}

	public void setImageCut(Sprite imageCut) {
		this.imageCut = imageCut;
	}

	public boolean isCutDown() {
		return cutDown;
	}

	public int getPositionX() {
		return positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void setCutDown(boolean cutDown) {
		this.cutDown = cutDown;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	public boolean isOnPlayer() {
		return onPlayer;
	}
	public void setOnPlayer(boolean onPlayer) {
		this.onPlayer = onPlayer;
	}
	public AnimatedSprite getTreeAnim() {
		return treeAnim;
	}
	public void setTreeAnim(AnimatedSprite treeAnim) {
		this.treeAnim = treeAnim;
	}
	
}
