package com.animals.state;

import android.R.color;
import android.util.Log;
import android.view.MotionEvent;

import com.animals.simpleandroidgdf.Assets;
import com.animals.util.Painter;
import com.animals.util.UIButton;

public class CarouzelState extends State {
	
	public static int carouzelIndex = 1;

	private UIButton carouzel_prev;
	private UIButton carouzel_next;
	
	public  CarouzelState() {
		init();
	}
	@Override
	public void init() {
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
		//g.drawImage(Assets.galle, 0, 0);
		//Assets.loadGalleryImageResolver(carouzelIndex);
		g.drawImage(Assets.galleryBitmap, 0, 0);
		carouzel_prev.render(g);
		carouzel_next.render(g);		
	}

	@Override
	public boolean onTouch(MotionEvent e, int scaledX, int scaledY) {
		Log.d("CarouzelState", "Carouzel button is pressed");
		if (e.getAction() == MotionEvent.ACTION_DOWN) {
			carouzel_next.onTouchDown(scaledX, scaledY);
			carouzel_prev.onTouchDown(scaledX, scaledY);
		}

		if (e.getAction() == MotionEvent.ACTION_UP) {
			
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
		return true;
	}

}
