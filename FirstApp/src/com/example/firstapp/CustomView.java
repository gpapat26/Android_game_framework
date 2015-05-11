package com.example.firstapp;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Canvas;

public class CustomView extends View {
	
	private Rect myRect;
	private Paint myPaint;
	private static final int SQUARE_SIDE_LENGTH = 200;

	public CustomView(Context context) {
		super(context);
		myRect = new Rect(30, 30, SQUARE_SIDE_LENGTH, SQUARE_SIDE_LENGTH);
		myPaint = new Paint();
		myPaint.setColor(Color.MAGENTA);
		
	}
	
	@Override
	protected void onDraw(Canvas canvas){
		canvas.drawRGB(39,111, 184);
		canvas.drawRect(myRect, myPaint);
		
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event){
		myRect.left = (int)event.getX()-(SQUARE_SIDE_LENGTH/2);
		myRect.top = (int)event.getY()-(SQUARE_SIDE_LENGTH/2);
		myRect.right = (int)event.getX()+(SQUARE_SIDE_LENGTH/2);
		myRect.bottom = (int)event.getY()+(SQUARE_SIDE_LENGTH/2);
		invalidate(); // calls onCraw
		return true;
	}

}
