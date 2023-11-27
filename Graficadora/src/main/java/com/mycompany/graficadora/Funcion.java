package com.mycompany.graficadora;

public class Funcion {
    private int a, b, c;
    private double corteX, corteY, vx, vy, extremo; // Se utilizan para calcular los extremos de la funcion
    
    // Funcion lineal
    public Funcion(int a, int b) {
        this.a = a;
        this.b = b;
    }
    
    // Funcion cuadratica
    public Funcion(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    private void CambiarSignoLineal() {
        if (corteX < 0)
                corteX *= -1;
        
        if (corteY < 0)
            corteY *= -1;
    }
    
    private void CambiarSignoCuadratica() {
        if (corteX != Double.NaN)
            if (corteX < 0)
                corteX *= -1;
        
        if (corteY < 0)
            corteY *= -1;
        
        if (vx < 0)
            vx *= -1;
        
        if (vy < 0)
            vy *= -1;
        
    }
    private void PuntosDeCorteLineal() {
        corteY = b;
        if (a != 0) {
            corteX = (double) -(b/a);
            return ; // Cerrar la funcion
        }
        corteX = 0;
    }
    
    private void PuntosDeCorteCuadratica() {
        corteY = c;
        if (a != 0) {
            
            // No existe corte con el eje x
            if ((b * b - 4 * a * c) < 0) {
                corteX = Double.NaN;
                return ;
            }
            
            double x1, x2;
            x1 = (double) (-b +(Math.sqrt(b*b - 4*a*c))) / (2 * a);
            x2 = (double) (-b -(Math.sqrt(b*b - 4*a*c))) / (2 * a);
            
            if(x1 > x2) {
                corteX = x1;
                return;
            }
            
            corteX = x2;
                
        }
        
        if (a != 0) {
            corteX = (double) -(b/a);
            return ; // Cerrar la funcion
        }
        
        corteX = 0;
    }
    
    private void Vertice() {
        vx = (double) (-b)/(2*a);
        vy = a*vx*vx + b*vx + c;
    }
    
    // Se busca el extremo de la funcion para, en funcion de él, obtener la escala
    public double getExtremoLineal() {
        PuntosDeCorteLineal();
        CambiarSignoLineal();
        CalcularExtremoLineal();
        return extremo;
    }
    
    public double getExtremoCuadratica() {
        PuntosDeCorteCuadratica();
        if (a != 0) {
            Vertice();
            CambiarSignoCuadratica();
            CalcularExtremoCuadratica();
            return extremo;
        }

        CambiarSignoCuadratica();        
        // Si es 0, se calcula el extremo como si de una ecuacion lineal se tratase
        CalcularExtremoLineal();
        return extremo;
    }
    
    
    
    private void CalcularExtremoLineal() {
        if (corteX > corteY) {
            extremo = corteX;
            return ;
        }
        
        extremo = corteY;
    }
    
    private void CalcularExtremoCuadratica() {
        double arr[] = {corteX, corteY, vx, vy};
        for (int i = 0; i < arr.length; i++) {
            
            if (i == 0 && !Double.isNaN(corteX))
                extremo = arr[0];
            
            if (i > 0) {
                if (i == 1 && Double.isNaN(corteX)) {
                    extremo = arr[1]; // El extremo sera corteY
                    i++; // Actualizar i para comparar con el siguiente elemento
                }
                if (extremo < arr[i])
                    extremo = arr[i];
            }
        }
    }

    public void DibujarLineal(PlanoLineal p, double e, int dec) {
        float x = (float) e * 10;

        dec /= 10;

        a /= dec;
        b /= dec;

        for (x = -x; x <= (float) e * 10; x += .1) {
            float y = a*x + b; // Formula lineal
            p.dibujarPunto(x, y);
        }
    }
    
    public void DibujarCuadratica(PlanoCuadratico p, double e, int dec) {
        float x = (float) e * 10;

        dec /= 10;

        a /= dec;
        b /= dec;
        c /= dec;

        for (x = -x; x <= (float) e * 10; x += .1) {
            float y = a*(x*x) + b*x + c; // Formula cuadratica
            p.dibujarPunto(x, y);
        }
    }    
}
