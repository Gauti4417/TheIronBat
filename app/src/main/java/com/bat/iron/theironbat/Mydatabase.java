package com.bat.iron.theironbat;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Mydatabase extends Activity {

    Button b1,b2,b3,b4,b5,b6,b7,b8,b9;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mydatabase);

        db=openOrCreateDatabase("hpes",MODE_PRIVATE,null); //this function open the file of the name entered in first parameter, or it creates the file of same name is there is no file of this name.

        b1=(Button)findViewById(R.id.button10);
        b2=(Button)findViewById(R.id.button11);
        b3=(Button)findViewById(R.id.button12);
        b4=(Button)findViewById(R.id.button13);
        b5=(Button)findViewById(R.id.button14);
        b6=(Button)findViewById(R.id.button15);
        b7=(Button)findViewById(R.id.button16);
        b8=(Button)findViewById(R.id.button22);
        b9=(Button)findViewById(R.id.button23);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s="Create table if not exists login(name varchar(20), pass varchar(20))"; //query
                db.execSQL(s);  //execute query
                Toast.makeText(getApplicationContext(),"Table Created",Toast.LENGTH_LONG).show();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s1="insert into login values('Gautam',555)";
                String s2="insert into login values('Gotya',555)";
                String s3="insert into login values('Temp',000)";

                db.execSQL(s1);
                db.execSQL(s2);
                db.execSQL(s3);

                Toast.makeText(getApplicationContext(),"3 Records Loaded",Toast.LENGTH_LONG).show();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s="select *from login"; //* means all in SQL
                Cursor c=db.rawQuery(s,null);
                String data="";
                while(c.moveToNext())
                {
                    String n=c.getString(0);
                    String p=c.getString(1);
                    data=data+n+" : "+p+" \n";
                }

                AlertDialog.Builder b=new AlertDialog.Builder(Mydatabase.this);
                b.setTitle("Show Record :");
                b.setIcon(R.mipmap.ic_launcher);
                b.setMessage(data);
                b.setPositiveButton("OK", null);
                //till now only alert builder b have the resources, but it has not been created, so an extra object d has been made to store creation of b
                AlertDialog d=b.create();
                d.show();
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s="delete from login";
                db.execSQL(s);
                Toast.makeText(getApplicationContext(),"Records deleted",Toast.LENGTH_LONG).show();
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s="drop table if exists login";
                db.execSQL(s);
                Toast.makeText(getApplicationContext(),"Table deleted",Toast.LENGTH_LONG).show();
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(Mydatabase.this,InsertRecord.class);
                startActivity(i);
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(Mydatabase.this,AllRecords.class);
                startActivity(i);
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(Mydatabase.this,Login.class);
                startActivity(i);
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(Mydatabase.this,Myprovider.class);
                startActivity(i);
            }
        });

    }
}
