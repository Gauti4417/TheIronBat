package com.bat.iron.theironbat;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

/**
 * Created by admin on 27-Jun-17.
 */
public class MyView extends View {

    Bitmap cloud;
    int x=0,y=0;    //values of x and y shows the poition of canvas
    Paint paint;

    public MyView(Context context)
    {
        super(context);
        cloud= BitmapFactory.decodeResource(getResources(),R.drawable.pic);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Rect rect=new Rect();
        rect.set(0, 0, canvas.getWidth(), canvas.getHeight());

        Paint paint=new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        canvas.drawRect(rect, paint);

        drawCloud(50, 200, canvas);
        drawCloud(x,y,canvas);
        drawCloud(100,300,canvas);
        drawCloud(200,400,canvas);
        drawCloud(300,500,canvas);
        drawCloud(400,600,canvas);

        if (x<canvas.getWidth())
        {
            x=x+2;
        }
        else
        {
            y=y+20;
            x=0;
        }
        invalidate();
    }
    private void drawCloud(int x2,int y2,Canvas canvas)
    {
        canvas.drawBitmap(cloud,x2,y2,paint);
    }
}
