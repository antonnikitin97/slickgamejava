package javagame.interfaces;

import javagame.items.Item;

import java.util.HashMap;

/**
 * Created by anton on 20/04/2016.
 */
public interface InventoryAccessor {
    HashMap<Item, Integer> playerInventory();
}
