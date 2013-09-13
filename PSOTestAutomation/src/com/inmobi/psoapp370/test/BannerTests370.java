package com.inmobi.psoapp370.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import android.graphics.Color;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.widget.LinearLayout;

import com.inmobi.androidsdk.IMAdRequest;
import com.inmobi.androidsdk.IMAdView;
import com.inmobi.app.sdk370.InMobiAdActivity370;
import com.inmobi.commons.Utils;
import com.inmobi.commons.internal.Log.INTERNAL_LOG_LEVEL;
import com.jayway.android.robotium.solo.Solo;


public class BannerTests370 extends ActivityInstrumentationTestCase2<InMobiAdActivity370> {

	private static final String APPID = "psoapp123";
	private InMobiAdActivity370 testActivity; 	// The test activity.
	public IMAdView imAdBannerViewObj;				// object to hold the test-activity
	public Solo solo;						// object for robotium

	// Fields
	public String slotSize = "";
	private String adtype = "banner";
	public String LOG_TAG = "PSOTEST";		// logger tag
	private String HOSTIP = "10.14.119.82";
	private String PORT = "8080";

	private HashMap<String, String> urlParams = new HashMap<String, String>();

	Utils utils = new Utils();

	// ################################################################################
	// constructor class: This tells the framework to run tests against what app/app-class.
	public BannerTests370() {
		super(InMobiAdActivity370.class);
		//this.slotSize = slot;
	}

	// ################################################################################
	@Before
	protected void setUp() throws Exception {
		super.setUp();
		com.inmobi.commons.internal.Log.setInternalLogLevel(INTERNAL_LOG_LEVEL.INTERNAL);

		testActivity = getActivity();
		imAdBannerViewObj = testActivity.imAdBannerView;		// banner view obj init
		solo = new Solo(getInstrumentation(), testActivity);	// robotium api initilization

		urlParams.put("hostip", HOSTIP);
		urlParams.put("port", PORT);

	}	// end setup()

	// ################################################################################
	// Test cases for banner ads
	
	@Test
	public void testBannerAds_Async_Slot320x50_Creative320x50() {
		String slotSize = "320x50";
		String creative = "320x50";				// These variables are to be parameterized
		String releaseType = "imai_async";		// These variables are to be parameterized
		String testCaseId = getName();

		this.inflateLayout(slotSize);			// inflating layout based on slot-size

		urlParams.put("testcaseid", testCaseId);
		urlParams.put("release", releaseType);
		urlParams.put("adtype", adtype);
		urlParams.put("slotid", slotSize);
		urlParams.put("creative", creative);

		String adServerURL = utils.buildAdServerURI(urlParams);
		Log.d(LOG_TAG, "URL: " + adServerURL);

		// setting ad-server custom url, by calling private method (Use of reflectin here)
		utils.setAdServerURI(imAdBannerViewObj, adServerURL);

		IMAdRequest mAdRequest = new IMAdRequest();
		//imAdBannerViewObj.setAdSize(IMAdView.INMOBI_AD_UNIT_320X50);
		imAdBannerViewObj.setAppId(APPID); // get app obj
		imAdBannerViewObj.setIMAdRequest(mAdRequest);
		imAdBannerViewObj.setRefreshInterval(IMAdView.REFRESH_INTERVAL_OFF);

		imAdBannerViewObj.loadNewAd();
		utils.waitThread(3000);

		String snapshotFile = getName() + testCaseId.toString();
		solo.takeScreenshot(snapshotFile);
		utils.waitThread(2000);

		// gen click event
		solo.clickOnView(imAdBannerViewObj);
		utils.waitThread(2000);
		//imAdBannerViewObj.destroy();

	} // end testBannerAds


