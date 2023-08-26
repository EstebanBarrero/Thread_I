import java.io.BufferedReader;    // Importa la clase BufferedReader, que se utiliza para leer texto de un flujo de entrada
import java.io.BufferedWriter;    // Importa la clase BufferedWriter, que se utiliza para escribir texto en un flujo de salida
import java.io.FileReader;        // Importa la clase FileReader, que se utiliza para leer caracteres de un archivo de texto
import java.io.FileWriter;        // Importa la clase FileWriter, que se utiliza para escribir caracteres en un archivo de texto
import java.io.IOException;       // Importa la clase IOException, que se utiliza para manejar excepciones relacionadas con entrada/salida
import java.io.InputStreamReader; // Importa la clase InputStreamReader, que se utiliza para leer caracteres desde un flujo de entrada
import java.util.ArrayList;       // Importa la clase ArrayList, que se utiliza para crear listas dinámicas
import java.util.List;            // Importa la interfaz List, que define el comportamiento de una lista (por ejemplo, ArrayList implementa esta interfaz)

// Cargar los estudiantes desde el archivo al inicio del programa
       // cargarEstudiantesDesdeArchivo();
// Agregar el hook de apagado para guardar datos antes de salir (gancho de apagado:
//se ejecutará justo antes de que el programa finalice su ejecución, ya sea porque está terminando normalmente o debido a una finalización abrupta)
       // Runtime.getRuntime().addShutdownHook(new Thread(() -> { guardarEstudiantesEnArchivo(); System.out.println("Guardando datos antes de salir...");}));


import java.io.BufferedReader;    // Importa la clase BufferedReader, que se utiliza para leer texto de un flujo de entrada
import java.io.BufferedWriter;    // Importa la clase BufferedWriter, que se utiliza para escribir texto en un flujo de salida
import java.io.FileReader;        // Importa la clase FileReader, que se utiliza para leer caracteres de un archivo de texto
import java.io.FileWriter;        // Importa la clase FileWriter, que se utiliza para escribir caracteres en un archivo de texto
import java.io.IOException;       // Importa la clase IOException, que se utiliza para manejar excepciones relacionadas con entrada/salida
import java.io.InputStreamReader; // Importa la clase InputStreamReader, que se utiliza para leer caracteres desde un flujo de entrada
import java.util.ArrayList;       // Importa la clase ArrayList, que se utiliza para crear listas dinámicas
import java.util.List;            // Importa la interfaz List, que define el comportamiento de una lista (por ejemplo, ArrayList implementa esta interfaz)

public class Main_BufferedReader_estudiantes_programa_matricula {

