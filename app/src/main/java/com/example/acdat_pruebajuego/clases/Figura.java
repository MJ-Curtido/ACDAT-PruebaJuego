package com.example.acdat_pruebajuego.clases;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Objects;

public abstract class Figura {
    protected int id;
    protected double posX, posY;
    protected Paint paint;

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    public float getPosX() {
        return (float) posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public float getPosY() {
        return (float) posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Figura(int id, double posX, double posY, int colorFigura) {
        this.id = id;
        this.posX = posX;
        this.posY = posY;
        this.paint = new Paint();
        this.paint.setColor(colorFigura);
    }

    public abstract Boolean estaDentro(int x, int y);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Figura figura = (Figura) o;
        return id == figura.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public abstract void onDraw(Canvas canvas);
}
