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
	private UIButton simulateConsumptionFromGoogle; //consume all purch items
	private UIButton simulateFetchStatusFromDB; //display what is writen in database
	private UIButton simulateFetchOwnedFromGoogle ; // display if any google reports that items are owned.
	
	private UIButton simulateBuyButtonWithoutGoogle;// buy items without Google. ie record a purchase in db, change carouzel.
	private UIButton simulateCleanDatabase; //cleans items from database.
	private Boolean testMode =true;

	
	public PurchaseState(){
		init();
	}
	

	@Override
	public void init() {
		// TODO Auto-generated method stub
		 Assets.loadGalleryImage("cartoon-rural-scene-farm-animals-24447502_2");
		 back = new UIButton(705, 355, 795, 445, Assets.home , Assets.home_down);	
		 buyPremiumItem  = new UIButton((GameMainActivity.GAME_WIDTH/2)-50, (GameMainActivity.GAME_HEIGHT/2)-50, (GameMainActivity.GAME_WIDTH/2)+50,  (GameMainActivity.GAME_HEIGHT/2)+50, Assets.buyItemUp2 , Assets.buyItemDown2);		
		 //rect = new Rect(0, 0, GameMainActivity.GAME_WIDTH, 200);
		 rect = GameMainActivity.upperHalfScreen;
		 displayAlreadyPurhcace  = new UIButton((GameMainActivity.GAME_WIDTH/2)-50, (GameMainActivity.GAME_HEIGHT/2)+50, (GameMainActivity.GAME_WIDTH/2)+50,  (GameMainActivity.GAME_HEIGHT/2)+150, Assets.premiumBought , Assets.premiumBought);		 	   	     
		 simulateConsumptionFromGoogle = new UIButton(5, 355, 95, 445, Assets.carouzel_left, Assets. carouzel_left_down);
	     simulateFetchStatusFromDB = new UIButton(110, 355, 200, 445, Assets. carouzel_right , Assets.carouzel_right_down);		 
	     simulateFetchOwnedFromGoogle = new UIButton(210, 355, 300, 445, Assets. english , Assets.english_down);	     
	     simulateBuyButtonWithoutGoogle = new UIButton(310, 355, 400, 445, Assets. balloons_button , Assets.balloons_button_down);
	     simulateCleanDatabase = new UIButton(410, 355, 500, 445, Assets. greek , Assets.greek_down);
	     Assets.onResume();	
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(Painter g) {
		g.drawImage(Assets.galleryBitmap, 0, 0);
		
		
		
		if(testMode){
			simulateFetchStatusFromDB.render(g); 		//display what is writen in database
			simulateFetchOwnedFromGoogle.render(g); 	// display if any google reports that items are owned.
			simulateBuyButtonWithoutGoogle.render(g);	// buy items without Google. ie record a purchase in db, change carouzel.
			simulateCleanDatabase.render(g);			//cleans items from database.
		}
		
		
		if(GameMainActivity.mIsPremium){
			g.drawRectTextAligned("App is Upgrated",rect,40,Typeface.SERIF,Align.CENTER,Color.rgb(0, 255, 0), true,80);
			displayAlreadyPurhcace.render(g);
			
			
		}
		if(!pleaseWaitLocal && !GameMainActivity.mIsPremium  && !GameMainActivity.waitForPurhcace ){
			g.drawRectTextAligned("Upgrade To Premium",rect,40,Typeface.SERIF,Align.CENTER,Color.rgb(255, 255, 0), true,80);
			buyPremiumItem.render(g);
					
		}
	     if(pleaseWaitLocal || GameMainActivity.waitForPurhcace){
			g.drawRectTextAligned("Please wait...",GameMainActivity.wholeScreenMinus,40,Typeface.SERIF,Align.CENTER,Color.rgb(255, 0, 0), true,80);
		}
	     
	     if(GameMainActivity.mIsPremium && (!pleaseWaitLocal || !GameMainActivity.waitForPurhcace) && testMode){
	    	 simulateConsumptionFromGoogle.render(g); //consume all purch items
	    	
	     }
	     
	     if(!pleaseWaitLocal || !GameMainActivity.waitForPurhcace){
	    	 back.render(g);
	     }

	}
	

	@Override
	public boolean onTouch(MotionEvent e, int scaledX, int scaledY) {
		Log.d("MainMenuState", "button clicked");	
		if (e.getAction() == MotionEvent.ACTION_DOWN) {
			back.onTouchDown(scaledX, scaledY);	
			
			if(testMode){
				simulateConsumptionFromGoogle.onTouchDown(scaledX, scaledY);
				simulateFetchStatusFromDB.onTouchDown(scaledX, scaledY);
				simulateFetchOwnedFromGoogle.onTouchDown(scaledX, scaledY);
				simulateBuyButtonWithoutGoogle.onTouchDown(scaledX, scaledY);
				simulateCleanDatabase.onTouchDown(scaledX, scaledY);
			}
			
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
			//Consume All items
			if (testMode && simulateConsumptionFromGoogle.isPressed(scaledX, scaledY)) {
				simulateConsumptionFromGoogle.cancel();    					
				Thread thread = new Thread(){				    
					public void run(){	
						pleaseWaitLocal = true;
						GameMainActivity.instance.onConsumePremiumItems();
						try {
							while(GameMainActivity.waitForPurhcace){
								sleep(5000);						
						    }							
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					    pleaseWaitLocal = false;
				    }
				  };				  
				  thread.start();		
		       }
			else{
				simulateConsumptionFromGoogle.cancel();
			}
			
			//Dispay database premium status
			if ( testMode && simulateFetchStatusFromDB.isPressed(scaledX, scaledY)) {
				simulateFetchStatusFromDB.cancel();  
				
				Thread thread = new Thread(){				    
					public void run(){									
						//GameMainActivity.instance.alertNonStatic("Premium : "+GameMainActivity.instance.retrievePremiumStatus() + ":"+GameMainActivity.mIsPremium);
						//GameMainActivity.instance.alertNonStatic("Premium : "+GameMainActivity.retrievePremiumToken());				   
						GameMainActivity.instance.retrievePremiumStatus();
						GameMainActivity.instance.retrievePremiumToken();
					}
				  };				  
				  thread.start();		
		       }
			else{
				simulateFetchStatusFromDB.cancel();
			}
			
			if (!GameMainActivity.mIsPremium && buyPremiumItem.isPressed(scaledX, scaledY) ) {
				
				 buyPremiumItem.cancel();
			 
					Thread thread = new Thread(){				    
						public void run(){	
							pleaseWaitLocal = true;
							GameMainActivity.instance.onUpgradeAppButtonClicked();
							try {
								while(GameMainActivity.waitForPurhcace)
								sleep(5000);						
									 Log.d(TAG, "on touch found mIsPremium to be true");						
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						    pleaseWaitLocal = false;
					    }
					  };				  
					  thread.start();						 							
		       }
			else{
				buyPremiumItem.cancel();
			}
			
			if ( testMode && simulateFetchOwnedFromGoogle.isPressed(scaledX, scaledY) ) {
				
				simulateFetchOwnedFromGoogle.cancel();
			 
					Thread thread = new Thread(){				    
						public void run(){	
							pleaseWaitLocal = true;
							GameMainActivity.instance.onQueryForOwnedItems();
							try {
								while(GameMainActivity.waitForPurhcace)
								sleep(5000);						
									 Log.d(TAG, "woke up");						
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						    pleaseWaitLocal = false;
					    }
					  };				  
					  thread.start();						 							
		       }
			else{
				simulateFetchOwnedFromGoogle.cancel();
			}
			
			if ( testMode && simulateBuyButtonWithoutGoogle.isPressed(scaledX, scaledY) ) {
				
				simulateBuyButtonWithoutGoogle.cancel();
			 
					Thread thread = new Thread(){				    
						public void run(){	
							pleaseWaitLocal = true;						
							try {
								GameMainActivity.waitForPurhcace= true;														
								sleep(20000);	
								GameMainActivity.instance.preparePremiumStatus("123 fake premium", true);
								sleep(3000);	
							    Log.d(TAG, "woke up");	
								GameMainActivity.waitForPurhcace= false;
							} catch (InterruptedException e) {
								e.printStackTrace();
								GameMainActivity.waitForPurhcace= false;
							}
						    pleaseWaitLocal = false;
					    }
					  };				  
					  thread.start();						 							
		       }
			else{
				simulateBuyButtonWithoutGoogle.cancel();
			}
			
			
		if ( testMode && simulateCleanDatabase.isPressed(scaledX, scaledY) ) {
				
			simulateCleanDatabase.cancel();
			 
					Thread thread = new Thread(){				    
						public void run(){	
							pleaseWaitLocal = true;						
							try {
								GameMainActivity.waitForPurhcace= true;
								sleep(20000);
								GameMainActivity.instance.preparePremiumStatus("", false);																					
							    Log.d(TAG, "woke up");	
								GameMainActivity.waitForPurhcace= false;
							} catch (InterruptedException e) {
								e.printStackTrace();
								GameMainActivity.waitForPurhcace= false;
							}
						    pleaseWaitLocal = false;
					    }
					  };				  
					  thread.start();						 							
		       }
			else{
				simulateCleanDatabase.cancel();
			}
			
			
			
			
			
			
		}
		return true;
	}
	
	@Override
	public void onPause() {
		Log.d("MainMenuState", "OnPause is called");
		Assets.onPause();	
	}
	
	@Override
	public void onResume() {
		Log.d("StartState", "OnResume is called");
		Assets.onResume();		
	}
	
	

}
