package com.inmobi.suites;

import junit.framework.Test;
import junit.framework.TestSuite;
import android.util.Log;

import com.inmobi.commons.Utils;
import com.inmobi.psoapp362.test.InterstitialTests362;

public class InterstitialTestSuite extends TestSuite {

	public static Test suite () {

		// variables:
		String LOG_TAG = "PSOTESTSUITE";
		String testPrefix = "testInterstitialAds";
		//String testPrefixTablets = "testInterstitialAds_Tablet_";

		TestSuite suite = new TestSuite();
		String[] devicesToExec = {"smartphone" }; //, "tablet"};
		boolean flexiMode = false;
		boolean portraitMode = true;
		boolean landscapeMode = true;

		// Variables - Portrait 
		String[] boltTypeListPortrait = { "Async", "Sync" };
		String[] slotListPortrait = { "320x480" };
		String[] creativeListPortrait = { "300x250", "320x480"	, "600x500", "640x960" };

		// Variables - Landscape 
		String[] boltTypeListLandscape = { "Async", "Sync" };
		String[] slotListLandscape = { "480x320" };
		String[] creativeListLandscape = { "300x250", "600x500", "480x320", "960x640" };

		String[] boltTypeListPortraitTablets = { "Async", "Sync" };
		String[] slotListPortraitTablets = { "800x1280" };
		String[] creativeListPortraitTablets = { "800x1280", "1600x2560" };
		
		String[] boltTypeListLandscapeTablets = { "Async", "Sync" };
		String[] slotListLandscapeTablets = { "1280x800" };
		String[] creativeListLandscapeTablets = { "1280x800", "2560x1600" };
		// #############################################################################

		for ( String device : devicesToExec ) {
			if ( device.equalsIgnoreCase("smartphone") ) {

				// iterating over slot-creative sizes:	PORTRAIT MODE
				if ( portraitMode ) {
					for (String boltType : boltTypeListPortrait) {
						for (String slotSize : slotListPortrait) {
							for (String creativeSize : creativeListPortrait) {
								String testCaseName = testPrefix + "_" + boltType + "_" + "Slot" + slotSize.toLowerCase() + "_" + "Creative" + creativeSize.toLowerCase();
								Log.d(LOG_TAG, "\nSlot size = " + slotSize + "; Creative size = " + creativeSize + "Bolt type = " + boltType + " => " + testCaseName);

								suite.addTest(TestSuite.createTest(InterstitialTests362.class, testCaseName));	// adding individual tests using loop
							}
						}
					}
				} 

				// iterating over slot-creative sizes:	LANDSCAPE MODE
				if ( landscapeMode ) {
					for (String boltType : boltTypeListLandscape) {
						for (String slotSize : slotListLandscape) {
							for (String creativeSize : creativeListLandscape) {
								String testCaseName = testPrefix + "_" + boltType + "_" + "Slot" + slotSize.toLowerCase() + "_" + "Creative" + creativeSize.toLowerCase();
								Log.d(LOG_TAG, "\nSlot size = " + slotSize + "; Creative size = " + creativeSize + "Bolt type = " + boltType + " => " + testCaseName);
								
								suite.addTest(TestSuite.createTest(InterstitialTests362.class, testCaseName));	// adding individual tests using loop
							}	// for (creative)
						}	// for (slot)
					}	// for (bolttype - landscape-mode)
					
				}
				
				if ( flexiMode ) {
					Log.d( LOG_TAG, "+++ Interstitial flex test case...");
					suite.addTest(TestSuite.createTest(InterstitialTests362.class, "testInterstitialAds_Async_Slot320x480_Creative320x480_FlexiTest"));	// adding individual tests using loop
				}

								
			} else if ( device.equalsIgnoreCase("tablet") ) {
				// iterating over slot-creative sizes:	PORTRAIT MODE
				if ( portraitMode ) {
					for (String boltType : boltTypeListPortraitTablets) {
						for (String slotSize : slotListPortraitTablets) {
							for (String creativeSize : creativeListPortrait) {
								String testCaseName = testPrefix + "_" + boltType + "_" + "Slot" + slotSize.toLowerCase() + "_" + "Creative" + creativeSize.toLowerCase();
								Log.d(LOG_TAG, "\nSlot size = " + slotSize + "; Creative size = " + creativeSize + "Bolt type = " + boltType + " => " + testCaseName);

								suite.addTest(TestSuite.createTest(InterstitialTests362.class, testCaseName));	// adding individual tests using loop
							}
						}
					}
				}
				
				if ( landscapeMode ) {
					for (String boltType : boltTypeListLandscapeTablets) {
						for (String slotSize : slotListLandscapeTablets) {
							for (String creativeSize : creativeListLandscapeTablets) {
								String testCaseName = testPrefix + "_" + boltType + "_" + "Slot" + slotSize.toLowerCase() + "_" + "Creative" + creativeSize.toLowerCase();
								Log.d(LOG_TAG, "\nSlot size = " + slotSize + "; Creative size = " + creativeSize + "Bolt type = " + boltType + " => " + testCaseName);

								suite.addTest(TestSuite.createTest(InterstitialTests362.class, testCaseName));	// adding individual tests using loop
							}
						}
					}
				}
				
			}	// if-else ( device-types )
			
		}
		
		return suite;
	
	}	// end Suite()

}	// end InterstitialTestSuite()
