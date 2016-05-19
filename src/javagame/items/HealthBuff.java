package javagame.items;

import javagame.constants.ItemTypes;
import javagame.interfaces.ItemListener;
import org.newdawn.slick.Image;

public class HealthBuff extends Item{
	
	public HealthBuff(Image model, float itemX, float itemY, float width, float height){
		super(model, itemX, itemY, width, height, ItemTypes.HEALTH_BUFF);
		this.itemUseKey = 'H';
	}
}