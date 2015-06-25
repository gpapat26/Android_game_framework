package com.animals.simpleandroidgdf;

import com.animals.state.CarouzelState;
import com.animals.state.LanguageState;
import com.animals.state.MainMenuState;
import com.animals.state.StartState;
import com.google.android.gms.games.Games;
import com.google.example.games.basegameutils.BaseGameActivity;
import com.animals.billing.*;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

public class GameMainActivity extends BaseGameActivity{
	
	public static final int GAME_WIDTH = 800;
	public static final int GAME_HEIGHT = 450;
	public static final int ENGLISH_CODE = 0;
	public static final int GREEK_CODE=1;
	public static GameView sGame;
	public static AssetManager assets;
	private Boolean exit = false;
	public static int languageId=1;
	private static final String languageCodeKey = "languageCodeKey";
	private static final String highScoreKey = "highScoreAnimalKey";
	private static final String premiumKey = "premium";
	private static int highScore;
	
	public static boolean testingMode = false;
	private static  String LEADERBOARD_ID = null;
	public static GameMainActivity instance;
    public static final String TAG = "GameMainActivity";
	
	public static SharedPreferences prefs;	
	 // Does the user have the premium upgrade?
    public static boolean mIsPremium = false;
    
    public static final String SKU_PREMIUM = "premium2";
    
    // (arbitrary) request code for the purchase flow
    static final int RC_REQUEST = 10001;
    
    // The helper object
    public static IabHelper mHelper;
	public static boolean waitForPurhcace;
    
    //**********************************************************************************//
	//********************* Activity methods           *********************************//
    //**********************************************************************************//
    
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
        String base64EncodedPublicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgNgrpfcgNutjrbjzpYOTGSrPCWwoO34B9+2CwXjfTuaahBV06he8epGoI4LPQnnNjnGyXdsBnKTjb0NRir6J96rNihsOUu2uQP5k57xDMFy6uVmvNKs9eSpeW249JoqgjDhDxATcXSxg+HOjWnEBCwlE5TWk7eMuUdWOCHOKty/m4NQIlK+a1n5YwFFRhF0ynbmvquWAXs1C96RNdr/kBvRvxPGMSqYC3mFzhNWTR/6i2TZuTF9oDvK+lRZ4LK+dIkdIMKolTLnTaE8rHItCn53dn9KP/dH9Ncp1hYr/dRlnf10lLTE/DpQQ/zKnpKa0aEjKlUd0Vm66PLhsxAQNtwIDAQAB";
        // Create the helper, passing it our context and the public key to verify signatures with
        Log.d(TAG, "Creating IAB helper.");              
        mHelper = new IabHelper(this, base64EncodedPublicKey);
        // enable debug logging (for a production application, you should set this to false).
        mHelper.enableDebugLogging(true);
        
        // Start setup. This is asynchronous and the specified listener
        // will be called once setup completes.
        Log.d(TAG, "Starting setup.");
        mHelper.startSetup(new IabHelper.OnIabSetupFinishedListener() {
            public void onIabSetupFinished(IabResult result) {
                Log.d(TAG, "Setup finished.");

                if (!result.isSuccess()) {
                    // Oh noes, there was a problem.
                    complain("Problem setting up in-app billing: " + result);
                    return;
                }

                // Have we been disposed of in the meantime? If so, quit.
                if (mHelper == null) return;

                // IAB is fully set up. Now, let's get an inventory of stuff we own.
                Log.d(TAG, "Setup successful. Querying inventory.");
                mHelper.queryInventoryAsync(mGotInventoryListener);
            }
        });
        
        
		assets=getAssets();
		prefs = getPreferences(Activity.MODE_PRIVATE);
		highScore = retrieveHighScore(); //Access only on start up.
		mIsPremium = retrievePremiumStatus();
		
