package com.animals.simpleandroidgdf;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

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
	public static volatile Bitmap galleryBitmap;
	
	
	public static Bitmap start;
	public static Bitmap startDown;
	
	public static Bitmap carouzel_up;
	public static Bitmap carouzel_down;
	
	public static Bitmap carouzel_left;
	public static Bitmap carouzel_left_down;
	
	public static Bitmap carouzel_right;
	public static Bitmap carouzel_right_down;
	
	private static HashMap<Integer, String> carouzelMap = new HashMap<Integer, String>();
	
	
	public static void load(){
		//buttons and resources used all over the game
		start = loadBitmap("start_button.png",false,false);
		startDown = loadBitmap("start_button_down.png",false,false);
		
		carouzel_up = loadBitmap("carouzel_up.png",true,false);
		carouzel_down = loadBitmap("carouzel_down.png",true,false);
		
		carouzel_left = loadBitmap("carouzel_left.png",true,false);
		carouzel_left_down = loadBitmap("carouzel_left_down.png",true,false);
		
		carouzel_right = loadBitmap("carouzel_right.png",true,false);
		carouzel_right_down = loadBitmap("carouzel_right_down.png",true,false);
		
		loadCarouzelMap();
	}
	
	public static int getSizeOfGallery(){
		if(carouzelMap!= null){
			return carouzelMap.size();
		}
		return 0;
	}
	
	public static void loadGalleryImageResolver(int key){
		 if(key <=getSizeOfGallery() && key>=0){
			 String imageName= carouzelMap.get(key);
			 loadGalleryImage(imageName);
		 }
		
	}

	public static void loadGalleryImage(String imageName){
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
		newWidth -=100;
		
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
	
	
	  private static void loadCarouzelMap(){
		  int tempVariable = 1;
		  carouzelMap.put(tempVariable++, "ant");
		  carouzelMap.put(tempVariable++, "baby dear");
		  carouzelMap.put(tempVariable++, "bear-grizzly");
		  carouzelMap.put(tempVariable++, "bear-pollar");
		  
		  carouzelMap.put(tempVariable++, "bird-bat");
		  carouzelMap.put(tempVariable++, "bird-canary");
		  carouzelMap.put(tempVariable++, "bird-nightingale");
		  
		  carouzelMap.put(tempVariable++, "bison");
		  carouzelMap.put(tempVariable++, "Black panther");
		  
		  carouzelMap.put(tempVariable++, "Bull");
		  
		  carouzelMap.put(tempVariable++, "butterfly");
		  
		  carouzelMap.put(tempVariable++, "camel");
		  
		  carouzelMap.put(tempVariable++, "cat");
		  carouzelMap.put(tempVariable++, "cat-face");
		  carouzelMap.put(tempVariable++, "cat-siam");
		  
		  carouzelMap.put(tempVariable++, "chicken");
		  carouzelMap.put(tempVariable++, "chicks");
		  carouzelMap.put(tempVariable++, "chipmank");
		  
		  carouzelMap.put(tempVariable++, "Cow_female_black_white");
		  
		  carouzelMap.put(tempVariable++, "crab");
		  carouzelMap.put(tempVariable++, "crocodile");
		  carouzelMap.put(tempVariable++, "crow");
		  
		  carouzelMap.put(tempVariable++, "dog-german-shepard");
		  carouzelMap.put(tempVariable++, "dog-lassie");
		  carouzelMap.put(tempVariable++, "dog-terrier");
		  
		  
		  carouzelMap.put(tempVariable++, "dolphin");
		  
		  carouzelMap.put(tempVariable++, "dove");
		  
		  carouzelMap.put(tempVariable++, "dragonfly");
		  carouzelMap.put(tempVariable++, "duck");
		  
		  
		  carouzelMap.put(tempVariable++, "eagle-bold");
		  carouzelMap.put(tempVariable++, "elephant");
		  carouzelMap.put(tempVariable++, "elk");
		  
		  
		  
		  carouzelMap.put(tempVariable++, "fish-clown");
		  carouzelMap.put(tempVariable++, "fish-goldfish");
		  carouzelMap.put(tempVariable++, "fish-scorpion");
		  
		  carouzelMap.put(tempVariable++, "fox");
		  carouzelMap.put(tempVariable++, "frog");
		  carouzelMap.put(tempVariable++, "giraffe");
		  
		  carouzelMap.put(tempVariable++, "goat");

		  carouzelMap.put(tempVariable++, "green-grasshopper-wallpaper");
		  
		  carouzelMap.put(tempVariable++, "guinea-pig");
		  
		  carouzelMap.put(tempVariable++, "hedgehog");
		  
		  carouzelMap.put(tempVariable++, "horse");
		  carouzelMap.put(tempVariable++, "insect-bee");
		  
		  carouzelMap.put(tempVariable++, "Kangaroo");
		  
		  carouzelMap.put(tempVariable++, "koala");
		  
		  carouzelMap.put(tempVariable++, "ladybug");
		  carouzelMap.put(tempVariable++, "lamb");
		  carouzelMap.put(tempVariable++, "leopard");
		  carouzelMap.put(tempVariable++, "lion");
		  carouzelMap.put(tempVariable++, "lizard-Igouana");
		  carouzelMap.put(tempVariable++, "lizard");
		  
		  carouzelMap.put(tempVariable++, "lobster");
		  carouzelMap.put(tempVariable++, "monkey");
		  
		  carouzelMap.put(tempVariable++, "moose");
		  
		  carouzelMap.put(tempVariable++, "mosquito");
		  
		  carouzelMap.put(tempVariable++, "mouse-field");
		  
		  carouzelMap.put(tempVariable++, "orca");
		  
		  carouzelMap.put(tempVariable++, "owl");
		  
		  carouzelMap.put(tempVariable++, "panda");
		  
		  carouzelMap.put(tempVariable++, "parrot");

		  carouzelMap.put(tempVariable++, "peacoc");
		  
		  carouzelMap.put(tempVariable++, "penguin");
		  
		  carouzelMap.put(tempVariable++, "pig");
		  
		  carouzelMap.put(tempVariable++, "rabbit");
		  carouzelMap.put(tempVariable++, "rabit");
		  carouzelMap.put(tempVariable++, "racoon");
		  
		  carouzelMap.put(tempVariable++, "rhino");
		  
		  carouzelMap.put(tempVariable++, "rooster");
		  
		  carouzelMap.put(tempVariable++, "sea lion");
		  
		  carouzelMap.put(tempVariable++, "shark");
		  
		  carouzelMap.put(tempVariable++, "shrimp");
		  
		  carouzelMap.put(tempVariable++, "snail");
		  
		  carouzelMap.put(tempVariable++, "snake");
		  
		  carouzelMap.put(tempVariable++, "spider");
		  
		  carouzelMap.put(tempVariable++, "starfish");
		  
		  carouzelMap.put(tempVariable++, "swan");
		  
		  carouzelMap.put(tempVariable++, "swordfish");
		  
		  carouzelMap.put(tempVariable++, "tiger");
		  
		  carouzelMap.put(tempVariable++, "turkey");
		  
		  carouzelMap.put(tempVariable++, "turtle");
		  
		  carouzelMap.put(tempVariable++, "wolf");
		  
		  carouzelMap.put(tempVariable++, "zebra");
	 
	  }
	
	
	
	
	
	

}
