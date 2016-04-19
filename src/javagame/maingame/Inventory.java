package javagame.maingame;

import javagame.player.Player;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * Created by anton on 19/04/2016.
 */
public class Inventory extends BasicGameState {

    private Integer stateID;
    private Player player;

    public Inventory(Integer stateID){
        this.stateID = stateID;
        this.player = Player.getInstance();
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

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

    }
}
