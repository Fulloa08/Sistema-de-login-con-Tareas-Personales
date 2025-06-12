package Modelo;

import java.util.ArrayList;

public class Usuario {
    private String nombre;
    private String clave;
    private Perfil perfil;
    private ArrayList<Tarea> tareas;

    public Usuario(String nombre, String clave) {
        this.nombre = nombre;
        this.clave = clave;
        this.perfil = new Perfil(nombre + "@ejemplo.com");
        this.tareas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getClave() {
        return clave;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public ArrayList<Tarea> getTareas() {
        return tareas;
    }

    public void agregarTarea(Tarea tarea) {
        tareas.add(tarea);
    }
}

//Resolver problemas de llamado a esta clase.