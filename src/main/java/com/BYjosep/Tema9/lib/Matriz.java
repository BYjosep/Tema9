package com.BYjosep.Tema9.lib;

public class Matriz {

    /**
     * @param filas       numero de filas
     * @param columnas    numero de columnas
     * @param valorMinimo valor minimo en formato {@link Double double}
     * @param valorMaximo valor maximo en formato {@link Double double}
     * @return Devuelve una matriz rellenada con numeros aleatorios
     */
    public static double[][] crearMatrizAleatoria(int filas,
                                                  int columnas, double valorMinimo, double valorMaximo) {
        double[][] matriz = new double[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = LibRandoms.ran(valorMinimo, valorMaximo);
            }
        }
        return matriz;
    }


    /**
     * rellena de forma manual una matriz
     *
     * @param matriz matriz a rellenar
     */
    public static void rellenarMatrizManualmente(float[][] matriz) {
        final int OPERACION = 10_000;
        int filas = matriz.length;
        int columnas = matriz[0].length;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                float valor = LibFloats.ingresarUnNumeroF("Ingrese un numero para la fila " + i + " y la columna " + j);
                int aux = (int) (valor * OPERACION);
                valor = (float) aux / OPERACION;
                matriz[i][j] = valor;
            }
        }
    }


    /**
     * @param matriz matriz que desea convertir
     * @return Retorna un {@link String String} con la matriz
     */
    public static String matrizToString(float[][] matriz) {
        StringBuilder builder = new StringBuilder();
        final int LONGITUD = maximaLongitud(matriz);
        for (float[] floats : matriz) {
            for (float valor : floats) {
                builder.append(String.format("%-" + LONGITUD + ".4f    ", valor));
            }
            builder.append("\n");
        }
        return builder.toString();
    }


    /**
     * @param matriz matriz a comprobar
     * @return Devuelve el valor maximo de la matriz
     */
    private static int maximaLongitud(float[][] matriz) {
        int longitud = 0;
        for (float[] floats : matriz) {
            for (float valor : floats) {
                if (longitud < String.valueOf(valor).length()) {
                    longitud = String.valueOf(valor).length();
                }
            }
        }
        return longitud;
    }
}
