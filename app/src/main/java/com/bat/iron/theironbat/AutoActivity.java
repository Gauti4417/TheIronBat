package com.bat.iron.theironbat;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class AutoActivity extends Activity {

    AutoCompleteTextView a;
    String []arr={"Apple","Android","Java","Jump","Raipur","Railway","RailView","Product","Produce","IronBat"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto);

        a=(AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);

        ArrayAdapter ob= new ArrayAdapter(this,android.R.layout.select_dialog_item,arr); //note that here, 'select' is used in second parameter not 'simple'

        a.setThreshold(1); //this means the auto searching will start from the 1st word
        a.setAdapter(ob);
        a.setTextColor(Color.RED);
    }
}
