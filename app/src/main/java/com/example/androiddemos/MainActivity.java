package com.example.androiddemos;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;

public class MainActivity extends AppCompatActivity  {
  private String TAG="lifecycle";
  private TextView mLifecycleDisplay;
  private  final String LIFECYCLE_CALLBACKS_TEXT_KEY = "callbacks";
  private  final String ON_CREATE="onCreate";
  private  final String ON_START="onStart";
  private  final String ON_RESUME="onResume";
  private  final String ON_PAUSE="onPause";
  private   final String ON_STOP="onStop";
  private final String ON_RESTART="onRestart";
  private  final String ON_DESTROY="onDestroy";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mLifecycleDisplay = findViewById(R.id.lifecycle_callbacks);
//        mLifecycleDisplay.append("Galiwango fahad");
//        mLifecycleDisplay.append("\n");
//        mLifecycleDisplay.append("From kampala");
           mLifecycleDisplay.append(ON_CREATE);
           mLifecycleDisplay.append("\n");
           logAndAppend(ON_CREATE);
        //checking if some data is stored
        if(savedInstanceState != null){
            if(savedInstanceState.containsKey(LIFECYCLE_CALLBACKS_TEXT_KEY)){
                String allPreviousCallbackLifeCycle = savedInstanceState.getString(LIFECYCLE_CALLBACKS_TEXT_KEY);
                mLifecycleDisplay.setText(allPreviousCallbackLifeCycle);
            }
        }else{
            Toast.makeText(this ,"its null" , Toast.LENGTH_LONG).show();
        }

    }

    private void logAndAppend(String message){
        Log.d(TAG, "logAndAppend: "+mLifecycleDisplay.getText().toString());
    }

    @Override
    protected void onStart() {
        super.onStart();
      mLifecycleDisplay.append(ON_START);
        mLifecycleDisplay.append("\n");
      logAndAppend(ON_START);
    }


    @Override
    protected void onResume() {
        super.onResume();
        mLifecycleDisplay.append(ON_RESUME);
        mLifecycleDisplay.append("\n");
        logAndAppend(ON_RESUME);
    }


    @Override
    protected void onPause() {
        super.onPause();
        mLifecycleDisplay.append(ON_PAUSE);
        mLifecycleDisplay.append("\n");
        logAndAppend(ON_PAUSE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mLifecycleDisplay.append(ON_STOP);
        mLifecycleDisplay.append("\n");
        logAndAppend(ON_STOP);
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        mLifecycleDisplay.append(ON_RESTART);
        mLifecycleDisplay.append("\n");
        logAndAppend(ON_RESTART);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLifecycleDisplay.append(ON_DESTROY);
        mLifecycleDisplay.append("\n");
        logAndAppend(ON_DESTROY);
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        String lifeCycleDisplayTextViewContents = mLifecycleDisplay.getText().toString();
       outState.putString(LIFECYCLE_CALLBACKS_TEXT_KEY , lifeCycleDisplayTextViewContents);

    }
}
