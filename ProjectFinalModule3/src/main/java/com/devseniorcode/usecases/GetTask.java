package com.devseniorcode.usecases;

import com.devseniorcode.exceptions.TaskInvalidDataException;
import com.devseniorcode.model.Imprimable;
import com.devseniorcode.model.Task;
import com.devseniorcode.exceptions.TaskNotFoundException;

import java.util.List;

public class GetTask {
    private GetTask() {}

    public static void showTasks(List<Task> tasks) throws TaskNotFoundException {
        if (tasks.isEmpty()) {
            throw new TaskNotFoundException("No hay tasks");
        }
        tasks.forEach(Imprimable::show);
    }

    public static Task getId(List<Task> tasks, String id) {
        try {
            return tasks.stream()
                    .filter(task -> task.getId() == Integer.parseInt(id))
                    .findFirst()
                    .orElseThrow(() -> new TaskNotFoundException("No existe Task"));
        } catch (NumberFormatException _) {
            throw new TaskInvalidDataException("El ID del task debe ser un numero");
        }
    }
}
