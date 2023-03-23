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

    public void transitarAlEstadoSiguiente(){
        estadoActual = estadoSiguiente;
        calcularEstadoSiguiente();
    }

    public void calcularEstadoSiguiente() {
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                estadoSiguiente[i][j] = recinto(i, j) > 2 ? 1 : 0;
            }
        }
    }

    private int recinto(int i, int j) {
        int resultado = 0;
        for (int k = i - 1; k <= i + 1; k++) {
            for (int l = j - 1; l <= j + 1; l++) {
                if (k >= 0 && k < DIMENSION && l >= 0 && l < DIMENSION) {
                    resultado += estadoActual[k][l];
                }
            }
        }
        return resultado;
    }

    public void generarEstadoActualPorMontecarlo(){
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                estadoActual[i][j] = (int) (Math.random() * 2);
            }
        }
    }

    @Override
    public String toString() {
        String resultado = "";
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                resultado += (estadoActual[i][j] == 1 ? "*" : " ") + " ";
            }
            resultado += "\n";
        }
        return resultado;
    }
}
