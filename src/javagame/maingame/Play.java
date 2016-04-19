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
import java.util.Iterator;

public class Play extends BasicGameState {

	private Player player;
	private final Integer state;
	private Input gameInput;
	private Image worldMap;
	private boolean quit;
    private ArrayList<Item> items;
    private ItemFactory factory;
	private Rectangle worldSpaceRectangle;
	
	public Play(Integer state){
		this.state = state;
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame game) throws SlickException {
		quit = false;
		worldMap = new Image("res/world.png");
		gameInput = gc.getInput();
		player = new Player();
        items = new ArrayList<>();
        factory = ItemFactory.getInstance();
		worldSpaceRectangle = new Rectangle(320 - player.getPlayerMapX(), 160 - player.getPlayerMapY() , player.getPlayerRectangle().getWidth()
				,player.getPlayerRectangle().getHeight());

        items.add(factory.getItem(ItemTypes.HEALTH_BUFF, 50, 50));
	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
		worldMap.draw(player.getPlayerMapX(), player.getPlayerMapY());
		this.player.getPlayerCurrent().draw(player.getPlayerScreenX(), player.getPlayerScreenY());
		//g.drawString("Bucky X: " + playerX +"\nBucky Y: " + playerY, 400, 20);

		g.fill(worldSpaceRectangle);
		g.draw(worldSpaceRectangle);

        for (Item i : items){
            i.render(player.getPlayerMapX(), player.getPlayerMapY());
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
        worldSpaceRectangle = new Rectangle(320 - player.getPlayerMapX(), 160 - player.getPlayerMapY() , player.getPlayerRectangle().getWidth()
        ,player.getPlayerRectangle().getHeight());

        Iterator<Item> itemIterator = items.iterator();
        while(itemIterator.hasNext()){
            if(itemIterator.next().intersects(worldSpaceRectangle)){
                System.out.println("AHH");
            }
        }

        if(gameInput.isKeyDown(Input.KEY_UP) && player.getPlayerMapY() < 159.500f){
				player.setPlayerCurrent(player.getMovingUp());
				player.setPlayerMapY(player.getPlayerMapY() + (delta * player.getPlayerSpeedMultiplier()));
			}
			if(gameInput.isKeyDown(Input.KEY_DOWN) && player.getPlayerMapY() > -601.399){
				player.setPlayerCurrent(player.getMovingDown());
				player.setPlayerMapY(player.getPlayerMapY() - (delta * player.getPlayerSpeedMultiplier()));
			}
			if(gameInput.isKeyDown(Input.KEY_LEFT) && player.getPlayerMapX() < 319.710){
				player.setPlayerCurrent(player.getMovingLeft());
				player.setPlayerMapX(player.getPlayerMapX() + (delta * player.getPlayerSpeedMultiplier()));
			}
			if(gameInput.isKeyDown(Input.KEY_RIGHT) && player.getPlayerMapX() > -839.744){
				player.setPlayerCurrent(player.getMovingRight());
				player.setPlayerMapX(player.getPlayerMapX() - (delta * player.getPlayerSpeedMultiplier()));
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