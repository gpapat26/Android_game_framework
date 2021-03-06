package com.animals.state;


import android.graphics.Color;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Toast;

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
	private UIButton animal;
	private Rect displayNameRect ;
	private UIButton back;
	
	private UIButton creditsButton;
	
	
	private static float x1,x2;
	static final int MIN_DISTANCE = 150;
	private static int languageCode = 0;
	private static int backPressedCounter = 0;
	private UIButton purhaceButton;
	private UIButton purhaceButton2;
	private Rect wholeScreenRect;
	private Thread  thread ;
	MediaPlayer media2 = null;
	MediaPlayer media3 = null;
	
	public  CarouzelState() {
		init();
	}
	@Override
	public void init() {
		wholeScreenRect = new Rect(0,0,GameMainActivity.GAME_WIDTH,GameMainActivity.GAME_HEIGHT);
		languageCode = GameMainActivity.getLanguageCode();
		displayNameRect = new Rect(GameMainActivity.sGame.getSrcRectangle().left,350, GameMainActivity.sGame.getSrcRectangle().right, GameMainActivity.sGame.getSrcRectangle().bottom);		
		Assets.onPause();
		Assets.loadGalleryImageResolver(carouzelIndex);
		carouzel_prev = new UIButton(5, 355, 95, 445, Assets.carouzel_left, Assets. carouzel_left_down);	
		carouzel_next = new UIButton(705, 355, 795, 445, Assets. carouzel_right , Assets.carouzel_right_down);				
		animal = new UIButton(110, 355, 200, 445, Assets.play_animal , Assets.play_animal_down);
		back = new UIButton(605, 355, 695, 445, Assets.back , Assets.back_down);
		purhaceButton2 = new UIButton(605, 355, 695, 445, Assets.buyItemUp, Assets.buyItemDown);
		purhaceButton = new UIButton(110, 355, 200, 445, Assets.buyItemUp, Assets.buyItemDown);
		creditsButton = new UIButton(5,5,105,105, Assets.credits_up, Assets.credits_down);
		playAnimalSoundsAndVoice();
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(Painter g) {
		String animalName = null;
	
		g.drawImage(Assets.galleryBitmap, 0, 0);
		creditsButton.render(g);
		
		try{
			 animalName = GameView.context.getResources().getString(Assets.animals.get(carouzelIndex).getAnimalName(GameMainActivity.getLanguageCode()));	

		}catch(Exception b){
			
		}
		
		g.drawRectTextAligned(animalName,displayNameRect,40,Typeface.SERIF,Align.CENTER,Color.rgb(144, 0, 0),true,80);
		
		if(Assets.currentAnimal.isPromo()){
			if(languageCode== 0){
				g.drawRectTextAligned(GameMainActivity.sGame.getContext().getResources().getString(R.string.promoMain),wholeScreenRect,40,Typeface.SERIF,Align.CENTER,Color.rgb(144, 0, 0),true,100);		
			}
			else if(languageCode== 1){
				g.drawRectTextAligned(GameMainActivity.sGame.getContext().getResources().getString(R.string.promoMain_gr),wholeScreenRect,40,Typeface.SERIF,Align.CENTER,Color.rgb(144, 0, 0),true,100);		

			}
		}
		
		carouzel_prev.render(g);
		carouzel_next.render(g);		
		
		if(!Assets.currentAnimal.isPromo()){
			back.render(g);
			animal.render(g);
		}
		else{
			purhaceButton2.render(g);
			purhaceButton.render(g);
		}
		
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
			 creditsButton.onTouchDown(scaledX, scaledY);
			 
			 if(Assets.currentAnimal.isPromo()){
				 purhaceButton.onTouchDown(scaledX, scaledY);
				 purhaceButton2.onTouchDown(scaledX, scaledY);
			 }
			
			 
		}

		if (e.getAction() == MotionEvent.ACTION_UP) {
			
			if(Assets.currentAnimal.isPromo() && !back.isPressed(scaledX, scaledY) && !carouzel_next.isPressed(scaledX, scaledY) && !carouzel_prev.isPressed(scaledX, scaledY)){
				setCurrentState(new PurchaseState());	
				return true;
			}
			
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
	       if (!Assets.currentAnimal.isPromo() && back.isPressed(scaledX, scaledY)) {
	    	   if(backPressedCounter<1){
	    		   Toast.makeText(GameMainActivity.sGame.context, R.string.exit,Toast.LENGTH_SHORT).show();
	    		   backPressedCounter++;
	    		   back.cancel();
	    	   }else{
	    		   back.cancel();
		    		//Assets.loadGalleryImage("crab");
					GameMainActivity.sGame.setCurrentState(new MainMenuState());
					backPressedCounter = 0;
					return true;
	    	   }
	    	  
	       }
	       
	       if (Assets.currentAnimal.isPromo() && purhaceButton.isPressed(scaledX, scaledY) || purhaceButton2.isPressed(scaledX, scaledY)) {			
				purhaceButton.cancel();	
				purhaceButton2.cancel();	
				setCurrentState(new PurchaseState());	
				return true;
			}
			else{
				purhaceButton.cancel();
				purhaceButton2.cancel();
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
		
		if(creditsButton.isPressed(scaledX, scaledY)){
			creditsButton.cancel();
			setCurrentState(new SpecialThanksState());	
			return true;
		}
		
		Assets.loadGalleryImageResolver(carouzelIndex);
		
	
		return true;
	}
	
	private  void playAnimalSoundsAndVoice(){
		
		if(media2 != null && media2.isPlaying()){		
			media2.stop();
		}
		
		if(media3 != null && media3.isPlaying()){		
			media3.stop();
		}
		
		if(thread != null){		
		thread.interrupt();			
		}
		
					
		try{
					thread = new Thread(){					
					public void run(){						
						
						try {
							media2 = Assets.playMusic2(Assets.animals.get(carouzelIndex).getAnimalAudioFile().get(0)+".mp3",false);
							thread.sleep(3000);
							resolveLinguisticSoundAndPlay();
						} catch (InterruptedException e) {
						
							e.printStackTrace();
						}										     
				    }
				  };
				  thread.start();						
		}catch(Exception s){
			Log.d("CarouzelState", "Animal with index "+ carouzelIndex +
					"does not appear to have any sound :"+s.getMessage());
		}
		
	}
	
	private void resolveLinguisticSoundAndPlay(){
		
		switch(languageCode){
		case 0 : 
			Log.d("CarouzelState", "starting second media player");
	    	media3=Assets.playMusic3(Assets.animals.get(carouzelIndex).getAnimalVisualFileSoundLang()+"-en.mp3",false);
		break;
		
		case 1 : 
			Log.d("CarouzelState", "starting second media player");
			media3=Assets.playMusic3(Assets.animals.get(carouzelIndex).getAnimalVisualFileSoundLang()+"-gr.mp3",false);
		break;
		}
	}
	
}
