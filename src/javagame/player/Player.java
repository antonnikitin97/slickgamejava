package javagame.player;

import java.util.HashMap;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import javagame.constants.ItemTypes;
import javagame.items.Item;

public class Player {
	private HashMap<String, Item> inventory;
	private Integer health;
	private float playerSpeedMultiplier;
    public Rectangle playerRectangle;
	private int[] duration;
	private float playerX;
	private float playerY;
	private float shiftX = playerX + 320;
	private float shiftY = playerY + 160;
	private Image[] walkUp;
	private Image[] walkDown;
	private Image[] walkLeft;
	private Image[] walkRight;
	
	private Animation playerCurrent, movingUp, movingDown, movingLeft, movingRight;
	
	public Player(){
		this.inventory = new HashMap<String, Item>();
		this.health = 10;
		this.playerSpeedMultiplier = 0.1f;
		
		duration = new int[] {200 ,200};
		
		try{
			walkUp = new Image[]{new Image("res/buckysBack.png"), new Image("res/buckysBack.png")};
			walkDown = new Image[]{new Image("res/buckysFront.png"), new Image("res/buckysFront.png")};
			walkLeft = new Image[]{new Image("res/buckysLeft.png"), new Image("res/buckysLeft.png")};
			walkRight = new Image[]{new Image("res/buckysRight.png"), new Image("res/buckysRight.png")};
		}
		catch(SlickException e){
			e.printStackTrace();
		}
		
		movingUp = new Animation(walkUp, duration, false);
		movingDown = new Animation(walkDown, duration, false);
		movingLeft = new Animation(walkLeft, duration, false);
		movingRight = new Animation(walkRight, duration, false);
		
		playerCurrent = movingDown;
        playerRectangle = new Rectangle(shiftX, shiftY, playerCurrent.getWidth(), playerCurrent.getHeight());
	}

	public Integer getHealth(){
		return this.health;
	}
	
	public void setHealth(Integer healthToSet){
		if(this.health - healthToSet <0){
			this.health = 0;
		}else{
			this.health -= healthToSet;
		}
	}
	
	public void addHealth(Integer healthToAdd){
		if(this.health + healthToAdd > 10){
			this.health = 10;
		}else{
			this.health += healthToAdd;
		}
	}
	
	public Animation getPlayerCurrent() {
		return playerCurrent;
	}

	public void setPlayerCurrent(Animation playerCurrent) {
		this.playerCurrent = playerCurrent;
	}

	public Animation getMovingUp() {
		return movingUp;
	}

	public Animation getMovingDown() {
		return movingDown;
	}

	public Animation getMovingLeft() {
		return movingLeft;
	}

	public Animation getMovingRight() {
		return movingRight;
	}
	public float getPlayerX() {
		return playerX;
	}

	public void setPlayerX(float playerX) {
		this.playerX = playerX;
        this.playerRectangle.setBounds(shiftX, shiftY, this.playerCurrent.getWidth(), this.playerCurrent.getHeight());
	}

	public float getPlayerY() {
		return playerY;
	}

	public void setPlayerY(float playerY) {
		this.playerY = playerY;
        this.playerRectangle.setBounds(shiftX, shiftY, this.playerCurrent.getWidth(), this.playerCurrent.getHeight());
	}

	public float getShiftX() {
		return shiftX;
	}

	public void setShiftX(float shiftX) {
		this.shiftX = shiftX;
	}

	public float getShiftY() {
		return shiftY;
	}

	public void setShiftY(float shiftY) {
		this.shiftY = shiftY;
	}

	public float getPlayerSpeedMultiplier(){
		return this.playerSpeedMultiplier;
	}

    public Rectangle getPlayerRectangle() {
        return playerRectangle;
    }
}
