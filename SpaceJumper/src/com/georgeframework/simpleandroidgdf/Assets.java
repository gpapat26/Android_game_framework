package com.georgeframework.simpleandroidgdf;

import java.io.IOException;
import java.io.InputStream;

import com.georgeframework.animation.Animation;
import com.georgeframework.animation.Frame;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.AudioManager;
import android.media.SoundPool;

public class Assets {
	
	private static SoundPool soundPool;
	public static Bitmap welcome;
	
	public static Bitmap block, cloud1, cloud2,duck,grass,jump,run1,run2,run3,run4,run5,scoreDown,startDown,start,score;
	public static Animation runAnimation;
	public static int hitID,onJumpID;
	
	public static void load(){
		welcome = loadBitmap("welcome.png",false);
		
		block = loadBitmap("welcome.png",false);
		
		cloud1 = loadBitmap("cloud1.png",false);
		
		cloud2 = loadBitmap("cloud2.png",false);
		
		duck = loadBitmap("duck.png",false);
		
		grass = loadBitmap("grass.png",false);
		
		jump = loadBitmap("jump.png",false);
		
		run1 = loadBitmap("run1.png",false);
		run2 = loadBitmap("run2.png",false);
		run3 = loadBitmap("run3.png",false);
		run4 = loadBitmap("run4.png",false);
		run5 = loadBitmap("run5.png",false);
		
		scoreDown = loadBitmap("score_button_down.png",true);
		
		score = loadBitmap("score_button.png",true);
		
		startDown = loadBitmap("start_button_down.png",true);
		
		start = loadBitmap("start_button.png",true);
		
		Frame f1 = new Frame(run1, 0.1f);
		Frame f2 = new Frame(run2, 0.1f);
		Frame f3 = new Frame(run3, 0.1f);
		Frame f4 = new Frame(run4, 0.1f);
		Frame f5 = new Frame(run5, 0.1f);
		
		runAnimation = new Animation(f1,f2,f3,f4,f5);
		
		hitID = loadSound("hit.wav");
		onJumpID = loadSound("onjump.wav");
		
		
		
	}

	private static Bitmap loadBitmap(String filename, boolean transparency) {
		InputStream inputStream = null;
		
		try{
			inputStream = GameMainActivity.assets.open(filename);
		}catch(IOException e){
			e.printStackTrace();
		}
		Options options = new Options();
		if(transparency){
			options.inPreferredConfig = Config.ARGB_8888;
		}else{
			options.inPreferredConfig = Config.RGB_565;
		}
		Bitmap bitmap = BitmapFactory.decodeStream(inputStream,null,options);
				
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

}
