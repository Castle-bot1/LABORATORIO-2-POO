//Creador Diego Castillo
//Fecha de Creación: 05/09/2025
//Última Modificación: 07/09/2025
// Clase que representa una carta en el juego de memoria
public class Carta {
    private String simbolo;
    private boolean revelada;
    private boolean emparejada;
    
    public Carta(String simbolo) {
        this.simbolo = simbolo;
        this.revelada = false;
        this.emparejada = false;
    }
    
    
    public String getSimbolo() {
        return simbolo;
    }
    
    public boolean isRevelada() {
        return revelada;
    }
    
    public boolean isEmparejada() {
        return emparejada;
    }
    
    
    public void setRevelada(boolean revelada) {
        this.revelada = revelada;
    }
    
    public void setEmparejada(boolean emparejada) {
        this.emparejada = emparejada;
        if (emparejada) {
            this.revelada = true; // Si está emparejada, permanece revelada
        }
    }
    
    public void ocultar() {
        if (!emparejada) {
            this.revelada = false;
        }
    }
    
    @Override
    public String toString() {
        if (revelada || emparejada) {
            return simbolo;
        } else {
            return "?";
        }
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Carta carta = (Carta) obj;
        return simbolo.equals(carta.simbolo);
    }
}