package com.bat.iron.theironbat;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;


public class ToggleActivity extends Activity {

    Button b;
    ToggleButton tb1,tb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle);

        b=(Button)findViewById(R.id.button28);
        tb1=(ToggleButton)findViewById(R.id.toggleButton);
        tb2=(ToggleButton)findViewById(R.id.toggleButton2);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringBuilder result=new StringBuilder();
                result.append("Toggle 1 : ").append(tb1.getText());
                result.append("\nToggle 2 : ").append(tb2.getText());
                result.toString();
                Toast.makeText(getApplication(),result, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
