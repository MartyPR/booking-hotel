package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Booking hotel Project");

        List<Map<String, Object>> alojamientos = Arrays.asList(
                // Hoteles
                Map.of(
                        "nombre", "Hotel Paraíso",
                        "ciudad", "Cartagena",
                        "tipoAlojamiento", "Hotel",
                        "calificacion", 5,
                        "precioPorNoche", 200000

                ),
                Map.of(
                        "nombre", "Hotel Real",
                        "ciudad", "Bogotá",
                        "tipoAlojamiento", "Hotel",
                        "calificacion", 4,
                        "precioPorNoche", 180000

                )
        );


    }
}