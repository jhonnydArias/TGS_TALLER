package persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.util.ArrayList;

import model.Inventory;
import model.Loan;
import model.LoanObject;
import model.LoanRecord;
import model.User;

public class FileManager {
    private static final String INVENTORY_FILE = "inventario.csv";
    private static final String LOAN_RECORD_FILE = "prestamos.csv";
    private static final String SEPARATOR = ";";
    private static final String NO_DATE = "-"; // fecha de devolución de un préstamo activo

    private static final String INVENTORY_HEADER = "id;marca;tipo;descripcion";
    private static final String LOAN_HEADER =
            "idEquipo;idUsuario;nombre;programa;fechaPrestamo;fechaDevolucion";

    // GUARDAR

    public boolean saveInventory(Inventory inventory) {
        try (PrintWriter writer = new PrintWriter(INVENTORY_FILE, "UTF-8")) {
            writer.println(INVENTORY_HEADER);
            for (LoanObject obj : inventory.getLoanObjects()) {
                writer.println(obj.getId() + SEPARATOR
                        + clean(obj.getBrand()) + SEPARATOR
                        + clean(obj.getType()) + SEPARATOR
                        + clean(obj.getDescription()));
            }
            return true;
        } catch (IOException e) {
            System.out.println("No se pudo guardar el inventario: " + e.getMessage());
            return false;
        }
    }

    public boolean saveLoanRecord(LoanRecord loanRecord) {
        try (PrintWriter writer = new PrintWriter(LOAN_RECORD_FILE, "UTF-8")) {
            writer.println(LOAN_HEADER);
            for (Loan loan : loanRecord.getLoans()) {
                String returnDate = (loan.getReturnDate() == null)
                        ? NO_DATE
                        : loan.getReturnDate().toString();

                writer.println(loan.getLoanObject().getId() + SEPARATOR
                        + loan.getUser().getId() + SEPARATOR
                        + clean(loan.getUser().getName()) + SEPARATOR
                        + clean(loan.getUser().getAcademicProgram()) + SEPARATOR
                        + loan.getLoanDate().toString() + SEPARATOR
                        + returnDate);
            }
            return true;
        } catch (IOException e) {
            System.out.println("No se pudo guardar el registro de préstamos: " + e.getMessage());
            return false;
        }
    }

    // CARGAR

    public Inventory loadInventory() {
        Inventory inventory = new Inventory(new ArrayList<>());

        for (String line : readDataLines(INVENTORY_FILE)) {
            String[] f = line.split(SEPARATOR, -1);
            if (f.length != 4) {
                System.out.println("Línea de inventario ignorada (campos incorrectos): " + line);
                continue;
            }
            try {
                int id = Integer.parseInt(f[0].trim());
                if (!inventory.createLoanObject(id, f[1], f[2], f[3])) {
                    System.out.println("Línea de inventario ignorada (id repetido): " + line);
                }
            } catch (NumberFormatException e) {
                System.out.println("Línea de inventario ignorada (id no numérico): " + line);
            }
        }
        return inventory;
    }

    // Recibe el inventario ya cargado: cada préstamo busca allí su equipo.
    public LoanRecord loadLoanRecord(Inventory inventory) {
        LoanRecord loanRecord = new LoanRecord();

        for (String line : readDataLines(LOAN_RECORD_FILE)) {
            String[] f = line.split(SEPARATOR, -1);
            if (f.length != 6) {
                System.out.println("Préstamo ignorado (campos incorrectos): " + line);
                continue;
            }
            try {
                int objectId = Integer.parseInt(f[0].trim());
                int userId = Integer.parseInt(f[1].trim());

                LoanObject loanObject = inventory.searchById(objectId);
                if (loanObject == null) {
                    System.out.println("Préstamo ignorado (el equipo no existe): " + line);
                    continue;
                }

                Loan loan = new Loan();
                loan.setUser(new User(userId, f[2], f[3]));
                loan.setLoanObject(loanObject);
                loan.setLoanDate(Date.valueOf(f[4].trim()));
                if (!f[5].trim().equals(NO_DATE)) {
                    loan.setReturnDate(Date.valueOf(f[5].trim()));
                }

                // La disponibilidad se calcula aquí: no se guarda en el archivo.
                if (loan.isActive()) {
                    if (!loanObject.isAvailable()) {
                        System.out.println("Préstamo ignorado (el equipo ya tiene otro préstamo activo): " + line);
                        continue;
                    }
                    loanObject.setAvailable(false);
                }

                loanRecord.getLoans().add(loan);
            } catch (IllegalArgumentException e) { // id no numérico o fecha mal escrita
                System.out.println("Préstamo ignorado (dato inválido): " + line);
            }
        }
        return loanRecord;
    }

    // Si el archivo no existe todavía, devuelve una lista vacía sin tratarlo como error.
    private ArrayList<String> readDataLines(String fileName) {
        ArrayList<String> lines = new ArrayList<>();
        File file = new File(fileName);
        if (!file.exists()) {
            return lines;
        }
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            reader.readLine(); // salta el encabezado
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("No se pudo leer " + fileName + ": " + e.getMessage());
        }
        return lines;
    }

    // Evita que un texto con ';' o saltos de línea desordene las columnas.
    private String clean(String text) {
        if (text == null) {
            return "";
        }
        return text.replace(SEPARATOR, " ").replace("\n", " ").replace("\r", " ").trim();
    }
}
