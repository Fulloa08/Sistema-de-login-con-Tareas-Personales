package Vista;

import Controlador.Login;
import Controlador.SesionActiva;
import Modelo.DatosLogin;
import Modelo.Usuario;
import java.util.Scanner;

/**
 * Vista principal del sistema.
 */
public class ConsolaLogin {
    private final Scanner scanner = new Scanner(System.in);
    private final DatosLogin datos = new DatosLogin();
    private final Login login = new Login();

    /**
     * Muestra el menú principal del sistema.
     */
    public void menu() {
        System.out.println("Bienvenido al sistema de gestión de tareas.");
        manejarLogin();
    }

    /**
     * Solicita usuario y clave, autentica, y lanza la sesión si corresponde.
     */
    private void manejarLogin() {
        System.out.print("Ingrese su nombre de usuario: ");
        String usuario = scanner.nextLine();

        System.out.print("Ingrese su contraseña: ");
        String clave = scanner.nextLine();

        Usuario usuarioAutenticado = login.autenticar(usuario, clave, datos);

        if (usuarioAutenticado != null) {
            System.out.println("¡Inicio de sesión exitoso!");
            new SesionActiva(usuarioAutenticado).iniciar();
        } else {
            System.out.println("Nombre de usuario o contraseña incorrectos.");
        }
    }
}

//LISTO, arreglar problemas con código y resolver problemas con clase usuario