	// ################################################################################
	// Test cases for banner ads
	@Test
	public void testBannerAds_Async_Slot300x250_Creative320x50() {
		String slotSize = "300x250";
		String creative = "320x50";		// These variables are to be parameterized
		String releaseType = "imai_async";		// These variables are to be parameterized
		
		String testCaseId = getName();

		this.inflateLayout(slotSize);	// inflating layout based on slot-size

		urlParams.put("testcaseid", testCaseId);
		urlParams.put("release", releaseType);
		urlParams.put("adtype", adtype);
		urlParams.put("slotid", slotSize);
		urlParams.put("creative", creative);

		String adServerURL = utils.buildAdServerURI(urlParams);
		Log.d(LOG_TAG, "URL: " + adServerURL);

		// setting ad-server custom url, by calling private method (Use of reflectin here)
		utils.setAdServerURI(imAdBannerViewObj, adServerURL);

		IMAdRequest mAdRequest = new IMAdRequest();
		//imAdBannerViewObj.setAdSize(IMAdView.INMOBI_AD_UNIT_320X50);
		imAdBannerViewObj.setAppId(APPID); // get app obj
		imAdBannerViewObj.setIMAdRequest(mAdRequest);
		imAdBannerViewObj.setRefreshInterval(IMAdView.REFRESH_INTERVAL_OFF);

		imAdBannerViewObj.loadNewAd();
		utils.waitThread(3000);

		String snapshotFile = getName() + testCaseId.toString();
		solo.takeScreenshot(snapshotFile);
		utils.waitThread(2000);

		// gen click event
		solo.clickOnView(imAdBannerViewObj);
		utils.waitThread(2000);
		//imAdBannerViewObj.destroy();

	} // end testBannerAds

	// ################################################################################
	// Test cases for banner ads
	@Test
	public void testBannerAds_Async_Slot320x48_Creative320x50() {
		String slotSize = "320x48";
		String creative = "320x50";				// These variables are to be parameterized
		String releaseType = "imai_async";		// These variables are to be parameterized
		String testCaseId = getName();
		
		this.inflateLayout(slotSize);			// inflating layout based on slot-size

		urlParams.put("testcaseid", testCaseId);
		urlParams.put("release", releaseType);
		urlParams.put("adtype", adtype);
		urlParams.put("slotid", slotSize);
		urlParams.put("creative", creative);

		String adServerURL = utils.buildAdServerURI(urlParams);
		Log.d(LOG_TAG, "URL: " + adServerURL);

		// setting ad-server custom url, by calling private method (Use of reflectin here)
		utils.setAdServerURI(imAdBannerViewObj, adServerURL);

		IMAdRequest mAdRequest = new IMAdRequest();
		//imAdBannerViewObj.setAdSize(IMAdView.INMOBI_AD_UNIT_300X250);
		imAdBannerViewObj.setAppId(APPID); // get app obj
		imAdBannerViewObj.setIMAdRequest(mAdRequest);
		imAdBannerViewObj.setRefreshInterval(IMAdView.REFRESH_INTERVAL_OFF);

		imAdBannerViewObj.loadNewAd();
		utils.waitThread(5000);

		String snapshotFile = getName() + testCaseId.toString();
		solo.takeScreenshot(snapshotFile);

		// gen click event
		solo.clickOnView(imAdBannerViewObj);
		utils.waitThread(3000);
		//imAdBannerViewObj.destroy();

	} // end testBannerAds

	// ################################################################################
	// custom written method for setting QA url for bannerAd
	public boolean accessAdViewAPI(IMAdView adView, String serverUrl) {
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

	}	// end accessAdViewAPI()



	// ##############################################################################################################################
	public void inflateLayout (final String slotSize) {
		testActivity.runOnUiThread(new Runnable() {
			public void run() {
				LinearLayout layout = new LinearLayout(testActivity);
				layout.setOrientation(LinearLayout.VERTICAL);
				layout.setBackgroundColor(Color.GRAY);
				testActivity.setContentView(layout);
				Log.d(LOG_TAG, "slot size: " + slotSize);
				//setContentView(R.layout.activity_main);	// this was by default when app was created. - Mukthar.

				if ( slotSize.equalsIgnoreCase("320x50") ) {
					imAdBannerViewObj = new IMAdView(testActivity, IMAdView.INMOBI_AD_UNIT_320X50, "testappid123");
					
				} else if ( slotSize.equalsIgnoreCase("300x250") ) {
					imAdBannerViewObj = new IMAdView(testActivity, IMAdView.INMOBI_AD_UNIT_300X250, "testappid123");
					
				} else if ( slotSize.equalsIgnoreCase("320x48") ) {
					imAdBannerViewObj = new IMAdView(testActivity, IMAdView.INMOBI_AD_UNIT_320X48, "testappid123");
					
				}

				imAdBannerViewObj.setBackgroundColor(Color.GREEN);
				layout.addView(imAdBannerViewObj);
			}
		});
		utils.waitThread(3000);
	}


}
