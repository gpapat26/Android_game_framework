package com.animals.simpleandroidgdf;

import java.io.IOException;
import java.io.InputStream;

import com.animals.animation.Animation;
import com.animals.animation.Frame;
import com.animals.model.Animal;
import com.animals.state.BalloonLooseState;
import com.animals.state.BalloonPopState;
import com.animals.state.BalloonWinState;
import com.animals.state.CarouzelState;
import com.animals.state.LanguageState;
import com.animals.state.MainMenuState;
import com.animals.state.SelectBalloonWinState;
import com.animals.state.StartState;
import com.animals.util.UIButton;

import android.app.AlertDialog;











import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.Point;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.WindowManager;

public class Assets {

	private static SoundPool soundPool;
	public static Bitmap welcome;
	public static volatile Bitmap galleryBitmap;

	public static Bitmap start;
	public static Bitmap startDown;

	public static Bitmap carouzel_up1;
	public static Bitmap carouzel_down1;

	public static Bitmap carouzel_left;
	public static Bitmap carouzel_left_down;

	public static Bitmap carouzel_right;
	public static Bitmap carouzel_right_down;
	public static int streamIDplaying = 0;

	public static Bitmap language;
	public static Bitmap language_down;

	public static Bitmap greek;
	public static Bitmap greek_down;

	public static Bitmap english;
	public static Bitmap english_down;
	
	public static Bitmap play_animal;
	public static Bitmap play_animal_down;
	
	public static Bitmap back;
	public static Bitmap back_down;
	
	public static Bitmap home;
	public static Bitmap home_down;
	
	public static Bitmap balloons_button;
	public static Bitmap balloons_button_down;
	
	public static Bitmap balloon_black;
	public static Bitmap balloon_black_pop;
	
	public static Bitmap balloon_blue;
	public static Bitmap balloon_blue_pop;
	
	public static Bitmap balloon_green;
	public static Bitmap balloon_green_pop;
	
	public static Bitmap balloon_grey;
	public static Bitmap balloon_grey_pop;
	
	public static Bitmap balloon_orange;
	public static Bitmap balloon_orange_pop;
	
	public static Bitmap balloon_pink;
	public static Bitmap balloon_pink_pop;
	
	public static Bitmap balloon_red;
	public static Bitmap balloon_red_pop;
	
	public static Bitmap balloon_yellow;
	public static Bitmap balloon_yellow_pop;
	
	public static Bitmap balloon_clown;
	public static Bitmap balloon_clown_pop;
	
	public static Bitmap balloon_girraffe;
	public static Bitmap balloon_hippo;
	
	public static Bitmap replay;
	public static Bitmap replayDown;
	
	//public static Bitmap grass_sky;
	

	public static SparseArray<Animal> animals = new SparseArray<Animal>();

	private static MediaPlayer mediaPlayer;
	
	private static MediaPlayer mediaPlayer2;
	
	private static MediaPlayer mediaPlayer3;
	
	private static int balloonPopId ;
	private static int balloonClownId ;
	private static int powerUpAscendingDingId;
	public static Bitmap scoreDown;
	public static Bitmap score;
	public static Bitmap scoreDown2;
	public static Bitmap score2;
	public static Bitmap signIn;
	public static Bitmap signInDown;
	public static Bitmap signOut;
	public static Bitmap signOutDown;
	
	public static Bitmap buyItemUp;
	public static Bitmap buyItemDown;
	
	public static Bitmap premiumBought;
	
	public static Bitmap buyItemUp2;
	public static Bitmap buyItemDown2;
	public static Animal currentAnimal;
	//public static Bitmap displayWait;
	public static Bitmap cloud1;
	public static Bitmap cloud2;
	
	public static Bitmap special_thanks_up;
	
	public static Bitmap special_thanks_down;
	
	public static final String creativeLisenceBy = "https://creativecommons.org/licenses/by/2.0/";
	
	public static final String creativeLisencePublicDomain = "https://creativecommons.org/publicdomain/zero/1.0/";

	

	
	
	

	public static void load() {
		
		cloud1 = loadBitmap("cloud1.png", true,false);
		cloud2 = loadBitmap("cloud2.png", true,false);

		start = loadBitmap("start_button.png", false, false);
		startDown = loadBitmap("start_button_down.png", false, false);
		
		carouzel_up1 = loadBitmap("carouzel_up1.png", true, false);
		carouzel_down1 = loadBitmap("carouzel_down1.png", true, false);

		carouzel_left = loadBitmap("carouzel_previous.png", true, false);
		carouzel_left_down = loadBitmap("carouzel_prev_down.png", true, false);

		carouzel_right = loadBitmap("carouzel_next.png", true, false);
		carouzel_right_down = loadBitmap("carouzel_next_down.png", true, false);

		language = loadBitmap("Language.png", true, false);
		language_down = loadBitmap("Language_down.png", true, false);

		greek = loadBitmap("greek_button.png", true, false);
		greek_down = loadBitmap("greek_button_down.png", true, false);

		english = loadBitmap("english_button.png", true, false);
		english_down = loadBitmap("english_button_down.png", true, false);
		
		play_animal = loadBitmap("play_gallery_animal_up.png", true, false);
		play_animal_down = loadBitmap("play_gallery_animal_down.png", true, false);
				
		back = loadBitmap("back.png", true, false);
		back_down = loadBitmap("back_down.png", true, false);
		
		home = loadBitmap("button_home_up.png", true, false);
	    home_down = loadBitmap("button_home_down.png", true, false);
	    
	    home = loadBitmap("button_home_up.png", true, false);
	    home_down = loadBitmap("button_home_down.png", true, false);
		
	    balloons_button = loadBitmap("balloons_button.png", true, false);
	    balloons_button_down = loadBitmap("balloons_button_down.png", true, false);
		
	       
	    
		  balloon_black = loadBitmap("balloon_black.png", true, false);
		 balloon_black_pop = loadBitmap("balloon_black_bang.png", true, false);
		
		  balloon_blue = loadBitmap("balloon_blue.png", true, false);
		balloon_blue_pop = loadBitmap("balloon_blue_bang.png", true, false);
		
		 balloon_green = loadBitmap("balloon_green.png", true, false);
		 balloon_green_pop = loadBitmap("balloon_green_bang.png", true, false);
		
		 balloon_grey = loadBitmap("balloon_grey.png", true, false);
		 balloon_grey_pop = loadBitmap("balloon_grey_bang.png", true, false);
		
		  balloon_orange = loadBitmap("balloon_orange.png", true, false);
		  balloon_orange_pop = loadBitmap("balloon_orange_bang.png", true, false);
		
		 balloon_pink = loadBitmap("balloon_pink.png", true, false);
		 balloon_pink_pop = loadBitmap("balloon_pink_bang.png", true, false);
		
		 balloon_red = loadBitmap("balloon_red.png", true, false);
		 balloon_red_pop = loadBitmap("balloon_red_bang.png", true, false);
		
		 balloon_yellow= loadBitmap("balloon_yellow.png", true, false);
		 balloon_yellow_pop = loadBitmap("balloon_yellow_bang.png", true, false);
		 
		 balloon_clown     = loadBitmap("balloon_clown.png", true, false);
		 balloon_clown_pop = loadBitmap("balloon_clown_bang.png", true, false);
		 
		 balloon_girraffe    = loadBitmap("balloon_girraffe.png", true, false);
		 balloon_hippo = loadBitmap("balloon_hippo.png", true, false);
		 
		scoreDown = loadBitmap("score_button_down.png", true, false);
		score = loadBitmap("score_button.png", true, false);
			
		scoreDown2 = loadBitmap("score_button_play_down.png", true, false);
		score2 = loadBitmap("score_button_play.png", true, false);
			
		signIn = loadBitmap("sign_in.png", true, false);
		signInDown = loadBitmap("sign_in_down.png", true, false);
		signOut = loadBitmap("sign_out.png", true, false);
		signOutDown = loadBitmap("sign_out_down.png", true, false);
		
		buyItemUp = loadBitmap("buy_item_up.png", true, false);
		buyItemDown = loadBitmap("buy_item_down.png", true, false);
		
		buyItemUp2 = loadBitmap("Buy.png", true, false);
		buyItemDown2 = loadBitmap("Buy_down.png", true, false);
		
		premiumBought = loadBitmap("premium_bought.png", true, false);
		
		replay = loadBitmap("replayButton.png", true, false);
		replayDown = loadBitmap("replayButton_down.png", true, false);
		
		special_thanks_up = loadBitmap("special_thanks.png", true, false);
		
		special_thanks_down = loadBitmap("special_thanks_down.png", true, false);
		
		//displayWait =loadBitmap("loading.jpg", true, false);
		 
		//grass_sky = loadBitmap("grass_sky.jpg", true, false);
		 		 	 
		loadCarouzelMap();
		
		loadBaloonPop("balloon_pop.mp3");
		
		loadZongPop("wrong2.mp3");
		
		loadAscendingPowerUp("comedy_marimba_ascend_003.mp3");
		
	
	}

	private static void loadBaloonPop(String filenaMe) {
		if(soundPool == null)
		  buildSoundPool();
		 if(soundPool == null){
			 Log.d("Assets", "SoundPool is not created 3");
		 }
		balloonPopId = loadSound(filenaMe);
		
	}
	
	private static void loadZongPop(String filenaMe) {
		if(soundPool == null)
		buildSoundPool();
		 if(soundPool == null){
			 Log.d("Assets", "SoundPool is not created 3");
		 }
		 balloonClownId = loadSound(filenaMe);
		
	}
	
	private static void loadAscendingPowerUp(String filenaMe) {
		if(soundPool == null)
		buildSoundPool();
		 if(soundPool == null){
			 Log.d("Assets", "SoundPool is not created 3");
		 }
		 powerUpAscendingDingId = loadSound(filenaMe);
		
	}
	
	public static void playBalloonPop(){
		playAlreadyLoadedSound(balloonPopId);
	}
	
	public static void playClownPop(){
		playAlreadyLoadedSound(balloonClownId);
	}
	
	public static void playAnimalPop() {		
		playAlreadyLoadedSound(powerUpAscendingDingId);
		
	}

	public static int getSizeOfGallery() {
		if (animals != null) {
			return animals.size();
		}
		return 0;
	}

	public static void loadGalleryImageResolver(int key) {
		if (key <= getSizeOfGallery() && key >= 0) {
			String imageName = null;
			try {
				currentAnimal=animals.get(key);
				imageName= currentAnimal.getAnimalVisualFile();
				//imageName = animals.get(key).getAnimalVisualFile();
				loadGalleryImage(imageName);
			} catch (Exception e) {
				Log.d("Assets", "Error loading gallery resource with id :"
						+ key);
			}

		}

	}

	public static void loadGalleryImage(String imageName) {
		galleryBitmap = loadBitmap(imageName + ".jpg", false, true);
	}

	private static Bitmap loadBitmap(String filename, boolean transparency,
			boolean isGalleryImage) {
		InputStream inputStream = null;

		try {
			inputStream = GameMainActivity.assets.open(filename);
		} catch (IOException e) {
			e.printStackTrace();
			Log.d("Assets", "Cannot find file :" + filename);
		}
		Options options = new Options();

		if (transparency) {
			options.inPreferredConfig = Config.ARGB_8888;
		} else {
			options.inPreferredConfig = Config.RGB_565;

		}

		Bitmap bitmap = BitmapFactory.decodeStream(inputStream, null, options);

		if (isGalleryImage) {
			bitmap = getResizedBitmap(bitmap);
		}
		return bitmap;
	}

	public static void playLoadedSound(String soundFileName) {
		//int id = loadSound(soundFileName + ".ogg");
		int id = loadSound(soundFileName);
		playSound(id);
	}

	private static int loadSound(String filename) {
		int soundID = 0;
		if (soundPool == null) {
			soundPool = buildSoundPool();
		}
		try {
//			if (streamIDplaying != -99999999 && soundPool != null) {
//				Log.d("Assets", "Stopped music with strweam id"
//						+ streamIDplaying);
//				soundPool.stop(streamIDplaying);
//			}
			soundID = soundPool.load(GameMainActivity.assets.openFd(filename),1);
			Log.d("Assets", "generated a new sound id " + soundID);
		
		} catch (IOException e) {
			e.printStackTrace();
			Log.d("Assets", "UNABLE TO GENERATE SOUND ID ");
		}
		return soundID;
	}

	public static void stopSoundOnDemand() {
		soundPool.stop(streamIDplaying);
	}

	@SuppressWarnings("deprecation")
	@TargetApi(Build.VERSION_CODES.LOLLIPOP)
	private static SoundPool buildSoundPool() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

			AudioAttributes audioAttributes = new AudioAttributes.Builder()
					.setUsage(AudioAttributes.USAGE_GAME)
					.setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
					.build();
             
			soundPool = new SoundPool.Builder().setMaxStreams(30)
					.setAudioAttributes(audioAttributes).build();
			 
