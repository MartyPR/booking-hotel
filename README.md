# Aplicación Booking Hoteles

## Descripción
Esta aplicación permite realizar reservas en hoteles de diversas ciudades turísticas mediante una interfaz basada en consola. Proporciona funcionalidades para buscar hoteles disponibles, confirmar la disponibilidad de habitaciones, realizar reservas y actualizar las reservas existentes.

## Requisitos
- Java 8 o superior.
- Un entorno de desarrollo (IDE) como IntelliJ IDEA, Eclipse o Visual Studio Code (opcional).

## Funcionalidades
### Búsqueda de Hoteles
- Permite buscar hoteles por ciudad, tipo de alojamiento, fechas de hospedaje, cantidad de adultos, niños y habitaciones.
- Muestra el nombre del hotel, su calificación, precio por noche y precio total calculado según los días de estadía y las reglas de incremento/descuento aplicables.

### Confirmar Disponibilidad
- Verifica la disponibilidad de habitaciones en un hotel específico para las fechas dadas.
- Muestra las características y precios de los tipos de habitaciones disponibles.

### Realizar Reservas
- Registra una reserva solicitando los datos personales del cliente y la hora aproximada de llegada.
- Reduce automáticamente la cantidad de habitaciones disponibles al realizar una reserva.

### Actualizar Reservas
- Permite cambiar el tipo de habitación dentro del mismo alojamiento o modificar la reserva para otro alojamiento, autenticando al usuario mediante su correo y fecha de nacimiento.

## Reglas de Precios
- **Incrementos:**
  - +15% si los días de estadía incluyen los últimos 5 días del mes.
  - +10% si los días de estadía incluyen del 10 al 15 del mes.
- **Descuentos:**
  - -8% si los días de estadía incluyen del 5 al 10 del mes.
- El precio total se calcula como:
  ```
  Precio total = (Precio por noche) * (Número de noches) * (Cantidad de habitaciones)
  ```
  Aplicando los descuentos o incrementos correspondientes.

## Instrucciones de Uso
1. Clonar o descargar este repositorio.
2. Compilar y ejecutar el archivo `BookingHoteles.java` desde un entorno de desarrollo o mediante la consola:
   ```bash
   javac BookingHoteles.java
   java BookingHoteles
   ```
3. Seguir las instrucciones en pantalla para interactuar con la aplicación.

## Estructura del Código
El programa utiliza únicamente funciones y estructuras de datos simples, sin Programación Orientada a Objetos (POO), para mantener la lógica sencilla y comprensible:
- **Datos:** Los datos de ejemplo están almacenados en arrays estáticos.
- **Métodos:** Cada funcionalidad principal se implementa como un método independiente:
  - `buscarHoteles`: Busca hoteles que coincidan con los parámetros ingresados.
  - `calcularPrecioTotal`: Calcula el precio total aplicando las reglas de precios.
  - `confirmarDisponibilidad`: Muestra las habitaciones disponibles para un hotel y fechas específicos.
  - `realizarReserva`: Registra una nueva reserva y muestra un mensaje de confirmación.

## Ejemplo de Uso
### Buscar Hoteles
- Entrada:
  ```
  Ciudad: Cartagena
  Tipo de alojamiento: Hotel
  Día de inicio: 10
  Día de finalización: 15
  Adultos: 2
  Niños: 1
  Habitaciones: 1
  ```
- Salida:
  ```
  Hoteles disponibles:
  Nombre: Hotel Caribe, Calificación: 5, Precio por noche: 200000, Precio total: 1100000
  ```

### Confirmar Disponibilidad
- Entrada:
  ```
  Nombre del hotel: Hotel Caribe
  Día de inicio: 10
  Día de finalización: 15
  ```
- Salida:
  ```
  Habitaciones disponibles:
  1. Habitación sencilla: 1 cama, vista al jardín, $100000 por noche
  2. Habitación doble: 2 camas, vista al mar, aire acondicionado, $150000 por noche
  ```

### Realizar Reserva
- Entrada:
  ```
  Nombre: Juan
  Apellido: Pérez
  Email: juan.perez@example.com
  Nacionalidad: Colombiana
  Teléfono: 3001234567
  Hora de llegada: 14:00
  ```
- Salida:
  ```
  Se ha realizado la reserva con éxito.
  ```

## Contribuciones
Si deseas contribuir a este proyecto, puedes realizar un fork del repositorio, implementar tus mejoras y enviar un pull request.

## Licencia
Este proyecto se encuentra bajo la licencia MIT. Puedes usarlo, modificarlo y distribuirlo libremente.

