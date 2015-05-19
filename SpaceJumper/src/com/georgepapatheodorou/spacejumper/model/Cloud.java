package com.georgepapatheodorou.spacejumper.model;

import android.graphics.Bitmap;

import com.georgepapatheodorou.spacejumper.simpleandroidgdf.Assets;
import com.georgepapatheodorou.spacejumper.util.Painter;
import com.georgepapatheodorou.spacejumper.util.RandomNumberGenerator;

public class Cloud {
	
	
	private float x, y;
	
	private static final int VEL_X = -15;
	
	public Cloud(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public void update(float delta){
		x+=VEL_X * delta;
		if(x<=-200){
			x+=1000;
			y=RandomNumberGenerator.getRandIntBetween(20, 100);
		}
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
	
	public void render(Painter g , Bitmap image){		
		g.drawImage(image, (int)x, (int)y,100,60);
		//g.drawImage(image, (int)x, (int)y,100,60);
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
