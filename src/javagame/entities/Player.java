package javagame.entities;

import java.util.HashMap;

import javagame.interfaces.InventoryAccessor;
import javagame.maingame.InventoryScreen;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import javagame.items.Item;

public class Player extends Entity implements InventoryAccessor{
    private static Player instance;
	private HashMap<Item, Integer> inventory;

    public static Player getInstance(){
        if(instance == null) {
            return instance = new Player();
        }else
            return instance;
    }

	private Player(){
		this.inventory = new HashMap<>();
		this.health = 10;
		this.SpeedMultiplier = 0.1f;
		InventoryScreen.setPlayerInventoryAccessor(this);

		duration = new int[] {200 ,200};
		
		try{
			walkUp = new Image[]{new Image("res/buckysBack.png"), new Image("res/buckysBack.png")};
			walkDown = new Image[]{new Image("res/buckysFront.png"), new Image("res/buckysFront.png")};
			walkLeft = new Image[]{new Image("res/buckysLeft.png"), new Image("res/buckysLeft.png")};
			walkRight = new Image[]{new Image("res/buckysRight.png"), new Image("res/buckysRight.png")};
		}
		catch(SlickException e){
			e.printStackTrace();
		}
		
		movingUp = new Animation(walkUp, duration, false);
		movingDown = new Animation(walkDown, duration, false);
		movingLeft = new Animation(walkLeft, duration, false);
		movingRight = new Animation(walkRight, duration, false);
		
		entityCurrent = movingDown;
        entityRectangle = new Rectangle(entityScreenX, entityScreenY, entityCurrent.getWidth(), entityCurrent.getHeight());
	}

	public float getPlayerScreenX() {
		return entityScreenX;
	}

	public float getPlayerScreenY() {
		return entityScreenY;
	}

	public float getPlayerSpeedMultiplier(){
		return this.SpeedMultiplier;
	}

    public Rectangle getPlayerRectangle() {
        return entityRectangle;
    }

	public void addItemToInventory(Item itemToAdd) {
		for (Item i : inventory.keySet()) {
			if (i.equals(itemToAdd)) {
				inventory.put(i, inventory.get(i) + 1);
				return;
			}
		}
		inventory.put(itemToAdd, 1);
	}

	@Override
	public HashMap<Item, Integer> getQuantitiesAndItems() {
		return new HashMap<>(inventory);
	}
}