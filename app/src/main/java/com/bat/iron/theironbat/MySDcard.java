package com.bat.iron.theironbat;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MySDcard extends Activity {

    private Cursor videocursor;
    private  int video_column_index;
    ListView videolist;
    int count;
    String[] thumbcolumns={MediaStore.Video.Thumbnails.DATA,MediaStore.Video.Thumbnails.VIDEO_ID};
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_sdcard);
        init_phone_music_grid();
    }
    private void init_phone_music_grid()
    {
        String []proj={MediaStore.Audio.Media._ID,MediaStore.Audio.Media.DATA,MediaStore.Audio.Media.DISPLAY_NAME,MediaStore.Audio.Media.SIZE};
        videocursor =managedQuery(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,proj,null,null,null);
        count =videocursor.getCount();
        videolist=(ListView)findViewById(R.id.listView);
        videolist.setAdapter(new MusicAdapter(getApplicationContext()));
        videolist.setOnItemClickListener(musicgridlistner);
        mediaPlayer=new MediaPlayer();

    }
    AdapterView.OnItemClickListener musicgridlistner=new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            video_column_index =videocursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA);
            videocursor.moveToPosition(position);
            String filename=videocursor.getString(video_column_index);
            try {
                if (mediaPlayer.isPlaying())
                {
                    mediaPlayer.reset();
                }
                mediaPlayer.setDataSource(filename);
                mediaPlayer.prepare();
                mediaPlayer.start();
            }
            catch (Exception e)
            {

            }
        }
    };
    public class MusicAdapter extends BaseAdapter
    {
        private Context mContext;
        public MusicAdapter(Context c){
            mContext=c;
    }
        @Override
        public int getCount() {
            return count;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            System.gc();
            ViewHolder holder;
            String id=null;
            convertView = null;
            if (convertView == null) {

                convertView = LayoutInflater.from(mContext).inflate(R.layout.listitem, parent, false);
                holder = new ViewHolder();
                holder.txtTitle = (TextView)convertView.findViewById(R.id.txtTitle);
                holder.txtSize = (TextView)convertView.findViewById(R.id.txtSize);
                holder.thumbImage = (ImageView)convertView.findViewById(R.id.imgIcon);

                video_column_index=videocursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DISPLAY_NAME);
                videocursor.moveToPosition(position);
                id=videocursor.getString(video_column_index);
                video_column_index=videocursor.getColumnIndexOrThrow(MediaStore.Audio.Media.SIZE);
                videocursor.moveToPosition(position);

                holder.txtTitle.setText(id);
                holder.txtSize.setText(" Size(KB):" + videocursor.getString(video_column_index));

                //String[] proj={MediaStore.Audio.Media._ID,MediaStore.Audio.Media.DISPLAY_NAME,MediaStore.Audio.Media.DATA};
            }

            return convertView;
        }
    }

    static class ViewHolder
    {
        TextView txtTitle;
        TextView txtSize;
        ImageView thumbImage;
    }

}
