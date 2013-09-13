//package com.inmobi.psoapp370.test;
//
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//import java.util.HashMap;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import android.graphics.Color;
//import android.test.ActivityInstrumentationTestCase2;
//import android.util.Log;
//import android.widget.LinearLayout;
//
//import com.inmobi.androidsdk.IMAdInterstitial;
//import com.inmobi.androidsdk.IMAdRequest;
//import com.inmobi.androidsdk.IMAdView;
//import com.inmobi.app.sdk370.InMobiAdActivity370;
//import com.inmobi.commons.Utils;
//import com.inmobi.commons.internal.Log.INTERNAL_LOG_LEVEL;
//import com.jayway.android.robotium.solo.Solo;
//
//
//public class InterstitialTests370 extends ActivityInstrumentationTestCase2<InMobiAdActivity370> {
//
//	private static final String APPID = "psoapp123";
//	private InMobiAdActivity370 testActivity; 	// The test activity.
//	public IMAdInterstitial imAdInterstitialView;				// object to hold the test-activity
//	public Solo solo;						// object for robotium
//
//	// Fields
//	public String slotSize = "";
//	private String adtype = "banner";
//	public String LOG_TAG = "PSOTEST";		// logger tag
//	private String HOSTIP = "10.14.119.184";
//	private String PORT = "8080";
//
//	private HashMap<String, String> urlParams = new HashMap<String, String>();
//
//	Utils utils = new Utils();
//	
//	// ################################################################################
//	public InterstitialTests370() {
//		super(InMobiAdActivity370.class);
//	}
//
//	// ################################################################################
//	@Before
//	protected void setUp() throws Exception {
//		super.setUp();
//		com.inmobi.commons.internal.Log.setInternalLogLevel(INTERNAL_LOG_LEVEL.INTERNAL);
//
//		testActivity = getActivity();
//		imAdInterstitialView = testActivity.imAdInterstitialView;		// banner view obj init
//		solo = new Solo(getInstrumentation(), testActivity);	// robotium api initilization
//		
//		urlParams.put("hostip", HOSTIP);
//		urlParams.put("port", PORT);
//
//	}	// end setup()
//
//	
//	// ################################################################################
//	// Test cases for banner ads
//	@Test
//	public void testInterstitalAds_Async_Slot320x480_Creative320x250() {
//		String slotSize = "320x480";
//		String creative = "320x250";				// These variables are to be parameterized
//		String releaseType = "imai_async";		// These variables are to be parameterized
//		String testCaseId = getName();
//		
//		//this.inflateLayout(slotSize);			// inflating layout based on slot-size
//
//		urlParams.put("testcaseid", testCaseId);
//		urlParams.put("release", releaseType);
//		urlParams.put("adtype", adtype);
//		urlParams.put("slotid", slotSize);
//		urlParams.put("creative", creative);
//
//		String adServerURL = utils.buildAdServerURI(urlParams);
//		Log.d(LOG_TAG, "URL: " + adServerURL);
//
//		// setting ad-server custom url, by calling private method (Use of reflectin here)
//		utils.setAdServerURI(imAdInterstitialView, adServerURL);
//
//		IMAdRequest mAdRequest = new IMAdRequest();
//		imAdInterstitialView.setAppId(APPID); // get app obj
//		imAdInterstitialView.setIMAdRequest(mAdRequest);
//		
//		imAdInterstitialView.loadNewAd();
//		utils.waitThread(5000);
//
//		String snapshotFile = getName() + testCaseId.toString();
//		solo.takeScreenshot(snapshotFile);
//
//		// gen click event
//		solo.clickOnScreen(100, 100);
//		utils.waitThread(3000);
//
//	} // end testBannerAds
//
//	// ################################################################################
//	// Test cases for banner ads
//	@Test
//	public void testInterstitalAds_Async_Slot320x480_Creative320x480() {
//		String slotSize = "320x480";
//		String creative = "320x480";				// These variables are to be parameterized
//		String releaseType = "imai_async";		// These variables are to be parameterized
//		String testCaseId = getName();
//		
//		//this.inflateLayout(slotSize);			// inflating layout based on slot-size
//
//		urlParams.put("testcaseid", testCaseId);
//		urlParams.put("release", releaseType);
//		urlParams.put("adtype", adtype);
//		urlParams.put("slotid", slotSize);
//		urlParams.put("creative", creative);
//
//		String adServerURL = utils.buildAdServerURI(urlParams);
//		Log.d(LOG_TAG, "URL: " + adServerURL);
//
//		// setting ad-server custom url, by calling private method (Use of reflectin here)
//		utils.setAdServerURI(imAdInterstitialView, adServerURL);
//
//		IMAdRequest mAdRequest = new IMAdRequest();
//		imAdInterstitialView.setAppId(APPID); // get app obj
//		imAdInterstitialView.setIMAdRequest(mAdRequest);
//		
//		imAdInterstitialView.loadNewAd();
//		utils.waitThread(5000);
//
//		String snapshotFile = getName() + testCaseId.toString();
//		solo.takeScreenshot(snapshotFile);
//
//		// gen click event
//		solo.clickOnScreen(100, 100);
//		utils.waitThread(3000);
//
//	} // end testBannerAds
//
//	
//	// ################################################################################
//	// Test cases for banner ads
//	@Test
//	public void testInterstitalAds_Async_Slot320x480_Creative600x500() {
//		String slotSize = "320x480";
//		String creative = "600x500";				// These variables are to be parameterized
//		String releaseType = "imai_async";		// These variables are to be parameterized
//		String testCaseId = getName();
//		
//		//this.inflateLayout(slotSize);			// inflating layout based on slot-size
//
//		urlParams.put("testcaseid", testCaseId);
//		urlParams.put("release", releaseType);
//		urlParams.put("adtype", adtype);
//		urlParams.put("slotid", slotSize);
//		urlParams.put("creative", creative);
//
//		String adServerURL = utils.buildAdServerURI(urlParams);
//		Log.d(LOG_TAG, "URL: " + adServerURL);
//
//		// setting ad-server custom url, by calling private method (Use of reflectin here)
//		utils.setAdServerURI(imAdInterstitialView, adServerURL);
//
//		IMAdRequest mAdRequest = new IMAdRequest();
//		imAdInterstitialView.setAppId(APPID); // get app obj
//		imAdInterstitialView.setIMAdRequest(mAdRequest);
//		
//		imAdInterstitialView.loadNewAd();
//		utils.waitThread(5000);
//
//		String snapshotFile = getName() + testCaseId.toString();
//		solo.takeScreenshot(snapshotFile);
//
//		// gen click event
//		solo.clickOnScreen(100, 100);
//		utils.waitThread(3000);
//
//	} // end testBannerAds
//	
//	
//	// ################################################################################
//	// Test cases for banner ads
//	@Test
//	public void testInterstitalAds_Async_Slot320x480_Creative640x960() {
//		String slotSize = "320x480";
//		String creative = "640x960";				// These variables are to be parameterized
//		String releaseType = "imai_async";		// These variables are to be parameterized
//		String testCaseId = getName();
//		
//		//this.inflateLayout(slotSize);			// inflating layout based on slot-size
//
//		urlParams.put("testcaseid", testCaseId);
//		urlParams.put("release", releaseType);
//		urlParams.put("adtype", adtype);
//		urlParams.put("slotid", slotSize);
//		urlParams.put("creative", creative);
//
//		String adServerURL = utils.buildAdServerURI(urlParams);
//		Log.d(LOG_TAG, "URL: " + adServerURL);
//
//		// setting ad-server custom url, by calling private method (Use of reflectin here)
//		utils.setAdServerURI(imAdInterstitialView, adServerURL);
//
//		IMAdRequest mAdRequest = new IMAdRequest();
//		imAdInterstitialView.setAppId(APPID); // get app obj
//		imAdInterstitialView.setIMAdRequest(mAdRequest);
//		
//		imAdInterstitialView.loadNewAd();
//		utils.waitThread(5000);
//
//		String snapshotFile = getName() + testCaseId.toString();
//		solo.takeScreenshot(snapshotFile);
//
//		// gen click event
//		solo.clickOnScreen(100, 100);
//		utils.waitThread(3000);
//
//	} // end testBannerAds
//
//	
//	// ################################################################################
//	// custom written method for setting QA url for bannerAd
//	public boolean accessAdViewAPI(IMAdView adView, String serverUrl) {
//		boolean flag = false;
//		Method method;
//		try {
//			method = (Method) adView.getClass().getDeclaredMethod(
//					"setAdServerUrl", String.class);
//			method.setAccessible(true);
//			method.invoke(adView, serverUrl);
//			flag = true;
//		} catch (NoSuchMethodException e) {
//			e.printStackTrace();
//		} catch (IllegalArgumentException e) {
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		} catch (InvocationTargetException e) {
//			e.printStackTrace();
//		}
//
//		return flag;
//
//	}	// end accessAdViewAPI()
//
//
//	// ###################################################################################
//	@After
//	protected void tearDown() throws Exception {
//		// super.tearDown();
//
//		try {
//			solo.finalize();
//		} catch (Throwable e) {
//			e.printStackTrace();
//			getActivity().finish();
//			super.tearDown();
//		}
//
//	}
//}
