package com.jamescho.game.model;

import java.awt.Rectangle;


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
		// TODO Auto-generated method stub
		
	}
	

	
	

}
