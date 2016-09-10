package javagame.items;

import javagame.interfaces.InventoryAccessor;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;
import javagame.constants.ItemTypes;

public abstract class Item{

	private float itemX;
	private float itemY;
	private Image model;
	private Rectangle modelRectangle;
	private ItemTypes id;
    private float itemWidth;
    private float itemHeight;

	protected char itemUseKey;
	
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

	public final Integer getId(){
		return this.id.getId();
	}

	public ItemTypes getType(){
		return this.id;
	}

	@Override
	public final String toString(){
		return this.id.toString();
	}

	public final void render(float itemOffSetX, float itemOffSetY){
		model.draw(modelRectangle.getX() + itemOffSetX, modelRectangle.getY() + itemOffSetY, itemWidth, itemHeight);
	}

	public char getItemUseKey() {
		return itemUseKey;
	}

	@Override
	public boolean equals(Object comparator){
		if(comparator instanceof Item){
			Item i = (Item)comparator;
			if(i.getId() == this.getId()) {
				return true;
			}
		}
		return false;
	}
}
