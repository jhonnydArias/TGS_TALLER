package utilities;

    public class Utils {

    public static final String WELCOME = "LABORATORIO DE CÓMPUTO";
    public static final String GOODBYE = "Cambios guardados. Hasta pronto.";
    public static final String CHOOSE_OPTION = "Ingrese el número de la opcion que desea realizar: ";
    public static final String INVALID_OPTION = "Opcion no valida. Intente de nuevo.";
    public static final String INVALID_NUMBER = "Debe ingresar un número entero. Intente de nuevo.";
    public static final String EMPTY_FIELD = "Este campo no puede estar vacio.";
    public static final String INVALID_CHARACTER = "No se permite el caracter ';' en el texto.";
    public static final String SAVE_ERROR = "Atencion: no se pudieron guardar los cambios en el archivo.";
    public static final String PRESS_ENTER = "Presione Enter para continuar...";

    // MENU PRINCIPAL
    public static final String MAIN_MENU_TITLE = "\n MENU PRINCIPAL";
    public static final String MAIN_OPTION_LOAN = "1. Prestar un equipo";
    public static final String MAIN_OPTION_RETURN = "2. Devolver un equipo";
    public static final String MAIN_OPTION_INVENTORY = "3. Consultar inventario de equipos";
    public static final String MAIN_OPTION_LOANS = "4. Consultar registro de préstamos";
    public static final String MAIN_OPTION_CREATE = "5. Registrar un equipo nuevo";
    public static final String MAIN_OPTION_DELETE = "6. Eliminar un equipo del inventario";
    public static final String MAIN_OPTION_EXIT = "0. Salir";

    //SUBMENU: INVENTARIO
    public static final String INVENTORY_MENU_TITLE = "\n CONSULTAR INVENTARIO DE EQUIPOS";
    public static final String INVENTORY_OPTION_ALL = "1. Ver todos los equipos";
    public static final String INVENTORY_OPTION_AVAILABLE = "2. Ver solo los equipos disponibles para préstamo";
    public static final String INVENTORY_OPTION_BY_TYPE = "3. Buscar equipos por tipo";
    public static final String INVENTORY_OPTION_BY_ID = "4. Buscar un equipo por número de inventario";
    public static final String OPTION_BACK = "0. Volver al menu principal";

    //SUBMENU: PRÉSTAMOS
    public static final String LOANS_MENU_TITLE = "\n CONSULTAR PRÉSTAMOS";
    public static final String LOANS_OPTION_ALL_ACTIVE = "1. Ver préstamos activos";
    public static final String LOANS_OPTION_ACTIVE_BY_TYPE = "2. Ver préstamos activos de un tipo de equipo";
    public static final String LOANS_OPTION_HISTORY_BY_OBJECT = "3. Historial de un equipo";
    public static final String LOANS_OPTION_HISTORY_BY_TYPE = "4. Historial de un tipo de equipo";
    public static final String LOANS_OPTION_HISTORY_BY_USER_ID = "5. Historial de una persona (por identificacion)";
    public static final String LOANS_OPTION_HISTORY_BY_USER_NAME = "6. Historial de una persona (por nombre)";

    //DATOS QUE PIDE LA VISTA
    public static final String ASK_OBJECT_ID = "Número de inventario del equipo: ";
    public static final String ASK_OBJECT_BRAND = "Marca: ";
    public static final String ASK_OBJECT_TYPE = "Tipo de equipo (ej: portátil, videoproyector, adaptador HDMI): ";
    public static final String ASK_OBJECT_DESCRIPTION = "Descripción: ";
    public static final String ASK_USER_ID = "Identificación de la persona: ";
    public static final String ASK_USER_NAME = "Nombre de la persona: ";
    public static final String ASK_USER_PROGRAM = "Programa académico: ";

    //PRESTAR
    public static final String LOAN_TITLE = "\n PRESTAR UN EQUIPO";
    public static final String LOAN_OK = "Préstamo registrado correctamente.";
    public static final String LOAN_OBJECT_NOT_FOUND = "No existe un equipo con ese número de inventario.";
    public static final String LOAN_NOT_AVAILABLE = "El equipo ya esta prestado. No se puede realizar el préstamo.";

    //DEVOLVER
    public static final String RETURN_TITLE = "\n DEVOLVER UN EQUIPO";
    public static final String RETURN_OK = "Devolución registrada correctamente.";
    public static final String RETURN_FAIL = "No se pudo devolver: el equipo no existe o no esta prestado.";

    //REGISTRAR EQUIPO
    public static final String CREATE_TITLE = "\n REGISTRAR UN EQUIPO";
    public static final String CREATE_OK = "Equipo registrado correctamente.";
    public static final String CREATE_DUPLICATE_ID = "Ya existe un equipo con ese número de inventario.";

    // ELIMINAR EQUIPO
    public static final String DELETE_TITLE = "\n ELIMINAR UN EQUIPO";
    public static final String DELETE_OK = "Equipo eliminado del inventario.";
    public static final String DELETE_FAIL = "No se pudo eliminar: el equipo no existe o esta prestado en este momento.";

    //RESULTADOS DE CONSULTAS
    public static final String NO_RESULTS = "No se encontraron resultados.";
    public static final String STATUS_AVAILABLE = "Disponible";
    public static final String STATUS_LOANED = "Prestado";
    public static final String NOT_RETURNED = "En préstamo";

    // Encabezados y formatos de tabla (se usan con String.format)
    public static final String OBJECT_HEADER =
            String.format("%-8s %-14s %-24s %-12s %s", "ID", "MARCA", "TIPO", "ESTADO", "DESCRIPCION");
    public static final String OBJECT_ROW = "%-8d %-14s %-24s %-12s %s";

    public static final String LOAN_HEADER =
            String.format("%-8s %-22s %-12s %-24s %-24s %-12s %s",
                    "EQUIPO", "TIPO / MARCA", "ID PERSONA", "NOMBRE", "PROGRAMA", "PRESTADO", "DEVUELTO");
    public static final String LOAN_ROW = "%-8d %-22s %-12d %-24s %-24s %-12s %s";
}