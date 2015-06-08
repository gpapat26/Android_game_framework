package com.animals.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;


public class Painter {
	
	private Canvas canvas;
	private Paint paint;
	private Rect srcRect;
	private Rect dstRect;
	private RectF dstRectF;
	
	
	public Painter(Canvas canvas ){
		this.canvas = canvas;
		paint = new Paint();
		srcRect = new Rect();
		dstRect = new Rect();
		dstRectF = new RectF();
	}
	
	public void setColor(int color){
		paint.setColor(color);
	}
	
	public void setFont(Typeface typeFace, float textSize){
		paint.setTypeface(typeFace);
		paint.setTextSize(textSize);
	}
	
	public  void drawString(String str , int x, int y){
		canvas.drawText(str, x, y, paint);
	}
	
	public void fillRect(int x , int y, int width , int height){
		dstRect.set(x, y, x+width, y+height);
		paint.setStyle(Paint.Style.FILL);
		canvas.drawRect(dstRect, paint);
	}
	
	public void drawImage(Bitmap bitmap ,int x, int y, int width , int height ){
		srcRect.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
		dstRect.set(x,y,x+width,y+height);
		canvas.drawBitmap(bitmap, srcRect, dstRect,paint);		
	}
	
	public void drawImage(Bitmap bitmap ,int x, int y){
		if(bitmap != null)
		canvas.drawBitmap(bitmap, x, y,paint);		
	}
	
	public void fillOval(int x, int y, int width, int height){
		paint.setStyle(Paint.Style.FILL);
		dstRectF.set(y, y, x+width, y+height);
		canvas.drawOval(dstRectF, paint);
	}
	
	public Canvas getCanvasObj(){
		return canvas;
	}
	
	public Paint getPaint(){
		return paint;
	}
	
	public void drawRectTextAligned(String text, Rect r,int textSize,android.graphics.Typeface typeFace, android.graphics.Paint.Align align,int color) {
		
		this.paint.setARGB(128, 255, 255, 255);
		this.canvas.drawRect(r, this.paint);	
		this.paint.setColor(color);		
		this.paint.setTypeface(typeFace);
		this.paint.setTextSize(textSize);
		this.paint.setTextAlign(align);
	    int width = r.width();
	    int numOfChars = this.paint.breakText(text,true,width,null);
	    int start = (text.length()-numOfChars)/2;
	    this.canvas.drawText(text,start,start+numOfChars,r.exactCenterX(),r.exactCenterY()+20,this.paint);
	}
	
//	public void draw(Canvas canvas,Rect r)
//	 {
//	  final RectF rectF = new RectF();
//	  final Paint paint = new Paint();
//	  paint.setARGB(128, 255, 255, 255);
//
//	  rectF.set(0,0, r.width(), r.height());
//
//	  canvas.drawRect(drawRect, paint);
//	}
	
	
	

}
