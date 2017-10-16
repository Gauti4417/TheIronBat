package com.bat.iron.theironbat;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

public class RadioActivity extends Activity {

    RadioGroup rd;
    LinearLayout li;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);

        rd=(RadioGroup)findViewById(R.id.rg);
        li=(LinearLayout)findViewById(R.id.li);

        rd.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { //OnCheckChangedListener for radio group
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch(checkedId)
                {
                    case R.id.r1:
                        li.setBackgroundColor(Color.RED);
                        break;
                    case R.id.r2:
                        li.setBackgroundColor(Color.GREEN);
                        break;
                    case R.id.r3:
                        li.setBackgroundColor(Color.BLUE);
                        break;
                    case R.id.r4:
                        li.setBackgroundColor(Color.GRAY);
                        break;
                    case R.id.r5:
                        li.setBackgroundResource(R.drawable.marsh); //drawable does not accepts capital letters, special characters or numbers in name
                        break;
                    case R.id.r6:
                        li.setBackgroundResource(R.drawable.ginger);
                        break;
                }

            }
        });
    }
}
