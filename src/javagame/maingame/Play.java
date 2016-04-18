package javagame.maingame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import javagame.player.Player;

public class Play extends BasicGameState {

	private Player player;
	private final Integer state;
	private Input gameInput;
	private Image worldMap;
	private boolean quit;
	
	public Play(Integer state){
		this.state = state;
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame game) throws SlickException {
		quit = false;
		worldMap = new Image("res/world.png");
		gameInput = gc.getInput();
		player = new Player();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
		worldMap.draw(player.getPlayerX(), player.getPlayerY());
		this.player.getPlayerCurrent().draw(player.getShiftX(), player.getShiftY());
		//g.drawString("Bucky X: " + playerX +"\nBucky Y: " + playerY, 400, 20);

        g.fill(player.playerRectangle);
		g.draw(player.playerRectangle);

		if(quit){
			g.drawString("Resume (R)", 250, 100);
			g.drawString("Main Menu (M)", 250, 150);
			g.drawString("Quit (Q)", 250, 200);
			if(!quit){
				g.clear();
			}
		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException {
			if(gameInput.isKeyDown(Input.KEY_UP) && player.getPlayerY() < 159.500f){
				player.setPlayerCurrent(player.getMovingUp());
				player.setPlayerY(player.getPlayerY() + (delta * player.getPlayerSpeedMultiplier()));
			}
			if(gameInput.isKeyDown(Input.KEY_DOWN) && player.getPlayerY() > -601.399){
				player.setPlayerCurrent(player.getMovingDown());
				player.setPlayerY(player.getPlayerY() - (delta * player.getPlayerSpeedMultiplier()));
			}
			if(gameInput.isKeyDown(Input.KEY_LEFT) && player.getPlayerX() < 319.710){
				player.setPlayerCurrent(player.getMovingLeft());
				player.setPlayerX(player.getPlayerX() + (delta * player.getPlayerSpeedMultiplier()));
			}
			if(gameInput.isKeyDown(Input.KEY_RIGHT) && player.getPlayerX() > -839.744){
				player.setPlayerCurrent(player.getMovingRight());
				player.setPlayerX(player.getPlayerX() - (delta * player.getPlayerSpeedMultiplier()));
			}
		if(gameInput.isKeyDown(Input.KEY_ESCAPE)){
			quit = true;
		}
		if(quit){
			if(gameInput.isKeyPressed(Input.KEY_R)){ 
				quit = false; 
			}
			if(gameInput.isKeyPressed(Input.KEY_M)){ 
				game.enterState(0, new FadeOutTransition(), new FadeInTransition()); 
			}
			if(gameInput.isKeyPressed(Input.KEY_Q)){ 
				System.exit(0);
			}
		}
	}

	@Override
	public int getID() {
		return this.state;
	}
	
}
