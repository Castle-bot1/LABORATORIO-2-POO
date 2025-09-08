//Creador Diego Castillo
//Fecha de Creación: 05/09/2025
//Última Modificación: 07/09/2025
//Clase principal para iniciar el juego de memoria
//Para que funcionaran los emojis desde la consola fue gracias a estos comandos que extraje de esta fuente: https://stackoverflow.com/questions/79355903/issues-printing-emojis-and-symbols-on-windows-terminal-using-java
//A la hora de correr el programa en la consola de windows, se debe de correr con el siguiente comando: [Console]::InputEncoding = [Console]::OutputEncoding = New-Object System.Text.UTF8Encoding
//Debo de agradecer a mi cuñado Hugo por ayudarme a encontrar esta solución ya que no pude encontrarla por mi mismo.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean jugarDeNuevo = true;

        while (jugarDeNuevo) {
            ControladorJuego controlador = new ControladorJuego();
            controlador.iniciarJuego();

            System.out.print("\n¿Desea jugar otra partida? (s/n): ");
            String respuesta = scanner.next().toLowerCase();
            jugarDeNuevo = respuesta.equals("s") || respuesta.equals("si");
        }

        System.out.println("¡Gracias por jugar!");
        scanner.close();
    }
}