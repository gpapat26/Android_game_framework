package com.georgepapatheodorou.spacejumper.animation;

import android.graphics.Bitmap;

public class Frame {
	
	private Bitmap image;
	private double duration;
	
	public Bitmap getImage() {
		return image;
	}

	public void setImage(Bitmap image) {
		this.image = image;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public Frame(Bitmap image , double duration){
		this.image = image;
		this.duration = duration;
	}
	
	
	

}
