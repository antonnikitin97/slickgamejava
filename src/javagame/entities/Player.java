package javagame.entities;

import java.util.HashMap;

import javagame.constants.ItemTypes;
import javagame.interfaces.InventoryAccessor;
import javagame.interfaces.ItemListener;
import javagame.maingame.InventoryScreen;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;
import javagame.items.Item;

public class Player extends Entity implements InventoryAccessor, ItemListener{
    private static Player instance;
	private HashMap<Item, Integer> inventory;

    public static Player getInstance(Integer health, Float speedMultiplier, int[] duration, Image[] walkUp, Image[] walkDown,
									 Image[] walkLeft, Image[] walkRight){
        if(instance == null) {
            return instance = new Player(health, speedMultiplier, duration, walkUp, walkDown,
					walkLeft, walkRight);
        }else
            return instance;
    }

	private Player(Integer health, Float speedMultiplier, int[] duration, Image[] walkUp, Image[] walkDown,
				   Image[] walkLeft, Image[] walkRight){

		super(health, speedMultiplier, duration, walkUp, walkDown,
				walkLeft, walkRight);
		this.inventory = new HashMap<>();
		InventoryScreen.setPlayerInventoryAccessor(this);
		InventoryScreen.setItemListener(this);
		entityCurrent = movingDown;
        entityRectangle = new Rectangle(entityScreenX, entityScreenY, entityCurrent.getWidth(), entityCurrent.getHeight());
	}

	public float getPlayerSpeedMultiplier(){
		return this.speedMultiplier;
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

	@Override
	public void itemUsed(ItemTypes id) {
		switch (id){
			case HEALTH_BUFF:
				this.addHealth(2);
				System.out.println("Success!");
				break;
		}
	}
}