package javagame.maingame;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main {

	public static final String GAME_NAME = "Ham Blaster!";
	
	public static void main(String[] args) {
		AppGameContainer appGC;
		try{
			appGC = new AppGameContainer(new Game(GAME_NAME));
			appGC.setDisplayMode(640, 360, false);
			appGC.setTargetFrameRate(60);
			appGC.start();
		}
		catch(SlickException e){
			e.printStackTrace();
		}
	}

}
