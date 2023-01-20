package com.example.acdat_pruebajuego.clases;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Circulo extends Figura {
    private double radio;

    public Circulo(int id, double posX, double posY, int colorFigura, double radio) {
        super(id, posX, posY, colorFigura);
        this.radio = radio;
    }

    public float getRadio() {
        return (float) radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    @Override
    public Boolean estaDentro(int x, int y) {


        return null;
    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawCircle(super.getPosX(), super.getPosY(), getRadio(), super.getPaint());
    }
}