    private static List<Estudiante> estudiantes = new ArrayList<>();
    private static List<ProgramaAcademico> programaAcademico = new ArrayList<>();
    private static List<Asignatura> asignatura = new ArrayList<>();
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {

// Cargar los estudiantes desde el archivo al inicio del programa
        cargarEstudiantesDesdeArchivo();
// Agregar el hook de apagado para guardar datos antes de salir (gancho de apagado:
//se ejecutará justo antes de que el programa finalice su ejecución, ya sea porque está terminando normalmente o debido a una finalización abrupta)
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            guardarEstudiantesEnArchivo();
            System.out.println("Guardando datos antes de salir...");
        }));

        int opcion;

        do {
            mostrarMenu();
            opcion = leerOpcion();

            switch (opcion) {
                case 1 ->
                        verEstudiantesRegistrados();
                case 2 ->
                        registrarEstudiante();
                case 3 ->
                        modificarEstudiante();
                case 4 ->
                        eliminarEstudiante();
                case 5 ->
                        crearProgramaAcademico();
                case 6 ->
                        modificarProgramaAcademico();
                case 7 ->
                        eliminarProgramaAcademico();
                case 8 ->
                        verProgramasAcademicosRegistrados();
                case 9 ->
                        crearAsignatura();
                case 10 ->
                        modificarAsignatura();
                case 11 ->
                        eliminarAsignatura();
                case 12 ->
                        verAsignaturasRegistradas();
                case 13 ->
                        matricularEstudiante_programa();
                case 14 ->
                        verEstudiantesMatriculados_programa();
                case 15 ->
                        eliminar_Matricula_Estudiante_programa();
                case 16 ->
                        matricularEstudiante_asigantura();
                case 17 ->
                        verEstudiantesMatriculadosEnAsignatura();
                case 18 ->
                        eliminarEstudianteDeAsignatura();

                case 0 ->
                        System.out.println("¡Hasta luego!");
                default ->
                        System.out.println("Opción no válida. Intente nuevamente.");
                // Guardar los datos antes de salir

            }
        } while (opcion != 0);

        // Guardar los datos antes de salir
        guardarEstudiantesEnArchivo();
        //reader.close(); // Cerrar el BufferedReader al finalizar
    }

    private static void guardarEstudiantesEnArchivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("estudiantes.txt"))) {
            // Abre un bloque try-with-resources que se encarga de cerrar automáticamente el BufferedWriter al final
            // La clase BufferedWriter se utiliza para escribir caracteres en un flujo de salida
            for (Estudiante estudiante : estudiantes) {
                // Itera sobre la lista de estudiantes para guardar cada uno en el archivo
                writer.write(estudiante.id_estudiante + ","
                        + estudiante.nombresApellidos + ","
                        + estudiante.codigoEstudiante + ","
                        + estudiante.correoElectronico);
                // Escribe los datos del estudiante en una línea del archivo, separados por comas
                // Cada estudiante se representa como una LÍNEA en el archivo
                writer.newLine();
                // Agrega una nueva línea para separar los datos del próximo estudiante en el archivo
            }
            System.out.println("Datos de estudiantes guardados en el archivo.");
            // Muestra un mensaje indicando que los datos se han guardado exitosamente en el archivo
        } catch (IOException e) {
            System.out.println("Error al guardar los datos de estudiantes en el archivo.");
            // Captura y maneja cualquier excepción de tipo IOException que pueda ocurrir durante la escritura en el archivo
            // Muestra un mensaje de error si se produce una excepción
        }
    }

    private static void cargarEstudiantesDesdeArchivo() {
        estudiantes.clear(); // Limpiamos la lista actual antes de cargar los datos, asegura que los estudiantes del archivo sean los únicos en la lista después de la carga

        try (BufferedReader reader = new BufferedReader(new FileReader("estudiantes.txt"))) {
            // Abre un bloque try-with-resources que se encarga de cerrar automáticamente el BufferedReader al final
            // La clase BufferedReader se utiliza para leer caracteres de un flujo de entrada (archivo)
            String line;
            while ((line = reader.readLine()) != null) {
                // Lee cada línea del archivo hasta llegar al final
                String[] parts = line.split(",");              //para dividir una cadena (string) en varias subcadenas (tokens)basadas en un delimitador especificado ","             
                // Divide la línea en partes utilizando la coma como separador
                if (parts.length == 4) {
                    // Si la línea se dividió en 4 partes (atributos esperados)
                    estudiantes.add(new Estudiante(parts[0], parts[1], parts[2], parts[3]));
                    // Crea un nuevo estudiante utilizando las partes y agrega el estudiante a la lista
                }
            }
            System.out.println("Datos de estudiantes cargados desde el archivo.");
            // Muestra un mensaje indicando que los datos se han cargado exitosamente desde el archivo
            // verEstudiantesRegistrados();  (Este comentario indica que aquí podrías llamar a verEstudiantesRegistrados() si deseas mostrar los estudiantes después de cargarlos)
        } catch (IOException e) {
            System.out.println("No se pudo cargar los datos de estudiantes desde el archivo.");
            // Captura y maneja cualquier excepción de tipo IOException que pueda ocurrir durante la lectura del archivo
            // Muestra un mensaje de error si se produce una excepción
        }
    }

    ///////////
    private static void mostrarMenu() {                         // mostrar opciones menú
        System.out.println("=== MENÚ - LISTA ESTUDIANTES PROGRAMACIÓN III ===");
        System.out.println("1. Ver estudiantes registrados");
        System.out.println("2. Registrar un nuevo estudiante");
        System.out.println("3. Modificar registro de estudiante");
        System.out.println("4. Eliminar registro de estudiante");
        System.out.println("5. Crear programa académico");
        System.out.println("6. Modificar programa academico");
        System.out.println("7. Eliminar programa académico");
        System.out.println("8. Ver programas académicos registrados");
        System.out.println("9. Crear asignatura");
        System.out.println("10. Modificar asignatura");
        System.out.println("11. Eliminar asignatura");
        System.out.println("12. Ver asignaturas registradas");
        System.out.println("13. Matricular estudiantes en programa");
        System.out.println("14. Ver matricula de estudiantes en programa");
        System.out.println("15. Eliminar estudiantes matricualados en programa");
        System.out.println("16. Matricular estudiantes en asignatura");
        System.out.println("17. Ver matricula de estudiantes en asignatura");
        System.out.println("18. Eliminar estudiantes matricualados en asignatura");
        System.out.println("0. Salir");
    }

    private static int leerOpcion() {
        int opcion;
        while (true) {
            try {
                System.out.print("Ingrese una opción: ");
                String input = reader.readLine().trim();
                if (!input.isEmpty()) {
                    opcion = Integer.parseInt(input);
                    if (opcion >= 0 && opcion <= 18) {
                        break;
                    } else {
                        System.out.println("Opción no válida. Intente nuevamente.");
                    }
                } else {
                    System.out.println("No se permiten campos vacíos. Intente nuevamente.");
                }
            } catch (NumberFormatException | IOException e) {
                System.out.println("Error: Ingrese un número válido.");
            }
        }
        return opcion;
    }

    private static void verEstudiantesRegistrados() {                       //método para leer lista estudiantes 
        if (estudiantes.isEmpty()) {                                        //Verifica si la lista de estudiantes está vacía
            System.out.println("No hay estudiantes registrados.");
        } else {
            System.out.println("=== Estudiantes Registrados ===");
            int index = 0;
            for (Estudiante estudiante : estudiantes) {                     //bucle for-each que recorre la lista de estudiantes
                System.out.println("Índice " + index + ": " + estudiante);
                index++;
            }
        }
    }

    private static void registrarEstudiante() {
        System.out.println("=== Registrar Estudiante ===");

        // Declaración de variables para almacenar los datos del estudiante
        String id_estudiante = null;
        String codigoEstudiante = null;
        String nombresApellidos = null;
        String correoElectronico = null;

        // Ciclo para validar y registrar los datos del estudiante
        while (true) {
            // Si la identificación del estudiante aún no se ha ingresado
            if (id_estudiante == null) {
                System.out.print("Identificación Estudiante: ");
                id_estudiante = leerCadenaNoVacia();

                // Validar si el estudiante ya está registrado por identificación
                for (Estudiante estudiante : estudiantes) {
                    if (estudiante.id_estudiante.equalsIgnoreCase(id_estudiante)) {
                        System.out.println("El estudiante con esta identificación ya está registrado.");
                        id_estudiante = null; // Reiniciar para volver a pedir el dato
                        break;
                    }
                }
            } // Si el código del estudiante aún no se ha ingresado
            else if (codigoEstudiante == null) {
                System.out.print("Código Estudiante: ");
                codigoEstudiante = leerCodigoNumerico();

                // Validar si el estudiante ya está registrado por código
                for (Estudiante estudiante : estudiantes) {
                    if (estudiante.codigoEstudiante.equals(codigoEstudiante)) {
                        System.out.println("El estudiante con este código ya está registrado.");
                        codigoEstudiante = null; // Reiniciar para volver a pedir el dato
                        break;
                    }
                }
            } // Si los nombres y apellidos del estudiante aún no se han ingresado
            else if (nombresApellidos == null) {
                System.out.print("Nombres y Apellidos: ");
                nombresApellidos = leerCadenaNoVaciaTexto();
            } // Si el correo electrónico del estudiante aún no se ha ingresado
            else if (correoElectronico == null) {
                System.out.print("Correo Electrónico: ");
                correoElectronico = leerCadenaNoVaciaCorreo();

                // Validar si el estudiante ya está registrado por correo electrónico
                for (Estudiante estudiante : estudiantes) {
                    if (estudiante.correoElectronico.equalsIgnoreCase(correoElectronico)) {
                        System.out.println("El estudiante con este correo electrónico ya está registrado.");
                        correoElectronico = null; // Reiniciar para volver a pedir el dato
                        break;
                    }
                }
            }

            // Si se han ingresado todos los datos requeridos, registrar el estudiante
            if (id_estudiante != null && codigoEstudiante != null && nombresApellidos != null && correoElectronico != null) {
                estudiantes.add(new Estudiante(id_estudiante, nombresApellidos, codigoEstudiante, correoElectronico));
                System.out.println("Estudiante registrado exitosamente.");
                guardarEstudiantesEnArchivo();
                break; // Salir del bucle en caso de éxito
            }
        }
    }

    private static String leerCodigoNumerico() {
        String input;
        while (true) {
            try {
                input = reader.readLine().trim();
                if (!input.isEmpty() && input.matches("^[0-9]+$")) { // Verifica que la entrada contenga solo números
                    return input;
                }
                System.out.println("Ingrese un valor válido (solo números). Intente nuevamente.");
            } catch (IOException e) {
                System.out.println("Error al leer la entrada.");
            }
        }
    }

    private static void modificarEstudiante() {
        System.out.println("=== Modificar Registro de Estudiante ===");

        // Verificar si hay estudiantes registrados
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }

        // Mostrar la lista de estudiantes registrados
        verEstudiantesRegistrados();

        // Solicitar al usuario que ingrese el índice del estudiante que desea modificar
        System.out.print("Ingrese el índice del estudiante que desea modificar: ");
        int indice = leerIndiceValido(estudiantes.size());
        Estudiante estudianteSeleccionado = estudiantes.get(indice);

        // Inicializar variables con los valores actuales del estudiante seleccionado
        String nuevosNombresApellidos = estudianteSeleccionado.nombresApellidos;
        String nuevoCodigoEstudiante = estudianteSeleccionado.codigoEstudiante;
        String nuevoCorreoElectronico = estudianteSeleccionado.correoElectronico;

        // Solicitar al usuario que ingrese los nuevos nombres y apellidos
        while (true) {
            System.out.print("Nuevo Nombres y Apellidos (" + nuevosNombresApellidos + "): ");
            String input = leerCadenaNoVaciaTexto();
            if (!input.isEmpty()) {
                nuevosNombresApellidos = input;
                break;
            } else {
                System.out.println("Ingrese un valor válido (solo texto). Intente nuevamente.");
            }
        }

        // Solicitar al usuario que ingrese el nuevo código de estudiante
        while (true) {
            System.out.print("Nuevo Código de Estudiante (" + nuevoCodigoEstudiante + "): ");
            String input = leerCodigoNumerico();
            boolean codigoEstudianteRegistrado = false;
            if (!input.isEmpty()) {
                for (Estudiante estudiante : estudiantes) {
                    if (estudiante.codigoEstudiante.equals(input) && !estudiante.codigoEstudiante.equals(nuevoCodigoEstudiante)) {
                        System.out.println("El estudiante con este código ya está registrado.");
                        codigoEstudianteRegistrado = true;
                        break;
                    }
                }
                if (!codigoEstudianteRegistrado) {
                    nuevoCodigoEstudiante = input;
                    break;
                }
            } else {
                System.out.println("No se permiten campos vacíos. Intente nuevamente.");
            }
        }

        // Solicitar al usuario que ingrese el nuevo correo electrónico
        while (true) {
            System.out.print("Nuevo Correo Electrónico (" + nuevoCorreoElectronico + "): ");
            String input = leerCadenaNoVaciaCorreo();
            boolean correoElectronicoRegistrado = false;
            if (!input.isEmpty()) {
                if (input.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$")) {
                    for (Estudiante estudiante : estudiantes) {
                        if (estudiante.correoElectronico.equalsIgnoreCase(input) && !estudiante.correoElectronico.equalsIgnoreCase(nuevoCorreoElectronico)) {
                            System.out.println("El estudiante con este correo electrónico ya está registrado.");
                            correoElectronicoRegistrado = true;
                            break;
                        }
                    }
                    if (!correoElectronicoRegistrado) {
                        nuevoCorreoElectronico = input;
                        break;
                    }
                } else {
                    System.out.println("Ingrese una dirección de correo válida. Intente nuevamente.");
                }
            } else {
                System.out.println("No se permiten campos vacíos. Intente nuevamente.");
            }
        }

        // Actualizar los datos del estudiante con los valores nuevos
        estudianteSeleccionado.nombresApellidos = nuevosNombresApellidos;
        estudianteSeleccionado.codigoEstudiante = nuevoCodigoEstudiante;
        estudianteSeleccionado.correoElectronico = nuevoCorreoElectronico;

        System.out.println("Estudiante modificado exitosamente.");
        guardarEstudiantesEnArchivo();
    }

    private static void eliminarEstudiante() {                                      //método para eliminar estudiantes registrados de la lista estudiantes
        System.out.println("=== Eliminar Registro de Estudiante ===");
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }
        verEstudiantesRegistrados();
        System.out.print("Ingrese el índice del estudiante que desea eliminar: ");
        int indice = leerIndiceValido(estudiantes.size());
        estudiantes.remove(indice);
        System.out.println("Estudiante eliminado exitosamente.");
        guardarEstudiantesEnArchivo();
    }

    private static void crearProgramaAcademico() {
        System.out.println("=== Crear Programa Académico ===");

        while (true) {
            System.out.print("Nombre del Programa Académico: ");
            String nombre_programa = leerCadenaNoVaciaTextoPunto();

            System.out.print("Código SNIES del programa: ");
            String codigo_SNIES = leerCodigoNumerico();
            // Validar si el programa académico ya está registrado por código SNIES
            boolean codigoSNIESRegistrado = false;
            for (ProgramaAcademico programa : programaAcademico) {
                if (programa.codigo_SNIES.equalsIgnoreCase(codigo_SNIES)) {
                    System.out.println("El programa académico con este código SNIES ya está registrado.");
                    codigoSNIESRegistrado = true;
                    break;
                }
            }
            if (!codigoSNIESRegistrado) {
                programaAcademico.add(new ProgramaAcademico(nombre_programa, codigo_SNIES));
                System.out.println("Programa Académico creado exitosamente.");
                break; // Salir del bucle en caso de éxito
            }
        }
    }

    private static void modificarProgramaAcademico() {
        System.out.println("=== Modificar Programa Académico ===");

        if (programaAcademico.isEmpty()) {
            System.out.println("No hay programas académicos registrados.");
            return;
        }

        verProgramasAcademicosRegistrados();

        System.out.print("Ingrese el índice del programa académico que desea modificar: ");
        int indice = leerIndiceValido(programaAcademico.size());

        ProgramaAcademico programaSeleccionado = programaAcademico.get(indice);

        String nuevoNombrePrograma = programaSeleccionado.nombre_programa;
        String nuevoCodigoSNIES = programaSeleccionado.codigo_SNIES;

        while (true) {
            System.out.print("Nuevo Nombre del Programa Académico (" + nuevoNombrePrograma + "): ");
            String input = leerCadenaNoVaciaTextoPunto();
            if (!input.isEmpty()) {
                nuevoNombrePrograma = input;
                break;
            } else {
                System.out.println("Ingrese un valor válido (texto y puntos). Intente nuevamente.");
            }
        }

        while (true) {
            System.out.print("Nuevo Código SNIES del programa (" + nuevoCodigoSNIES + "): ");
            String input = leerCodigoNumerico();
            boolean codigoSNIESRegistrado = false;
            if (!input.isEmpty()) {
                if (!input.equalsIgnoreCase(programaSeleccionado.codigo_SNIES)) {
                    for (ProgramaAcademico programa : programaAcademico) {
                        if (programa.codigo_SNIES.equalsIgnoreCase(input)) {
                            System.out.println("El programa académico con este código SNIES ya está registrado.");
                            codigoSNIESRegistrado = true;
                            break;
                        }
                    }
                    if (!codigoSNIESRegistrado) {
                        nuevoCodigoSNIES = input;
                        break;
                    }
                } else {
                    System.out.println("El nuevo código SNIES es igual al actual.");
                    break;
                }
            } else {
                System.out.println("No se permiten campos vacíos. Intente nuevamente.");
            }
        }

        programaSeleccionado.nombre_programa = nuevoNombrePrograma;
        programaSeleccionado.codigo_SNIES = nuevoCodigoSNIES;

        System.out.println("Programa académico modificado exitosamente.");
    }

    private static void eliminarProgramaAcademico() {
        System.out.println("=== Eliminar Programa Académico ===");
        if (programaAcademico.isEmpty()) {
            System.out.println("No hay programas académicos registrados.");
            return;
        }
        verProgramasAcademicosRegistrados();
        System.out.print("Ingrese el índice del programa académico que desea eliminar: ");
        int indice = leerIndiceValido(programaAcademico.size());

        ProgramaAcademico programaSeleccionado = programaAcademico.get(indice);

        System.out.println("¿Está seguro que desea eliminar el programa académico: " + programaSeleccionado.nombre_programa + " (Código SNIES: " + programaSeleccionado.codigo_SNIES + ")?");
        System.out.print("Ingrese 'SI' para confirmar la eliminación: ");
        String confirmacion = leerCadenaNoVaciaTexto().toLowerCase();

        if (confirmacion.equals("si")) {
            programaAcademico.remove(indice);
            System.out.println("Programa académico eliminado exitosamente.");
        } else {
            System.out.println("Eliminación cancelada.");
        }
    }

    private static void verProgramasAcademicosRegistrados() {
        System.out.println("=== Programas Académicos Registrados ===");

        if (programaAcademico.isEmpty()) {
            System.out.println("No hay programas académicos registrados.");
        } else {
            int index = 0;
            for (ProgramaAcademico programa : programaAcademico) {
                System.out.println("Índice " + index + ": " + programa.nombre_programa + " (Código SNIES: " + programa.codigo_SNIES + ")");
                index++;
            }
        }
    }

    private static void crearAsignatura() {
        System.out.println("=== Crear Asignaturas ===");

        while (true) {
            System.out.print("Nombre de la Asignatura: ");
            String nombre_asignatura = leerCadenaNoVaciaTexto();

            System.out.print("Créditos académicos de la Asignatura: ");
            String creditos_asignatura = leerCodigoNumerico();

            System.out.print("Código de la Asignatura: ");
            String codigo_asignatura = leerCodigoNumerico();
            // Validar si el programa académico ya está registrado por código SNIES
            boolean codigo_asignaturaRegistrado = false;
            for (Asignatura Cod_asignaturaValidar : asignatura) {
                if (Cod_asignaturaValidar.codigo_asignatura.equalsIgnoreCase(codigo_asignatura)) {
                    System.out.println("La asignatura con este código ya está registrada.");
                    codigo_asignaturaRegistrado = true;
                    break;
                }
            }
            if (!codigo_asignaturaRegistrado) {
                asignatura.add(new Asignatura(nombre_asignatura, codigo_asignatura, creditos_asignatura));
                System.out.println("Asignatura creada exitosamente.");
                break; // Salir del bucle en caso de éxito
            }
        }
    }

    private static void modificarAsignatura() {
        System.out.println("=== Modificar Asignatura ===");

        if (asignatura.isEmpty()) {
            System.out.println("No hay asignaturas registradas.");
            return;
        }

        verAsignaturasRegistradas();
        System.out.print("Ingrese el índice de la asignatura que desea modificar: ");
        int indice = leerIndiceValido(asignatura.size());

        Asignatura asignaturaSeleccionada = asignatura.get(indice);

        String nuevoCodigo_asignatura = asignaturaSeleccionada.codigo_asignatura;

        while (true) {
            System.out.print("Nuevo Código de la Asignatura (" + nuevoCodigo_asignatura + "): ");
            String input = leerCodigoNumerico();
            boolean codigoAsignaturaRegistrado = false;
            if (!input.isEmpty()) {
                if (!input.equalsIgnoreCase(asignaturaSeleccionada.codigo_asignatura)) {
                    for (Asignatura asignatura_validar : asignatura) {
                        if (asignatura_validar.codigo_asignatura.equalsIgnoreCase(input)) {
                            System.out.println("La asignatura con este código ya está registrada.");
                            codigoAsignaturaRegistrado = true;
                            break;
                        }
                    }
                    if (!codigoAsignaturaRegistrado) {
                        nuevoCodigo_asignatura = input;
                        break;
                    }
                } else {
                    System.out.println("El nuevo código de asignatura es igual al actual.");
                    break;
                }
            } else {
                System.out.println("No se permiten campos vacíos. Intente nuevamente.");
            }
        }

        System.out.print("Nuevo Nombre de la Asignatura: ");
        String nuevoNombreAsignatura = leerCadenaNoVaciaTexto();

        System.out.print("Nuevos Créditos académicos de la Asignatura: ");
        String nuevosCreditosAsignatura = leerCodigoNumerico();

        asignaturaSeleccionada.codigo_asignatura = nuevoCodigo_asignatura;
        asignaturaSeleccionada.nombre_asignatura = nuevoNombreAsignatura;
        asignaturaSeleccionada.creditos_asignatura = nuevosCreditosAsignatura;

        System.out.println("Asignatura modificada exitosamente.");
    }

    private static void verAsignaturasRegistradas() {
        System.out.println("=== Asignaturas Registradas ===");

        if (asignatura.isEmpty()) {
            System.out.println("No hay asignaturas registradas.");
        } else {
            int index = 0;
            for (Asignatura asignaturaRegistrada : asignatura) {
                System.out.println("Índice " + index + ": " + asignaturaRegistrada.nombre_asignatura + " (Código: " + asignaturaRegistrada.codigo_asignatura + "Créditos: " + asignaturaRegistrada.creditos_asignatura + ")");
                index++;
            }
        }
    }

    private static void eliminarAsignatura() {
        System.out.println("=== Eliminar Asignatura ===");

        if (asignatura.isEmpty()) {
            System.out.println("No hay asignaturas registradas.");
            return;
        }

        verAsignaturasRegistradas();
        System.out.print("Ingrese el índice de la asignatura que desea eliminar: ");
        int indice = leerIndiceValido(asignatura.size());

        Asignatura asignaturaSeleccionada = asignatura.get(indice);

        System.out.println("¿Está seguro que desea eliminar la asignatura: " + asignaturaSeleccionada.nombre_asignatura + " (Código: " + asignaturaSeleccionada.codigo_asignatura + ")?");
        System.out.print("Ingrese 'SI' para confirmar la eliminación: ");
        String confirmacion = leerCadenaNoVaciaTexto().toLowerCase();

        if (confirmacion.equals("si")) {
            asignatura.remove(indice);
            System.out.println("Asignatura eliminada exitosamente.");
        } else {
            System.out.println("Eliminación cancelada.");
        }
    }

    private static int leerIndiceValido(int maximo) {
        int indice;
        while (true) {
            try {
                System.out.print("Ingrese un índice válido: ");
                String input = reader.readLine().trim();
                indice = Integer.parseInt(input);
                if (indice >= 0 && indice < maximo) {
                    break;
                }
                System.out.println("Índice no válido. Intente nuevamente.");
            } catch (NumberFormatException | IOException e) {
                System.out.println("Error: Ingrese un número válido.");
            }
        }
        return indice;
    }

    private static String leerCadenaNoVaciaCorreo() {
        String input;
        while (true) {
            try {
                input = reader.readLine().trim();
                if (!input.isEmpty() && input.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$")) {
                    return input;
                }
                System.out.println("Ingrese una dirección de correo válida. Intente nuevamente.");
            } catch (IOException e) {
                System.out.println("Error al leer la entrada.");
            }
        }
    }

    private static String leerCadenaNoVacia() {
        String input;
        while (true) {
            try {
                input = reader.readLine().trim();
                if (!input.isEmpty()) {
                    return input;
                }
                System.out.println("No se permiten campos vacíos. Intente nuevamente.");
            } catch (IOException e) {
                System.out.println("Error al leer la entrada.");
            }
        }
    }

    private static String leerCadenaNoVaciaTexto() {
        String input;
        while (true) {
            try {
                input = reader.readLine().trim();
                if (!input.isEmpty() && input.matches("^[a-zA-Z\\s]+$")) {
                    return input;
                }
                System.out.println("Ingrese un valor válido (solo texto). Intente nuevamente.");
            } catch (IOException e) {
                System.out.println("Error al leer la entrada.");
            }
        }
    }

    private static void matricularEstudiante_programa() {
        System.out.println("=== Matricular Estudiante en Programa Académico ===");

        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }

        verEstudiantesRegistrados();

        System.out.print("Ingrese el índice del estudiante que desea matricular: ");
        int indiceEstudiante = leerIndiceValido(estudiantes.size());

        Estudiante estudianteSeleccionado = estudiantes.get(indiceEstudiante);

        if (programaAcademico.isEmpty()) {
            System.out.println("No hay programas académicos registrados.");
            return;
        }

        verProgramasAcademicosRegistrados();

        System.out.print("Ingrese el índice del programa académico en el que desea matricular al estudiante: ");
        int indicePrograma = leerIndiceValido(programaAcademico.size());

        ProgramaAcademico programaSeleccionado = programaAcademico.get(indicePrograma);

        // Validar si el estudiante ya está matriculado en el programa
        boolean estudianteMatriculado = programaSeleccionado.estudiantes_matriculados_programa.contains(estudianteSeleccionado);

        if (estudianteMatriculado) {
            System.out.println("El estudiante ya está matriculado en este programa.");
        } else {
            programaSeleccionado.Estudiantes_matriculados_programa(estudianteSeleccionado);
            System.out.println("Estudiante matriculado exitosamente en el programa académico.");
        }
    }

    private static void verEstudiantesMatriculados_programa() {
        System.out.println("=== Estudiantes Matriculados en Programa Académico ===");

        if (programaAcademico.isEmpty()) {
            System.out.println("No hay programas académicos registrados.");
            return;
        }

        verProgramasAcademicosRegistrados();

        System.out.print("Ingrese el índice del programa académico del cual desea ver los estudiantes matriculados: ");
        int indicePrograma = leerIndiceValido(programaAcademico.size());

        ProgramaAcademico programaSeleccionado = programaAcademico.get(indicePrograma);

        if (programaSeleccionado.estudiantes_matriculados_programa.isEmpty()) {
            System.out.println("No hay estudiantes matriculados en este programa.");
        } else {
            System.out.println("Estudiantes Matriculados en " + programaSeleccionado.nombre_programa + ":");
            for (Estudiante estudiante : programaSeleccionado.estudiantes_matriculados_programa) {
                System.out.println("- " + estudiante.nombresApellidos + " (" + estudiante.id_estudiante + ")");
            }
        }
    }

    private static void eliminar_Matricula_Estudiante_programa() {
        System.out.println("=== Modificar Matrícula de Estudiante en Programa Académico ===");

        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }

        verEstudiantesRegistrados();

        System.out.print("Ingrese el índice del estudiante cuya matrícula desea modificar: ");
        int indiceEstudiante = leerIndiceValido(estudiantes.size());

        Estudiante estudianteSeleccionado = estudiantes.get(indiceEstudiante);

        if (programaAcademico.isEmpty()) {
            System.out.println("No hay programas académicos registrados.");
            return;
        }

        verProgramasAcademicosRegistrados();

        System.out.print("Ingrese el índice del programa académico en el que desea modificar la matrícula del estudiante: ");
        int indicePrograma = leerIndiceValido(programaAcademico.size());

        ProgramaAcademico programaSeleccionado = programaAcademico.get(indicePrograma);

        // Validar si el estudiante está matriculado en el programa
        boolean estudianteMatriculado = programaSeleccionado.estudiantes_matriculados_programa.contains(estudianteSeleccionado);

        if (estudianteMatriculado) {
            programaSeleccionado.estudiantes_matriculados_programa.remove(estudianteSeleccionado);
            System.out.println("Matrícula del estudiante en el programa académico eliminada exitosamente.");
        } else {
            System.out.println("El estudiante no está matriculado en este programa.");
        }
    }

    private static void matricularEstudiante_asigantura() {
        System.out.println("=== Matricular Estudiante en asignatura ===");

        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }

        verEstudiantesRegistrados();

        System.out.print("Ingrese el índice del estudiante que desea matricular: ");
        int indiceEstudiante = leerIndiceValido(estudiantes.size());

        Estudiante estudianteSeleccionado = estudiantes.get(indiceEstudiante);

        if (asignatura.isEmpty()) {
            System.out.println("No hay asignaturas registradas.");
            return;
        }

        verAsignaturasRegistradas();

        System.out.print("Ingrese el índice de la asignatura en la que desea matricular al estudiante: ");
        int indicePrograma = leerIndiceValido(asignatura.size());

        Asignatura asignaturaSeleccionada = asignatura.get(indicePrograma);

        // Validar si el estudiante ya está matriculado en el programa
        boolean asignaturaMatriculada = asignaturaSeleccionada.lista_estudiantes_asignatura.contains(estudianteSeleccionado);

        if (asignaturaMatriculada) {
            System.out.println("El estudiante ya está matriculado en esta asignatura.");
        } else {
            asignaturaSeleccionada.Lista_estudiantes_asignatura(estudianteSeleccionado);
            System.out.println("Estudiante matriculado exitosamente en la asignatura.");
        }
    }

    private static void verEstudiantesMatriculadosEnAsignatura() {
        System.out.println("=== Estudiantes Matriculados en Asignatura ===");

        if (asignatura.isEmpty()) {
            System.out.println("No hay asignaturas registradas.");
            return;
        }

        verAsignaturasRegistradas();

        System.out.print("Ingrese el índice de la asignatura para ver los estudiantes matriculados: ");
        int indiceAsignatura = leerIndiceValido(asignatura.size());

        Asignatura asignaturaSeleccionada = asignatura.get(indiceAsignatura);

        if (asignaturaSeleccionada.lista_estudiantes_asignatura.isEmpty()) {
            System.out.println("No hay estudiantes matriculados en esta asignatura.");
        } else {
            System.out.println("Estudiantes matriculados en la asignatura " + asignaturaSeleccionada.nombre_asignatura + ":");
            for (Estudiante estudiante : asignaturaSeleccionada.lista_estudiantes_asignatura) {
                System.out.println("- " + estudiante.nombresApellidos);
            }
        }
    }

    private static void eliminarEstudianteDeAsignatura() {
        System.out.println("=== Eliminar Estudiante de Asignatura ===");

        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }

        verEstudiantesRegistrados();

        System.out.print("Ingrese el índice del estudiante que desea eliminar de la asignatura: ");
        int indiceEstudiante = leerIndiceValido(estudiantes.size());

        Estudiante estudianteSeleccionado = estudiantes.get(indiceEstudiante);

        if (asignatura.isEmpty()) {
            System.out.println("No hay asignaturas registradas.");
            return;
        }

        verAsignaturasRegistradas();

        System.out.print("Ingrese el índice de la asignatura de la que desea eliminar al estudiante: ");
        int indiceAsignatura = leerIndiceValido(asignatura.size());

        Asignatura asignaturaSeleccionada = asignatura.get(indiceAsignatura);

        // Validar si el estudiante está matriculado en la asignatura
        boolean estudianteMatriculado = asignaturaSeleccionada.lista_estudiantes_asignatura.contains(estudianteSeleccionado);

        if (estudianteMatriculado) {
            asignaturaSeleccionada.lista_estudiantes_asignatura.remove(estudianteSeleccionado);
            System.out.println("Estudiante eliminado exitosamente de la asignatura.");
        } else {
            System.out.println("El estudiante no está matriculado en esta asignatura.");
        }
    }

    private static String leerCadenaNoVaciaTextoPunto() {
        String input;
        while (true) {
            try {
                input = reader.readLine().trim();
                if (!input.isEmpty() && input.matches("^[a-zA-Z.\\s]+$")) {
                    return input;
                }
                System.out.println("Ingrese un valor válido (texto y puntos). Intente nuevamente.");
            } catch (IOException e) {
                System.out.println("Error al leer la entrada.");
            }
        }
    }

}




