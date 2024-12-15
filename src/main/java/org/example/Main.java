package org.example;

import java.util.*;

public class Main {

    static String[] nombres = {
            "Hotel Paraíso", "Hotel Real", "Apartamento Luna",
            "Apartamento Sol", "Finca El Encanto", "Finca La Montaña", "Resort Brisa Marina", "Hotel Nube"
    };
    static String[] ciudades = {
            "Cartagena", "Bogotá", "Medellín", "Bogotá",
            "Medellín", "Cartagena", "Medellín", "Bogotá"
    };
    static String[] tipos = {
            "Hotel", "Hotel", "Apartamento", "Apartamento",
            "Finca", "Finca", "Día de Sol", "Hotel"
    };

    static double[] calificaciones = {5.0, 4.2, 4.4, 3, 3.8, 4.0, 3.9, 2.5};
    static int[][] preciosPorNoche = {
            {150000, 200000, 350000}, // Precios para Hotel Paraíso
            {120000, 250000, 500000}, // Precios para Hotel Real
            {300000, 250000},         // Precios para Apartamento Luna
            {200000, 350000},         // Precios para Apartamento Sol
            {300000, 280000},         // Precios para Finca El Encanto
            {400000, 150000},         // Precios para Finca La Montaña
            {120000, 90000},
            {100000, 150000, 230000}// Precios para Hotel Nube
    };
    static String[][][] habitaciones = {
            {
                    {"Sencilla", "1 cama sencilla, TV, baño privado"},
                    {"Doble", "2 camas sencillas, aire acondicionado"},
                    {"Suite", "1 cama king, jacuzzi, balcón"}
            },
            {
                    {"Sencilla", "1 cama sencilla, escritorio, baño privado"},
                    {"Familiar", "3 camas sencillas, aire acondicionado"},
                    {"Suite Presidencial", "1 cama king, jacuzzi, sala de estar"}
            },
            {
                    {"Suite", "1 cama king, cocina equipada, balcón"},
                    {"Familiar", "2 camas dobles, sala comedor, cocina"}
            },
            {
                    {"Estudio", "1 cama queen, cocina, aire acondicionado"},
                    {"Dúplex", "2 camas dobles, sala, balcón con vista al mar"}
            },
            {
                    {"Cabaña", "2 camas dobles, cocina, chimenea"},
                    {"Habitación Campestre", "1 cama king, terraza privada"}
            },
            {
                    {"Cabaña de Lujo", "1 cama king, jacuzzi, chimenea"},
                    {"Habitación Compartida", "4 camas individuales, baño compartido"}
            },
            {
                    {"Piscina", "Deportes acuáticos", "Tour en lancha"},
                    {"Piscina", "Toboganes", "Zona de picnic"}
            },
            {
                    {"Sencilla", "1 cama sencilla, TV, baño privado"},
                    {"Doble", "2 camas sencillas, aire acondicionado"},
                    {"Suite", "1 cama king, jacuzzi, balcón"}
            },

    };


    //index hotel, index habitacion, index
    static int[][] reservacion;

    static boolean[] incluyeAlmuerzo = {false, false, false, false, false, false, true, false, false};

    static int[][] habitacionesDisponibles = {
            {10, 5, 2}, // Disponibilidad inicial para Hotel Paraíso
            {8, 3, 1},  // Disponibilidad inicial para Hotel Real
            {5, 2},     // Disponibilidad inicial para Apartamento Luna
            {6, 3},     // Disponibilidad inicial para Apartamento Sol
            {4, 3},     // Disponibilidad inicial para Finca El Encanto
            {2, 8},     // Disponibilidad inicial para Finca La Montaña
            {10, 10},   // Disponibilidad inicial para Resort Brisa Marina
            {6, 4, 2}   // Disponibilidad inicial para Hotel Nube
    };
    static String[][] reservas = new String[100][6]; // ID, Nombre, Email, Fecha Nacimiento, Hotel ID, Habitación ID
    static int reservasCount = 0;


    static ArrayList<String> ciudadesEncontradas = new ArrayList<>();//guarda las ciudades existentes
    static ArrayList<String> tipoAlojamientos = new ArrayList<>();//guarda los tipos de alojamientos existentes
    static ArrayList<String> alojamientosfiltrados = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ciudadesEncontradas();
        tiposAlojamientoEncontradas();

        int ciudadSeleccionada = -1;
        int tipoAlojamientoSeleccionada = -1;
        int opcionConfirmarAlojamiento = -1;
        int fechaInicio = -1;
        int fechaFin = -1;
        int cantidadAdultos = -1;
        int cantidadNinos = -1;
        int cantidadHabitaciones = -1;
        //usuario
        String nombre = "";
        String apellido = "";
        String email = "";
        String nacionalidad = "";
        int telefono = -1;
        int hora = -1;

