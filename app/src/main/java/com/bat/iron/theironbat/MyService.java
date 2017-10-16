package com.bat.iron.theironbat;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MyService extends Activity implements View.OnClickListener {

    Button b1, b2;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_service);

        b1 = (Button) findViewById(R.id.button32);
        b2 = (Button) findViewById(R.id.button33);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);

        i = new Intent(MyService.this, MusicDemo.class);

    }


    @Override
    public void onClick(View v) {

        if (v == b1) {
            startService(i);
            finish();
        } else if (v == b2) {
            stopService(i);
            finish();
        }
    }
}
