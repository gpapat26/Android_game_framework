package com.jamescho.game.model;

import java.awt.Rectangle;

import com.jamescho.game.main.Resources;


public class Player {
	
	private float x,y;
	private int width,height,velY;
	private Rectangle rect,duckRect,ground;
	
	
	private boolean isAlive;
	private boolean isDucked;
	
	private float duckDuration = .6f;
	
	private static final int JUMP_VELOCITY = -600;
	private static final int ACCEL_GRAVITY = 1800;
	
	
	public Player(float x, float y, int width, int height) {
	
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
			
		this.ground = new Rectangle(0,405,800,45);
		this.rect = new Rectangle();
		
		this.duckRect = new Rectangle();
		
		this.isAlive = true;
		this.isDucked = false;
		updateRects();
		
	}


	private void updateRects() {
		rect.setBounds((int)(x+10), (int)y, width-20, height);
		duckRect.setBounds((int)x,(int)(y+20),width,height-20);		
	}
	
	public void update(float delta){
		
		if(duckDuration > 0 && isDucked){
			duckDuration -= delta;
		}else{
			isDucked = false;
			duckDuration = .6f;
		}
		if(!isGrounded()){ // checks if player is walking
			velY+=ACCEL_GRAVITY*delta;
		}else{
			y=406 - height;
			velY = 0;
		}
		y+= velY*delta;
		
		
	}

	
	public void jump(){
		if(isGrounded()){//Are you walking ?
			Resources.onjump.play();
			isDucked = false;
			duckDuration = .6f;
			y-=10;
			velY = JUMP_VELOCITY;
			updateRects();
		}
		
	}
	
	public void duck(){
		if(isGrounded()){
			isDucked = true;
		}
	}
	
	public void pushBack(int dX){
		Resources.hit.play();
		x-= dX;
		if(x < -width/2){
			this.isAlive = false;
		}
		rect.setBounds((int)x,(int)y,width,height);
	}
	
	public boolean isGrounded(){
		return rect.intersects(ground);
	}


	public boolean isAlive() {		
		return isAlive;
	}
	
	public boolean isDucked(){
		return isDucked;
	}


	public Rectangle getDuckRect() {		
		return duckRect;
	}


	public Rectangle getRect() {		
		return rect;
	}


	public double getY() {
		// TODO Auto-generated method stub
		return y;
	}


	public double getX() {
		// TODO Auto-generated method stub
		return x;
	}


	public int getWidth() {
		// TODO Auto-generated method stub
		return width;
	}


	public int getHeight() {
		// TODO Auto-generated method stub
		return height;
	}
	

	
	

}
