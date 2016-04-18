package javagame.items;

import javagame.constants.ItemTypes;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.util.HashMap;

public class ItemFactory {
	private static ItemFactory instance;
	private HashMap<Integer, Image> itemImages;

	public static ItemFactory getInstance(){
		if(instance == null){
			return instance = new ItemFactory();
		}
		return instance;
	}

	private ItemFactory(){
		itemImages = new HashMap<>();
		try{
			itemImages.put(ItemTypes.HEALTH_BUFF.getId(), new Image("res/items/health.png"));
		}
		catch (SlickException e){
			e.printStackTrace();
		}
	}

	public Item getItem(ItemTypes id, float x, float y){
		Image itemModel = itemImages.get(id.getId());

		switch(id){
			case HEALTH_BUFF:
				return new HealthBuff(itemModel, x, y, 30, 30);
		}
		return null;
	}
}
