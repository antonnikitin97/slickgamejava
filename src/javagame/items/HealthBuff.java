package javagame.items;

import org.newdawn.slick.Image;

public class HealthBuff extends Item {

	private Integer healthIncrease;
	
	public HealthBuff(Image model, float itemX, float itemY){
		super(model, itemX, itemY);
		this.healthIncrease = 2;
	}
	
	public Integer getHealthIncrease() {
		return healthIncrease;
	}
	
	@Override
	public void use() {
		
	}
}