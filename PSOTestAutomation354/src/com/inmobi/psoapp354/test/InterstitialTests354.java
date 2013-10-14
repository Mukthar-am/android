package com.inmobi.psoapp354.test;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;

import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;

import com.inmobi.androidsdk.IMAdInterstitial;
import com.inmobi.androidsdk.IMAdRequest;
import com.inmobi.app.sdk354.InMobiAdActivity354;
import com.inmobi.commons.Utils;
//import com.inmobi.commons.internal.IMLog.INTERNAL_LOG_LEVEL;
import com.jayway.android.robotium.solo.Solo;


public class InterstitialTests354 extends ActivityInstrumentationTestCase2<InMobiAdActivity354> {

	private static final String APPID = "psoapp123";
	private InMobiAdActivity354 testActivity; 	// The test activity.
	public IMAdRequest mIMAdRequest;
	
	public IMAdInterstitial imAdInterstitialViewObj;				// object to hold the test-activity
	public Solo solo;						// object for robotium

	// Fields
	public String slotSize = "";
	private String adtype = "interstitial";
	public String LOG_TAG = "PSOTEST";		// logger tag
	private String HOSTIP = "10.14.126.80";
	private String PORT = "8080";

	private HashMap<String, String> urlParams = new HashMap<String, String>();

	Utils utils = new Utils();

	// ################################################################################
	public InterstitialTests354() {
		super(InMobiAdActivity354.class);
	}

	// ################################################################################
	@Before
	protected void setUp() throws Exception {
		super.setUp();
		
		// This is changed in SDK-354
		//com.inmobi.commons.internal.IMLog.setInternalLogLevel(INTERNAL_LOG_LEVEL.INTERNAL);

		testActivity = getActivity();
		imAdInterstitialViewObj = testActivity.imAdInterstitial;
		solo = new Solo(getInstrumentation(), testActivity);	// robotium api initilization

		urlParams.put("hostip", HOSTIP);
		urlParams.put("port", PORT);

	}	// end setup()


