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

}
