//Creador Diego Castillo
//Fecha de Creación: 05/09/2025
//Última Modificación: 07/09/2025
//Clase que maneja la vista en consola
public class VistaConsola {
    
    public void mostrarBienvenida() {
        System.out.println("=================================================");
        System.out.println("          JUEGO DE MEMORIA");
        System.out.println("==================================================");
        System.out.println("Dos jugadores se turnan para encontrar parejas");
        System.out.println("Ingrese coordenadas como: fila columna");
        System.out.println("Ejemplo: 2 3 (fila 2, columna 3)");
        System.out.println("=================================================================");
    }
    
    public void mostrarTablero(JuegoMemoria juego) {
        System.out.println("\n--- TABLERO ACTUAL ---");
        juego.mostrarTablero();
        System.out.println("----------------------");
    }
    
    public void mostrarEstadoJuego(JuegoMemoria juego) {
        juego.mostrarEstado();
    }
    
    public void mostrarTurnoActual(Jugador jugador) {
        System.out.println("\nTurno de: " + jugador.getNombre());
        System.out.print("Seleccione la primera carta (fila columna): ");
    }
    
    public void pedirSegundaCarta() {
        System.out.print("Seleccione la segunda carta (fila columna): ");
    }
    
    public void mostrarMovimientoInvalido() {
        System.out.println("Movimiento inválido. La carta ya está revelada o las coordenadas son incorrectas.");
    }
    
    public void mostrarResultadoFinal(JuegoMemoria juego) {
        System.out.println("\n===========================================");
        System.out.println("           ¡JUEGO TERMINADO!");
        System.out.println("===========================================");
        System.out.println("Puntuación final:");
        System.out.println(juego.getJugador1().toString());
        System.out.println(juego.getJugador2().toString());
        
        Jugador ganador = juego.getGanador();
        if (ganador != null) {
            System.out.println("\n¡" + ganador.getNombre() + " es el ganador!");
        } else {
            System.out.println("\n ¡Es un empate! ");
        }
        System.out.println("===========================================");
    }
    
    public void mostrarError(String mensaje) {
        System.out.println("ERROR: " + mensaje);
    }
    
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
    
    public void limpiarPantalla() {
        // Añadir líneas en blanco para separar turnos
        for (int i = 0; i < 5; i++) {
            System.out.println();
        }
        System.out.println("=====================================");
    }
    
    public void esperarEnter() {
        System.out.println("Presione Enter para continuar...");
        try {
            System.in.read();
        } catch (Exception e) {
            // Ignorar excepción
        }
    }
}