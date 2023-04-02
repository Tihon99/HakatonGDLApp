package com.example.hakatongdlapp;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Square {
    double x, y;
    double vx = 0, vy = 0;
    int side;
    boolean inPipe = false;
    Canvas canvas;
    Paint paint = new Paint();
    public Square(int x, int y, int side, Canvas canvas, int color) {
        this.x = x;
        this.y = y;
        this.side = side;
        this.canvas = canvas;
        paint.setColor(color);
        canvas.drawRect(x, y, x + side, y + side, paint);
    }

    void update() {
        canvas.drawRect((float) x, (float) y, (float) x + side, (float) y + side, paint);
    }

    void squarePipeCollide(Pipe p) {
        if( y + side > p.y + 40 && x > p.x && x + side < p.x + p.width) {
            this.inPipe = true;
            p.selected = true;
        }
    }
}

