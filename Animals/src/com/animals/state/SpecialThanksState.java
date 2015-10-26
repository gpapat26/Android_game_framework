package com.animals.state;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.Paint.Align;
import android.view.MotionEvent;

import com.animals.model.Animal;
import com.animals.simpleandroidgdf.Assets;
import com.animals.simpleandroidgdf.GameMainActivity;
import com.animals.util.Painter;

public class SpecialThanksState extends State{
	
	
    private Animal currentAnimal;
    String[] credits ;
	public SpecialThanksState() {
	 init();
	}

	@Override
	public void init() {
		currentAnimal = Assets.currentAnimal;	
		credits = currentAnimal.imageDetails;
	}

	@Override
	public void update(float delta) {
		
		
	}

	@Override
	public void render(Painter g) {
		String author ;
		String source;
		String license;
		
		
		if(credits!= null && credits.length !=0 && credits[1] != null ){
			author = credits[1];
		}
		else{
			author ="No author";
		}
		
		if(credits!= null && credits.length !=0 && credits[0] != null ){
			source = credits[0];
		}
		else{
			source ="No source";
		}
		
		
		
		
		g.setColor(Color.rgb(53, 165, 253));
		g.fillRect(0, 0, GameMainActivity.GAME_WIDTH, GameMainActivity.GAME_HEIGHT);
		g.drawRectTextAligned(author, GameMainActivity.upperThirdScreen, 30, Typeface.DEFAULT_BOLD, Align.CENTER, Color.WHITE, true, 0);
		g.drawRectTextAligned(author, GameMainActivity.midThirdScreen, 30, Typeface.DEFAULT_BOLD, Align.CENTER, Color.WHITE, true, 0);
		g.drawRectTextAligned(author, GameMainActivity.midThirdScreen, 30, Typeface.DEFAULT_BOLD, Align.CENTER, Color.WHITE, true, 0);

	}

	@Override
	public boolean onTouch(MotionEvent e, int scaledx, int scaledY) {
		
		return true;
	}

}
