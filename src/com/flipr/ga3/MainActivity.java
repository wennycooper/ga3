package com.flipr.ga3;



import java.util.Map;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

//import com.google.analytics.tracking.android.GAServiceManager;
//import com.google.analytics.tracking.android.GoogleAnalytics;

//import com.example.ga3.R;
//import com.example.ga2.R;

import com.google.analytics.tracking.android.Fields;
import com.google.analytics.tracking.android.GAServiceManager;
import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.Logger.LogLevel;
import com.google.analytics.tracking.android.Tracker;


//import com.google.analytics.tracking.android.Tracker;
//import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.MapBuilder;


public class MainActivity extends Activity {

	private static final String TAG = "ga3";
	
	private Button mButton1;
	private Button mButton2;
	private Button mButton3;
	private Button mButton4;
	private Button mButton5;
	private Button mButton6;
	
	private static GoogleAnalytics mGa;
	private static Tracker mTracker;

	private static final String GA_PROPERTY_ID = "UA-47454448-2";
	private static final int GA_DISPATCH_PERIOD = 180;
	// private static final boolean GA_IS_DRY_RUN = false;

	private static final LogLevel GA_LOG_VERBOSITY = LogLevel.VERBOSE;

	private static final String SCREEN1_LABEL = "/ga3/screen1";
	private static final String SCREEN2_LABEL = "/ga3/screen2";
	private static final String SCREEN3_LABEL = "/ga3/screen3";
	
	private static final String CAMPAIGN_SOURCE_PARAM = "utm_source";


	
//	private EasyTracker easyTracker;
	
	
	private void initializeGa() {
		mGa = GoogleAnalytics.getInstance(this);
		mTracker = mGa.getTracker(GA_PROPERTY_ID);
		GAServiceManager.getInstance().setLocalDispatchPeriod(GA_DISPATCH_PERIOD);	
		mGa.getLogger().setLogLevel(GA_LOG_VERBOSITY);

	}
	
	public static Tracker getGaTracker() {
	    return mTracker;
	}

	public static GoogleAnalytics getGaInstance() {
	    return mGa;
	}

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initializeGa();
	
		
		setContentView(R.layout.activity_main);
	}

	
	
		
	@Override
	protected void onStart() {
		super.onStart();
		
		mButton1 = (Button) findViewById(R.id.button1);
		//mButton1.setEnabled(false);
		mButton1.setOnClickListener(new Button.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				// do something ....
				
				
				mTracker.send(MapBuilder
					    .createAppView()
					    .set(Fields.SCREEN_NAME, SCREEN1_LABEL)
					    .build()
					    );
				
				Context context = getApplicationContext();
				CharSequence text = SCREEN1_LABEL;
				int duration = Toast.LENGTH_SHORT;

				Toast toast = Toast.makeText(context, text, duration);
				toast.show();
				
				
				
				
			}		
		});

		mButton2 = (Button) findViewById(R.id.button2);
		//mButton2.setEnabled(false);
		mButton2.setOnClickListener(new Button.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				
				mTracker.send(MapBuilder
					    .createAppView()
					    .set(Fields.SCREEN_NAME, SCREEN2_LABEL)
					    .build()
					    );
				
				Context context = getApplicationContext();
				CharSequence text = SCREEN2_LABEL;
				int duration = Toast.LENGTH_SHORT;

				Toast toast = Toast.makeText(context, text, duration);
				toast.show();
				
				
				
			}		
		});
		
		mButton3 = (Button) findViewById(R.id.button3);
		//mButton3.setEnabled(false);
		mButton3.setOnClickListener(new Button.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				// do something ....
				
				//mTracker.set(Fields.SCREEN_NAME, SCREEN3_LABEL);
				mTracker.send(MapBuilder
					    .createAppView()
					    .set(Fields.SCREEN_NAME, SCREEN3_LABEL)
					    .build()
					    );
				
				Context context = getApplicationContext();
				CharSequence text = SCREEN3_LABEL;
				int duration = Toast.LENGTH_SHORT;

				Toast toast = Toast.makeText(context, text, duration);
				toast.show();
				
				
				
			}		
		});
		
		mButton4 = (Button) findViewById(R.id.button4);
		mButton4.setOnClickListener(new Button.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				// do something ....
				
				mTracker.send(MapBuilder
					    .createEvent("ga3_category1", "ga3_action1", "ga3_label1", (long) 0)
					    .build()
						);


				Context context = getApplicationContext();
				CharSequence text = "logEvent(ga3_category1)";
				int duration = Toast.LENGTH_SHORT;

				Toast toast = Toast.makeText(context, text, duration);
				toast.show();
				
				
				
			}		
		});
		
		
		mButton5 = (Button) findViewById(R.id.button5);
		mButton5.setOnClickListener(new Button.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				// do something ....
				
				mTracker.send(MapBuilder
					    .createEvent("ga3_category2", "ga3_action2", "ga3_label2", (long) 0)
					    .build()
						);
				
				Context context = getApplicationContext();
				CharSequence text = "logEvent(ga3_category2)";
				int duration = Toast.LENGTH_SHORT;

				Toast toast = Toast.makeText(context, text, duration);
				toast.show();
				
				//FlurryAgent.logEvent("step2");
				
			}		
		});
		
		mButton6 = (Button) findViewById(R.id.button6);
		mButton6.setOnClickListener(new Button.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				// do something ....
				
				mTracker.send(MapBuilder
					    .createEvent("ga3_category3", "ga3_action3", "ga3_label3", null)
					    .build()
						);
				
				
				Context context = getApplicationContext();
				CharSequence text = "logEvent(ga3_category3)";
				int duration = Toast.LENGTH_SHORT;

				Toast toast = Toast.makeText(context, text, duration);
				toast.show();
				
				
				
			}		
		});
		
		
	}
	
	
	@Override
	protected void onStop() {
		super.onStop();
		Log.i("KK", "onStop()............");
	}

}



