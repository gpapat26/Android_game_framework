package com.animals.state;

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

	
	public PurchaseState(){
		init();
	}
	

	@Override
	public void init() {
		// TODO Auto-generated method stub
		 Assets.loadGalleryImage("cartoon-rural-scene-farm-animals-24447502_2");
		 back = new UIButton(705, 355, 795, 445, Assets.home , Assets.home_down);	
		 buyPremiumItem  = new UIButton(250, 200, 350, 300, Assets.buyItemUp2 , Assets.buyItemDown2);		
		 
		 displayAlreadyPurhcace  = new UIButton(250, 200, 350, 300, Assets.premiumBought , Assets.premiumBought);		 	   	     
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
			displayAlreadyPurhcace.render(g);
		}
		else{
			buyPremiumItem.render(g);
		}
		if(pleaseWaitLocal){
			g.drawImage(Assets.displayWait, 0, 0);
		}

	}

	@Override
	public boolean onTouch(MotionEvent e, int scaledX, int scaledY) {
		Log.d("MainMenuState", "button clicked");	
		if (e.getAction() == MotionEvent.ACTION_DOWN) {
			back.onTouchDown(scaledX, scaledY);
			
			if(!GameMainActivity.mIsPremium)
				buyPremiumItem.onTouchDown(scaledX, scaledX);
			
			
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
			
			
			
			if (buyPremiumItem.isPressed(scaledX, scaledY)) {
				 buyPremiumItem.cancel();
				 Log.d(TAG, "Buy premium is pressed");
					Thread thread = new Thread(){				    
						public void run(){	
							pleaseWaitLocal = true;
								GameMainActivity.onUpgradeAppButtonClicked();
						    pleaseWaitLocal = false;
					    }
					  };
					  thread.start();			
				 							
		       }
			else{
				buyPremiumItem.cancel();
			}
			
			
			
		}
		return true;
	}
	
	

}
