import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MatrizAdjunta {
    // iniciamos construyendo un main
    public static void main(String[] args) {
        String archivoEntrada = "matriz.txt";
        String archivoSalida = "matriz_adjunta.txt";

        double[][] matriz = leerMatriz(archivoEntrada);

        if (matriz != null) {
            System.out.println("matriz Original:");
            imprimirMatriz(matriz);

            double[][] adjunta = matrizAdjunta(matriz);

            if (adjunta != null) {
                System.out.println("\n Matriz Adjunta:");
                imprimirMatriz(adjunta);

                escribirArchivo(adjunta, archivoSalida);
                System.out.println("\n archivo generado: " + archivoSalida);
            } else {
                System.out.println("\n la matriz no es cuadrada. No se puede calcular la adjunta.");
            }
        } else {
            System.out.println("error al leer el archivo.");
        }
    }

     // lee la matriz desde el archivo
    public static double[][] leerMatriz(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            int filas = 0;

            // contara las filas
            while ((linea = br.readLine()) != null) {
                filas++;
            }

            double[][] matriz = new double[filas][];
            br.close();

            // lo lee de nuevo para guardar datos
            BufferedReader br2 = new BufferedReader(new FileReader(nombreArchivo));
            int i = 0;
            while ((linea = br2.readLine()) != null) {
                String[] valores = linea.trim().split(" ");
                matriz[i] = new double[valores.length];
                for (int j = 0; j < valores.length; j++) {
                    matriz[i][j] = Double.parseDouble(valores[j]);
                }
                i++;
            }
            br2.close();

            return matriz;

        } catch (IOException | NumberFormatException e) {
            System.out.println("error al leer archivo: " + e.getMessage());
            return null;
        }
    }

}
