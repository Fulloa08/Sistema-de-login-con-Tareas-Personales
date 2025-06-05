//Lógica de autenticación, recibe usuario y contraseña, verifica las credenciales , consultando datos proporcionados por DatosLogin.
package Controlador;
import modelo.DatosLogin;

import java.util.ArrayList;

/**
 * Clase encargada de verificar las credenciales del usuario.
 */
public class Login {


    /**
     * Verifica si existe una línea con el formato exacto "usuario;clave".
     *
     * @param usuario nombre de usuario ingresado
     * @param clave contraseña ingresada
     * @return true si las credenciales son válidas, false en caso contrario
     */
    static boolean autenticar(String usuario, String clave, DatosLogin datos) {
        List<usuario> usuarios = datos.getUsuarios();
        for (>Usuario u : usuarios) {
            if (u.getNombre().equals(usuario) && u.getClave().equals(clave)) {
                return u;
            }
        }
        return null;
    }
}

//LISTO
