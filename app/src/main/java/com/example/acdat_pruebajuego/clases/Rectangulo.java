package com.example.acdat_pruebajuego.clases;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Rectangulo extends Figura {
    private double base, altura;

    public Rectangulo(int id, double posX, double posY, int colorFigura, double base, double altura) {
        super(id, posX, posY, colorFigura);
        this.base = base;
        this.altura = altura;
    }

    public float getBase() {
        return (float) base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public float getAltura() {
        return (float) altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public Boolean estaDentro(int x, int y) {
        Boolean dentro = false;

        if(x > posX && x < (posX + base) && y > posY && y < (posY + altura)) {
            dentro = true;
        }

        return dentro;
    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawRect(super.getPosX(), super.getPosY(), super.getPosX() + getBase(), super.getPosY() + getAltura(), super.getPaint());
    }
}
