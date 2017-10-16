package com.bat.iron.theironbat;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {

    Button b;
    EditText et,et1;

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db=openOrCreateDatabase("hpes",MODE_PRIVATE,null);

        b=(Button)findViewById(R.id.button24);
        et=(EditText)findViewById(R.id.editText6);
        et1=(EditText)findViewById(R.id.editText7);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String n=et.getText().toString();
                String p=et1.getText().toString();

                String s="select name,pass from login where name='"+n+"' and pass='"+p+"'";
                Cursor c=db.rawQuery(s,null);

                if(c.moveToNext())
                {

                    Toast.makeText(getApplicationContext(),"Login Success",Toast.LENGTH_LONG).show();
                }
                else
                {

                    Toast.makeText(getApplicationContext(),"Login Failed, please enter correct name and password",Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}
