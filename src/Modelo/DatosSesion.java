//Maneja archivos de tareas personales, formato_ <usuario>_todo.txt, si no existe, se crea automáticamente.
//Escribe nuevas tareas y las muestra por consola
package Modelo;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DatosSesion {
    private final String nombreArchivo;
    private final ArrayList<Tarea> tareas = new ArrayList<>();
    private final HistorialSesion historial;

    public DatosSesion(String usuario) {
        this.nombreArchivo = usuario + "_todo.txt";
        this.historial = new HistorialSesion();
        crearArchivoSiNoExiste();
        cargarTareas();
    }

    private void crearArchivoSiNoExiste() {
        File file = new File(nombreArchivo);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Error al crear archivo de tareas.");
            }
        }
    }

    private void cargarTareas() {
        try (Scanner sc = new Scanner(new File(nombreArchivo))) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String[] partes = linea.split(";");
                if (partes.length == 2) {
                    tareas.add(new Tarea(partes[0], Prioridad.valueOf(partes[1])));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo cargar el archivo de tareas.");
        }
    }

    public void agregarTarea(String descripcion, Prioridad prioridad) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            writer.write(descripcion + ";" + prioridad);
            writer.newLine();
            tareas.add(new Tarea(descripcion, prioridad));
            historial.registrarNuevaTarea();
        } catch (IOException e) {
            System.out.println("Error al guardar tarea.");
        }
    }

    public void mostrarTareas() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas registradas.");
        } else {
            System.out.println("Tareas actuales:");
            for (Tarea t : tareas) {
                System.out.println("- " + t);
            }
        }
    }

    public HistorialSesion getHistorial() {
        return historial;
    }
}
