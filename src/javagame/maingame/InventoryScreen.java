package javagame.maingame;

import javagame.constants.ItemTypes;
import javagame.*;
import javagame.interfaces.InventoryAccessor;
import javagame.interfaces.ItemListener;
import javagame.items.Item;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import java.util.HashMap;

/**
 * Created by anton on 19/04/2016.
 */
public class InventoryScreen extends BasicGameState{

    private Integer stateID;
    private static InventoryAccessor playerInventoryAccessor;
    private HashMap<Item, Integer> inventoryOfPlayer;
    private Input gameInput;
    private static ItemListener itemListener;

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
        this.gameInput = gameContainer.getInput();
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        for(Item item : inventoryOfPlayer.keySet()){
            graphics.drawString("Item: " + item.toString() +
                    " - Quantity: " + inventoryOfPlayer.get(item) + " - Use: " + item.getItemUseKey(), 50, 50);
        }
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        if(gameInput.isKeyPressed(Input.KEY_G)){
            stateBasedGame.enterState(1, new FadeOutTransition(Color.blue), new FadeInTransition(Color.red));
        }
        for(Item i : inventoryOfPlayer.keySet()){
            if(gameInput.isKeyPressed(i.getItemUseKey())){
                itemListener.itemUsed(i.getType());
                System.out.println("Fired!");
            }
        }
    }

    @Override
    public void enter(GameContainer container, StateBasedGame game) throws SlickException {
        inventoryOfPlayer = playerInventoryAccessor.getQuantitiesAndItems();
    }

    @Override
    public void leave(GameContainer container, StateBasedGame game) throws SlickException {
    }

    public static void setPlayerInventoryAccessor(InventoryAccessor playerInventoryAccessorToSet){
        playerInventoryAccessor = playerInventoryAccessorToSet;
    }

    public static void setItemListener(ItemListener itemListenerToSet){
        itemListener = itemListenerToSet;
    }
}