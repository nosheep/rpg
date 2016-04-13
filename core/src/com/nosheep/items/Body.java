package com.nosheep.items;

import java.io.Serializable;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nosheep.assets.AssetLoader;
import com.nosheep.main.rpgGame;
import com.nosheep.player.Player;

public class Body implements Item, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2481598741404747849L;

	public Player.DIRECTION direction;

	protected String name;
	public int magicDamage;
	public int rangedDamage;
	public int meleeDamage;
	public int defence;
	public boolean showInfo = false;
	public boolean loot;

	protected boolean onPlayer;
	protected int positionX, positionY;
	protected transient Sprite bodyFront, bodyBack;
	public int lootTimer = 0;
	
	public Body(){
		loot = false;
		init();
	}
	public Body(int positionX, int positionY){
		loot = true;
		this.positionX = positionX;
		this.positionY = positionY;
		init();
	}
	public void init(){
		direction = Player.DIRECTION.UP;
	}

	public boolean checkPlayer(Player player){
		if(player.getPositionX() + player.getWidth() >= getPositionX()-10 &&
				player.getPositionX() <= (getPositionX()-10 + 70) &&
				(player.getPositionX() + player.getWidth()) >= getPositionX()-10 &&
				player.getPositionY() + player.getHeight() >= getPositionY()-10 &&
				player.getPositionY() <= (getPositionY()-10 + 70) &&
				(player.getPositionY() + player.getHeight()) >= getPositionY()-10){
			onPlayer = true;
			return true;
		}
		else{
			onPlayer = false;
			return false;
		}
	}

	public void renderIcon(SpriteBatch batch, int x, int y, int width, int height){
		if(bodyFront != null)
			batch.draw(bodyFront, x, y, width, height);
		else
			System.out.println("idleFront is null");
	}
	public void render(SpriteBatch batch, int x, int y, int width, int height){
		if(direction == Player.DIRECTION.UP){
			batch.draw(bodyBack, x, y, width, height);
		}
		else{
			batch.draw(bodyFront, x - 10, y, width, height);
		}
	}
	
	public void update(){
		if(isLoot())
			lootTimer++;
	}
	
	public void render(SpriteBatch batch){
		
		batch.draw(bodyFront, positionX, positionY, 50, 50);
		
		if(onPlayer){
			batch.draw(AssetLoader.ui, positionX - 30, positionY - 90, 135, 35);
			batch.draw(AssetLoader.blackBorder, positionX - 30, positionY - 90, 135, 35);
			batch.draw(AssetLoader.ui, positionX - 90, positionY - 50, 265, 35);
			batch.draw(AssetLoader.blackBorder, positionX - 90, positionY - 50, 265, 35);
			batch.draw(AssetLoader.blackBorder, positionX - 10, positionY - 10, 70, 70);
			rpgGame.font.setColor(Color.ORANGE);
			rpgGame.font.draw(batch, name, positionX - 70, positionY - 45);
			rpgGame.font.draw(batch, "Loot (F)", positionX - 25, positionY - 85);
		}
		if(rpgGame.checkHover(positionX - 10, positionY - 10, 70, 70)){
			batch.draw(AssetLoader.ui, positionX - 90, positionY - 50, 265, 35);
			batch.draw(AssetLoader.blackBorder, positionX - 90, positionY - 50, 265, 35);
			batch.draw(AssetLoader.blackBorder, positionX - 10, positionY - 10, 70, 70);
			rpgGame.font.setColor(Color.ORANGE);
			rpgGame.font.draw(batch, name, positionX - 70, positionY - 45);
		}
	}
	
	public Player.DIRECTION getDirection() {
		return direction;
	}
	public String getName() {
		return name;
	}
	public int getMagicDamage() {
		return magicDamage;
	}
	public int getRangedDamage() {
		return rangedDamage;
	}
	public int getMeleeDamage() {
		return meleeDamage;
	}
	public int getDefence() {
		return defence;
	}
	public boolean isShowInfo() {
		return showInfo;
	}
	public boolean isLoot() {
		return loot;
	}
	public boolean isOnPlayer() {
		return onPlayer;
	}
	public int getPositionX() {
		return positionX;
	}
	public int getPositionY() {
		return positionY;
	}
	public Sprite getBodyFront() {
		return bodyFront;
	}
	public Sprite getBodyBack() {
		return bodyBack;
	}
	public void setDirection(Player.DIRECTION direction) {
		this.direction = direction;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setMagicDamage(int magicDamage) {
		this.magicDamage = magicDamage;
	}
	public void setRangedDamage(int rangedDamage) {
		this.rangedDamage = rangedDamage;
	}
	public void setMeleeDamage(int meleeDamage) {
		this.meleeDamage = meleeDamage;
	}
	public void setDefence(int defence) {
		this.defence = defence;
	}
	public void setShowInfo(boolean showInfo) {
		this.showInfo = showInfo;
	}
	public void setLoot(boolean loot) {
		lootTimer = 0;
		this.loot = loot;
	}
	public void setOnPlayer(boolean onPlayer) {
		this.onPlayer = onPlayer;
	}
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}
	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
	public void setBodyFront(Sprite bodyFront) {
		this.bodyFront = bodyFront;
	}
	public void setBodyBack(Sprite bodyBack) {
		this.bodyBack = bodyBack;
	}
	@Override
	public int getLootTimer() {
		return lootTimer;
	}
	
}
