package javagame.items;

import javagame.constants.ItemTypes;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.util.HashMap;

public class ItemFactory {
	private ItemFactory instance;
	private HashMap<Integer, Image> itemImages;

	public ItemFactory getInstance(){
		if(instance == null){
			instance = new ItemFactory();
		}
		return instance;
	}

	private ItemFactory(){
		itemImages = new HashMap<>();
	}

	public Item getItem(ItemTypes id, float x, float y){
		Image itemModel = itemImages.get(id.getId());

		switch(id){
			case HEATLTH_BUFF:
				return new HealthBuff(itemModel, x, y);
		}
		return null;
	}
}
