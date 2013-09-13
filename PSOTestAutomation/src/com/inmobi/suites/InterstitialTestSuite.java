package com.inmobi.suites;

import com.inmobi.psoapp370.test.BannerTests370;

import junit.framework.Test;
import junit.framework.TestSuite;
import android.util.Log;

public class InterstitialTestSuite extends TestSuite {

	public static Test suite () {

		// variables:
		String LOG_TAG = "PSOTEST";
		
		TestSuite suite = new TestSuite();
		
		String testPrefix = "testInterstitialAds";
		String[] slotList = { "320x480"};
		String[] creativeList = { "320x250", "320x480", "600x500", "640x960" };
		
		// iterating over slot-creative sizes:
		for (String slotSize : slotList) {
			Log.d(LOG_TAG, "\nSlot - " + slotSize);
			
			for (String creativeSize : creativeList) {
				Log.d(LOG_TAG, "Creative - " + creativeSize);
				String testCaseName = testPrefix + "_" + "Async" + "_" + "Slot" + slotSize.toLowerCase() + "_" + "Creative" + creativeSize.toLowerCase();
				Log.d(LOG_TAG, "Slot size = " + slotSize + "; Creative size = " + creativeSize + " => " + testCaseName);
				suite.addTest(TestSuite.createTest(BannerTests370.class, testCaseName));
			}
		}
		
		return suite;
	}


}
