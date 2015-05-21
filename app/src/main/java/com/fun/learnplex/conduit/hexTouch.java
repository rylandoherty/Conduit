package com.fun.learnplex.conduit;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by Pan on 5/3/2015.
 */
public class hexTouch implements View.OnTouchListener {
    private static final String TAG = "hexTouch";
    PointF start;
    tryIt tryf;
    Canvas map;
    Bitmap b;
    public static class Anchor {

        public static final int CENTER = 0;
        public static final int TOPLEFT = 1;
    }


    public hexTouch(Canvas can, Bitmap dIV) {

        tryf = new tryIt(can,dIV);
    }

    public boolean onTouch(View view, MotionEvent event) {

        // Handle touch events here...
        if (event.getAction() == MotionEvent.ACTION_UP) {
            //Log.d(TAG, "mode=LLLLLLLLL");
            // Do what you want
        }

        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                start = new PointF(event.getX(), event.getY());
                Log.d(TAG, "mode=LLLLLLLLL");
                tryf.drawIt(start);


                break;
            case MotionEvent.ACTION_POINTER_DOWN:


            case MotionEvent.ACTION_UP:


        }
        return true; // indicate event was handled
    }



    public class tryIt {
        Canvas c;

        tryIt(Canvas can,Bitmap b) {
             c = new Canvas(b);


        }
        public void drawIt(PointF start){
            Hexagon h = new Hexagon(start.x, start.y);
            h.drawIt(c);
            System.out.println("WRITING");

        }
    }
}