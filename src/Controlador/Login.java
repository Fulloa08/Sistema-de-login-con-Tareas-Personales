//Lógica de autenticación, recibe usuario y contraseña, verifica las credenciales , consultando datos proporcionados por DatosLogin.
package Controlador;

import Modelo.DatosLogin;
import Modelo.Usuario;

import java.util.List;

/**
 * Clase encargada de verificar las credenciales del usuario.
 */
public class Login {

    /**
     * Verifica si existe una línea con el formato exacto "usuario;clave".
     *
     * @param usuario nombre de usuario ingresado
     * @param clave contraseña ingresada
     * @return Usuario autenticado o null si las credenciales son inválidas
     */
    public Usuario autenticar(String usuario, String clave, DatosLogin datos) {
        System.out.println("Intentando autenticar: " + usuario);  // Verificar que llega el nombre del usuario
        List<Usuario> usuarios = datos.getUsuarios();
        for (Usuario u : usuarios) {
            if (u.getNombre().trim().equalsIgnoreCase(usuario.trim()) && u.getClave().trim().equals(clave.trim())) {
                System.out.println("Autenticado exitosamente: " + u.getNombre());
                return u;
            }
        }
        System.out.println("No se encontró el usuario o la clave es incorrecta.");
        return null;
    }

}

//LISTO
