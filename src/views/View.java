package views;

public class View {

    public static final String MAIN_MENU = "=== MENÚ - LISTA ESTUDIANTES PROGRAMACIÓN III ===\n1. ESTUDIANTES\n2. PROGRAMA ACADEMICO\n3. ASIGNATURA\n4. MATRICULA ESTUDIANTE PROGRAMA\n5. MATRICULA ESTUDIANTE ASIGNATURA\n0. Salir";
    public static final String LOAD_EXIT = "Guardando datos antes de salir...";
    public static final String BYE = "¡Gracias por visitarnos!";

    public void showMenu() {// mostrar opciones menú
        System.out.println(MAIN_MENU);
    }
    public void showMenuStudent(){
        System.out.println("=== MENÚ - ESTUDIANTES ===\n1. Ver estudiantes registrados"
                + "\n2. Registrar un nuevo estudiante\n3. Modificar registro de estudiante\n4. Eliminar registro de estudiante\n0. Salir");
    }
    public void showMenuProgram(){
        System.out.println( "=== MENÚ - PROGRAMA ACADEMICO ===\n1. Crear programa académico\n2. Modificar programa academico\n3. Eliminar programa académico"
                + "\n4. Ver programas académicos registrados\n0. Salir");
    }
    public void showMenuSubject(){
        System.out.println("=== MENÚ - ASIGNATURA ===\n1. Crear asignatura\n2. Modificar asignatura\n3. Eliminar asignatura"
                + "\n4. Ver asignaturas registradas\n0. Salir");
    }

    public void showMenuRegisterStudentProgram(){
        System.out.println("=== MENÚ - MATRICULA ESTUDIANTE A PROGRAMA ===\n1. Matricular estudiantes en programa\n2. Ver matricula de estudiantes en programa"
                + "\n3. Eliminar estudiantes matricualados en programa\n0. Salir");
    }
    public void showMenuRegisterStudentSubject(){
        System.out.println("=== MENÚ - MATRICULA ESTUDIANTE A ASIGNATURA ===\n1. Matricular estudiantes en asignatura"
                        + "\n2. Ver matricula de estudiantes en asignatura\n3. Eliminar estudiantes matricualados en asignatura\n0. Salir");
    }

    public void showLoadToExit(){
        System.out.println(LOAD_EXIT);
    }

    public void showBye(){
        System.out.println(BYE);
    }
    public void showInvalidateOption(){
        System.out.println("Opción no válida. Intente nuevamente.");
    }
}
