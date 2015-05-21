package com.fun.learnplex.conduit;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.List;


public class MainActivity extends Activity {


    Drawable d;
    Point size = new Point();
    //ImageView dIV;
    hexView dIV;
    private int mActivePointerId;
    int resourceId;
    // Called when the activity is first created.
    @Override
    public void onCreate(Bundle savedInstanceState) {
        Display display = getWindowManager().getDefaultDisplay();

        display.getSize(size);
        int width = size.x;
        int height = size.y;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FrameLayout fr = (FrameLayout) findViewById(R.id.r);
        hexView dIV = (hexView) findViewById(R.id.imageView);
        dIV.setSize(size);
        FrameLayout.LayoutParams fp = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT, Gravity.TOP | Gravity.LEFT);

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);
        paint.setTextSize(30);

        //Bitmap b = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        //Canvas c = new Canvas(b);
        //c.drawText("Some Text", 100, 100, paint);

/*
        init h = new init(size);
        List<Hexagon> list = h.getIt();
        for (int i = 0; list.size() > i; i++) {
            Hexagon maybe = list.get(i);
            maybe.drawIt(c);
        }
*/
        //hexView hv = new hexView(fr.getContext());

        PanAndZoomListener pz = new PanAndZoomListener(fr, dIV, PanAndZoomListener.Anchor.TOPLEFT);
        //fr.addView(dIV);
       fr.setOnTouchListener(pz);
        //hexTouch ht = new hexTouch(c,b);
        //dIV.setOnTouchListener(ht);


    }




    public boolean onTouch(View view, MotionEvent event) {

        // Handle touch events here...
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:


            case MotionEvent.ACTION_POINTER_DOWN:


            case MotionEvent.ACTION_UP:


        }
        return true; // indicate event was handled
    }}


