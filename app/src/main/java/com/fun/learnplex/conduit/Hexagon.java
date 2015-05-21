package com.fun.learnplex.conduit;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

import com.fun.learnplex.conduit.MainActivity;

/**
 * Created by Pan on 4/15/2015.
 */
public class Hexagon {
 float[] f = new float[200];
    int osx = 0;
    int osy = 0;
    int sizez = 12;
    private static final String TAG = "Hexagon";


    double x,y;
public Hexagon(double xin,double yin) {

    x = xin;y=yin;
//

    //drawIt();
}

    public void drawIt(Canvas can) {
        for (int i = 1; i < 14; i = i + 2) {
            f[i] = (float) getAngleX(x,y, sizez, i);
            f[i + 1] = (float) getAngleY(x,y, sizez, i);
            if (i > 2) {
                Paint p = new Paint();
                can.drawLine(f[i - 2], f[i - 1], f[i], f[i + 1], p);
            }
        }
    }
    public double getAngleX(double x, double y, int size, int i) {
        double angle_deg = 30 * i + 90;
        double angle_rad = Math.PI / 180 * angle_deg;
        double distx = (x
                + size * Math.cos(angle_rad));
        //Log.d(TAG, "angle_radx="+angle_rad);
        //Log.d(TAG, "distx="+distx);
        return distx;
    }
    public double getAngleY(double x, double y, int size, int i) {
        double angle_deg = 30 * i + 90;
        double angle_rad = Math.PI / 180 * angle_deg;
        double disty = (y
                + size * Math.sin(angle_rad));
       // Log.d(TAG, "disty="+disty);

        return disty;
    }

}

