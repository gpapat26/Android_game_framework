package com.animals.simpleandroidgdf;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;




import com.animals.model.Animal;

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
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.os.Build;
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
	public static int streamIDplaying=0;
	
	public static Bitmap language;
	public static Bitmap language_down;
	
	public static Bitmap greek;
	public static Bitmap greek_down;
	
	public static Bitmap english;
	public static Bitmap english_down;
	
	//private static HashMap<Integer, String> carouzelMap = new HashMap<Integer, String>();
	public static HashMap<Integer, Animal> animals = new HashMap<Integer, Animal>();
	//private static Animal[] animals = new Animal[86];	
	
	private static MediaPlayer mediaPlayer;
	
	
	public static void load(){
		//buttons and resources used all over the game
		start = loadBitmap("start_button.png",false,false);
		startDown = loadBitmap("start_button_down.png",false,false);
		
		carouzel_up = loadBitmap("carouzel_up.png",true,false);
		carouzel_down = loadBitmap("carouzel_down.png",true,false);
		
//		carouzel_left = loadBitmap("carouzel_left.png",true,false);
//		carouzel_left_down = loadBitmap("carouzel_left_down.png",true,false);
		
		carouzel_left = loadBitmap("carouzel_previous.png",true,false);
		carouzel_left_down = loadBitmap("carouzel_prev_down.png",true,false);
		
//		carouzel_right = loadBitmap("carouzel_right.png",true,false);
//		carouzel_right_down = loadBitmap("carouzel_right_down.png",true,false);
		
		carouzel_right = loadBitmap("carouzel_next.png",true,false);
		carouzel_right_down = loadBitmap("carouzel_next_down.png",true,false);
		
		language = loadBitmap("Language.png",true,false);
		language_down = loadBitmap("Language_down.png",true,false);
		
		
		greek = loadBitmap("greek_button.png",true,false);
		greek_down = loadBitmap("greek_button_down.png",true,false);
		
		english = loadBitmap("english_button.png",true,false);
		english_down = loadBitmap("english_button_down.png",true,false);
		
		loadCarouzelMap();
	}
	
	public static int getSizeOfGallery(){
		if(animals!= null){
		//if(carouzelMap!= null){
			//return carouzelMap.size();
			return animals.size();
		}
		return 0;
	}
	
	public static void loadGalleryImageResolver(int key){
		 if(key <=getSizeOfGallery() && key>=0){
			// String imageName= carouzelMap.get(key);
			 String imageName = null;
			 try{
				  imageName= animals.get(key).getAnimalVisualFile();
				  loadGalleryImage(imageName);
			 }
			 catch(Exception e){
				 Log.d("Assets", "Error loading gallery resource with id :"+key);
			 }
			 
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
		
	public static void playGallerySounds(String soundFileName){
		int id =loadSound(soundFileName+".ogg");
		 playSound(id);
	}
	
    private static int loadSound(String filename) {
        int soundID = 0;
        if (soundPool == null) {
           soundPool = buildSoundPool();
        }
        try {
        	if(streamIDplaying!=-99999999 && soundPool != null){
        		Log.d("Assets", "Stopped music with strweam id"+streamIDplaying);
        		soundPool.stop(streamIDplaying);      	
        	}       	
           soundID = soundPool.load(GameMainActivity.assets.openFd(filename),1);
           Log.d("Assets", "generated a new sound id "+soundID);                
        } catch (IOException e) {
           e.printStackTrace();
        }
        return soundID;
     }
    
    public static void stopSoundOnDemand(){
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
                                   
           soundPool = new SoundPool.Builder()
                       .setMaxStreams(30)
                       .setAudioAttributes(audioAttributes)
                       .build();
        } else {
           soundPool = new SoundPool(30 , AudioManager.STREAM_MUSIC, 0);
        }
       
        return soundPool;
     }

     private static void playSound(final int soundID) {
        if (soundPool != null) {
        	
        	  soundPool.setOnLoadCompleteListener(new OnLoadCompleteListener() {
                  @Override
                  public void onLoadComplete(SoundPool soundPool, int sampleId,
                      int status) {
                       // soundPool.play(myVoice, 20, 20, 1, 0, 1f);
                        streamIDplaying = soundPool.play(soundID, 20, 20, 1, 0, 1f);
                  } 
            });
        	  
           
        }
     }
	
	
    //play music themes 
 	public static void playMusic(String filename, boolean looping) {
 		Log.d("Assets", "playing music");
		if (mediaPlayer == null) {
			mediaPlayer = new MediaPlayer();
		}
		try {
			AssetFileDescriptor afd = GameMainActivity.assets.openFd(filename);
			mediaPlayer.setDataSource(afd.getFileDescriptor(),
					afd.getStartOffset(), afd.getLength());
			mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
			mediaPlayer.prepare();
			mediaPlayer.setLooping(looping);
			mediaPlayer.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
 	
	public static void onResume() {	
		Log.d("Assets", "OnResume is called");
		playMusic("animals_generic_sounds1.mp3", true);
	}

	public static void onPause() {
		if (soundPool != null) {
			soundPool.release();
			soundPool = null;
		}

		if (mediaPlayer != null) {
			mediaPlayer.stop();
			mediaPlayer.release();
			mediaPlayer = null;
		}
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
		
		
		newHeight -=90;
		newWidth -=90;
		
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
		 // int tempVariable = 1;
		  int tempArrayVariable = 1;
		  

		  
		 //1 carouzelMap.put(tempVariable++, "ant");
	      Animal ant = new Animal();
	      ant.addAnimalName(R.string.ant);
	      ant.addAnimalName(R.string.ant_gr);
	      ant.setAnimalVisualFile("ant");
	      ant.addAudioFile("empty");
	      animals.put(tempArrayVariable++, ant);
		  
		 //2 carouzelMap.put(tempVariable++, "baby_dear");
	      Animal baby_dear = new Animal();
	      baby_dear.addAnimalName(R.string.baby_dear);
	      baby_dear.addAnimalName(R.string.baby_dear_gr);
	      baby_dear.setAnimalVisualFile("baby_dear");
	      baby_dear.addAudioFile("deer");
	      animals.put(tempArrayVariable++, baby_dear);
		  
		  //3 carouzelMap.put(tempVariable++, "bear_grizzly");
	      Animal bear_grizzly = new Animal();
	      bear_grizzly.addAnimalName(R.string.bear_grizzly);
	      bear_grizzly.addAnimalName(R.string.bear_grizzly_gr);
	      bear_grizzly.setAnimalVisualFile("bear_grizzly");
	      //bear_grizzly.addAudioFile("bear1");
	      //bear_grizzly.addAudioFile("bear2");
	      bear_grizzly.addAudioFile("bear3");
	      animals.put(tempArrayVariable++, bear_grizzly);
		  
		  //4carouzelMap.put(tempVariable++, "bear_pollar");
	      Animal bear_pollar = new Animal();
	      bear_pollar.addAnimalName(R.string.bear_pollar);
	      bear_pollar.addAnimalName(R.string.bear_pollar_gr);
	      bear_pollar.setAnimalVisualFile("bear_pollar");
	      //bear_pollar.addAudioFile("bear1");
	      //bear_pollar.addAudioFile("bear2");
	      bear_pollar.addAudioFile("bear3");
	      animals.put(tempArrayVariable++, bear_pollar);
		  
		  //5carouzelMap.put(tempVariable++, "bird_bat");
	      Animal bird_bat = new Animal();
	      bird_bat.addAnimalName(R.string.bird_bat);
	      bird_bat.addAnimalName(R.string.bird_bat_gr);
	      bird_bat.setAnimalVisualFile("bird_bat");
	      bird_bat.addAudioFile("bat1");
	      bird_bat.addAudioFile("bat2");
	      animals.put(tempArrayVariable++, bird_bat);
		  
		  //6carouzelMap.put(tempVariable++, "bird_canary");
		  Animal bird_canary = new Animal();
		  bird_canary.addAnimalName(R.string.bird_canary);
		  bird_canary.addAnimalName(R.string.bird_canary_gr);
		  bird_canary.setAnimalVisualFile("bird_canary");
		  bird_canary.addAudioFile("bird_canary");
		  bird_canary.addAudioFile("bird_canary2");
	      animals.put(tempArrayVariable++, bird_canary);
		  
		  //7carouzelMap.put(tempVariable++, "bird_nightingale");
		  Animal bird_nightingale = new Animal();
		  bird_nightingale.addAnimalName(R.string.bird_nightingale);
		  bird_nightingale.addAnimalName(R.string.bird_nightingale_gr);
		  bird_nightingale.setAnimalVisualFile("bird_nightingale");
		  bird_nightingale.addAudioFile("bird_canary");
		  bird_nightingale.addAudioFile("bird_canary2");
	      animals.put(tempArrayVariable++, bird_nightingale);
		  
		  //8carouzelMap.put(tempVariable++, "bison");
		  Animal bison = new Animal();
		  bison.addAnimalName(R.string.bison);
		  bison.setAnimalVisualFile("bison");
		  bison.addAudioFile("bison");
	      animals.put(tempArrayVariable++, bison);
		  
		  //9carouzelMap.put(tempVariable++, "Black_panther");
		  Animal Black_panther = new Animal();
		  Black_panther.addAnimalName(R.string.Black_panther);
		  Black_panther.addAnimalName(R.string.Black_panther_gr);
		  Black_panther.setAnimalVisualFile("Black_panther");
		 // Black_panther.addAudioFile("tiger1");
		  Black_panther.addAudioFile("tiger2");
		 // Black_panther.addAudioFile("tiger3");
		 // Black_panther.addAudioFile("tiger4");
		 // Black_panther.addAudioFile("tiger5");
		  //Black_panther.addAudioFile("tiger6");
		  //Black_panther.addAudioFile("tiger7");
	      animals.put(tempArrayVariable++, Black_panther);
		  
		  //10carouzelMap.put(tempVariable++, "Bull");
		  Animal Bull = new Animal();
		  Bull.addAnimalName(R.string.Bull);
		  Bull.setAnimalVisualFile("Bull");
		  Bull.addAudioFile("cow1");
	      animals.put(tempArrayVariable++, Bull);
		  
		  //11carouzelMap.put(tempVariable++, "butterfly");
		  Animal butterfly = new Animal();
		  butterfly.addAnimalName(R.string.butterfly);
		  butterfly.addAnimalName(R.string.butterfly_gr);
		  butterfly.setAnimalVisualFile("butterfly");
	      animals.put(tempArrayVariable++, butterfly);
		  
		  //12carouzelMap.put(tempVariable++, "camel");
		  Animal camel = new Animal();
		  camel.addAnimalName(R.string.camel);
		  camel.setAnimalVisualFile("camel");
		  camel.addAudioFile("camel");
	      animals.put(tempArrayVariable++, camel);
		  
		  //13carouzelMap.put(tempVariable++, "cat");
		  Animal cat = new Animal();
		  cat.addAnimalName(R.string.cat);
		  cat.setAnimalVisualFile("cat");
		  //cat.addAudioFile("cat1");
		 // cat.addAudioFile("cat2");
		  cat.addAudioFile("cat3");
	      animals.put(tempArrayVariable++, cat);
		  
		  //14carouzelMap.put(tempVariable++, "cat_face");
		  Animal cat_face = new Animal();
		  cat_face.addAnimalName(R.string.cat_face);
		  cat_face.addAnimalName(R.string.cat_face_gr);
		  cat_face.setAnimalVisualFile("cat_face");
		  cat_face.addAudioFile("cat1");
		  cat_face.addAudioFile("cat2");
		  cat_face.addAudioFile("cat3");
	      animals.put(tempArrayVariable++, cat_face);
		  
		  //15carouzelMap.put(tempVariable++, "cat_siam");
		  Animal cat_siam = new Animal();
		  cat_siam.addAnimalName(R.string.cat_siam);
		  cat_siam.addAnimalName(R.string.cat_siam_gr);
		  cat_siam.setAnimalVisualFile("cat_siam");
		  cat_siam.addAudioFile("cat1");
		  cat_siam.addAudioFile("cat2");
		  cat_siam.addAudioFile("cat3");
	      animals.put(tempArrayVariable++, cat_siam);
		  
		  //16carouzelMap.put(tempVariable++, "chicken");
		  Animal chicken = new Animal();
		  chicken.addAnimalName(R.string.chicken);
		  chicken.addAnimalName(R.string.chicken_gr);
		  chicken.setAnimalVisualFile("chicken");
		  chicken.addAudioFile("chiken");
	      animals.put(tempArrayVariable++, chicken);
		  
		  //17carouzelMap.put(tempVariable++, "chicks");
		  Animal chicks = new Animal();
		  chicks.addAnimalName(R.string.chicks);
		  chicks.addAnimalName(R.string.chicks_gr);
		  chicks.setAnimalVisualFile("chicks");
		  chicks.addAudioFile("chiken");
	      animals.put(tempArrayVariable++, chicks);
		  
		  //18carouzelMap.put(tempVariable++, "chipmank");
		  Animal chipmank = new Animal();
		  chipmank.addAnimalName(R.string.chipmank);
		  chipmank.addAnimalName(R.string.chipmank_gr);
		  chipmank.setAnimalVisualFile("chipmank");
		  chipmank.addAudioFile("Chipmunk");
	      animals.put(tempArrayVariable++, chipmank);
		  
		  //19carouzelMap.put(tempVariable++, "Cow_female_black_white");
		  Animal Cow_female_black_white = new Animal();
		  Cow_female_black_white.addAnimalName(R.string.Cow_female_black_white);
		  Cow_female_black_white.addAnimalName(R.string.Cow_female_black_white_gr);
		  Cow_female_black_white.setAnimalVisualFile("Cow_female_black_white");
		  Cow_female_black_white.addAudioFile("cow1");
		  Cow_female_black_white.addAudioFile("cow2");
	      animals.put(tempArrayVariable++, Cow_female_black_white);
		  
		  //20carouzelMap.put(tempVariable++, "crab");
		  Animal crab = new Animal();
		  crab.addAnimalName(R.string.crab);
		  crab.setAnimalVisualFile("crab");
		  crab.addAudioFile("fish");
	      animals.put(tempArrayVariable++, crab);
		  
		  //21carouzelMap.put(tempVariable++, "crocodile");
		  Animal crocodile = new Animal();
		  crocodile.addAnimalName(R.string.crocodile);
		  crocodile.addAnimalName(R.string.crocodile_gr);
		  crocodile.setAnimalVisualFile("crocodile");		
		  crocodile.addAudioFile("crocodile1");
		  crocodile.addAudioFile("crocodile2");
	      animals.put(tempArrayVariable++, crocodile);
		  
		  //22carouzelMap.put(tempVariable++, "crow");
		  Animal crow = new Animal();
		  crow.addAnimalName(R.string.crow);
		  crow.addAnimalName(R.string.crow_gr);
		  crow.setAnimalVisualFile("crow");
		  crow.addAudioFile("crow");
	      animals.put(tempArrayVariable++, crow);
		  
		  //23carouzelMap.put(tempVariable++, "dog_german_shepard");
		  Animal dog_german_shepard = new Animal();
		  dog_german_shepard.addAnimalName(R.string.dog_german_shepard);
		  dog_german_shepard.addAnimalName(R.string.dog_german_shepard_gr);
		  dog_german_shepard.setAnimalVisualFile("dog_german_shepard");
		 // dog_german_shepard.addAudioFile("dog1");
		  dog_german_shepard.addAudioFile("dog2");
		 // dog_german_shepard.addAudioFile("dog3");
		 // dog_german_shepard.addAudioFile("dog4");
	      animals.put(tempArrayVariable++, dog_german_shepard);
		  
		  //24carouzelMap.put(tempVariable++, "dog_lassie");
		  Animal dog_lassie = new Animal();
		  dog_lassie.addAnimalName(R.string.dog_lassie);
		  dog_lassie.addAnimalName(R.string.dog_lassie_gr);
		  dog_lassie.setAnimalVisualFile("dog_lassie");
		 // dog_lassie.addAudioFile("dog1");
		  dog_lassie.addAudioFile("dog2");
		  //dog_lassie.addAudioFile("dog3");
		  //dog_lassie.addAudioFile("dog4");
	      animals.put(tempArrayVariable++, dog_lassie);
		  
		  //25carouzelMap.put(tempVariable++, "dog_terrier");
		  Animal dog_terrier = new Animal();
		  dog_terrier.addAnimalName(R.string.dog_terrier);
		  dog_terrier.addAnimalName(R.string.dog_terrier_gr);
		  dog_terrier.setAnimalVisualFile("dog_terrier");
		  //dog_terrier.addAudioFile("dog1");
		  dog_terrier.addAudioFile("dog2");
		 // dog_terrier.addAudioFile("dog3");
		 // dog_terrier.addAudioFile("dog4");
	      animals.put(tempArrayVariable++, dog_terrier);
		  		  
		 //26 carouzelMap.put(tempVariable++, "dolphin");
		  Animal dolphin = new Animal();
		  dolphin.addAnimalName(R.string.dolphin);
		  dolphin.addAnimalName(R.string.dolphin_gr);
		  dolphin.setAnimalVisualFile("dolphin");
		  //dolphin.addAudioFile("dolphin1");
		  dolphin.addAudioFile("dolphin2");
		 // dolphin.addAudioFile("dolphin3");
		  //dolphin.addAudioFile("dolphin4");
	      animals.put(tempArrayVariable++, dolphin);
		  
		  //27carouzelMap.put(tempVariable++, "dove");
		  Animal dove = new Animal();
		  dove.addAnimalName(R.string.dove);
		  dove.addAnimalName(R.string.dove_gr);
		  dove.setAnimalVisualFile("dove");
		  dove.addAudioFile("dove1");
		  //dove.addAudioFile("dove2");
	      animals.put(tempArrayVariable++, dove);
		  
		  //28carouzelMap.put(tempVariable++, "dragonfly");
		  Animal dragonfly = new Animal();
		  dragonfly.addAnimalName(R.string.dragonfly);
		  dragonfly.addAnimalName(R.string.dragonfly_gr);
		  dragonfly.setAnimalVisualFile("dragonfly");
		  dragonfly.addAudioFile("insect_mosquito");
		 // dragonfly.addAudioFile("insect_mosquito2");
	      animals.put(tempArrayVariable++, dragonfly);
		  
		  //29carouzelMap.put(tempVariable++, "duck");
		  Animal duck = new Animal();
		  duck.addAnimalName(R.string.duck);
		  duck.addAnimalName(R.string.duck_gr);
		  duck.setAnimalVisualFile("duck");
		  duck.addAudioFile("duck");
	      animals.put(tempArrayVariable++, duck);
		  	  
		  //30carouzelMap.put(tempVariable++, "eagle_bold");
		  Animal eagle_bold = new Animal();
		  eagle_bold.addAnimalName(R.string.eagle_bold);
		  eagle_bold.setAnimalVisualFile("eagle_bold");
		  eagle_bold.addAudioFile("eagle");
		//  eagle_bold.addAudioFile("eagle2");
	      animals.put(tempArrayVariable++, eagle_bold);
		  
		  //31carouzelMap.put(tempVariable++, "elephant");
		  Animal elephant = new Animal();
		  elephant.addAnimalName(R.string.elephant);
		  eagle_bold.addAnimalName(R.string.eagle_bold_gr);
		  elephant.setAnimalVisualFile("elephant");
		  elephant.addAudioFile("elephant");
	      animals.put(tempArrayVariable++, elephant);
		  
		  //32carouzelMap.put(tempVariable++, "elk");
		  Animal elk = new Animal();
		  elk.addAnimalName(R.string.elk);
		  elk.addAnimalName(R.string.elk_gr);
		  
		  elk.setAnimalVisualFile("elk");
		  elk.addAudioFile("elk");
		 // elk.addAudioFile("elk2");
	      animals.put(tempArrayVariable++, elk);
		  	  	  
		  //33carouzelMap.put(tempVariable++, "fish_clown");
		  Animal fish_clown = new Animal();
		  fish_clown.addAnimalName(R.string.fish_clown);
		  fish_clown.addAnimalName(R.string.fish_clown_gr);
		  fish_clown.setAnimalVisualFile("fish_clown");
		  fish_clown.addAudioFile("fish");
	      animals.put(tempArrayVariable++, fish_clown);
		  
		  //34carouzelMap.put(tempVariable++, "fish_goldfish");
		  Animal fish_goldfish = new Animal();
		  fish_goldfish.addAnimalName(R.string.fish_goldfish);
		  fish_goldfish.addAnimalName(R.string.fish_goldfish_gr);
		  fish_goldfish.setAnimalVisualFile("fish_goldfish");
		  fish_goldfish.addAudioFile("fish");
	      animals.put(tempArrayVariable++, fish_goldfish);
		  
		  //35carouzelMap.put(tempVariable++, "fish_scorpion");
		  Animal fish_scorpion = new Animal();
		  fish_scorpion.addAnimalName(R.string.fish_scorpion);
		  fish_scorpion.addAnimalName(R.string.fish_scorpion_gr);
		  fish_scorpion.setAnimalVisualFile("fish_scorpion");
		  fish_scorpion.addAudioFile("fish");
	      animals.put(tempArrayVariable++, fish_scorpion);
		  
		  //36carouzelMap.put(tempVariable++, "fox");
		  Animal fox = new Animal();
		  fox.addAnimalName(R.string.fox);
		  fox.addAnimalName(R.string.fox_gr);
		  fox.setAnimalVisualFile("fox");
		  fox.addAudioFile("fox");
		 /// fox.addAudioFile("fox2");
		 // fox.addAudioFile("fox3");
	      animals.put(tempArrayVariable++, fox);
		  
		  //37carouzelMap.put(tempVariable++, "frog");
		  Animal frog = new Animal();
		  frog.addAnimalName(R.string.frog);
		  frog.addAnimalName(R.string.frog_gr);
		  frog.setAnimalVisualFile("frog");
		  frog.addAudioFile("frog");
		  //frog.addAudioFile("frog2");
	      animals.put(tempArrayVariable++, frog);
		  
		  
		  //38carouzelMap.put(tempVariable++, "giraffe");
		  Animal giraffe = new Animal();
		  giraffe.addAnimalName(R.string.giraffe);
		  giraffe.addAnimalName(R.string.giraffe_gr);
		  giraffe.setAnimalVisualFile("giraffe");
		  giraffe.addAudioFile("giraffe");
	      animals.put(tempArrayVariable++, giraffe);
		  
		  //39carouzelMap.put(tempVariable++, "goat");
		  Animal goat = new Animal();
		  goat.addAnimalName(R.string.goat);
		  goat.addAnimalName(R.string.goat_gr);
		  goat.setAnimalVisualFile("goat");	
		//  goat.addAudioFile("goat1");
		  goat.addAudioFile("goat2");
		 // goat.addAudioFile("goat3");
	      animals.put(tempArrayVariable++, goat);

		  //40carouzelMap.put(tempVariable++, "grasshoper");
		  Animal grasshoper = new Animal();
		  grasshoper.addAnimalName(R.string.grasshoper);
		  grasshoper.addAnimalName(R.string.grasshoper_gr);
		  grasshoper.setAnimalVisualFile("grasshoper");
		  grasshoper.addAudioFile("grasshopper");
	      animals.put(tempArrayVariable++, grasshoper);
		  
		  //41carouzelMap.put(tempVariable++, "guinea_pig");
		  Animal guinea_pig = new Animal();
		  guinea_pig.addAnimalName(R.string.guinea_pig);
		  guinea_pig.addAnimalName(R.string.guinea_pig_gr);
		  guinea_pig.setAnimalVisualFile("guinea_pig");
		  guinea_pig.addAudioFile("mouse");
		//  guinea_pig.addAudioFile("mouse2");
	      animals.put(tempArrayVariable++, guinea_pig);
		  
		  //42carouzelMap.put(tempVariable++, "hedgehog");
		  Animal hedgehog = new Animal();
		  hedgehog.addAnimalName(R.string.hedgehog);
		  hedgehog.addAnimalName(R.string.hedgehog_gr);
		  hedgehog.setAnimalVisualFile("hedgehog");
		  hedgehog.addAudioFile("hedgehog");	  
	      animals.put(tempArrayVariable++, hedgehog);
		  
		  //43carouzelMap.put(tempVariable++, "horse");
		  Animal horse = new Animal();
		  horse.addAnimalName(R.string.horse);
		  horse.addAnimalName(R.string.horse_gr);
		  horse.setAnimalVisualFile("horse");
		  horse.addAudioFile("horse1");
//		  horse.addAudioFile("horse2");
//		  horse.addAudioFile("horse3");	
//		  horse.addAudioFile("horse4");	
	      animals.put(tempArrayVariable++, horse);
		  
		  //44carouzelMap.put(tempVariable++, "insect_bee");
		  Animal insect_bee = new Animal();
		  insect_bee.addAnimalName(R.string.insect_bee);
		  insect_bee.addAnimalName(R.string.insect_bee_gr);
		  insect_bee.setAnimalVisualFile("insect_bee");
		  insect_bee.addAudioFile("insect_bee");	
	      animals.put(tempArrayVariable++, insect_bee);
		  
		  //45carouzelMap.put(tempVariable++, "Kangaroo");//should play cycled
		  Animal Kangaroo = new Animal();
		  Kangaroo.addAnimalName(R.string.Kangaroo);
		  Kangaroo.addAnimalName(R.string.Kangaroo_gr);
		  Kangaroo.setAnimalVisualFile("Kangaroo");
		  Kangaroo.addAudioFile("helper_spring_boing");	
	      animals.put(tempArrayVariable++, Kangaroo);
		  
		  //46carouzelMap.put(tempVariable++, "koala");
		  Animal koala = new Animal();
		  koala.addAnimalName(R.string.koala);
		  koala.addAnimalName(R.string.koala_gr);
		  koala.setAnimalVisualFile("koala");
		  koala.addAudioFile("koala");	
	      animals.put(tempArrayVariable++, koala);
		  
		  //47carouzelMap.put(tempVariable++, "ladybug");
		  Animal ladybug = new Animal();
		  ladybug.addAnimalName(R.string.ladybug);
		  ladybug.addAnimalName(R.string.ladybug_gr);
		  ladybug.setAnimalVisualFile("ladybug");
		  ladybug.addAudioFile("insect-fly");
		  ladybug.addAudioFile("insect-bee");
	      animals.put(tempArrayVariable++, ladybug);
		  
		  //48carouzelMap.put(tempVariable++, "lamb");
		  Animal lamb = new Animal();
		  lamb.addAnimalName(R.string.lamb);
		  lamb.addAnimalName(R.string.lamb_gr);
		  lamb.setAnimalVisualFile("lamb");
		  lamb.addAudioFile("lamb");
		  //lamb.addAudioFile("goat");
		  //lamb.addAudioFile("goat1");
		  //lamb.addAudioFile("goat2");
		  //lamb.addAudioFile("goat3");
	      animals.put(tempArrayVariable++, lamb);
		  
		  //49carouzelMap.put(tempVariable++, "leopard");
		  Animal leopard = new Animal();
		  leopard.addAnimalName(R.string.leopard);
		  leopard.addAnimalName(R.string.leopard_gr);
		  leopard.setAnimalVisualFile("leopard");
	//	  leopard.addAudioFile("tiger1");
		  leopard.addAudioFile("tiger2");
//		  leopard.addAudioFile("tiger3");
//		  leopard.addAudioFile("tiger4");
//		  leopard.addAudioFile("tiger5");
//		  leopard.addAudioFile("tiger6");
//		  leopard.addAudioFile("tiger7");
	      animals.put(tempArrayVariable++, leopard);
		  
		 //50 carouzelMap.put(tempVariable++, "lion");
		  Animal lion = new Animal();
		  lion.addAnimalName(R.string.lion);
		  lion.addAnimalName(R.string.lion_gr);
		  lion.setAnimalVisualFile("lion");
		  lion.addAudioFile("lion");
		 // lion.addAudioFile("lion2");
	      animals.put(tempArrayVariable++, lion);
		  
		  //51carouzelMap.put(tempVariable++, "lizard_Igouana");
		  Animal lizard_Igouana = new Animal();
		  lizard_Igouana.addAnimalName(R.string.lizard_Igouana);
		  lizard_Igouana.addAnimalName(R.string.lizard_Igouana_gr);
		  lizard_Igouana.setAnimalVisualFile("lizard_Igouana");
		  lizard_Igouana.addAudioFile("reptile");
	      animals.put(tempArrayVariable++, lizard_Igouana);
		  
		  //52carouzelMap.put(tempVariable++, "lizard");
		  Animal lizard = new Animal();
		  lizard.addAnimalName(R.string.lizard);
		  lizard.addAnimalName(R.string.lizard_gr);
		  lizard.setAnimalVisualFile("lizard");
		  lizard.addAudioFile("reptile");
	      animals.put(tempArrayVariable++, lizard);
		  
		  //53carouzelMap.put(tempVariable++, "lobster");
		  Animal lobster = new Animal();
		  lobster.addAnimalName(R.string.lobster);
		  lobster.addAnimalName(R.string.lobster_gr);
		  lobster.setAnimalVisualFile("lobster");
		  lobster.addAudioFile("fish");
	      animals.put(tempArrayVariable++, lobster);
		  
		  //54carouzelMap.put(tempVariable++, "monkey");
		  Animal monkey = new Animal();
		  monkey.addAnimalName(R.string.monkey);
		  monkey.addAnimalName(R.string.monkey_gr);
		  monkey.setAnimalVisualFile("monkey");
		  monkey.addAudioFile("monkey1");
//		  monkey.addAudioFile("monkey2");
//		  monkey.addAudioFile("monkey3");
//		  monkey.addAudioFile("monkey4");
//		  monkey.addAudioFile("monkey5");
	      animals.put(tempArrayVariable++, monkey);
		  
		  //55carouzelMap.put(tempVariable++, "moose");
		  Animal moose = new Animal();
		  moose.addAnimalName(R.string.moose);
		  moose.addAnimalName(R.string.moose_gr);
		  moose.setAnimalVisualFile("moose");
		  moose.addAudioFile("moose");
	      animals.put(tempArrayVariable++, moose);
		  
		  //56carouzelMap.put(tempVariable++, "mosquito");
		  Animal mosquito = new Animal();
		  mosquito.addAnimalName(R.string.mosquito);
		  mosquito.addAnimalName(R.string.mosquito_gr);
		  mosquito.setAnimalVisualFile("mosquito");
		  mosquito.addAudioFile("insect_mosquito");
		  //mosquito.addAudioFile("insect-fly");
	      animals.put(tempArrayVariable++, mosquito);
		  
		  //57carouzelMap.put(tempVariable++, "mouse_field");
		  Animal mouse_field = new Animal();
		  mouse_field.addAnimalName(R.string.mouse_field);
		  mouse_field.addAnimalName(R.string.mouse_field_gr);
		  mouse_field.setAnimalVisualFile("mouse_field");
		  mouse_field.addAudioFile("mouse");
		 // mouse_field.addAudioFile("mouse2");
	      animals.put(tempArrayVariable++, mouse_field);
		  
		  //58carouzelMap.put(tempVariable++, "orca");
		  Animal orca = new Animal();
		  orca.addAnimalName(R.string.orca);
		  orca.addAnimalName(R.string.orca_gr);
		  orca.setAnimalVisualFile("orca");
		  orca.addAudioFile("orca");		
	      animals.put(tempArrayVariable++, orca);
		  
		  //59carouzelMap.put(tempVariable++, "owl");
		  Animal owl = new Animal();
		  owl.addAnimalName(R.string.owl);
		  owl.addAnimalName(R.string.owl_gr);
		  owl.setAnimalVisualFile("owl");
		  owl.addAudioFile("owl1");	
		 // owl.addAudioFile("owl2");	
		 // owl.addAudioFile("owl3");	
	      animals.put(tempArrayVariable++, owl);
		  
		 //60 carouzelMap.put(tempVariable++, "panda");
		  Animal panda = new Animal();
		  panda.addAnimalName(R.string.panda);
		  panda.addAnimalName(R.string.panda_gr);
		  panda.setAnimalVisualFile("panda");
		  panda.addAudioFile("panda");
	      animals.put(tempArrayVariable++, panda);
		  
		  //61carouzelMap.put(tempVariable++, "parrot");
		  Animal parrot = new Animal();
		  parrot.addAnimalName(R.string.parrot);
		  parrot.addAnimalName(R.string.parrot_gr);
		  parrot.setAnimalVisualFile("parrot");
		  //parrot.addAudioFile("parrot");
		  //parrot.addAudioFile("parro1");
		  parrot.addAudioFile("parrot2");
	      animals.put(tempArrayVariable++, parrot);

		  //62carouzelMap.put(tempVariable++, "peacock");
		  Animal peacock = new Animal();
		  peacock.addAnimalName(R.string.peacock);
		  peacock.addAnimalName(R.string.peacock_gr);
		  peacock.addAudioFile("peacoc");
		  peacock.setAnimalVisualFile("peacock");
	      animals.put(tempArrayVariable++, peacock);
		  
		  //63carouzelMap.put(tempVariable++, "penguin");
		  Animal penguin = new Animal();
		  penguin.addAnimalName(R.string.penguin);
		  penguin.addAnimalName(R.string.penguin_gr);
		  penguin.addAudioFile("penguin");
		  penguin.setAnimalVisualFile("penguin");
	      animals.put(tempArrayVariable++, penguin);
		  
		  //64carouzelMap.put(tempVariable++, "pig");
		  Animal pig = new Animal();
		  pig.addAnimalName(R.string.pig);
		  pig.addAnimalName(R.string.pig_gr);
		 // pig.addAudioFile("pig");
		  pig.addAudioFile("pig1");
		 // pig.addAudioFile("pig2");
		 // pig.addAudioFile("pig3");
		  pig.setAnimalVisualFile("pig");
	      animals.put(tempArrayVariable++, pig);
		  
		  //65carouzelMap.put(tempVariable++, "rabbit");
		  Animal rabbit = new Animal();
		  rabbit.addAnimalName(R.string.rabbit);
		  rabbit.addAnimalName(R.string.rabbit_gr);
		  rabbit.addAudioFile("rabit");
		  rabbit.setAnimalVisualFile("rabbit");
	      animals.put(tempArrayVariable++, rabbit);
		  
		 //66 carouzelMap.put(tempVariable++, "rabbit2");
		  Animal rabbit2 = new Animal();
		  rabbit2.addAnimalName(R.string.rabbit2);
		  rabbit2.addAnimalName(R.string.rabbit2_gr);
		  rabbit2.addAudioFile("rabit");
		  rabbit2.setAnimalVisualFile("rabbit2");
	      animals.put(tempArrayVariable++, rabbit2);
		  
		  //67carouzelMap.put(tempVariable++, "racoon");
		  Animal racoon = new Animal();
		  racoon.addAnimalName(R.string.racoon);
		  racoon.addAnimalName(R.string.racoon_gr);
		  racoon.addAudioFile("racoon1");
		 // racoon.addAudioFile("racoon2");
		  racoon.setAnimalVisualFile("racoon");
	      animals.put(tempArrayVariable++, racoon);
		  
		 //68 carouzelMap.put(tempVariable++, "rhino");
		  Animal rhino = new Animal();
		  rhino.addAnimalName(R.string.rhino);
		  rhino.addAnimalName(R.string.rhino_gr);
		  rhino.addAudioFile("rhino");
		  rhino.setAnimalVisualFile("rhino");
	      animals.put(tempArrayVariable++, rhino);
		  
		  //69carouzelMap.put(tempVariable++, "rooster");
		  Animal rooster = new Animal();
		  rooster.addAnimalName(R.string.rooster);
		  rooster.addAnimalName(R.string.rooster_gr);
		  rooster.addAudioFile("Rooster");
		  rooster.setAnimalVisualFile("rooster");  
	      animals.put(tempArrayVariable++, rooster);  
		  
		 //70 carouzelMap.put(tempVariable++, "sea_lion");
		  Animal sea_lion = new Animal();
		  sea_lion.addAnimalName(R.string.sea_lion);
		  sea_lion.addAnimalName(R.string.sea_lion_gr);
		  sea_lion.addAudioFile("sea_lion");
		  sea_lion.setAnimalVisualFile("sea_lion");
	      animals.put(tempArrayVariable++, sea_lion);
		  
		  //71carouzelMap.put(tempVariable++, "shark");
		  Animal shark = new Animal();
		  shark.addAnimalName(R.string.shark);
		  shark.addAnimalName(R.string.shark_gr);
		  shark.addAudioFile("fish");
		  shark.setAnimalVisualFile("shark");
	      animals.put(tempArrayVariable++, shark);
		  
		  
		  //72carouzelMap.put(tempVariable++, "shrimp");
		  Animal shrimp = new Animal();
		  shrimp.addAnimalName(R.string.shrimp);
		  shrimp.addAnimalName(R.string.shrimp_gr);
		  shrimp.setAnimalVisualFile("shrimp");
	      animals.put(tempArrayVariable++, shrimp);
		  
		 //73 carouzelMap.put(tempVariable++, "snail"); // Snails does not make sounds
		  Animal snail = new Animal();
		  snail.setAnimalVisualFile("snail");
		  snail.addAnimalName(R.string.snail);
		  snail.addAnimalName(R.string.snail_gr);
		  snail.addAudioFile("empty");
	      animals.put(tempArrayVariable++, snail);
		  
		  //74carouzelMap.put(tempVariable++, "snake");
		  Animal snake = new Animal();
		  snake.addAnimalName(R.string.snake);
		  snake.addAnimalName(R.string.snake_gr);
		  snake.setAnimalVisualFile("snake");
		  snake.addAudioFile("snake2");
		 // snake.addAudioFile("snake1");
	      animals.put(tempArrayVariable++, snake);
		  
		  //75carouzelMap.put(tempVariable++, "spider"); // spiders does not make sounds
		  Animal spider = new Animal();
		  spider.addAnimalName(R.string.spider);
		  spider.addAnimalName(R.string.spider_gr);
		  spider.setAnimalVisualFile("spider");
		  spider.addAudioFile("empty");
	      animals.put(tempArrayVariable++, spider);
		  
		  //76carouzelMap.put(tempVariable++, "starfish");
		  Animal starfish = new Animal();
		  starfish.addAnimalName(R.string.starfish);
		  starfish.addAnimalName(R.string.starfish_gr);
		  starfish.setAnimalVisualFile("starfish");
		  starfish.addAudioFile("fish");	
	      animals.put(tempArrayVariable++, starfish);
		  
		 //77 carouzelMap.put(tempVariable++, "swan");
		  Animal swan = new Animal();
		  swan.addAnimalName(R.string.swan);
		  swan.addAnimalName(R.string.swan_gr);
		  swan.setAnimalVisualFile("swan");
		  swan.addAudioFile("swan");	
	      animals.put(tempArrayVariable++, swan);
		  
		  //78carouzelMap.put(tempVariable++, "swordfish");
		  Animal swordfish = new Animal();
		  swordfish.addAnimalName(R.string.swordfish);
		  swordfish.addAnimalName(R.string.swordfish_gr);
		  swordfish.setAnimalVisualFile("swordfish");
		  swordfish.addAudioFile("fish");	
	      animals.put(tempArrayVariable++, swordfish);
		  
		  //79carouzelMap.put(tempVariable++, "tiger");
		  Animal tiger = new Animal();
		  tiger.addAnimalName(R.string.tiger);
		  tiger.addAnimalName(R.string.tiger_gr);
		  tiger.setAnimalVisualFile("tiger");
//		  tiger.addAudioFile("tiger1");
		  tiger.addAudioFile("tiger2");	
//		  tiger.addAudioFile("tiger3");	
//		  tiger.addAudioFile("tiger4");	
//		  tiger.addAudioFile("tiger5");	
//		  tiger.addAudioFile("tiger6");
//		  tiger.addAudioFile("tiger7");
	      animals.put(tempArrayVariable++, tiger);
		  
		  //80carouzelMap.put(tempVariable++, "turkey");
		  Animal turkey = new Animal();
		  turkey.addAnimalName(R.string.turkey);
		  turkey.addAnimalName(R.string.turkey_gr);
		  turkey.setAnimalVisualFile("turkey");
		  turkey.addAudioFile("turkey");	
	      animals.put(tempArrayVariable++, turkey);
		  
		  //81carouzelMap.put(tempVariable++, "turtle");
		  Animal turtle = new Animal();
		  turtle.addAnimalName(R.string.turtle);
		  turtle.addAnimalName(R.string.turtle_gr);
		  turtle.setAnimalVisualFile("turtle");
		  turtle.addAudioFile("fish");	
	      animals.put(tempArrayVariable++, turtle);
		  
		  //82carouzelMap.put(tempVariable++, "wolf");
		  Animal wolf = new Animal();
		  wolf.addAnimalName(R.string.wolf);
		  wolf.addAnimalName(R.string.wolf_gr);
		  wolf.setAnimalVisualFile("wolf");
		  wolf.addAudioFile("wolf");	
	      animals.put(tempArrayVariable++, wolf);
		  
		  //83carouzelMap.put(tempVariable++, "zebra");
		  Animal zebra = new Animal();
		  zebra.addAnimalName(R.string.zebra);
		  zebra.addAnimalName(R.string.zebra_gr);
		  zebra.setAnimalVisualFile("zebra");
		  //zebra.addAudioFile("horse");	
		  zebra.addAudioFile("horse1");	
		  //zebra.addAudioFile("horse2");	
		  //zebra.addAudioFile("horse3");	
		  //zebra.addAudioFile("horse4");	
	      animals.put(tempArrayVariable++, zebra);
		  
		  //84carouzelMap.put(tempVariable++, "sea_gull");
		  Animal sea_gull = new Animal();
		  sea_gull.addAnimalName(R.string.sea_gull);
		  sea_gull.addAnimalName(R.string.sea_gull_gr);
		  sea_gull.setAnimalVisualFile("sea_gull");
		  sea_gull.addAudioFile("seagull");	
	      animals.put(tempArrayVariable++, sea_gull);
		  
		  
		  //85carouzelMap.put(tempVariable++, "hippo");
		  Animal hippo = new Animal();
		  hippo.addAnimalName(R.string.hippo);
		  hippo.addAnimalName(R.string.hippo_gr);
		  hippo.setAnimalVisualFile("hippo");
		  hippo.addAudioFile("hippo");	
	      animals.put(tempArrayVariable++, hippo);
		
		  
		  //86carouzelMap.put(tempVariable++, "donkey");
		  Animal donkey = new Animal();
		  donkey.addAnimalName(R.string.donkey);
		  donkey.addAnimalName(R.string.donkey_gr);
		  donkey.setAnimalVisualFile("donkey");
		  donkey.addAudioFile("donkey");	
	      animals.put(tempArrayVariable++, donkey);		  
			  
	  }
	
	
	
	
	
	

}
