package com.animals.state;


import java.util.ArrayList;



import android.graphics.Color;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.Log;
import android.view.MotionEvent;

import com.animals.simpleandroidgdf.Assets;
import com.animals.simpleandroidgdf.GameMainActivity;
import com.animals.simpleandroidgdf.GameView;
import com.animals.util.Painter;
import com.animals.util.UIButton;

public class CarouzelState extends State {
	
	public static int carouzelIndex = 1;

	private UIButton carouzel_prev;
	private UIButton carouzel_next;
	private UIButton animal;
	private Rect displayNameRect ;
	private UIButton back;
	
	
	private static float x1,x2;
	static final int MIN_DISTANCE = 150;
	private static int languageCode = 0;
	
	public  CarouzelState() {
		init();
	}
	@Override
	public void init() {
		languageCode = GameMainActivity.getLanguageCode();
		displayNameRect = new Rect(GameMainActivity.sGame.getSrcRectangle().left,350, GameMainActivity.sGame.getSrcRectangle().right, GameMainActivity.sGame.getSrcRectangle().bottom);		
		Assets.onPause();
		Assets.loadGalleryImageResolver(carouzelIndex);
		carouzel_prev = new UIButton(5, 355, 95, 445, Assets.carouzel_left, Assets. carouzel_left_down);	
		carouzel_next = new UIButton(705, 355, 795, 445, Assets. carouzel_right , Assets.carouzel_right_down);				
		animal = new UIButton(110, 355, 200, 445, Assets.play_animal , Assets.play_animal_down);
		back = new UIButton(605, 355, 695, 445, Assets.back , Assets.back_down);
		resolveLinguisticSoundAndPlay();
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(Painter g) {
		String animalName = "UNDENTIFIED";
		g.drawImage(Assets.galleryBitmap, 0, 0);
		try{
			 animalName = GameView.context.getResources().getString(Assets.animals.get(carouzelIndex).getAnimalName(GameMainActivity.getLanguageCode()));	
		//	 Log.d("CarouzelState", "found animal name with index: "+carouzelIndex + "and language code: "+languageCode +" "+animalName);

		}catch(Exception b){
		//	Log.d("CarouzelState", "unable to find animal name with index: "+carouzelIndex + "and language code: "+languageCode);
		}
		//String animalName = GameView.context.getResources().getString(R.string.ant);	

	
		g.drawRectTextAligned(animalName,displayNameRect,40,Typeface.SERIF,Align.CENTER,Color.rgb(144, 0, 0));
	
		carouzel_prev.render(g);
		carouzel_next.render(g);
		animal.render(g);
		back.render(g);
	}
	


	@Override
	public boolean onTouch(MotionEvent e, int scaledX, int scaledY) {
		Log.d("CarouzelState", "Carouzel button is pressed");
		if (e.getAction() == MotionEvent.ACTION_DOWN) {
			carouzel_next.onTouchDown(scaledX, scaledY);
			carouzel_prev.onTouchDown(scaledX, scaledY);		
			 x1 = e.getX();  
			 animal.onTouchDown(scaledX, scaledY);
			 back.onTouchDown(scaledX, scaledY);
			 
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
	       if (animal.isPressed(scaledX, scaledY)) {
	    	   animal.cancel();
	    	   playAnimalSoundsAndVoice();
	       }
	       if (back.isPressed(scaledX, scaledY)) {
	    	   back.cancel();
	    		Assets.loadGalleryImage("crab");
				GameMainActivity.sGame.setCurrentState(new MainMenuState());
				return true;
	       }
	           
			if (carouzel_next.isPressed(scaledX, scaledY)) {
				carouzel_next.cancel();	
				if (carouzelIndex < Assets.getSizeOfGallery())
					{
					carouzelIndex++;
					playAnimalSoundsAndVoice();
					}
				else{
					carouzelIndex = 1; //roll - over
					playAnimalSoundsAndVoice();
				    }
			}else if(carouzel_prev.isPressed(scaledX, scaledY)){
				carouzel_prev.cancel();
				if (carouzelIndex>1){
					carouzelIndex--;
					playAnimalSoundsAndVoice();
				}else{
					carouzelIndex=Assets.getSizeOfGallery();
					playAnimalSoundsAndVoice();
				}
														
			} else {
				carouzel_next.cancel();
				carouzel_prev.cancel();
			}
			
		
		}
		Assets.loadGalleryImageResolver(carouzelIndex);
		
	
		return true;
	}
	
	private void playAnimalSoundsAndVoice(){
		try{
			ArrayList<String> musicList = Assets.animals.get(carouzelIndex).getAnimalAudioFile();
			
			if(musicList != null && musicList.size()>0){
				//Assets.playGallerySounds(musicList.get(0));
				Assets.playMusic2(musicList.get(0)+".ogg",false);
				
					Thread thread = new Thread(){				    
					public void run(){
						
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
						
							e.printStackTrace();
						}
						resolveLinguisticSoundAndPlay();				     
				    }
				  };
				  thread.start();			
			}
			else{
				Assets.stopSoundOnDemand();
			}
			
		}catch(Exception s){
			Log.d("CarouzelState", "Animal with index "+ carouzelIndex +
					"does not appear to have any sound :"+s.getMessage());
		}
		
	}
	
	private void resolveLinguisticSoundAndPlay(){
		
		switch(languageCode){
		case 0 : 
			Log.d("CarouzelState", "starting second media player");
	    	Assets.playMusic3(Assets.animals.get(carouzelIndex).getAnimalVisualFileSoundLang()+"-en.ogg",false);
		break;
		
		case 1 : 
			Log.d("CarouzelState", "starting second media player");
	    	Assets.playMusic3(Assets.animals.get(carouzelIndex).getAnimalVisualFileSoundLang()+"-gr.ogg",false);
		break;
		}
	}
}
