package javagame.items;

import javagame.constants.ItemTypes;
import org.newdawn.slick.Image;

public class HealthBuff extends Item {

	private java.lang.Integer healthIncrease;
	
	public HealthBuff(Image model, float itemX, float itemY, float width, float height){
		super(model, itemX, itemY, width, height, ItemTypes.HEALTH_BUFF);
		this.healthIncrease = 2;
	}
	
	public java.lang.Integer getHealthIncrease() {
		return healthIncrease;
	}
	
	@Override
	public void use() {
		
	}
}