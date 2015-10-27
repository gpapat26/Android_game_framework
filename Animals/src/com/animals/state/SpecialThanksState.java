package com.animals.state;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.Paint.Align;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.view.MotionEvent;
import android.widget.Toast;

import com.animals.model.Animal;
import com.animals.simpleandroidgdf.Assets;
import com.animals.simpleandroidgdf.GameMainActivity;
import com.animals.simpleandroidgdf.GameView;
import com.animals.simpleandroidgdf.R;
import com.animals.util.Painter;

public class SpecialThanksState extends State{
	
	private  float x1,x2 = 0;
    private Animal currentAnimal;
    String[] credits ;
    String navigationLink;
    int navCounter = 0;
    static final int MIN_DISTANCE = 150;
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
			//author= "Author: " + author;
		}
		else{
			author ="No author";
		}
		
		if(credits!= null && credits.length !=0 && credits[0] != null ){
			navigationLink=source = credits[0];
			source="Source: "+source;
		}
		else{
			source ="";
		}
		
		if(credits!= null && credits.length !=0 && credits[3] != null ){
			license = "Lisence info: "+credits[3];
		}
		else{
			license ="";
		}
		
		String animalName = GameView.context.getResources().getString(currentAnimal.getAnimalName(GameMainActivity.getLanguageCode()));
		
		
		g.setColor(Color.rgb(53, 165, 253));
		g.fillRect(0, 0, GameMainActivity.GAME_WIDTH, GameMainActivity.GAME_HEIGHT);
		g.drawRectTextAligned(animalName, GameMainActivity.midThirdScreen, 30, Typeface.DEFAULT_BOLD, Align.CENTER, Color.WHITE, true, 0);
		g.drawRectTextAligned(author, GameMainActivity.upperThirdScreen, 20, Typeface.DEFAULT_BOLD, Align.CENTER, Color.WHITE, true, 0);
		g.drawRectTextAligned(license, GameMainActivity.lowerThirdScreen, 20, Typeface.DEFAULT_BOLD, Align.CENTER, Color.WHITE, true, 0);
	}

	@Override
	public boolean onTouch(MotionEvent e, int scaledx, int scaledY) {
		
		
		if(e.getAction() == MotionEvent.ACTION_DOWN){
			 x1 = e.getX();
		}
		

		
		if (( e.getAction() == MotionEvent.ACTION_UP)  ) {
			
			 x2 = e.getX();
			 float deltaX = x2 - x1;
			 
			 if (Math.abs(deltaX) > MIN_DISTANCE){
				       navCounter=0;
		        	   setCurrentState(new CarouzelState());	           
			 }
			
			 if(GameMainActivity.instance.isNetworkAvailable())	{
				if(navigationLink != null && navigationLink.length()>0){
					if(navCounter<1){
						 //Toast.makeText(GameMainActivity.sGame.context, R.string.exit,Toast.LENGTH_SHORT).show();
						 navCounter++;
					}else{
						 openWebURL(navigationLink);
						 navCounter=0;
					}
					
					
				}
				
			}
			else{
				navCounter=0;
				setCurrentState(new CarouzelState());	
			}
		}
		return true;
	}
	
	
	public void openWebURL( String inURL ) {
	    Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( inURL ) );
	    GameMainActivity.instance.startActivity( browse );
	}
	


}
