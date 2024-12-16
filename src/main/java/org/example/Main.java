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
            {150000, 200000, 350000, 250000, 320000}, // Precios para Hotel Paraíso
            {120000, 250000, 500000}, // Precios para Real
            {300000, 250000},         // Precios para Apartamento Luna
            {200000, 350000},         // Precios para Apartamento Sol
            {300000, 280000},         // Precios para Finca El Encanto
            {400000, 150000},         // Precios para Finca La Montaña
            {120000, 90000},
            {100000, 150000, 230000}// Precios para Nube
    };
    static String[][][] habitaciones = {
            {
                    {"Sencilla", "1 cama sencilla, TV, baño privado"},
                    {"Lujo", "2 cama sencilla, TV, baño privado"},
                    {"Doble", "2 camas sencillas, aire acondicionado"},
                    {"Triple", "2 camas sencillas, aire acondicionado"},
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
                    {"Tipo 1 : Piscina", "Deportes acuáticos", "Tour en lancha"},
                    {"Tipo 2 : Picnic", " Piscina/Toboganes", "Zona de picnic"}
            },
            {
                    {"Sencilla", "1 cama sencilla, TV, baño privado"},
                    {"Doble", "2 camas sencillas, aire acondicionado"},
                    {"Suite", "1 cama king, jacuzzi, balcón"}
            },

    };

    static boolean[] incluyeAlmuerzo = {false, false, false, false, false, false, true, false, false};

    static int[][] habitacionesDisponibles = {
            {10, 5, 2, 2, 2}, // Disponibilidad inicial para Hotel Paraíso
            {8, 3, 1},  // Disponibilidad inicial para Hotel Real
            {5, 2},     // Disponibilidad inicial para Apartamento Luna
            {6, 3},     // Disponibilidad inicial para Apartamento Sol
            {4, 3},     // Disponibilidad inicial para Finca El Encanto
            {5, 8},     // Disponibilidad inicial para Finca La Montaña
            {10, 10},   // Disponibilidad inicial para Resort Brisa Marina
            {6, 4, 2}   // Disponibilidad inicial para Hotel Nube
    };
    static int[][] personasHabitacion = {
            {4, 6, 5, 4, 4}, // Disponibilidad  de personas para Hotel Paraíso
            {3, 5, 4},  // Disponibilidad de personas para Hotel Real
            {3, 5},     // Disponibilidad de personas para Apartamento Luna
            {3, 4},     // Disponibilidad de personas para Apartamento Sol
            {4, 3},     // Disponibilidad de personas para Finca El Encanto
            {3, 6},     // Disponibilidad de personas para Finca La Montaña
            {10, 10},   // Disponibilidad de personas para Resort Brisa Marina
            {3, 4, 3}   // Disponibilidad de personas para Hotel Nube
    };

    static String[][] reservas = new String[100][6]; // ID, Nombre, Email, Fecha Nacimiento, Hotel ID, Habitación ID
    static int[][] habitaciondisponibilidadDia = new int[100][5]; //Id, idHotel,Habitacion ID, diaInicio,diaFinal, nuevoValorHabitacion
    static int reservasCount = 0;
    static int disponibilidadCount = 0;


    static ArrayList<String> ciudadesEncontradas = new ArrayList<>();//guarda las ciudades existentes
    static ArrayList<String> tipoAlojamientos = new ArrayList<>();//guarda los tipos de alojamientos existentes
    static ArrayList<String> alojamientosfiltrados = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ciudadesEncontradas();
        tiposAlojamientoEncontradas();
        int menuSeleccionada = -1;
        int ciudadSeleccionada = -1;
        int tipoAlojamientoSeleccionada = -1;
        int opcionConfirmarAlojamiento = -1;
        int fechaInicio = -1;
        int fechaFin = -1;
        int cantidadAdultos = -1;
        int cantidadNinos = -1;
        int cantidadHabitaciones = -1;
        String fechaNacimiento = "";
        //usuario
        String nombre = "";
        String apellido = "";
        String email = "";
        String nacionalidad = "";
        int telefono = -1;
        int hora = -1;
        int habitacionSeleccionada = -1;
        ArrayList<Integer> opcionesEncontrada = new ArrayList<Integer>();
        ArrayList<String> opcionesHabitaciones = new ArrayList<String>();

        int step = 0; // Inicio en el paso 1

        while (step >= 0 && step <= 12) {
            switch (step) {
                case 0:
                    menuSeleccionada = seleccionarOpcionMenu(scanner, "___Bienvenido a Booking Hotel___", new String[]{"Consultar y reservar", "Autenticar y Actualizar"});
                    step = (menuSeleccionada == 0) ? 1 : (menuSeleccionada == 1 ? 11 : 0);

                    break;
                case 1:
                    ciudadSeleccionada = seleccionarOpcion(scanner, "___Seleccione la ciudad donde le gustaría hospedarse___", ciudadesEncontradas);
                    step = validarSeleccion(ciudadSeleccionada, step);
                    break;

                case 2:
                    tipoAlojamientoSeleccionada = seleccionarOpcion(scanner, "___Seleccione el tipo de alojamiento donde le gustaría hospedarse___", tipoAlojamientos);
                    step = validarSeleccion(tipoAlojamientoSeleccionada, step);
                    break;
                case 3:
                    fechaInicio = obtenerEntradaValida(scanner, "Ingrese  el día de inicio del hospedaje: ");
                    fechaFin = obtenerEntradaValida(scanner, "Ingrese el día de finalización del hospedaje: ");
                    cantidadAdultos = obtenerEntradaValida(scanner, "Ingrese la cantidad de adultos: ");
                    cantidadNinos = obtenerEntradaValida(scanner, "Ingrese la cantidad de niños: ");
                    cantidadHabitaciones = obtenerEntradaValida(scanner, "Ingrese la cantidad de habitaciones: ");
                    if (fechaInicio >= fechaFin) {
                        System.out.println("Has ingresado fechas incorrectas");
                    } else {
                        step++;
                    }

//                    System.out.println(opcionesEncontrada);
//                    fechaInicio = 1;
//                    fechaFin = 5;
//                    cantidadAdultos = 2;
//                    cantidadNinos = 1;
//                    cantidadHabitaciones = 3;
//                    step++;

                    break;
                case 4:

                    opcionesEncontrada = buscarAlojamientos(ciudadesEncontradas.get(ciudadSeleccionada), tipoAlojamientos.get(tipoAlojamientoSeleccionada), fechaInicio, fechaFin, cantidadAdultos, cantidadNinos, cantidadHabitaciones);
                    System.out.println(opcionesEncontrada);
                    opcionConfirmarAlojamiento = seleccionarOpcion(scanner, "___Seleccione una opción en la que le gustaría hospedarse:____", alojamientosfiltrados);
                    step = (opcionConfirmarAlojamiento == -1) ? 2 : 5;

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
                    step = (habitacionSeleccionada == -1) ? 4 : 6;
                case 6:
                    System.out.println("__________________________________________________________________");
                    int opcionMenuReserva = seleccionarOpcionMenu(scanner, "Proceso a seguir:", new String[]{"Hacer Reservacion", "Volver Atras", "volver a consultar alojamiento", "volver a menu inicial"});
                    if (opcionMenuReserva == 0) step++;
                    else if (opcionMenuReserva == 1) step--;
                    else if (opcionMenuReserva == 2) step = 1;
                    else if (opcionMenuReserva == 3) step = 0;
                    break;
                case 7:
                    nombre = obtenerEntradaValidaTexto(scanner, "Escriba su nombre: ");
                    apellido = obtenerEntradaValidaTexto(scanner, "Escriba su apellido: ");
                    fechaNacimiento = obtenerEntradaValidaTexto(scanner, "Escriba su Fecha de Nacimiento dd/MM/yyyy : ");
                    nacionalidad = obtenerEntradaValidaTexto(scanner, "Escriba su Nacionalidad: ");
                    email = obtenerEntradaValidaTexto(scanner, "Escriba su email: ");
                    telefono = obtenerEntradaValida(scanner, "Escriba su telefono: ");
                    hora = obtenerEntradaValida(scanner, "Escriba la hora de llegada: ");
//                    nombre = "Martin";
//                    apellido = "Par";
//                    fechaNacimiento = "123";
//                    nacionalidad = "CO";
//                    email = "@gmail";
//                    telefono = 123456789;
//                    hora = 12;
                    if (hora >= 0 && hora <= 24) {
                        step++;
                    } else {
                        System.out.println("algun dato esta mal, reescriba nuevamente los datos");
                    }
                    break;
                case 8:
                    boolean confirmacionReservaAlojamiento = reservarAlojamiento(opcionesEncontrada.get(opcionConfirmarAlojamiento), habitacionSeleccionada, cantidadHabitaciones, nombre, apellido, email, nacionalidad, telefono, hora, fechaInicio, fechaFin, cantidadAdultos, cantidadNinos);
                    step = confirmacionReservaAlojamiento ? 9 : 2;
                    break;
                case 9:
                    System.out.println("__________________________________________________________________");

                    int confirmarReserva = seleccionarOpcionMenu(scanner, "Proceso a Seguir:", new String[]{"Confirmar", "Atras"});
                    if (confirmarReserva == 0) {
                        agregarReserva(nombre, email, fechaNacimiento, opcionesEncontrada.get(opcionConfirmarAlojamiento), habitacionSeleccionada);
                        step++;
                    } else step--;

                    break;
                case 10:
                    System.out.println("Muchas Gracias Por reservar con nosotros!!!!");
                    step = 0;
                    break;
                case 11:

                    int opcionMenuAutenticar = seleccionarOpcionMenu(scanner, "Menu para autenticar y Actualizar:", new String[]{"Autenticar", "Atras al Menu Inicial"});
                    if (opcionMenuAutenticar == 0) autenticarYActualizarReserva(scanner);
                    step = 0;

                    break;
            }

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
                    System.out.println(incluyeAlmuerzo[indexCiudad] ? "Almuerzo: Si" : "Almuerzo: No");
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
                System.out.println("Max Personas: " + personasHabitacion[indexAlojamiento][contadorTipo]);
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
        for (int i = 0; i < habitaciondisponibilidadDia.length; i++) {
            if (habitaciondisponibilidadDia[i][1] == indexAlojamiento && habitaciondisponibilidadDia[i][4] == diaInicio && habitaciondisponibilidadDia[i][5] == diaFin) {
                System.out.println(habitaciones[indexAlojamiento][i][0] + ": "
                        + habitaciondisponibilidadDia[i][1] + " disponibles");
            }
        }
        for (int i = 0; i < habitacionesDisponibles[indexAlojamiento].length; i++) {

            if (habitacionesDisponibles[indexAlojamiento][i] > cantidadHabitaciones) {

                System.out.println(habitaciones[indexAlojamiento][i][0] + ": "
                        + habitacionesDisponibles[indexAlojamiento][i] + " disponibles");
            } else {
                System.out.println(habitaciones[indexAlojamiento][i][0] + ": "
                        + habitacionesDisponibles[indexAlojamiento][i] + " disponibles (No Alcanzan las habitaciones disponibles)");
            }


        }

    }

    public static boolean reservarAlojamiento(int indexAlojamiento, int habitacionSeleccionada, int cantidadHabitaciones, String nombre, String apellido, String email, String nacionalidad, int telefono, int horaLlegada, int diaInicio, int diaFin, int adultos, int ninos) {
        if (personasHabitacion[indexAlojamiento][habitacionSeleccionada] * cantidadHabitaciones >= (adultos + ninos)) {
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
        } else {
            System.out.println("Limite de Personas por habitacion superado");
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
        disponibilidadCount++;
        System.out.println("Reserva creada con éxito. ID de reserva: " + (reservasCount - 1));
    }

    public static void autenticarYActualizarReserva(Scanner scanner) {
        System.out.println("Ingrese su correo electrónico:");
        String email = scanner.next();
        System.out.println("Ingrese su fecha de nacimiento (dd/mm/yyyy):");
        String fechaNacimiento = scanner.next();

        int reservaIndex = -1;

        for (int i = 0; i < reservasCount; i++) {
            if (reservas[i][2].equals(email) && reservas[i][3].equals(fechaNacimiento)) {
                reservaIndex = i;
                break;
            }
        }

        if (reservaIndex == -1) {
            System.out.println("Reserva no encontrada o credenciales incorrectas.");
            return;
        }

        System.out.println("Reserva encontrada:");
        System.out.println("Nombre: " + reservas[reservaIndex][1]);
        System.out.println("Hotel: " + nombres[Integer.parseInt(reservas[reservaIndex][4])]);
        System.out.println("Habitación: " + habitaciones[Integer.parseInt(reservas[reservaIndex][4])]
                [Integer.parseInt(reservas[reservaIndex][5])][0]);


        System.out.println("Seleccione la opción que desea realizar:");
        System.out.println("1. Cambiar de habitación");
        System.out.println("2. Cambiar de alojamiento");
        int opcion = scanner.nextInt();

        if (opcion == 1) {
            cambiarHabitacion(scanner, reservaIndex);
        } else if (opcion == 2) {
            cambiarAlojamiento(scanner, reservaIndex);
        } else {
            System.out.println("Opción no válida.");
        }
    }

    public static void cambiarHabitacion(Scanner scanner, int reservaIndex) {
        int hotelID = Integer.parseInt(reservas[reservaIndex][4]);
        System.out.println("Habitaciones disponibles en " + nombres[hotelID] + ":");

        for (int i = 0; i < habitaciones[hotelID].length; i++) {
            if (habitacionesDisponibles[hotelID][i] > 0) {
                System.out.println(i + ". " + habitaciones[hotelID][i][0] + " - " + habitaciones[hotelID][i][1]);
            }
        }

        System.out.println("Seleccione la nueva habitación:");
        int nuevaHabitacion = scanner.nextInt();

        if (habitacionesDisponibles[hotelID][nuevaHabitacion] > 0) {
            habitacionesDisponibles[hotelID][nuevaHabitacion]--;
            int habitacionAnterior = Integer.parseInt(reservas[reservaIndex][5]);
            habitacionesDisponibles[hotelID][habitacionAnterior]++;
            reservas[reservaIndex][5] = String.valueOf(nuevaHabitacion);
            System.out.println("Cambio de habitación realizado con éxito.");
        } else {
            System.out.println("Habitación no disponible.");
        }
    }

    public static void cambiarAlojamiento(Scanner scanner, int reservaIndex) {
        int hotelID = Integer.parseInt(reservas[reservaIndex][4]);
        int habitacionID = Integer.parseInt(reservas[reservaIndex][5]);
        habitacionesDisponibles[hotelID][habitacionID]++;

        System.out.println("La reserva ha sido cancelada. Por favor, cree una nueva reserva.");
        reservas[reservaIndex][0] = null; // Marca como eliminada
        main(new String[]{}); // Reinicia el proceso desde el principio
    }

    private static int validarSeleccion(int seleccion, int pasoActual) {
        return (seleccion == -1) ? pasoActual - 1 : pasoActual + 1;
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

    public static int seleccionarOpcionMenu(Scanner scanner, String mensaje, String[] opciones) {
        mostrarOpcionesMenu(mensaje, opciones);
        return obtenerEntradaValida(scanner, opciones.length);
    }

    public static void mostrarOpciones(String mensaje, ArrayList<String> opciones) {
        System.out.println(mensaje);
        for (int i = 0; i < opciones.size(); i++) {
            System.out.println((i + 1) + ". " + opciones.get(i));
        }
        System.out.println((opciones.size() + 1) + ". Volver");
    }

    public static void mostrarOpcionesMenu(String mensaje, String[] opciones) {
        System.out.println(mensaje);
        for (int i = 0; i < opciones.length; i++) {
            System.out.println((i + 1) + ". " + opciones[i]);
        }
        System.out.println((opciones.length + 1) + ". Volver");
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

    public static int obtenerSeleccionMenu(Scanner scanner, String mensaje, int opciones, String[] mensajeOpciones) {
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