//Creador Diego Castillo
//Fecha de Creación: 05/09/2025
//Última Modificación: 07/09/2025
// Clase que representa a un jugador en el juego de memoria
public class Jugador {
    private String nombre;
    private int puntos;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntos = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public void sumarPunto() {
        puntos++;
    }

    public void reiniciarPuntos() {
        puntos = 0;
    }

    @Override
    public String toString() {
        return nombre + ":" + puntos + " puntos";
    }
}
