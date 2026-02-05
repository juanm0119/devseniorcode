package com.devseniorcode;

import com.devseniorcode.model.OptionInvalidException;
import com.devseniorcode.model.Task;
import com.devseniorcode.model.TaskInvalidDataException;
import com.devseniorcode.model.TaskNotFoundException;
import com.devseniorcode.usecases.CompleteTask;
import com.devseniorcode.usecases.DropTask;
import com.devseniorcode.usecases.GetTask;
import com.devseniorcode.usecases.NewTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class App {

    private static final Logger LOG = LoggerFactory.getLogger(App.class);

    private App() {
    }

    static void main() {
        run();
    }

    static void run() {
        short option = 0;
        Scanner reader = new Scanner(System.in);

        do {
            try {
                showOptions();
                option = reader.nextShort();
            } catch (OptionInvalidException e) {
                LOG.error(e.getMessage());
            }
        } while (option != 5);

        reader.close();
    }

    static void showOptions() {
        System.out.println("1. Mostrar Tareas\n2. Agregar Tarea\n3. Eliminar Tarea\n4. Marcar Tarea Completa\n5. Salir");
    }

    static void applyOperation(short option) {
        var tasks = new ArrayList<Task>();

        switch (option) {
            case 1:
                LOG.info("Mostrar Tasks");
                try {
                    GetTask.showTasks(tasks);
                } catch (TaskNotFoundException e) {
                    LOG.error(e.getMessage());
                }

                break;
            case 2:
                try {
                    LOG.info("Crear Task");
                    NewTask.add(tasks, new Task());
                } catch (TaskInvalidDataException e) {
                    LOG.error(e.getMessage());
                }

                break;
            case 3:
                LOG.info("Borrar Task");
                DropTask.remove(tasks, UUID.randomUUID());

                break;
            case 4:
                LOG.info("Marcar Task Completa");
                CompleteTask.complete(tasks, UUID.randomUUID());

                break;
            case 5:
                LOG.info("Salir Task Manager");
                System.out.println("Saliendo de Task Manager...");
                break;
            default:
                LOG.error("Opcion no existe");
                throw new OptionInvalidException("Opcion no existe");
        }
    }
}
