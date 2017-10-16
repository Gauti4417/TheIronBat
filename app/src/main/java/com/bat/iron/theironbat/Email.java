package com.bat.iron.theironbat;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Email extends Activity {

    Button b;
    EditText textTo,textSubject,textMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        b=(Button)findViewById(R.id.button9);
        textTo=(EditText)findViewById(R.id.editText);
        textSubject=(EditText)findViewById(R.id.editText2);
        textMessage=(EditText)findViewById(R.id.editText3);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String to=textTo.getText().toString();
                String subject=textSubject.getText().toString();
                String message=textMessage.getText().toString();

                Intent i=new Intent(Intent.ACTION_SENDTO);

                String uriText = "mailto:"+to+"?subject="+ Uri.encode(subject) + "?body=" + Uri.encode(message);

                Uri uri=Uri.parse(uriText);

                i.setData(uri);
                startActivity(Intent.createChooser(i,"Send email"));
            }
        });
    }
}
