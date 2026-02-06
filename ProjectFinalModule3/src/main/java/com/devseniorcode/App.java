package com.devseniorcode;

import com.devseniorcode.model.*;
import com.devseniorcode.usecases.CompleteTask;
import com.devseniorcode.usecases.DropTask;
import com.devseniorcode.usecases.GetTask;
import com.devseniorcode.usecases.NewTask;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

@Slf4j
public class App {

    private static List<Task> tasks = new ArrayList<>();
    private static final Scanner READER = new Scanner(System.in);

    private App() {
    }

    static void main() {
        run();
    }

    static void run() {
        short option = 0;
        log.info("Task Manager is running");

        do {
            try {
                showOptions();
                option = Short.parseShort(READER.nextLine().strip());
                applyOperation(option);
            } catch (OptionInvalidException e) {
                log.error(e.getMessage());
            }
        } while (option != 5);

        READER.close();
    }

    static void showOptions() {
        System.out.println("1. Mostrar Tareas\n2. Agregar Tarea\n3. Eliminar Tarea\n4. Marcar Tarea Completa\n5. Salir");
    }

    static void applyOperation(short option) {
        String value;
        switch (option) {
            case 1:
                log.info("Mostrar Tasks");
                try {
                    GetTask.showTasks(tasks);
                } catch (TaskNotFoundException e) {
                    log.warn(e.getMessage());
                }
                break;
            case 2:
                try {
                    log.info("Crear Task");
                    value = getValue("Descripcion del Task: ");
                    NewTask.add(tasks, new Task(value));
                } catch (TaskInvalidDataException e) {
                    log.error(e.getMessage());
                }
                break;
            case 3:
                try {
                    log.info("Borrar Task");
                    value = getValue("ID del Task: ");
                    DropTask.remove((ArrayList<Task>) tasks, Integer.parseInt(value));
                } catch (TaskInvalidDataException | TaskNotFoundException e) {
                    log.error(e.getMessage());
                }
                break;
            case 4:
                try {
                    log.info("Marcar Task Completa");
                    value = getValue("ID del Task: ");
                    CompleteTask.complete(tasks, Integer.parseInt(value));
                } catch (TaskInvalidDataException | TaskNotFoundException e) {
                    log.error(e.getMessage());
                }
                break;
            case 5:
                log.info("Salir Task Manager");
                System.out.println("Saliendo de Task Manager...");
                break;
            default:
                throw new OptionInvalidException("Opcion no existe");
        }
    }

    static String getValue(String message) throws TaskInvalidDataException {
        System.out.print(message);

        var value = READER.nextLine().strip();

        if (value.isEmpty()) {
            throw new TaskInvalidDataException("Dato ingresado del Task incorrecto");
        }

        return value;
    }
}
