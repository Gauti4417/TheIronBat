package com.bat.iron.theironbat;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MyActionBar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_action_bar);

        /*ActionBar ab=getActionBar();
        ab.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        ab.setDisplayHomeAsUpEnabled(true);
        ab.show();*/
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.home:
                Intent i=new Intent(MyActionBar.this,HomeActivity.class);
                startActivity(i);
                return true;

            case R.id.java:
                javaActivity();
                return true;

            case R.id.android:
                androidActivity();
                return true;

            case R.id.action_settings:
                Toast.makeText(getApplicationContext(), "Settings", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.sample,menu);

        return super.onCreateOptionsMenu(menu);
    }

    public void javaActivity()
    {
        Toast.makeText(getApplicationContext(), "Java Option Selected", Toast.LENGTH_SHORT).show();
    }

    public void androidActivity()
    {
        Toast.makeText(getApplicationContext(), "Android Option Selected", Toast.LENGTH_SHORT).show();
    }
}
