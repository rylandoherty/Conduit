package com.fun.learnplex.conduit;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.fun.learnplex.conduit.Hexagon;

import java.util.List;

/**
 * Created by Pan on 5/4/2015.
 */

public class hexView extends ImageView {

    private static final String TAG ="BOOMBABY" ;
    protected Bitmap art;
    int width;
    int height;
    Point size;
    PointF start;
    Canvas canvas;
    public hexView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public hexView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

    }
    public hexView(Context context) {
        super(context);
    }
    public hexView(Context context,int x, int y) {
        super(context);

    }


public void setSize(Point screen){
    width = screen.x;
    height = screen.y;
    art = Bitmap.createBitmap(width,height,Bitmap.Config.ARGB_8888);
    canvas = new Canvas(art);
    size= screen;
    canvas.save();

    init h = new init(size);
    List<Hexagon> list = h.getIt();

    for (int i = 0; list.size() > i; i++) {
        Hexagon maybe = list.get(i);
        maybe.drawIt(canvas);
    }
    this.setImageBitmap(art);
    canvas.restore();
}



    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        this.setImageBitmap(art);



}
    public void drawIt(Hexagon h) {
        h.drawIt(canvas);
    }
    /*
    @Override public boolean onTouchEvent(MotionEvent event) {


        // Handle touch events here...
        if (event.getAction() == MotionEvent.ACTION_UP) {
            //Log.d(TAG, "mode=LLLLLLLLL");
            // Do what you want
        }

        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                start = new PointF(event.getX(), event.getY());
                Log.d(TAG, "mode=LLLLLLLLL");
                Hexagon h = new Hexagon(start.x, start.y);
                h.drawIt(canvas);
                break;
            case MotionEvent.ACTION_POINTER_DOWN:


            case MotionEvent.ACTION_UP:


        }
        return true; // indicate event was handled
    }
*/
}