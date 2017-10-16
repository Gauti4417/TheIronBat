package com.bat.iron.theironbat;

import android.app.Activity;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    String []ar={"My Grid View","My Web View","Intent Demo","Email Sending","Database Demo","Checkbox Demo","Radio Button Demo","Rating Bar Demo","Seek bar Demo","Progress Bar Demo","Toggle Demo","Switch Demo","Auto Complete Demo","Spinner Demo","Transfer through intent Demo","Shared Preference Demo","Service Demo","Music Player","Sensor Demo","SD card Demo","My View Demo","Notification Demo","Action bar menu","Google map demo","GPS demo"};
    Class []c={Mygrid.class, MyWeb.class, MyIntent.class,Email.class,Mydatabase.class,CheckboxActivity.class,RadioActivity.class,RatingActivity.class,SeekActivity.class,ProgressActivity.class,ToggleActivity.class,SwitchActivity.class,AutoActivity.class,SpinnerActivity.class,TransferActivity.class,SharedActivity.class,MyService.class,MyMusic.class,SensorActivity.class,MySDcard.class,MyViewTest.class,MyNotification.class,MyActionBar.class,GoogleActivity.class,Mygps.class};
     //this is made so that whichever element is clicked in array, same Class is opened


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,ar));

       // myProgress();

    }

    void myProgress(){
        //final for nesting thread

        final ProgressDialog pd=new ProgressDialog(this);
        pd.setMessage("Loading. Please Wait!!");
        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pd.setCancelable(false);
        pd.setTitle("My Android App");
        pd.show();

        Thread t =new Thread() {
            public void run() {
                for (int i=0;i<=100;i++) {
                    try {
                        sleep(1000/20);
                    } catch (Exception e) {}
                    pd.setProgress(i);
                }
                pd.dismiss();
            }
        };
        t.start();
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Intent ob=new Intent(this,c[position]);
        startActivity(ob);
    }

}
