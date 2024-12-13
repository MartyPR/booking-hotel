package org.example;

import java.util.*;

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
        Set<String> ciudades = new HashSet<>();
        for (Map<String, Object> alojamiento : alojamientos) {
            ciudades.add((String) alojamiento.get("ciudad"));
        }

        System.out.println(ciudades);

    }
}