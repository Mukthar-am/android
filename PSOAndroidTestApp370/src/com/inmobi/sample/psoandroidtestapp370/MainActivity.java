package com.inmobi.sample.psoandroidtestapp370;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.widget.LinearLayout;

import com.inmobi.androidsdk.IMAdRequest;
import com.inmobi.androidsdk.IMAdView;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.internal.Log.INTERNAL_LOG_LEVEL;


public class MainActivity extends Activity {

	// Globals:
	private static String ADSERVER_URL = "http://10.14.127.38:8080/psowebapp/rspserver?rqparam=/test=iOS_6.0.1_SDK-3.7.0_android_320x50_320x50/platform=Android_6.0.1_SDK-3.7.0_XPeria/release=imai_async/adtype=banner/slotid=320x50/creative=320x50";
	private IMAdView imAdView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Log.setInternalLogLevel(INTERNAL_LOG_LEVEL.INTERNAL);	// for logging purpose
		
		LinearLayout layout = new LinearLayout(this);
		layout.setOrientation(LinearLayout.VERTICAL);
		layout.setBackgroundColor(Color.GRAY);
		setContentView(layout);
		//setContentView(R.layout.activity_main);	// this was by default when app was created. - Mukthar.

		imAdView = new IMAdView(this, IMAdView.INMOBI_AD_UNIT_300X250, "Id-12345");
		setAdServerURI(imAdView, ADSERVER_URL); 	// setting ad-server custom url, by calling private method (Use of reflectin here) 
		imAdView.setBackgroundColor(Color.GREEN);
		
		IMAdRequest mAdRequest = new IMAdRequest();
		imAdView.setIMAdRequest(mAdRequest);
		layout.addView(imAdView);
		imAdView.loadNewAd();

		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	

	private boolean setAdServerURI(IMAdView adView, String serverUrl) {
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

}

