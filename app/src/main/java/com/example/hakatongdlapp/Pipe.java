package com.example.hakatongdlapp;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Pipe {
    double x, y;
    double vx = 0, vy = 0;
    int width;
    int height;
    boolean selected = false;
    Canvas canvas;
    Paint paint = new Paint();
    public Pipe(int x, int y, int width, int height, Canvas canvas, int color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.canvas = canvas;
        paint.setColor(color);
        canvas.drawRect(x, y, x + width, y + height, paint);
    }

    void update() {
        canvas.drawRect((float) x, (float) y, (float) x + width, (float) y + height, paint);
    }
}