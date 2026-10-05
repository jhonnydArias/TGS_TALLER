package utilities;

import java.text.Normalizer;

public class Utils {

    public static final String WELCOME = "LABORATORIO DE COMPUTO";
    public static final String GOODBYE = "Cambios guardados. Hasta pronto.";
    public static final String CHOOSE_OPTION = "Ingrese el numero de la opcion que desea realizar: ";
    public static final String INVALID_OPTION = "Opcion no valida. Intente de nuevo.";
    public static final String INVALID_NUMBER = "Debe ingresar un numero entero. Intente de nuevo.";
    public static final String EMPTY_FIELD = "Este campo no puede estar vacio.";
    public static final String INVALID_CHARACTER = "No se permite el caracter ';' en el texto.";
    public static final String SAVE_ERROR = "Atencion: no se pudieron guardar los cambios en el archivo.";
    public static final String PRESS_ENTER = "Presione Enter para continuar...";

    // MENU PRINCIPAL
    public static final String[] MAIN_MENU = {
            "\n MENU PRINCIPAL",
            "\n 1. Prestar un equipo",
            "\n 2. Devolver un equipo",
            "\n 3. Consultar inventario de equipos",
            "\n 4. Consultar registro de prestamos",
            "\n 5. Registrar un equipo nuevo",
            "\n 6. Eliminar un equipo del inventario",
            "\n 0. Salir"
    };

    // SUBMENU: INVENTARIO
    public static final String[] INVENTORY_MENU = {
            "\n CONSULTAR INVENTARIO DE EQUIPOS",
            "\n 1. Ver todos los equipos",
            "\n 2. Ver solo los equipos disponibles para prestamo",
            "\n 3. Buscar equipos por tipo",
            "\n 4. Buscar un equipo por numero de inventario",
            "\n 0. Volver al menu principal"
    };

    // SUBMENU: PRESTAMOS
    public static final String[] LOANS_MENU = {
            "\n CONSULTAR PRESTAMOS",
            "\n 1. Ver prestamos activos",
            "\n 2. Ver prestamos activos de un tipo de equipo",
            "\n 3. Historial de un equipo",
            "\n 4. Historial de un tipo de equipo",
            "\n 5. Historial de una persona (por identificacion)",
            "\n 6. Historial de una persona (por nombre)",
            "\n 0. Volver al menu principal"
    };

    // DATOS QUE PIDE LA VISTA
    public static final String ASK_OBJECT_ID = "Numero de inventario del equipo: ";
    public static final String ASK_OBJECT_BRAND = "Marca: ";
    public static final String ASK_OBJECT_TYPE = "Tipo de equipo (ej: portatil, videoproyector, adaptador HDMI): ";
    public static final String ASK_OBJECT_DESCRIPTION = "Descripcion: ";
    public static final String ASK_USER_ID = "Identificacion de la persona: ";
    public static final String ASK_USER_NAME = "Nombre y apellido de la persona: ";
    public static final String ASK_USER_PROGRAM = "Programa academico: ";

    // PRESTAR
    public static final String LOAN_TITLE = "\n PRESTAR UN EQUIPO";
    public static final String LOAN_OK = "Prestamo registrado correctamente.";
    public static final String LOAN_OBJECT_NOT_FOUND = "No existe un equipo con ese numero de inventario.";
    public static final String LOAN_NOT_AVAILABLE = "El equipo ya esta prestado. No se puede realizar el prestamo.";

    // DEVOLVER
    public static final String RETURN_TITLE = "\n DEVOLVER UN EQUIPO";
    public static final String RETURN_OK = "Devolucion registrada correctamente.";
    public static final String RETURN_FAIL = "No se pudo devolver: el equipo no existe o no esta prestado.";

    // REGISTRAR EQUIPO
    public static final String CREATE_TITLE = "\n REGISTRAR UN EQUIPO";
    public static final String CREATE_OK = "Equipo registrado correctamente.";
    public static final String CREATE_DUPLICATE_ID = "Ya existe un equipo con ese numero de inventario.";

    // ELIMINAR EQUIPO
    public static final String DELETE_TITLE = "\n ELIMINAR UN EQUIPO";
    public static final String DELETE_OK = "Equipo eliminado del inventario.";
    public static final String DELETE_FAIL = "No se pudo eliminar: el equipo no existe o esta prestado en este momento.";

    // RESULTADOS DE CONSULTAS
    public static final String NO_RESULTS = "No se encontraron resultados.";
    public static final String STATUS_AVAILABLE = "Disponible";
    public static final String STATUS_LOANED = "Prestado";
    public static final String NOT_RETURNED = "En prestamo";

    // Encabezados y formatos de tabla
    public static final String OBJECT_HEADER = String.format("%-8s %-14s %-24s %-12s %s", "ID", "MARCA", "TIPO",
            "ESTADO", "DESCRIPCION");
    public static final String OBJECT_ROW = "%-8d %-14s %-24s %-12s %s";

    public static final String LOAN_HEADER = String.format("%-8s %-22s %-12s %-24s %-24s %-12s %s",
            "EQUIPO", "TIPO / MARCA", "ID PERSONA", "NOMBRE", "PROGRAMA", "PRESTADO", "DEVUELTO");
    public static final String LOAN_ROW = "%-8d %-22s %-12d %-24s %-24s %-12s %s";

    // Normalizacion de texto
    public static String normalize(String text) {
        if (text == null) {
            return "";
        }
        return Normalizer.normalize(text, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "")
                .toLowerCase()
                .trim();
    }
}