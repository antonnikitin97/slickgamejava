package javagame.maingame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.*;

public class Game extends StateBasedGame {

	private final Integer MENU = 0;
	private final Integer PLAY = 1;
	private final Integer INVENTORY = 2;

	public Game(String title){
		super(title);
		this.addState(new MainMenu(MENU));
		this.addState(new Play(PLAY));
		this.addState(new InventoryScreen(INVENTORY));
	}
	
	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(MENU).init(gc, this);
		this.getState(PLAY).init(gc, this);
		this.getState(INVENTORY).init(gc, this);
		this.enterState(MENU);
	}

}