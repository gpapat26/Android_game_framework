package com.georgeframework.model;

import com.georgegramework.util.RandomNumberGenerator;

import android.graphics.Rect;

public class Block {
	
	
	private float x, y;
	private int width, height;
	private Rect rect;
	private boolean visible;
	
	private static final int UPPER_Y = 275;
	private static final int LOWER_Y = 335;
	
	
	public Block(float x, float y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void update(float delta,float velX){
		//velx should be negative!?
		x+= velX*delta;
		updateRect();
		if(x<=-50){
			reset();
		}
		
		
	}

	private void reset() {
			visible = true;
			if(RandomNumberGenerator.getRandInt(3)==0){
				y = UPPER_Y;
			}else{
				y = LOWER_Y;
			}
			x+=1000;
			updateRect();
	}

	private void updateRect() {
		rect.set((int)x, (int)y, (int)x+width, (int)y+height);
		
	}
	
	public void onCollide(Player p){
		visible = false;
		p.pushBack(30);
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Rect getRect() {
		return rect;
	}

	public void setRect(Rect rect) {
		this.rect = rect;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	
	
	
	
	
	

}
