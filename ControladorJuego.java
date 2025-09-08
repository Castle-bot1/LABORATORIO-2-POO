//Creador Diego Castillo
//Fecha de Creación: 05/09/2025
//Última Modificación: 07/09/2025
//Clase que controla el juego
import java.util.Scanner;

public class ControladorJuego {
    private JuegoMemoria modelo;
    private VistaConsola vista;
    private Scanner scanner;
    
    public ControladorJuego() {
        vista = new VistaConsola();
        scanner = new Scanner(System.in);
    }
    
    public void iniciarJuego() {
        vista.mostrarBienvenida();
        
        // Obtener dimensiones del tablero
        int filas = obtenerDimension("filas");
        int columnas = obtenerDimension("columnas");
        
        // Validar que el total sea par
        if ((filas * columnas) % 2 != 0) {
            vista.mostrarError("El total de casillas debe ser par para formar parejas.");
            return;
        }
        
        // Crear el modelo del juego
        modelo = new JuegoMemoria(filas, columnas);
        
        // Ejecutar el bucle principal del juego
        ejecutarJuego();
    }
    
    private int obtenerDimension(String tipo) {
        int dimension;
        do {
            System.out.print("Ingrese el número de " + tipo + " (2-8): ");
            dimension = scanner.nextInt();
            if (dimension < 2 || dimension > 8) {
                vista.mostrarError("El número debe estar entre 2 y 8.");
            }
        } while (dimension < 2 || dimension > 8);
        return dimension;
    }
    
    private void ejecutarJuego() {
        while (!modelo.juegoTerminado()) {
            // Mostrar estado actual
            vista.mostrarTablero(modelo);
            vista.mostrarEstadoJuego(modelo);
            
            // Procesar turno del jugador
            procesarTurnoJugador();
        }
        
        // Mostrar resultado final
        vista.mostrarTablero(modelo);
        vista.mostrarResultadoFinal(modelo);
    }
    
    private void procesarTurnoJugador() {
        Jugador jugadorActual = modelo.getJugadorActual();
        
        // Obtener primera carta
        int[] primeraCarta = obtenerCoordenadas(jugadorActual, true);
        if (primeraCarta == null) return;
        
        // Obtener segunda carta
        int[] segundaCarta = obtenerCoordenadas(jugadorActual, false);
        if (segundaCarta == null) return;
        
        // Procesar el turno
        boolean continuaTurno = modelo.procesarTurno(
            primeraCarta[0], primeraCarta[1], 
            segundaCarta[0], segundaCarta[1]
        );
        
        if (!continuaTurno) {
            vista.limpiarPantalla();
        }
    }
    
    private int[] obtenerCoordenadas(Jugador jugador, boolean esPrimera) {
        if (esPrimera) {
            vista.mostrarTurnoActual(jugador);
        } else {
            vista.pedirSegundaCarta();
        }
        
        int fila = scanner.nextInt() - 1; // Convertir a índice 0
        int columna = scanner.nextInt() - 1; // Convertir a índice 0
        
        // Validar movimiento
        if (!modelo.esMovimientoValido(fila, columna)) {
            vista.mostrarMovimientoInvalido();
            return obtenerCoordenadas(jugador, esPrimera); // Pedir de nuevo
        }
        
        return new int[]{fila, columna};
    }
}