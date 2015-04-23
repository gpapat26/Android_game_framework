package com.jamescho.game.model;

import java.awt.Rectangle;

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
		y += velY;
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
