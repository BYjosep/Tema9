package com.BYjosep.Tema9.Ejercicio7;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ConversorMonedas {
    private static final Map<String, String> nombres = new HashMap<>();
    private static final Random random = new Random();

    static {
        nombres.put("USD", "Dólar USA");
        nombres.put("GBP", "Libra esterlina");
        nombres.put("INR", "Rupia India");
        nombres.put("AUD", "Dólar Australiano");
        nombres.put("CAD", "Dólar Canadiense");
        nombres.put("ARS", "Peso Argentino");
        nombres.put("BOB", "Boliviano Boliviano");
        nombres.put("CLP", "Peso Chileno");
        nombres.put("VEZ", "Peso Colombiano");
        nombres.put("CRC", "Colón Costarricense");
        nombres.put("CUP", "Peso Cubano");
        nombres.put("DOP", "Peso Dominicano");
        nombres.put("MXN", "Peso Mexicano");
    }

    public Map<String, String> getMonedas() {
        return nombres;
    }

    public double generarTasaCambio(String codigo) {
        return switch (codigo) {
            case "USD" -> 1 + random.nextDouble(0.00, 0.5);
            case "GBP" -> 0.8 + random.nextDouble(0.00, 0.2);
            case "INR" -> 80 + random.nextDouble(0.0, 20);
            case "AUD" -> 1.4 + random.nextDouble(0.0, 0.3);
            case "CAD" -> 1.3 + random.nextDouble(0.0, 0.3);
            case "ARS" -> 300 + random.nextDouble(0.0, 100);
            case "BOB" -> 7 + random.nextDouble(0.0, 1);
            case "CLP" -> 850 + random.nextDouble(0.0, 100);
            case "VEZ" -> 4000 + random.nextDouble(0.0, 1000);
            case "CRC" -> 550 + random.nextDouble(0.0, 150);
            case "CUP" -> 25 + random.nextDouble(0.0, 10);
            case "DOP" -> 55 + random.nextDouble(0.0, 15);
            case "MXN" -> 18 + random.nextDouble(0.0, 5);
            default -> 1.0; // EUR
        };
    }

    public String convertir(double euros, String codigo) {
        double tasa = generarTasaCambio(codigo);
        double resultado = euros * tasa;
        DecimalFormat formato = new DecimalFormat("0.00");
        return euros + " EUR son " + formato.format(resultado) + " " + codigo +
                " (" + nombres.get(codigo) + ", tasa: " + formato.format(tasa) + ")";
    }
}
