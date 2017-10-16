package com.bat.iron.theironbat;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

public class SwitchActivity extends Activity {

    Button b;
    Switch s1,s2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch);

        b=(Button)findViewById(R.id.button29);
        s1=(Switch)findViewById(R.id.switch1);
        s2=(Switch)findViewById(R.id.switch2);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringBuilder r1=new StringBuilder();
                StringBuilder r2=new StringBuilder();
                if(s1.isChecked())
                    r1.append(s1.getTextOn());
                else
                    r1.append(s1.getTextOff());

                if(s2.isChecked())
                    r2.append(s2.getTextOn());
                else
                    r2.append(s2.getTextOff());

                Toast.makeText(getApplicationContext(), "Switch1 : "+r1+"\nSwitch2 : "+r2, Toast.LENGTH_SHORT).show();

            }
        });
    }
}
