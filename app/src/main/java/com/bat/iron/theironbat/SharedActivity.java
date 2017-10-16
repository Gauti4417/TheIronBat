package com.bat.iron.theironbat;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class SharedActivity extends Activity {

    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared);

        et=(EditText)findViewById(R.id.editText10);
        //shared preference is used to store some data permenantly. it cannot be deleted automatically ever
        SharedPreferences ob=getSharedPreferences("mm",0); //here 0 means null, not index
        et.setText(ob.getString("mytext",""));
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences ob=getSharedPreferences("mm",0);
        SharedPreferences.Editor obj=ob.edit();
        obj.putString("mytext",et.getText().toString());
        obj.commit();
    }
}
