package models;

import java.util.ArrayList;
import java.util.List;

public class ProgramaAcademico {

    public String nombre_programa;
    public String codigo_SNIES;
    public List<Asignatura> asignaturas_programa; // Nueva lista para asignaturas de programa
    public List<Estudiante> estudiantes_matriculados_programa; // Nueva lista para estudiantes matriculados

    public ProgramaAcademico(String nombre_programa, String codigo_SNIES) {
        this.nombre_programa = nombre_programa;
        this.codigo_SNIES = codigo_SNIES;
        this.asignaturas_programa = new ArrayList<>(); // Inicialización de la lista
        this.estudiantes_matriculados_programa = new ArrayList<>(); // Inicialización de la lista
    }


    public void Asignaturas_programa(Asignatura asignatura) {
        asignaturas_programa.add(asignatura);
    }

    public void Estudiantes_matriculados_programa(Estudiante estudiante) {
        estudiantes_matriculados_programa.add(estudiante);
    }

    @Override
    public String toString() {
        return "Nombre del programa académico: " + nombre_programa
                + ", Código SNIES programa: " + codigo_SNIES;
    }

}
