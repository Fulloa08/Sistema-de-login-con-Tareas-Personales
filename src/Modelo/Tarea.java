package Modelo;

public class Tarea {
    private String descripcion;
    private Prioridad prioridad;

    public Tarea(String descripcion, Prioridad prioridad) {
        this.descripcion = descripcion;
        this.prioridad = prioridad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    @Override
    public String toString() {
        return prioridad + " - " + descripcion;
    }
}