		Log.d("Activity", "Activity is onCreate status");
		sGame= new GameView(this, GAME_WIDTH, GAME_HEIGHT);
		setContentView(sGame);	
		instance = this;
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		
		if(testingMode){
			LEADERBOARD_ID = getResources().getString(R.string.leaderBoardTest);//Test LeaderBoard
		}
		else{
			LEADERBOARD_ID = getResources().getString(R.string.leaderBoardProduction); //production LeaderBoard
		}
	}
	
    // We're being destroyed. It's important to dispose of the helper here!
    @Override
    public void onDestroy() {
        super.onDestroy();

        // very important:
        Log.d(TAG, "Destroying helper.");
        if (mHelper != null) {
            mHelper.dispose();
            mHelper = null;
        }
    }
    
    @Override
	public void onBackPressed() {
		if(sGame.currentState instanceof MainMenuState)
			{				
				sGame.setCurrentState(new StartState());
			}
		else if(sGame.currentState instanceof CarouzelState){
			Assets.loadGalleryImage("farm1");
			sGame.setCurrentState(new MainMenuState());
		}
		else if(sGame.currentState instanceof LanguageState){
			
			sGame.setCurrentState(new StartState());
		}
		else if(sGame.currentState instanceof StartState){
			
			if (exit) {
	            finish(); // finish activity          
	            return;
	        } else {
	            Toast.makeText(this, R.string.exit,
	                    Toast.LENGTH_SHORT).show();
	            exit = true;
	            new Handler().postDelayed(new Runnable() {
	                @Override
	                public void run() {
	                    exit = false;
	                }
	            }, 3 * 1000);

	        }
			
		}
	}
	
	@TargetApi(Build.VERSION_CODES.KITKAT)
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
	        super.onWindowFocusChanged(hasFocus);
	    if (hasFocus) {
	    	getWindow().getDecorView().setSystemUiVisibility(
	                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
	                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
	                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
	                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
	                | View.SYSTEM_UI_FLAG_FULLSCREEN
	                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);}
	}
	
	@Override
	protected void onResume(){
		Log.d("Activity", "OnResume be4 Super is called");
		super.onResume();
		if(sGame != null){
			Log.d("Activity", "OnResume is called");		
			sGame.onResume();
		}
	}
	
	@Override
	protected void onPause(){
		
		super.onPause();
		if(sGame != null){			
			sGame.onPause();
		}
	}
	
    //**********************************************************************************//
	//********************* Helpers for language , leaderboard**************************//
    //**********************************************************************************//
	
	public static int getLanguageCode(){
		return prefs.getInt(languageCodeKey, 0);
	}

	public static int getHighScore() {
		return highScore;
	}
	
	public static void setHighScore(int highScore) {
		GameMainActivity.highScore = highScore;
		Editor editor = prefs.edit();
		editor.putInt(highScoreKey, highScore);
		editor.commit();
		Log.d("GameMainActivity", "score set is "+highScore);			
		//LeaderBoard  & Achievements !!
		
		//TODO Submit to leaderBoards
		if (isSignedIntoGoogle()) {
			Games.Leaderboards.submitScore(instance.getApiClient(),LEADERBOARD_ID, highScore);
			
			if(!testingMode){
				if (highScore >= 5 ){
					Games.Achievements.unlock(instance.getApiClient(), "CgkI3bDN4OQZEAIQAg" );
				}
				if (highScore >= 10 ){
					Games.Achievements.unlock(instance.getApiClient(), "CgkI3bDN4OQZEAIQAw" );
				}
				if (highScore >= 100 ){
					Games.Achievements.unlock(instance.getApiClient(), "CgkI3bDN4OQZEAIQBA" );
				}
				if (highScore >= 500 ){
					Games.Achievements.unlock(instance.getApiClient(), "CgkI3bDN4OQZEAIQBg" );			
				}
//				if (highScore >= 35 ){
//					Games.Achievements.unlock(instance.getApiClient(), "CgkIkt6rpcgPEAIQBg" );				
//				}
//			}
//			else{//Test Mode for Achievements
//				if (highScore >= 10 ){
//					Games.Achievements.unlock(instance.getApiClient(), "CgkIvKPCpKwREAIQAg" );
//				}
//				if (highScore >= 20 ){
//					Games.Achievements.unlock(instance.getApiClient(), "CgkIvKPCpKwREAIQAw" );
//				}
				
				
			}
						
		}
		
	}
	
	
	private int retrieveHighScore() {
		return prefs.getInt(highScoreKey, 0);
	}
	
	private boolean retrievePremiumStatus() {
		return prefs.getBoolean(premiumKey, false);
		
	}
	
	public static void setLanguageCode(int languageId) {
		GameMainActivity.languageId = languageId;
		Editor editor = prefs.edit();
		editor.putInt(languageCodeKey, languageId);
		editor.commit();
		//0 = English
		//1 = Greek
		// ...
	}
	
	
    //**********************************************************************************//
	//********************* Google Play Payment Methods*********************************//
    //**********************************************************************************//

	private void setPremiumStatus(boolean value){
		Editor editor = prefs.edit();
		editor.putBoolean(premiumKey, value);
		editor.commit();
		Log.d("GameMainActivity", "premium is "+value);	
	}
	
    // Listener that's called when we finish querying the items and subscriptions we own
    IabHelper.QueryInventoryFinishedListener mGotInventoryListener = new IabHelper.QueryInventoryFinishedListener() {
        public void onQueryInventoryFinished(IabResult result, Inventory inventory) {
            Log.d(TAG, "Query inventory finished.");

            // Have we been disposed of in the meantime? If so, quit.
            if (mHelper == null) return;

            // Is it a failure?
            if (result.isFailure()) {
                complain("Failed to query inventory: " + result);
                return;
            }

            Log.d(TAG, "Query inventory was successful.");

            /*
             * Check for items we own. Notice that for each purchase, we check
             * the developer payload to see if it's correct! See
             * verifyDeveloperPayload().
             */

            // Do we have the premium upgrade?
            Purchase premiumPurchase = inventory.getPurchase(SKU_PREMIUM);
            mIsPremium = (premiumPurchase != null && verifyDeveloperPayload(premiumPurchase));
            
            setPremiumStatus(mIsPremium);
            
            Log.d(TAG, "User is " + (mIsPremium ? "PREMIUM" : "NOT PREMIUM"));
           //here store key
            //Other payment options can be placed here ,consumption plans
            
            
          //  updateUi();
            setWaitScreen(false);
            Log.d(TAG, "Initial inventory query finished; enabling main UI.");
        }
    };
    

    // Enables or disables the "please wait" screen.
    static void setWaitScreen(boolean set) {
    	// TODO add a blur allover the screen...
    	if(set){
    		waitForPurhcace = set;
    		//Toast.makeText(sGame.getContext(), "please wait payment to complete",Toast.LENGTH_SHORT).show();
    	}
    	else{
    		waitForPurhcace = set;
    	}
    	  
    }


    static void alert(String message) {
//        AlertDialog.Builder bld = new AlertDialog.Builder(sGame.getContext());
//        bld.setMessage(message);
//        bld.setNeutralButton("OK", null);
//        Log.d(TAG, "Showing alert dialog: " + message);
//        bld.create().show();
    }
    

    /** Verifies the developer payload of a purchase. */
    static boolean verifyDeveloperPayload(Purchase p) {
        String payload = p.getDeveloperPayload();

        /*
         * TODO: verify that the developer payload of the purchase is correct. It will be
         * the same one that you sent when initiating the purchase.
         *
         * WARNING: Locally generating a random string when starting a purchase and
         * verifying it here might seem like a good approach, but this will fail in the
         * case where the user purchases an item on one device and then uses your app on
         * a different device, because on the other device you will not have access to the
         * random string you originally generated.
         *
         * So a good developer payload has these characteristics:
         *
         * 1. If two different users purchase an item, the payload is different between them,
         *    so that one user's purchase can't be replayed to another user.
         *
         * 2. The payload must be such that you can verify it even when the app wasn't the
         *    one who initiated the purchase flow (so that items purchased by the user on
         *    one device work on other devices owned by the user).
         *
         * Using your own server to store and verify developer payloads across app
         * installations is recommended.
         */

        return true;
    }
    
    // User clicked the "Upgrade to Premium" button.
    public static void onUpgradeAppButtonClicked() {
        Log.d(TAG, "Upgrade button clicked; launching purchase flow for upgrade.");
        setWaitScreen(true);

        /* TODO: for security, generate your payload here for verification. See the comments on
         *        verifyDeveloperPayload() for more info. Since this is a SAMPLE, we just use
         *        an empty string, but on a production app you should carefully generate this. */
        String payload = "";

        mHelper.launchPurchaseFlow(instance, SKU_PREMIUM, RC_REQUEST,
                mPurchaseFinishedListener, payload);
    }
    
    // Callback for when a purchase is finished
    static IabHelper.OnIabPurchaseFinishedListener mPurchaseFinishedListener = new IabHelper.OnIabPurchaseFinishedListener() {
        public void onIabPurchaseFinished(IabResult result, Purchase purchase) {
            Log.d(TAG, "Purchase finished: " + result + ", purchase: " + purchase);

            // if we were disposed of in the meantime, quit.
            if (mHelper == null) return;

            if (result.isFailure()) {
                complain("Error purchasing: " + result);
                setWaitScreen(false);
                return;
            }
            if (!verifyDeveloperPayload(purchase)) {
                complain("Error purchasing. Authenticity verification failed.");
                setWaitScreen(false);
                return;
            }

            Log.d(TAG, "Purchase successful.");
            	if (purchase.getSku().equals(SKU_PREMIUM)) {
                // bought the premium upgrade!
                Log.d(TAG, "Purchase is premium upgrade. Congratulating user.");
                alert("Thank you for upgrading to premium!");
                Toast.makeText(sGame.getContext(), "please restart app for changes to take effect",Toast.LENGTH_LONG).show();
                mIsPremium = true;           
                setWaitScreen(false);
            }
        }
    };
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d(TAG, "onActivityResult(" + requestCode + "," + resultCode + "," + data);
        if (mHelper == null) return;

        // Pass on the activity result to the helper for handling
        if (!mHelper.handleActivityResult(requestCode, resultCode, data)) {
            // not handled, so handle it ourselves (here's where you'd
            // perform any handling of activity results not related to in-app
            // billing...
            super.onActivityResult(requestCode, resultCode, data);
        }
        else {
            Log.d(TAG, "onActivityResult handled by IABUtil.");
        }
    }
    
	
    static void complain(String message) {
        Log.e(TAG, "**** Error: " + message);
        alert("Error: " + message);
    }

    

	

    //**********************************************************************************//
	//********************* Google Play Games Methods LeaderBoard***********************//
    //**********************************************************************************//
    
    
	// Can optionally implement some kind of action when sign in fails.
	@Override
	public void onSignInFailed() {
	}

	// When Sign In is successful, we submit the current local high score to the server
	@Override
	public void onSignInSucceeded() {
		Games.Leaderboards.submitScore(instance.getApiClient(), LEADERBOARD_ID,
				highScore);
	}

	// Static Methods for Other Game Classes to Access
	
	// This allows us to determine from other classes whether the user is
	// currently signed in.
	public static boolean isSignedIntoGoogle() {
		return instance.isSignedIn();
	}

	// This method will open a new Activity (ON TOP of GameMainActivity)
	// That shows the global leaderboard.
	public static void showLeaderboard() {
		instance.startActivityForResult(Games.Leaderboards
				.getLeaderboardIntent(instance.getApiClient(), LEADERBOARD_ID),
				0);
	}
	
	// This method is called when the Google Sign In/Sign Out Button is pressed.
	public static void onGoogleButtonPress() {
		if (isSignedIntoGoogle()) {
			instance.signOut();
		} else {
			instance.beginUserInitiatedSignIn();
		}
	}
	
  
}
