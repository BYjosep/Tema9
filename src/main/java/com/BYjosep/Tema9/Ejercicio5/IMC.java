package com.BYjosep.Tema9.Ejercicio5;

public enum IMC {
    PESO_INSUFICIENTE("Peso insuficiente"),
    PESO_NORMAL("Peso normal"),
    SOBREPESO_GRADO_1("Sobre peso grado 1"),
    SOBREPESO_GRADO_2("Sobre peso grado 2"),
    SOBREPESO_GRADO_3("Sobre peso grado 3");

    private final String mensaje;

    IMC(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return mensaje;

    }
}
