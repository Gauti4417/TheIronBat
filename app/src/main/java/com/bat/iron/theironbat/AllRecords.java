package com.bat.iron.theironbat;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AllRecords extends Activity {

    Button b,b1,b2,b3;
    TextView tv,tv1;

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_records);

        db=openOrCreateDatabase("hpes",MODE_PRIVATE,null);

        tv=(TextView)findViewById(R.id.textView);
        tv1=(TextView)findViewById(R.id.textView2);
        b=(Button)findViewById(R.id.button18);
        b1=(Button)findViewById(R.id.button19);
        b2=(Button)findViewById(R.id.button20);
        b3=(Button)findViewById(R.id.button21);

        String s="select *from login";
        final Cursor c=db.rawQuery(s,null); //rawQuery returns Cursor

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!c.isFirst())
                {
                    if(c.moveToPrevious())
                    {
                        String n=c.getString(0);
                        String p=c.getString(1);
                        tv.setText(n);
                        tv1.setText(p);
                    }
                }
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

                 if(!c.isLast())
                     {
                     if(c.moveToNext())
                     {
                        String n=c.getString(0);
                         String p=c.getString(1);
                        tv.setText(n);
                        tv1.setText(p);
                     }
                }
             }
         });

        b2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

                c.moveToFirst();
                String n=c.getString(0);
                String p=c.getString(1);
                tv.setText(n);
                tv1.setText(p);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                c.moveToLast();
                String n=c.getString(0);
                String p=c.getString(1);
                tv.setText(n);
                tv1.setText(p);
            }
        });


    }
}
