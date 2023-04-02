package com.example.hakatongdlapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import androidx.annotation.NonNull;

import java.util.Random;

public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    int touchX,  touchY;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        touchX = (int)event.getX();
        touchY = (int)event.getY();

        return true;
    }

    class DrawThread extends Thread {
        Random r = new Random();
        Paint paint = new Paint();
        boolean runFlag = true;
        SurfaceHolder holder;
        Canvas canvas;

        Integer[] colors = new Integer[] {Color.RED,  Color.YELLOW, Color.GREEN, Color.BLUE, Color.MAGENTA};
        public DrawThread(SurfaceHolder holder) {
            this.holder = holder;
        }


        @Override
        public void run() {
            super.run();
            canvas = holder.lockCanvas();
            int width = canvas.getWidth();
            int height = canvas.getHeight();
            int pipeWidth = width/3 - 20;
            int pipeHeight = height/3;
            int count = 2;

            int side = 200;
            //int sqColor = Color.rgb(r.nextInt(255), r.nextInt(255), r.nextInt(255));
            int sqColor = Color.rgb(0, 0, 255);
            int pipeColor = Color.rgb(255, 0, 0);
            Square square = new Square((int) (width-side)/2, (int) (height-side)/2, side, canvas, sqColor);
            Pipe pipe1 = new Pipe(10, height - pipeHeight, pipeWidth, pipeHeight, canvas, pipeColor);
            Pipe pipe2 = new Pipe(pipeWidth + 20, height - pipeHeight, pipeWidth, pipeHeight, canvas, pipeColor);
            Pipe pipe3 = new Pipe((pipeWidth + 20)*2, height - pipeHeight, pipeWidth, pipeHeight, canvas, pipeColor);
            holder.unlockCanvasAndPost(canvas);
            boolean win = false;
            while (runFlag) {
                canvas = holder.lockCanvas();
                if( canvas!= null) {
                    canvas.drawColor(Color.WHITE);
                    Paint fontPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
                    fontPaint.setTextSize(60);
                    fontPaint.setTextAlign(Paint.Align.CENTER);
                    canvas.drawText("Счет: " + count, width/2, 60,  fontPaint);
                    if (!square.inPipe) {
                        if (touchX > square.x && touchX < square.x + square.side && touchY > square.y && touchY < square.y + square.side) {
                            double px = square.x, py = square.y;
                            square.x = touchX - square.side / 2;
                            square.y = touchY - square.side / 2;
                            square.vx = square.x - px;
                            square.vy = square.y - py;
                        }
                    }
                    else {
                        if (square.y + side < height) {
                            square.y += 10;
                        }
                        else {
                            square.x = (int) (width-side)/2;
                            square.y = (int) (height-side)/2;
                            square.inPipe = false;
                            count += 2;

                        }

                    }

                    square.squarePipeCollide(pipe1);
                    square.squarePipeCollide(pipe2);
                    square.squarePipeCollide(pipe3);
                    pipe1.update();
                    pipe2.update();
                    pipe3.update();
                    square.update();

                    holder.unlockCanvasAndPost(canvas);
                    try {
                        Thread.sleep(10);
                    }
                    catch (InterruptedException e) { }
                }
            }
        }
    }
    DrawThread thread;
    public MySurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        thread = new DrawThread(holder);
        thread.start();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {
        thread.runFlag = false;
        thread = new DrawThread(holder);
        thread.start();
    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {
        thread.runFlag = false;
    }
}
