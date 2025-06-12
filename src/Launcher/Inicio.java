//Punto de entrada del programa, crea una instancia de ConsolaLOgin y llama al método menú()
package Launcher;

import Vista.ConsolaLogin;

/**
 * Clase principal del sistema.
 * Contiene el método main para lanzar la aplicación.
 */
public class Inicio {
    public static void main(String[] args) {
        ConsolaLogin consola = new ConsolaLogin();
        consola.menu();
    }
}

//LISTO