package mates;

public class Matematicas {

    public static double generarNumeroPi(long pasos) {
        try {
            double aciertos = 0;
            double areaCuadrado = 4;
            for (int i = 0; i < pasos; i++) {
                double x = Math.random();
                double y = Math.random();
                if (x * x + y * y <= 1) aciertos++;
            }
            return areaCuadrado * aciertos / pasos;
        }catch (Exception e){
            System.out.println("No has introducido un numero válido");
        }
        return 0;
    }
}
