package com.jamescho.game.model;

import java.awt.Rectangle;
import java.util.Random;

import com.jamescho.game.main.GameMain;
import com.jamescho.game.main.Resources;

public class Ball {
	
	private int x,y,width,height,velX,velY;
	
	private Rectangle rect;
	
	public Ball(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		velX = 5;
		Random r = new Random();
		velY = r.nextInt(5-(-4)) + (-4);
		this.rect = new Rectangle(x,y,width,height);
	}
	
	public void update(){
		x+=velX;
		y+=velY;
		correctYCollisions();
		updateRect();
	}

	private void correctYCollisions() {
		if(y<0){
		y=0;
		}
		else if(y+ height >GameMain.GAME_HEIGHT){//reach down
			y=GameMain.GAME_HEIGHT - height;
		}
		else{
			return;
		}
		velY = -velY;
		Resources.bounce.play();
		
	}

	private void updateRect() {
		rect.setBounds(x,y,width,height);		
	}
	
	public void onCollideWith(Paddle p){
		
	}
	

	
	

}
