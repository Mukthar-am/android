/*package com.inmobi.suites;

import junit.framework.Test;
import junit.framework.TestSuite;
import android.util.Log;
import com.inmobi.psoapp370.test.BannerTests370;

public class BannerTestSuite extends TestSuite {
	
	public static Test suite () {
		TestSuite suite = new TestSuite();
		
		// variables:
		String LOG_TAG = "PSOTEST";
		
		// All tests to be executed:
		BannerTests370 bannerTests = new BannerTests370();
		
		String testPrefix = "testBannerAds";
		String[] slotList = { "320x50" };//, "320x48", "300x250"};
		String[] creativeList = { "320x50" };
		
			// use this for full test runs, when implemented... (Mukthar)
		 * String[] slotList = {"320x50", "320x48", "300x250", "300x50", "728x90", "468x60" };		// full listing of all valid slot sizes.
		 * String[] creativeList = { "216x36", "300x250", "300x50", "320x48", "320x50", "468x60", "640x100", "640x96", "728x90" };
		 
		
		// iterating over slot-creative sizes:
		for (String slotSize : slotList) {
			Log.d(LOG_TAG, "\nSlot - " + slotSize);
			for (String creativeSize : creativeList) {
				Log.d(LOG_TAG, "Creative - " + creativeSize);
				String testCaseName = testPrefix + "_" + "Async" + "_" + "Slot" + slotSize.toLowerCase() + "_" + "Creative" + creativeSize.toLowerCase();
				Log.d(LOG_TAG, "Slot size = " + slotSize + "; Creative size = " + creativeSize + " => " + testCaseName);
				
				suite.addTest(TestSuite.createTest(BannerTests370.class, testCaseName));	// adding tests to the suite
			}
		}

			# Another way of running individual tests 
		 * suite.addTest(TestSuite.createTest(BannerTests.class, "testBannerAdsAsync320X50"));
		 * suite.addTest(TestSuite.createTest(BannerTests.class, "testBannerAdsAsync300X250"));	
		 
		
		return suite;


		    TestSuite suite = new TestSuite("BannerTests");
        BannerTests arithmeticsTests = new BannerTests();
        arithmeticsTests.setName("testBannerAdsAsync320X50");
        arithmeticsTests.setName("testBannerAdsAsync300X250");
        suite.addTest(arithmeticsTests);
        return suite;
		 

				Class[] testClasses = { BannerTests.class }
		TestSuite suite= new TestSuite(testClasses);
		suite.addTest(new BannerTests("testAdd"));
		suite.addTest(new BannerTests("testDivideByZero"));

		
	}	// end suite()


}	// end BannerTestSuite - class
*/