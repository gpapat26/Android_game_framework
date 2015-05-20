package com.georgepapatheodorou.spacejumper.simpleandroidgdf;

import java.io.IOException;
import java.io.InputStream;

import com.georgepapatheodorou.spacejumper.animation.Animation;
import com.georgepapatheodorou.spacejumper.animation.Frame;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.MediaPlayer;

public class Assets {
	
	private static SoundPool soundPool;
	public static Bitmap welcome;
	
	public static Bitmap block, cloud1, cloud2,duck,grass,jump,run1,run2,run3,run4,run5,scoreDown,startDown,start,score;
	public static Animation runAnimation;
	public static int hitID,onJumpID;
	
	private static MediaPlayer mediaPlayer;
	
	
	public static void load(){
		welcome = loadBitmap("welcome.png",false);
		
		block = loadBitmap("block.png",false);
		
		cloud1 = loadBitmap("cloud1.png",false);
		
		cloud2 = loadBitmap("cloud2.png",false);
		
		duck = loadBitmap("duck.png",false);
		
		grass = loadBitmap("grass.png",false);
		
		jump = loadBitmap("jump.png",false);
		
		run1 = loadBitmap("run_anim1.png",false);
		run2 = loadBitmap("run_anim2.png",false);
		run3 = loadBitmap("run_anim3.png",false);
		run4 = loadBitmap("run_anim4.png",false);
		run5 = loadBitmap("run_anim5.png",false);
		
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
		
		//hitID = loadSound("hit.wav");
		//onJumpID = loadSound("onjump.wav");
		
		
		
	}
	
	public static void onResume(){
		hitID = loadSound("hit.wav");
		onJumpID = loadSound("onjump.wav");
		playMusic("bgmusic.mp3", true);
	}
	
	public static void onPause(){
		if(soundPool != null){
			soundPool.release();
			soundPool = null;
		}
		
		if(mediaPlayer != null){
			mediaPlayer.stop();
			mediaPlayer.release();
			mediaPlayer = null;
		}
		
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
		if(soundPool != null)
		soundPool.play(soundID, 1, 1, 1, 0, 1);
	}
	
	public static void playMusic(String filename, boolean looping){
		if(mediaPlayer == null){
			mediaPlayer = new MediaPlayer();
		}
		try {
			AssetFileDescriptor afd = GameMainActivity.assets.openFd(filename);
			mediaPlayer.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());
			mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
			mediaPlayer.prepare();
			mediaPlayer.setLooping(looping);
			mediaPlayer.start();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

}
