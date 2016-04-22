package javagame.maingame;

import javagame.constants.ItemTypes;
import javagame.*;
import javagame.interfaces.InventoryAccessor;
import javagame.items.Item;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tests.PackedSheetTest;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by anton on 19/04/2016.
 */
public class InventoryScreen extends BasicGameState {

    private Integer stateID;
    private static InventoryAccessor playerInventoryAccessor;
    private HashMap<Item, Integer> inventoryOfPlayer;
    private Integer counterVariable;

    public InventoryScreen(Integer stateID){
        this.stateID = stateID;
        inventoryOfPlayer = new HashMap<>();
    }

    @Override
    public int getID() {
        return this.stateID;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        if(counterVariable != inventoryOfPlayer.size()){
            for(Item item : inventoryOfPlayer.keySet()){
                graphics.drawString("Item: " + item.toString()
                + " Quantity: " + inventoryOfPlayer.get(item), 50, 50);
                counterVariable++;
            }
        }
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
    }

    @Override
    public void enter(GameContainer container, StateBasedGame game) throws SlickException {
        inventoryOfPlayer = playerInventoryAccessor.getQuantitiesAndItems();
    }

    @Override
    public void leave(GameContainer container, StateBasedGame game) throws SlickException {
        counterVariable = 0;
    }

    public static void setPlayerInventoryAccessor(InventoryAccessor playerInventoryAccessorToSet){
        playerInventoryAccessor = playerInventoryAccessorToSet;
    }
}