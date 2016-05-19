package javagame.maingame;

import javagame.constants.ItemTypes;
import javagame.items.Item;
import javagame.items.ItemFactory;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import javagame.entities.Player;
import java.util.ArrayList;

public class Play extends BasicGameState {

	private Player player;
	private final java.lang.Integer state;
	private Input gameInput;
	private Image worldMap;
	private boolean quit;
    private ArrayList<Item> items;
    private ItemFactory factory;
	private Rectangle worldSpaceRectangle;
	
	public Play(java.lang.Integer state){
		this.state = state;
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame game) throws SlickException {
		quit = false;
		player = Player.getInstance(10, 0.1f,new int[] {200 ,200},
				new Image[]{new Image("res/buckysBack.png"), new Image("res/buckysBack.png")},
				new Image[]{new Image("res/buckysFront.png"), new Image("res/buckysFront.png")},
				new Image[]{new Image("res/buckysLeft.png"), new Image("res/buckysLeft.png")},
				new Image[]{new Image("res/buckysRight.png"), new Image("res/buckysRight.png")});
		worldMap = new Image("res/world.png");
		gameInput = gc.getInput();
        items = new ArrayList<>();
        factory = ItemFactory.getInstance();
		worldSpaceRectangle = new Rectangle(320 - player.getEntityWorldX(), 160 - player.getEntityWorldY() , player.getPlayerRectangle().getWidth()
				,player.getPlayerRectangle().getHeight());

        items.add(factory.getItem(ItemTypes.HEALTH_BUFF, 50, 50));
		items.add(factory.getItem(ItemTypes.HEALTH_BUFF, 20, 20));
	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
		worldMap.draw(player.getEntityWorldX(), player.getEntityWorldY());
		this.player.getEntityCurrent().draw(player.getEntityScreenX(), player.getEntityScreenY());

		/**
		g.fill(worldSpaceRectangle);
		g.draw(worldSpaceRectangle);
		 */

		for (Item i : items){
			//Renders the item on screen, offsetted by the player's movement to ensure it stays in the same position all the time.
			i.render(player.getEntityWorldX(), player.getEntityWorldY());
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
        worldSpaceRectangle = new Rectangle(320 - player.getEntityWorldX(), 160 - player.getEntityWorldY() , player.getPlayerRectangle().getWidth()
        ,player.getPlayerRectangle().getHeight());

		removeItemsFromWorld();

        if(gameInput.isKeyDown(Input.KEY_UP) && player.getEntityWorldY() < 159.500f){
			player.setEntityCurrent(player.getMovingUp());
			player.setEntityWorldY(player.getEntityWorldY() + (delta * player.getPlayerSpeedMultiplier()));
		}
		if(gameInput.isKeyDown(Input.KEY_DOWN) && player.getEntityWorldY() > -601.399){
			player.setEntityCurrent(player.getMovingDown());
			player.setEntityWorldY(player.getEntityWorldY() - (delta * player.getPlayerSpeedMultiplier()));
		}
		if(gameInput.isKeyDown(Input.KEY_LEFT) && player.getEntityWorldX() < 319.710){
			player.setEntityCurrent(player.getMovingLeft());
			player.setEntityWorldX(player.getEntityWorldX() + (delta * player.getPlayerSpeedMultiplier()));
		}
		if(gameInput.isKeyDown(Input.KEY_RIGHT) && player.getEntityWorldX() > -839.744){
			player.setEntityCurrent(player.getMovingRight());
			player.setEntityWorldX(player.getEntityWorldX() - (delta * player.getPlayerSpeedMultiplier()));
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

	private void removeItemsFromWorld(){
		items.removeIf(item ->
		{
			if (item.intersects(worldSpaceRectangle)) {
				player.addItemToInventory(item);
				return true;
			}else{
				return false;
			}
		});
	}
}