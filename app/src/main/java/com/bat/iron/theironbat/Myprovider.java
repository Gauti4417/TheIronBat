package com.bat.iron.theironbat;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Myprovider extends Activity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myprovider);
        tv=(TextView)findViewById(R.id.textView3);

        String s="content://com.hpes.rcpl"; //this is a method to access everything with url without using database objects
        Uri u=Uri.parse(s);
        ContentResolver cr=getContentResolver();
        String data="";
        Cursor c=cr.query(u,null,null,null,null);
        while (c.moveToNext())
        {
            String n=c.getString(0);
            String p=c.getString(1);
            data=data+n+" : "+p+" \n";
        }
        Toast.makeText(getApplicationContext(),""+data,Toast.LENGTH_LONG).show();
        tv.setText(data);

    }
}
