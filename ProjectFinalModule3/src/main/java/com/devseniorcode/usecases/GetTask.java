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
        if (!id.matches("^\\d+$")) {
            throw new TaskInvalidDataException("El ID de task debe ser un numero");
        }

        return tasks.stream()
                .filter(task -> task.getId() == Integer.parseInt(id))
                .findFirst()
                .orElseThrow(() -> new TaskNotFoundException("No existe Task"));
    }
}
