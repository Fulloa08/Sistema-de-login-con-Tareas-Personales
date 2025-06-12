//Gestión de usuarios logueados, crea y utiliza una instancia de DatosSesion para manipular las tareas
//si es admin, puede registrar nuevos usuarios con GestorUsuarios
package Controlador;

import Modelo.DatosSesion;
import Modelo.GestorUsuarios;
import Modelo.Usuario;
import Modelo.Tarea;
import java.util.Scanner;

/**
 * Representa la sesión de un usuario logueado.
 */
public class SesionActiva {
    private final Usuario usuario;
    private final Scanner scanner = new Scanner(System.in);
    private final GestorUsuarios gestorUsuarios = new GestorUsuarios();
    private final DatosSesion datosSesion;

    public SesionActiva(Usuario usuario) {
        this.usuario = usuario;
        this.datosSesion = new DatosSesion(usuario.getNombre());
    }

    public void iniciar() {
        int opcion;
        do {
            mostrarOpciones();
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1 -> escribirTarea();
                case 2 -> datosSesion.mostrarTareas();
                case 3 -> {
                    if (usuario.getNombre().equalsIgnoreCase("admin")) {
                        registrarUsuario();
                    } else {
                        System.out.println("Acceso denegado.");
                    }
                }
                case 0 -> System.out.println("Sesión finalizada.");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private void mostrarOpciones() {
        System.out.println("\nMenú de usuario: " + usuario.getNombre());
        System.out.println("1. Escribir nueva tarea");
        System.out.println("2. Mostrar tareas");
        if (usuario.getNombre().equalsIgnoreCase("admin")) {
            System.out.println("3. Registrar nuevo usuario");
        }
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private void escribirTarea() {
        System.out.print("Ingresar la descripción de la tarea: ");
        String descripcion = scanner.nextLine();
        datosSesion.agregarTarea(descripcion);
        System.out.println("Tarea guardada.");
    }

    private void registrarUsuario() {
        System.out.print("Nuevo nombre de usuario: ");
        String nuevoNombre = scanner.nextLine();
        System.out.print("Clave: ");
        String nuevaClave = scanner.nextLine();

        boolean exito = gestorUsuarios.registrar(nuevoNombre, nuevaClave);
        if (exito) {
            System.out.println("Usuario registrado exitosamente.");
        } else {
            System.out.println("Error al registrar usuario.");
        }
    }
}

//LISTO