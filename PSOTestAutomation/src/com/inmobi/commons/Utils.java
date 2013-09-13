package com.inmobi.commons;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import android.os.Build;
import android.os.Looper;
import android.util.Log;

import com.inmobi.androidsdk.IMAdInterstitial;
import com.inmobi.androidsdk.IMAdView;
import com.inmobi.commons.internal.Log.INTERNAL_LOG_LEVEL;

public class Utils {

	public String LOG_TAG = "PSOTEST";		// logger tag
	
	// #############################################################################################################################
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}


	// #############################################################################################################################
	/*
	 * constructing ad-server url, runtime.
	 */
	public boolean setAdServerURI(IMAdView adView, String serverUrl) {
		boolean flag = false;
		Method method;
		try {
			method = (Method) adView.getClass().getDeclaredMethod(
					"setAdServerUrl", String.class);
			method.setAccessible(true);
			method.invoke(adView, serverUrl);
			flag = true;
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return flag;
	}

	
	// #############################################################################################################################
	/*
	 * constructing ad-server url, runtime.
	 */
	public boolean setAdServerURI(IMAdInterstitial adView, String serverUrl) {
		boolean flag = false;
		Method method;
		Log.d(LOG_TAG, "view - " + adView.toString() + " server - " + serverUrl);
		try {
			method = (Method) adView.getClass().getDeclaredMethod(
					"setAdServerUrl", String.class);
			method.setAccessible(true);
			method.invoke(adView, serverUrl);
			flag = true;
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	
	// #############################################################################################################################
	/*
	 * constructing ad-server url, runtime.
	 */
	public void waitThread(int interval) {
		try {
			synchronized (Looper.getMainLooper().getThread()) {
				Looper.getMainLooper().getThread().wait(interval);
			}
		} catch (InterruptedException e) {

		}
	}
	
	// #############################################################################################################################
	/*
	 * constructing ad-server url, runtime.
	 */
	public String buildAdServerURI(Map<String, String> urlParameters) {

		String respSrvUrl = null;		
		HashMap<String, String> deviceInfo = getDeviceDetails();
		String platform = deviceInfo.get("os") + "_" + deviceInfo.get("osversion") + "_" + deviceInfo.get("sdkversion") + "_" + deviceInfo.get("handset");
		Log.d(LOG_TAG, "URL Params: " + urlParameters.toString());
		
		respSrvUrl = "http://" + 
				urlParameters.get("hostip") + 
				":" + 
				urlParameters.get("port") +
				"/psowebapp/rspserver?rqparam=" +
				"/test=" + urlParameters.get("testcaseid") + 
				"/platform=" + platform + 
				"/release=" + urlParameters.get("release") + 
				"/adtype=" + urlParameters.get("adtype") + 
				"/creative=" + urlParameters.get("creative") + 
				"/slotid=" + urlParameters.get("slotid");

		Log.d(LOG_TAG, "Ad-Server URL: " + respSrvUrl);
		return respSrvUrl;

	} // getResponseServerURL()

	// #############################################################################################################################
	/*
	 * Fetching device related information.
	 */
	public HashMap<String, String> getDeviceDetails() {
		HashMap<String, String> deviceDetails = new HashMap<String, String>();
		
		// build platform string using device info
		deviceDetails.put("os", "Android");
		deviceDetails.put("devicename", Build.MODEL);
		String model = null;
		if ( deviceDetails.get("devicename").equalsIgnoreCase("gt-i9300") ) {			// fetching model name mappings should be moved to a config/properties file.	
			model = "S3";
		} else if (deviceDetails.get("devicename").equalsIgnoreCase("gt-i9100") ) {
			model = "S2";
		} else {
			Log.d("\n" + LOG_TAG, deviceDetails.get("devicename") + " - Device is not registered in the code base... " + "\n");
		}
		deviceDetails.put("osversion", Build.VERSION.RELEASE);
		deviceDetails.put("manufacturer", Build.MANUFACTURER);
		deviceDetails.put("handset", deviceDetails.get("manufacturer") + "-" + model);
		deviceDetails.put("sdkversion", "SDK-" + IMCommonUtil.getReleaseVersion() );
		
		return deviceDetails;
	
	}	// getDeviceDetails()
	
}
// #################################	End - class #################################