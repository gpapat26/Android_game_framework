package com.animals.simpleandroidgdf;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

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
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
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
	private static final String premiumKey = "premiumkey";
	private static final String purchaseTokenKey = "purchaseTokenKey";
	
	public static Boolean purchaseTestModeOn = false;
	
	private static int highScore;
	
	public static boolean testingMode = false;
	private static  String LEADERBOARD_ID = null;
	public static GameMainActivity instance;
    public static final String TAG = "GameMainActivity";
	
	public static SharedPreferences prefs;	
	 // Does the user have the premium upgrade?
    public static boolean mIsPremium = false;
    
    public static final String SKU_PREMIUM = "sku_prem";
    
    // (arbitrary) request code for the purchase flow
    static final int RC_REQUEST = 10002;
    
    // The helper object
    public static IabHelper mHelper;
	public static boolean waitForPurhcace;
	
	public static Rect upperHalfScreen;
	public static Rect lowerHalfScreen;
	public static Rect upperLeftScore;
	public static Rect upperRightTimer;
	public static Rect wholeScreenMinus;
    
    //**********************************************************************************//
	//********************* Activity methods           *********************************//
    //**********************************************************************************//
    
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		Resources res = getResources();		
		
		purchaseTestModeOn = Boolean.valueOf(res.getString(R.string.purchase_Flow_test));		
		
		upperHalfScreen=new Rect(0,0,GAME_WIDTH,GAME_HEIGHT/2);
		lowerHalfScreen=new Rect(0,GAME_HEIGHT/2,GAME_WIDTH,GAME_HEIGHT);
		
		upperLeftScore=new Rect(0,0,GAME_WIDTH/4,GAME_HEIGHT/12);
		
		upperRightTimer=new Rect(4*(GAME_WIDTH/5),0,GAME_WIDTH,GAME_HEIGHT/12);
		
		wholeScreenMinus = new Rect(5,5,GAME_WIDTH-5,GAME_HEIGHT-5);
       
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
		
		if(retrievePremiumStatus()){
			mIsPremium = true;
			alertNonStatic("When opening app premium was found true");
		}
		else{
			mIsPremium = false;
			alertNonStatic("When opening app premium was found false");
		}
								
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
	
	
	public static int retrieveHighScore() {
		return prefs.getInt(highScoreKey, 0);
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

	private  void setPremiumStatus(boolean value , String token){
		try{
		GameMainActivity.mIsPremium = value; 
		
		Editor editor = prefs.edit();
		editor.putString(premiumKey, value+"");
		editor.putString(purchaseTokenKey, token);
		editor.commit();
		Log.d("GameMainActivity", "premium  boolean value is "+value + " and token is "+token);	
		}
		catch(Exception e){
			alertNonStatic("something went wrong while storing data");
			setWaitScreen(false);
		}
		alertNonStatic("Data is persisted OK!");
		alertNonStatic("prem boolean data is : " + value + " ,token is :"+ token );
	}
	
	public  Boolean retrievePremiumStatus() {
		String  value = null;
		try{
		  value =prefs.getString(premiumKey, "");				
		 
		}catch(Exception e){
			alertNonStatic("something went wrong while accessing data");
			 setWaitScreen(true);
		}
		alertNonStatic("retrieving premiumKey : "+value);
		
		if(value!= null && value.length() > 0 &&  value.equals("true")){
			return true;
		}
		
		return false;	
	}
	
	public  String retrievePremiumToken() {
		String  value = null;
		try{
			 value =prefs.getString(purchaseTokenKey, "");
			
		}catch(Exception e){
			alertNonStatic("something went wrong while accessing data");
		}
		alertNonStatic("retrieving purchaseTokenKey "+value);
		return value;	
	}
	
	
	
    // Listener that's called when we finish querying the items and subscriptions we own
    IabHelper.QueryInventoryFinishedListener mGotInventoryListener = new IabHelper.QueryInventoryFinishedListener() {
        public void onQueryInventoryFinished(IabResult result, Inventory inventory) {
            Log.d(TAG, "Query inventory finished.");

            // Have we been disposed of in the meantime? If so, quit.
            if (mHelper == null) {
                complain("Failed to query google inventory when App started (mHelper is null )");
            	return;
            }

            // Is it a failure?
            if (result.isFailure()) {
                complain("Failed to query google inventory when App started (result failure )");
                if(result != null){
                	   complain("Failed to query google inventory when App started (result failure ) with response  : " + result.getResponse());                    
                       complain("Failed to query google inventory when App started (result failure ) with  message : "+result.getMessage());
                }
             
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
            
          //  GameMainActivity.mIsPremium = (premiumPurchase != null && verifyDeveloperPayload(premiumPurchase));
           
            if(premiumPurchase != null && verifyDeveloperPayload(premiumPurchase)){
            	complain(TAG+" OnQuery is premium : " + mIsPremium);
            	Log.d(TAG,"re-loading carouzel map since mIsPremium ="+mIsPremium);
            	//preparePremiumStatus(premiumPurchase);
            	preparePremiumStatus(premiumPurchase.getmToken(), true);
            }
            else{
            	complain(TAG+" OnQuery from Google says  is not premium ");
            	Log.d(TAG," mIsPremium was found  "+mIsPremium);
            }
                     
            Log.d(TAG, " User is " + (mIsPremium ? "PREMIUM" : "NOT PREMIUM"));
                       
            Log.d(TAG, " Initial inventory query finished; enabling main UI.");
        }
    };
    

    // Enables or disables the "please wait" screen.
    static void setWaitScreen(boolean set) {
    	// TODO add a blur allover the screen...
    		waitForPurhcace = set;	  
    }

   
   
   public void alertNonStatic(final String message){
	   if(purchaseTestModeOn)
	   new Thread()
	   {
	       public void run()
	       {	    	  
	           runOnUiThread(new Runnable()
	           {
	               public void run()
	               {
	            	   
	            	   AlertDialog.Builder bld = new AlertDialog.Builder(sGame.getContext());
	                   bld.setMessage(message);
	                   bld.setNeutralButton("OK", null);
	                   Log.d(TAG, "Showing alert dialog: " + message);
	                   bld.create().show();
	                   
	               }
	           });
	       }
	   }.start();
   }
   
  
    

    /** Verifies the developer payload of a purchase. */
    static boolean verifyDeveloperPayload(Purchase p) {
        String payload = p.getDeveloperPayload();
        if(payload.equals("test")){
        	return true;
        }
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

        return false;
    }
    
    // User clicked the "Upgrade to Premium" button.
    public  void onUpgradeAppButtonClicked() {
        Log.d(TAG, "Upgrade button clicked; launching purchase flow for upgrade.");
        setWaitScreen(true);
        if(!retrievePremiumStatus()){
        	alertNonStatic("Status is not premium in database");
        }
       // alert("on upgrade button clicked");

        /* TODO: for security, generate your payload here for verification. See the comments on
         *        verifyDeveloperPayload() for more info. Since this is a SAMPLE, we just use
         *        an empty string, but on a production app you should carefully generate this. */
        String payload = "test";

        mHelper.launchPurchaseFlow(instance, SKU_PREMIUM, RC_REQUEST,
                mPurchaseFinishedListener, payload);
    }
    
    // Callback for when a purchase is finished --  > If purchase flow is followed
     IabHelper.OnIabPurchaseFinishedListener mPurchaseFinishedListener = new IabHelper.OnIabPurchaseFinishedListener() {
        public void onIabPurchaseFinished(IabResult result, Purchase purchase) {
        	
        	try{
            Log.d(TAG, "Purchase finished: " + result + ", purchase: " + purchase);
           // alert("mPurchaseFinishedListener");
            // if we were disposed of in the meantime, quit.
            if (mHelper == null) {
            	setWaitScreen(false);
            	return;
            }

            if (result.isFailure()) {
            	alertNonStatic("Error purchasing: " + result);
                setWaitScreen(false);
                return;
            }
            if (!verifyDeveloperPayload(purchase)) {
            	alertNonStatic("Error purchasing. Authenticity verification failed.");
                setWaitScreen(false);
                return;
            }

             Log.d(TAG, "Purchase successful.");
             
            if (purchase.getSku().equals(SKU_PREMIUM)) {
                // bought the premium upgrade!
                Log.d(TAG, "Purchase is premium upgrade. Congratulating user.");
                alertNonStatic("Thank you for upgrading to premium!");
                
                alertNonStatic("properties stored : " +true + " "+purchase.getmToken());
                          
                preparePremiumStatus(purchase.getmToken(), true);
                
                setWaitScreen(false);
            }
            else if(!purchase.getSku().equals(SKU_PREMIUM)){
            	alertNonStatic("This is not premium!!!!");
            	preparePremiumStatus(null, false);
                setWaitScreen(false);
            	}
        	}catch(Exception e){
        		alertNonStatic("Something went wrong in onIabPurchaseFinished "+e );
        		setWaitScreen(false);
        	}
        	 setWaitScreen(false);
        }


    };
    
    public void preparePremiumStatus(String  purchaseToken , Boolean isPremium){
        setPremiumStatus(isPremium,purchaseToken);               
        Assets.loadCarouzelMap();                                
    }
    

    
	public void onConsumePremiumItems() {
		setWaitScreen(true);
		queryforPremiumsAndConsumeWithContinuationToken(null);
		setWaitScreen(false);
	}
	
	public void onQueryForOwnedItems(){
		setWaitScreen(true);
		queryforOwnedItems();
		setWaitScreen(false);
	}
	
	  private void queryforOwnedItems() {
	    	Bundle ownedItems = null;
	    	
	    	try {
	    		
	    		ownedItems = mHelper.mService.getPurchases(3, sGame.getContext().getPackageName(), "inapp", null);
				
			} catch (RemoteException e) {
				alertNonStatic("Something went wrong when calling getPurcases");				
				return;
			}
	    	
	    	if(ownedItems == null || ownedItems.getInt("RESPONSE_CODE") !=0 ){
	    		alertNonStatic("Android returned null as a response");
	    		return ;
	    	}
	    	
	    	int response = ownedItems.getInt("RESPONSE_CODE");
	    	
	    	if (response == 0) {
	    		alertNonStatic("Google says request is valid!");
	    	   ArrayList<String>  purchaseDataList = ownedItems.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
	    	   
	    	   if(purchaseDataList == null){
	    		   alertNonStatic("Google says that there INAPP_PURCHASE_DATA_LIST does not exist or is empty");
	    	   }
	    	   if(purchaseDataList != null && purchaseDataList.size()==0){
	    		   alertNonStatic("Google says that INAPP_PURCHASE_DATA_LIST exist but there are no items retrieved!!");
	    	   }
	    	   
	    	   for (int i = 0; i < purchaseDataList.size(); ++i) {
	    	      String purchaseData = purchaseDataList.get(i);
	 
	    	      String token = null;
				  String sku = null;
				  
	    	      try {
					  JSONObject jo = new JSONObject(purchaseData);
					  token = jo.getString("purchaseToken");
					  sku = jo.getString("productId");
					  alertNonStatic("fetched sku :" + sku + " and token "+ token);				 	      
	    	      } catch (JSONException e) {
					alertNonStatic("unable to parse fetched json of owned items");
					return;
				  }
	    		    	        
	    	   }

	    	}
	    	else{
	    		alertNonStatic("Response from Google was not ok! i.e status == 0");	
	    	}
	  }
	  
	  
    private void queryforPremiumsAndConsumeWithContinuationToken(String continuationToken) {
    	
    	Bundle ownedItems = null;
    	
    	try {
    		
    		ownedItems = mHelper.mService.getPurchases(3, sGame.getContext().getPackageName(), "inapp", continuationToken);
			
		} catch (RemoteException e) {
			alertNonStatic("Something went wrong when calling getPurcases");
			return;
		}
    	
    	if(ownedItems == null){
    		alertNonStatic("Android returned null as a response");
    		return ;
    	}
    	
    	int response = ownedItems.getInt("RESPONSE_CODE");
    	
    	if (response == 0) {
//    	   ArrayList<String> ownedSkus =
//    	      ownedItems.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
    	   ArrayList<String>  purchaseDataList = ownedItems.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
//    	   ArrayList<String>  signatureList =
//    	      ownedItems.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
    	   String continuationTokenFetced =ownedItems.getString("INAPP_CONTINUATION_TOKEN");
    	   
    	   if(purchaseDataList == null){
    		   alertNonStatic("Google says that there INAPP_PURCHASE_DATA_LIST does not exist or is empty");
    	   }
    	   if(purchaseDataList != null && purchaseDataList.size()==0){
    		   alertNonStatic("Google says that INAPP_PURCHASE_DATA_LIST exist but there are no items retrieved!!");
    	   }

    	   for (int i = 0; i < purchaseDataList.size(); ++i) {
    	      String purchaseData = purchaseDataList.get(i);
 
    	      String token = null;
			  String sku = null;
			  
    	      try {
				  JSONObject jo = new JSONObject(purchaseData);
				  token = jo.getString("purchaseToken");
				  sku = jo.getString("productId");
				  alertNonStatic("fetched sku :" + sku + " and token "+ token);				 	      
    	      } catch (JSONException e) {
				alertNonStatic("unable to parse fetched json for consumption");
				return;
			  }
    	      if(token != null && sku != null &&  token.length() > 0 ){
       	       try {
       	    	alertNonStatic("generating request for consumption of  sku :"+sku + " and token :"+token);
					response = mHelper.mService.consumePurchase(3, getPackageName(), token);					
					response = ownedItems.getInt("RESPONSE_CODE");
					
					if (response == 0) {
						alertNonStatic(" You have successfully consumed sku " +sku + " with token "+  token);					
						preparePremiumStatus(token, false);						
					}else{
						alertNonStatic(" You have un successfully tried to consumed sku " +sku + " with token "+  token);					
					}

				} catch (RemoteException e) {
					alertNonStatic("unable to consume sku :"+ sku + " token "+token);
				}  

    	      }
    	        
    	   }

    	   // if continuationToken != null, call getPurchases again
    	   // and pass in the token to retrieve more items
    	   if(continuationTokenFetced != null && continuationTokenFetced.length() > 0){
    		   queryforPremiumsAndConsumeWithContinuationToken(continuationTokenFetced);   
    	   } 
    	   
    	   setWaitScreen(false);   	   
    	}
    	alertNonStatic("Response fron Google is not ok, we did not receive any owned items.");
    	setWaitScreen(false);  	   	
	}

//	public  void consumeAllOlderItems() {
//    	Bundle ownedItems = null;
//		try {
//			ownedItems = mHelper.mService.getPurchases(3, sGame.getContext().getPackageName(), "inapp", null);
//			
//		} catch (RemoteException e1) {
//			
//			e1.printStackTrace();
//		}
//    	int response = ownedItems.getInt("RESPONSE_CODE");
//    	
//    	if (response == 0)
//    	{
//    		alertNonStatic("consumeAllOlderItems() google responded ok to our consumables");
//    		
//    	    ArrayList<String> ownedSkus = ownedItems.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
//    	    if(ownedSkus != null && ownedSkus.size() > 0)    	    	
//    	    alertNonStatic("consumeAllOlderItems() ownedSkus is not empty");
//    	    
//    	    ArrayList<String> purchaseDataList = ownedItems.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
//    	    if(purchaseDataList != null && purchaseDataList.size() > 0)
//        	alertNonStatic("consumeAllOlderItems() purchaseDataList is not empty");
//    	      	    
//    	    ArrayList<String> signatureList = ownedItems.getStringArrayList("INAPP_DATA_SIGNATURE");
//    	    if(signatureList != null && signatureList.size() > 0)
//            	alertNonStatic("consumeAllOlderItems() signatureList is not empty");
//    	    
//    	    //String continuationToken = ownedItems.getString("INAPP_CONTINUATION_TOKEN");
//    	    
//    	    	alertNonStatic("consumeAllOlderItems() google responded ok to our consumables");
//    	    for (int i = 0; i < purchaseDataList.size(); ++i) {
//    	        try {
//    	            String purchaseData = purchaseDataList.get(i);
//    	            JSONObject jo = new JSONObject(purchaseData);
//    	            alertNonStatic("consumeAllOlderItems() JSON " +jo);
//    	            
//    	            if(jo != null && jo.length() > 0);
//    	            final String token = jo.getString("purchaseToken");
//    	            String sku = null;
//    	            String sig = null;
//    	            if (ownedSkus != null){
//    	                sku = ownedSkus.get(i);
//    	            	
//        	            if (signatureList != null && signatureList.size() > 0){
//        	            	 sig = signatureList.get(i);
//        	            	
//        	            }
//        	                
//        	            consume(sku, token, purchaseData,sig);
//    	            	
//    	            }
//    	         
//    	        } catch (JSONException e) {
//    	            e.printStackTrace();
//    	        }
//
//    	    }
//    	    
//    	
//    	}
//    	else if(response != 0){
//    		alertNonStatic("Response for older items is "+response);
//    	}
//		
//	}
//	
//
//
//	private  void consume(String sku, String token, String purchaseData,String sig) {
//		alertNonStatic("consume is trying to consume an item");
//		Purchase purchace = null;
//		try {
//			purchace = new Purchase("inapp", purchaseData, sig);
//		} catch (JSONException e) {
//			alertNonStatic("purchace item failed to be recreated "+e);
//			//e.printStackTrace();
//		}
//		
//		mHelper.consumeAsync(purchace,mConsumeFinishedListener);
//		
//	}

	// Called when consumption is complete
//     IabHelper.OnConsumeFinishedListener mConsumeFinishedListener = new IabHelper.OnConsumeFinishedListener() {
//        public void onConsumeFinished(Purchase purchase, IabResult result) {
//            Log.d(TAG, "Consumption finished. Purchase: " + purchase + ", result: " + result);
//
//            // if we were disposed of in the meantime, quit.
//            if (mHelper == null){
//            	alert(" onConsumeFinished failed due to null helper");
//            	setWaitScreen(false);
//            	return;
//            }
//
//            // We know this is the "gas" sku because it's the only one we consume,
//            // so we don't check which sku was consumed. If you have more than one
//            // sku, you probably should check...
//            if (result.isSuccess()) {           	           	
//            	setPremiumStatus(false, purchase.getmToken());             	
//                Log.d(TAG, "Consumption successful.");                            
//                alert(" Consumption is successfull");
//                setWaitScreen(false);
//            }
//            else {
//                complain("Error while consuming: " + result);
//                setWaitScreen(false);
//            }
//           
//            setWaitScreen(false);
//            Log.d(TAG, "End consumption flow.");
//        }
//    };

    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	
    	if (requestCode == 1001) {
    		alertNonStatic("onActivityResult says request code is 1001");
    		  if(data != null){
    			  
    	      int responseCode = data.getIntExtra("RESPONSE_CODE", 0); 	      
    	      String purchaseData = data.getStringExtra("INAPP_PURCHASE_DATA");
    	      String dataSignature = data.getStringExtra("INAPP_DATA_SIGNATURE");
    	      
    	      alertNonStatic("RESPONSE_CODE : "+responseCode + " purchaseData :"+purchaseData + "dataSignature : "+dataSignature );
    	      

    	      if (resultCode == RESULT_OK) {
    	    	  alertNonStatic("onActivityResult says result is ok");
    	         try {
    	            JSONObject jo = new JSONObject(purchaseData);
    	            String sku = jo.getString("productId");
    	            alertNonStatic("You have bought the " + sku + ". Excellent choice,adventurer!");
    	            String token = jo.getString("purchaseToken");
    	            alertNonStatic("You have bought the " + token + ". Excellent choice,adventurer!");
    	          }
    	          catch (JSONException e) {
    	        	  alertNonStatic("Failed to parse purchase data.");
    	             e.printStackTrace();
    	          }
    	      }
    	      else{
    	    	  alertNonStatic("onActivityResult says result is Nok");
    	      }
    	      
    		  }else{
    			  alertNonStatic("onActivityResult says data is null"); 
    		  }
    	   }
    	else{
    		alertNonStatic("onActivityResult says request code is NOT 1001");
    		setWaitScreen(false);
    	}

    	
        Log.d(TAG, "onActivityResult(" + requestCode + "," + resultCode + "," + data);
       
        if (mHelper == null){
        	setWaitScreen(false);
        	return;
        }

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
    
	
     void complain(String message) {
        Log.e(TAG, "**** Error: " + message);
        alertNonStatic("Error: " + message);
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
