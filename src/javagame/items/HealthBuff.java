package javagame.items;

import org.newdawn.slick.Image;

public class HealthBuff extends Item {

	private Integer healthIncrease;
	
	public HealthBuff(Image model, float itemX, float itemY, float width, float height){
		super(model, itemX, itemY, width, height);
		this.healthIncrease = 2;
	}
	
	public Integer getHealthIncrease() {
		return healthIncrease;
	}
	
	@Override
	public void use() {
		
	}
}