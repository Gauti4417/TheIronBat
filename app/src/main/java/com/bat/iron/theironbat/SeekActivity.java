package com.bat.iron.theironbat;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class SeekActivity extends Activity {

    SeekBar sb;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek);

        sb=(SeekBar)findViewById(R.id.seekBar);
        tv=(TextView)findViewById(R.id.textView4);

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { //note the new Listener
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //Toast.makeText(getApplicationContext(), "seekbar progress: "+progress, Toast.LENGTH_SHORT).show();
                tv.setText("seekbar progress: "+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //Toast.makeText(getApplicationContext(), "seekbar touch started!", Toast.LENGTH_SHORT).show();
                tv.setText("seekbar touch started!");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //Toast.makeText(getApplicationContext(), "seekbar touch stopped!", Toast.LENGTH_SHORT).show();
                tv.setText("seekbar touch stopped!");
            }
        });
    }
}
