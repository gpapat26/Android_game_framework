package com.georgepapatheodorou.spacejumper.util;



import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;

public class UIButton {
	
	private Rect buttonRect;
	
	private boolean buttonDown = false;
	private Bitmap buttonImage, buttonDownImage;
	
	public UIButton(int left, int top, int right,int bottom, Bitmap buttonImage, Bitmap buttonPressedImage){
		
		buttonRect = new Rect(left,top,right,bottom);
		this.buttonImage = buttonImage;
		this.buttonDownImage = buttonPressedImage;
	}
	
	public void render(Painter g) {
		Bitmap currentButtonImage = buttonDown ? buttonDownImage : buttonImage;
		g.drawImage(currentButtonImage, buttonRect.left, buttonRect.top, buttonRect.width(), buttonRect.height());
	}
	
	public void render(Painter g, Bitmap alternate, Bitmap alternateDown) {
		Bitmap currentButtonImage = buttonDown ? alternateDown : alternate;
		g.drawImage(currentButtonImage, buttonRect.left, buttonRect.top, buttonRect.width(), buttonRect.height());
	}
	
	public void onTouchDown(int touchX, int touchY){
		
		if(buttonRect.contains(touchX,touchY)){
			Log.d("UIBUtton", "onTouchDown button = true");
			buttonDown = true;
		}else{
			Log.d("UIBUtton", "onTouchDown button = false");

			buttonDown = false;
		}
	}
	
	public void cancel(){
		buttonDown = false;
	}
	
	public boolean isPressed(int touchX, int touchY){
		return buttonDown && buttonRect.contains(touchX,touchY);
	}

}
