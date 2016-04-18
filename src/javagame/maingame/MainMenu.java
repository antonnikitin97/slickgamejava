package javagame.maingame;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class MainMenu extends BasicGameState {

	private final Integer state;
	private Input gameInput;
	private Image playButton;
	private Image exitButton;
	private Integer mouseX;
	private Integer mouseY;
	
	public MainMenu(Integer state){
		this.state = state;
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame game) throws SlickException {
		playButton = new Image("res/playNow.png");
		exitButton = new Image("res/exitGame.png");
		gameInput = gc.getInput();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
		g.drawString("Welcome to Bucky World!", 100, 50);
		playButton.draw(100, 100);
		exitButton.draw(100, 200);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException {
		mouseX = Mouse.getX();
		mouseY = Mouse.getY();
		// Exit Button
		if((mouseX > 100 && mouseX < 311)
			&& (mouseY > 109 && mouseY < 160)){
			if(gameInput.isMousePressed(Input.MOUSE_LEFT_BUTTON)){
				System.exit(0);
			}
		}
		//Play Button
		if((mouseX > 100 && mouseX < 311)
				&& (mouseY > 209 && mouseY < 260)){
				if(gameInput.isMousePressed(Input.MOUSE_LEFT_BUTTON)){
					game.enterState(1, new FadeOutTransition() , new FadeInTransition());
				}
			}
	}

	@Override
	public int getID() {
		return this.state;
	}

}
