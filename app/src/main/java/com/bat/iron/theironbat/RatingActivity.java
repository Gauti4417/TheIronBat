package com.bat.iron.theironbat;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class RatingActivity extends Activity {

    RatingBar rb;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        rb=(RatingBar)findViewById(R.id.ratingBar);
        b=(Button)findViewById(R.id.button26);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String rating=String.valueOf(rb.getRating()); //valueOf() here is used to unbox getRating()
                Toast.makeText(getApplicationContext(),rating,Toast.LENGTH_LONG).show();

            }
        });
    }
}
