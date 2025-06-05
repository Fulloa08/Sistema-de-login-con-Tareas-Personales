//Gestión de usuarios logueados, crea y utiliza una instancia de DatosSesion para manipular las tareas
//si es admin, puede registrar nuevos usuarios con GestorUsuarios

package Controlador;

import modelo.DatosSesion;
import modelo.GestorUsuarios;

import java.util.Scanner;

/**
 * Representa la sesión de un usuario logueado.
 */
public class SesionActiva {
    private final String usuario;
    private final Scanner scanner = new Scanner(System.in);
    private final GestorUsuarios gestorUsuarios = new GestorUsuarios();
    private final DatosSesion datosSesion;

    public SesionActiva(String usuario) {
        this.usuario = usuario;
        this.datosSesion = new DatosSesion(usuario.getNombre());
    }

    /**
     * Ciclo de operaciones disponibles en sesión.
     */
    public void menuSesion() {
        System.out.println("\nMenú de usuario: " + usuario.getNombre());
        System.out.println("1. Escribir nueva tarea");
        System.out.println("2. Mostrar tareas");
        if (usuario.getNombre().equalsIgnoreCase("admin")) {
            System.out.println("3. Registrar nuevo usuario");
        }
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
        // TODO: Mostrar opciones según si el usuario es admin o no.
        // TODO: Escribir tareas.
        // TODO: Registrar usuarios (solo admin).
        // TODO: Salir de sesión.
    }

    public void menuOpciones(){
        int opcion;
        do {
            menuSesion();
            opcion = Integer.parseInt(scanner.nextline());
            switch (opcion){
                case 1 -> escribirTarea();
                case 2 -> mostrarTareas();
                case 3 -> {
                    if (usuario.getNombre().equalsIgnoreCase("admin")){
                        registrarUsuario();
                    } else {
                        System.out.println("Acceso denegado");
                    }
                }
                case 0 -> System.out.println("Sesión finalizada. ");
                default -> System.out.println("Opción invalida. ");
            }
        } while (opcion != 0)

    }

    private void escribirTarea() {
        System.out.println("Ingresar la descripción de la tarea: ");
        String descripcion = scanner.nextLine();
        datosSesion.agregarTarea(descripcion);
        System.out.println("tarea guardada");
        // TODO: Pedir tarea al usuario y delegar a datosSesion.
    }

    private void mostrarTareas(){
        System.out.println("Tareas guardadas: ");
        for (var tarea : datosSesion.getTareas()){
            System.out.println("- " + tarea.getDescripcion());
        }
    }

    private void registrarUsuario() {
        System.out.println("Nuevo nombre de usuario: ");
        String nuevoNombre = scanner.nextLine();
        System.out.println("Clave: ");
        String nuevaClave = scanner.nextLine();

        boolean exito = gestorUsuarios.registrar(nuevoNombre, nuevaClave);
        if (exito){
            System.out.println("Usuario registrado exitosamente. ");
        } else {
            System.out.println("Error al registrar usuario.");
        }
        // TODO: Usar GestorUsuarios para registrar un nuevo usuario.
    }
}

//LISTO