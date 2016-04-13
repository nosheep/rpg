package com.nosheep.items;

import java.io.Serializable;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.nosheep.assets.AssetLoader;
import com.nosheep.main.rpgGame;
import com.nosheep.player.Player;

import net.dermetfan.gdx.graphics.g2d.AnimatedSprite;

public class Leg implements Item, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8133826686233506325L;
	public Player.DIRECTION direction;
	public int magicDamage;
	public int rangedDamage;
	public int meleeDamage;
	public int defence;
	protected transient Sprite idleFront;
	protected transient Sprite idleBack;
	protected transient AnimatedSprite frontWalk;
	protected transient AnimatedSprite backWalk;
	protected String name;
	public boolean showInfo = false;
	public boolean loot, onPlayer;
	protected int positionX, positionY;
	public int lootTimer = 0;
	
	public Leg(){
		loot = false;
		init();
	}
	public Leg(int positionX, int positionY){
		loot = true;
		this.positionX = positionX;
		this.positionY = positionY;
		init();
	}
	
	public void init(){
		direction = Player.DIRECTION.DOWN;
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
		if(idleFront != null)
			batch.draw(idleFront, x, y, width, height);
		else
			System.out.println("idleFront is null");
	}
	
	public void renderIdle(SpriteBatch batch, int x, int y, int width, int height){
		if(direction == Player.DIRECTION.DOWN){
			batch.draw(idleFront, x - 10, y, width, height);
		}
		else{
			batch.draw(idleBack, x, y, width, height);
		}
	}
	public void render(SpriteBatch batch, int x, int y, int width, int height){
		if(direction == Player.DIRECTION.DOWN){
			frontWalk.setPosition(x - 10, y);
			frontWalk.setSize(width, height);
			frontWalk.draw(batch);
		}
		else{
			backWalk.setPosition(x, y);
			backWalk.setSize(width, height);
			backWalk.draw(batch);
		}
	}
	
	public void update(){
		if(isLoot())
			lootTimer++;
	}
	
	public void render(SpriteBatch batch){
		
		batch.draw(idleFront, positionX, positionY, 50, 50);
		
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
	public void renderInfo(ShapeRenderer render, int i, int positionY2) {
		// TODO Auto-generated method stub
		
	}
	
	public Player.DIRECTION getDirection() {
		return direction;
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
	public Sprite getIdleFront() {
		return idleFront;
	}
	public Sprite getIdleBack() {
		return idleBack;
	}
	public String getName() {
		return name;
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
	public void setDirection(Player.DIRECTION direction) {
		this.direction = direction;
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
	public void setIdleFront(Sprite idleFront) {
		this.idleFront = idleFront;
	}
	public void setIdleBack(Sprite idleBack) {
		this.idleBack = idleBack;
	}
	public void setName(String name) {
		this.name = name;
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
	public AnimatedSprite getFrontWalk() {
		return frontWalk;
	}
	public AnimatedSprite getBackWalk() {
		return backWalk;
	}
	public void setFrontWalk(AnimatedSprite frontWalk) {
		this.frontWalk = frontWalk;
	}
	public void setBackWalk(AnimatedSprite backWalk) {
		this.backWalk = backWalk;
	}
	@Override
	public int getLootTimer() {
		return lootTimer;
	}
	
}
