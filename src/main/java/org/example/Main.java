package org.example;


import java.util.*;


public class Main {
    static ArrayList<String> ciudades = new ArrayList<>();
    static ArrayList<String> tipoAlojamientos = new ArrayList<>();
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
        Scanner scanner = new Scanner(System.in);
        ciudadesEncontradas();
        tiposAlojamientoEncontradas();
        while (true) {

            int opcionCiudad = seleccionarOpcion(scanner, "Seleccione la ciudad donde le gustaria hospedarse", ciudades);
            if (opcionCiudad == -1) continue;

            int opcionTipoAlojamiento = seleccionarOpcion(scanner, "Seleccione la tipo de alojamiento donde le gustaria hospedarse", tipoAlojamientos);
            if (opcionTipoAlojamiento == -1) continue;

//            int fechaInicio  = obtenerEntradaValida(scanner, "Ingrese  el día de inicio del hospedaje: ");
//            int fechaFin  = obtenerEntradaValida(scanner, "Ingrese el día de finalización del hospedaje: ");
//            int cantidadAdultos = obtenerEntradaValida(scanner, "Ingrese la cantidad de adultos: ");
//            int cantidadNinos = obtenerEntradaValida(scanner, "Ingrese la cantidad de niños: ");
//            int cantidadHabitaciones = obtenerEntradaValida(scanner, "Ingrese la cantidad de habitaciones: ");
            int fechaInicio = 10;
            int fechaFin = 15;
            int cantidadAdultos = 3;
            int cantidadNinos = 2;
            int cantidadHabitaciones = 2;
            buscarAlojamientos(ciudades.get(opcionCiudad), tipoAlojamientos.get(opcionTipoAlojamiento), fechaInicio, fechaFin, cantidadAdultos, cantidadNinos, cantidadHabitaciones);


            break;

        }
    }

    public static void buscarAlojamientos(String ciudad, String tipoAlojamiento, int fechaInicio, int fechaFin,
                                          int cantidadAdultos, int cantidadNinos, int cantidadHabitaciones) {
        System.out.println(ciudad);
        List<Map<String, Object>> alojamientoCiudad = filtrarPorSeleccion("ciudad", ciudad, alojamientos);
        List<Map<String, Object>> alojamientoPorTipo= filtrarPorSeleccion("tipoAlojamiento", ciudad, alojamientoCiudad);
        

    }

    public static void ciudadesEncontradas() {
        ciudades.clear();
        for (Map<String, Object> alojamiento : alojamientos) {
            if (!ciudades.contains((String) alojamiento.get("ciudad"))) {
                ciudades.add((String) alojamiento.get("ciudad"));
            }
        }
    }

    public static void tiposAlojamientoEncontradas() {
        tipoAlojamientos.clear();
        for (Map<String, Object> alojamiento : alojamientos) {
            if (!tipoAlojamientos.contains((String) alojamiento.get("tipoAlojamiento"))) {
                tipoAlojamientos.add((String) alojamiento.get("tipoAlojamiento"));
            }
        }
    }

    public static List<Map<String, Object>> filtrarPorSeleccion(String claveFiltro, String valorFiltro, List<Map<String, Object>> opciones) {
        List<Map<String, Object>> result = new ArrayList<>();
        for (Map<String, Object> alojamiento : opciones) {
            // Comprobamos si el alojamiento está en la ciudad busqueda
            if (alojamiento.get(claveFiltro).equals(valorFiltro)) {
                result.add(alojamiento);
            }
        }
        return result;
    }

    public static int obtenerEntradaValida(Scanner scanner, int maxOption) {
        int opcion = -1;
        while (true) {
            System.out.print("Ingrese un número entre 1 y " + maxOption + ": ");
            try {
                opcion = scanner.nextInt();
                if (opcion >= 1 && opcion <= maxOption) {
                    return opcion;
                }
                if (opcion == (maxOption + 1)) {
                    System.out.println("close");
                    return -1;
                } else {
                    System.out.println("Opción no válida. Debe estar entre 1 y " + maxOption + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                scanner.next();
            }
        }
    }


    public static int seleccionarOpcion(Scanner scanner, String mensaje, List<String> opciones) {
        mostrarOpciones(mensaje, opciones);
        return obtenerEntradaValida(scanner, opciones.size());
    }

    public static void mostrarOpciones(String mensaje, List<String> opciones) {
        System.out.println(mensaje);
        for (int i = 0; i < opciones.size(); i++) {
            System.out.println((i + 1) + ". " + opciones.get(i));
        }
        System.out.println((opciones.size() + 1) + ". Volver");
    }


    public static int obtenerEntradaValida(Scanner scanner, String mensaje) {
        int opcion;
        while (true) {
            System.out.print(mensaje);
            try {
                opcion = scanner.nextInt();
                if (opcion >= 0) {
                    return opcion;  // Aceptamos solo valores no negativos
                }
                System.out.println("La cantidad no puede ser negativa.");
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                scanner.next(); // Limpiar el buffer
            }
        }
    }
}