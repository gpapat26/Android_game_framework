package com.animals.model;



import com.animals.simpleandroidgdf.GameMainActivity;
import com.animals.util.Painter;



import com.animals.util.RandomNumberGenerator;

import android.graphics.Bitmap;
import android.graphics.Rect;

public class Balloon {
	
	private float x, y;
	private int width, height;
	private Rect rect;
	private boolean visible=true;
	private boolean popped = false; // the state of the balloon . Popped or not.
	private Bitmap balloon; // the balloon image.
	private Bitmap balloonPop; // the popped balloon image
	private Bitmap currentBalloonImage;
	private float originalX,originalY;
	private int VELX_POSITIVE ;
	private int VELX_NEGATIVE ;
	private int currentVelocity ;
	private int platosX;
	private boolean isClown;
	private boolean isAnimal;
	private int stage;
	private Integer clownNo;
	
	
	public Balloon(float x, float y, int width, int height,Bitmap balloon,Bitmap balloonPop,boolean isclown,boolean isAnimal, int stage, Integer clownNo) {
		this.x = x;
		this.y = y;
		this.originalX = x;
		this.originalY = y;
		this.balloon = balloon;
		setCurrentBalloonImage(balloon);
		this.balloonPop = balloonPop;
		this.width = width;
		this.height = height;
		rect = new Rect((int)x,(int)y,(int)(x+width),(int)y+height);
		currentVelocity = RandomNumberGenerator.getRandIntBetween(2, 5);
		int rand  = RandomNumberGenerator.getRandIntBetween(5, 10);
		VELX_POSITIVE =  rand;
		VELX_NEGATIVE = -rand;
		platosX = RandomNumberGenerator.getRandIntBetween(50, 200);
		this.isClown =isclown;
		this.isAnimal = isAnimal;
		this.stage =stage;
		this.clownNo = clownNo;
	}
	



	///velY , velX must be positive
	public void update(float delta,float velY){
				
		//y-= velY*delta;
		y-= delta*velY*0.1;
		x+= currentVelocity;	
		
		if(x > originalX+platosX){
			//x-=velY*delta;			
			currentVelocity = VELX_NEGATIVE;
		}else if (x < originalX-platosX){
			//x+=velX*delta;
			
			currentVelocity = VELX_POSITIVE;
		}
		
		updateRect();
		
		if(y<=-150){
			reset(); //Do something when balloon has reached the top of the screen.
		}			
	}
	
	private void reset() { //Balloon has reached the top of the screen.
	
			visible = true;
			popped = false;
			setCurrentBalloonImage(balloon);
			y+=RandomNumberGenerator.getRandIntBetween(GameMainActivity.GAME_HEIGHT +200, GameMainActivity.GAME_HEIGHT+400);
			x = RandomNumberGenerator.getRandIntBetween(0, GameMainActivity.GAME_WIDTH);
			//VELX_POSITIVE   = RandomNumberGenerator.getRandIntBetween(2, 10);
			//VELX_NEGATIVE = - VELX_POSITIVE;
			alterPlatos();
			updateRect();
		

	}
	
	public void alterPlatos(){
		
		
		if(isAnimal){
			VELX_POSITIVE   = RandomNumberGenerator.getRandIntBetween(5+stage, 10+stage);
			VELX_NEGATIVE = - VELX_POSITIVE;
		}
		else if(!isAnimal&&isClown){
			VELX_POSITIVE   = RandomNumberGenerator.getRandIntBetween(8+stage, 10+stage);
			VELX_NEGATIVE = - VELX_POSITIVE;
		}
		else{
			VELX_POSITIVE   = RandomNumberGenerator.getRandIntBetween(2+stage, 10+stage);
			VELX_NEGATIVE = - VELX_POSITIVE;
		}
		
	}

	private void updateRect() {
		rect.set((int)x, (int)y, (int)x+width, (int)y+height);
	}
	
	public void onUserTouch(){
		
		popped = true;
		visible= true;	
		setCurrentBalloonImage(balloonPop);
		//slow down since balloon is popped
		VELX_POSITIVE =  +1;
		VELX_NEGATIVE = -VELX_POSITIVE;
	   
		Thread t = new Thread(){
			public void run(){
				try {
					Thread.sleep(2000) ;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(y<GameMainActivity.GAME_HEIGHT/2){
					visible= false;
				}				
				//popped = false;			
				//setCurrentBalloonImage(balloon);
			}
		};	
		t.start();
			
	}
	
	public void render(Painter g) {		
		g.drawImage(getCurrentBalloonImage(), (int)x, (int)y,120,150);
		
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

	
	public boolean isPopped() {
		return popped;
	}

	public void setPopped(boolean popped) {
		this.popped = popped;
	}



	public Bitmap getBalloon() {
		return balloon;
	}



	public void setBalloon(Bitmap balloon) {
		this.balloon = balloon;
	}



	public Bitmap getBalloonPop() {
		return balloonPop;
	}



	public void setBalloonPop(Bitmap balloonPop) {
		this.balloonPop = balloonPop;
	}



	public Bitmap getCurrentBalloonImage() {
		return currentBalloonImage;
	}



	public void setCurrentBalloonImage(Bitmap currentBalloonImage) {
		this.currentBalloonImage = currentBalloonImage;
	}




	public boolean isClown() {
		return isClown;
	}




	public void setClown(boolean isClown) {
		this.isClown = isClown;
	}




	public boolean isAnimal() {
		return isAnimal;
	}




	public void setAnimal(boolean isAnimal) {
		this.isAnimal = isAnimal;
	}




	public int getStage() {
		return stage;
	}




	public void setStage(int stage) {
		this.stage = stage;
	}




	public Integer getClownNo() {
		return clownNo;
	}




	public void setClownNo(Integer clownNo) {
		this.clownNo = clownNo;
	}	
	
	
	

}
