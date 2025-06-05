package Modelo;

import java.io.*;

/**
 * Clase que permite registrar nuevos usuarios.
 */
public class GestorUsuarios {

    private final String archivo = "login.txt";

    public GestorUsuarios() {
        File f = new File(archivo);
        try {
            if (!f.exists()) {
                f.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("Error al crear login.txt: " + e.getMessage());
        }
    }

    public boolean registrar(String nombre, String clave) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))) {
            writer.write(nombre + ";" + clave);
            writer.newLine();
            return true;
        } catch (IOException e) {
            System.out.println("Error al registrar usuario: " + e.getMessage());
            return false;
        }
    }
}

//Listo