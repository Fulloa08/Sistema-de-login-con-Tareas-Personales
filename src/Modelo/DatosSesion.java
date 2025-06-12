//Maneja archivos de tareas personales, formato_ <usuario>_todo.txt, si no existe, se crea automáticamente.
//Escribe nuevas tareas y las muestra por consola

package Modelo;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DatosSesion {
    private final String nombreArchivo;
    private final ArrayList<Tarea> tareas = new ArrayList<>();

    public DatosSesion(String usuario) {
        this.nombreArchivo = usuario + "_todo.txt";
        crearArchivoSiNoExiste();
        cargarTareas();
    }

    private void crearArchivoSiNoExiste() {
        File f = new File(nombreArchivo);
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                System.out.println("Error al crear el archivo de tareas.");
            }
        }
    }

    public void agregarTarea(String tareaTexto) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            writer.write(tareaTexto);
            writer.newLine();
            tareas.add(new Tarea(tareaTexto));
        } catch (IOException e) {
            System.out.println("Error al guardar la tarea.");
        }
    }

    private void cargarTareas() {
        File f = new File(nombreArchivo);
        try (Scanner lector = new Scanner(f)) {
            while (lector.hasNextLine()) {
                String linea = lector.nextLine().trim();
                if (!linea.isEmpty()) {
                    tareas.add(new Tarea(linea));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo leer el archivo de tareas.");
        }
    }

    public void mostrarTareas() {
        tareas.clear(); // Limpiamos antes de recargar
        File archivoTareas = new File(nombreArchivo);

        if (!archivoTareas.exists()) {
            System.out.println("No hay tareas registradas aún.");
            return;
        }

        try (Scanner lector = new Scanner(archivoTareas)) {
            while (lector.hasNextLine()) {
                String linea = lector.nextLine().trim();
                if (!linea.isEmpty()) {
                    Tarea tarea = new Tarea(linea);
                    tareas.add(tarea);
                    System.out.println("- " + tarea.getDescripcion());
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer las tareas: " + e.getMessage());
        }
    }

    public ArrayList<Tarea> getTareas() {
        return tareas;
    }
}
