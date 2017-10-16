package com.bat.iron.theironbat;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by admin on 25-Jun-17.
 */
public class MusicDemo extends Service implements MediaPlayer.OnCompletionListener {

    MediaPlayer mp;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {

        mp=MediaPlayer.create(this,R.raw.a);
        mp.setOnCompletionListener(this);
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(!mp.isPlaying())
            mp.start();
        return START_STICKY;  //start forcefully
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mp.isPlaying())
            mp.stop();;
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        stopSelf();
    }
}
