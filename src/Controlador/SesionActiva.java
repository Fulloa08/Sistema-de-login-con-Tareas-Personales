//Gestión de usuarios logueados, crea y utiliza una instancia de DatosSesion para manipular las tareas
//si es admin, puede registrar nuevos usuarios con GestorUsuarios
package Controlador;

import Modelo.*;

import java.util.Scanner;

public class SesionActiva {
    private final Usuario usuario;
    private final DatosSesion datosSesion;
    private final Scanner scanner = new Scanner(System.in);

    public SesionActiva(Usuario usuario) {
        this.usuario = usuario;
        this.datosSesion = new DatosSesion(usuario.getNombre());
    }

    public void iniciar() {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n1. Ver tareas");
            System.out.println("2. Agregar tarea");
            System.out.println("3. Ver perfil");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> datosSesion.mostrarTareas();
                case 2 -> agregarTarea();
                case 3 -> mostrarPerfil();
                case 4 -> {
                    salir = true;
                    mostrarResumenSesion();
                }
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    private void agregarTarea() {
        System.out.print("Ingrese descripción de la tarea: ");
        String descripcion = scanner.nextLine();

        System.out.print("Prioridad (BAJA, MEDIA, ALTA): ");
        Prioridad prioridad = Prioridad.valueOf(scanner.nextLine().toUpperCase());

        datosSesion.agregarTarea(descripcion, prioridad);
        usuario.agregarTarea(new Tarea(descripcion, prioridad));
        System.out.println("Tarea agregada correctamente.");
    }

    private void mostrarPerfil() {
        Perfil perfil = usuario.getPerfil();
        System.out.println("Correo: " + perfil.getCorreo());
        System.out.println("Fecha de creación: " + perfil.getFechaCreacion());
    }

    private void mostrarResumenSesion() {
        HistorialSesion historial = datosSesion.getHistorial();
        System.out.println("\nResumen de sesión:");
        System.out.println("Inicio: " + historial.getInicio());
        System.out.println("Tareas agregadas: " + historial.getTareasAgregadas());
        System.out.println("Sesión finalizada.");
    }
}

//LISTO