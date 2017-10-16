package com.bat.iron.theironbat;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

public class Mygrid extends Activity {

    GridView g;
    String []ar={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    //Class []c={NextGrid.class};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mygrid);

        g=(GridView)findViewById(R.id.gi);

        ArrayAdapter<String> obj= new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,ar);
        g.setAdapter(obj);

        g.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String name=ar[position];
                Toast.makeText(getApplicationContext(),""+name,Toast.LENGTH_LONG).show();

            //   Intent ob=new Intent(Mygrid.this,c[position]); //Mygrid is used along with this because this activity is not a launcher activity
            //   startActivity(ob);
            }
        });
    }
}
