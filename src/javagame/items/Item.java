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
    private float itemWidth;
    private float itemHeight;
	
	public Item(Image model, float itemX, float itemY, float itemWidth, float itemHeight, ItemTypes id) {
		this.model = model;
        this.itemX = itemX;
        this.itemY = itemY;
        this.itemWidth = itemWidth;
        this.itemHeight = itemHeight;
		this.id = id;
        modelRectangle = new Rectangle(itemX, itemY, itemWidth, itemHeight);
    }

	public final boolean intersects(Rectangle rectangle){
		return modelRectangle.intersects(rectangle);
	}

	public final java.lang.Integer getId(){
		return this.id.getId();
	}

	public final String toString(){
		return this.id.toString();
	}

	public final void render(float itemOffSetX, float itemOffSetY){
		model.draw(modelRectangle.getX() + itemOffSetX, modelRectangle.getY() + itemOffSetY, itemWidth, itemHeight);
	}
}
