package javagame.items;

import javagame.constants.ItemTypes;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;

public class HealthBuff extends Item{
	
	public HealthBuff(Image model, float itemX, float itemY, float width, float height){
		super(model, itemX, itemY, width, height, ItemTypes.HEALTH_BUFF);
		this.itemInputKey = Input.KEY_H;
	}
}