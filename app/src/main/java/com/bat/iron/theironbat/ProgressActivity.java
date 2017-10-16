package com.bat.iron.theironbat;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProgressActivity extends Activity {

    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        b=(Button)findViewById(R.id.button27);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog pd=new ProgressDialog(ProgressActivity.this);
                pd.setMessage("Loading. Please Wait!!");
                pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                pd.setCancelable(false);
                pd.setTitle("My Android App");
                pd.show();

                Thread t =new Thread() {
                    public void run() {
                        for (int i=0;i<=100;i++) {
                            try {
                                sleep(1000/50);
                            } catch (Exception e) {}
                            pd.setProgress(i);
                        }
                        pd.dismiss();
                    }
                };
                t.start();
            }
        });
    }
}
