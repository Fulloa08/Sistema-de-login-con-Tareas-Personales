package Modelo;

import java.time.LocalDateTime;
import java.util.EnumMap;

public class Perfil {
    private String correo;
    private LocalDateTime fechaCreacion;
    private EnumMap<Prioridad, Integer> tareasPorPrioridad;

    public Perfil(String correo) {
        this.correo = correo;
        this.fechaCreacion = LocalDateTime.now();
        tareasPorPrioridad = new EnumMap<>(Prioridad.class);
        for (Prioridad p : Prioridad.values()) {
            tareasPorPrioridad.put(p, 0);
        }
    }

    public void registrarTarea(Prioridad prioridad) {
        tareasPorPrioridad.put(prioridad, tareasPorPrioridad.get(prioridad) + 1);
    }

    public String getCorreo() {
        return correo;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public EnumMap<Prioridad, Integer> getTareasPorPrioridad() {
        return tareasPorPrioridad;
    }
}
