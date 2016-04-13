package com.nosheep.tools;

import java.io.Serializable;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.nosheep.assets.AssetLoader;
import com.nosheep.items.Body;
import com.nosheep.items.Helmet;
import com.nosheep.items.Leg;
import com.nosheep.items.Weapon;
import com.nosheep.main.rpgGame;
import com.nosheep.player.Player;
import com.nosheep.items.Backpiece;

public class InventorySlot implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7287094448000252101L;
	public int positionX, positionY, width, height;
	private Weapon weapon;
	private Helmet helmet;
	private Leg legs;
	private Body body;
	private Backpiece backpiece;
	public boolean full = false;
	private Player player;
	
	public InventorySlot(int positionX, int positionY, Player player){
		this.positionX = positionX;
		this.positionY = positionY;
		this.player = player;
		width = 50;
		height = 50;
	}
	public void update(int positionX, int positionY){
		this.positionX = positionX;
		this.positionY = positionY;
	}
	public void render(SpriteBatch batch){
		if(rpgGame.checkHover(positionX, positionY, width, height))
			batch.draw(AssetLoader.inventorySlotHover, positionX, positionY, width, height);
		else
			batch.draw(AssetLoader.slot, positionX, positionY, width, height);
		
		if(weapon != null){
			full = true;
			if(weapon.type == Weapon.Type.BOW){
				weapon.renderIcon(batch, positionX + 18, positionY, 15, height);
			}
			if(weapon.type == Weapon.Type.STAFF)
			{
				weapon.renderIcon(batch, positionX, positionY, width, height);
			}
			if(weapon.type == Weapon.Type.SWORD)
			{
				weapon.renderIcon(batch, positionX, positionY, width, height);
			}
			
			if(rpgGame.checkHover(positionX, positionY, width, height)){
				weapon.showInfo = true;
				if(Gdx.input.isButtonPressed(Buttons.RIGHT)){
					dropWeapon();
				}
				if(Gdx.input.justTouched()){
					equipWeapon();
				}
			}
			else{
				weapon.showInfo = false;
			}
		}
		if(helmet != null){
			full = true;
			helmet.renderIcon(batch, positionX, positionY, width, height);
			if(rpgGame.checkHover(positionX, positionY, width, height)){
				helmet.showInfo = true;
				if(Gdx.input.isButtonPressed(Buttons.RIGHT)){
					dropHelmet();
				}
				if(Gdx.input.justTouched()){
					equipHelmet();
				}
			}
			else{
				helmet.showInfo = false;
			}
		}
		if(legs != null){
			full = true;
			legs.renderIcon(batch, positionX, positionY, width, height);
			if(rpgGame.checkHover(positionX, positionY, width, height)){
				legs.showInfo = true;
				if(Gdx.input.isButtonPressed(Buttons.RIGHT)){
					dropLegs();
				}
				if(Gdx.input.justTouched()){
					equipLegs();
				}
			}
			else{
				legs.showInfo = false;
			}
		}
		if(body != null){
			full = true;
			body.renderIcon(batch, positionX, positionY, width, height);
			if(rpgGame.checkHover(positionX, positionY, width, height)){
				body.showInfo = true;
				if(Gdx.input.isButtonPressed(Buttons.RIGHT)){
					dropBody();
				}
				if(Gdx.input.justTouched()){
					equipBody();
				}
			}
			else{
				body.showInfo = false;
			}
		}
		if(backpiece != null){
			full = true;
			backpiece.renderIcon(batch, positionX, positionY, width, height);
			if(rpgGame.checkHover(positionX, positionY, width, height)){
				backpiece.showInfo = true;
				if(Gdx.input.isButtonPressed(Buttons.RIGHT)){
					dropBackpiece();
				}
				if(Gdx.input.justTouched()){
					equipBackpiece();
				}
			}
			else{
				backpiece.showInfo = false;
			}
		}
	}
	public void sRenderFill(ShapeRenderer render){		
		/*if(rpgGame.checkHover(positionX, positionY, width, height))
			render.setColor(Color.GRAY);
		else
			render.setColor(Color.DARK_GRAY);
		render.rect(positionX, positionY, width, height);*/	
	}
	public void sRenderLine(ShapeRenderer render){
		//render.setColor(Color.ORANGE);
		//render.rect(positionX, positionY, width, height);
	}
	public void setLink(Player player){
		this.player = player;
	}
	public void equipWeapon(){
		if(weapon != null){
			Weapon w = weapon;
			weapon.showInfo = false;
			weapon = null;
			full = false;
			player.equipMainHand(w);
		}
	}
	public void equipHelmet(){
		if(helmet != null){
			Helmet h = helmet;
			helmet.showInfo = false;
			helmet = null;
			full = false;
			player.equipHelmet(h);
		}
	}
	public void equipLegs(){
		if(legs != null){
			Leg l = legs;
			legs.showInfo = false;
			legs = null;
			full = false;
			player.equipLegs(l);
		}
	}
	public void equipBody(){
		if(body != null){
			Body b = body;
			body.showInfo = false;
			body = null;
			full = false;
			player.equipBody(b);
		}
	}
	public void equipBackpiece(){
		if(backpiece != null){
			Backpiece b = backpiece;
			backpiece.showInfo = false;
			backpiece = null;
			full = false;
			player.equipBackpiece(b);
		}
	}
	public void add(Weapon weapon){
		if(!full){
			this.weapon = weapon;
			full = true;
		}
	}
	public void add(Helmet helmet){
		if(!full){
			this.helmet = helmet;
			full = true;
		}
	}
	public void add(Leg legs){
		if(!full){
			this.legs = legs;
			full = true;
		}
	}
	public void add(Body body){
		if(!full){
			this.body = body;
			full = true;
		}
	}
	public void add(Backpiece backpiece){
		if(!full){
			this.backpiece = backpiece;
			full = true;
		}
	}
	public void dropWeapon(){
		if(weapon != null){
			weapon.lootTimer = 0;
			weapon.loot = true;
			weapon.showInfo = false;
			weapon.setPositionX(rpgGame.playerX);
			weapon.setPositionY(rpgGame.playerY);
			rpgGame.map.get(rpgGame.mapIndex).loot.add(weapon);
			weapon = null;
			full = false;
		}
	}
	public void dropHelmet(){
		if(helmet != null){
			helmet.lootTimer = 0;
			helmet.loot = true;
			helmet.showInfo = false;
			helmet.setPositionX(rpgGame.playerX);
			helmet.setPositionY(rpgGame.playerY);
			rpgGame.map.get(rpgGame.mapIndex).loot.add(helmet);
			helmet = null;
			full = false;
		}
	}
	public void dropLegs(){
		if(legs != null){
			legs.lootTimer = 0;
			legs.loot = true;
			legs.showInfo = false;
			legs.setPositionX(rpgGame.playerX);
			legs.setPositionY(rpgGame.playerY);
			rpgGame.map.get(rpgGame.mapIndex).loot.add(legs);
			legs = null;
			full = false;
		}
	}
	public void dropBody(){
		if(body != null){
			body.lootTimer = 0;
			body.loot = true;
			body.showInfo = false;
			body.setPositionX(rpgGame.playerX);
			body.setPositionY(rpgGame.playerY);
			rpgGame.map.get(rpgGame.mapIndex).loot.add(body);
			body = null;
			full = false;
		}
	}
	public void dropBackpiece(){
		if(backpiece != null){
			backpiece.lootTimer = 0;
			backpiece.loot = true;
			backpiece.showInfo = false;
			backpiece.setPositionX(rpgGame.playerX);
			backpiece.setPositionY(rpgGame.playerY);
			rpgGame.map.get(rpgGame.mapIndex).loot.add(backpiece);
			backpiece = null;
			full = false;
		}
	}
	public Weapon getWeapon() {
		return weapon;
	}
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	public Leg getLegs() {
		return legs;
	}
	public boolean isFull() {
		return full;
	}
	public void setLegs(Leg legs) {
		this.legs = legs;
	}
	public void setFull(boolean full) {
		this.full = full;
	}
	public Body getBody() {
		return body;
	}
	public void setBody(Body body) {
		this.body = body;
	}
	public Backpiece getBackpiece() {
		return backpiece;
	}
	public void setBackpiece(Backpiece backpiece) {
		this.backpiece = backpiece;
	}
	public Helmet getHelmet() {
		return helmet;
	}
	public void setHelmet(Helmet helmet) {
		this.helmet = helmet;
	}
}
