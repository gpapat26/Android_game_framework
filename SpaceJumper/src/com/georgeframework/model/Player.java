package com.georgeframework.model;

import com.georgeframework.simpleandroidgdf.Assets;

import android.graphics.Rect;

public class Player {
	
	private float x, y;
	private int width,height,velY;
	private Rect rect, duckRect,ground;
	
	private boolean isAlive;
	private boolean isDucked;
	private boolean isGrounded;
	private float duckDuration = 0.6f;
	
	private static final int JUMP_VELOCITY = -600;
	private static final int ACCEL_GRAVITY = 1800;
				
	public Player(float x, float y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		//800 x 450
		ground = new Rect(0,405,0+800,405+45);
		rect = new Rect();
		duckRect = new Rect();
		isAlive = true;
		isDucked = false;
	}
	
	public void update(float delta){
		if(duckDuration>0 && isDucked){
			duckDuration -= delta;
		}else{
			isDucked = false;
			duckDuration = 0.6f;
		}
		
		if(!isGrounded){
			velY+= ACCEL_GRAVITY * delta;
		}else{
			y = 406 - height; //405 is ground
			velY =0;
		}
		
		y += velY * delta;
		updateRects();
		
		
		
	}






	private void updateRects() {
		//player 72x97
		rect.set((int)x+10, (int)y,(int)(x+width-20), (int)y+height);
		//player 72x97
		duckRect.set((int)x, (int)y+20,(int)(x+width), (int)(y+height));
	}
	
	public void jump(){
		if(isGrounded){
			Assets.playSound(Assets.onJumpID);
			isDucked = false;
			duckDuration = 0.6f;
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

	
	private boolean isGrounded() {		
		return Rect.intersects(rect, ground);
	}

	public void pushBack(int dx) {
		x-= dx;
		Assets.playSound(Assets.hitID);
		if(x<-width/2){
			isAlive = false;
		}
		rect.set((int)x, (int)y, (int)x+width, (int)y+height);
	}
	
	public boolean isDucked(){
		return isDucked;
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

	public int getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}

	public Rect getRect() {
		return rect;
	}

	public void setRect(Rect rect) {
		this.rect = rect;
	}

	public Rect getDuckRect() {
		return duckRect;
	}

	public void setDuckRect(Rect duckRect) {
		this.duckRect = duckRect;
	}

	public Rect getGround() {
		return ground;
	}

	public void setGround(Rect ground) {
		this.ground = ground;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public float getDuckDuration() {
		return duckDuration;
	}

	public void setDuckDuration(float duckDuration) {
		this.duckDuration = duckDuration;
	}

	public static int getJumpVelocity() {
		return JUMP_VELOCITY;
	}

	public static int getAccelGravity() {
		return ACCEL_GRAVITY;
	}

	public void setDucked(boolean isDucked) {
		this.isDucked = isDucked;
	}

	public void setGrounded(boolean isGrounded) {
		this.isGrounded = isGrounded;
	}
	
	

}
