//Creador Diego Castillo
//Fecha de Creación: 05/09/2025
//Última Modificación: 07/09/2025
//Clase que representa el juego de memoria
public class JuegoMemoria {
    private Tablero tablero;
    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador jugadorActual;
    private int turno;

    public JuegoMemoria(int filas, int columnas) {
        tablero = new Tablero(filas, columnas);
        jugador1 = new Jugador("Jugador 1");
        jugador2 = new Jugador("Jugador 2");
        jugadorActual = jugador1;
        turno = 1;
    }

    public boolean esMovimientoValido(int fila, int columna) {
        return tablero.esMovimientoValido(fila, columna);
    }

    public boolean procesarTurno(int fila1, int columna1, int fila2, int columna2) {
        // Revelar las dos cartas
        tablero.revelarCarta(fila1, columna1);
        tablero.revelarCarta(fila2, columna2);

        // Mostrar tablero con cartas reveladas
        System.out.println("\n>>> Cartas seleccionadas <<<");
        tablero.mostrarTablero();

        // Verificar si son pareja
        // validar con un if que no sea similar la misma carta y pedir nuevamente que
        // ingrese las coordenadas
        if (fila1 == fila2 && columna1 == columna2) {
            System.out.println("¡Seleccionaste la misma carta!");
            tablero.ocultarCarta(fila1, columna1);

            return false;
        }

        if (tablero.sonPareja(fila1, columna1, fila2, columna2)) {
            // Es pareja
            tablero.marcarPareja(fila1, columna1, fila2, columna2);
            jugadorActual.sumarPunto();
            System.out.println("¡Pareja encontrada! " + jugadorActual.getNombre() + " continúa.");
            return true; // El mismo jugador continúa
        } else {
            // No es pareja
            System.out.println("No hay pareja. Las cartas se ocultarán.");

            // Pausa para que el usuario vea las cartas
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            // Ocultar las cartas
            tablero.ocultarCarta(fila1, columna1);
            tablero.ocultarCarta(fila2, columna2);

            // Cambiar turno
            cambiarTurno();
            return false; // Cambió el turno
        }
    }

    private void cambiarTurno() {
        turno++;
        jugadorActual = (jugadorActual == jugador1) ? jugador2 : jugador1;
    }

    public boolean juegoTerminado() {
        return tablero.juegoTerminado();
    }

    public Jugador getGanador() {
        if (jugador1.getPuntos() > jugador2.getPuntos()) {
            return jugador1;
        } else if (jugador2.getPuntos() > jugador1.getPuntos()) {
            return jugador2;
        }
        return null; // Empate
    }

    public void mostrarTablero() {
        tablero.mostrarTablero();
    }

    public void mostrarEstado() {
        System.out.println("\n=== ESTADO DEL JUEGO ===");
        System.out.println("Turno: " + turno);
        System.out.println(jugador1.toString());
        System.out.println(jugador2.toString());
        System.out.println("Turno actual: " + jugadorActual.getNombre());
        System.out.println("========================");
    }

    // Getters
    public Jugador getJugadorActual() {
        return jugadorActual;
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public int getTurno() {
        return turno;
    }
}