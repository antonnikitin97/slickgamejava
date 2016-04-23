package javagame.entities;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;


public abstract class Entity {
    protected float entityWorldX;
    protected float entityWorldY;
    protected float entityScreenX = 320;
    protected float entityScreenY = 160;
    protected Image[] walkUp;
    protected Image[] walkDown;
    protected Image[] walkLeft;
    protected Image[] walkRight;
    protected int[] duration;
    protected Animation entityCurrent, movingUp, movingDown, movingLeft, movingRight;
    protected Integer health;
    protected float speedMultiplier;
    protected Rectangle entityRectangle;

    public Entity(Integer health, Float speedMultiplier, int[] duration, Image[] walkUp, Image[] walkDown, Image[] walkLeft, Image[] walkRight){
        this.health = health;
        this.speedMultiplier = speedMultiplier;
        this.duration = duration;
        this.walkUp = walkUp;
        this.walkDown = walkDown;
        this.walkLeft = walkLeft;
        this.walkRight = walkRight;
        movingUp = new Animation(walkUp, duration, false);
        movingDown = new Animation(walkDown, duration, false);
        movingLeft = new Animation(walkLeft, duration, false);
        movingRight = new Animation(walkRight, duration, false);
    }

    public Animation getEntityCurrent() {
        return entityCurrent;
    }

    public void setEntityCurrent(Animation entityCurrent) {
        this.entityCurrent = entityCurrent;
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

    public float getEntityWorldX() {
        return entityWorldX;
    }

    public void setEntityWorldX(float entityWorldX) {
        this.entityWorldX = entityWorldX;
        this.entityRectangle.setBounds(entityScreenX, entityScreenY, this.entityCurrent.getWidth(), this.entityCurrent.getHeight());
    }

    public float getEntityWorldY() {
        return entityWorldY;
    }

    public void setEntityWorldY(float entityWorldY) {
        this.entityWorldY = entityWorldY;
        this.entityRectangle.setBounds(entityScreenX, entityScreenY, this.entityCurrent.getWidth(), this.entityCurrent.getHeight());
    }

    public float getEntityScreenX() {
        return entityScreenX;
    }

    public float getEntityScreenY() {
        return entityScreenY;
    }

    public Integer getHealth(){
        return this.health;
    }

    public void setHealth(Integer healthToSet){
        if(this.health - healthToSet < 0){
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
}
