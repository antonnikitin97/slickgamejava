package javagame.maingame;

import javagame.constants.ItemTypes;
import javagame.items.Item;
import javagame.items.ItemFactory;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import javagame.player.Player;
import java.util.ArrayList;

public class Play extends BasicGameState {

	private Player player;
	private final Integer state;
	private Input gameInput;
	private Image worldMap;
	private boolean quit;
    private ArrayList<Item> items;
    private ItemFactory factory;
	private Rectangle worldSpaceRectangle;
	
	public Play(Integer state, Player player){
		this.state = state;
		this.player = player;
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame game) throws SlickException {
		quit = false;
		worldMap = new Image("res/world.png");
		gameInput = gc.getInput();
        items = new ArrayList<>();
        factory = ItemFactory.getInstance();
		worldSpaceRectangle = new Rectangle(320 - player.getPlayerWorldX(), 160 - player.getPlayerWorldY() , player.getPlayerRectangle().getWidth()
				,player.getPlayerRectangle().getHeight());

        items.add(factory.getItem(ItemTypes.HEALTH_BUFF, 50, 50));
	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
		worldMap.draw(player.getPlayerWorldX(), player.getPlayerWorldY());
		this.player.getPlayerCurrent().draw(player.getPlayerScreenX(), player.getPlayerScreenY());
		//g.drawString("Bucky X: " + playerX +"\nBucky Y: " + playerY, 400, 20);

		g.fill(worldSpaceRectangle);
		g.draw(worldSpaceRectangle);

        for (Item i : items){
            i.render(player.getPlayerWorldX(), player.getPlayerWorldY());
        }

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
        worldSpaceRectangle = new Rectangle(320 - player.getPlayerWorldX(), 160 - player.getPlayerWorldY() , player.getPlayerRectangle().getWidth()
        ,player.getPlayerRectangle().getHeight());

		items.removeIf(item -> {player.addItemToInventory(item);
			return item.intersects(worldSpaceRectangle);});

        if(gameInput.isKeyDown(Input.KEY_UP) && player.getPlayerWorldY() < 159.500f){
				player.setPlayerCurrent(player.getMovingUp());
				player.setPlayerWorldY(player.getPlayerWorldY() + (delta * player.getPlayerSpeedMultiplier()));
			}
			if(gameInput.isKeyDown(Input.KEY_DOWN) && player.getPlayerWorldY() > -601.399){
				player.setPlayerCurrent(player.getMovingDown());
				player.setPlayerWorldY(player.getPlayerWorldY() - (delta * player.getPlayerSpeedMultiplier()));
			}
			if(gameInput.isKeyDown(Input.KEY_LEFT) && player.getPlayerWorldX() < 319.710){
				player.setPlayerCurrent(player.getMovingLeft());
				player.setPlayerWorldX(player.getPlayerWorldX() + (delta * player.getPlayerSpeedMultiplier()));
			}
			if(gameInput.isKeyDown(Input.KEY_RIGHT) && player.getPlayerWorldX() > -839.744){
				player.setPlayerCurrent(player.getMovingRight());
				player.setPlayerWorldX(player.getPlayerWorldX() - (delta * player.getPlayerSpeedMultiplier()));
			}
			if(gameInput.isKeyDown(Input.KEY_I)){
				game.enterState(2, new FadeOutTransition(), new FadeInTransition());
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