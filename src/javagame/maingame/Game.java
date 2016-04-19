package javagame.maingame;

import javagame.player.Player;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.*;

public class Game extends StateBasedGame {

	private final Integer MENU = 0;
	private final Integer PLAY = 1;
	private final Integer INVENTORY = 2;
	private Player player;
	
	public Game(String title){
		super(title);
		player = new Player();
		this.addState(new MainMenu(MENU));
		this.addState(new Play(PLAY, player));
		this.addState(new Inventory(INVENTORY, player));
	}
	
	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(MENU).init(gc, this);
		this.getState(PLAY).init(gc, this);
		this.getState(INVENTORY).init(gc, this);
		this.enterState(MENU);
	}

}