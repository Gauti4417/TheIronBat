package com.bat.iron.theironbat;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class SpinnerActivity extends Activity {

    Spinner s;
    Button b;
    String []arr={"Apple","Android","Java","Jump","Raipur","Railway","RailView","Product","Produce","IronBat"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        s=(Spinner)findViewById(R.id.spinner);
        b=(Button)findViewById(R.id.button31);
        ArrayAdapter ob=new ArrayAdapter(this,android.R.layout.simple_spinner_item,arr); //we have to use the name of the activity along with this when we are accessing a global variable and 'this' is present in a local area
        ob.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(ob);

        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                final int p=position;
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(),arr[p], Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
