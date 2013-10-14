package com.inmobi.app.sdk360;

import android.app.Activity;

import com.inmobi.androidsdk.IMAdInterstitial;
import com.inmobi.androidsdk.IMAdView;

public class InMobiAdActivity354 extends Activity {
	
	// Globals:
	private static String ADSERVER_URL = "http://10.14.125.136:8080/psowebapp/rspserver?rqparam=/test=iOS_6.0.1_SDK-3.7.0_android_320x50_320x50/platform=Android_6.0.1_SDK-3.7.0_XPeria/release=imai_async/adtype=banner/slotid=320x50/creative=320x50";
	public IMAdView imAdBannerView;		// this class object is refered by imAdView outside this class.
	public IMAdInterstitial imAdInterstitial;
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
//		if (imAdBannerView != null)
//			imAdBannerView.destroyDrawingCache();
//
//		if (imAdInterstitial != null)
//			imAdInterstitial.destroy();
	}

}
