package com.animals.simpleandroidgdf;

import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.Point;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

public class Assets {
	
	private static SoundPool soundPool;
	public static Bitmap welcome;
	public static Bitmap galleryBitmap;
	public static Bitmap galleryOldBitmap;
	
	public static Bitmap start;
	public static Bitmap startDown;
	
	
	public static void load(){
		//welcome = loadBitmap("welcome screen.jpg",false);
		start = loadBitmap("start_button.png",false,false);
		startDown = loadBitmap("start_button_down.png",false,false);

	}

	public static void load(String imageName){
		//destroyOldImage();
		galleryBitmap = loadBitmap(imageName+".jpg",false,true);
	}
	
	private static Bitmap loadBitmap(String filename, boolean transparency,boolean isGalleryImage) {
		InputStream inputStream = null;
		
		try{
			inputStream = GameMainActivity.assets.open(filename);
		}catch(IOException e){
			e.printStackTrace();
			Log.d("Assets", "Cannot find file :"+filename);
		}
		Options options = new Options();
		
		
		if(transparency){
			options.inPreferredConfig = Config.ARGB_8888;
		}else{
			options.inPreferredConfig = Config.RGB_565;
			
		}
		
		Bitmap bitmap = BitmapFactory.decodeStream(inputStream,null,options);
		
		if(isGalleryImage){
			bitmap = getResizedBitmap(bitmap);
		}
		return bitmap;
	}
	
	public static int loadSound(String filename){
		int soundID = 0;
		
		if(soundPool ==null){
			soundPool = new SoundPool(25, AudioManager.STREAM_MUSIC, 0);
		}
		try{
			soundID = soundPool.load(GameMainActivity.assets.openFd(filename), 1);
		}catch(IOException e){
			e.printStackTrace();
		}
		return soundID;
	}
	
	public static void playSound(int soundID){
		soundPool.play(soundID, 1, 1, 1, 0, 1);
	}
	


	
	public static Bitmap getResizedBitmap(Bitmap bm) {
		 
		int width = bm.getWidth();		 
		int height = bm.getHeight();
		Log.d("Assets", "Bitmap width,height :"+width+","+height);
		
		Context context = GameMainActivity.sGame.getContext();		
		WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);		
		Display display = wm.getDefaultDisplay();
		Point size = new Point();		
		display.getSize(size);
		
		
		
		int newWidth = size.x;
		int newHeight = size.y;
		Log.d("Assets", "Screen width,height :"+newWidth+","+newHeight);
		
		
		newHeight -=100;
		
		float scaleWidth = ((float) newWidth) / width;
		 
		float scaleHeight = ((float) newHeight) / height;
		 
		// create a matrix for the manipulation
		 
		Matrix matrix = new Matrix();
		 
		// resize the bit map
		 
		matrix.postScale(scaleWidth, scaleHeight);
		 
		// recreate the new Bitmap
		
				 
		Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, false);
						 
		return resizedBitmap;
		 
		}
	
//	public static void destroyOldImage(){
//		if (galleryBitmap!= null){
//			
//			galleryBitmap.recycle();		
//		}
//	}
	
	
	
	
	
	

}
