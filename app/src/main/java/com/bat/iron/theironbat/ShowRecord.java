package com.bat.iron.theironbat;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class ShowRecord extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_record);

        Bundle ob=getIntent().getExtras(); //Intent data is accepted through bundle

        String name=ob.getString("U");
        String pass=ob.getString("B");

        Toast.makeText(getApplicationContext(), "Name : "+name+"\nPass : "+pass, Toast.LENGTH_SHORT).show();
    }
}
