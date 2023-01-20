package com.example.acdat_pruebajuego;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.acdat_pruebajuego.clases.Circulo;

import java.util.ArrayList;
import java.util.Random;

public class Vista extends View implements View.OnTouchListener {
    /*
    //-------BOLA QUE TE SIGUE EL DEDO-------

    private float x = 116, y = 116;

    public Vista(Context context) {
        super(context);

        this.setOnTouchListener(this::onTouch);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.MAGENTA);
        canvas.drawPaint(paint);

        paint.setColor(Color.BLACK);
        paint.setAntiAlias(true);
        canvas.drawRect(16, 16, getWidth() - 16, getHeight() - 16, paint);

        paint.setColor(Color.MAGENTA);
        canvas.drawCircle(x,
                y, 100, paint);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i("down", "down");
                break;
            case MotionEvent.ACTION_UP:
                Log.i("up", "up");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i("move", "move");
                x = motionEvent.getX();
                y = motionEvent.getY();
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.i("cancel", "cancel");
                break;
        }
        this.invalidate(); //para que refresque la pantalla
        return true;
    }
    */
    /*
    //-------INTENTO DE HACER UNA ESPECIE DE PAINT PERO NO VA-------

    private Double x = 116.0, y = 116.0;
    Paint paint;
    Canvas canvas;
    ArrayList<Double> xs;
    ArrayList<Double> ys;

    public Vista(Context context) {
        super(context);

        this.setOnTouchListener(this::onTouch);

        xs = new ArrayList<Double>();
        ys = new ArrayList<Double>();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.canvas = canvas;
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.MAGENTA);
        canvas.drawPaint(paint);

        paint.setColor(Color.BLACK);
        paint.setAntiAlias(true);
        canvas.drawRect(16, 16, getWidth() - 16, getHeight() - 16, paint);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i("down", "down");
                break;
            case MotionEvent.ACTION_UP:
                Log.i("up", "up");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i("move", "move");
                xs.add(Double.valueOf(motionEvent.getX()));
                ys.add(Double.valueOf(motionEvent.getY()));

                for (int i = 0; i < xs.size(); i++) {
                    paint.setColor(Color.MAGENTA);
                    canvas.drawCircle(xs.get(i).floatValue(),
                            ys.get(i).floatValue(), 100, paint);
                }
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.i("cancel", "cancel");
                break;
        }
        this.invalidate(); //para que refresque la pantalla
        return true;
    }
    */

    Random rand = new Random();

    private float x = 116, y = 116;
    private Boolean flag = false;

    public Vista(Context context) {
        super(context);

        this.setOnTouchListener(Vista.this);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawRGB(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));

        Paint paint = new Paint();
        /*
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);
        canvas.drawPaint(paint);
        */
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        canvas.drawRect(16, 16, getWidth() - 16, getHeight() - 16, paint);

        paint.setColor(Color.rgb(255, 104, 230));
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(x, y, 100, paint);

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        //motionEvent.getX();
        switch (motionEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.i("Down", "Down");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i("Move", "Move");
                x = motionEvent.getX();
                y = motionEvent.getY();
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.i("Cancel", "Cancel");
                break;
            case MotionEvent.ACTION_UP:
                Log.i("Up","Up");
                break;

        }

        this.invalidate();
        return true;
    }
}