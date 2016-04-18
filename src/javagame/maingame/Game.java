package javagame.maingame;

import org.newdawn.slick.*;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.*;

public class Game extends StateBasedGame {

	public final Integer MENU = 0;
	public final Integer PLAY = 1;
	
	public Game(String title){
		super(title);
		this.addState(new MainMenu(MENU));
		this.addState(new Play(PLAY));
	}
	
	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(MENU).init(gc, this);
		this.getState(PLAY).init(gc, this);
		this.enterState(MENU);
	}

}
