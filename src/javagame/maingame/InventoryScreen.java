package javagame.maingame;

import javagame.constants.ItemTypes;
import javagame.*;
import javagame.interfaces.InventoryAccessor;
import javagame.items.Item;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;

/**
 * Created by anton on 19/04/2016.
 */
public class InventoryScreen extends BasicGameState {

    private Integer stateID;
    private static InventoryAccessor playerInventoryAccessor;
    private ArrayList<String> namesOfItems;

    public InventoryScreen(Integer stateID){
        this.stateID = stateID;
        namesOfItems = new ArrayList<>();
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
        for(String item : namesOfItems){
            graphics.drawString(item + "\n", 50, 50);
        }
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        if(namesOfItems.size() != playerInventoryAccessor.playerInventory().size()){
            for(Item item : playerInventoryAccessor.playerInventory().keySet()){
                namesOfItems.add(item.toString());
            }
        }
    }

    public static void setPlayerInventoryAccessor(InventoryAccessor playerInventoryAccessorToSet){
        playerInventoryAccessor = playerInventoryAccessorToSet;
    }
}
