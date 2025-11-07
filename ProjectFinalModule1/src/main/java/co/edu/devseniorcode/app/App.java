package co.edu.devseniorcode.app;

import java.util.Scanner;

public class App {

    static String name = "N/A";
    static double grade1 = -1, grade2 = -1, grade3 = -1, average;

    public static void main(String[] args) {
        int option;
        Scanner scanner = new Scanner(System.in);

        do {
            displayMenu();
            option = getInt(scanner, "\nIngrese su opción:");
            scanner.skip("\n");

            switch (option) {
                case 1: // Registrar datos de un estudiante
                    registerStudent(scanner);
                    break;
                case 2: // Mostrar datos del estudiante actual
                    displayStudentData();
                    break;
                case 3: // Calcular promedio de notas
                    getAverage();
                    System.out.printf("El promedio de las notas es: %.2f%n", average);
                    break;
                case 4: // Mostrar resumen completo del estudiante
                    displayStudentDataFull();
                    break;
                case 5: // Limpiar datos del estudiante actual
                    clearStudentData();
                    break;
                case 0: // Salir
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                    break;
            }

        } while (option != 0);

        scanner.close();
    }

    public static int getInt(Scanner scanner, String message) {
        System.out.print(message);
        return scanner.nextInt();
    }

    public static double getDouble(Scanner scanner, String message) {
        System.out.println(message);
        double grade = 0;

        grade = scanner.nextDouble();
        while (grade < 0 || grade > 100) {
            System.out.println("Nota inválida. Por favor, ingrese una nota entre 0 y 100:");
            grade = scanner.nextDouble();
            scanner.nextLine();
        }

        return grade;
    }

    public static String getString(Scanner scanner, String message) {
        String response;

        System.out.println(message);
        response = scanner.nextLine().trim();

        while (response.isEmpty() || response.equals("N/A")) {
            System.out.println("Entrada inválida. Por favor, ingrese un valor válido:");
            response = scanner.nextLine().trim();
        }

        return response;
    }

    public static void displayMenu() {
        System.out.println("--- Sistema de Registro de Estudiantes ---");
        System.out.println("1. Registrar datos de un estudiante\n2. Mostrar datos del estudiante actual\n3. Calcular promedio de notas\n4. Mostrar resumen completo del estudiante\n5. Limpiar datos del estudiante actual\n0. Salir");
    }

    public static void registerStudent(Scanner scanner) {
        if (!name.equals("N/A") && !name.isEmpty()) {
            String response;
            System.out.println("Ya hay un estudiante registrado.\ndesea sobrescribir los datos actuales? (s/n)");
            response = scanner.nextLine().trim();

            if (response.equalsIgnoreCase("s")) {
                name = getString(scanner, "Ingrese el nombre del estudiante:");
                grade1 = getDouble(scanner, "Ingrese la primera nota:");
                grade2 = getDouble(scanner, "Ingrese la segunda nota:");
                grade3 = getDouble(scanner, "Ingrese la tercera nota:");
            }

        } else {
            name = getString(scanner, "Ingrese el nombre del estudiante:");
            grade1 = getDouble(scanner, "Ingrese la primera nota:");
            grade2 = getDouble(scanner, "Ingrese la segunda nota:");
            grade3 = getDouble(scanner, "Ingrese la tercera nota:");
        }

    }

    public static void displayStudentData() {
        if (!name.equals("N/A") || grade1 != -1 || grade2 != -1 || grade3 != -1) {
            System.out.println("--- Informacion del Estudiante ---");
            System.out.printf("Nombre: %s%nNota 1: %.2f%nNota 2: %.2f%nNota 3: %.2f%n", name, grade1, grade2, grade3);
        } else {
            System.out.println("No hay datos de estudiante registrados actualmente.");
        }
    }

    public static void displayStudentDataFull() {
        if (!name.equals("N/A") || grade1 != -1 || grade2 != -1 || grade3 != -1) {
            getAverage();
            String status = average >= 60 ? "Aprobado" : "Reprobado";
            System.out.println("--- Resumen del Estudiante ---");
            System.out.printf("Nombre: %s%nNota 1: %.2f%nNota 2: %.2f%nNota 3: %.2f%nPromedio: %.2f%nEstado: %s%n", name, grade1, grade2, grade3, average, status);
        } else {
            System.out.println("No hay datos de estudiante registrados actualmente.");
        }
    }

    public static void getAverage() {
        if (name.equals("N/A")) {
            average = 0;
            System.out.println("No hay estudiante registrado.");
        } else {
            average = (grade1 + grade2 + grade3) / 3;
        }
    }

    public static void clearStudentData() {
        name = "N/A";
        grade1 = -1;
        grade2 = -1;
        grade3 = -1;
        average = 0;
        System.out.println("Los datos del estudiante actual han sido borrados exitosamente.");
    }

}