	// ################################################################################
	// Test cases for INTERSTITIAL ads
	/* 
	 * Steps for serving a interstitial ads on a layout
	 * 1. build ad-server url
	 * 2. inflate or load interstitial ad view app-id
	 * 3. set ad-server url over the interstitial ad-view
	 * 4. loadad() over interstitial ad-view object
	 * 5. showAd() over runOnUiThread method
	 * 6. take a snapshot and 
	 * 7. solo.click()
	 */
	
	
	public void testInterstitialAds_Async_Slot320x480_Creative640x960_FlexiTest1() {
		String slotSize = "320x480";
		String creative = "640x960";				// These variables are to be parameterized
		String releaseType = "imai_async";		// These variables are to be parameterized
		String testCaseId = getName();

		// building the request url parameters:
		urlParams.put("testcaseid", testCaseId);
		urlParams.put("release", releaseType);
		urlParams.put("adtype", adtype);
		urlParams.put("slotid", slotSize);
		urlParams.put("creative", creative);
		
		String adServerURL = utils.buildAdServerURI(urlParams);	// method to build ad-server url with test params
		Log.d(LOG_TAG, "URL: " + adServerURL);

		this.inflateInterstitialLayout("portrait");			// inflating layout based on slot-size
		utils.setAdServerURI(imAdInterstitialViewObj, adServerURL);
		Log.d(LOG_TAG, " adServerURL - " + adServerURL);

		
		utils.loadAndShowInterstitialAd(mIMAdRequest, imAdInterstitialViewObj, testActivity);
		String snapshotFile = getName() + testCaseId.toString();
		solo.takeScreenshot(snapshotFile);

		// Change orientation from portrait to landscape to check the scalability of the creative and generate click event
		testActivity.setRequestedOrientation(0);	// 0 - landscape
		solo.takeScreenshot(snapshotFile + "_ScaledLandscape");
		utils.waitThread(3000);
		
		// Comment by Mukthar:
		// Hitting close button and reloading the ad is to be automated here.
		//
		//	- place holder -
		//
		
		// gen click event
		solo.clickOnScreen(160, 240);
		utils.waitThread(3000);
		
	} // end testInterstitialAds
	
	
//	@Test
//	public void testInterstitialAds_Async_Slot320x480_Creative640x960_FlexiTest2() {
//		String slotSize = "480x320";
//		String creative = "960x640";				// These variables are to be parameterized
//		String releaseType = "imai_async";		// These variables are to be parameterized
//		String testCaseId = getName();
//
//		// building the request url parameters:
//		urlParams.put("testcaseid", testCaseId);
//		urlParams.put("release", releaseType);
//		urlParams.put("adtype", adtype);
//		urlParams.put("slotid", slotSize);
//		urlParams.put("creative", creative);
//		
//		String adServerURL = utils.buildAdServerURI(urlParams);	// method to build ad-server url with test params
//		Log.d(LOG_TAG, "URL: " + adServerURL);
//
//		this.inflateInterstitialLayout("landscape");			// inflating layout based on slot-size
//		utils.setAdServerURI(imAdInterstitialViewObj, adServerURL);
//		Log.d(LOG_TAG, " adServerURL - " + adServerURL);
//
//		utils.loadAndShowInterstitialAd(mIMAdRequest, imAdInterstitialViewObj, testActivity);
//		String snapshotFile = getName() + testCaseId.toString();
//		solo.takeScreenshot(snapshotFile);
//
//		// Change orientation from portrait to landscape to check the scalability of the creative and generate click event
//		testActivity.setRequestedOrientation(1);
//		solo.takeScreenshot(snapshotFile + "_ScaledLandscape");
//		utils.waitThread(3000);
//		
//		
//		// Comment by Mukthar:
//		// Hitting close button and reloading the ad is to be automated here.
//		//
//		//	- place holder -
//		//
//		
//		// gen click event
//		solo.clickOnScreen(160, 240);
//		utils.waitThread(3000);
//		
//	} // end testInterstitialAds
//	
//	// ################################################################################	
//	@Test
//	public void testInterstitialAds_Async_Slot320x480_Creative320x480() {
//		String slotSize = "320x480";
//		String creative = "320x480";				// These variables are to be parameterized
//		String releaseType = "imai_async";		// These variables are to be parameterized
//		String testCaseId = getName();
//
//		// building the request url parameters:
//		urlParams.put("testcaseid", testCaseId);
//		urlParams.put("release", releaseType);
//		urlParams.put("adtype", adtype);
//		urlParams.put("slotid", slotSize);
//		urlParams.put("creative", creative);
//		
//		String adServerURL = utils.buildAdServerURI(urlParams);	// method to build ad-server url with test params
//		Log.d(LOG_TAG, "URL: " + adServerURL);
//
//		this.inflateInterstitialLayout("portrait");			// inflating layout based on slot-size
//		utils.setAdServerURI(imAdInterstitialViewObj, adServerURL);
//		Log.d(LOG_TAG, " adServerURL - " + adServerURL);
//
//		utils.loadAndShowInterstitialAd(mIMAdRequest, imAdInterstitialViewObj, testActivity);
//		String snapshotFile = getName() + testCaseId.toString();
//		solo.takeScreenshot(snapshotFile);
//
//		// gen click event
//		solo.clickOnScreen(160, 240);
//		utils.waitThread(3000);
//	} // end testInterstitialAds
//
//
//	// ################################################################################
//	// Test cases for INTERSTITIAL ads
//	@Test
//	public void testInterstitialAds_Async_Slot320x480_Creative300x250() {
//		String slotSize = "320x480";
//		String creative = "300x250";				// These variables are to be parameterized
//		String releaseType = "imai_async";		// These variables are to be parameterized
//		String testCaseId = getName();
//
//		// building the request url parameters:
//		urlParams.put("testcaseid", testCaseId);
//		urlParams.put("release", releaseType);
//		urlParams.put("adtype", adtype);
//		urlParams.put("slotid", slotSize);
//		urlParams.put("creative", creative);
//		
//		String adServerURL = utils.buildAdServerURI(urlParams);	// method to build ad-server url with test params
//		Log.d(LOG_TAG, "URL: " + adServerURL);
//
//		this.inflateInterstitialLayout("portrait");			// inflating layout based on slot-size
//		utils.setAdServerURI(imAdInterstitialViewObj, adServerURL);
//		Log.d(LOG_TAG, " adServerURL - " + adServerURL);
//
//		utils.loadAndShowInterstitialAd(mIMAdRequest, imAdInterstitialViewObj, testActivity);		
//		String snapshotFile = getName() + testCaseId.toString();
//		solo.takeScreenshot(snapshotFile);
//
//		// gen click event
//		solo.clickOnScreen(100, 100);
//		utils.waitThread(3000);
//	} // end testInterstitialAds
//
//	
//	// ################################################################################
//	// Test cases for INTERSTITIAL ads
//	@Test
//	public void testInterstitialAds_Async_Slot320x480_Creative600x500() {
//		String slotSize = "320x480";
//		String creative = "600x500";				// These variables are to be parameterized
//		String releaseType = "imai_async";		// These variables are to be parameterized
//		String testCaseId = getName();
//
//		// building the request url parameters:
//		urlParams.put("testcaseid", testCaseId);
//		urlParams.put("release", releaseType);
//		urlParams.put("adtype", adtype);
//		urlParams.put("slotid", slotSize);
//		urlParams.put("creative", creative);
//		
//		String adServerURL = utils.buildAdServerURI(urlParams);	// method to build ad-server url with test params
//		Log.d(LOG_TAG, "URL: " + adServerURL);
//
//		this.inflateInterstitialLayout("portrait");			// inflating layout based on slot-size
//		utils.setAdServerURI(imAdInterstitialViewObj, adServerURL);
//		Log.d(LOG_TAG, " adServerURL - " + adServerURL);
//
//		utils.loadAndShowInterstitialAd(mIMAdRequest, imAdInterstitialViewObj, testActivity);		
//		String snapshotFile = getName() + testCaseId.toString();
//		solo.takeScreenshot(snapshotFile);
//
//		// gen click event
//		solo.clickOnScreen(100, 100);
//		utils.waitThread(3000);
//	} // end testInterstitialAds
//
//	// ################################################################################
//	// Test cases for INTERSTITIAL ads
//	@Test
//	public void testInterstitialAds_Async_Slot320x480_Creative640x960() {
//		String slotSize = "320x480";
//		String creative = "640x960";				// These variables are to be parameterized
//		String releaseType = "imai_async";		// These variables are to be parameterized
//		String testCaseId = getName();
//
//		// building the request url parameters:
//		urlParams.put("testcaseid", testCaseId);
//		urlParams.put("release", releaseType);
//		urlParams.put("adtype", adtype);
//		urlParams.put("slotid", slotSize);
//		urlParams.put("creative", creative);
//		
//		String adServerURL = utils.buildAdServerURI(urlParams);	// method to build ad-server url with test params
//		Log.d(LOG_TAG, "URL: " + adServerURL);
//
//		this.inflateInterstitialLayout("portrait");			// inflating layout based on slot-size
//		utils.setAdServerURI(imAdInterstitialViewObj, adServerURL);
//		Log.d(LOG_TAG, " adServerURL - " + adServerURL);
//
//		utils.loadAndShowInterstitialAd(mIMAdRequest, imAdInterstitialViewObj, testActivity);		
//		String snapshotFile = getName() + testCaseId.toString();
//		solo.takeScreenshot(snapshotFile);
//
//		// gen click event
//		solo.clickOnScreen(100, 100);
//		utils.waitThread(3000);
//	} // end testInterstitialAds
//
//
//	// ################################################################################
//	// #########	SYNC TESTS ##########
//	// Test cases for INTERSTITIAL ads
//	@Test
//	public void testInterstitialAds_Sync_Slot320x480_Creative320x480() {
//		String slotSize = "320x480";
//		String creative = "320x480";				// These variables are to be parameterized
//		String releaseType = "imai_async";		// These variables are to be parameterized
//		String testCaseId = getName();
//
//		// building the request url parameters:
//		urlParams.put("testcaseid", testCaseId);
//		urlParams.put("release", releaseType);
//		urlParams.put("adtype", adtype);
//		urlParams.put("slotid", slotSize);
//		urlParams.put("creative", creative);
//		
//		String adServerURL = utils.buildAdServerURI(urlParams);	// method to build ad-server url with test params
//		Log.d(LOG_TAG, "URL: " + adServerURL);
//
//		this.inflateInterstitialLayout("portrait");			// inflating layout based on slot-size
//		utils.setAdServerURI(imAdInterstitialViewObj, adServerURL);
//		Log.d(LOG_TAG, " adServerURL - " + adServerURL);
//
//		utils.loadAndShowInterstitialAd(mIMAdRequest, imAdInterstitialViewObj, testActivity);		
//		String snapshotFile = getName() + testCaseId.toString();
//		solo.takeScreenshot(snapshotFile);
//
//		// gen click event
//		solo.clickOnScreen(100, 100);
//		utils.waitThread(3000);
//	} // end testInterstitialAds
//
//
//	// ################################################################################
//	// Test cases for INTERSTITIAL ads
//	@Test
//	public void testInterstitialAds_Sync_Slot320x480_Creative300x250() {
//		String slotSize = "320x480";
//		String creative = "300x250";				// These variables are to be parameterized
//		String releaseType = "imai_async";		// These variables are to be parameterized
//		String testCaseId = getName();
//
//		// building the request url parameters:
//		urlParams.put("testcaseid", testCaseId);
//		urlParams.put("release", releaseType);
//		urlParams.put("adtype", adtype);
//		urlParams.put("slotid", slotSize);
//		urlParams.put("creative", creative);
//		
//		String adServerURL = utils.buildAdServerURI(urlParams);	// method to build ad-server url with test params
//		Log.d(LOG_TAG, "URL: " + adServerURL);
//
//		this.inflateInterstitialLayout("portrait");			// inflating layout based on slot-size
//		utils.setAdServerURI(imAdInterstitialViewObj, adServerURL);
//		Log.d(LOG_TAG, " adServerURL - " + adServerURL);
//
//		utils.loadAndShowInterstitialAd(mIMAdRequest, imAdInterstitialViewObj, testActivity);		
//		String snapshotFile = getName() + testCaseId.toString();
//		solo.takeScreenshot(snapshotFile);
//
//		// gen click event
//		solo.clickOnScreen(100, 100);
//		utils.waitThread(3000);
//	} // end testInterstitialAds
//
//	// ################################################################################
//	// Test cases for INTERSTITIAL ads
//	@Test
//	public void testInterstitialAds_Sync_Slot320x480_Creative600x500() {
//		String slotSize = "320x480";
//		String creative = "600x500";				// These variables are to be parameterized
//		String releaseType = "imai_async";		// These variables are to be parameterized
//		String testCaseId = getName();
//
//		// building the request url parameters:
//		urlParams.put("testcaseid", testCaseId);
//		urlParams.put("release", releaseType);
//		urlParams.put("adtype", adtype);
//		urlParams.put("slotid", slotSize);
//		urlParams.put("creative", creative);
//		
//		String adServerURL = utils.buildAdServerURI(urlParams);	// method to build ad-server url with test params
//		Log.d(LOG_TAG, "URL: " + adServerURL);
//
//		this.inflateInterstitialLayout("portrait");			// inflating layout based on slot-size
//		utils.setAdServerURI(imAdInterstitialViewObj, adServerURL);
//		Log.d(LOG_TAG, " adServerURL - " + adServerURL);
//
//		utils.loadAndShowInterstitialAd(mIMAdRequest, imAdInterstitialViewObj, testActivity);		
//		String snapshotFile = getName() + testCaseId.toString();
//		solo.takeScreenshot(snapshotFile);
//
//		// gen click event
//		solo.clickOnScreen(100, 100);
//		utils.waitThread(3000);
//	} // end testInterstitialAds
//
//	// ################################################################################
//	// Test cases for INTERSTITIAL ads
//	@Test
//	public void testInterstitialAds_Sync_Slot320x480_Creative640x960() {
//		String slotSize = "320x480";
//		String creative = "640x960";				// These variables are to be parameterized
//		String releaseType = "imai_async";		// These variables are to be parameterized
//		String testCaseId = getName();
//
//		// building the request url parameters:
//		urlParams.put("testcaseid", testCaseId);
//		urlParams.put("release", releaseType);
//		urlParams.put("adtype", adtype);
//		urlParams.put("slotid", slotSize);
//		urlParams.put("creative", creative);
//		
//		String adServerURL = utils.buildAdServerURI(urlParams);	// method to build ad-server url with test params
//		Log.d(LOG_TAG, "URL: " + adServerURL);
//
//		this.inflateInterstitialLayout("portrait");			// inflating layout based on slot-size
//		utils.setAdServerURI(imAdInterstitialViewObj, adServerURL);
//		Log.d(LOG_TAG, " adServerURL - " + adServerURL);
//
//		utils.loadAndShowInterstitialAd(mIMAdRequest, imAdInterstitialViewObj, testActivity);		
//		String snapshotFile = getName() + testCaseId.toString();
//		solo.takeScreenshot(snapshotFile);
//
//		// gen click event
//		solo.clickOnScreen(100, 100);
//		utils.waitThread(3000);
//
//	} // end testInterstitialAds
//
//	
//	
//	
//	// ############################################################################################################
//	// ##################### LANDSCAPE MODE ########################
//	@Test
//	public void testInterstitialAds_Async_Slot480x320_Creative480x320() {
//		String slotSize = "320x480";
//		String creative = "320x480";				// These variables are to be parameterized
//		String releaseType = "imai_async";		// These variables are to be parameterized
//		String testCaseId = getName();
//
//		// building the request url parameters:
//		urlParams.put("testcaseid", testCaseId);
//		urlParams.put("release", releaseType);
//		urlParams.put("adtype", adtype);
//		urlParams.put("slotid", slotSize);
//		urlParams.put("creative", creative);
//		
//		String adServerURL = utils.buildAdServerURI(urlParams);	// method to build ad-server url with test params
//		Log.d(LOG_TAG, "URL: " + adServerURL);
//
//		this.inflateInterstitialLayout("landscape");			// inflating layout based on slot-size
//		utils.setAdServerURI(imAdInterstitialViewObj, adServerURL);
//		Log.d(LOG_TAG, " adServerURL - " + adServerURL);
//
//		utils.loadAndShowInterstitialAd(mIMAdRequest, imAdInterstitialViewObj, testActivity);		
//		String snapshotFile = getName() + testCaseId.toString();
//		solo.takeScreenshot(snapshotFile);
//
//		// gen click event
//		solo.clickOnScreen(100, 100);
//		utils.waitThread(3000);
//	} // end testInterstitialAds
//
//
//	// ################################################################################
//	// Test cases for INTERSTITIAL ads
//	@Test
//	public void testInterstitialAds_Async_Slot480x320_Creative300x250() {
//		String slotSize = "320x480";
//		String creative = "300x250";				// These variables are to be parameterized
//		String releaseType = "imai_async";		// These variables are to be parameterized
//		String testCaseId = getName();
//
//		// building the request url parameters:
//		urlParams.put("testcaseid", testCaseId);
//		urlParams.put("release", releaseType);
//		urlParams.put("adtype", adtype);
//		urlParams.put("slotid", slotSize);
//		urlParams.put("creative", creative);
//		
//		String adServerURL = utils.buildAdServerURI(urlParams);	// method to build ad-server url with test params
//		Log.d(LOG_TAG, "URL: " + adServerURL);
//
//		this.inflateInterstitialLayout("landscape");			// inflating layout based on slot-size
//		utils.setAdServerURI(imAdInterstitialViewObj, adServerURL);
//		Log.d(LOG_TAG, " adServerURL - " + adServerURL);
//
//		utils.loadAndShowInterstitialAd(mIMAdRequest, imAdInterstitialViewObj, testActivity);		
//		String snapshotFile = getName() + testCaseId.toString();
//		solo.takeScreenshot(snapshotFile);
//
//		// gen click event
//		solo.clickOnScreen(100, 100);
//		utils.waitThread(3000);
//	} // end testInterstitialAds
//
//	// ################################################################################
//	// Test cases for INTERSTITIAL ads
//	@Test
//	public void testInterstitialAds_Async_Slot480x320_Creative600x500() {
//		String slotSize = "320x480";
//		String creative = "600x500";				// These variables are to be parameterized
//		String releaseType = "imai_async";		// These variables are to be parameterized
//		String testCaseId = getName();
//
//		// building the request url parameters:
//		urlParams.put("testcaseid", testCaseId);
//		urlParams.put("release", releaseType);
//		urlParams.put("adtype", adtype);
//		urlParams.put("slotid", slotSize);
//		urlParams.put("creative", creative);
//		
//		String adServerURL = utils.buildAdServerURI(urlParams);	// method to build ad-server url with test params
//		Log.d(LOG_TAG, "URL: " + adServerURL);
//
//		this.inflateInterstitialLayout("landscape");			// inflating layout based on slot-size
//		utils.setAdServerURI(imAdInterstitialViewObj, adServerURL);
//		Log.d(LOG_TAG, " adServerURL - " + adServerURL);
//
//		utils.loadAndShowInterstitialAd(mIMAdRequest, imAdInterstitialViewObj, testActivity);		
//		String snapshotFile = getName() + testCaseId.toString();
//		solo.takeScreenshot(snapshotFile);
//
//		// gen click event
//		solo.clickOnScreen(100, 100);
//		utils.waitThread(3000);
//	} // end testInterstitialAds
//
//	// ################################################################################
//	// Test cases for INTERSTITIAL ads
//	@Test
//	public void testInterstitialAds_Async_Slot480x320_Creative960x640() {
//		String slotSize = "320x480";
//		String creative = "640x960";				// These variables are to be parameterized
//		String releaseType = "imai_async";		// These variables are to be parameterized
//		String testCaseId = getName();
//
//		// building the request url parameters:
//		urlParams.put("testcaseid", testCaseId);
//		urlParams.put("release", releaseType);
//		urlParams.put("adtype", adtype);
//		urlParams.put("slotid", slotSize);
//		urlParams.put("creative", creative);
//		
//		String adServerURL = utils.buildAdServerURI(urlParams);	// method to build ad-server url with test params
//		Log.d(LOG_TAG, "URL: " + adServerURL);
//
//		this.inflateInterstitialLayout("landscape");			// inflating layout based on slot-size
//		utils.setAdServerURI(imAdInterstitialViewObj, adServerURL);
//		Log.d(LOG_TAG, " adServerURL - " + adServerURL);
//
//		utils.loadAndShowInterstitialAd(mIMAdRequest, imAdInterstitialViewObj, testActivity);		
//		String snapshotFile = getName() + testCaseId.toString();
//		solo.takeScreenshot(snapshotFile);
//
//		// gen click event
//		solo.clickOnScreen(100, 100);
//		utils.waitThread(3000);
//	} // end testInterstitialAds
//
//
//	// ################################################################################
//	// #########	SYNC TESTS ##########
//	// Test cases for INTERSTITIAL ads
//	@Test
//	public void testInterstitialAds_Sync_Slot480x320_Creative480x320() {
//		String slotSize = "320x480";
//		String creative = "320x480";				// These variables are to be parameterized
//		String releaseType = "imai_async";		// These variables are to be parameterized
//		String testCaseId = getName();
//
//		// building the request url parameters:
//		urlParams.put("testcaseid", testCaseId);
//		urlParams.put("release", releaseType);
//		urlParams.put("adtype", adtype);
//		urlParams.put("slotid", slotSize);
//		urlParams.put("creative", creative);
//		
//		String adServerURL = utils.buildAdServerURI(urlParams);	// method to build ad-server url with test params
//		Log.d(LOG_TAG, "URL: " + adServerURL);
//
//		this.inflateInterstitialLayout("landscape");			// inflating layout based on slot-size
//		utils.setAdServerURI(imAdInterstitialViewObj, adServerURL);
//		Log.d(LOG_TAG, " adServerURL - " + adServerURL);
//
//		utils.loadAndShowInterstitialAd(mIMAdRequest, imAdInterstitialViewObj, testActivity);		
//		String snapshotFile = getName() + testCaseId.toString();
//		solo.takeScreenshot(snapshotFile);
//
//		// gen click event
//		solo.clickOnScreen(100, 100);
//		utils.waitThread(3000);
//	} // end testInterstitialAds
//
//
//	// ################################################################################
//	// Test cases for INTERSTITIAL ads
//	@Test
//	public void testInterstitialAds_Sync_Slot480x320_Creative300x250() {
//		String slotSize = "320x480";
//		String creative = "300x250";				// These variables are to be parameterized
//		String releaseType = "imai_async";		// These variables are to be parameterized
//		String testCaseId = getName();
//
//		// building the request url parameters:
//		urlParams.put("testcaseid", testCaseId);
//		urlParams.put("release", releaseType);
//		urlParams.put("adtype", adtype);
//		urlParams.put("slotid", slotSize);
//		urlParams.put("creative", creative);
//		
//		String adServerURL = utils.buildAdServerURI(urlParams);	// method to build ad-server url with test params
//		Log.d(LOG_TAG, "URL: " + adServerURL);
//
//		this.inflateInterstitialLayout("landscape");			// inflating layout based on slot-size
//		utils.setAdServerURI(imAdInterstitialViewObj, adServerURL);
//		Log.d(LOG_TAG, " adServerURL - " + adServerURL);
//
//		utils.loadAndShowInterstitialAd(mIMAdRequest, imAdInterstitialViewObj, testActivity);		
//		String snapshotFile = getName() + testCaseId.toString();
//		solo.takeScreenshot(snapshotFile);
//
//		// gen click event
//		solo.clickOnScreen(100, 100);
//		utils.waitThread(3000);
//	} // end testInterstitialAds
//
//	// ################################################################################
//	// Test cases for INTERSTITIAL ads
//	@Test
//	public void testInterstitialAds_Sync_Slot480x320_Creative600x500() {
//		String slotSize = "320x480";
//		String creative = "600x500";				// These variables are to be parameterized
//		String releaseType = "imai_async";		// These variables are to be parameterized
//		String testCaseId = getName();
//
//		// building the request url parameters:
//		urlParams.put("testcaseid", testCaseId);
//		urlParams.put("release", releaseType);
//		urlParams.put("adtype", adtype);
//		urlParams.put("slotid", slotSize);
//		urlParams.put("creative", creative);
//		
//		String adServerURL = utils.buildAdServerURI(urlParams);	// method to build ad-server url with test params
//		Log.d(LOG_TAG, "URL: " + adServerURL);
//
//		this.inflateInterstitialLayout("landscape");			// inflating layout based on slot-size
//		utils.setAdServerURI(imAdInterstitialViewObj, adServerURL);
//		Log.d(LOG_TAG, " adServerURL - " + adServerURL);
//
//		utils.loadAndShowInterstitialAd(mIMAdRequest, imAdInterstitialViewObj, testActivity);		
//		String snapshotFile = getName() + testCaseId.toString();
//		solo.takeScreenshot(snapshotFile);
//
//		// gen click event
//		solo.clickOnScreen(100, 100);
//		utils.waitThread(3000);
//	} // end testInterstitialAds
//
//	// ################################################################################
//	// Test cases for INTERSTITIAL ads
//	@Test
//	public void testInterstitialAds_Sync_Slot480x320_Creative960x640() {
//		String slotSize = "320x480";
//		String creative = "640x960";				// These variables are to be parameterized
//		String releaseType = "imai_async";		// These variables are to be parameterized
//		String testCaseId = getName();
//
//		// building the request url parameters:
//		urlParams.put("testcaseid", testCaseId);
//		urlParams.put("release", releaseType);
//		urlParams.put("adtype", adtype);
//		urlParams.put("slotid", slotSize);
//		urlParams.put("creative", creative);
//		
//		String adServerURL = utils.buildAdServerURI(urlParams);	// method to build ad-server url with test params
//		Log.d(LOG_TAG, "URL: " + adServerURL);
//
//		this.inflateInterstitialLayout("landscape");			// inflating layout based on slot-size
//		utils.setAdServerURI(imAdInterstitialViewObj, adServerURL);
//		Log.d(LOG_TAG, " adServerURL - " + adServerURL);
//
//		utils.loadAndShowInterstitialAd(mIMAdRequest, imAdInterstitialViewObj, testActivity);		
//		String snapshotFile = getName() + testCaseId.toString();
//		solo.takeScreenshot(snapshotFile);
//
//		// gen click event
//		solo.clickOnScreen(100, 100);
//		utils.waitThread(3000);
//	} // end testInterstitialAds
//	
//	
//	
//	// ################################################################################
//	/* 					TABLET RELATED TESTS EXECUTION FROM BELOW					*/
//	// ################################################################################
//	// Test cases for INTERSTITIAL ads
//	@Test
//	public void testInterstitialAds_Async_Slot800x1280_Creative800x1280() {
//		String slotSize = "800X1280";
//		String creative = "800X1280";				// These variables are to be parameterized
//		String releaseType = "imai_async";		// These variables are to be parameterized
//		String testCaseId = getName();
//
//		// building the request url parameters:
//		urlParams.put("testcaseid", testCaseId);
//		urlParams.put("release", releaseType);
//		urlParams.put("adtype", adtype);
//		urlParams.put("slotid", slotSize);
//		urlParams.put("creative", creative);
//		
//		String adServerURL = utils.buildAdServerURI(urlParams);	// method to build ad-server url with test params
//		Log.d(LOG_TAG, "URL: " + adServerURL);
//
//		this.inflateInterstitialLayout("landscape");			// inflating layout based on slot-size
//		utils.setAdServerURI(imAdInterstitialViewObj, adServerURL);
//		Log.d(LOG_TAG, " adServerURL - " + adServerURL);
//
//		utils.loadAndShowInterstitialAd(mIMAdRequest, imAdInterstitialViewObj, testActivity);		
//		String snapshotFile = getName() + testCaseId.toString();
//		solo.takeScreenshot(snapshotFile);
//
//		// gen click event
//		solo.clickOnScreen(100, 100);
//		utils.waitThread(3000);
//	} // end testInterstitialAds
//	
//	
//	@Test
//	public void testInterstitialAds_Async_Slot800x1280_Creative1600x2560() {
//		String slotSize = "800X1280";
//		String creative = "1600x2560";				// These variables are to be parameterized
//		String releaseType = "imai_async";		// These variables are to be parameterized
//		String testCaseId = getName();
//
//		// building the request url parameters:
//		urlParams.put("testcaseid", testCaseId);
//		urlParams.put("release", releaseType);
//		urlParams.put("adtype", adtype);
//		urlParams.put("slotid", slotSize);
//		urlParams.put("creative", creative);
//		
//		String adServerURL = utils.buildAdServerURI(urlParams);	// method to build ad-server url with test params
//		Log.d(LOG_TAG, "URL: " + adServerURL);
//
//		this.inflateInterstitialLayout("landscape");			// inflating layout based on slot-size
//		utils.setAdServerURI(imAdInterstitialViewObj, adServerURL);
//		Log.d(LOG_TAG, " adServerURL - " + adServerURL);
//
//		utils.loadAndShowInterstitialAd(mIMAdRequest, imAdInterstitialViewObj, testActivity);		
//		String snapshotFile = getName() + testCaseId.toString();
//		solo.takeScreenshot(snapshotFile);
//
//		// gen click event
//		solo.clickOnScreen(100, 100);
//		utils.waitThread(3000);
//	} // end testInterstitialAds
//
//	// Test cases for INTERSTITIAL ads
//	@Test
//	public void testInterstitialAds_Async_Slot1280x800_Creative1280x800() {
//		String slotSize = "1280x800";
//		String creative = "1280x800";				// These variables are to be parameterized
//		String releaseType = "imai_async";		// These variables are to be parameterized
//		String testCaseId = getName();
//
//		// building the request url parameters:
//		urlParams.put("testcaseid", testCaseId);
//		urlParams.put("release", releaseType);
//		urlParams.put("adtype", adtype);
//		urlParams.put("slotid", slotSize);
//		urlParams.put("creative", creative);
//		
//		String adServerURL = utils.buildAdServerURI(urlParams);	// method to build ad-server url with test params
//		Log.d(LOG_TAG, "URL: " + adServerURL);
//
//		this.inflateInterstitialLayout("landscape");			// inflating layout based on slot-size
//		utils.setAdServerURI(imAdInterstitialViewObj, adServerURL);
//		Log.d(LOG_TAG, " adServerURL - " + adServerURL);
//
//		utils.loadAndShowInterstitialAd(mIMAdRequest, imAdInterstitialViewObj, testActivity);		
//		String snapshotFile = getName() + testCaseId.toString();
//		solo.takeScreenshot(snapshotFile);
//
//		// gen click event
//		solo.clickOnScreen(100, 100);
//		utils.waitThread(3000);
//	} // end testInterstitialAds
//	
//	
//	@Test
//	public void testInterstitialAds_Async_Slot1280x800_Creative2560x1600() {
//		String slotSize = "1280x800";
//		String creative = "2560x1600";				// These variables are to be parameterized
//		String releaseType = "imai_async";		// These variables are to be parameterized
//		String testCaseId = getName();
//
//		// building the request url parameters:
//		urlParams.put("testcaseid", testCaseId);
//		urlParams.put("release", releaseType);
//		urlParams.put("adtype", adtype);
//		urlParams.put("slotid", slotSize);
//		urlParams.put("creative", creative);
//		
//		String adServerURL = utils.buildAdServerURI(urlParams);	// method to build ad-server url with test params
//		Log.d(LOG_TAG, "URL: " + adServerURL);
//
//		this.inflateInterstitialLayout("landscape");			// inflating layout based on slot-size
//		utils.setAdServerURI(imAdInterstitialViewObj, adServerURL);
//		Log.d(LOG_TAG, " adServerURL - " + adServerURL);
//
//		utils.loadAndShowInterstitialAd(mIMAdRequest, imAdInterstitialViewObj, testActivity);		
//		String snapshotFile = getName() + testCaseId.toString();
//		solo.takeScreenshot(snapshotFile);
//
//		// gen click event
//		solo.clickOnScreen(100, 100);
//		utils.waitThread(3000);
//	} // end testInterstitialAds

	
	// ##############################################################################################################################
	@After
	protected void tearDown() throws Exception {
		// super.tearDown();	
		try {
			solo.finalize();
		} catch (Throwable e) {
			e.printStackTrace();
			getActivity().finish();
			super.tearDown();
		}
	}
	
	// #############################################	Generic utility functions for interstitials	###########################################################################
	public void inflateInterstitialLayout (final String orientationType) {
		testActivity.runOnUiThread(new Runnable() {
			public void run() {
				imAdInterstitialViewObj = new IMAdInterstitial(testActivity, "appid123");
				utils.waitThread(2000);
				
				if (orientationType.equalsIgnoreCase("landscape")) {
					testActivity.setRequestedOrientation(0);
					
				} else if (orientationType.equalsIgnoreCase("portrait")) {
					testActivity.setRequestedOrientation(1);
					
				} else {
					Log.d(LOG_TAG, "+ INFO: No orientation selected, orientation will be flexi now...");
					
				}
			}
		});
		utils.waitThread(2000);

		String deviceIsTab = utils.isTablet(testActivity) ? "Android - Tablet" : "Android - Smartphone";
		Log.d(LOG_TAG, "\nDevice Type: " + deviceIsTab + " \n\n");
		
	}
	
	// ##############################################################################################################################


}
