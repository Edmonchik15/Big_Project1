package com.example.bird1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MyDraw extends View {
    public MyDraw(Context context) {
        super(context);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        canvas.drawPaint(paint);
        paint.setAntiAlias(true);
        paint.setColor(Color.argb(127,0,0,255));
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, 100, paint);
        paint.setColor(Color.BLUE);
        canvas.drawRect(0, 0, getWidth(),200, paint);
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(30);
        canvas.drawText("Samsung IT school", 50, 100, paint);
        float rotate_center_x = 200;
        float rotate_center_y = 200;
        float rotate_angle = 45;
        canvas.rotate(-rotate_angle, rotate_center_x, rotate_center_y);
        paint.setColor(Color.BLACK);
        paint.setTextSize(40);
        canvas.drawText("Samsung IT school",0,450,paint);
        canvas.rotate(rotate_angle, rotate_center_x, rotate_center_y);
        Bitmap image = BitmapFactory.decodeResource(getResources(), R.drawable.samsung);
        int xx = canvas.getWidth(), yy = canvas.getHeight();
        canvas.drawBitmap(image, xx - image.getWidth(), yy - image.getHeight(), paint);
    }
}