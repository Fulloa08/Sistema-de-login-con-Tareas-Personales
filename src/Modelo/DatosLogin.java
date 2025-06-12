package Modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Gestiona el archivo login.txt.
 */
public class DatosLogin {
    private final ArrayList<Usuario> usuarios = new ArrayList<>();
    private final String archivo = "login.txt";

    public DatosLogin() {
        crearArchivoSiNoExiste();
        cargarUsuarios();
    }

    private void crearArchivoSiNoExiste() {
        File f = new File(archivo);
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                System.out.println("Error al crear el archivo de login.");
            }
        }
    }

    private void cargarUsuarios() {
        File f = new File(archivo);
        try (Scanner lector = new Scanner(f)) {
            while (lector.hasNextLine()) {
                String linea = lector.nextLine().trim();
                if (!linea.isEmpty() && linea.contains(";")) {
                    String[] partes = linea.split(";");
                    String nombre = partes[0].trim();
                    String clave = partes[1].trim();
                    Usuario usuario = new Usuario(nombre, clave);
                    usuarios.add(usuario);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo leer el archivo de login.");
        }
    }



    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
}
