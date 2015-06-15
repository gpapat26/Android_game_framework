package com.animals.state;

import android.util.Log;
import android.view.MotionEvent;

import com.animals.simpleandroidgdf.Assets;
import com.animals.simpleandroidgdf.GameMainActivity;
import com.animals.util.Painter;
import com.animals.util.UIButton;

public class BalloonPopState extends State{
	
	private UIButton back;
	
	private UIButton balloon_black;
	private UIButton balloon_blue;
	private UIButton balloon_green;
	private UIButton balloon_grey;
	private UIButton balloon_orange;
	
	private UIButton balloon_pink;
	private UIButton balloon_red;
	private UIButton balloon_yellow;
	
	private boolean black;
	private boolean blue;
	private boolean green;
	private boolean grey;
	private boolean orange;
	private boolean pink;
	private boolean red;
	private boolean yellow;
	
//	
//	  balloon_black = loadBitmap("balloon_black.png", true, false);
//	 balloon_black_pop = loadBitmap("balloon_black_bang.png", true, false);
//	
//	  balloon_blue = loadBitmap("balloon_blue.png", true, false);
//	balloon_blue_pop = loadBitmap("balloon_blue_bang.png", true, false);
//	
//	 balloon_green = loadBitmap("balloon_green.png", true, false);
//	 balloon_green_pop = loadBitmap("balloon_green_bang.png", true, false);
//	
//	 balloon_grey = loadBitmap("balloon_grey.png", true, false);
//	 balloon_grey_pop = loadBitmap("balloon_grey_bang.png", true, false);
//	
//	  balloon_orange = loadBitmap("balloon_orange.png", true, false);
//	  balloon_orange_pop = loadBitmap("balloon_orange_bang.png", true, false);
//	
//	 balloon_pink = loadBitmap("balloon_pink.png", true, false);
//	 balloon_pink_pop = loadBitmap("balloon_pink_bang.png", true, false);
//	
//	 balloon_red = loadBitmap("balloon_red.png", true, false);
//	 balloon_red_pop = loadBitmap("balloon_red_bang.png", true, false);
//	
//	balloon_yellow= loadBitmap("balloon_yellow.png", true, false);
//	balloon_yellow_pop = loadBitmap("balloon_yellow_bang.png", true, false);
	
	 public BalloonPopState() {
		init();
	}

	@Override
	public void init() {
		Assets.loadGalleryImage("farm1");	
		back = new UIButton(705, 355, 795, 445, Assets.home , Assets.home_down);	
		
		balloon_black = new UIButton(700, 400, 820, 600, Assets.balloon_black , Assets.balloon_black_pop);
		balloon_blue = new UIButton(500, 200, 620, 400, Assets.balloon_blue , Assets.balloon_blue_pop);
		balloon_green = new UIButton(705, 355, 795, 445, Assets.balloon_green , Assets.balloon_green_pop);
		balloon_grey = new UIButton(705, 355, 795, 445, Assets.balloon_grey , Assets.balloon_grey_pop);
		balloon_orange = new UIButton(705, 355, 795, 445, Assets.balloon_orange , Assets.balloon_orange_pop);
		balloon_pink = new UIButton(705, 355, 795, 445, Assets.balloon_pink , Assets.balloon_pink_pop);
		balloon_red = new UIButton(705, 355, 795, 445, Assets.balloon_red , Assets.balloon_red_pop);
		balloon_yellow = new UIButton(705, 355, 795, 445, Assets.balloon_yellow , Assets.balloon_yellow_pop);
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Painter g) {
		g.drawImage(Assets.galleryBitmap, 0, 0);
		back.render(g);
		balloon_blue.render(g);
		balloon_black.render(g);
		
		
		
	}

	@Override
	public boolean onTouch(MotionEvent e, int scaledX, int scaledY) {
		Log.d("MainMenuState", "button clicked");
		
		if (e.getAction() == MotionEvent.ACTION_DOWN) {
			
			back.onTouchDown(scaledX, scaledY);
			balloon_blue.onTouchDown(scaledX, scaledY);
			balloon_black.onTouchDown(scaledX, scaledY);
		}

		if (e.getAction() == MotionEvent.ACTION_UP) {
			 if (back.isPressed(scaledX, scaledY)) {
		    	   back.cancel();		    		
					GameMainActivity.sGame.setCurrentState(new MainMenuState());
					return true;
		       }
			 
			 if (balloon_blue.isPressed(scaledX, scaledY)) {		
				 balloon_blue.cancel();	
				 blue = false;
					//GameMainActivity.sGame.setCurrentState(new MainMenuState());
					return true;
		       }
			 
			 if (balloon_black.isPressed(scaledX, scaledY)) {
				 balloon_black.cancel();
				 black = false;
					//GameMainActivity.sGame.setCurrentState(new MainMenuState());
					return true;
		       }

		}

		return true;
	}

}
