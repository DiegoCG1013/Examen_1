package dominio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.Arrays;

public class Tablero {
    private static int DIMENSION = 30;
    private int[][] estadoActual;
    private int[][] estadoSiguiente = new int[DIMENSION][DIMENSION];

    public void leerEstadoActual() {
        String matriz = "";
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            archivo = new File(Paths.get("matriz.txt").toAbsolutePath().toString());
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null)
                matriz = linea;
        } catch (Exception e) {
            System.out.println("Error");
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                System.out.println("Error");
            }
        }
        estadoActual = new int[DIMENSION][DIMENSION];
        int contador = 0;
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                estadoActual[i][j] = matriz.charAt(contador) - 48;
                contador++;
            }
        }
        calcularEstadoSiguiente();
    }



    public static void main(String[] args) {
        Tablero tablero = new Tablero();
        tablero.leerEstadoActual();

    }
}
