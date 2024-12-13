package org.example;

import java.sql.Array;
import java.util.*;

public class Main {
    static ArrayList<String> ciudades = new ArrayList<>();
    //alojamientos
    static List<Map<String, Object>> alojamientos = Arrays.asList(
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
            ),
            // Apartamentos
            Map.of(
                    "nombre", "Apartamento Luna",
                    "ciudad", "Medellín",
                    "tipoAlojamiento", "Apartamento",
                    "calificacion", 4,
                    "precioPorNoche", 150000
            ),
            Map.of(
                    "nombre", "Apartamento Sol",
                    "ciudad", "Bogotá",
                    "tipoAlojamiento", "Apartamento",
                    "calificacion", 5,
                    "precioPorNoche", 180000
            ),
            // Fincas
            Map.of(
                    "nombre", "Finca El Encanto",
                    "ciudad", "Cartagena",
                    "tipoAlojamiento", "Finca",
                    "calificacion", 5,
                    "precioPorNoche", 250000
            ),
            Map.of(
                    "nombre", "Finca La Montaña",
                    "ciudad", "Medellín",
                    "tipoAlojamiento", "Finca",
                    "calificacion", 4,
                    "precioPorNoche", 220000
            )

    );

    public static void main(String[] args) {
        System.out.println("Seleccione la ciudad donde le gustaria hospedarse");
        ciudadesEncontradas();
        
    }

    public static void ciudadesEncontradas() {
        for (Map<String, Object> alojamiento : alojamientos) {
            if (!ciudades.contains((String) alojamiento.get("ciudad"))) {
                ciudades.add((String) alojamiento.get("ciudad"));
            }
        }

        int contador = 1;
        for (String ciudad : ciudades) {
            System.out.println(contador + ". " + ciudad);
            contador++;
        }
    }


}