package models;

public class Estudiante {
    public String id_estudiante;
    public String nombresApellidos;
    public String codigoEstudiante;
    public String correoElectronico;

    public Estudiante(String id_estudiante, String nombresApellidos, String codigoEstudiante, String correoElectronico) {
        this.id_estudiante = id_estudiante;
        this.nombresApellidos = nombresApellidos;
        this.codigoEstudiante = codigoEstudiante;
        this.correoElectronico = correoElectronico;
    }

    @Override
    public String toString() {
        return "Id_estudiante: " + id_estudiante +
                ", Nombres y Apellidos: " + nombresApellidos +
                ", Código de Estudiante: " + codigoEstudiante +
                ", Correo Electrónico: " + correoElectronico;
    }
}
