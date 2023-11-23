package com.mycompany.graficadora;

public class Funcion {
    private int a, b, c;
    private double corteX, corteY, vx, vy, extremo; // Se utilizan para calcular los extremos de la funcion
    private boolean nullX; // Se utiliza para saber si no hay corte en el eje X en una funcion cuadratica
    
    public Funcion () {}
    
    private void PuntosDeCorteLineal() {
        corteY = b;
        if (a != 0) {
            corteX = -(b/a);
            return ; // Cerrar la funcion
        }
        corteX = 0;
    }
    
    private void PuntosDeCorteCuadratica() {
        corteY = c;
        if (a != 0) {
            
            // No existe corte con el eje x
            if ((-4 * a * c) < 0){
                return ;
            }
            
            // Existe corte con el eje x
            nullX = false;
            
            double x1, x2;
            x1 = (-b +(Math.sqrt(b*b - 4*a*c))) / (2 * a);
            x2 = (-b -(Math.sqrt(b*b - 4*a*c))) / (2 * a);
            
            if(x1 > x2) {
                corteX = x1;
                return;
            }
            
            corteX = x2;
                
        }
        
        if (a != 0) {
            corteX = -(b/a);
            return ; // Cerrar la funcion
        }
        
        corteX = 0;
    }
    
    private void Vertice() {
        vx = (-b)/(2*a);
        vy = (-(b*b)+4*a*c)/(2*a);
    }
    
    // Se busca el extremo de la funcion para, en funcion de él, obtener la escala
    public double getExtremoLineal() {
        PuntosDeCorteLineal();
        CalcularExtremoLineal();
        return extremo + 1.15;
    }
    
    public double getExtremoCuadratica() {
        PuntosDeCorteCuadratica();
        if (a != 0) {
            Vertice();
            CalcularExtremoCuadratica();
            return extremo + 1.15;
        }
        // Si es 0, se calcula el extremo como si de una ecuacion lineal se tratase
        CalcularExtremoLineal();
        return extremo;
    }
    
    // Funcion lineal
    public void setLineal(int a, int b) {
        this.a = a;
        this.b = b;
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
            
            if (i == 0 && !nullX)
                extremo = arr[0];
            if (i > 0) {
                if (i == 1 && nullX) {
                    extremo = arr[1]; // El extremo sera corteY
                    i++; // Actualizar i para comparar con el siguiente elemento
                }
                if (extremo < arr[i])
                    extremo = arr[i];
            }
        }
    }

    // Funcion cuadratica
    public void setCuadratica(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.nullX = true;
    }

    public void DibujarLineal(PlanoLineal p) {
        for (float x = -56; x <= 56 ; x += .1) {
            float y = a*x + b; // Formula lineal
            p.dibujarPunto(x, y);
        }
    }
    
    public void DibujarCuadratica(PlanoCuadratico p) {
        for (float x = -56; x <= 56 ; x += .1) {
            float y = a*(x*x) + b*x + c; // Formula cuadratica
            //p.dibujarPunto(x, y);
        }
    }    
}
