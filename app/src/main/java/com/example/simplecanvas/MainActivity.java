package com.example.simplecanvas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private Canvas mCanvas;
    private Paint mPaint=new Paint();
    private Paint mPaintText=new Paint(Paint.UNDERLINE_TEXT_FLAG);
    private Bitmap mBitmap;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView=findViewById(R.id.my_imageview);
        mPaint.setColor(Color.YELLOW);
        mPaintText.setColor(ResourcesCompat.getColor(getResources(),
                R.color.colorPrimary,null));
        mPaintText.setTextSize(80);
    }

    public void drawSomething(View view) {
        int vWidth=view.getWidth();
        int vHeight=view.getHeight();
        mBitmap=Bitmap.createBitmap(vWidth,vHeight,Bitmap.Config.ARGB_8888);
        mImageView.setImageBitmap(mBitmap);
        mCanvas=new Canvas(mBitmap);
        mCanvas.drawColor(Color.WHITE);

        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(10);
        mCanvas.drawLine(100,150,400,150,mPaint);

        mPaint.setColor(Color.GRAY);
        Rect mRect=new Rect();
        mRect.set(300,800,800,1300);
        mCanvas.drawRect(mRect,mPaint);


        Path path=new Path();
        path.moveTo(550,500);
        path.lineTo(250,800);
        path.lineTo(850,800);
        path.close();
        mPaint.setColor(Color.GRAY);
        mCanvas.drawPath(path,mPaint);

        mPaint.setColor(Color.BLACK);
        RectF rectF=new RectF();
        rectF.set(500,1000,600,1300);
        mCanvas.drawOval(rectF,mPaint);

        mCanvas.drawText("Agnia Adzillawati",470,900,mPaintText);

        view.invalidate();
    }
}