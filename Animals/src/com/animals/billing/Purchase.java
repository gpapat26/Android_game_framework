/* Copyright (c) 2012 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.animals.billing;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Represents an in-app billing purchase.
 */
public class Purchase {
    String mItemType;  // ITEM_TYPE_INAPP or ITEM_TYPE_SUBS
    String mOrderId;
    String mPackageName;
    String mSku;
    long mPurchaseTime;
    int mPurchaseState;
    String mDeveloperPayload;
    String mToken;
    String mOriginalJson;
    String mSignature;

    public Purchase(String itemType, String jsonPurchaseInfo, String signature) throws JSONException {
        mItemType = itemType;
        mOriginalJson = jsonPurchaseInfo;
        JSONObject o = new JSONObject(mOriginalJson);
        mOrderId = o.optString("orderId");
        mPackageName = o.optString("packageName");
        mSku = o.optString("productId");
        mPurchaseTime = o.optLong("purchaseTime");
        mPurchaseState = o.optInt("purchaseState");
        mDeveloperPayload = o.optString("developerPayload");
        mToken = o.optString("token", o.optString("purchaseToken"));
        mSignature = signature;
    }
    
    
    public String getmItemType() {
		return mItemType;
	}


	public void setmItemType(String mItemType) {
		this.mItemType = mItemType;
	}


	public String getmOrderId() {
		return mOrderId;
	}


	public void setmOrderId(String mOrderId) {
		this.mOrderId = mOrderId;
	}


	public String getmPackageName() {
		return mPackageName;
	}


	public void setmPackageName(String mPackageName) {
		this.mPackageName = mPackageName;
	}


	public String getmSku() {
		return mSku;
	}


	public void setmSku(String mSku) {
		this.mSku = mSku;
	}


	public long getmPurchaseTime() {
		return mPurchaseTime;
	}


	public void setmPurchaseTime(long mPurchaseTime) {
		this.mPurchaseTime = mPurchaseTime;
	}


	public int getmPurchaseState() {
		return mPurchaseState;
	}


	public void setmPurchaseState(int mPurchaseState) {
		this.mPurchaseState = mPurchaseState;
	}


	public String getmDeveloperPayload() {
		return mDeveloperPayload;
	}


	public void setmDeveloperPayload(String mDeveloperPayload) {
		this.mDeveloperPayload = mDeveloperPayload;
	}


	public String getmToken() {
		return mToken;
	}


	public void setmToken(String mToken) {
		this.mToken = mToken;
	}


	public String getmOriginalJson() {
		return mOriginalJson;
	}


	public void setmOriginalJson(String mOriginalJson) {
		this.mOriginalJson = mOriginalJson;
	}


	public String getmSignature() {
		return mSignature;
	}


	public void setmSignature(String mSignature) {
		this.mSignature = mSignature;
	}


	public String getItemType() { return mItemType; }
    public String getOrderId() { return mOrderId; }
    public String getPackageName() { return mPackageName; }
    public String getSku() { return mSku; }
    public long getPurchaseTime() { return mPurchaseTime; }
    public int getPurchaseState() { return mPurchaseState; }
    public String getDeveloperPayload() { return mDeveloperPayload; }
    public String getToken() { return mToken; }
    public String getOriginalJson() { return mOriginalJson; }
    public String getSignature() { return mSignature; }

    @Override
    public String toString() { return "PurchaseInfo(type:" + mItemType + "):" + mOriginalJson; }
}
