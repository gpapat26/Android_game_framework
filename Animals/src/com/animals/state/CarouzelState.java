package com.animals.state;


import java.util.ArrayList;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.Log;
import android.view.MotionEvent;

import com.animals.simpleandroidgdf.Assets;
import com.animals.simpleandroidgdf.GameMainActivity;
import com.animals.simpleandroidgdf.GameView;
import com.animals.simpleandroidgdf.R;
import com.animals.util.Painter;
import com.animals.util.UIButton;

public class CarouzelState extends State {
	
	public static int carouzelIndex = 1;

	private UIButton carouzel_prev;
	private UIButton carouzel_next;
	private Rect displayNameRect ;
	
	private static float x1,x2;
	static final int MIN_DISTANCE = 150;
	
	public  CarouzelState() {
		init();
	}
	@Override
	public void init() {	
		displayNameRect = new Rect(GameMainActivity.sGame.getSrcRectangle().left,350, GameMainActivity.sGame.getSrcRectangle().right, GameMainActivity.sGame.getSrcRectangle().bottom);		
		Assets.onPause();
		//Assets.loadGalleryImage("crocodile");
		Assets.loadGalleryImageResolver(carouzelIndex);
		carouzel_prev = new UIButton(5, 355, 95, 445, Assets.carouzel_left, Assets. carouzel_left_down);	
		//carouzel_next = new UIButton(725, 290, 790, 370, Assets.carouzel_right_down, Assets.carouzel_right);	
		carouzel_next = new UIButton(705, 355, 795, 445, Assets. carouzel_right , Assets.carouzel_right_down);
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(Painter g) {
		g.drawImage(Assets.galleryBitmap, 0, 0);
		String animalName = GameView.context.getResources().getString(Assets.animals.get(carouzelIndex).getAnimalName());				
		g.drawRectTextAligned(animalName,displayNameRect,40,Typeface.SERIF,Align.CENTER,Color.WHITE);
	
		carouzel_prev.render(g);
		carouzel_next.render(g);
	}
	


	@Override
	public boolean onTouch(MotionEvent e, int scaledX, int scaledY) {
		Log.d("CarouzelState", "Carouzel button is pressed");
		if (e.getAction() == MotionEvent.ACTION_DOWN) {
			carouzel_next.onTouchDown(scaledX, scaledY);
			carouzel_prev.onTouchDown(scaledX, scaledY);		
			 x1 = e.getX();  
			
			 
		}

		if (e.getAction() == MotionEvent.ACTION_UP) {
			
			   x2 = e.getX();
	           float deltaX = x2 - x1;
	          
	           if (Math.abs(deltaX) > MIN_DISTANCE)
	           {
	            if(x1>x2){
	            	if (carouzelIndex < Assets.getSizeOfGallery())
					{
					carouzelIndex++;	
					}
				else{
					carouzelIndex = 1; //roll - over
				    }
	            }else{
	            	if (carouzelIndex>1){
						carouzelIndex--;
					}else{
						carouzelIndex=Assets.getSizeOfGallery();
					}
	            }
	            
	           }
	         
	           
			if (carouzel_next.isPressed(scaledX, scaledY)) {
				carouzel_next.cancel();	
				if (carouzelIndex < Assets.getSizeOfGallery())
					{
					carouzelIndex++;	
					}
				else{
					carouzelIndex = 1; //roll - over
				    }
			}else if(carouzel_prev.isPressed(scaledX, scaledY)){
				carouzel_prev.cancel();
				if (carouzelIndex>1){
					carouzelIndex--;
				}else{
					carouzelIndex=Assets.getSizeOfGallery();
				}
														
			} else {
				carouzel_next.cancel();
				carouzel_prev.cancel();
			}
		}
		Assets.loadGalleryImageResolver(carouzelIndex);
		try{
			ArrayList<String> musicList = Assets.animals.get(carouzelIndex).getAnimalAudioFile();
			
			if(musicList != null && musicList.size()>0){
				Assets.playGallerySounds(musicList.get(0));
				Log.d("CarouzelState", "playing "+ Assets.animals.get(carouzelIndex).getAnimalVisualFile());
			}
			else{
				Assets.stopSoundOnDemand();
			}
			
		}catch(Exception s){
			Log.d("CarouzelState", "Animal with index "+ carouzelIndex +
					"does not appear to have any sound :"+s.getMessage());
		}
		
		return true;
	}
}
