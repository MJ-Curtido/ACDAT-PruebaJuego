package com.example.acdat_pruebajuego;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

import com.example.acdat_pruebajuego.clases.Circulo;
import com.example.acdat_pruebajuego.clases.Figura;
import com.example.acdat_pruebajuego.clases.Rectangulo;

import java.util.ArrayList;

public class MoverFiguras extends SurfaceView implements SurfaceHolder.Callback {

    private HiloDraw threadDraw;
    private ArrayList<Figura> figuras;
    private int figuraActiva;

    public MoverFiguras(Context context) {
        super(context);

        getHolder().addCallback(this);
        setBackgroundColor(Color.WHITE);

    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        int id = 0;

        figuras = new ArrayList<Figura>();
        figuras.add(new Circulo(id++, 200, 200, Color.BLACK,100));
        figuras.add(new Rectangulo(id++, 200, 500, Color.RED,200, 200));

        threadDraw = new HiloDraw(this);
        threadDraw.setRunning(true);
        threadDraw.start();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
        boolean retry = true;
        threadDraw.setRunning(false);

        while (retry){
            try {
                threadDraw.join();
                retry = false;
            } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint p = new Paint();
        p.setAntiAlias(true);

        canvas.drawColor(Color.WHITE);

        Circulo c = (Circulo) figuras.get(0);
        c.onDraw(canvas);
        Rectangulo r = (Rectangulo) figuras.get(1);
        r.onDraw(canvas);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int x = (int) event.getX();
        int y = (int) event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                for (Figura f : figuras) {
                    if(f instanceof Circulo){
                        Circulo c = (Circulo) f;
                        double distanciaX = x - c.getPosX();
                        double distanciaY = y - c.getPosY();
                        if(Math.pow(c.getRadio(), 2) > (Math.pow(distanciaX, 2) + (Math.pow(distanciaY, 2)))){
                            figuraActiva = c.getId();
                            Log.i("FiguraActiva", "ID" + figuraActiva);
                        }
                    } else {
                        Rectangulo r = (Rectangulo) f;
                        if(x > r.getPosX() && x < r.getPosX() + r.getBase() && y > r.getPosY() && y < r.getPosY() + r.getAltura()){
                            figuraActiva = r.getId();
                            Log.i("FiguraActiva", "ID" + figuraActiva);
                        }
                    }
                }
                return true;
            case MotionEvent.ACTION_MOVE:
                System.out.println("MOVIENDOSE");
                break;
            case MotionEvent.ACTION_UP:{
                break;
            }
        }

        return super.onTouchEvent(event);
    }
}