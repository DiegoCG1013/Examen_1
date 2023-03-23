package mates;

public class Matematicas {

    public static double generarNumeroPi(long pasos) {
        double aciertos = 0;
        double areaCuadrado = 4;
        for (int i = 0; i < pasos; i++) {
            double x = Math.random();
            double y = Math.random();
            if (x * x + y * y <= 1) aciertos++;
        }
        return areaCuadrado * aciertos / pasos;
    }
}
