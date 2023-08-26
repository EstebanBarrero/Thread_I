package models;

import java.util.ArrayList;
import java.util.List;

public class Asignatura {
    String nombre_asignatura;
    String codigo_asignatura;
    String creditos_asignatura;
    List<Estudiante> lista_estudiantes_asignatura; // Nueva lista para estudiantes matriculados

    public Asignatura(String nombre_asignatura, String codigo_asignatura, String creditos_asignatura) {
        this.nombre_asignatura = nombre_asignatura;
        this.codigo_asignatura = codigo_asignatura;
        this.creditos_asignatura = creditos_asignatura;
        this.lista_estudiantes_asignatura = new ArrayList<>(); // Inicialización de la lista
    }

    public void Lista_estudiantes_asignatura(Estudiante estudiante) {
        lista_estudiantes_asignatura.add(estudiante);
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre_asignatura +
                ", Código: " + codigo_asignatura+
                ", Créditos Asignatura: " + creditos_asignatura;
    }
}
