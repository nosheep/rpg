package com.nosheep.tools;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.nosheep.assets.AssetLoader;
import com.nosheep.items.Backpiece;
import com.nosheep.items.Body;
import com.nosheep.items.Coins;
import com.nosheep.items.Helmet;
import com.nosheep.items.Item;
import com.nosheep.items.Leg;
import com.nosheep.items.Weapon;
import com.nosheep.main.rpgGame;
import com.nosheep.player.Player;

public class Inventory extends Window implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2525916153136495041L;
	public List<InventorySlot> slots = new ArrayList<InventorySlot>(66);
	private Player player;
	
	public Inventory(String text, int positionX, int positionY, int width,
			int height, Player player) {
		super(text, positionX, positionY, width, height);
		this.player = player;
		for(int i=0; i<=65; i++)
			slots.add(new InventorySlot(positionX, positionY, player));
	}
	public boolean isBagFull(){
		boolean full = true;
		for(InventorySlot s : slots){
			if(!s.full) {
				full = false;
				break;
			}
		}
		return full;
	}
	
	
	@Override
	public void render(SpriteBatch batch) {
		super.render(batch);
		if(isActive()){
			for(InventorySlot s : slots){
				s.render(batch);
				// WEAPONS //
				if(s.getWeapon() != null && s.getWeapon().showInfo){
					batch.draw(AssetLoader.slot, positionX - 300, positionY, 300, 280);
					batch.draw(AssetLoader.ui, positionX - 290, positionY + 10, 290, 260);
					if(s.getWeapon().isRare())
						rpgGame.font.setColor(Color.GREEN);
					else
						rpgGame.font.setColor(Color.ORANGE);
					rpgGame.font.draw(batch, s.getWeapon().getName(), positionX - 280, getPositionY() + 10);
					rpgGame.font.setColor(Color.LIGHT_GRAY);
					rpgGame.font.draw(batch, "Melee damage: " + Integer.toString(s.getWeapon().meleeDamage), positionX - 280, positionY + 60);
					rpgGame.font.draw(batch, "Range damage: " + Integer.toString(s.getWeapon().rangedDamage), positionX - 280, positionY + 100);
					rpgGame.font.draw(batch, "Magic damage: " + Integer.toString(s.getWeapon().magicDamage), positionX - 280, positionY + 140);
					rpgGame.font.setColor(Color.ORANGE);
					rpgGame.font.draw(batch, "Left-Click: Equip", positionX - 280, positionY + 200);
					rpgGame.font.draw(batch, "Right-Click: Drop", positionX - 280, positionY + 240);
				}
				// HELMETS //
				if(s.getHelmet() != null && s.getHelmet().showInfo){
					batch.draw(AssetLoader.slot, positionX - 300, positionY, 300, 280);
					batch.draw(AssetLoader.ui, positionX - 290, positionY + 10, 290, 260);
					rpgGame.font.setColor(Color.ORANGE);
					rpgGame.font.draw(batch, s.getHelmet().getName(), positionX - 280, positionY + 10);
					rpgGame.font.setColor(Color.LIGHT_GRAY);
					rpgGame.font.draw(batch, "Melee damage: " + Integer.toString(s.getHelmet().meleeDamage), positionX - 280, positionY + 60);
					rpgGame.font.draw(batch, "Range damage: " + Integer.toString(s.getHelmet().rangedDamage), positionX - 280, positionY + 100);
					rpgGame.font.draw(batch, "Magic damage: " + Integer.toString(s.getHelmet().magicDamage), positionX - 280, positionY + 140);
					rpgGame.font.setColor(Color.ORANGE);
					rpgGame.font.draw(batch, "Left-Click: Equip", positionX - 280, positionY + 200);
					rpgGame.font.draw(batch, "Right-Click: Drop", positionX - 280, positionY + 240);
				}
				//
				// LEGS //
				if(s.getLegs() != null && s.getLegs().showInfo){
					batch.draw(AssetLoader.slot, positionX - 300, positionY, 300, 280);
					batch.draw(AssetLoader.ui, positionX - 290, positionY + 10, 290, 260);
					rpgGame.font.setColor(Color.ORANGE);
					rpgGame.font.draw(batch, s.getLegs().getName(), positionX - 280, positionY + 10);
					rpgGame.font.setColor(Color.LIGHT_GRAY);
					rpgGame.font.draw(batch, "Melee damage: " + Integer.toString(s.getLegs().meleeDamage), positionX - 280, positionY + 60);
					rpgGame.font.draw(batch, "Range damage: " + Integer.toString(s.getLegs().rangedDamage), positionX - 280, positionY + 100);
					rpgGame.font.draw(batch, "Magic damage: " + Integer.toString(s.getLegs().magicDamage), positionX - 280, positionY + 140);
					rpgGame.font.setColor(Color.ORANGE);
					rpgGame.font.draw(batch, "Left-Click: Equip", positionX - 280, positionY + 200);
					rpgGame.font.draw(batch, "Right-Click: Drop", positionX - 280, positionY + 240);
				}
				//
				if(s.getBody() != null && s.getBody().showInfo){
					batch.draw(AssetLoader.slot, positionX - 300, positionY, 300, 280);
					batch.draw(AssetLoader.ui, positionX - 290, positionY + 10, 290, 260);
					rpgGame.font.setColor(Color.ORANGE);
					rpgGame.font.draw(batch, s.getBody().getName(), positionX - 280, positionY + 10);
					rpgGame.font.setColor(Color.LIGHT_GRAY);
					rpgGame.font.draw(batch, "Melee damage: " + Integer.toString(s.getBody().meleeDamage), positionX - 280, positionY + 60);
					rpgGame.font.draw(batch, "Range damage: " + Integer.toString(s.getBody().rangedDamage), positionX - 280, positionY + 100);
					rpgGame.font.draw(batch, "Magic damage: " + Integer.toString(s.getBody().magicDamage), positionX - 280, positionY + 140);
					rpgGame.font.setColor(Color.ORANGE);
					rpgGame.font.draw(batch, "Left-Click: Equip", positionX - 280, positionY + 200);
					rpgGame.font.draw(batch, "Right-Click: Drop", positionX - 280, positionY + 240);
				}
				// BACKPIECE //
				if(s.getBackpiece() != null && s.getBackpiece().showInfo){
					batch.draw(AssetLoader.slot, positionX - 300, positionY, 300, 280);
					batch.draw(AssetLoader.ui, positionX - 290, positionY + 10, 290, 260);
					rpgGame.font.setColor(Color.ORANGE);
					rpgGame.font.draw(batch, s.getBackpiece().getName(), positionX - 280, positionY + 10);
					rpgGame.font.setColor(Color.LIGHT_GRAY);
					rpgGame.font.draw(batch, "Melee damage: " + Integer.toString(s.getBackpiece().meleeDamage), positionX - 280, positionY + 60);
					rpgGame.font.draw(batch, "Range damage: " + Integer.toString(s.getBackpiece().rangedDamage), positionX - 280, positionY + 100);
					rpgGame.font.draw(batch, "Magic damage: " + Integer.toString(s.getBackpiece().magicDamage), positionX - 280, positionY + 140);
					rpgGame.font.setColor(Color.ORANGE);
					rpgGame.font.draw(batch, "Left-Click: Equip", positionX - 280, positionY + 200);
					rpgGame.font.draw(batch, "Right-Click: Drop", positionX - 280, positionY + 240);
				}
			}
			try{
				batch.draw(AssetLoader.coins, positionX + 10, positionY + height - 60, 80, 50);
				rpgGame.font.setColor(Color.YELLOW);
				rpgGame.font.draw(batch, ": " + player.getCoins(), positionX + 100, positionY + height - 50);	
			}
			catch(NullPointerException ex){}
		}
	}
	@Override
	public void sRenderFill(ShapeRenderer render) {
		super.sRenderFill(render);
		if(isActive()){
			int x = 10,
					y = 70;
				for(int i=0; i<slots.size(); i++){
					slots.get(i).update(positionX + x, positionY + y);
					x += 60;
					if(i % 6 == 5){
						y += 60;
						x = 10;
					}
				}
			for(InventorySlot s : slots){
				s.sRenderFill(render);
				if(s.getWeapon() != null && s.getWeapon().showInfo){
					s.getWeapon().renderInfo(render, positionX - 290, positionY);
				}
			}
		}
	}
	@Override
	public void sRenderLine(ShapeRenderer render) {
		super.sRenderLine(render);
	}
	public void add(Item i){
		if(i.getClass() == Coins.class){
			Coins c = (Coins) i;
			player.setCoins(player.getCoins() + c.amount);
			rpgGame.map.get(rpgGame.mapIndex).loot.remove(i);
		}
		else {
			if(!isBagFull()){
				if(i.getClass().getSuperclass() == Weapon.class) {
					Weapon weapon = (Weapon) i;
					for(InventorySlot s : slots){
						if(s.getWeapon() == null && s.getLegs() == null && s.getHelmet() == null && s.getBody() == null && s.getBackpiece() == null)
							s.full = false;
						if(!s.full){
							s.add(weapon);
							break;
						}
					}
				}
				else if(i.getClass().getSuperclass() == Helmet.class) {
					Helmet helmet = (Helmet) i;
					for(InventorySlot s : slots){
						if(s.getWeapon() == null && s.getHelmet() == null && s.getLegs() == null && s.getBody() == null && s.getBackpiece() == null)
							s.full = false;
						if(!s.full){
							s.add(helmet);
							break;
						}
					}
				}
				else if(i.getClass().getSuperclass() == Leg.class) {
					Leg legs = (Leg) i;
					for(InventorySlot s : slots){
						if(s.getWeapon() == null && s.getLegs() == null && s.getHelmet() == null && s.getBody() == null && s.getBackpiece() == null)
							s.full = false;
						if(!s.full){
							s.add(legs);
							break;
						}
					}
				}
				else if(i.getClass().getSuperclass() == Body.class) {
					Body body = (Body) i;
					for(InventorySlot s : slots){
						if(s.getWeapon() == null && s.getLegs() == null && s.getHelmet() == null && s.getBody() == null && s.getBackpiece() == null)
							s.full = false;
						if(!s.full){
							s.add(body);
							break;
						}
					}
				}
				else if(i.getClass().getSuperclass() == Backpiece.class) {
					Backpiece backpiece = (Backpiece) i;
					for(InventorySlot s : slots){
						if(s.getWeapon() == null && s.getLegs() == null && s.getHelmet() == null && s.getBody() == null && s.getBackpiece() == null)
							s.full = false;
						if(!s.full){
							s.add(backpiece);
							break;
						}
					}
				}
				try{
					rpgGame.map.get(rpgGame.mapIndex).loot.remove(i);
				} catch(NullPointerException ex){}
			}
			else{
				System.out.println("Bag is full.");
			}
		}
	}
	public void setLink(Player player){
		this.player = player;
		for(int i=0; i<=65; i++)
			slots.get(i).setLink(player);
	}

}
