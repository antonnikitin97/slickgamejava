package javagame.items;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;
import javagame.constants.ItemTypes;
import javagame.interfaces.Useable;

public abstract class Item implements Useable {

	private float itemX;
	private float itemY;
	private Image model;
	private Rectangle modelRectangle;
	private ItemTypes id;
	
	public Item(Image model, float itemX, float itemY) {
		this.model = model;
        this.itemX = itemX;
        this.itemY = itemY;

		modelRectangle = new Rectangle(itemX, itemY, model.getWidth(), model.getHeight());
	}
	
	public final boolean intersects(Rectangle rectangle){
		return modelRectangle.intersects(rectangle);
	}

	public final Integer getId(){
		return this.id.getId();
	}

	public final void render(){
		model.draw(itemX, itemY, model.getWidth(), model.getHeight());
	}

}
