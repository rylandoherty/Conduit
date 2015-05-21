package com.fun.learnplex.conduit;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.PointF;
import com.fun.learnplex.conduit.MainActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Pan on 4/23/2015.
 */
public class init {


    int size = 15;
    int widthr ;
    int heightr;
    double centX ;
    double nextX ;
    double centY ;
    double nextY ;
    int pixel = 15;
    double width = pixel * 2;
    double horiz = width * 3 / 4;
    double height = (Math.sqrt(3) / 2 * width);
    double vert = height;

    Hexagon maybe;
    List<Hexagon> list = new ArrayList<Hexagon>();
    List<int[]> coord = new ArrayList<int[]>();
    int[]store = new int[3];
    public init(Point p) {

        widthr = p.x;
        heightr = p.y;
        centX = widthr/2;
        centY = heightr/2;
        nextY =centY;
        nextX =centX;
        yup();

    }
    public void yup (){

        for (int i = (-size); i <= size; i++) {
            nextY = centY + ((int) vert *i);
            add1(-1,i,0);
            maybe = new Hexagon(nextX,nextY);
            list.add(maybe);

        }

        centX = widthr/2;
        double topY = nextY;

        for (int i = (-size); i < 0; i++) {
            nextX = centX + ( horiz*i);
            nextY = topY + (( vert *i)/2);
            add1(size+i,size,size-i);
            maybe = new Hexagon(nextX,nextY);
            list.add(maybe);

            for(int b = 1 ;b<=size+(size+i);b++ ){

                double thisY = nextY - ((int) vert *b);
                add1(-i,i,0);
                maybe = new Hexagon(nextX,thisY);
                list.add(maybe);


        }}
        centX = widthr/2;

        for (int i = 1; i <= (size); i++) {
            nextX = centX + ( horiz*i);
            nextY = topY - (( vert *i)/2);
            add1(0-i,size,-size+i);
            maybe = new Hexagon(nextX,nextY);
            list.add(maybe);

            for(int b =size+(size-i);b>0;b-- ){
                double thisY = nextY - ((int) vert *b);
                add1(-i,i,0);


                coord.add(store);
                maybe = new Hexagon(nextX,thisY);

                list.add(maybe);
            }
        }
}
    public void add1(int a ,int b, int c){
        store[0] = a;
        store[1] = b;
        store[2] = c;

        coord.add(store);

    }
public List<Hexagon> getIt(){
    return list;
}
}