package javagame.items;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class ItemFactory {
	private ItemFactory(){
		//No one can instantiate this class! 
	}
	
	public static HealthBuff createHealthBuffItem(){
		try {
			return new HealthBuff(new Image("res/health_medicine_emergency.png"));
		} catch (SlickException e) {
			e.printStackTrace();
			return null;
		}
	}
}
