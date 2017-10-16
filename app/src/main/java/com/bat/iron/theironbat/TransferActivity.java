package com.bat.iron.theironbat;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TransferActivity extends Activity {

    Button b;
    EditText et1,et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);

        b=(Button)findViewById(R.id.button30);
        et1=(EditText)findViewById(R.id.editText8);
        et2=(EditText)findViewById(R.id.editText9);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String n=et1.getText().toString();
                String p=et2.getText().toString();

                Intent i=new Intent(TransferActivity.this,ShowRecord.class);
                i.putExtra("U",n);
                i.putExtra("B",p);
                //U and B are objects
                startActivity(i);
            }
        });
    }
}
