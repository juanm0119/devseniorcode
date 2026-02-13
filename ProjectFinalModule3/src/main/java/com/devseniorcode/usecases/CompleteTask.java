package com.devseniorcode.usecases;

import com.devseniorcode.exceptions.TaskStatusException;
import com.devseniorcode.model.Task;
import com.devseniorcode.model.TaskStatus;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class CompleteTask {
    private CompleteTask() {}

    public static void complete(List<Task> tasks, String id) throws TaskStatusException {
        var task = GetTask.getId(tasks, id);

        if (task.getStatus() == TaskStatus.COMPLETE) {
            throw new TaskStatusException("Task con ID " + id + " esta completa");
        }

        task.setStatus(TaskStatus.COMPLETE);
        log.info("Task completada");
    }
}
