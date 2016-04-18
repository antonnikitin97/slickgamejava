package javagame.items;

import java.util.HashMap;
import org.newdawn.slick.geom.Rectangle;

public class ItemManager {
	private HashMap<Rectangle, Item> itemsToSpawn;
	
	public ItemManager(){
		itemsToSpawn = new HashMap<Rectangle, Item>();
	}
	
	public void addItemToSpawn(Item itemToAdd){
		itemsToSpawn.put(itemToAdd.createModelRectangle(), itemToAdd);
	}
	
	public void removeItemFromSpawn(Rectangle itemToRemove){
		itemsToSpawn.remove(itemsToSpawn.get(itemToRemove));
	}
}
