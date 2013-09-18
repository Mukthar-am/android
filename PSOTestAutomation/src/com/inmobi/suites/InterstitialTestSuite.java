package com.inmobi.suites;

import junit.framework.Test;
import junit.framework.TestSuite;
import android.util.Log;
import com.inmobi.psoapp370.test.InterstitialTests370;

public class InterstitialTestSuite extends TestSuite {

	public static Test suite () {

		// variables:
		String LOG_TAG = "PSOTEST";
		String testPrefix = "testInterstitialAds";
		
		TestSuite suite = new TestSuite();
		
//		// #############################################################################
//		// iterating over slot-creative sizes:	PORTRAIT MODE
//		String[] boltTypeListPortrait = { "Async", "Sync" };
//		String[] slotListPortrait = { "320x480" };
//		String[] creativeListPortrait = { "300x250" };//, "320x480"	, "600x500", "640x960" };
//
//		for (String boltType : boltTypeListPortrait) {
//			for (String slotSize : slotListPortrait) {
//				for (String creativeSize : creativeListPortrait) {
//					String testCaseName = testPrefix + "_" + boltType + "_" + "Slot" + slotSize.toLowerCase() + "_" + "Creative" + creativeSize.toLowerCase();
//					Log.d(LOG_TAG, "\nSlot size = " + slotSize + "; Creative size = " + creativeSize + "Bolt type = " + boltType + " => " + testCaseName);
//
//					suite.addTest(TestSuite.createTest(InterstitialTests370.class, testCaseName));	// adding individual tests using loop
//				}
//			}
//		}
//		
		// #############################################################################
		// iterating over slot-creative sizes:	LANDSCAPE MODE
		String[] boltTypeListLandscape = { "Async", "Sync" };
		String[] slotListLandscape = { "480x320" };
		String[] creativeListLandscape = { "300x250" };//, "600x500", "480x320", "960x640" };

		for (String boltType : boltTypeListLandscape) {
			for (String slotSize : slotListLandscape) {
				for (String creativeSize : creativeListLandscape) {
					String testCaseName = testPrefix + "_" + boltType + "_" + "Slot" + slotSize.toLowerCase() + "_" + "Creative" + creativeSize.toLowerCase();
					Log.d(LOG_TAG, "\nSlot size = " + slotSize + "; Creative size = " + creativeSize + "Bolt type = " + boltType + " => " + testCaseName);

					suite.addTest(TestSuite.createTest(InterstitialTests370.class, testCaseName));	// adding individual tests using loop
				}
			}
		}

		return suite;
	}

}	// end InterstitialTestSuite()
