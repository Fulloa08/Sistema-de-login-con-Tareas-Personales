package Modelo;

/**
 * Representa una tarea con una descripción.
 */
public class Tarea {
    private final String descripcion;

    public Tarea(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