        int opcionHabitacion = -1;
        int habitacionSeleccionada = -1;
        ArrayList<Integer> opcionesEncontrada = new ArrayList<Integer>();
        ArrayList<String> opcionesHabitaciones = new ArrayList<String>();

        int step = 1; // Inicio en el paso 1

        while (step >= 1 && step <= 8) {
            switch (step) {
                case 1:
                    ciudadSeleccionada = seleccionarOpcion(scanner, "Seleccione la ciudad donde le gustaría hospedarse", ciudadesEncontradas);
                    System.out.println(ciudadSeleccionada == -1 ? "Ya está en el primer paso. No puede volver más atrás." : "");
                    step = ciudadSeleccionada == -1 ? step : step + 1;
                    break;

                case 2:
                    tipoAlojamientoSeleccionada = seleccionarOpcion(scanner, "Seleccione el tipo de alojamiento donde le gustaría hospedarse", tipoAlojamientos);
                    if (tipoAlojamientoSeleccionada == -1) {
                        step--;
                    } else {
                        step++;
                    }
                    break;
                case 3:
                    System.out.println(opcionesEncontrada);
                    fechaInicio = 1;
                    fechaFin = 5;
                    cantidadAdultos = 3;
                    cantidadNinos = 2;
                    cantidadHabitaciones = 3;
                    step++;

                    break;
                case 4:
                    opcionesEncontrada = buscarAlojamientos(ciudadesEncontradas.get(ciudadSeleccionada), tipoAlojamientos.get(tipoAlojamientoSeleccionada), fechaInicio, fechaFin, cantidadAdultos, cantidadNinos, cantidadHabitaciones);
                    System.out.println(opcionesEncontrada);
                    opcionConfirmarAlojamiento = seleccionarOpcion(scanner, "Seleccione una opción en la que le gustaría hospedarse:", alojamientosfiltrados);
                    if (opcionConfirmarAlojamiento == -1) {
                        step = step - 2;

                    } else {
                        step++;
                    }

                    //opcionesEncontrada.get(opcionConfirmarAlojamiento) -> encontrar index expecifico de alojamiento
                    break;
                case 5:
                    confirmarHabitaciones(nombres[opcionesEncontrada.get(opcionConfirmarAlojamiento)], fechaInicio, fechaFin, cantidadAdultos, cantidadNinos, cantidadHabitaciones, opcionesEncontrada.get(opcionConfirmarAlojamiento));
                    System.out.println("--------------------------------------------------------------\n");
                    opcionesHabitaciones.clear();
                    for (int i = 0; i < habitaciones[opcionesEncontrada.get(opcionConfirmarAlojamiento)].length; i++) {
                        opcionesHabitaciones.add(habitaciones[opcionesEncontrada.get(opcionConfirmarAlojamiento)][i][0]);
                    }
                    habitacionSeleccionada = seleccionarOpcion(scanner, "Seleccionar el tipo de habitacion que desea", opcionesHabitaciones);
                    if (habitacionSeleccionada == -1) {
                        step--;
                    } else {
                        step++;
                    }
                    break;
                case 6:
                    System.out.println("__________________________________________________________________");
                    System.out.println("Proceso a seguir:");
                    System.out.println("1. Hacer Reservacion");
                    System.out.println("2. volver atras");
                    System.out.println("3. volver a consultar alojamiento");
                    System.out.println("4. volver a menu inicial");

                    int opcionMenuReservaSelecccionada = scanner.nextInt();
                    if (opcionMenuReservaSelecccionada == 1) {
                        step++;
                    } else if (opcionMenuReservaSelecccionada == 2) {
                        step--;
                    } else if (opcionMenuReservaSelecccionada == 3) {
                        step = step - 5;
                    } else if (opcionMenuReservaSelecccionada == 4) {
                        step = step - 5;
                    }
                    break;
                case 7:
//                    nombre = obtenerEntradaValidaTexto(scanner, "Escriba su nombre: ");
//                    apellido = obtenerEntradaValidaTexto(scanner, "Escriba su apellido: ");
//                    nacionalidad = obtenerEntradaValidaTexto(scanner, "Escriba su Nacionalidad: ");
//                    email = obtenerEntradaValidaTexto(scanner, "Escriba su email: ");
//                    telefono = obtenerEntradaValida(scanner, "Escriba su telefono: ");
//                    hora = obtenerEntradaValida(scanner, "Escriba la hora de llegada: ");
                    nombre = "Martin";
                    apellido = "Par";
                    nacionalidad = "CO";
                    email = "@gmail";
                    telefono = 123456789;
                    hora = 12;
                    if (hora >= 0 && hora <= 24) {
                        step++;
                    } else {
                        System.out.println("algun dato esta mal, reescriba nuevamente los datos");
                    }
                    break;
                case 8:
                    boolean confirmacionReservaAlojamiento = reservarAlojamiento(opcionesEncontrada.get(opcionConfirmarAlojamiento), habitacionSeleccionada, cantidadHabitaciones, nombre, apellido, email, nacionalidad, telefono, hora);
                    if (confirmacionReservaAlojamiento) {
                        step++;
                    } else {
                        System.out.println("Lo sentimos mucho, no puedes pedir mas habitaciones de las que hay");
                        step = 2;
                    }
                    break;
                case 9:
                    System.out.println("__________________________________________________________________");
                    System.out.println("Proceso a seguir:");
                    System.out.println("1. Confirmar");
                    System.out.println("2. Atras");
                    int opcionReserva = scanner.nextInt();
                    if (opcionReserva == 1) {
                        agregarReserva(in);
                        step++;
                    } else if (opcionReserva == 2) {
                        step--;
                    }else{
                        System.out.println("Lo sentimos mucho, esa opcion no es valida");
                    }

                    break;
            }


////            int fechaInicio  = obtenerEntradaValida(scanner, "Ingrese  el día de inicio del hospedaje: ");
////            int fechaFin  = obtenerEntradaValida(scanner, "Ingrese el día de finalización del hospedaje: ");
////            int cantidadAdultos = obtenerEntradaValida(scanner, "Ingrese la cantidad de adultos: ");
////            int cantidadNinos = obtenerEntradaValida(scanner, "Ingrese la cantidad de niños: ");
////            int cantidadHabitaciones = obtenerEntradaValida(scanner, "Ingrese la cantidad de habitaciones: ");
        }
    }

    public static ArrayList<Integer> buscarAlojamientos(String ciudad, String tipoAlojamiento, int fechaInicio, int fechaFin,
                                                        int cantidadAdultos, int cantidadNinos, int cantidadHabitaciones) {
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("Consulta Realizada:");
        List<Integer> alojamientoCiudad = filtrarPorSeleccion(ciudad, ciudades);
        ArrayList<Integer> alojamientoFiltradosIndex = new ArrayList<>();
        alojamientosfiltrados.clear();
        int contador = 0;
        for (int indexCiudad : alojamientoCiudad) {
            if (tipos[indexCiudad] == tipoAlojamiento) {
                System.out.println("/................../");
                System.out.println("Ciudad: " + ciudad + "\n" + "\n" + "Nombre:" + nombres[indexCiudad] + "\n" + calificaciones[indexCiudad] + "⭐");
                alojamientoFiltradosIndex.add(indexCiudad);
                alojamientosfiltrados.add(nombres[indexCiudad]);
                if (tipos[indexCiudad] == "Día de Sol") {
                    mostrarHabitacionesActividades(indexCiudad, tipoAlojamiento, fechaInicio, fechaFin, cantidadHabitaciones, indexCiudad);
                } else {
                    double precio = calcularPrecio(fechaInicio, fechaFin, cantidadHabitaciones, preciosPorNoche[indexCiudad][0]);
                }
            }
            contador++;
        }
        System.out.println(alojamientoFiltradosIndex);
        return alojamientoFiltradosIndex;


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

    public static double calcularPrecio(int diaInicio, int diaFin, int cantidadHabitaciones, double precioHabitacion) {

        int noches = diaFin - diaInicio + 1;
        double precioTotal = precioHabitacion * noches * cantidadHabitaciones;

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

    public static void mostrarHabitacionesActividades(int indexAlojamiento, String tipoAlojamiento, int fechaInicio, int fechaFin, int cantidadHabitaciones, int indexCiudad) {
        int contadorTipo = 0;
        int contadorActividad = 1;
        for (String[] habitacionesHotel : habitaciones[indexAlojamiento]) {
            System.out.println(tipoAlojamiento == "Día de Sol" ?
                    "Tipo " + contadorTipo + ":" + "\n" + "Actividad(es)" : (contadorTipo + 1) + ". " + habitaciones[indexAlojamiento][contadorTipo][0]);

            if (tipoAlojamiento == "Día de Sol") {
                for (String actividad : habitaciones[indexAlojamiento][contadorTipo]) {
                    System.out.println(contadorActividad + ". " + actividad);
                    contadorActividad++;
                }
                System.out.println("Precio:" + preciosPorNoche[indexAlojamiento][contadorTipo]);
            } else {
                System.out.println("Description: " + habitaciones[indexAlojamiento][contadorTipo][1]);
                double precio = calcularPrecio(fechaInicio, fechaFin, cantidadHabitaciones, preciosPorNoche[indexAlojamiento][contadorTipo]);
            }
            contadorTipo++;

        }
    }

    public static void confirmarHabitaciones(String nombreHotel, int diaInicio, int diaFin, int cantidadAdultos, int cantidadNinos, int cantidadHabitaciones, int indexAlojamiento) {
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("Alojamiento seleccionado: " + nombreHotel);
        mostrarHabitacionesActividades(indexAlojamiento, tipos[indexAlojamiento], diaInicio, diaFin, cantidadHabitaciones, indexAlojamiento);
        System.out.println("_____________________>");
        System.out.println("Disponibilidad de habitaciones:");
        for (int i = 0; i < habitacionesDisponibles[indexAlojamiento].length; i++) {
            if (habitacionesDisponibles[indexAlojamiento][i] > cantidadHabitaciones) {
                System.out.println(habitaciones[indexAlojamiento][i][0] + ": "
                        + habitacionesDisponibles[indexAlojamiento][i] + " disponibles");
            }else {
                System.out.println(habitaciones[indexAlojamiento][i][0] + ": "
                        + habitacionesDisponibles[indexAlojamiento][i] + " disponibles (No Alcanzan las habitaciones disponibles)");
            }
        }

    }

    public static boolean reservarAlojamiento(int indexAlojamiento, int habitacionSeleccionada, int cantidadHabitaciones, String nombre, String apellido, String email, String nacionalidad, int telefono, int horaLlegada) {
        if (habitacionesDisponibles[indexAlojamiento][habitacionSeleccionada] >= cantidadHabitaciones) {
            // Restar las habitaciones reservadas
            habitacionesDisponibles[indexAlojamiento][habitacionSeleccionada] -= cantidadHabitaciones;

            // Confirmación de la reserva
            System.out.println("-----------------------------------------------------");
            System.out.println("¡Reserva realizada con éxito!");
            System.out.println("Datos de la reserva:");
            System.out.println("Nombre: " + nombre + " " + apellido);
            System.out.println("Email: " + email);
            System.out.println("Nacionalidad: " + nacionalidad);
            System.out.println("Teléfono: " + telefono);
            System.out.println("Hora de llegada: " + horaLlegada + ":00");
            System.out.println("Hotel: " + nombres[indexAlojamiento]);
            System.out.println("Habitación: " + habitaciones[indexAlojamiento][habitacionSeleccionada][0]);
            System.out.println("Cantidad de habitaciones reservadas: " + cantidadHabitaciones);
            System.out.println("-----------------------------------------------------");
            return true;
        } else {
            // Mensaje de error si no hay suficientes habitaciones
            System.out.println("-----------------------------------------------------");
            System.out.println("Lo sentimos, no hay suficientes habitaciones disponibles.");
            System.out.println("Habitaciones disponibles para este tipo: "
                    + habitacionesDisponibles[indexAlojamiento][habitacionSeleccionada]);
            System.out.println("-----------------------------------------------------");
            return false;
        }
    }

    public static void agregarReserva(String nombre, String email, String fechaNacimiento, int hotelID, int habitacionID) {
        reservas[reservasCount][0] = String.valueOf(reservasCount); // ID de reserva
        reservas[reservasCount][1] = nombre;
        reservas[reservasCount][2] = email;
        reservas[reservasCount][3] = fechaNacimiento;
        reservas[reservasCount][4] = String.valueOf(hotelID);
        reservas[reservasCount][5] = String.valueOf(habitacionID);
        reservasCount++;
        System.out.println("Reserva creada con éxito. ID de reserva: " + (reservasCount - 1));
    }

    //funciones para validar y mostrar menus
    public static int obtenerEntradaValida(Scanner scanner, int maxOption) {
        int opcion = -1;
        while (true) {
            System.out.print("Ingrese un número" + ": ");
            try {
                opcion = scanner.nextInt();
                if (opcion >= 1 && opcion <= maxOption) {
                    return opcion - 1;
                }
                if (opcion == (maxOption + 1)) {
                    System.out.println("close");
                    return -1;
                } else {
                    System.out.println("Opción no válida. Debe estar entre 1 y " + (maxOption + 1) + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                scanner.next();
            }
        }
    }

    public static int seleccionarOpcion(Scanner scanner, String mensaje, ArrayList<String> opciones) {
        mostrarOpciones(mensaje, opciones);
        return obtenerEntradaValida(scanner, opciones.size());
    }

    public static void mostrarOpciones(String mensaje, ArrayList<String> opciones) {
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

    public static String obtenerEntradaValidaTexto(Scanner scanner, String mensaje) {
        String opcion;
        while (true) {
            System.out.print(mensaje);
            try {
                opcion = scanner.nextLine();
                if (opcion != "") {
                    return opcion;  // Aceptamos solo valores no negativos
                }
                System.out.println(opcion);
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un texto.");
                scanner.next(); // Limpiar el buffer
            }
        }
    }
}