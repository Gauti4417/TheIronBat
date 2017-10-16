package com.bat.iron.theironbat;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertRecord extends Activity {

    Button b;
    EditText ed,ed1;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_record);

        b=(Button)findViewById(R.id.button17);
        ed=(EditText)findViewById(R.id.editText4);
        ed1=(EditText)findViewById(R.id.editText5);
        db=openOrCreateDatabase("hpes",MODE_PRIVATE,null); //same name as in MyDatabase has to be used

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String n=ed.getText().toString();
                String p=ed1.getText().toString();
                String s="insert into login values('"+n+"','"+p+"')";

                if(n.equals(""))
                    ed.setError("Enter Name");
                else if (p.equals(""))
                    ed1.setError("Enter Password");
                else
                    db.execSQL(s);

                Toast.makeText(getApplicationContext(),"New Record Loaded", Toast.LENGTH_LONG).show();

            }
        });
    }
}