			 if(soundPool == null){
				 Log.d("Assets", "SoundPool is not created 1");
			 }
		} else {
			soundPool = new SoundPool(30, AudioManager.STREAM_MUSIC, 0);
			 if(soundPool == null){
				 Log.d("Assets", "SoundPool is not created 2");
			 }
		}

		return soundPool;
	}

	private static void playSound(final int soundID) {
		if (soundPool != null) {

			soundPool.setOnLoadCompleteListener(new OnLoadCompleteListener() {
				@Override
				public void onLoadComplete(SoundPool soundPool, int sampleId,
						int status) {
					streamIDplaying = soundPool.play(soundID, 20, 20, 1, 0, 1f);
				}
			});

		}
	}
	
	private static void playAlreadyLoadedSound(int soundID){
		try{
		
		if(soundPool != null){
			 Log.d("Assets", "playing soundId "+soundID);
			
			soundPool.play(soundID, 1, 1, 1, 0, 1);
		}
		else{
			 Log.d("Assets", "Not playing music "+soundID);						
		}
		
		}catch(Exception e){
			Log.d("Assets", "Unable to play "+soundID);
		}
	
	}

	// play music themes
	public static void playMusic(String filename, boolean looping) {
		 Log.d("Assets", "playing music");
		
		 if (mediaPlayer == null) {
		 mediaPlayer = new MediaPlayer();
		 }
		 try {
		 AssetFileDescriptor afd = GameMainActivity.assets.openFd(filename);
		 mediaPlayer.setDataSource(afd.getFileDescriptor(),
		 afd.getStartOffset(), afd.getLength());
		 afd.close();
		 
		 mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);	 
		 mediaPlayer.prepare();
		 mediaPlayer.setLooping(looping);
		 mediaPlayer.start();
		 } catch (Exception e) {
		 e.printStackTrace();
		 }
	}
	
	

	public static MediaPlayer playMusic2(String filename, boolean looping) {
		
		AssetFileDescriptor afd = null;

		Log.d("Assets", "playing music");
		if (mediaPlayer2 == null) {
			mediaPlayer2 = new MediaPlayer();
			mediaPlayer2.setAudioStreamType(AudioManager.STREAM_MUSIC);
			mediaPlayer2.setLooping(looping);
		
		}
		try {

			if (mediaPlayer2 != null) {
				mediaPlayer2.pause();
				mediaPlayer2.release();
				mediaPlayer2 = new MediaPlayer();
				mediaPlayer2.setAudioStreamType(AudioManager.STREAM_MUSIC);
				mediaPlayer2.setLooping(looping);
				
			}

			afd = GameMainActivity.assets.openFd(filename);
			mediaPlayer2.setDataSource(afd.getFileDescriptor(),
					afd.getStartOffset(), afd.getLength());
			afd.close();

			// mediaPlayer.setAudioStreamType(AudioManager.);

			mediaPlayer2.prepareAsync();

			mediaPlayer2.setOnPreparedListener(new OnPreparedListener() {

				@Override
				public void onPrepared(MediaPlayer mp) {
					if (!mp.isPlaying()){
						mp.setVolume(1.0f, 1.0f);
						mp.start();
					}
						
				}
			});

			mediaPlayer2.setOnErrorListener(new OnErrorListener() {

				@Override
				public boolean onError(MediaPlayer mp, int what, int extra) {
					Log.d("Assets",
							"An error has occured in the media player what: "
									+ what + " extra: " + extra);
					return false;
				}
			});

			mediaPlayer2.setOnCompletionListener(new OnCompletionListener() {

				@Override
				public void onCompletion(MediaPlayer mp) {
					mp.reset();
				}

			});

			mediaPlayer2.setOnInfoListener(new OnInfoListener() {

				@Override
				public boolean onInfo(MediaPlayer mp, int what, int extra) {
					// TODO Auto-generated method stub
					return false;
				}

			});

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mediaPlayer2;
	}

	public static MediaPlayer playMusic3(String filename, boolean looping) {
	

		AssetFileDescriptor afd = null;

		Log.d("Assets", "playing music");
		if (mediaPlayer3 == null) {
			mediaPlayer3 = new MediaPlayer();
			mediaPlayer3.setAudioStreamType(AudioManager.STREAM_MUSIC);
			mediaPlayer3.setLooping(looping);
		
			
		}
		try {

			if (mediaPlayer3 != null) {
				mediaPlayer3.pause();
				mediaPlayer3.release();
				mediaPlayer3 = new MediaPlayer();
				mediaPlayer3.setAudioStreamType(AudioManager.STREAM_MUSIC);
				mediaPlayer3.setLooping(looping);
				
			}

			afd = GameMainActivity.assets.openFd(filename);
			mediaPlayer3.setDataSource(afd.getFileDescriptor(),
					afd.getStartOffset(), afd.getLength());
			afd.close();

			// mediaPlayer.setAudioStreamType(AudioManager.);

			mediaPlayer3.prepareAsync();

			mediaPlayer3.setOnPreparedListener(new OnPreparedListener() {

				@Override
				public void onPrepared(MediaPlayer mp) {
					if (!mp.isPlaying()){
						mp.setVolume(1.0f, 1.0f);
						mp.start();
						
					}
						
				}
			});

			mediaPlayer3.setOnErrorListener(new OnErrorListener() {

				@Override
				public boolean onError(MediaPlayer mp, int what, int extra) {
					Log.d("Assets",
							"An error has occured in the media player what: "
									+ what + " extra: " + extra);
					return false;
				}
			});

			mediaPlayer3.setOnCompletionListener(new OnCompletionListener() {

				@Override
				public void onCompletion(MediaPlayer mp) {
					mp.reset();
				}

			});

			mediaPlayer3.setOnInfoListener(new OnInfoListener() {

				@Override
				public boolean onInfo(MediaPlayer mp, int what, int extra) {
					// TODO Auto-generated method stub
					return false;
				}

			});
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mediaPlayer3;
	}

	public static void onResume() {
		playMusic("179_full_rollercoaster-fun_0121.mp3", true);
//		if(GameMainActivity.sGame.currentState instanceof StartState)
//		{				
//			playMusic("179_full_rollercoaster-fun_0121.mp3", true);
//		}
//		else if(GameMainActivity.sGame.currentState instanceof MainMenuState)
//		{				
//			playMusic("179_full_rollercoaster-fun_0121.mp3", true);
//		}
//		else if(GameMainActivity.sGame.currentState instanceof CarouzelState){
//			
//			
//		}
//		else if(GameMainActivity.sGame.currentState instanceof LanguageState){
//			
//			playMusic("179_full_rollercoaster-fun_0121.mp3", true);
//		}
//		else if(GameMainActivity.sGame.currentState instanceof BalloonPopState)
//		{				
//			playMusic("179_full_rollercoaster-fun_0121.mp3", true);
//		}
//		else if(GameMainActivity.sGame.currentState instanceof BalloonWinState)
//		{				
//			playMusic("179_full_rollercoaster-fun_0121.mp3", true);
//		}
//		else if(GameMainActivity.sGame.currentState instanceof BalloonLooseState)
//		{				
//			playMusic("179_full_rollercoaster-fun_0121.mp3", true);
//		}
//		else if(GameMainActivity.sGame.currentState instanceof SelectBalloonWinState)
//		{				
//			playMusic("179_full_rollercoaster-fun_0121.mp3", true);
//		}
//		
	}

	public static void onPause() {
		if (soundPool != null) {
			//soundPool.release();
			//soundPool = null;
			soundPool.autoPause();
		}

		if (mediaPlayer != null) {
			mediaPlayer.stop();
			mediaPlayer.release();
			mediaPlayer= null;
		}
		
//		if (mediaPlayer2 != null) {
//			mediaPlayer2.stop();
//			mediaPlayer2.release();
//			
//		}
//		
//		if (mediaPlayer3 != null) {
//			mediaPlayer3.stop();
//			mediaPlayer3.release();		
//		}
		
		
	}
	
	public static void stopPreviousMusic(){
		if (mediaPlayer != null) {
			mediaPlayer.stop();
			mediaPlayer.release();
			mediaPlayer = null;
		}
	}

	public static Bitmap getResizedBitmap(Bitmap bm) {

		int width = bm.getWidth();
		int height = bm.getHeight();
		Log.d("Assets", "Bitmap width,height :" + width + "," + height);

		Context context = GameMainActivity.sGame.getContext();
		WindowManager wm = (WindowManager) context
				.getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);

		int newWidth = size.x;
		int newHeight = size.y;
		Log.d("Assets", "Screen width,height :" + newWidth + "," + newHeight);

		newHeight -= 90;
		newWidth -= 90;

		float scaleWidth = ((float) newWidth) / width;

		float scaleHeight = ((float) newHeight) / height;

		// create a matrix for the manipulation

		Matrix matrix = new Matrix();

		// resize the bit map

		matrix.postScale(scaleWidth, scaleHeight);

		// recreate the new Bitmap

		Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height,
				matrix, false);

		return resizedBitmap;

	}

	public static void loadCarouzelMap() {
		
		
		int tempArrayVariable = 1;
        
		if( GameMainActivity.mIsPremium  || ( (GameMainActivity.instance != null) && GameMainActivity.instance.retrievePremiumStatus() ) )	
		{
			
			animals.clear();
			animals = new SparseArray<Animal>();
			

			// 2 DEER
			Animal baby_dear = new Animal();
			baby_dear.addAnimalName(R.string.baby_dear);
			baby_dear.addAnimalName(R.string.baby_dear_gr);
			baby_dear.setAnimalVisualFile("baby_dear");
			baby_dear.setAnimalVisualFileSoundLang("baby_dear");
			baby_dear.addAudioFile("deer");
			baby_dear.imageDetails[0] = "https://www.flickr.com/photos/51986662@N05/14285645404/";
			baby_dear.imageDetails[1] = "USFWS Mountain-Prairie/Tom Koerner";
			baby_dear.imageDetails[2] = "https://www.flickr.com/photos/usfwsmtnprairie/";
			baby_dear.imageDetails[3] = creativeLisenceBy;
			animals.put(tempArrayVariable++, baby_dear);

			// 3 GRIZZLY
			Animal bear_grizzly = new Animal();
			bear_grizzly.addAnimalName(R.string.bear_grizzly);
			bear_grizzly.addAnimalName(R.string.bear_grizzly_gr);
			bear_grizzly.setAnimalVisualFile("bear_grizzly");
			bear_grizzly.setAnimalVisualFileSoundLang("bear_grizzly");
			bear_grizzly.addAudioFile("bear");
			
			
			baby_dear.imageDetails[0] = "https://www.flickr.com/photos/50838842@N06/6754978699/";
			baby_dear.imageDetails[1] = "U.S. Fish and Wildlife Service Headquarters";
			baby_dear.imageDetails[2] = "https://www.flickr.com/photos/usfwshq/";
			baby_dear.imageDetails[3] = creativeLisenceBy;
			
		
			animals.put(tempArrayVariable++, bear_grizzly);

			// 4 POLAR BEAR
			Animal bear_pollar = new Animal();
			bear_pollar.addAnimalName(R.string.bear_pollar);
			bear_pollar.addAnimalName(R.string.bear_pollar_gr);
			bear_pollar.setAnimalVisualFile("bear_pollar");
			bear_pollar.setAnimalVisualFileSoundLang("bear_pollar");
			bear_pollar.addAudioFile("bear");
			bear_pollar.imageDetails[0] = "https://www.flickr.com/photos/50838842@N06/8473461967/";
			bear_pollar.imageDetails[1] = "Scott Schliebe/USFWS, 2000";
			bear_pollar.imageDetails[2] = "https://www.flickr.com/photos/usfwshq/";
			bear_pollar.imageDetails[3] = creativeLisenceBy;
					
			animals.put(tempArrayVariable++, bear_pollar);

			// 5 BAT
			Animal bird_bat = new Animal();
			bird_bat.addAnimalName(R.string.bird_bat);
			bird_bat.addAnimalName(R.string.bird_bat_gr);
			bird_bat.setAnimalVisualFile("bird_bat");
			bird_bat.setAnimalVisualFileSoundLang("bird_bat");
			bird_bat.addAudioFile("bat");
			
			bird_bat.imageDetails[0] = "https://www.flickr.com/photos/50838842@N06/7371567444/";
			bird_bat.imageDetails[1] = "U.S. Fish and Wildlife Service Headquarters";
			bird_bat.imageDetails[2] = "https://www.flickr.com/photos/usfwshq/";
			bird_bat.imageDetails[3] = creativeLisenceBy;
			
			animals.put(tempArrayVariable++, bird_bat);

			// 6 CANARY
			Animal bird_canary = new Animal();
			bird_canary.addAnimalName(R.string.bird_canary);
			bird_canary.addAnimalName(R.string.bird_canary_gr);
			bird_canary.setAnimalVisualFile("bird_canary");
			bird_canary.setAnimalVisualFileSoundLang("bird_canary");
			bird_canary.addAudioFile("canary");
			
			
			bird_canary.imageDetails[0] = "https://www.flickr.com/photos/chad_sparkes/14037792260/in/photolist-notmz3-4QFcV8-dWv9nG-bphjRG-9YWD7v-9aDMmN-9citeS-8iAUXo-8iB8Rb-8iQKxF-8iBEUo-8iB8uw-buguZo-9wdS4B-mKWdRj-8ixZBH-a6ZbQq-8ixZSH-uR7ihG-7EPYXh-9vkKjz-doPq7n-digajP-tTFYqe-9b4rfc-8wQ4SC-8iBewh-8U3uaM-uSY3Qf-uTFDEH-tWzFrx-uAYMmk-mbLCcB-8ixTtP-f5nerR-8iCXeD-9aopdA-dxMGo7-8ixYw8-qvrn25-8iAVsS-pcNbc-tWq8Tm-oNsshQ-9vNPJK-8ixZbv-cRcSE-qsUskJ-oAFdB5-qTB7uj";
			bird_canary.imageDetails[1] = "Chad Sparkes";
			bird_canary.imageDetails[2] = "https://www.flickr.com/photos/chad_sparkes/";
			bird_canary.imageDetails[3] = creativeLisenceBy;
			
			animals.put(tempArrayVariable++, bird_canary);

			// 7 NIGHTGALE
			Animal bird_nightingale = new Animal();
			bird_nightingale.addAnimalName(R.string.bird_nightingale);
			bird_nightingale.addAnimalName(R.string.bird_nightingale_gr);
			bird_nightingale.setAnimalVisualFile("bird_nightingale");
			bird_nightingale.setAnimalVisualFileSoundLang("bird_nightingale");
			bird_nightingale.addAudioFile("canary");
			
			bird_nightingale.imageDetails[0] = "https://www.flickr.com/photos/25553993@N02/5670166569/in/photolist-9D45Yz-ePVfxD-4sE8m-81zBb6-rJE5MX-rGMs6z-rJxa4N-auUaJ2-bGP73V-drSC3A-eGXKuA-4CvrU-LHoG3-7Y3rj8-4CvYx-8anJV-4rHuw-7wZ61C-bQMBXV-4pWJf-4CvYu-4CvYw-4orhV-dMhRns-ee7dDN-4pKVr-dAcfAR-4jkkX-5WhY9W-dYxkqu-5ZKFXK-7qU8zD-nAfR2M-efrk2t-86cRSm-64LMr7-qEZWTq-7Jjdrg-6iruYV-pWw6ku-oY993k-oKfHfB-9pF32Y-7Jo8eh-7JjdRg-7JjaDX-7Jj9YR-7Jo4P5-7JjeGi-7JjejP";
			bird_nightingale.imageDetails[1] = "Kev Chapman";
			bird_nightingale.imageDetails[2] = "https://www.flickr.com/photos/25553993@N02/";
			bird_nightingale.imageDetails[3] = creativeLisenceBy;
			
			animals.put(tempArrayVariable++, bird_nightingale);

			// 8 BISON
			Animal bison = new Animal();
			bison.addAnimalName(R.string.bison);
			bison.addAnimalName(R.string.bison_gr);
			bison.setAnimalVisualFile("bison");
			bison.setAnimalVisualFileSoundLang("bison");
			bison.addAudioFile("bison");
			bison.imageDetails[0] = "https://www.flickr.com/photos/royalty-free-images/139092409/in/photolist-dhTjZ-g94dHg-6B111D-8Gwr5G-atMgsn-kj623W-uHYYeR-9aeEgj-cnhtUA-okF7wM-sAhLWu-cuKE43-dczj3S-2srMP9-8GNihs-oGXLUu-nLiLiP-92dDWd-q5njn6-oo4Z54-cuKEfy-n4t1qo-5Q1V6f-oS1fww-4seqg2-oDWXwY-5dofV8-pAYoDN-7Rez9J-bcofNV-bBULga-3G6FmJ-2YAyYd-opoZdP-bryVZc-vFm3pJ-fGuwLJ-cuKqzY-6uRMY9-cuKqpq-8NnJCc-cA84xA-oX8cKu-i27UwW-dM3fqZ-91VcPx-MRp3A-i4byCr-fGS12N-p4vUgp";
			bison.imageDetails[1] = "Kabsik Park";
			bison.imageDetails[2] = "https://www.flickr.com/photos/royalty-free-images/";
			bison.imageDetails[3] = creativeLisenceBy;
			animals.put(tempArrayVariable++, bison);

			// 9 BLACK PANTHER
			Animal Black_panther = new Animal();
			Black_panther.addAnimalName(R.string.Black_panther);
			Black_panther.addAnimalName(R.string.Black_panther_gr);
			Black_panther.setAnimalVisualFile("Black_panther");
			Black_panther.setAnimalVisualFileSoundLang("Black_panther");
			Black_panther.addAudioFile("tiger");
			Black_panther.imageDetails[0] = "https://www.flickr.com/photos/tiger_feet/3925626289/in/photolist-6YTRVT-dTcnoL-7NYQHZ-71eJt7-biXgp4-qvGoZ1-7EB86W-7Lhs95-dTcn3L-7EB9eS-87xGux-87xGqX-87xGsP-odyneL-6pDttp-4eFXHw-8GEyBw-87AUxN-91a39L-9MbYJQ-81qpAw-CpmDp-n5hP2K-mwK4ke-4eFSXq-85fFmz-9MAL5t-nVj1ks-ikYteR-85iRww-85iRyd-85iRAS-85fDcX-85iRE3-87xGYg-85fDav-85iLZU-85fD8a-85fJQz-85fJNi-85iT1Q-85fJTa-85fE2c-85iMYC-85iPqj-85fDUc-85fDZi-8APQGb-sbi2tB-ebNcEu";
			Black_panther.imageDetails[1] = "Brian Mckay";
			Black_panther.imageDetails[2] = "https://www.flickr.com/photos/tiger_feet/";
			Black_panther.imageDetails[3] = creativeLisenceBy;
			animals.put(tempArrayVariable++, Black_panther);

			// 10 BULL
			Animal Bull = new Animal();
			Bull.addAnimalName(R.string.Bull);
			Bull.addAnimalName(R.string.Bull_gr);
			Bull.setAnimalVisualFile("Bull");
			Bull.setAnimalVisualFileSoundLang("Bull");
			Bull.addAudioFile("cow");
			//addImageDetails( Bull, Bull.imageDetails[0],  Bull.imageDetails[1], Bull.imageDetails[2],  Bull.imageDetails[3]);
			//addImageDetails(Animal animal,String source, String authorName,String authorUrl, String lisence)
			
			Bull.imageDetails[0] = "https://www.flickr.com/photos/25525110@N06/3893685640/in/photolist-6W5a63-3AvkwX-818PFe-4GB7Sf-daPhZ5-775a9f-nKQ6FP-4ESGnC-fzJp6M-kfkysA-3dqFK6-7Appv1-rpdCH2-7hAFvf-f3CPom-e7WoUb-tgWK8w-5crSAG-63nhPa-iLzHL-BRAWt-5HXcFN-9WuqDS-bDKRAk-dzcTaA-9nPfAK-7fRmTf-6N1bmP-aySTdM-fKzw1J-ns4yb5-naRvcL-6YMJE-dfDee-qmDQ9V-fU172v-9RFbuX-nDox5V-fZXr4E-c6P9uf-aVyDJv-pQnqD6-KLfPr-fcguZY-pfEFDk-bJ6Wd4-CKCUE-87KoAA-bqdMPr-iREnAx";
			Bull.imageDetails[1] = "Yves Jusot";
			Bull.imageDetails[2] = "https://www.flickr.com/photos/25525110@N06/";
			Bull.imageDetails[3] = creativeLisenceBy;
			
			animals.put(tempArrayVariable++, Bull);

			// 11 BATTERFLY
			Animal butterfly = new Animal();
			butterfly.addAnimalName(R.string.butterfly);
			butterfly.addAnimalName(R.string.butterfly_gr);
			butterfly.setAnimalVisualFile("butterfly");
			butterfly.setAnimalVisualFileSoundLang("butterfly");
			butterfly.addAudioFile("empty");
			
			addImageDetails(butterfly,
					"https://www.flickr.com/photos/127269296@N06/15490853103/in/photolist-pASEWc-i72pU-d6o5Nm-8urdN6-6RBUvk-po9WTS-ox9gA9-crmtoQ-eWK1ne-8yfPfJ-6hTayM-aMPJvr-wvNvVS-9QqRmi-51yysp-qvyTLM-82TsUx-H1aP1-5pg3KE-8pnr6-p55Yoa-r6x4b3-6STTbC-rRmRVp-bTkeVv-jjZKdT-oAGjyR-htcah-otDMFq-bke2p4-b5tW2-9ozAtV-vMiQbc-vzhw37-9ms2Hu-7Gkonx-8nmo7N-7PKyfU-9hZh5i-2CZU9S-8BoP2k-acU6L8-aLuU9n-wCPMi4-asQ6mi-dtKZF2-3cHnam-o9Cu2c-nQ3Lwq-fvZEGz",
					"Daniel Schiersner",
					"https://www.flickr.com/photos/127269296@N06/",
					creativeLisenceBy);
			
			animals.put(tempArrayVariable++, butterfly);

			// 12 CAMEL
			Animal camel = new Animal();
			camel.addAnimalName(R.string.camel);
			camel.addAnimalName(R.string.camel_gr);
			camel.setAnimalVisualFile("camel");
			camel.setAnimalVisualFileSoundLang("camel");
			camel.addAudioFile("camel");
			addImageDetails(camel,
                    "https://commons.wikimedia.org/wiki/File:Camelus_dromedarius_in_Singapore_Zoo.JPG",
					"Daderot",
					"https://commons.wikimedia.org/wiki/User:Daderot",
					"https://commons.wikimedia.org/wiki/File:Camelus_dromedarius_in_Singapore_Zoo.JPG");
			animals.put(tempArrayVariable++, camel);

			// 13 CAT
			Animal cat = new Animal();
			cat.addAnimalName(R.string.cat);
			cat.addAnimalName(R.string.cat_gr);
			cat.setAnimalVisualFile("cat");
			cat.setAnimalVisualFileSoundLang("cat");
			cat.addAudioFile("cat");
			addImageDetails(cat,
                    "https://commons.wikimedia.org/wiki/File:Spielendes_K%C3%A4tzchen.JPG",
					"Loliloli",
					"https://commons.wikimedia.org/w/index.php?title=User:Loliloli&action=edit&redlink=1",
					"https://commons.wikimedia.org/wiki/File:Spielendes_K%C3%A4tzchen.JPG");
			animals.put(tempArrayVariable++, cat);

			// 14 CAT FACE
//			Animal cat_face = new Animal();
//			cat_face.addAnimalName(R.string.cat_face);
//			cat_face.addAnimalName(R.string.cat_face_gr);
//			cat_face.setAnimalVisualFile("cat_face");
//			cat_face.setAnimalVisualFileSoundLang("cat");
//			cat_face.addAudioFile("cat");
//			animals.put(tempArrayVariable++, cat_face);

			// 15 CAT SIAM
//			Animal cat_siam = new Animal();
//			cat_siam.addAnimalName(R.string.cat_siam);
//			cat_siam.addAnimalName(R.string.cat_siam_gr);
//			cat_siam.setAnimalVisualFile("cat_siam");
//			cat_siam.setAnimalVisualFileSoundLang("cat");
//			cat_siam.addAudioFile("cat");
//			animals.put(tempArrayVariable++, cat_siam);

			// 16 CHIKEN
			Animal chicken = new Animal();
			chicken.addAnimalName(R.string.chicken);
			chicken.addAnimalName(R.string.chicken_gr);
			chicken.setAnimalVisualFile("chicken");
			chicken.setAnimalVisualFileSoundLang("chicken");
			chicken.addAudioFile("chiken");
			addImageDetails(chicken,
                    "https://www.flickr.com/photos/26279436@N02/7010916717/in/album-72157629292124488/",
					"Matt Davis",
					"https://www.flickr.com/photos/26279436@N02/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, chicken);

			// 17 CHICKS
//			Animal chicks = new Animal();
//			chicks.addAnimalName(R.string.chicks);
//			chicks.addAnimalName(R.string.chicks_gr);
//			chicks.setAnimalVisualFile("chicks");
//			chicks.setAnimalVisualFileSoundLang("chicks");
//			chicks.addAudioFile("chiken");
//			animals.put(tempArrayVariable++, chicks);

			// 18 CHIPMANK
			Animal chipmank = new Animal();
			chipmank.addAnimalName(R.string.chipmank);
			chipmank.addAnimalName(R.string.chipmank_gr);
			chipmank.setAnimalVisualFile("chipmank");
			chipmank.setAnimalVisualFileSoundLang("chipmank");
			chipmank.addAudioFile("Chipmunk");
			addImageDetails(chipmank,
                    "https://www.flickr.com/photos/49208525@N08/15842654206/",
					"Edward VanderWall/USFWSmidwest",
					"https://www.flickr.com/photos/usfwsmidwest/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, chipmank);

			// 19 COW
			Animal Cow_female_black_white = new Animal();
			Cow_female_black_white.addAnimalName(R.string.Cow_female_black_white);
			Cow_female_black_white
					.addAnimalName(R.string.Cow_female_black_white_gr);
			Cow_female_black_white.setAnimalVisualFile("Cow_female_black_white");
			Cow_female_black_white
					.setAnimalVisualFileSoundLang("Cow_female_black_white");
			Cow_female_black_white.addAudioFile("cow");
			addImageDetails(Cow_female_black_white,
                    "https://commons.wikimedia.org/wiki/File:Vache_Aubrac.jpg",
					"Jean-Luc Bailleul",
					"http://www.jlbailleul.fr/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, Cow_female_black_white);

			// 20 CRAB
			Animal crab = new Animal();
			crab.addAnimalName(R.string.crab);
			crab.addAnimalName(R.string.crab_gr);
			crab.setAnimalVisualFile("crab");
			crab.setAnimalVisualFileSoundLang("crab");
			crab.addAudioFile("fish");
			addImageDetails(crab,
                    "https://www.flickr.com/photos/geishaboy500/4387147748/in/photolist-7FFhbq-88qJ4e-a22wqR-mk2Gk-opV861-5dp3rN-8MYkSE-8dNKcj-6jHsQL-9igiDf-c7m6r-mZxFd-4yFJj-r94bkA-eey1cs-cgbFbh-vWdXYh-wxZGz-qi1wzD-oSKSRi-9iKC4t-YSuUB-q6GV4D-dPJ1iG-5X8f6v-rTbVG1-pj5sYW-dCfQqf-29JtPo-wmfSS-fUc1gN-edRgUF-a7ap2b-nDEoEk-gAeNuN-79zGew-oDgjX-bQTnrM-79xaTM-mKVXHz-eW49dZ-79vZka-9mrWGY-dZGTJV-oMBc9t-",
					"THOR",
					"https://www.flickr.com/photos/geishaboy500/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, crab);

			// 21 CROCODILE
			Animal crocodile = new Animal();
			crocodile.addAnimalName(R.string.crocodile);
			crocodile.addAnimalName(R.string.crocodile_gr);
			crocodile.setAnimalVisualFile("crocodile");
			crocodile.setAnimalVisualFileSoundLang("crocodile");
			crocodile.addAudioFile("crocodile");
			addImageDetails(crocodile,
                    "https://www.flickr.com/photos/129978259@N03/16019268408/in/photolist-qpyWoU-4SSURN-4SuwZd-7kv6Hk-9fmT6k-unj2cg-9fq4PJ-9fpV7U-9fmQUM-6F3U5U-9fmUG4-9fmNSP-9fpYTN-9fmSgn-9fpX89-9fmRU4-9fmWMt-9fmU2t-9fpULA-JRhpm-7kUXdC-34q5Jn897Zh7-abhnZ7-5oJqUE-onUnRj-dTNemF-ijtAk9-9fVkLJ-7PcScH-5pKnMW-fBzafi-6ds9u-6ds9r-aiBNei-doe3qE-v2Zdji-rXEY1P-9P6fV6-4HirVk-wXM7Dg-G7PWM-9cb9mY-9cbpiE-9cbn33-9cbnBQ-9c85HP-9c88bB-9cbpPU-9cbp6S",
					"Matthias Hiltner",
					"https://www.flickr.com/photos/129978259@N03/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, crocodile);

			// 22 CROW
			Animal crow = new Animal();
			crow.addAnimalName(R.string.crow);
			crow.addAnimalName(R.string.crow_gr);
			crow.setAnimalVisualFile("crow");
			crow.setAnimalVisualFileSoundLang("crow");
			crow.addAudioFile("crow");
			addImageDetails(crow,
                    "https://www.flickr.com/photos/grand_canyon_nps/5735021613/in/photolist-9JMu7Z-66QFg1-9NfHac-6FLoH1-45sJXW-ofwtWC-3jGb4o-c9BH2-7frkL3-7frkPo-6Uz1r2-tZVoRH-bNe68c-cohGAC-vbPZQp-qCdjPk-7frm9f-agvXiR-bWvhYz-7uAgmQ-4M8wQD-eWxien-cb7uR7-bpQc1a-3bA3Ls-sVsLb9-cccxBy-pFmb4Y-4o2CKi-7ikKJ6-9bJ33y-p6eNKk-6P6jPd-cccxy3-pBvU4X-r8KDLj-56a7-76HubU-Ngu86-nonoAS-n1ioDZ-7adNfg-eY6G5D-56mVWn-66aEtD-o13Sq6-dywztg-nE2dhc-85ULpM-o1nHY7",
					"Grand Canyon National Park / Michael Quinn",
					"https://www.flickr.com/photos/grand_canyon_nps/title=User:ZankaM&action=edit&redlink=1",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, crow);

			// 23 DOG GERMAN SHEPARD
			Animal dog_german_shepard = new Animal();
			dog_german_shepard.addAnimalName(R.string.dog_german_shepard);
			dog_german_shepard.addAnimalName(R.string.dog_german_shepard_gr);
			dog_german_shepard.setAnimalVisualFile("dog_german_shepard");
			dog_german_shepard.setAnimalVisualFileSoundLang("dog");
			dog_german_shepard.addAudioFile("dog");
			addImageDetails(dog_german_shepard,
                    "https://www.flickr.com/photos/col_and_tasha/5588330810/in/photolist-9vPE4d-d5FnT-7qWknW-nuXzAK-ejcLCz-CuUQk-9CD4Zb-7QKdoL-9LMbx6-9jcygx-8DSVrz-c5xqxN-6xYezg-cjYB1w-4au2Wa-bpSgNQ-6xYefR-5rdLTj-6z8APx-6yiDHy-7Qre5a-ey7p8Z-bt7Wfb-bG2MoX-bt7XtE-bG2NDz-bt7Wnh-bG2Ny4-dTFFRF-9nJjfK-CvHcj-9Marzk-541xKy-7c628J-9dF9tc-95Tj6f-3eh6P-96Reaj-53WqeM-8aCuA5-541zZy-dEeoEu-6nuv9F-9dF9Bc-5rXBbL-9Wnc63-4rKiXZ-8vTFYG-7WixyD-7HMLAi",
					"Col Ford and Natasha de Vere",
					"https://www.flickr.com/photos/col_and_tasha/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, dog_german_shepard);

			// 24 DOG LASSIE (Rough_Collie)
			Animal dog_lassie = new Animal();
			dog_lassie.addAnimalName(R.string.dog_lassie);
			dog_lassie.addAnimalName(R.string.dog_lassie_gr); 
			dog_lassie.setAnimalVisualFile("dog_lassie");
			dog_lassie.setAnimalVisualFileSoundLang("dog");
			dog_lassie.addAudioFile("dog");
			addImageDetails(dog_lassie,
                    "https://www.flickr.com/photos/jonas_lowgren/7180097417/in/photolist-bWtSP4-9MGGvk-9MKEtf-9MGTMk-9MGFT2-9MKvnq-9MGLqz-9MKJUy-9MGSA4-9MKJn9-9MGv8B-9MKjYh-9MGJBz-9MKFyo-9MKAiJ-9MGBU6-9MGD4H-9MGKRz-9MGQGV-9MKKPd-9MGZga-9MKmBy-9MKBph-9MGzZB-9MKDcE-9MGNwZ-9MGunZ-9MGHcv-9MGtKZ-9MKGMU-9MKoHU-9MKHNs-9MGPyc-9MKs3w-9MKzej-9MKqXN-9MGLNK-9MGUQD-9MGAQv-9MGYca-anTgjv-anW3y9-anVYny-a6T1uz-a6SYqV-8a1tvs-anTdxH-a6VNY9-a6SR84-a6SW4Z",
					"Jonas Löwgren",
					"https://www.flickr.com/photos/jonas_lowgren/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, dog_lassie);

			// 25 DOG TERRIER
			Animal dog_terrier = new Animal();
			dog_terrier.addAnimalName(R.string.dog_terrier);
			dog_terrier.addAnimalName(R.string.dog_terrier_gr);
			dog_terrier.setAnimalVisualFile("dog_terrier");
			dog_terrier.setAnimalVisualFileSoundLang("dog");
			dog_terrier.addAudioFile("dog");
			addImageDetails(dog_terrier,
                    "https://www.flickr.com/photos/annapanakova/15408006900/in/photolist-pty4Do-7BGGP-dHHsWL-pL2Lob-3pu45C-eERnP-7KMa1T-5PBQ9k-7MFnqH-eXt488-eg7a3b-65EZA9-6tCWQc-6rcr7C-drEG3-8cMyMk-5nXfNb-68mS5h-6uFWFk-4wfp32-5YgsNq-aazZft-7KPNxN-rYwpy6-5espk6-csvVi7-9nu8e2-d9QVDN-741Hvn-rLY3Ua-6YvgHD-aXqoHp-a4xvPZ-Asinj-5UUpjY-CEELJ-6wpWji-6WE2xG-6hdSo5-HF5BZ-TmHB6-7Nsfs9-dheXnW-HogXQ-pinu2-6ZtYEA-896utK-daYe4T-4oJbey-6oxN4X",
					"Anna Panáková",
					"https://www.flickr.com/photos/annapanakova/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, dog_terrier);

			// 26 DOLPHIN
			Animal dolphin = new Animal();
			dolphin.addAnimalName(R.string.dolphin);
			dolphin.addAnimalName(R.string.dolphin_gr);
			dolphin.setAnimalVisualFile("dolphin");
			dolphin.setAnimalVisualFileSoundLang("dolphin");
			dolphin.addAudioFile("dolphin");
			addImageDetails(dolphin,
                    "https://www.flickr.com/photos/barachi/7961266942/in/photolist-d8vzi9-d7XESu-d4bSJu-d3AMy9-d3AMbd-4cv1Fe-mmyMn3-5Trw2v-9xvji2-cToaZo-cSMDGm-cSMzpd-bTXzec-aoaC1k-amM7W6-amiWP1-amg6Pa-amiRqE-akYELE-akYCxL-aeDNFF-ae9SjF-aecEFw-ae9PUT-aecCF7-aecCj1-ae9KC6-ae9JKg-ae9HQt-adzNaa-ac7kD3-dmQ5UF-aaraC3-4WNfRV-9CoHp3-75i6iN-69SfNt-69WrCb-69SfEp-67RDPK-jBJmMh-gFEkf6-bBjzhi-9Zcbhf-cnbYLQ-8n5re4-46MQum-oqF4mv-nx38tX-jeeonv",
					"barachihuang",
					"https://www.flickr.com/photos/barachi/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, dolphin);

			// 27 DOVE
			Animal dove = new Animal();
			dove.addAnimalName(R.string.dove);
			dove.addAnimalName(R.string.dove_gr);
			dove.setAnimalVisualFile("dove");
			dove.setAnimalVisualFileSoundLang("dove");
			dove.addAudioFile("dove");
			addImageDetails(dove,
                    "https://www.flickr.com/photos/bobolink/14451804224/in/photolist-o24gUm-dq1AKq-bmfUnM-iERZ2t-iEW2H3-iEW1qJ-iERVTV-iESZdB-iERU1r-iETAVQ-iESRq2-iESQix-iETsXf-iESMAZ-iEREn4-iETn2h-iESGsH-8vxknt-9LiXCC-4u2cQL-9aooEh-5kEK5V-9MDcWC-9Mreok-95kc6c-512hu4-rkhcqd-rZG5NU-rktMhi-9MuQxQ-eMQWc7-eX2t5p-eYdBz1-3R1XwU-gqe4oj-9MuQQC-nwG9E-a4oVuZ-a4oc58-9SDN7q-9MfVNm-cDUCVE-nZS8tE-9MGGjj-9Mr2Zt-f7BGkA-b4QuCe-a2eyQX-7qAtLg-4PyRBc",
					"Robert Taylor",
					"https://www.flickr.com/photos/bobolink/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, dove);

			// 28 DRAGONFLY
			Animal dragonfly = new Animal();
			dragonfly.addAnimalName(R.string.dragonfly);
			dragonfly.addAnimalName(R.string.dragonfly_gr);
			dragonfly.setAnimalVisualFile("dragonfly");
			dragonfly.setAnimalVisualFileSoundLang("dragonfly");
			dragonfly.addAudioFile("mosquito");
			addImageDetails(dragonfly,
                    "https://www.flickr.com/photos/rexy85/6968980658/in/photolist-8uxsCM-eRUNY5-e9h7xJ-dMzepE-cBTixL-52E8mi-pfuWwn-3bj1pM-f4REgp-ovwCxZ-5hy6x7-abWf7V-c65S29-kDuuWv-abwBge-5fmVaG-Nssnq-9KSs82-5onBuL-SWxhE-kDu9wn-86dYw9-e8vn6f-bUperx-9V5xyN-9poxA5-ouX1nf-5mhD3D-ei4sTL-fC3dyd-6TWtdq-84iU48-a83m1p-6wSnfw-8oY4Tb-bBPR9W-2uA5jR-6UEw3t-iQCrh-51bhn5-JE61x-dMzep5-7jyKZb-oYBC8-fz95iC-5xYQaY-aG14wV-9V5E4z-ovNqmB-8r4ebS",
					"Daniel lightscaper",
					"https://www.flickr.com/photos/rexy85/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, dragonfly);

			// 29 DUCK
			Animal duck = new Animal();
			duck.addAnimalName(R.string.duck);
			duck.addAnimalName(R.string.duck_gr);
			duck.setAnimalVisualFile("duck");
			duck.setAnimalVisualFileSoundLang("duck");
			duck.addAudioFile("duck");
			addImageDetails(duck,
                    "https://www.flickr.com/photos/ben124/7449127466/in/photolist-cmfJ5b-n2mD63-rz32DJ-saAtok-uyVwU3-nDZsxn-dMuQrM-pZNzdm-dSKrNw-r9iCU1-qctQcR-4yN2Qs-qNC7F3-gwtDNK-pPJZqQ-4xGykM-nu1hA7-qRgPaR-g44G1c-pw7F4x-gNq6kQ-fmGXer-rDJzQn-6paARq-7AhWuk-daBXHt-jVJ9uK-mmG7oK-gNqbZC-dAa7n2-rq9oN5-hiHrhB-nf1eDD-7LGaD2-4mr9n3-iddEb3-dJtftL-oZfA5z-HWRDn-cmRK8u-5h2kE6-4qdnyk-3wCV3g-kmSK8e-95GMWt-ciNpjA-rvEixy-rACiBy-5WtgnK-ebk8iJ",
					"Berit Watkin",
					"https://www.flickr.com/photos/ben124/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, duck);

			// 30 EAGLE
			Animal eagle_bold = new Animal();
			eagle_bold.addAnimalName(R.string.eagle_bold);
			eagle_bold.addAnimalName(R.string.eagle_bold_gr);
			eagle_bold.setAnimalVisualFile("eagle_bold");
			eagle_bold.setAnimalVisualFileSoundLang("eagle_bold");
			eagle_bold.addAudioFile("eagle");
			addImageDetails(eagle_bold,
                    "https://www.flickr.com/photos/usfwsmidwest/12973024833/in/photolist-kLo9iX-daQWoq-eetGE3-bBQpH9-kk8oBi-dFYrsw-8nzLh2-gG9mkD-cTHQ9o-pSBw6p-r3Vksr-4YtL3n-9Dawco-9D7BhK-6YxHKa-6ax588-bBkYmR-pXiHpA-str2Np-dtQKS9-dnHnBy-gi2H3x-mGw6cg-bW8jKY-a7V2gq-4Jr2qa-6UKpm4-4NW3zv-b4fuyF-mjyYur-d1NiUY-5jhEcF-8cRvq1-e32jh1-qnRD2m-bwofnK-6hri8Y-8yyNPw-b2HSKk-oSo2ce-ouwQ8n-o1oLeD-4SrwJz-jBMruY-qEKbfP-8eQLqN-e4qLgx-6KYL4M-4Asqxn-6p9eys",
					"USFWSmidwest/Stan Bousson",
					"https://www.flickr.com/photos/usfwsmidwest/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, eagle_bold);

			// 31 ELEPHANT
			Animal elephant = new Animal();
			elephant.addAnimalName(R.string.elephant);
			elephant.addAnimalName(R.string.elephant_gr);
			elephant.setAnimalVisualFile("elephant");
			elephant.setAnimalVisualFileSoundLang("elephant");
			elephant.addAudioFile("elephant");
			addImageDetails(elephant,
                    "https://www.flickr.com/photos/lizard_queen/114587853/in/photolist-b8hYD-iS8Yj9-67NFxz-6K4uxy-bHY2Mi-8jc4Sz-6p1EKF-gE67k-8ur4Pb-4ExKyW-4S5AE2-i356uz-8wYbVd-8HywJy-68sGY6-rqiK9E-4aXPm3-5J3mkJ-PtvL-dVpBtJ-jDurXL-rgnjqr-8mzUx6-xQ9S6-c2gQgL-qSLXPB-cqUinf-xQ9VX-sMrw3-i3pzXG-vvwGaw-68qn8v-tfUquq-662rdZ-btd1kd-zSreN-c2gRZs-dJbZx-rpksY4-9qAAK4-5qSJVq-7DUJoG-c2gXrC-2HqW3d-4wdmtd-7ktcyG-8BGWku-rwZq3x-pdMSEc-75uqvp",
					"Caitlin",
					"https://www.flickr.com/photos/lizard_queen/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, elephant);

			// 32 ELK
			Animal elk = new Animal();
			elk.addAnimalName(R.string.elk);
			elk.addAnimalName(R.string.elk_gr);
			elk.setAnimalVisualFile("elk");
			elk.setAnimalVisualFileSoundLang("elk");
			elk.addAudioFile("elk");
			addImageDetails(elk
					,"https://www.flickr.com/photos/larry1732/5499633043/in/photolist-9nZ4in-5sV9EM-v5ZCYm-v6Mymn-7325gy-amthBb-7HjcGL-4Q4may-dUG8SW-5dfK3z-5YkRXK-doGjWt-a35QQB-u9DuQT-pXCQNM-8ZsAS9-8ZsAis-8ZpvUv-oGN6qQ-9NzdNM-cP4nTU-9dhYCr-2aA3DT-hxvEKM-oacQ7h-5qGcfL-6GdpJC-2aEu5h-bCScJ6-hxRjco-dCFGnm-37R4ru-dV5HTy-9nXTQt-jshRGY-7tnoUD-5sZxTq-8ZszW7-8ZpvKv-8Zpvjn-qCm88q-foavxo-cEC5o9-2Ej9W7-f8ZJLQ-7bozi7-dfEVvW-5idkLt-rCSFv6-8ZszBJ"
					,"Larry Lamsa"
					,"https://www.flickr.com/photos/larry1732/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, elk);

			// 33 CLOWN FISH
			Animal fish_clown = new Animal();
			fish_clown.addAnimalName(R.string.fish_clown);
			fish_clown.addAnimalName(R.string.fish_clown_gr);
			fish_clown.setAnimalVisualFile("fish_clown");
			fish_clown.setAnimalVisualFileSoundLang("fish_clown");
			fish_clown.addAudioFile("fish");
			addImageDetails(fish_clown
					,"https://www.flickr.com/photos/diverslog/190074931/in/photolist-KCXo4-d8f1N-5368G2-9SpBrm-qrdgTq-qJfcfZ-nZpeo-5368Kz-hNbDZ-eED21W-7pTdJS-egKMHY-4bYwj7-4AL3Uq-rMh8Q-rMh8C-rMh8j-9ZrDEB-55FYSk-5n8Tf9-5TmeFY-5TmfMG-77fpDN-5rLhso-4tTvh3-4ifePv-bBKALx-6Qmg43-qrLupx-dzb6es-7pTuJo-wgrmi-bBKC1p-5n4B4K-6pq2x3-ko9NaP-8yfyEL-8ycw6Z-ayRkFv-e6mHAB-4RNv5Z-xEx89-9624nL-ag4NjS-8e618m-ag23WF-xEveE-xEvet-xEx83-5gMB66"					
					,"Jenny"
					,"https://www.flickr.com/photos/diverslog/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, fish_clown);

			// 34 GOLD FISH
			Animal fish_goldfish = new Animal();
			fish_goldfish.addAnimalName(R.string.fish_goldfish);
			fish_goldfish.addAnimalName(R.string.fish_goldfish_gr);
			fish_goldfish.setAnimalVisualFile("fish_goldfish");
			fish_goldfish.setAnimalVisualFileSoundLang("fish_goldfish");
			fish_goldfish.addAudioFile("fish");
			addImageDetails(fish_goldfish
					,"https://www.flickr.com/photos/27330306@N08/3758613590/in/photolist-6J9fXU-6J8SSA-6J9b6A-6J9VwU-7iaGof-7p7GJw-6J9Nfm-db6rbC-7XMkpt-3gGRn9-6J5MWc-6J9uTq-6J58ca-6J8YB3-6J9tyC-6J9mJ1-3cAhvB-cm9Ku5-f6c3Xm-r3Ep5u-p5L3FA-fTuZv8-5mjDPg-hVRT7G-p5qxen-h8V2WV-hVSfuD-n22sCP-mhi2yK-shysC7-k6bCaD-vfPap3-oo65kZ-kLCQNZ-5jttpy-6mx6AU-4YvtP3-biCA5H-aN7Mkx-db9u4V-7NSDrD-7Na5jf-6GHihu-cCsU4h-aN7BdZ-czSS7Q-78JXhu-cCt6D5-cCsZgN-7NSDzF/"
					,"Kamillo Kluth"
					,"https://www.flickr.com/photos/27330306@N08/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, fish_goldfish);

			// 35 SCORPION FISH
			Animal fish_scorpion = new Animal();
			fish_scorpion.addAnimalName(R.string.fish_scorpion);
			fish_scorpion.addAnimalName(R.string.fish_scorpion_gr);
			fish_scorpion.setAnimalVisualFile("fish_scorpion");
			fish_scorpion.setAnimalVisualFileSoundLang("fish_scorpion");
			fish_scorpion.addAudioFile("fish");
			addImageDetails(fish_scorpion
					,"https://www.flickr.com/photos/nostri-imago/3148921655/in/photolist-5Ng3GF-9b5vCY-2qiNv7-69vL6q-e7Z7sS-68CVHT-4rkcjx-6XKaxo-e1pxUC-aQDPPi-mFdJ8y-Qkdb-qbGQWx-4EfqWt-4EjGyq-hdBAN1-6ZYZwc-5nhws9-dAmDeT-a4Uk1Q-nKWhRm-J5vf-6L4EHA-77bu8P-BQQv4-6oiwwi-fquoo-dxMs22-e76zYG-a6Zff3-up9NR-9b5vYo-7At7SZ-6KZcmF-7AAykA-o4EaG8-cjkM7Q-cjkLXb-cjkKUq-kJTBmF-4wokud-4wjc6i-dT7w3J-bM7WKV-ahmDMC-ahiTvX-gjDxi3-65XdS4-6L4E8L-5Tkor3"
					,"Cliff"
					,"hhttps://www.flickr.com/photos/nostri-imago/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, fish_scorpion);

			// 36 FOX
			Animal fox = new Animal();
			fox.addAnimalName(R.string.fox);
			fox.addAnimalName(R.string.fox_gr);
			fox.setAnimalVisualFile("fox");
			fox.setAnimalVisualFileSoundLang("fox");
			fox.addAudioFile("fox");
			addImageDetails(fox
					,"https://www.flickr.com/photos/quintanomedia/16138030480/in/photolist-qA4CdQ-qQk1Dy-KseGg-957hXt-sJivD-4BfELP-qSC1MH-6E7vnx-4GNVDy-bw6v2T-98vm55-9jEa4f-7BsrrS-9jE6nY-edTtGe-qA3FoN-bSdGec-9CkJgZ-9dLJFs-6L4s4p-5fseqN-dXtv9P-9PrYA2-qSxzxj-jjJTB-vmX46H-bUu5rZ-s8foNB-eMM3L6-ceWFr7-71bGQk-qAcjpK-btHDt8-btHLRt-dXtvt6-btqBh3-7ZfA9B-agRbcc-NZKuz-961tJu-a2fZUi-o2EucE-7YAjmb-979Pxr-2EHsb7-c2Ctm1-q97kQm-qAaCDB-qAcidM-rk9MER"
					,"Anthony Quintano"
					,"https://www.flickr.com/photos/quintanomedia/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, fox);

			// 37 FROG
			Animal frog = new Animal();
			frog.addAnimalName(R.string.frog);
			frog.addAnimalName(R.string.frog_gr);
			frog.setAnimalVisualFile("frog");
			frog.setAnimalVisualFileSoundLang("frog");
			frog.addAudioFile("frog");
			addImageDetails(frog
					,"https://www.flickr.com/photos/chrisandholley/9379017341/in/photolist-fhMV6x-kUzPyG-ejvD64-mKKug-o1jwWx-iWUJ7-jWYtnR-8S2Rvt-vRkhy7-9JLHuJ-4bYsRG-8HZTos-5nn6jw-nTiJK-nYVbTb-okGkAS-bBuny1-32GpGh-gEgepa-4WYuDX-7TxdyB-csGzQ3-duVxH2-d4RkM-rNQjiT-nPHMsd-icpfWZ-dMDzKB-rghsqB-dSvA8C-rTvo5C-bWPUW-o1FLPz-3f7Z8r-aLPwS-cVaY3N-3xmNVL-dJ5sc7-uDWEaA-c3iwUf-2Liyj9-jWZ6Yz-546UwR-ec7EsX-ojQSyY-cCTZK-9jfA1V-ePSFk-eRyJrT-ecuWYm"
					,"Holley And Chris Melton"
					,"https://www.flickr.com/photos/chrisandholley/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, frog);

			// 38 GIRAFFE
			Animal giraffe = new Animal();
			giraffe.addAnimalName(R.string.giraffe);
			giraffe.addAnimalName(R.string.giraffe_gr);
			giraffe.setAnimalVisualFile("giraffe");
			giraffe.setAnimalVisualFileSoundLang("giraffe");
			giraffe.addAudioFile("giraffe");
			addImageDetails(giraffe
					,"https://www.flickr.com/photos/jamiedfw/2399382313/in/photolist-4E2sLz-4Ey3mL-5ecEXJ-k82bug-qKC1TM-6TMErV-7gDfj5-cjqBVd-85wZLP-avmQxs-7PsZ1h-4eyZXV-55RKzc-yG8ek-6aff66-8EbQ9K-8EbQCK-2PH9zn-8EbPjx-7BjbWk-55VWjd-diwAdV-63pAmV-4AvNgD-brMjob-tubUKa-4HwwAV-fpQw6Z-4ExGtS-4ExHib-4JaUu3-hAmC8y-c9hM69-pWYSyW-cjqCSm-JX6rL-h1UPXX-4QXawv-5ZKZTS-sbmnGv-5c5nZD-nhQZjC-dMkqdD-91GJG5-eUR1Vu-6KGXiw-a59XWH-2PM9sA-qekWQp-3X395t"	
					,"Holley And Chris Melton"
					,"https://www.flickr.com/photos/chrisandholley/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, giraffe);

			// 39 GOAT
			Animal goat = new Animal();
			goat.addAnimalName(R.string.goat);
			goat.addAnimalName(R.string.goat_gr);
			goat.setAnimalVisualFile("goat");
			goat.setAnimalVisualFileSoundLang("goat");
			goat.addAudioFile("goat");
			addImageDetails(goat
					,"https://www.flickr.com/photos/39968191@N06/4798547137/in/photolist-8j2NTk-pjbf6D-o49EEf-fveaxs-fve74o-fuXh7z-fvbqRN-fuVRKV-ePg9gk-dDnSfn-6S9Z83-e9cBum-pfkFbP-geutaF-p6s7pX-pGi84F-cwKsJb-9hCvtX-heh9qW-dWmK32-gD5wkx-vCYqeo-e4cpLJ-k66dFy-dSZKXZ-rsFA2z-9AMWgL-raeZ7b-nq5Fnm-fvbVXG-fvbFXG-fvb6V9-ePuLff-ePuGTC-ePgoR6-ePgaMt-eAsHWG-ax3dQj-9fx9Tk-5sBkd9-3G6Gwj-8yHC2N-81Njey-imCRn3-8q9UTP-8aoXoy-6BPubL-upaTHL-oGAACD-8Prezq"
					,"Zufall2010"
					,"https://www.flickr.com/photos/39968191@N06/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, goat);

			// 40 GRASSHOPER
			Animal grasshoper = new Animal();
			grasshoper.addAnimalName(R.string.grasshoper);
			grasshoper.addAnimalName(R.string.grasshoper_gr);
			grasshoper.setAnimalVisualFile("grasshoper");
			grasshoper.setAnimalVisualFileSoundLang("grasshoper");
			grasshoper.addAudioFile("grasshopper");
			addImageDetails(grasshoper
					,"https://www.flickr.com/photos/endogamia/3434038840/in/photolist-6esm7d-s9PEGR-6x3xaa-FBGe9-29BijN-4CGr3w-g3CqYr-mMkaN-3aPdHR-oeFEhi-6x7Dnf-7GHQjK-8fPnsb-9f18hz-9VDWbe-6x2UTT-97BgRF-jfwxu9-75be87-oPx3X-3xicFd-BpU8B-fG7Kwn-BpU6r-8tLt8k-so6bK3-q6rcka-6x7EzQ-axgrPY-axgrBY-4fyWuL-dYB4bz-zuMih-7ttxi9-9UMAfi-8CVdhx-9XpoMQ-vyCB79-rShpZu-p4ammD-r8GruB-8mGDTK-6waQhA-piBoPY-9ak5Mm-dpKkfQ-eZxPVW-rd5htV-8VZCrw-aiTDQM"
					,"Feans"
					,"https://www.flickr.com/photos/endogamia/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, grasshoper);

			// 41 GUINEA PIG
			Animal guinea_pig = new Animal();
			guinea_pig.addAnimalName(R.string.guinea_pig);
			guinea_pig.addAnimalName(R.string.guinea_pig_gr);
			guinea_pig.setAnimalVisualFile("guinea_pig");
			guinea_pig.setAnimalVisualFileSoundLang("guinea_pig");
			guinea_pig.addAudioFile("mouse");
			addImageDetails(guinea_pig
					,"https://www.flickr.com/photos/tonyaustin/4008952880/in/photolist-77fW2f-5CBa2j-5CBauS-5CBaHS-5CwSxF-NqQfm-8ewt6c-2FQEE1-6aBmd4-4HLPgh-E4Xm-6gwTvS-cntS19-59nfS4-bBju5J-4pkUGP-2TbLws-2T7itV-77bZTP-3pG844-Kpq7o-6hQuBq-k8cs-DxHJw-9udP33-2LrQE-hbSos-5rDtNZ-aZRu6B-2TbJfj-2T7ksV-2TbHM7-2TbLPE-2T7hy8-2TbHiL-2T7hCx-2TbMyj-2T7hiB-2TbM8S-hbSmM-hbSnr-hbSkP-A83Ga-4FBatA-88fuo2-59rh5u-shEYa-7g2DP8-3227AJ-7dbCnW"
					,"Tony Austin"
					,"https://www.flickr.com/photos/tonyaustin/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, guinea_pig);

			// 42 HEDGEHOG
			Animal hedgehog = new Animal();
			hedgehog.addAnimalName(R.string.hedgehog);
			hedgehog.addAnimalName(R.string.hedgehog_gr);
			hedgehog.setAnimalVisualFile("hedgehog");
			hedgehog.setAnimalVisualFileSoundLang("hedgehog");
			hedgehog.addAudioFile("hedgehog");
			addImageDetails(hedgehog
					,"https://www.flickr.com/photos/karen_roe/3811710595/in/photolist-6NQ1Lc-eicKG-b5u2i-bSHiBv-9KbDzb-6KCEiD-9AR5mT-scwSrA-scy4kQ-6vzvm3-mt3VA-6iwt6U-KMCxd-oCaHqE-9o4Py3-9o1LJT-6NQ2RH-6NUdbL-6NUcm9-6NUchs-c33cej-g1qGJv-6NQ2pP-bBjcum-eic643-ab83Dg-oSHq9G-ej7uni-9zcwqe-d5SMFu-8us29r-awh6xm-aweoyc-5YbRdF-9rTHvh-ueigdw-cXcQKj-stazwY-5g3HKT-8DoMip-efrN3Z-bPpAKt-bAuXhW-8pZidt-ne7fuL-dvdFPk-6XQEDZ-3YtT4-a7NMHC-4adbLu/"
					,"Karen Roe"
					,"https://www.flickr.com/photos/karen_roe/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, hedgehog);

			// 43 HORSE
			Animal horse = new Animal();
			horse.addAnimalName(R.string.horse);
			horse.addAnimalName(R.string.horse_gr);
			horse.setAnimalVisualFile("horse");
			horse.setAnimalVisualFileSoundLang("horse");
			horse.addAudioFile("horse");
			addImageDetails(horse
					,"https://www.flickr.com/photos/bigmikeyeah/4855414254/in/photolist-8p4guS-a4Z8y7-fdQ4c6-obeXyZ-oqWSvz-iQZsSA-oXuhGf-em96yE-8WqWHk-5tjUna-6iFheU-a4Wgti-eESohH-7fh7Vj-bKefmt-Jb5hm-rYPcAG-fgaeVN-a8Ken2-adBamH-9Lu7HZ-4v95Ke-a4Wgjp-tKFtqp-f5RqZ7-4uPM2H-8u6W3E-5oJaGq-9epjtp-dykcFR-paeMQN-2eX5Jq-9X1HTB-q3iFgT-hg4r3A-78ubRJ-QtinJ-8292JW-55kacC-rKmsr9-7q3dez-ownMyr-sbrA3M-q84s8d-dLA3oT-npWBKu-awwP5-3sBrkX-wyWTh-sB9DUP"
					,"Mycatkins"
					,"https://www.flickr.com/photos/bigmikeyeah/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, horse);

			// 44 BEE
			Animal insect_bee = new Animal();
			insect_bee.addAnimalName(R.string.insect_bee);
			insect_bee.addAnimalName(R.string.insect_bee_gr);
			insect_bee.setAnimalVisualFile("insect_bee");
			insect_bee.setAnimalVisualFileSoundLang("insect_bee");
			insect_bee.addAudioFile("mosquito");
			addImageDetails(insect_bee
					,"https://www.flickr.com/photos/conifer/14416137894/in/photolist-nXUtxC-upNeNA-8Ws8PR-rqDMFB-9A2zj1-9gkuut-pkDMDQ-nJwQ6y-9skAQB-rmB2sc-51EMxi-4Sr7QG-3wCV3g-6k1FcA-2Ewtv2-2hPgpq-vAS6sN-rgWSem-vXwmJW-upyisG-8ajqH8-5uLLHN-otZUGL-9iYTk4-4AHTAX-t8G7gu-dK5Ecp-uFLFH5-6nEgcQ-rgfCsg-dwFUtL-vTgVUW-pq4gTG-bvxkYu-b5XiGD-5qNWxV-51dnrz-4ybMuJ-dX4G5B-rRw6fQ-ac7Xet-bu2Uur-9ZPQYk-vzDkuE-amvHVZ-r6N3Ab-4UDwAk-hRoQi-a5ZqKJ-sipj8i"
					,"coniferconifer"
					,"https://www.flickr.com/photos/conifer/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, insect_bee);

			// 45 KANGAROO
			Animal Kangaroo = new Animal();
			Kangaroo.addAnimalName(R.string.Kangaroo);
			Kangaroo.addAnimalName(R.string.Kangaroo_gr);
			Kangaroo.setAnimalVisualFile("Kangaroo");
			Kangaroo.setAnimalVisualFileSoundLang("Kangaroo");
			Kangaroo.addAudioFile("spring");
			addImageDetails(Kangaroo
					,"https://www.flickr.com/photos/onedaycloser/8340115689/in/photolist-dGZgQ6-9Ytohe-pQD1FY-5LrvVD-2H6SxB-rD2cSY-7uhEXb-fwBcLj-ovNcg8-7z322e-6KPGjf-3nuvUx-8DDrVe-8cecif-7itG6m-8roJaT-pwdipD-d9TBqH-oWtmSf-4JVkfq-qvcenc-97xU8r-97n26o-sxD7j1-8oLv2y-8oy9Jc-d9TBV1-48N8rv-3nyZ1q-6iQdDE-agmprw-pzAVQD-fGmvcL-5ksCFj-8W2aRv-4vQ7d1-fwCP67-ejcCRm-aoau6q-ieVGiZ-4d66vf-nbesPM-7dZfo8-d9TBsa-b9rfnV-6sQncN-6ggSu9-eCxBbR-hS9fdj-ezCtuS"
					,"Kangaroo with joey"
					,"https://www.flickr.com/photos/onedaycloser/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, Kangaroo);

			// 46 KOALA
			Animal koala = new Animal();
			koala.addAnimalName(R.string.koala);
			koala.addAnimalName(R.string.koala_gr);
			koala.setAnimalVisualFile("koala");
			koala.setAnimalVisualFileSoundLang("koala");
			koala.addAudioFile("koala");
			addImageDetails(koala
					,"https://www.flickr.com/photos/swallowtailgardenseeds/15714627136/in/photolist-pWDzab-pStAP4-5N9BPQ-5N5iQn-9oEjaj-fAFHaQ-fAFHaw-uNVmo-882SDi-8VFJxZ-6R2Sej-9CrgSP-9YPrhh-623YSF-h1C7xA-bMxSbM-9A7NWw-pAEGg7-2YVcuD-5BbKV-dnGAU3-5TxYHr-pSQ2uz-79a1nH-bMWq5P-dBhUPg-7QdPLC-sEwsHC-7yLovN-o6ME5g-dXDzNA-bdk1VK-5DmAgh-6iGw2G-4jYS9M-GhKjF-kGcg6R-aHK4W4-h4RSKM-617cTE-8sXwat-kmyJb-g8GF8b-kmyHh-dk8kGM-ps19g-5N5jxH-kCbZzg-ndiL1s-79sNyJ"
					,"Swallowtail Garden Seeds"
					,"https://www.flickr.com/photos/swallowtailgardenseeds/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, koala);

			// 47 LADYBUG
			Animal ladybug = new Animal();
			ladybug.addAnimalName(R.string.ladybug);
			ladybug.addAnimalName(R.string.ladybug_gr);
			ladybug.setAnimalVisualFile("ladybug");
			ladybug.setAnimalVisualFileSoundLang("ladybug");
			ladybug.addAudioFile("fly");
			addImageDetails(ladybug
					,"https://www.flickr.com/photos/themarmot/468859384/in/photolist-Hr2yu-pt14Wx-7tXHTr-fsGhAd-5pWXFu-eCGiSs-u5xeij-8wx9QK-c2oHKQ-9rBW2c-ptfJPA-mSz2Ng-6R4sya-7YdGsS-57XmKL-a98GaW-5PmBrC-6nJyxJ-fjQxJ6-fQDCbp-8G3qDw-9z5Sw1-9DdeLr-87JzKc-pt15T2-pbMZNE-nDqhhu-Tbtoq-Eh3fT-d96r83-cpaBCC-cpaBss-4f3was-4yY6dq-bV5kaJ-abTbo3-4d64Ne-7QsSNE-mQ41Zq-9AC34x-c4EdRN-cnypfQ-acVLVM-ehof2V-obACnG-vg2zyw-cPEH6-qVQ1Yn-ndwFNd-32FFA5"
					,"The Marmot"
					,"https://www.flickr.com/photos/themarmot/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, ladybug);
			
			// 1 ANT
			Animal ant = new Animal();
			ant.addAnimalName(R.string.ant	);
			ant.addAnimalName(R.string.ant_gr);
			ant.setAnimalVisualFile("ant");
			ant.setAnimalVisualFileSoundLang("ant");
			ant.addAudioFile("empty");		
			
			ant.imageDetails[0] = "https://www.flickr.com/photos/siraf72/11500322673/";
			ant.imageDetails[1] = "Faris Algosaibi";
			ant.imageDetails[2] = "https://www.flickr.com/photos/siraf72/";
			ant.imageDetails[3] = creativeLisenceBy;
		
			animals.put(tempArrayVariable++, ant);

			// 48 LAMB
			Animal lamb = new Animal();
			lamb.addAnimalName(R.string.lamb);
			lamb.addAnimalName(R.string.lamb_gr);
			lamb.setAnimalVisualFile("lamb");
			lamb.setAnimalVisualFileSoundLang("lamb");
			lamb.addAudioFile("goat");
			addImageDetails(lamb
					,"https://www.flickr.com/photos/rogdavies/4670542323/in/photostream/"
					,"Roger Davies"
					,"https://www.flickr.com/photos/rogdavies/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, lamb);

			// 49 LEOPARD
			Animal leopard = new Animal();
			leopard.addAnimalName(R.string.leopard);
			leopard.addAnimalName(R.string.leopard_gr);
			leopard.setAnimalVisualFile("leopard");
			leopard.setAnimalVisualFileSoundLang("leopard");
			leopard.addAudioFile("tiger");
			addImageDetails(leopard
					,"https://www.flickr.com/photos/flowcomm/11665709426/in/photolist-7zb6Dx-6ipXGj-4cn1Y4-bCn7ur-fhzS9B-fhzUhK-ecrUGD-7sNoTp-7EgvdY-donNi8-4Ep73V-5PEptQ-5kJzup-dT6Ltz-jJyoG-pw8Ly8-9uJ8Qd-4pJLZ4-6ei174-8rt5Qc-pBCzUA-aBAqX8-m3wfS6-6ewFMD-ktQ1um-n9MdXT-4cn2cp-8MBnPS-3L6iS1-kEvWqZ-nnDQ9F-nkAG36-g47Xz3-q6fiTd-iLLR12-kEziP5-kEzyqj-6feiUM-fyqFmW-fyqCEY-fybm7x-fyqFdU-7JvqTp-3JWmca-aDdD64-h3vF6S-fybo74-iLRNZ9-psyaD3-9S9zr1"
					,"flowcomm"
					,"https://www.flickr.com/photos/flowcomm/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, leopard);

			// 50 LION
			Animal lion = new Animal();
			lion.addAnimalName(R.string.lion);
			lion.addAnimalName(R.string.lion_gr);
			lion.setAnimalVisualFile("lion");
			lion.setAnimalVisualFileSoundLang("lion");
			lion.addAudioFile("lion");
			addImageDetails(lion
					,"https://www.flickr.com/photos/mdpettitt/2744071042/in/photolist-5bu5HG-7RrGq1-caDmhw-6WrSag-8bimn-6JH137-aSvKb6-r7Hnba-9jZCKC-4XMFy-dJpQp-7K1MXv-8ytZZf-oGp9SU-ejnUak-heeNsT-7RrFKE-jRTpxg-a5uv7M-eQkFhX-q9WuKS-GWtmi-7AN3f-62QGYc-71ZC4K-kurXac-62UWLL-ovqA2U-5eYE4w-a62PTA-6MgSGM-GWtmx-qa26ES-bxKWh-grJXdz-5TL15H-4w9k7X-8qy8DH-oZK6DK-9PPH-j7HiSg-6WrSyn-nhQXxo-4skMdS-cZh4iy-owuQJr-d4CLLL-894tTc-2W7Fuf-5FRkF1"
					,"Martin Pettitt"
					,"https://www.flickr.com/photos/mdpettitt/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, lion);

			// 51 IGOUANA
			Animal lizard_Igouana = new Animal();
			lizard_Igouana.addAnimalName(R.string.lizard_Igouana); 
			lizard_Igouana.addAnimalName(R.string.lizard_Igouana_gr);
			lizard_Igouana.setAnimalVisualFile("lizard_Igouana");
			lizard_Igouana.setAnimalVisualFileSoundLang("lizard_Igouana");
			lizard_Igouana.addAudioFile("reptile");
			addImageDetails(lizard_Igouana
					,"https://www.flickr.com/photos/opalsson/3594421784/"
					,"O Palsson"
					,"https://www.flickr.com/photos/opalsson/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, lizard_Igouana);

			// 52 LIZARD
			Animal lizard = new Animal();
			lizard.addAnimalName(R.string.lizard);
			lizard.addAnimalName(R.string.lizard_gr);
			lizard.setAnimalVisualFile("lizard");
			lizard.setAnimalVisualFileSoundLang("lizard");
			lizard.addAudioFile("reptile");
			addImageDetails(lizard
					,"https://www.flickr.com/photos/7147684@N03/12645960755/"
					,"Jason Hollinger"
					,"https://www.flickr.com/photos/7147684@N03/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, lizard);

			// 53 LOBSTER
//			Animal lobster = new Animal();
//			lobster.addAnimalName(R.string.lobster);// < --- havent found yet!!!!!
//			lobster.addAnimalName(R.string.lobster_gr);
//			lobster.setAnimalVisualFile("lobster");
//			lobster.setAnimalVisualFileSoundLang("lobster");
//			lobster.addAudioFile("fish");
//			addImageDetails(lizard_Igouana
//					,"https://www.flickr.com/photos/7147684@N03/12645960755/"
//					,"Jason Hollinger"
//					,"https://www.flickr.com/photos/7147684@N03/",
//					creativeLisenceBy);
//			animals.put(tempArrayVariable++, lobster);

			// 54 MONKEY
			Animal monkey = new Animal();
			monkey.addAnimalName(R.string.monkey);
			monkey.addAnimalName(R.string.monkey_gr);
			monkey.setAnimalVisualFile("monkey");
			monkey.setAnimalVisualFileSoundLang("monkey");
			monkey.addAudioFile("monkey");
			addImageDetails(monkey
					,"https://www.flickr.com/photos/mape_s/333862026/in/photolist-vv8xQ-3uDcyv-5uZPbm-dBbPjP-4S8Fcq-sJaaiK-tomrM1-jWkder-dQ3oWc-dUCi77-pvpAiH-9dZQjz-8R3f1S-nVcqc8-4DcUAJ-4G2dfF-8LVaAY-8LS7Rc-4rr2Dx-9vk3eU-9rsQkp-igRXPY-hh3ric-dy1QMq-4rv7AG-6KsQm4-5Vz8oG-pUXQrn-6KsWjV-nfRp51-5v7uaE-apiC6e-apmkxy-3w1BF-4W9PKY-enRqJ1-7zc4jq-7z8hst-666PDP-saJTMY-4AER6T-9dd25h-mthpKr-62DfYj-69C2SN-2P9vHJ-MFgS7-5AQuBP-zN18s-oFC92u"
					,"Marieke IJsendoorn-Kuijpers"
					,"https://www.flickr.com/photos/mape_s/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, monkey);

//			// 55 MOOSE
//			Animal moose = new Animal();
//			moose.addAnimalName(R.string.moose);
//			moose.addAnimalName(R.string.moose_gr);
//			moose.setAnimalVisualFile("moose");
//			moose.setAnimalVisualFileSoundLang("moose");
//			moose.addAudioFile("moose");
//			animals.put(tempArrayVariable++, moose);

			// 56 MOSQUITO
			Animal mosquito = new Animal();
			mosquito.addAnimalName(R.string.mosquito);
			mosquito.addAnimalName(R.string.mosquito_gr);
			mosquito.setAnimalVisualFile("mosquito");   
			mosquito.setAnimalVisualFileSoundLang("mosquito");
			mosquito.addAudioFile("mosquito");
			addImageDetails(mosquito
					,"https://www.flickr.com/photos/dfataustralianaid/10703811283/in/photolist-hiRQbp-t829Yg-co6Am9-f6phpQ-8j7C91-diAQNB-o2C5Ea-5pBMJ8-9RE4sN-5pBMJp-5pBMJ4-boBKtp-d8VGcm-nEXatf-NrjrV-qr2yxb-4my6gQ-4oBLyt-6hrFJ5-aAWitD-fLETTr-kFsnXd-egmpZD-nwP3sz-mSgaep-WjrPY-YFtgv-gZ6mEQ-aNDnL2-c6bw3S-phX93M-orVegY-mAtMwr-dL2Wn-fQnZtM-bW5NLq-aeM19Y-3SUkNL-fQnYZz-nnLdu3-fSS3v5-fQnZng-vMPGS-uLrez5-fSS2Qr-5vZWe-3crN6x-aUew3i-e2AaMZ-e5znsu"
					,"Department of Foreign Affairs and Trade"
					,"https://www.flickr.com/photos/dfataustralianaid/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, mosquito);

			// 57 MOUSE
			Animal mouse_field = new Animal();
			mouse_field.addAnimalName(R.string.mouse_field);
			mouse_field.addAnimalName(R.string.mouse_field_gr);
			mouse_field.setAnimalVisualFile("mouse_field");
			mouse_field.setAnimalVisualFileSoundLang("mouse_field");
			mouse_field.addAudioFile("mouse");
			addImageDetails(mouse_field
					,"https://www.flickr.com/photos/spencer77/6153586825/in/photolist-anLJYz-a3URpt-4tLZWY-78vf1h-dYzLBw-7F83ib-MiRwQ-5dcWum-aUgTFZ-5TJRuU-4Zq6Wx-patuu5-7ih7Yn-8nf9FX-7qzgNU-529w7D-529woP-7Vhw9E-hrc3jA-3KA7N9-ooSas-c3V3Pq-aUgTtr-ims2NW-fyHZbH-hM6Ey-bkW7fH-6cTvKN-d88Brm-2qJYBV-97w1BB-99TEBV-oqi6MC-pKxRqs-7DWNtu-7pFAqK-C61mA-aG6F1V-a8JMsj-bhum4H-e4AiJu-8TawLT-hw9AYu-t7ZTjZ-atvg7L-ndYEUp-8rwstf-7GegfX-3pPKua-7pAXsL"
					,"Spencer Wright"
					,"https://www.flickr.com/photos/spencer77/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, mouse_field);

			// 58 ORCA
			Animal orca = new Animal();
			orca.addAnimalName(R.string.orca); 
			orca.addAnimalName(R.string.orca_gr);
			orca.setAnimalVisualFile("orca");
			orca.setAnimalVisualFileSoundLang("orca");
			orca.addAudioFile("orca");
			addImageDetails(orca
					,"https://www.flickr.com/photos/9557815@N05/4105646624/in/photolist-7fNvGL-6rTFU2-CqeYt-kmxCvB-8F3S48-7HhSjw-apE7Lv-b5LCXK-qNGMVZ-bjydnR-6prCf4-CqezM-bjydxM-bjydvv-bjydp8-pNyzZW-qAtAST-3CsiP-75i7qJ-pu1M2-7rMNuR-6n4129-bgCRS-mhVcLi-2CHCpr-3nyZLx-7rRJFQ-6AZoZf-2zrmWT-9bbpWV-75cYU2-6ZW3Rg-6ZW3cB-6ZW34a-6ZW2tk-7113fU-6ZW2Bx-7111B9-apEbbe-bgCSS-9bbpVV-axCj3W-9xDVZ1-qLioX-4ETyWu-8L3Q1B-51PHTx-8rNW58-bzvp3W-nhaH5J"
					,"Abi Skipp"
					,"https://www.flickr.com/photos/9557815@N05/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, orca);

			// 59 OWL
			Animal owl = new Animal();
			owl.addAnimalName(R.string.owl);
			owl.addAnimalName(R.string.owl_gr);
			owl.setAnimalVisualFile("owl");
			owl.setAnimalVisualFileSoundLang("owl");
			owl.addAudioFile("owl");
			addImageDetails(owl
					,"https://www.flickr.com/photos/sbern/8527858751/in/photolist-dZzvir-8FjRtQ-e8cVee-a4rbww-fL1XYx-fxBBE2-fxBhhk-bE1QXG-cM89LG-bjSdJz-obwHJU-8sN9kH-d3qmFb-p45qN2-s1PhT9-2x21eR-4rQsLt-6eUiTK-7QrqY5-px5gCk-bSVAnV-e3Rgwz-srDrP5-pv345m-fjKZLx-fLiyC7-4LPYr3-oKNpcc-7MFmfT-fxRnCA-fxRkAf-pmCeLX-bBg5gP-fxRv3j-29Md4L-8FJDrW-gQCKLS-8x56ad-cRWDRo-fg1cb-9J5PEZ-fn4BMZ-9MamzU-bxd4hq-u6NEpY-bye23-fxAXnV-osgJp4-fxC7uZ-nTuwBW"
					,"Stefan Berndtsson"
					,"https://www.flickr.com/photos/sbern/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, owl);

			// 60 PANDA
			Animal panda = new Animal();       
			panda.addAnimalName(R.string.panda);
			panda.addAnimalName(R.string.panda_gr);
			panda.setAnimalVisualFile("panda");
			panda.setAnimalVisualFileSoundLang("panda");
			panda.addAudioFile("panda");
			addImageDetails(panda
					,"https://www.flickr.com/photos/sbern/8527858751/in/photolist-dZzvir-8FjRtQ-e8cVee-a4rbww-fL1XYx-fxBBE2-fxBhhk-bE1QXG-cM89LG-bjSdJz-obwHJU-8sN9kH-d3qmFb-p45qN2-s1PhT9-2x21eR-4rQsLt-6eUiTK-7QrqY5-px5gCk-bSVAnV-e3Rgwz-srDrP5-pv345m-fjKZLx-fLiyC7-4LPYr3-oKNpcc-7MFmfT-fxRnCA-fxRkAf-pmCeLX-bBg5gP-fxRv3j-29Md4L-8FJDrW-gQCKLS-8x56ad-cRWDRo-fg1cb-9J5PEZ-fn4BMZ-9MamzU-bxd4hq-u6NEpY-bye23-fxAXnV-osgJp4-fxC7uZ-nTuwBW"
					,"Andrew Lawson"
					,"https://www.flickr.com/photos/andylawson/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, panda);

			// 61 PARROT
			Animal parrot = new Animal(); //
			parrot.addAnimalName(R.string.parrot);
			parrot.addAnimalName(R.string.parrot_gr);
			parrot.setAnimalVisualFile("parrot");
			parrot.setAnimalVisualFileSoundLang("parrot");
			parrot.addAudioFile("parrot");
			addImageDetails(parrot
					,"https://www.flickr.com/photos/11152520@N03/1524251782/in/photolist-3jGbX9-dPreJn-pY2Pju-p9nVKQ-6XW4tM-gnJpER-7VVKgn-ocUoyu-6rJi9F-6jK7L2-8YVpSB-qw2RBa-Lm8AY-94f7sQ-akFRqZ-oXcfdi-HQJyW-6rNr4b-6VjrDy-6rNrvm-5C6ws3-bPCWDz-9pYftu-6M2oLB-6uDbGT-4jZ3J7-defmFG-8qisZL-eUPp5V-frbUQG-9nBix-sGJFSJ-frtSbP-o4JPhv-BX1KF-2YuBzB-o2koCD-6zGHLa-D59Pb-ajrPbq-m7a8-sAqQR-bJKhXg-65eGXZ-3BRDx-6wjLVd-s645Gm-dtQxUf-pwWSSH-q2vq"
					,"Danny Chapman"
					,"https://www.flickr.com/photos/11152520@N03/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, parrot);

			// 62 PEACOCK
			Animal peacock = new Animal();
			peacock.addAnimalName(R.string.peacock);
			peacock.addAnimalName(R.string.peacock_gr);
			peacock.addAudioFile("peacock");
			peacock.setAnimalVisualFile("peacock");
			peacock.setAnimalVisualFileSoundLang("peacock");
			addImageDetails(peacock
					,"https://www.flickr.com/photos/atoach/4523891662/in/photolist-7TL8o7-9FXUa-oSTxKs-7CB7ZC-bLMCa6-4vWkXz-597Qjo-9FXUF-68JySm-prtRZc-aYCgB-8croea-m9quGN-PY3hK-7BRbar-4dgQtp-qzxmTD-4W8sbR-76vwpN-4Sg5CZ-37cjgs-6fckG9-47nj8Q-51hdHh-kr13Qc-cq1vj3-8ZUMs-4L7e9g-295MB-aq2U7G-8wuKpS-7KC16u-nytBVX-fxMUgA-fDXJZ2-8gkxkh-7fVLC9-6tmdqW-4Rkxus-6dRp96-qnM7ZA-mzL4Tv-oermGL-4yQNSG-sgCQaT-bFpkEa-fxMThm-fxxCBK-6TCjy1-9tJezM"
					,"Tim Green"
					,"https://www.flickr.com/photos/atoach/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, peacock);

			// 63 PENGUIN
			Animal penguin = new Animal();
			penguin.addAnimalName(R.string.penguin);
			penguin.addAnimalName(R.string.penguin_gr);
			penguin.addAudioFile("penguin");
			penguin.setAnimalVisualFile("penguin");
			penguin.setAnimalVisualFileSoundLang("penguin");
			addImageDetails(penguin
					,"https://www.flickr.com/photos/cmichel67/11235945713/in/photolist-i7TacX-69xP6r-qLxWTj-qcMwU7-oEz9TL-qs9gXg-i8gA2c-2KCkZ-a6rRNe-qcYQqf-pKneEA-javHwK-6gbFYs-i8g2sg-9ifD3Z-qkUxTR-6bq5r9-ibFac8-4sNb3A-i8g8gu-i8g4wL-JByTr-cFqTk-4n2KUv-2Vqs71-pRSJyU-qABQ51-q9VtYw-i8PXqm-agBzu6-qNcUXt-qxxW1n-q5S2Ke-ibFbui-qMxx9W-idaUrJ-4krYcm-sc2QeD-dQ6DTr-kWUBQF-siJ25M-dpNP7a-i8fUyB-8yQxKj-2X53-idaSqj-veKD6T-ibW3Hh-qQTcPf-73M5iT"
					,"Christopher Michel"
					,"https://www.flickr.com/photos/cmichel67/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, penguin);

			// 64 PIG
			Animal pig = new Animal();//< --- here  I am.
			pig.addAnimalName(R.string.pig);
			pig.addAnimalName(R.string.pig_gr);
			pig.addAudioFile("pig");
			pig.setAnimalVisualFile("pig");
			pig.setAnimalVisualFileSoundLang("pig");
			addImageDetails(pig
					,"https://www.flickr.com/photos/nsalt/2808207783/in/photolist-5h9Nkz-4B1csu-bkpgJL-qXwott-oGoxrz-BNcKW-iWv2gT-rMD8SX-5ypmXu-Mhhsd-rYogqK-5n6hjR-fn9Jc-apf8VN-hX6Mq-4je2DP-DRn2H-3wCZdT-s2if5B-iuL9V-MsFM-7FEQHe-7ZskDC-4o8aWM-4ppX6h-rxTJfy-7GEJvD-fa8RBD-t26u12-rmohrR-4ppXfC-jYse-5B8mLe-5dzMBA-a1PjXQ-nYVtz-pB3WR9-5fHE8G-63Nrwr-5B8mRv-dgdger-apcofM-5WXnBW-5ZF1LF-9k3oHh-a8oZU3-3cZNi-6p8fg9-dp1h2g-8cy7H"
					,"Nick Saltmarsh"
					,"https://www.flickr.com/photos/nsalt/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, pig);

			// 65 RABBIT
			Animal rabbit = new Animal();
			rabbit.addAnimalName(R.string.rabbit);
			rabbit.addAnimalName(R.string.rabbit_gr);
			rabbit.addAudioFile("rabit");
			rabbit.setAnimalVisualFile("rabbit");
			rabbit.setAnimalVisualFileSoundLang("rabbit");
			addImageDetails(rabbit
					,"https://www.flickr.com/photos/jpockele/3746828860/in/photolist-6H6tFA-jQQGx8-aaMyUQ-nfmMgn-7SU1DT-dzsYSS-6nvKZH-x9rD4-77tnc2-7ncB3g-9HDdkZ-eKM7Zh-jbues-oeLCbv-ehSbe7-6NexNs-quijB-iHErPc-poFfVa-7jDvKi-b44bQn-jZp6p-neFPgq-7Yx4DB-7ncBqp-ataH3s-cMTWjG-7SHaQf-7SxgGJ-rwDSDx-6xs6Ec-7e7tg6-iqrXWT-oNwMN6-sAG5TS-gV2hu-2pX15C-sqiFY-oTic2-7ncJua-c3X1Ay-atFQH8-rACfBL-nNBSYb-CwnC2-7efXvh-ehU9QF-dBQqK-6FieGX-6znNq4"
					,"Jannes Pockele"
					,"https://www.flickr.com/photos/jpockele/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, rabbit);

			// 66 RABBIT2
//			Animal rabbit2 = new Animal();
//			rabbit2.addAnimalName(R.string.rabbit2);
//			rabbit2.addAnimalName(R.string.rabbit2_gr);
//			rabbit2.addAudioFile("rabit");
//			rabbit2.setAnimalVisualFile("rabbit2");
//			rabbit2.setAnimalVisualFileSoundLang("rabbit");
//			animals.put(tempArrayVariable++, rabbit2);

			// 67 RACOON
			Animal racoon = new Animal();
			racoon.addAnimalName(R.string.racoon);
			racoon.addAnimalName(R.string.racoon_gr);
			racoon.addAudioFile("racoon");
			racoon.setAnimalVisualFile("racoon");
			racoon.setAnimalVisualFileSoundLang("racoon");
			addImageDetails(racoon
					,"https://www.flickr.com/photos/briangratwicke/4086055914/"
					,"Brian Gratwicke"
					,"https://www.flickr.com/photos/briangratwicke/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, racoon);

			// 68 RHINO
			Animal rhino = new Animal();
			rhino.addAnimalName(R.string.rhino);
			rhino.addAnimalName(R.string.rhino_gr);
			rhino.addAudioFile("rhino");
			rhino.setAnimalVisualFile("rhino");
			rhino.setAnimalVisualFileSoundLang("rhino");
			addImageDetails(rhino
					,"https://www.flickr.com/photos/usfwshq/6880953627/"
					,"Karl Stromayer/USFWS"
					,"https://www.flickr.com/photos/usfwshq/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, rhino);

			// 69 ROOSTER
			Animal rooster = new Animal();
			rooster.addAnimalName(R.string.rooster);
			rooster.addAnimalName(R.string.rooster_gr);
			rooster.addAudioFile("Rooster");
			rooster.setAnimalVisualFile("rooster");
			rooster.setAnimalVisualFileSoundLang("rooster");
			addImageDetails(rooster
					,"https://www.flickr.com/photos/korymatthew/8178996716/"
					,"Kory Westerhold"
					,"https://www.flickr.com/photos/korymatthew/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, rooster);

			// 70 SEA LION
			Animal sea_lion = new Animal();
			sea_lion.addAnimalName(R.string.sea_lion);
			sea_lion.addAnimalName(R.string.sea_lion_gr);
			sea_lion.addAudioFile("sea_lion");
			sea_lion.setAnimalVisualFile("sea_lion");
			sea_lion.setAnimalVisualFileSoundLang("sea_lion");
			addImageDetails(sea_lion
					,"https://www.flickr.com/photos/aidanmorgan/2408856721/in/photolist-4ES2br-4EWiCm-p2Q1xy-5rsmH7-ma4fnm-jnqgGu-32Qs5X-9UBt3G-iZKAWn-32Qj6x-nBuWQP-c7MgZy-tQcN47-7t417R-rUK1RC-8r4HkH-79tRXX-9opJm9-icbBtD-wwqSM9-6686o6-5tJcKz-r2Lb6U-32QcyX-5wLH53-aA8sHv-iZJi7t-eajwk1-nRNKyG-7juoG9-6ov1zS-dY1MGr-eZPaLh-qwFife-uNWRQA-aE4X8h-5nZsTY-qAp6on-fGHNCj-pg1QU6-um3LPU-qSGjjK-6VqAXA-df8BDg-2qiud9-sKoJja-owP5rZ-gJevuN-AhacF-fKEsnA"
					,"John Morgan"
					,"https://www.flickr.com/photos/aidanmorgan/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, sea_lion);

			// 71 SHARK
			Animal shark = new Animal();
			shark.addAnimalName(R.string.shark);
			shark.addAnimalName(R.string.shark_gr);
			shark.addAudioFile("fish");
			shark.setAnimalVisualFile("shark");
			shark.setAnimalVisualFileSoundLang("shark");
			addImageDetails(shark
					,"https://www.flickr.com/photos/leszekleszczynski/15447205451/in/photolist-px1Y1t-bgLamp-h3dZG-e4gXPf-rpEgiw-9iiJ2h-cCRx1-9dN5Ts-2jGUrP-rnEYp-cCRqb-h3m8ZS-iJDADw-db6hGQ-51wjhW-aRajA2-7HGkDX-oFMxWk-N688e-7LXNkJ-drS6DZ-gGTaDH-iJBDzr-8ddg9W-cFqJ2-oHVLa6-5gBraH-sDsFCD-orGMzR-puNL2-2T1rC-7SpL3e-6aSGh9-ouVq-4zz25c-iJCWNa-8FDQ2R-orGMyu-eiwgt1-4NyU5-cFqQs-49duH7-jqt5ud-p6zctv-tPtZDA-d2rmgY-drS6SB-oESC6a-7RxjMm-5WAKjR"
					,"Leszek Leszczynski"
					,"https://www.flickr.com/photos/leszekleszczynski/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, shark);

			// 72 SHRIMP
			Animal shrimp = new Animal();
			shrimp.addAnimalName(R.string.shrimp);
			shrimp.addAnimalName(R.string.shrimp_gr);
			shrimp.setAnimalVisualFile("shrimp");
			shrimp.setAnimalVisualFileSoundLang("shrimp");
			shrimp.addAudioFile("fish");
			addImageDetails(shrimp
					,"https://www.flickr.com/photos/dahlstroms/4408094771/in/photolist-7HwCZZ-r32PBg-biVTBv-8TE767-9Vj3un-8fBpd2-dhj93J-dhj1tu-9TvWWx-catGjU-dT7DzX-i8vkdg-dhiX4T-powp2b-dhj5Em-dhiX3w-7PN1L3-pLVJgW-C1sQs-9MTxAC-9LzZ52-8SS7Pb-9qijKm-nWFuHh-8mnkZh-dhiVaD-bSJwXK-r9EK3p-cXpfXb-dhiYKi-dhj4sU-dhiZiD-dhjk9H-nmnCD1-fDdi4g-rS54Uz-q6wQmM-6kbjni-51MFS-4Y9RM-g1aUi2-h8d4e-7HcAGD-7fYXAr-a9mQ4C-nk94uR-kbfMdv-7KHrgD-6c69T7-amWBtL"
					,"Håkan Dahlström"
					,"https://www.flickr.com/photos/dahlstroms/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, shrimp);

			// 73 SNAIL
			Animal snail = new Animal();
			snail.setAnimalVisualFile("snail");
			snail.setAnimalVisualFileSoundLang("snail");
			snail.addAnimalName(R.string.snail);
			snail.addAnimalName(R.string.snail_gr);
			snail.addAudioFile("empty");
			addImageDetails(snail
					,"https://www.flickr.com/photos/randysonofrobert/2763801867/in/photolist-5ded1k-sqbX5L-gR5qqL-q84kjJ-eMQZDn-ks5jH8-i2eUbE-iThPLJ-eJb6Q-netMeR-6VdNYj-ptfjTX-or4QfV-pGtiZK-5dqJrP-9qyPNw-t5Ffy3-Ruy9M-2zFCDn-4GaoMd-7MmzXs-7Ydxp7-fpZFie-eGYhMw-24iYC6-kqu9-tAxQXS-9xuyFG-iTfM4G-i3J7Nw-gEoat1-onDY2s-74w5oY-eEg3xf-51MLuC-nxcPr8-kYz3zk-vjNfUZ-qETZQH-i3Yna1-5jBxzC-oYoXEk-8RymZS-9ak4A-riEPgn-fqEqiA-pbJXTh-v364t1-nQFdGt-C22zn"
					,"Randy Robertson"
					,"https://www.flickr.com/photos/randysonofrobert/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, snail);

			// 74 SNAKE
			Animal snake = new Animal();
			snake.addAnimalName(R.string.snake);
			snake.addAnimalName(R.string.snake_gr);
			snake.setAnimalVisualFile("snake");
			snake.setAnimalVisualFileSoundLang("snake");
			snake.addAudioFile("snake");
			addImageDetails(snake
					,"https://www.flickr.com/photos/kurisuuu/398673269/in/photolist-BeiF4-9ucK5m-dpcbNa-neQWoo-9Ycq9J-qsm3Se-eV65YB-4hogcD-9kwWdv-b8ABP-6prN2h-6wxBx9-tdXgUH-7XSkzK-4nXkeb-pNuErp-cBbQgq-pNuF34-pweR6p-pFJYbV-pFK2Fk-9yX9De-pR8YyM-pimkc8-pXZTfP-pwkdXb-pweV6D-pR91iD-q9X9Z5-pdFLtj-pikR5s-nBsbxw-pcnBYf-7VRCNv-5kt6Mf-4ZahmK-dnDmPM-nBt1QT-faMdw-4Zc23H-u1vhB-aoAT8Z-r48VyF-q9iLnL-qauWDP-qauWVF-robDE8-7Derge-5o7QkS-q5Ccf8"
					,"stacieharmon1"
					,"https://www.flickr.com/photos/stacieharmon1/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, snake);

			// 75 SPIDER
			Animal spider = new Animal();
			spider.addAnimalName(R.string.spider);
			spider.addAnimalName(R.string.spider_gr);
			spider.setAnimalVisualFile("spider");
			spider.setAnimalVisualFileSoundLang("spider");
			spider.addAudioFile("empty");
			addImageDetails(spider
					,"https://www.flickr.com/photos/christianhaugen/3559128758/in/photolist-6qvsYW-6qvtm3-6qrkvR-EcPCw-ktUJV5-ecP4tu-9g3rw-8XSxzr-8XVAyw-8XSxzM-4VtCua-ehAiMv-8XSxza-7uCuq8-bJkFQp-2D6ZaC-eCovWm-eCovGd-eCovP9-pnySD-5xCBHZ-2VcmaP-fx6Twq-cFX9ty-jKCjr1-rQ6Sxp-ffLxSS-ffwjjD-ffLxR5-ffwjkB-ffLxPW-ffLxQA-ffwjfX-ffwjia-ffwjgp-ffLxPG-ffLxRw-ffLxQo-ffLxNs-57cepn-enft8L-bDoaM8-ekCXwu-ehVcdQ-7nteS4-8MfK7N-5a8tH4-4WSeN4-4FMJ1Z-NPWVi"
					,"Christian Haugen"
					,"https://www.flickr.com/photos/jayt74/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, spider);

			// 76 STARFISH
			Animal starfish = new Animal();
			starfish.addAnimalName(R.string.starfish);
			starfish.addAnimalName(R.string.starfish_gr);
			starfish.setAnimalVisualFile("starfish");
			starfish.setAnimalVisualFileSoundLang("starfish");
			starfish.addAudioFile("fish");
			addImageDetails(starfish
					,"https://www.flickr.com/photos/idapinder/16726060788/in/photolist-ru2r9q-24CiUS-iBX1CH-9tdXAc-9tdXy4-9tdXSV-5h74ky-68MCHc-8tbLqw-c8tuow-8HMvvV-5hQKQc-6iRPHs-9z94fQ-pLNEoM-dzcdX5-4zLjKC-74kPMu-9PM6F2-7JdbZk-7JgFoW-4T2EjH-9UWoCw-7TNtHf-92Lkfg-92PeeG-k8VTx3-arVkGu-82quEv-bKWzZM-96vfEv-caM1cC-bzR25C-wpKcC-7BtfVQ-61U7KA-j7rbtQ-cBKBCm-34uqWm-qytgzG-9MQhg-kJTGYT-gd1Vf-64b8uA-pJuWpy-5v9HY-k8Uz5c-9smyrm-ejk9T9-cAt2cY"
					,"Dapinder"
					,"https://www.flickr.com/photos/idapinder/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, starfish);

			// 77 SWAN
			Animal swan = new Animal();
			swan.addAnimalName(R.string.swan);
			swan.addAnimalName(R.string.swan_gr);
			swan.setAnimalVisualFile("swan");
			swan.setAnimalVisualFileSoundLang("swan");
			swan.addAudioFile("swan");
			addImageDetails(swan
					,"https://www.flickr.com/photos/robin1966/15197564621/in/photolist-p9Xuue-2tibPG-k7P6Ug-69TKwQ-nXtFFH-mkD6WL-bGUWfa-dAFiez-9viFEH-6sX4iQ-daMPLF-qJBXGK-ehQ4CC-7RbGc3-waKf7-fSqC3W-6ZxZqb-2oLDYY-5T5Gtv-3VqSKo-6hmcqf-7X4RWs-g5KB1Y-g45cti-6ZKVjg-kcMQYr-cBfb2Y-nVvnyD-e4ZyaR-sMKE1L-ufhBcj-u5kFuw-vT49Nc-5UdCmn-bbyyFZ-9wX5RT-6sSVDz-jZFZZD-sMPzkp-bowCuP-sSENVi-bA3dfL-bFQooD-qXeDEZ-6SyS6f-8NShjQ-4uJd9M-fBLGxj-bU5Po4-98b3xC"
					,"Micolo J"
					,"https://www.flickr.com/photos/robin1966/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, swan);

			// 78 SWORDFISH
//			Animal swordfish = new Animal();
//			swordfish.addAnimalName(R.string.swordfish);
//			swordfish.addAnimalName(R.string.swordfish_gr);
//			swordfish.setAnimalVisualFile("swordfish");
//			swordfish.setAnimalVisualFileSoundLang("swordfish");
//			swordfish.addAudioFile("fish");
//			animals.put(tempArrayVariable++, swordfish);

			// 79 TIGER
			Animal tiger = new Animal();
			tiger.addAnimalName(R.string.tiger);
			tiger.addAnimalName(R.string.tiger_gr);
			tiger.setAnimalVisualFile("tiger");
			tiger.setAnimalVisualFileSoundLang("tiger");
			tiger.addAudioFile("tiger");
			addImageDetails(tiger
					,"https://www.flickr.com/photos/mathiasappel/14806825806/in/photolist-oyqRs7-nuNp5f-bBrQj1-dyCJeY-wV8Nj1-5Pd8Fq-hEkKUW-3cNnP8-FxgaX-9gUaAh-nHjGLB-p3mGXB-fD73xb-npZy3g-9F2hFB-72xLS1-98aGRk-e23sza-pDhpCn-LgDGE-721SC4-6TBbS3-bnfUn8-j3hdG8-qa4LzP-5mf742-cGqrnw-uYMUA-bXeoq7-99AqGx-5fwvwA-9f5DjS-r6ovjv-hq4Qxi-qopqKf-xcfwi-8fQhTU-rJSg2-6spUPg-51vnqj-rKW3c-twnWDK-cy6Lsf-89Xr9m-EXFg-73yPF1-6kCoqQ-etpY51-aJR7KX-daQ3UD"
					,"Mathias Appel"
					,"https://www.flickr.com/photos/mathiasappel/"
					,creativeLisencePublicDomain
					);
			animals.put(tempArrayVariable++, tiger);

			// 80 TURKEY
			Animal turkey = new Animal();
			turkey.addAnimalName(R.string.turkey);
			turkey.addAnimalName(R.string.turkey_gr);
			turkey.setAnimalVisualFile("turkey");
			turkey.setAnimalVisualFileSoundLang("turkey");
			turkey.addAudioFile("turkey");
			addImageDetails(turkey
					,"https://www.flickr.com/photos/zionnps/6384983627/in/photolist-aJdHbB-qbMwTT-9P4ndB-q4jWG4-ajHvi4-f8rVen-s7zEpm-52GdPC-rctxjR-e9RRfi-iZF29c-nRn6rd-9T9fTN-qwDdwa-4h85ik-pZZf3D-9zjPJE-fbfPzB-iLkQ3D-cYPQnq-bVMkSh-bVKn4u-rAitp9-orAPW2-nfCicj-52GaLE-9msMhX-dxk9Co-9hH1WX-hj3KML-aFvBkr-c3p8uo-52BX2B-nhqdgE-ecMW1v-gThv5G-i7hufs-jNvufo-gTgotL-dHGqsE-bKxv1H-aGAP6V-eimGkf-94dMSh-pf9K8n-pc7AW3-9T9eEY-9o1Vhz-s47JYn-bqZTUx"
					,"NPS Photo/Marc Neidig /Zion National Park"
					,"https://www.flickr.com/photos/zionnps/"
					,creativeLisenceBy
					);
			animals.put(tempArrayVariable++, turkey);

			// 81 TURTLE
			Animal turtle = new Animal();
			turtle.addAnimalName(R.string.turtle);
			turtle.addAnimalName(R.string.turtle_gr);
			turtle.setAnimalVisualFile("turtle");
			turtle.setAnimalVisualFileSoundLang("turtle");
			turtle.addAudioFile("fish");
			addImageDetails(turtle
					,"https://www.flickr.com/photos/jamiedfw/3786707849/in/photolist-6LBSjn-671y2R-nduova-5D9D7D-4YZott-4W5pTJ-36A8ex-6bhRX9-v3wWLh-3fFHbz-qJ5AAv-atdbxY-rERJqq-ubfRJg-uG9upi-hNj7V-okLbV9-8ewn2j-6vbspx-9t32mv-hrcKnB-u1Jvei-gwyiiN-3Q99Q-rstiT5-e7oRPu-5oV7cj-5yhzCT-4m2Von-fGkcpv-3hiiu-dsKxTT-s9kAG4-7wQJbM-p7RPF1-opjDwr-bBrvL1-7fX4B2-weGCZw-vEGmw9-4vVsud-tKBkMq-gwyy1n-4W5ppW-iEWXSf-ajNRnz-7kNEz2-bk98aq-gCUdZ1-qotfWm"
					,"Jim Bowen"
					,"https://www.flickr.com/photos/jamiedfw/"
					,creativeLisenceBy
					);
			animals.put(tempArrayVariable++, turtle);

			// 82 WOLF
			Animal wolf = new Animal();
			wolf.addAnimalName(R.string.wolf);
			wolf.addAnimalName(R.string.wolf_gr);
			wolf.setAnimalVisualFile("wolf");
			wolf.setAnimalVisualFileSoundLang("wolf");
			wolf.addAudioFile("wolf");
			addImageDetails(wolf
					,"https://www.flickr.com/photos/max-goldberg/16936233026/in/photolist-rNAC2G-rQLXzU-5emeB1-74FNmZ-9YS55f-6uJNZ4-nJcnrJ-nJba8D-nYCfj1-o1yRuo-72XhJd-79jxA4-rjDGRg-74KZpq-fH95Du-5R4LQR-79jxAc-ryjVA9-8wPxJ5-cLZA93-boD49j-9sizKC-rQNU1K-9dmz2g-e8BWgY-eAZAyA-ryrtHH-rwyWkX-psgap6-inUgbF-rQLS7Q-rNAHkh-rNALe3-ryiLEd-qTTVej-ryiQ6G-ryiSz9-rwyRZH-ryjPNs-qU6xb6-74KGgJ-74KFtd-qFz14A-a5rZeR-8fxoc5-4xUeTy-pieV8-MGrpz-nDqPEL-74KG5S"
					,"Max Goldberg"
					,"https://www.flickr.com/photos/max-goldberg/"
					,creativeLisenceBy
					);
			animals.put(tempArrayVariable++, wolf);

			// 83 ZEBRA
			Animal zebra = new Animal();
			zebra.addAnimalName(R.string.zebra);
			zebra.addAnimalName(R.string.zebra_gr);
			zebra.setAnimalVisualFile("zebra");
			zebra.setAnimalVisualFileSoundLang("zebra");
			zebra.addAudioFile("zebra");
			addImageDetails(zebra
					,"https://www.flickr.com/photos/stignygaard/2445865522/in/photolist-4J8GBd-4EysVf-bqqc9K-7f5j3g-3q8bME-afoJnv-FTd8c-4EuwmV-qQ6sMV-aEXkNP-4EyMAu-6tnGEu-ecqHt8-5BCAyi-cm8NZs-3EtJH1-4uvsHu-4EuvPr-5TDidd-7vMfv-8unW42-ibkJSJ-rTTqSH-55W391-55RRRM-6E4MJ-4EyKcU-7uQiaP-9dD2bU-4Eybcu-75HiQJ-4Eyttm-5VwtWC-9AjVM7-2HKGLy-6KJ3Th-5fr5ad-farTFh-4EuxMp-9ZS5Lp-8ukxji-p74hdY-8uky7g-bZkXCf-kMju-8UbZoc-b86728-6MTF3V-bTkQ66-3gLngV"
					,"Stig Nygaard"
					,"https://www.flickr.com/photos/stignygaard/"
					,creativeLisenceBy
					);
			animals.put(tempArrayVariable++, zebra);

			// 84 SEAGULL
			Animal sea_gull = new Animal();
			sea_gull.addAnimalName(R.string.sea_gull);
			sea_gull.addAnimalName(R.string.sea_gull_gr);
			sea_gull.setAnimalVisualFile("sea_gull");
			sea_gull.setAnimalVisualFileSoundLang("sea_gull");
			sea_gull.addAudioFile("seagull");
			addImageDetails(sea_gull
					,"https://www.flickr.com/photos/arnaudabadie/7733716998/in/photolist-cMpjCf-89YkWw-uGJfeG-9x6QJz-qttgyz-xMCA-32NtwV-oitj2W-v534C-4tp5A5-picuQA-rTYdN9-59yRxR-9VSHeK-9UiPhv-5cgDGP-e3pHxa-di95y1-poipRa-r2TFwY-dnCrPD-8WLcNS-nAU4FB-r4oEYX-gcdohS-v6zQB2-4zdT8-wgP64S-puNhaq-dPeS4F-vyPXV7-rZ1Hoj-oGkoik-ewzDhY-dYcp83-obQuP7-f5ds4V-nDeuXD-tSN6cQ-4z5oo1-753Y8L-biTMce-v8vktq-tB6PxZ-DtJWw-gAx8gn-3VWX6Z-kty3C1-bTvhcr-agSTik"
					,"Arnaud Abadie"
					,"https://www.flickr.com/photos/arnaudabadie/"
					,creativeLisenceBy
					);
			animals.put(tempArrayVariable++, sea_gull);

			// 85 HIPPO
			Animal hippo = new Animal();
			hippo.addAnimalName(R.string.hippo);
			hippo.addAnimalName(R.string.hippo_gr);
			hippo.setAnimalVisualFile("hippo");
			hippo.setAnimalVisualFileSoundLang("hippo");
			hippo.addAudioFile("hippo");
			addImageDetails(hippo
					,"https://www.flickr.com/photos/stignygaard/2456796208/in/photolist-4K6HVj-8uoC3N-494xiX-b8hYF-nazq6n-2mpTW-6TKMd-crTHSf-jEXiCD-4K2tQc-pbaz4S-5V2ZUz-uX9HjT-6ppUuQ-d6MhWd-dwmRQ7-72NpzJ-8RQeHG-fLShL-aYoAZK-8RQeKW-8RQeGE-8ukvz8-8ng2r-2mq3E-w8aCVs-5VTkKU-4EyxpY-4uhv4k-4EtQMi-ohLCX7-aoey3G-LwgfN-7seHz7-76zBoY-5EkrWv-4JSSBE-gikZaq-okZJ8w-kEXLGF-5fvRwn-qCXidi-gim2Hc-5fB5YS-bt4V2h-4Ey6mw-71NGd9-of3U3n-a9nWhq-GkoYM"
					,"Stig Nygaard"
					,"https://www.flickr.com/photos/stignygaard/"
					,creativeLisenceBy
					);
			animals.put(tempArrayVariable++, hippo);

			// 86 DONKEY
			Animal donkey = new Animal();
			donkey.addAnimalName(R.string.donkey);
			donkey.addAnimalName(R.string.donkey_gr);
			donkey.setAnimalVisualFile("donkey");
			donkey.setAnimalVisualFileSoundLang("donkey");
			donkey.addAudioFile("donkey");
			addImageDetails(donkey
					,"https://www.flickr.com/photos/33852840@N06/3548774979/in/photolist-6pApav-9E1Bph-8m4vKc-2DfPfY-fU9UjA-btvAah-5MesVs-7b814D-85knFq-6DwbKW-7Y3ca2-6Ds35p-3qVctE-ecJMMw-6KLFPA-amYeTe-6K2aU5-dPc6qL-cCdSBS-4XYMYn-32Mj38-4iMPKF-3KDdTc-5TQY6j-8vk9df-2KjYYD-8T6pe5-nY4QB7-6Ywwxg-an21ZC-9Yuz9-39AULH-6L85VX-6ww3FG-qvKDqq-qxS37P-qgtTFE-nmr8sT-qgAdMx-qvKDmC-672YTd-4KzKAF-NxG6J-arjV5-qyNLGV-5TLCje-cqsfHj-qZLG4-C3N3G-6y4da5/"
					,"isamiga76"
					,"https://www.flickr.com/photos/33852840@N06/"
					,creativeLisenceBy
					);
			animals.put(tempArrayVariable++, donkey);

		}
		else{
			
			animals.clear();
			animals = new SparseArray<Animal>();
			
			// 2 DEER
			Animal baby_dear = new Animal();
			baby_dear.addAnimalName(R.string.baby_dear);
			baby_dear.addAnimalName(R.string.baby_dear_gr);
			baby_dear.setAnimalVisualFile("baby_dear");
			baby_dear.setAnimalVisualFileSoundLang("baby_dear");
			baby_dear.addAudioFile("deer");
			
			
			baby_dear.imageDetails[0] = "https://www.flickr.com/photos/51986662@N05/14285645404/";
			baby_dear.imageDetails[1] = "USFWS Mountain-Prairie/Tom Koerner";
			baby_dear.imageDetails[2] = "https://www.flickr.com/photos/usfwsmtnprairie/";
			baby_dear.imageDetails[3] = creativeLisenceBy;
			
			
			animals.put(tempArrayVariable++, baby_dear);
			
			// 6 CANARY
			Animal bird_canary = new Animal();
			bird_canary.addAnimalName(R.string.bird_canary);
			bird_canary.addAnimalName(R.string.bird_canary_gr);
			bird_canary.setAnimalVisualFile("bird_canary");
			bird_canary.setAnimalVisualFileSoundLang("bird_canary");
			bird_canary.addAudioFile("canary");
			
			bird_canary.imageDetails[0] = "https://www.flickr.com/photos/chad_sparkes/14037792260/in/photolist-notmz3-4QFcV8-dWv9nG-bphjRG-9YWD7v-9aDMmN-9citeS-8iAUXo-8iB8Rb-8iQKxF-8iBEUo-8iB8uw-buguZo-9wdS4B-mKWdRj-8ixZBH-a6ZbQq-8ixZSH-uR7ihG-7EPYXh-9vkKjz-doPq7n-digajP-tTFYqe-9b4rfc-8wQ4SC-8iBewh-8U3uaM-uSY3Qf-uTFDEH-tWzFrx-uAYMmk-mbLCcB-8ixTtP-f5nerR-8iCXeD-9aopdA-dxMGo7-8ixYw8-qvrn25-8iAVsS-pcNbc-tWq8Tm-oNsshQ-9vNPJK-8ixZbv-cRcSE-qsUskJ-oAFdB5-qTB7uj";
			bird_canary.imageDetails[1] = "Chad Sparkes";
			bird_canary.imageDetails[2] = "https://www.flickr.com/photos/chad_sparkes/";
			bird_canary.imageDetails[3] = creativeLisenceBy;
			
			animals.put(tempArrayVariable++, bird_canary);
			
			// 29 DUCK
			Animal duck = new Animal();
			duck.addAnimalName(R.string.duck);
			duck.addAnimalName(R.string.duck_gr);
			duck.setAnimalVisualFile("duck");
			duck.setAnimalVisualFileSoundLang("duck");
			duck.addAudioFile("duck");
			addImageDetails(duck,
                    "https://www.flickr.com/photos/ben124/7449127466/in/photolist-cmfJ5b-n2mD63-rz32DJ-saAtok-uyVwU3-nDZsxn-dMuQrM-pZNzdm-dSKrNw-r9iCU1-qctQcR-4yN2Qs-qNC7F3-gwtDNK-pPJZqQ-4xGykM-nu1hA7-qRgPaR-g44G1c-pw7F4x-gNq6kQ-fmGXer-rDJzQn-6paARq-7AhWuk-daBXHt-jVJ9uK-mmG7oK-gNqbZC-dAa7n2-rq9oN5-hiHrhB-nf1eDD-7LGaD2-4mr9n3-iddEb3-dJtftL-oZfA5z-HWRDn-cmRK8u-5h2kE6-4qdnyk-3wCV3g-kmSK8e-95GMWt-ciNpjA-rvEixy-rACiBy-5WtgnK-ebk8iJ",
					"Berit Watkin",
					"https://www.flickr.com/photos/ben124/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, duck);
			
			// 16 CHIKEN
			Animal chicken = new Animal();
			chicken.addAnimalName(R.string.chicken);
			chicken.addAnimalName(R.string.chicken_gr);
			chicken.setAnimalVisualFile("chicken");
			chicken.setAnimalVisualFileSoundLang("chicken");
			chicken.addAudioFile("chiken");
			addImageDetails(chicken,
                    "https://www.flickr.com/photos/26279436@N02/7010916717/in/album-72157629292124488/",
					"Matt Davis",
					"https://www.flickr.com/photos/26279436@N02/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, chicken);
			
			// 86 DONKEY
			Animal donkey = new Animal();
			donkey.addAnimalName(R.string.donkey);
			donkey.addAnimalName(R.string.donkey_gr);
			donkey.setAnimalVisualFile("donkey");
			donkey.setAnimalVisualFileSoundLang("donkey");
			donkey.addAudioFile("donkey");
			addImageDetails(donkey
					,"https://www.flickr.com/photos/33852840@N06/3548774979/in/photolist-6pApav-9E1Bph-8m4vKc-2DfPfY-fU9UjA-btvAah-5MesVs-7b814D-85knFq-6DwbKW-7Y3ca2-6Ds35p-3qVctE-ecJMMw-6KLFPA-amYeTe-6K2aU5-dPc6qL-cCdSBS-4XYMYn-32Mj38-4iMPKF-3KDdTc-5TQY6j-8vk9df-2KjYYD-8T6pe5-nY4QB7-6Ywwxg-an21ZC-9Yuz9-39AULH-6L85VX-6ww3FG-qvKDqq-qxS37P-qgtTFE-nmr8sT-qgAdMx-qvKDmC-672YTd-4KzKAF-NxG6J-arjV5-qyNLGV-5TLCje-cqsfHj-qZLG4-C3N3G-6y4da5/"
					,"isamiga76"
					,"https://www.flickr.com/photos/33852840@N06/"
					,creativeLisenceBy
					);
			animals.put(tempArrayVariable++, donkey);
			
			// 82 WOLF
			Animal wolf = new Animal();
			wolf.addAnimalName(R.string.wolf);
			wolf.addAnimalName(R.string.wolf_gr);
			wolf.setAnimalVisualFile("wolf");
			wolf.setAnimalVisualFileSoundLang("wolf");
			wolf.addAudioFile("wolf");
			addImageDetails(wolf
					,"https://www.flickr.com/photos/max-goldberg/16936233026/in/photolist-rNAC2G-rQLXzU-5emeB1-74FNmZ-9YS55f-6uJNZ4-nJcnrJ-nJba8D-nYCfj1-o1yRuo-72XhJd-79jxA4-rjDGRg-74KZpq-fH95Du-5R4LQR-79jxAc-ryjVA9-8wPxJ5-cLZA93-boD49j-9sizKC-rQNU1K-9dmz2g-e8BWgY-eAZAyA-ryrtHH-rwyWkX-psgap6-inUgbF-rQLS7Q-rNAHkh-rNALe3-ryiLEd-qTTVej-ryiQ6G-ryiSz9-rwyRZH-ryjPNs-qU6xb6-74KGgJ-74KFtd-qFz14A-a5rZeR-8fxoc5-4xUeTy-pieV8-MGrpz-nDqPEL-74KG5S"
					,"Max Goldberg"
					,"https://www.flickr.com/photos/max-goldberg/"
					,creativeLisenceBy
					);
			animals.put(tempArrayVariable++, wolf);
			
			// 64 PIG
			Animal pig = new Animal();//< --- here  I am.
			pig.addAnimalName(R.string.pig);
			pig.addAnimalName(R.string.pig_gr);
			pig.addAudioFile("pig");
			pig.setAnimalVisualFile("pig");
			pig.setAnimalVisualFileSoundLang("pig");
			addImageDetails(pig
					,"https://www.flickr.com/photos/nsalt/2808207783/in/photolist-5h9Nkz-4B1csu-bkpgJL-qXwott-oGoxrz-BNcKW-iWv2gT-rMD8SX-5ypmXu-Mhhsd-rYogqK-5n6hjR-fn9Jc-apf8VN-hX6Mq-4je2DP-DRn2H-3wCZdT-s2if5B-iuL9V-MsFM-7FEQHe-7ZskDC-4o8aWM-4ppX6h-rxTJfy-7GEJvD-fa8RBD-t26u12-rmohrR-4ppXfC-jYse-5B8mLe-5dzMBA-a1PjXQ-nYVtz-pB3WR9-5fHE8G-63Nrwr-5B8mRv-dgdger-apcofM-5WXnBW-5ZF1LF-9k3oHh-a8oZU3-3cZNi-6p8fg9-dp1h2g-8cy7H"
					,"Nick Saltmarsh"
					,"https://www.flickr.com/photos/nsalt/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, pig);
			
			// 13 CAT
			Animal cat = new Animal();
			cat.addAnimalName(R.string.cat);
			cat.addAnimalName(R.string.cat_gr);
			cat.setAnimalVisualFile("cat");
			cat.setAnimalVisualFileSoundLang("cat");
			cat.addAudioFile("cat");
			addImageDetails(cat,
                    "https://commons.wikimedia.org/wiki/File:Spielendes_K%C3%A4tzchen.JPG",
					"Loliloli",
					"https://commons.wikimedia.org/w/index.php?title=User:Loliloli&action=edit&redlink=1",
					"https://commons.wikimedia.org/wiki/File:Spielendes_K%C3%A4tzchen.JPG");
			animals.put(tempArrayVariable++, cat);
			
			// 25 DOG TERRIER
			Animal dog_terrier = new Animal();
			dog_terrier.addAnimalName(R.string.dog_terrier);
			dog_terrier.addAnimalName(R.string.dog_terrier_gr);
			dog_terrier.setAnimalVisualFile("dog_terrier");
			dog_terrier.setAnimalVisualFileSoundLang("dog");
			dog_terrier.addAudioFile("dog");
			addImageDetails(dog_terrier,
                    "https://www.flickr.com/photos/annapanakova/15408006900/in/photolist-pty4Do-7BGGP-dHHsWL-pL2Lob-3pu45C-eERnP-7KMa1T-5PBQ9k-7MFnqH-eXt488-eg7a3b-65EZA9-6tCWQc-6rcr7C-drEG3-8cMyMk-5nXfNb-68mS5h-6uFWFk-4wfp32-5YgsNq-aazZft-7KPNxN-rYwpy6-5espk6-csvVi7-9nu8e2-d9QVDN-741Hvn-rLY3Ua-6YvgHD-aXqoHp-a4xvPZ-Asinj-5UUpjY-CEELJ-6wpWji-6WE2xG-6hdSo5-HF5BZ-TmHB6-7Nsfs9-dheXnW-HogXQ-pinu2-6ZtYEA-896utK-daYe4T-4oJbey-6oxN4X",
					"Anna Panáková",
					"https://www.flickr.com/photos/annapanakova/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, dog_terrier);
			
			// 65 RABBIT
			Animal rabbit = new Animal();
			rabbit.addAnimalName(R.string.rabbit);
			rabbit.addAnimalName(R.string.rabbit_gr);
			rabbit.addAudioFile("rabit");
			rabbit.setAnimalVisualFile("rabbit");
			rabbit.setAnimalVisualFileSoundLang("rabbit");
			addImageDetails(rabbit
					,"https://www.flickr.com/photos/jpockele/3746828860/in/photolist-6H6tFA-jQQGx8-aaMyUQ-nfmMgn-7SU1DT-dzsYSS-6nvKZH-x9rD4-77tnc2-7ncB3g-9HDdkZ-eKM7Zh-jbues-oeLCbv-ehSbe7-6NexNs-quijB-iHErPc-poFfVa-7jDvKi-b44bQn-jZp6p-neFPgq-7Yx4DB-7ncBqp-ataH3s-cMTWjG-7SHaQf-7SxgGJ-rwDSDx-6xs6Ec-7e7tg6-iqrXWT-oNwMN6-sAG5TS-gV2hu-2pX15C-sqiFY-oTic2-7ncJua-c3X1Ay-atFQH8-rACfBL-nNBSYb-CwnC2-7efXvh-ehU9QF-dBQqK-6FieGX-6znNq4"
					,"Jannes Pockele"
					,"https://www.flickr.com/photos/jpockele/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, rabbit);
			
			// 30 EAGLE
			Animal eagle_bold = new Animal();
			eagle_bold.addAnimalName(R.string.eagle_bold);
			eagle_bold.addAnimalName(R.string.eagle_bold_gr);
			eagle_bold.setAnimalVisualFile("eagle_bold");
			eagle_bold.setAnimalVisualFileSoundLang("eagle_bold");
			eagle_bold.addAudioFile("eagle");
			addImageDetails(eagle_bold,
                    "https://www.flickr.com/photos/usfwsmidwest/12973024833/in/photolist-kLo9iX-daQWoq-eetGE3-bBQpH9-kk8oBi-dFYrsw-8nzLh2-gG9mkD-cTHQ9o-pSBw6p-r3Vksr-4YtL3n-9Dawco-9D7BhK-6YxHKa-6ax588-bBkYmR-pXiHpA-str2Np-dtQKS9-dnHnBy-gi2H3x-mGw6cg-bW8jKY-a7V2gq-4Jr2qa-6UKpm4-4NW3zv-b4fuyF-mjyYur-d1NiUY-5jhEcF-8cRvq1-e32jh1-qnRD2m-bwofnK-6hri8Y-8yyNPw-b2HSKk-oSo2ce-ouwQ8n-o1oLeD-4SrwJz-jBMruY-qEKbfP-8eQLqN-e4qLgx-6KYL4M-4Asqxn-6p9eys",
					"USFWSmidwest/Stan Bousson",
					"https://www.flickr.com/photos/usfwsmidwest/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, eagle_bold);
			
			// 77 PROMO
			Animal swan = new Animal();
			swan.addAnimalName(R.string.promo);
			swan.addAnimalName(R.string.promo_gr);
			swan.setAnimalVisualFile("swan");
			swan.setAnimalVisualFileSoundLang("promo");
			swan.addAudioFile("empty");
			swan.setPromo(true);
			addImageDetails(swan
					,"https://www.flickr.com/photos/robin1966/15197564621/in/photolist-p9Xuue-2tibPG-k7P6Ug-69TKwQ-nXtFFH-mkD6WL-bGUWfa-dAFiez-9viFEH-6sX4iQ-daMPLF-qJBXGK-ehQ4CC-7RbGc3-waKf7-fSqC3W-6ZxZqb-2oLDYY-5T5Gtv-3VqSKo-6hmcqf-7X4RWs-g5KB1Y-g45cti-6ZKVjg-kcMQYr-cBfb2Y-nVvnyD-e4ZyaR-sMKE1L-ufhBcj-u5kFuw-vT49Nc-5UdCmn-bbyyFZ-9wX5RT-6sSVDz-jZFZZD-sMPzkp-bowCuP-sSENVi-bA3dfL-bFQooD-qXeDEZ-6SyS6f-8NShjQ-4uJd9M-fBLGxj-bU5Po4-98b3xC"
					,"Micolo J"
					,"https://www.flickr.com/photos/robin1966/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, swan);
			
			// 3 GRIZZLY
			Animal bear_grizzly = new Animal();
			bear_grizzly.addAnimalName(R.string.bear_grizzly);
			bear_grizzly.addAnimalName(R.string.bear_grizzly_gr);
			bear_grizzly.setAnimalVisualFile("bear_grizzly");
			bear_grizzly.setAnimalVisualFileSoundLang("bear_grizzly");
			bear_grizzly.addAudioFile("bear");
			
			bear_grizzly.imageDetails[0] = "https://www.flickr.com/photos/50838842@N06/6754978699/";
			bear_grizzly.imageDetails[1] = "U.S. Fish and Wildlife Service Headquarters";
			bear_grizzly.imageDetails[2] = "https://www.flickr.com/photos/usfwshq/";
			bear_grizzly.imageDetails[3] = creativeLisenceBy;
			
			animals.put(tempArrayVariable++, bear_grizzly);
			
			
			//PROMO
			Animal promo = new Animal();
			promo.addAnimalName(R.string.promo);
			promo.addAnimalName(R.string.promo_gr);
			promo.setAnimalVisualFile("dolphin");
			promo.setAnimalVisualFileSoundLang("promo");
			promo.addAudioFile("empty");
			promo.setPromo(true);
			addImageDetails(promo,
                    "https://www.flickr.com/photos/barachi/7961266942/in/photolist-d8vzi9-d7XESu-d4bSJu-d3AMy9-d3AMbd-4cv1Fe-mmyMn3-5Trw2v-9xvji2-cToaZo-cSMDGm-cSMzpd-bTXzec-aoaC1k-amM7W6-amiWP1-amg6Pa-amiRqE-akYELE-akYCxL-aeDNFF-ae9SjF-aecEFw-ae9PUT-aecCF7-aecCj1-ae9KC6-ae9JKg-ae9HQt-adzNaa-ac7kD3-dmQ5UF-aaraC3-4WNfRV-9CoHp3-75i6iN-69SfNt-69WrCb-69SfEp-67RDPK-jBJmMh-gFEkf6-bBjzhi-9Zcbhf-cnbYLQ-8n5re4-46MQum-oqF4mv-nx38tX-jeeonv",
					"barachihuang",
					"https://www.flickr.com/photos/barachi/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, promo);
			
			// 34 GOLD FISH
			Animal fish_goldfish = new Animal();
			fish_goldfish.addAnimalName(R.string.fish_goldfish);
			fish_goldfish.addAnimalName(R.string.fish_goldfish_gr);
			fish_goldfish.setAnimalVisualFile("fish_goldfish");
			fish_goldfish.setAnimalVisualFileSoundLang("fish_goldfish");
			fish_goldfish.addAudioFile("fish");
			addImageDetails(fish_goldfish
					,"https://www.flickr.com/photos/27330306@N08/3758613590/in/photolist-6J9fXU-6J8SSA-6J9b6A-6J9VwU-7iaGof-7p7GJw-6J9Nfm-db6rbC-7XMkpt-3gGRn9-6J5MWc-6J9uTq-6J58ca-6J8YB3-6J9tyC-6J9mJ1-3cAhvB-cm9Ku5-f6c3Xm-r3Ep5u-p5L3FA-fTuZv8-5mjDPg-hVRT7G-p5qxen-h8V2WV-hVSfuD-n22sCP-mhi2yK-shysC7-k6bCaD-vfPap3-oo65kZ-kLCQNZ-5jttpy-6mx6AU-4YvtP3-biCA5H-aN7Mkx-db9u4V-7NSDrD-7Na5jf-6GHihu-cCsU4h-aN7BdZ-czSS7Q-78JXhu-cCt6D5-cCsZgN-7NSDzF/"
					,"Kamillo Kluth"
					,"https://www.flickr.com/photos/27330306@N08/",
					creativeLisenceBy);
			animals.put(tempArrayVariable++, fish_goldfish);
			
			//PROMO
			Animal promo2 = new Animal();
			promo2.addAnimalName(R.string.promo);
			promo2.addAnimalName(R.string.promo_gr);
			promo2.setAnimalVisualFile("tiger");
			promo2.setAnimalVisualFileSoundLang("promo");
			promo2.addAudioFile("empty");
			promo2.setPromo(true);
			addImageDetails(promo2
					,"https://www.flickr.com/photos/mathiasappel/14806825806/in/photolist-oyqRs7-nuNp5f-bBrQj1-dyCJeY-wV8Nj1-5Pd8Fq-hEkKUW-3cNnP8-FxgaX-9gUaAh-nHjGLB-p3mGXB-fD73xb-npZy3g-9F2hFB-72xLS1-98aGRk-e23sza-pDhpCn-LgDGE-721SC4-6TBbS3-bnfUn8-j3hdG8-qa4LzP-5mf742-cGqrnw-uYMUA-bXeoq7-99AqGx-5fwvwA-9f5DjS-r6ovjv-hq4Qxi-qopqKf-xcfwi-8fQhTU-rJSg2-6spUPg-51vnqj-rKW3c-twnWDK-cy6Lsf-89Xr9m-EXFg-73yPF1-6kCoqQ-etpY51-aJR7KX-daQ3UD"
					,"Mathias Appel"
					,"https://www.flickr.com/photos/mathiasappel/"
					,creativeLisencePublicDomain
					);
			animals.put(tempArrayVariable++, promo2);
			
			
		}
	
	}

	private static void addImageDetails(Animal animal, String src,String authorName, String authorUrl, String lisence) {
		animal.imageDetails[0] = src;
		animal.imageDetails[1] = authorName;
		animal.imageDetails[2] = authorUrl;
		animal.imageDetails[3] = lisence;
	}



}
