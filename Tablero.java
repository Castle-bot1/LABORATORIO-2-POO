//Creador Diego Castillo
//Fecha de Creación: 05/09/2025
//Última Modificación: 07/09/2025
//Clase que representa el tablero del juego de memoria
import java.util.*;

public class Tablero {
    private Carta[][] cartas;
    private int filas;
    private int columnas;
    private String[] emojis = {" 🔴 ", " 🔵 ", " 🟡 ", " 🟢 ", " 🟠", "🟣 ", "⚫ ", " ⚪ ", 
                              " 🔺 ", " 🔻 ", " 🟨 ", " 🟩 ", " 🟦 ", " 🟪 ", " 🟫 ", " ⬛ ", 
                              " ⬜ ", " 🟧 ", " 💎 ", " ⭐ ", " ❤️ ", " 💙 ", " 💚 ", " 💜 "};
    
    public Tablero(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.cartas = new Carta[filas][columnas];
        inicializarTablero();
    }
    
    private void inicializarTablero() {
        int totalCartas = filas * columnas;
        int parejas = totalCartas / 2;
        
        List<String> simbolos = new ArrayList<>();
        
        // Crear parejas de símbolos
        for (int i = 0; i < parejas; i++) {
            simbolos.add(emojis[i]);
            simbolos.add(emojis[i]);
        }
        
        // Mezclar los símbolos
        Collections.shuffle(simbolos);
        
        // Llenar el tablero
        int indice = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                cartas[i][j] = new Carta(simbolos.get(indice));
                indice++;
            }
        }
    }
    
    public void mostrarTablero() {
        System.out.println();
        System.out.println("--- TABLERO ACTUAL ---");
        
        // Mostrar números de columna
        System.out.print("    ");
        for (int j = 0; j < columnas; j++) {
            System.out.printf("%3d", j + 1);
        }
        System.out.println();
        
        // Línea separadora
        System.out.print("    ");
        for (int j = 0; j < columnas; j++) {
            System.out.print("---");
        }
        System.out.println();
        
        // Mostrar filas con números
        for (int i = 0; i < filas; i++) {
            System.out.printf("%2d |", i + 1);
            for (int j = 0; j < columnas; j++) {
                System.out.printf("%3s", cartas[i][j].toString());
            }
            System.out.println();
        }
        
        System.out.println("----------------------");
    }
    
    public boolean esMovimientoValido(int fila, int columna) {
        return fila >= 0 && fila < filas && columna >= 0 && columna < columnas &&
               !cartas[fila][columna].isRevelada() && !cartas[fila][columna].isEmparejada();
    }
    
    public void revelarCarta(int fila, int columna) {
        cartas[fila][columna].setRevelada(true);
    }
    
    public void ocultarCarta(int fila, int columna) {
        cartas[fila][columna].ocultar();
    }
    
    public boolean sonPareja(int fila1, int columna1, int fila2, int columna2) {
        return cartas[fila1][columna1].equals(cartas[fila2][columna2]);
    }
    
    public void marcarPareja(int fila1, int columna1, int fila2, int columna2) {
        cartas[fila1][columna1].setEmparejada(true);
        cartas[fila2][columna2].setEmparejada(true);
    }
    
    public boolean juegoTerminado() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (!cartas[i][j].isEmparejada()) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public int getFilas() {
        return filas;
    }
    
    public int getColumnas() {
        return columnas;
    }
    
    public Carta getCarta(int fila, int columna) {
        return cartas[fila][columna];
    }
}