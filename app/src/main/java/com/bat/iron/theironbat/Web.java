package com.bat.iron.theironbat;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class Web extends Activity {

    WebView ob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        ob=(WebView)findViewById(R.id.w);
        ob.getSettings().setJavaScriptEnabled(true); //to enable java script web settings on mobile
        ob.loadUrl("http:\\www.google.co.in");
        //app would work only when permission is given by user to access internet. permission is found in AndroidManifest.xml
    }
}
