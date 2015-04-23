package com.jamescho.game.model;

import java.awt.Rectangle;

import com.jamescho.game.main.GameMain;
import com.jamescho.game.state.PlayState;

public class Paddle {
	
	private int x,y,width,height,velY;
	private Rectangle rect;
	
	public Paddle(int x, int y, int width, int height) {
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;		
		rect = new Rectangle(x,y,width,height);
		velY = 0;		 
	}
	
	public void update(){
		
		if(y<0){
			y =0;	
		}else if(y>GameMain.GAME_HEIGHT-this.height){
			y = GameMain.GAME_HEIGHT-this.height;
		}else{
			y += velY;
		}
	//	y += velY;
		updateRect();
	}
	
	private void updateRect(){
		rect.setBounds(x,y,width,height);
	}
	
	public void accelUp(){
		velY = -5;
	}
	
	public void accelDown(){
		velY = +5;
	}
	
	public void stop(){
		velY = 0;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Rectangle getRect() {
		return rect;
	}
	
	
	

}
