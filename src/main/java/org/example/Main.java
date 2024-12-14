package org.example;

import java.util.*;

public class Main {
    static String[] nombres = {
            "Hotel Paraíso", "Hotel Real", "Apartamento Luna",
            "Apartamento Sol", "Finca El Encanto", "Finca La Montaña", "Resort Brisa Marina"
    };
    static String[] ciudades = {
            "Cartagena", "Bogotá", "Medellín", "Bogotá",
            "Cartagena", "Medellín", "Cartagena"
    };
    static String[] tipos = {
            "Hotel", "Hotel", "Apartamento", "Apartamento",
            "Finca", "Finca", "Día de Sol"
    };
    static double[] calificaciones = {5.0, 4.2, 4.4, 3, 3.8, 4.0};
    static int[][] preciosPorNoche = {{20, 20}, {180000}, {150000}, {180000}, {250000}, {220000}};
//    static String [][] habitaciones={{}};


    static ArrayList<String> ciudadesEncontradas = new ArrayList<>();
    static ArrayList<String> tipoAlojamientos = new ArrayList<>();


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ciudadesEncontradas();
        tiposAlojamientoEncontradas();

        while (true) {

            int opcionCiudad = seleccionarOpcion(scanner, "Seleccione la ciudad donde le gustaria hospedarse", ciudadesEncontradas);
            if (opcionCiudad == -1) continue;

            int opcionTipoAlojamiento = seleccionarOpcion(scanner, "Seleccione la tipo de alojamiento donde le gustaria hospedarse", tipoAlojamientos);
            if (opcionTipoAlojamiento == -1) continue;
//
////            int fechaInicio  = obtenerEntradaValida(scanner, "Ingrese  el día de inicio del hospedaje: ");
////            int fechaFin  = obtenerEntradaValida(scanner, "Ingrese el día de finalización del hospedaje: ");
////            int cantidadAdultos = obtenerEntradaValida(scanner, "Ingrese la cantidad de adultos: ");
////            int cantidadNinos = obtenerEntradaValida(scanner, "Ingrese la cantidad de niños: ");
////            int cantidadHabitaciones = obtenerEntradaValida(scanner, "Ingrese la cantidad de habitaciones: ");
            int fechaInicio = 1;
            int fechaFin = 5;
            int cantidadAdultos = 3;
            int cantidadNinos = 2;
            int cantidadHabitaciones = 2;
            buscarAlojamientos(ciudadesEncontradas.get(opcionCiudad), tipoAlojamientos.get(opcionTipoAlojamiento), fechaInicio, fechaFin, cantidadAdultos, cantidadNinos, cantidadHabitaciones);


            break;
//
        }
    }

    public static void buscarAlojamientos(String ciudad, String tipoAlojamiento, int fechaInicio, int fechaFin,
                                          int cantidadAdultos, int cantidadNinos, int cantidadHabitaciones) {
        System.out.println("-------------------------------------------------------------------------------------");
        List<Integer> alojamientoCiudad = filtrarPorSeleccion(ciudad, ciudades);
        for (int indexCiudad : alojamientoCiudad) {
            if (tipos[indexCiudad] == tipoAlojamiento) {
                System.out.println("Ciudad: " + ciudad + "\n" + "Tipo: " + tipos[indexCiudad] + "\n" + "Nombre:" + nombres[indexCiudad] + "\n" + calificaciones[indexCiudad] + "⭐");
            }
        }
        double precio = calcularprecio(fechaInicio, fechaFin, cantidadHabitaciones);


    }

    public static void ciudadesEncontradas() {
        ciudadesEncontradas.clear();
        for (String ciudad : ciudades) {
            if (!ciudadesEncontradas.contains((String) ciudad)) {
                ciudadesEncontradas.add((String) ciudad);

            }
        }
    }

    public static void tiposAlojamientoEncontradas() {
        tipoAlojamientos.clear();
        for (String tipoAlojamiendo : tipos) {
            if (!tipoAlojamientos.contains((String) tipoAlojamiendo)) {
                tipoAlojamientos.add((String) tipoAlojamiendo);

            }
        }
    }

    public static List<Integer> filtrarPorSeleccion(String valorFiltro, String[] opciones) {
        List<Integer> resultadoFiltro = new ArrayList<>();
        int contador = 0;
        for (String alojamiento : opciones) {
            // Comprobamos si el alojamiento está en la ciudad busqueda
            if (alojamiento == valorFiltro) {
                resultadoFiltro.add(contador);
            }
            contador++;
        }
        return resultadoFiltro;
    }

    public static double calcularprecio(int diaInicio, int diaFin, int cantidadHabitaciones) {
        // Calcular el número de noches de estadía
        int noches = diaFin - diaInicio + 1;
//        Habitacion habitacion = habitaciones.get(0);  // Tomamos la habitación más simple (la primera)
        double precioTotal = 200000 * noches * cantidadHabitaciones;

        // Aplicar aumento o descuento según las fechas
        double aumentoDesc = 0.0;
        if (diaFin >= 25) {  // Los últimos 5 días del mes
            aumentoDesc = 0.15;  // Aumento del 15%
        } else if (diaInicio >= 10 && diaFin <= 15) {
            aumentoDesc = 0.10;  // Aumento del 10%
        } else if (diaInicio >= 5 && diaFin <= 10) {
            aumentoDesc = -0.08;  // Descuento del 8%
        }
        double precioFinal = precioTotal * (1 + aumentoDesc);
        System.out.println("Precio total: $" + precioTotal);
        System.out.println("Aumento/Descuento aplicado: " + (aumentoDesc * 100) + "%");
        System.out.println("Precio final: $" + precioFinal);
        return precioFinal;
    }

    public static int obtenerEntradaValida(Scanner scanner, int maxOption) {
        int opcion = -1;
        while (true) {
            System.out.print("Ingrese un número entre 1 y " + maxOption + ": ");
            try {
                opcion = scanner.nextInt();
                if (opcion >= 1 && opcion <= maxOption) {
                    return opcion - 1;
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