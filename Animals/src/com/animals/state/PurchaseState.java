package com.animals.state;

import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.Paint.Align;
import android.util.Log;
import android.view.MotionEvent;

import com.animals.simpleandroidgdf.Assets;
import com.animals.simpleandroidgdf.GameMainActivity;
import com.animals.util.Painter;
import com.animals.util.UIButton;

public class PurchaseState extends State {

	private UIButton back;
	private UIButton buyPremiumItem;
	private UIButton displayAlreadyPurhcace;
	private static final String TAG ="PurchaseState";
	public static boolean pleaseWaitLocal=false;
	private static Rect rect;

	
	public PurchaseState(){
		init();
	}
	

	@Override
	public void init() {
		// TODO Auto-generated method stub
		 Assets.loadGalleryImage("cartoon-rural-scene-farm-animals-24447502_2");
		 back = new UIButton(705, 355, 795, 445, Assets.home , Assets.home_down);	
		 buyPremiumItem  = new UIButton((GameMainActivity.GAME_WIDTH/2)-50, (GameMainActivity.GAME_HEIGHT/2)+50, (GameMainActivity.GAME_WIDTH/2)+50,  (GameMainActivity.GAME_HEIGHT/2)+150, Assets.buyItemUp2 , Assets.buyItemDown2);		
		 rect = new Rect(0, 0, GameMainActivity.GAME_WIDTH, 200);
		 displayAlreadyPurhcace  = new UIButton((GameMainActivity.GAME_WIDTH/2)-50, (GameMainActivity.GAME_HEIGHT/2)+50, (GameMainActivity.GAME_WIDTH/2)+50,  (GameMainActivity.GAME_HEIGHT/2)+150, Assets.premiumBought , Assets.premiumBought);		 	   	     
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(Painter g) {
		g.drawImage(Assets.galleryBitmap, 0, 0);
		
		back.render(g);
	
		
		if(GameMainActivity.mIsPremium){
			g.drawRectTextAligned("App is Upgrated",rect,40,Typeface.SERIF,Align.CENTER,Color.rgb(0, 255, 0));
			displayAlreadyPurhcace.render(g);
		}
		else if(!pleaseWaitLocal){
			g.drawRectTextAligned("Upgrade To Premium",rect,40,Typeface.SERIF,Align.CENTER,Color.rgb(255, 255, 0));
			buyPremiumItem.render(g);
		}
		else{
			g.drawRectTextAligned("Please wait...",rect,40,Typeface.SERIF,Align.CENTER,Color.rgb(255, 0, 0));

		}

	}
	

	@Override
	public boolean onTouch(MotionEvent e, int scaledX, int scaledY) {
		Log.d("MainMenuState", "button clicked");	
		if (e.getAction() == MotionEvent.ACTION_DOWN) {
			back.onTouchDown(scaledX, scaledY);			
			
			if(!GameMainActivity.mIsPremium){
				buyPremiumItem.onTouchDown(scaledX, scaledY);
			}									
		}
		
		if (e.getAction() == MotionEvent.ACTION_UP) {			
			if (back.isPressed(scaledX, scaledY)) {
		    	   back.cancel();    		
					GameMainActivity.sGame.setCurrentState(new MainMenuState());
					return true;
		       }
			else{
				back.cancel();
			}
			
			
			
			if (buyPremiumItem.isPressed(scaledX, scaledY) ) {
				 buyPremiumItem.cancel();
//				 Log.d(TAG, "Buy premium is pressed");
//				 
					Thread thread = new Thread(){				    
						public void run(){	
							pleaseWaitLocal = true;
							
							try {
								GameMainActivity.onUpgradeAppButtonClicked();
								sleep(10000);
							} catch (Exception e) {
								
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						    pleaseWaitLocal = false;
					    }
					  };
//					  
					  thread.start();			
//				 							
		       }
			else{
				buyPremiumItem.cancel();
			}
			
			
			
		}
		return true;
	}
	
	

}
