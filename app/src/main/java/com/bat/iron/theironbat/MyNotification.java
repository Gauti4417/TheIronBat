package com.bat.iron.theironbat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyNotification extends AppCompatActivity {
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_notification);

        b=(Button)findViewById(R.id.button39);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext()).setSmallIcon(R.drawable.pic).setContentTitle("Notification example").setContentText("This is set notification");
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                PendingIntent contentIntent = PendingIntent.getActivity(getApplicationContext(),0,i,PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(contentIntent);

                NotificationManager manager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                manager.notify(0,builder.build());
            }
        });
    }
}
