package com.devseniorcode.usecases;

import com.devseniorcode.model.Imprimable;
import com.devseniorcode.model.Task;
import com.devseniorcode.model.TaskNotFoundException;

import java.util.List;

public class GetTask {
    private GetTask() {}

    public static void showTasks(List<Task> tasks) throws TaskNotFoundException {
        if (tasks.isEmpty()) {
            throw new TaskNotFoundException("No hay tasks");
        }
        tasks.forEach(Imprimable::show);
    }

    public static Task getId(List<Task> tasks, int id) throws TaskNotFoundException {
        return tasks.stream()
                .filter(task -> task.getId() == id)
                .findFirst()
                .orElseThrow(() -> new TaskNotFoundException("No existe Task"));
    }
}
