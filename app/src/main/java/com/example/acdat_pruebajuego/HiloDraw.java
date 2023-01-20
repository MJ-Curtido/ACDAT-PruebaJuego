package com.example.acdat_pruebajuego;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class HiloDraw extends Thread {
    private MoverFiguras view;
    private boolean run;
    private SurfaceHolder sh;

    public HiloDraw(MoverFiguras view) {
        this.view = view;
        this.sh = view.getHolder();
    }

    @Override
    public void run() {
        Canvas canvas = null;

        while(run) {
            canvas = null;

            try {
                canvas = sh.lockCanvas(null);

                if (canvas != null) {
                    synchronized (sh) {
                        view.postInvalidate();
                    }
                }
            } finally {
                if (canvas != null) {
                    sh.unlockCanvasAndPost(canvas);
                }
            }
        }
    }

    public void setRunning(boolean run){
        this.run=run;
    }
}
