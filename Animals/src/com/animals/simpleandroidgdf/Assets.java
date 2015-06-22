package com.animals.simpleandroidgdf;

import java.io.IOException;
import java.io.InputStream;

import com.animals.model.Animal;
import com.animals.util.UIButton;

import android.annotation.TargetApi;
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
	

	public static void load() {

		start = loadBitmap("start_button.png", false, false);
		startDown = loadBitmap("start_button_down.png", false, false);

		//carouzel_up1 = loadBitmap("carouzel_up.png", true, false);
		//carouzel_down1 = loadBitmap("carouzel_down.png", true, false);
		
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
				imageName = animals.get(key).getAnimalVisualFile();
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

	public static void playMusic2(String filename, boolean looping) {
		
		AssetFileDescriptor afd = null;

		Log.d("Assets", "playing music");
		if (mediaPlayer2 == null) {
			mediaPlayer2 = new MediaPlayer();
			mediaPlayer2.setAudioStreamType(AudioManager.STREAM_MUSIC);
			mediaPlayer2.setLooping(looping);
		
		}
		try {

			if (mediaPlayer2 != null) {
				mediaPlayer2.stop();
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
	}

	public static void playMusic3(String filename, boolean looping) {
	

		AssetFileDescriptor afd = null;

		Log.d("Assets", "playing music");
		if (mediaPlayer3 == null) {
			mediaPlayer3 = new MediaPlayer();
			mediaPlayer3.setAudioStreamType(AudioManager.STREAM_MUSIC);
			mediaPlayer3.setLooping(looping);
			
		}
		try {

			if (mediaPlayer3 != null) {
				mediaPlayer3.stop();
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
	}

	public static void onResume() {
		Log.d("Assets", "OnResume is called");
		//playMusic("animals.ogg", true);
		//playMusic("animals.mp3", true);
		playMusic("179_full_rollercoaster-fun_0121.mp3", true);
		
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
			mediaPlayer = null;
		}
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

	private static void loadCarouzelMap() {

		int tempArrayVariable = 1;

				
		// 1 ANT
		Animal ant = new Animal();
		ant.addAnimalName(R.string.ant);
		ant.addAnimalName(R.string.ant_gr);
		ant.setAnimalVisualFile("ant");
		ant.setAnimalVisualFileSoundLang("ant");
		ant.addAudioFile("empty");
		animals.put(tempArrayVariable++, ant);

		// 2 DEER
		Animal baby_dear = new Animal();
		baby_dear.addAnimalName(R.string.baby_dear);
		baby_dear.addAnimalName(R.string.baby_dear_gr);
		baby_dear.setAnimalVisualFile("baby_dear");
		baby_dear.setAnimalVisualFileSoundLang("baby_dear");
		baby_dear.addAudioFile("deer");
		animals.put(tempArrayVariable++, baby_dear);

		// 3 GRIZZLY
		Animal bear_grizzly = new Animal();
		bear_grizzly.addAnimalName(R.string.bear_grizzly);
		bear_grizzly.addAnimalName(R.string.bear_grizzly_gr);
		bear_grizzly.setAnimalVisualFile("bear_grizzly");
		bear_grizzly.setAnimalVisualFileSoundLang("bear_grizzly");
		bear_grizzly.addAudioFile("bear");
		animals.put(tempArrayVariable++, bear_grizzly);

		// 4 POLAR BEAR
		Animal bear_pollar = new Animal();
		bear_pollar.addAnimalName(R.string.bear_pollar);
		bear_pollar.addAnimalName(R.string.bear_pollar_gr);
		bear_pollar.setAnimalVisualFile("bear_pollar");
		bear_pollar.setAnimalVisualFileSoundLang("bear_pollar");
		bear_pollar.addAudioFile("bear");
		animals.put(tempArrayVariable++, bear_pollar);

		// 5 BAT
		Animal bird_bat = new Animal();
		bird_bat.addAnimalName(R.string.bird_bat);
		bird_bat.addAnimalName(R.string.bird_bat_gr);
		bird_bat.setAnimalVisualFile("bird_bat");
		bird_bat.setAnimalVisualFileSoundLang("bird_bat");
		bird_bat.addAudioFile("bat");
		animals.put(tempArrayVariable++, bird_bat);

		// 6 CANARY
		Animal bird_canary = new Animal();
		bird_canary.addAnimalName(R.string.bird_canary);
		bird_canary.addAnimalName(R.string.bird_canary_gr);
		bird_canary.setAnimalVisualFile("bird_canary");
		bird_canary.setAnimalVisualFileSoundLang("bird_canary");
		bird_canary.addAudioFile("canary");
		animals.put(tempArrayVariable++, bird_canary);

		// 7 NIGHTGALE
		Animal bird_nightingale = new Animal();
		bird_nightingale.addAnimalName(R.string.bird_nightingale);
		bird_nightingale.addAnimalName(R.string.bird_nightingale_gr);
		bird_nightingale.setAnimalVisualFile("bird_nightingale");
		bird_nightingale.setAnimalVisualFileSoundLang("bird_nightingale");
		bird_nightingale.addAudioFile("canary");
		animals.put(tempArrayVariable++, bird_nightingale);

		// 8 BISON
		Animal bison = new Animal();
		bison.addAnimalName(R.string.bison);
		bison.addAnimalName(R.string.bison_gr);
		bison.setAnimalVisualFile("bison");
		bison.setAnimalVisualFileSoundLang("bison");
		bison.addAudioFile("bison");
		animals.put(tempArrayVariable++, bison);

		// 9 BLACK PANTHER
		Animal Black_panther = new Animal();
		Black_panther.addAnimalName(R.string.Black_panther);
		Black_panther.addAnimalName(R.string.Black_panther_gr);
		Black_panther.setAnimalVisualFile("Black_panther");
		Black_panther.setAnimalVisualFileSoundLang("Black_panther");
		Black_panther.addAudioFile("tiger");
		animals.put(tempArrayVariable++, Black_panther);

		// 10 BULL
		Animal Bull = new Animal();
		Bull.addAnimalName(R.string.Bull);
		Bull.addAnimalName(R.string.Bull_gr);
		Bull.setAnimalVisualFile("Bull");
		Bull.setAnimalVisualFileSoundLang("Bull");
		Bull.addAudioFile("cow");
		animals.put(tempArrayVariable++, Bull);

		// 11 BATTERFLY
		Animal butterfly = new Animal();
		butterfly.addAnimalName(R.string.butterfly);
		butterfly.addAnimalName(R.string.butterfly_gr);
		butterfly.setAnimalVisualFile("butterfly");
		butterfly.setAnimalVisualFileSoundLang("butterfly");
		butterfly.addAudioFile("empty");
		animals.put(tempArrayVariable++, butterfly);

		// 12 CAMEL
		Animal camel = new Animal();
		camel.addAnimalName(R.string.camel);
		camel.addAnimalName(R.string.camel_gr);
		camel.setAnimalVisualFile("camel");
		camel.setAnimalVisualFileSoundLang("camel");
		camel.addAudioFile("camel");
		animals.put(tempArrayVariable++, camel);

		// 13 CAT
		Animal cat = new Animal();
		cat.addAnimalName(R.string.cat);
		cat.addAnimalName(R.string.cat_gr);
		cat.setAnimalVisualFile("cat");
		cat.setAnimalVisualFileSoundLang("cat");
		cat.addAudioFile("cat");
		animals.put(tempArrayVariable++, cat);

		// 14 CAT FACE
		Animal cat_face = new Animal();
		cat_face.addAnimalName(R.string.cat_face);
		cat_face.addAnimalName(R.string.cat_face_gr);
		cat_face.setAnimalVisualFile("cat_face");
		cat_face.setAnimalVisualFileSoundLang("cat");
		cat_face.addAudioFile("cat");
		animals.put(tempArrayVariable++, cat_face);

		// 15 CAT SIAM
		Animal cat_siam = new Animal();
		cat_siam.addAnimalName(R.string.cat_siam);
		cat_siam.addAnimalName(R.string.cat_siam_gr);
		cat_siam.setAnimalVisualFile("cat_siam");
		cat_siam.setAnimalVisualFileSoundLang("cat");
		cat_siam.addAudioFile("cat");
		animals.put(tempArrayVariable++, cat_siam);

		// 16 CHIKEN
		Animal chicken = new Animal();
		chicken.addAnimalName(R.string.chicken);
		chicken.addAnimalName(R.string.chicken_gr);
		chicken.setAnimalVisualFile("chicken");
		chicken.setAnimalVisualFileSoundLang("chicken");
		chicken.addAudioFile("chiken");
		animals.put(tempArrayVariable++, chicken);

		// 17 CHICKS
		Animal chicks = new Animal();
		chicks.addAnimalName(R.string.chicks);
		chicks.addAnimalName(R.string.chicks_gr);
		chicks.setAnimalVisualFile("chicks");
		chicks.setAnimalVisualFileSoundLang("chicks");
		chicks.addAudioFile("chiken");
		animals.put(tempArrayVariable++, chicks);

		// 18 CHIPMANK
		Animal chipmank = new Animal();
		chipmank.addAnimalName(R.string.chipmank);
		chipmank.addAnimalName(R.string.chipmank_gr);
		chipmank.setAnimalVisualFile("chipmank");
		chipmank.setAnimalVisualFileSoundLang("chipmank");
		chipmank.addAudioFile("Chipmunk");
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
		animals.put(tempArrayVariable++, Cow_female_black_white);

		// 20 CRAB
		Animal crab = new Animal();
		crab.addAnimalName(R.string.crab);
		crab.addAnimalName(R.string.crab_gr);
		crab.setAnimalVisualFile("crab");
		crab.setAnimalVisualFileSoundLang("crab");
		crab.addAudioFile("fish");
		animals.put(tempArrayVariable++, crab);

		// 21 CROCODILE
		Animal crocodile = new Animal();
		crocodile.addAnimalName(R.string.crocodile);
		crocodile.addAnimalName(R.string.crocodile_gr);
		crocodile.setAnimalVisualFile("crocodile");
		crocodile.setAnimalVisualFileSoundLang("crocodile");
		crocodile.addAudioFile("crocodile");
		animals.put(tempArrayVariable++, crocodile);

		// 22 CROW
		Animal crow = new Animal();
		crow.addAnimalName(R.string.crow);
		crow.addAnimalName(R.string.crow_gr);
		crow.setAnimalVisualFile("crow");
		crow.setAnimalVisualFileSoundLang("crow");
		crow.addAudioFile("crow");
		animals.put(tempArrayVariable++, crow);

		// 23 DOG GERMAN SHEPARD
		Animal dog_german_shepard = new Animal();
		dog_german_shepard.addAnimalName(R.string.dog_german_shepard);
		dog_german_shepard.addAnimalName(R.string.dog_german_shepard_gr);
		dog_german_shepard.setAnimalVisualFile("dog_german_shepard");
		dog_german_shepard.setAnimalVisualFileSoundLang("dog");
		dog_german_shepard.addAudioFile("dog");
		animals.put(tempArrayVariable++, dog_german_shepard);

		// 24 DOG LASSIE
		Animal dog_lassie = new Animal();
		dog_lassie.addAnimalName(R.string.dog_lassie);
		dog_lassie.addAnimalName(R.string.dog_lassie_gr);
		dog_lassie.setAnimalVisualFile("dog_lassie");
		dog_lassie.setAnimalVisualFileSoundLang("dog");
		dog_lassie.addAudioFile("dog");
		animals.put(tempArrayVariable++, dog_lassie);

		// 25 DOG TERRIER
		Animal dog_terrier = new Animal();
		dog_terrier.addAnimalName(R.string.dog_terrier);
		dog_terrier.addAnimalName(R.string.dog_terrier_gr);
		dog_terrier.setAnimalVisualFile("dog_terrier");
		dog_terrier.setAnimalVisualFileSoundLang("dog");
		dog_terrier.addAudioFile("dog");
		animals.put(tempArrayVariable++, dog_terrier);

		// 26 DOLPHIN
		Animal dolphin = new Animal();
		dolphin.addAnimalName(R.string.dolphin);
		dolphin.addAnimalName(R.string.dolphin_gr);
		dolphin.setAnimalVisualFile("dolphin");
		dolphin.setAnimalVisualFileSoundLang("dolphin");
		dolphin.addAudioFile("dolphin");
		animals.put(tempArrayVariable++, dolphin);

		// 27 DOVE
		Animal dove = new Animal();
		dove.addAnimalName(R.string.dove);
		dove.addAnimalName(R.string.dove_gr);
		dove.setAnimalVisualFile("dove");
		dove.setAnimalVisualFileSoundLang("dove");
		dove.addAudioFile("dove");
		animals.put(tempArrayVariable++, dove);

		// 28 DRAGONFLY
		Animal dragonfly = new Animal();
		dragonfly.addAnimalName(R.string.dragonfly);
		dragonfly.addAnimalName(R.string.dragonfly_gr);
		dragonfly.setAnimalVisualFile("dragonfly");
		dragonfly.setAnimalVisualFileSoundLang("dragonfly");
		dragonfly.addAudioFile("mosquito");
		animals.put(tempArrayVariable++, dragonfly);

		// 29 DUCK
		Animal duck = new Animal();
		duck.addAnimalName(R.string.duck);
		duck.addAnimalName(R.string.duck_gr);
		duck.setAnimalVisualFile("duck");
		duck.setAnimalVisualFileSoundLang("duck");
		duck.addAudioFile("duck");
		animals.put(tempArrayVariable++, duck);

		// 30 EAGLE
		Animal eagle_bold = new Animal();
		eagle_bold.addAnimalName(R.string.eagle_bold);
		eagle_bold.addAnimalName(R.string.eagle_bold_gr);
		eagle_bold.setAnimalVisualFile("eagle_bold");
		eagle_bold.setAnimalVisualFileSoundLang("eagle_bold");
		eagle_bold.addAudioFile("eagle");
		animals.put(tempArrayVariable++, eagle_bold);

		// 31 ELEPHANT
		Animal elephant = new Animal();
		elephant.addAnimalName(R.string.elephant);
		elephant.addAnimalName(R.string.elephant_gr);
		elephant.setAnimalVisualFile("elephant");
		elephant.setAnimalVisualFileSoundLang("elephant");
		elephant.addAudioFile("elephant");
		animals.put(tempArrayVariable++, elephant);

		// 32 ELK
		Animal elk = new Animal();
		elk.addAnimalName(R.string.elk);
		elk.addAnimalName(R.string.elk_gr);
		elk.setAnimalVisualFile("elk");
		elk.setAnimalVisualFileSoundLang("elk");
		elk.addAudioFile("elk");
		animals.put(tempArrayVariable++, elk);

		// 33 CLOWN FISH
		Animal fish_clown = new Animal();
		fish_clown.addAnimalName(R.string.fish_clown);
		fish_clown.addAnimalName(R.string.fish_clown_gr);
		fish_clown.setAnimalVisualFile("fish_clown");
		fish_clown.setAnimalVisualFileSoundLang("fish_clown");
		fish_clown.addAudioFile("fish");
		animals.put(tempArrayVariable++, fish_clown);

		// 34 GOLD FISH
		Animal fish_goldfish = new Animal();
		fish_goldfish.addAnimalName(R.string.fish_goldfish);
		fish_goldfish.addAnimalName(R.string.fish_goldfish_gr);
		fish_goldfish.setAnimalVisualFile("fish_goldfish");
		fish_goldfish.setAnimalVisualFileSoundLang("fish_goldfish");
		fish_goldfish.addAudioFile("fish");
		animals.put(tempArrayVariable++, fish_goldfish);

		// 35 SCORPION FISH
		Animal fish_scorpion = new Animal();
		fish_scorpion.addAnimalName(R.string.fish_scorpion);
		fish_scorpion.addAnimalName(R.string.fish_scorpion_gr);
		fish_scorpion.setAnimalVisualFile("fish_scorpion");
		fish_scorpion.setAnimalVisualFileSoundLang("fish_scorpion");
		fish_scorpion.addAudioFile("fish");
		animals.put(tempArrayVariable++, fish_scorpion);

		// 36 FOX
		Animal fox = new Animal();
		fox.addAnimalName(R.string.fox);
		fox.addAnimalName(R.string.fox_gr);
		fox.setAnimalVisualFile("fox");
		fox.setAnimalVisualFileSoundLang("fox");
		fox.addAudioFile("fox");
		animals.put(tempArrayVariable++, fox);

		// 37 FROG
		Animal frog = new Animal();
		frog.addAnimalName(R.string.frog);
		frog.addAnimalName(R.string.frog_gr);
		frog.setAnimalVisualFile("frog");
		frog.setAnimalVisualFileSoundLang("frog");
		frog.addAudioFile("frog");
		animals.put(tempArrayVariable++, frog);

		// 38 GIRAFFE
		Animal giraffe = new Animal();
		giraffe.addAnimalName(R.string.giraffe);
		giraffe.addAnimalName(R.string.giraffe_gr);
		giraffe.setAnimalVisualFile("giraffe");
		giraffe.setAnimalVisualFileSoundLang("giraffe");
		giraffe.addAudioFile("giraffe");
		animals.put(tempArrayVariable++, giraffe);

		// 39 GOAT
		Animal goat = new Animal();
		goat.addAnimalName(R.string.goat);
		goat.addAnimalName(R.string.goat_gr);
		goat.setAnimalVisualFile("goat");
		goat.setAnimalVisualFileSoundLang("goat");
		goat.addAudioFile("goat");
		animals.put(tempArrayVariable++, goat);

		// 40 GRASSHOPER
		Animal grasshoper = new Animal();
		grasshoper.addAnimalName(R.string.grasshoper);
		grasshoper.addAnimalName(R.string.grasshoper_gr);
		grasshoper.setAnimalVisualFile("grasshoper");
		grasshoper.setAnimalVisualFileSoundLang("grasshoper");
		grasshoper.addAudioFile("grasshopper");
		animals.put(tempArrayVariable++, grasshoper);

		// 41 GUINEA PIG
		Animal guinea_pig = new Animal();
		guinea_pig.addAnimalName(R.string.guinea_pig);
		guinea_pig.addAnimalName(R.string.guinea_pig_gr);
		guinea_pig.setAnimalVisualFile("guinea_pig");
		guinea_pig.setAnimalVisualFileSoundLang("guinea_pig");
		guinea_pig.addAudioFile("mouse");
		animals.put(tempArrayVariable++, guinea_pig);

		// 42 HEDGEHOG
		Animal hedgehog = new Animal();
		hedgehog.addAnimalName(R.string.hedgehog);
		hedgehog.addAnimalName(R.string.hedgehog_gr);
		hedgehog.setAnimalVisualFile("hedgehog");
		hedgehog.setAnimalVisualFileSoundLang("hedgehog");
		hedgehog.addAudioFile("hedgehog");
		animals.put(tempArrayVariable++, hedgehog);

		// 43 HORSE
		Animal horse = new Animal();
		horse.addAnimalName(R.string.horse);
		horse.addAnimalName(R.string.horse_gr);
		horse.setAnimalVisualFile("horse");
		horse.setAnimalVisualFileSoundLang("horse");
		horse.addAudioFile("horse");
		animals.put(tempArrayVariable++, horse);

		// 44 BEE
		Animal insect_bee = new Animal();
		insect_bee.addAnimalName(R.string.insect_bee);
		insect_bee.addAnimalName(R.string.insect_bee_gr);
		insect_bee.setAnimalVisualFile("insect_bee");
		insect_bee.setAnimalVisualFileSoundLang("insect_bee");
		insect_bee.addAudioFile("mosquito");
		animals.put(tempArrayVariable++, insect_bee);

		// 45 KANGAROO
		Animal Kangaroo = new Animal();
		Kangaroo.addAnimalName(R.string.Kangaroo);
		Kangaroo.addAnimalName(R.string.Kangaroo_gr);
		Kangaroo.setAnimalVisualFile("Kangaroo");
		Kangaroo.setAnimalVisualFileSoundLang("Kangaroo");
		Kangaroo.addAudioFile("spring");
		animals.put(tempArrayVariable++, Kangaroo);

		// 46 KOALA
		Animal koala = new Animal();
		koala.addAnimalName(R.string.koala);
		koala.addAnimalName(R.string.koala_gr);
		koala.setAnimalVisualFile("koala");
		koala.setAnimalVisualFileSoundLang("koala");
		koala.addAudioFile("koala");
		animals.put(tempArrayVariable++, koala);

		// 47 LADYBUG
		Animal ladybug = new Animal();
		ladybug.addAnimalName(R.string.ladybug);
		ladybug.addAnimalName(R.string.ladybug_gr);
		ladybug.setAnimalVisualFile("ladybug");
		ladybug.setAnimalVisualFileSoundLang("ladybug");
		ladybug.addAudioFile("fly");

		animals.put(tempArrayVariable++, ladybug);

		// 48 LAMB
		Animal lamb = new Animal();
		lamb.addAnimalName(R.string.lamb);
		lamb.addAnimalName(R.string.lamb_gr);
		lamb.setAnimalVisualFile("lamb");
		lamb.setAnimalVisualFileSoundLang("lamb");
		lamb.addAudioFile("goat");
		animals.put(tempArrayVariable++, lamb);

		// 49 LEOPARD
		Animal leopard = new Animal();
		leopard.addAnimalName(R.string.leopard);
		leopard.addAnimalName(R.string.leopard_gr);
		leopard.setAnimalVisualFile("leopard");
		leopard.setAnimalVisualFileSoundLang("leopard");
		leopard.addAudioFile("tiger");
		animals.put(tempArrayVariable++, leopard);

		// 50 LION
		Animal lion = new Animal();
		lion.addAnimalName(R.string.lion);
		lion.addAnimalName(R.string.lion_gr);
		lion.setAnimalVisualFile("lion");
		lion.setAnimalVisualFileSoundLang("lion");
		lion.addAudioFile("lion");
		animals.put(tempArrayVariable++, lion);

		// 51 IGOUANA
		Animal lizard_Igouana = new Animal();
		lizard_Igouana.addAnimalName(R.string.lizard_Igouana);
		lizard_Igouana.addAnimalName(R.string.lizard_Igouana_gr);
		lizard_Igouana.setAnimalVisualFile("lizard_Igouana");
		lizard_Igouana.setAnimalVisualFileSoundLang("lizard_Igouana");
		lizard_Igouana.addAudioFile("reptile");
		animals.put(tempArrayVariable++, lizard_Igouana);

		// 52 LIZARD
		Animal lizard = new Animal();
		lizard.addAnimalName(R.string.lizard);
		lizard.addAnimalName(R.string.lizard_gr);
		lizard.setAnimalVisualFile("lizard");
		lizard.setAnimalVisualFileSoundLang("lizard");
		lizard.addAudioFile("reptile");
		animals.put(tempArrayVariable++, lizard);

		// 53 LOBSTER
		Animal lobster = new Animal();
		lobster.addAnimalName(R.string.lobster);
		lobster.addAnimalName(R.string.lobster_gr);
		lobster.setAnimalVisualFile("lobster");
		lobster.setAnimalVisualFileSoundLang("lobster");
		lobster.addAudioFile("fish");
		animals.put(tempArrayVariable++, lobster);

		// 54 MONKEY
		Animal monkey = new Animal();
		monkey.addAnimalName(R.string.monkey);
		monkey.addAnimalName(R.string.monkey_gr);
		monkey.setAnimalVisualFile("monkey");
		monkey.setAnimalVisualFileSoundLang("monkey");
		monkey.addAudioFile("monkey");
		animals.put(tempArrayVariable++, monkey);

		// 55 MOOSE
		Animal moose = new Animal();
		moose.addAnimalName(R.string.moose);
		moose.addAnimalName(R.string.moose_gr);
		moose.setAnimalVisualFile("moose");
		moose.setAnimalVisualFileSoundLang("moose");
		moose.addAudioFile("moose");
		animals.put(tempArrayVariable++, moose);

		// 56 MOSQUITO
		Animal mosquito = new Animal();
		mosquito.addAnimalName(R.string.mosquito);
		mosquito.addAnimalName(R.string.mosquito_gr);
		mosquito.setAnimalVisualFile("mosquito");
		mosquito.setAnimalVisualFileSoundLang("mosquito");
		mosquito.addAudioFile("mosquito");
		animals.put(tempArrayVariable++, mosquito);

		// 57 MOUSE
		Animal mouse_field = new Animal();
		mouse_field.addAnimalName(R.string.mouse_field);
		mouse_field.addAnimalName(R.string.mouse_field_gr);
		mouse_field.setAnimalVisualFile("mouse_field");
		mouse_field.setAnimalVisualFileSoundLang("mouse_field");
		mouse_field.addAudioFile("mouse");
		animals.put(tempArrayVariable++, mouse_field);

		// 58 ORCA
		Animal orca = new Animal();
		orca.addAnimalName(R.string.orca);
		orca.addAnimalName(R.string.orca_gr);
		orca.setAnimalVisualFile("orca");
		orca.setAnimalVisualFileSoundLang("orca");
		orca.addAudioFile("orca");
		animals.put(tempArrayVariable++, orca);

		// 59 OWL
		Animal owl = new Animal();
		owl.addAnimalName(R.string.owl);
		owl.addAnimalName(R.string.owl_gr);
		owl.setAnimalVisualFile("owl");
		owl.setAnimalVisualFileSoundLang("owl");
		owl.addAudioFile("owl");
		animals.put(tempArrayVariable++, owl);

		// 60 PANDA
		Animal panda = new Animal();
		panda.addAnimalName(R.string.panda);
		panda.addAnimalName(R.string.panda_gr);
		panda.setAnimalVisualFile("panda");
		panda.setAnimalVisualFileSoundLang("panda");
		panda.addAudioFile("panda");
		animals.put(tempArrayVariable++, panda);

		// 61 PARROT
		Animal parrot = new Animal();
		parrot.addAnimalName(R.string.parrot);
		parrot.addAnimalName(R.string.parrot_gr);
		parrot.setAnimalVisualFile("parrot");
		parrot.setAnimalVisualFileSoundLang("parrot");
		parrot.addAudioFile("parrot");
		animals.put(tempArrayVariable++, parrot);

		// 62 PEACOCK
		Animal peacock = new Animal();
		peacock.addAnimalName(R.string.peacock);
		peacock.addAnimalName(R.string.peacock_gr);
		peacock.addAudioFile("peacock");
		peacock.setAnimalVisualFile("peacock");
		peacock.setAnimalVisualFileSoundLang("peacock");
		animals.put(tempArrayVariable++, peacock);

		// 63 PENGUIN
		Animal penguin = new Animal();
		penguin.addAnimalName(R.string.penguin);
		penguin.addAnimalName(R.string.penguin_gr);
		penguin.addAudioFile("penguin");
		penguin.setAnimalVisualFile("penguin");
		penguin.setAnimalVisualFileSoundLang("penguin");
		animals.put(tempArrayVariable++, penguin);

		// 64 PIG
		Animal pig = new Animal();
		pig.addAnimalName(R.string.pig);
		pig.addAnimalName(R.string.pig_gr);
		pig.addAudioFile("pig");
		pig.setAnimalVisualFile("pig");
		pig.setAnimalVisualFileSoundLang("pig");
		animals.put(tempArrayVariable++, pig);

		// 65 RABBIT
		Animal rabbit = new Animal();
		rabbit.addAnimalName(R.string.rabbit);
		rabbit.addAnimalName(R.string.rabbit_gr);
		rabbit.addAudioFile("rabit");
		rabbit.setAnimalVisualFile("rabbit");
		rabbit.setAnimalVisualFileSoundLang("rabbit");
		animals.put(tempArrayVariable++, rabbit);

		// 66 RABBIT2
		Animal rabbit2 = new Animal();
		rabbit2.addAnimalName(R.string.rabbit2);
		rabbit2.addAnimalName(R.string.rabbit2_gr);
		rabbit2.addAudioFile("rabit");
		rabbit2.setAnimalVisualFile("rabbit2");
		rabbit2.setAnimalVisualFileSoundLang("rabbit");
		animals.put(tempArrayVariable++, rabbit2);

		// 67 RACOON
		Animal racoon = new Animal();
		racoon.addAnimalName(R.string.racoon);
		racoon.addAnimalName(R.string.racoon_gr);
		racoon.addAudioFile("racoon");
		racoon.setAnimalVisualFile("racoon");
		racoon.setAnimalVisualFileSoundLang("racoon");
		animals.put(tempArrayVariable++, racoon);

		// 68 RHINO
		Animal rhino = new Animal();
		rhino.addAnimalName(R.string.rhino);
		rhino.addAnimalName(R.string.rhino_gr);
		rhino.addAudioFile("rhino");
		rhino.setAnimalVisualFile("rhino");
		rhino.setAnimalVisualFileSoundLang("rhino");
		animals.put(tempArrayVariable++, rhino);

		// 69 ROOSTER
		Animal rooster = new Animal();
		rooster.addAnimalName(R.string.rooster);
		rooster.addAnimalName(R.string.rooster_gr);
		rooster.addAudioFile("Rooster");
		rooster.setAnimalVisualFile("rooster");
		rooster.setAnimalVisualFileSoundLang("rooster");
		animals.put(tempArrayVariable++, rooster);

		// 70 SEA LION
		Animal sea_lion = new Animal();
		sea_lion.addAnimalName(R.string.sea_lion);
		sea_lion.addAnimalName(R.string.sea_lion_gr);
		sea_lion.addAudioFile("sea_lion");
		sea_lion.setAnimalVisualFile("sea_lion");
		sea_lion.setAnimalVisualFileSoundLang("sea_lion");
		animals.put(tempArrayVariable++, sea_lion);

		// 71 SHARK
		Animal shark = new Animal();
		shark.addAnimalName(R.string.shark);
		shark.addAnimalName(R.string.shark_gr);
		shark.addAudioFile("fish");
		shark.setAnimalVisualFile("shark");
		shark.setAnimalVisualFileSoundLang("shark");
		animals.put(tempArrayVariable++, shark);

		// 72 SHRIMP
		Animal shrimp = new Animal();
		shrimp.addAnimalName(R.string.shrimp);
		shrimp.addAnimalName(R.string.shrimp_gr);
		shrimp.setAnimalVisualFile("shrimp");
		shrimp.setAnimalVisualFileSoundLang("shrimp");
		shrimp.addAudioFile("fish");
		animals.put(tempArrayVariable++, shrimp);

		// 73 SNAIL
		Animal snail = new Animal();
		snail.setAnimalVisualFile("snail");
		snail.setAnimalVisualFileSoundLang("snail");
		snail.addAnimalName(R.string.snail);
		snail.addAnimalName(R.string.snail_gr);
		snail.addAudioFile("empty");
		animals.put(tempArrayVariable++, snail);

		// 74 SNAKE
		Animal snake = new Animal();
		snake.addAnimalName(R.string.snake);
		snake.addAnimalName(R.string.snake_gr);
		snake.setAnimalVisualFile("snake");
		snake.setAnimalVisualFileSoundLang("snake");
		snake.addAudioFile("snake");
		animals.put(tempArrayVariable++, snake);

		// 75 SPIDER
		Animal spider = new Animal();
		spider.addAnimalName(R.string.spider);
		spider.addAnimalName(R.string.spider_gr);
		spider.setAnimalVisualFile("spider");
		spider.setAnimalVisualFileSoundLang("spider");
		spider.addAudioFile("empty");
		animals.put(tempArrayVariable++, spider);

		// 76 STARFISH
		Animal starfish = new Animal();
		starfish.addAnimalName(R.string.starfish);
		starfish.addAnimalName(R.string.starfish_gr);
		starfish.setAnimalVisualFile("starfish");
		starfish.setAnimalVisualFileSoundLang("starfish");
		starfish.addAudioFile("fish");
		animals.put(tempArrayVariable++, starfish);

		// 77 SWAN
		Animal swan = new Animal();
		swan.addAnimalName(R.string.swan);
		swan.addAnimalName(R.string.swan_gr);
		swan.setAnimalVisualFile("swan");
		swan.setAnimalVisualFileSoundLang("swan");
		swan.addAudioFile("swan");
		animals.put(tempArrayVariable++, swan);

		// 78 SWORDFISH
		Animal swordfish = new Animal();
		swordfish.addAnimalName(R.string.swordfish);
		swordfish.addAnimalName(R.string.swordfish_gr);
		swordfish.setAnimalVisualFile("swordfish");
		swordfish.setAnimalVisualFileSoundLang("swordfish");
		swordfish.addAudioFile("fish");
		animals.put(tempArrayVariable++, swordfish);

		// 79 TIGER
		Animal tiger = new Animal();
		tiger.addAnimalName(R.string.tiger);
		tiger.addAnimalName(R.string.tiger_gr);
		tiger.setAnimalVisualFile("tiger");
		tiger.setAnimalVisualFileSoundLang("tiger");
		tiger.addAudioFile("tiger");
		animals.put(tempArrayVariable++, tiger);

		// 80 TIGER
		Animal turkey = new Animal();
		turkey.addAnimalName(R.string.turkey);
		turkey.addAnimalName(R.string.turkey_gr);
		turkey.setAnimalVisualFile("turkey");
		turkey.setAnimalVisualFileSoundLang("turkey");
		turkey.addAudioFile("turkey");
		animals.put(tempArrayVariable++, turkey);

		// 81 TURTLE
		Animal turtle = new Animal();
		turtle.addAnimalName(R.string.turtle);
		turtle.addAnimalName(R.string.turtle_gr);
		turtle.setAnimalVisualFile("turtle");
		turtle.setAnimalVisualFileSoundLang("turtle");
		turtle.addAudioFile("fish");
		animals.put(tempArrayVariable++, turtle);

		// 82carouzelMap.put(tempVariable++, "wolf");
		Animal wolf = new Animal();
		wolf.addAnimalName(R.string.wolf);
		wolf.addAnimalName(R.string.wolf_gr);
		wolf.setAnimalVisualFile("wolf");
		wolf.setAnimalVisualFileSoundLang("wolf");
		wolf.addAudioFile("wolf");
		animals.put(tempArrayVariable++, wolf);

		// 83 ZEBRA
		Animal zebra = new Animal();
		zebra.addAnimalName(R.string.zebra);
		zebra.addAnimalName(R.string.zebra_gr);
		zebra.setAnimalVisualFile("zebra");
		zebra.setAnimalVisualFileSoundLang("zebra");
		zebra.addAudioFile("zebra");
		animals.put(tempArrayVariable++, zebra);

		// 84 SEAGULL
		Animal sea_gull = new Animal();
		sea_gull.addAnimalName(R.string.sea_gull);
		sea_gull.addAnimalName(R.string.sea_gull_gr);
		sea_gull.setAnimalVisualFile("sea_gull");
		sea_gull.setAnimalVisualFileSoundLang("sea_gull");
		sea_gull.addAudioFile("seagull");
		animals.put(tempArrayVariable++, sea_gull);

		// 85 HIPPO
		Animal hippo = new Animal();
		hippo.addAnimalName(R.string.hippo);
		hippo.addAnimalName(R.string.hippo_gr);
		hippo.setAnimalVisualFile("hippo");
		hippo.setAnimalVisualFileSoundLang("hippo");
		hippo.addAudioFile("hippo");
		animals.put(tempArrayVariable++, hippo);

		// 86 DONKEY
		Animal donkey = new Animal();
		donkey.addAnimalName(R.string.donkey);
		donkey.addAnimalName(R.string.donkey_gr);
		donkey.setAnimalVisualFile("donkey");
		donkey.setAnimalVisualFileSoundLang("donkey");
		donkey.addAudioFile("donkey");
		animals.put(tempArrayVariable++, donkey);

	}



}
