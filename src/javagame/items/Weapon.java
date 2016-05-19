package javagame.items;

import javagame.constants.ItemTypes;
import org.newdawn.slick.Image;

public class Weapon extends Item{

    public Weapon(Image model, float itemX, float itemY, float itemWidth, float itemHeight, ItemTypes id) {
        super(model, itemX, itemY, itemWidth, itemHeight, id);
    }
}
