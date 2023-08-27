package views;

public class View {

    public static final String MAIN_MENU = "=== MENÚ - LISTA ESTUDIANTES PROGRAMACIÓN III ===\n1. Ver estudiantes registrados"
            + "\n2. Registrar un nuevo estudiante\n3. Modificar registro de estudiante\n4. Eliminar registro de estudiante"
            + "5. Crear programa académico\n6. Modificar programa academico\n7. Eliminar programa académico"
            + "8. Ver programas académicos registrados\n9. Crear asignatura\n10. Modificar asignatura\n11. Eliminar asignatura"
            + "12. Ver asignaturas registradas\n13. Matricular estudiantes en programa\n14. Ver matricula de estudiantes en programa"
            + "\n15. Eliminar estudiantes matricualados en programa\n16. Matricular estudiantes en asignatura"
            + "\n17. Ver matricula de estudiantes en asignatura\n18. Eliminar estudiantes matricualados en asignatura\n0. Salir";
    public static final String LOAD_EXIT = "Guardando datos antes de salir...";
    public static final String BYE = "¡Hasta luego!";

    public void mostrarMenu() {// mostrar opciones menú
        System.out.println(MAIN_MENU);
    }

    public void showLoadToExit(){
        System.out.println(LOAD_EXIT);
    }

    public void showBye(){
        System.out.println(BYE);
    }
}
