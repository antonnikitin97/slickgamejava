package javagame.items;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;
import javagame.constants.Types;
import javagame.interfaces.Useable;

public abstract class Item implements Useable {
	
	protected static ItemManager itemManager;
	private float itemX;
	private float itemY;
	private Image model;
	private Rectangle modelRectangle;
	private Types id;

	static {
		itemManager = new ItemManager();
	}
	
	public Item(Image model){
		id = Types.ITEM;
		this.model = model;
	}
	
	public Types getId() {
		return this.id;
	}
	
	public Rectangle createModelRectangle(){
		return new Rectangle(itemX, itemY, model.getHeight(), model.getWidth());
	}
	
	public float getItemX() {
		return itemX;
	}

	public float getItemY() {
		return itemY;
	}

	public void setItemX(float itemX) {
		this.itemX = itemX;
	}
	
	public void setItemY(float itemY) {
		this.itemY = itemY;
	}
}
