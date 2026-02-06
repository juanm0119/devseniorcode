package com.devseniorcode.usecases;

import com.devseniorcode.model.Task;
import com.devseniorcode.model.TaskStatus;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class CompleteTask {
    private CompleteTask() {
    }

    public static void complete(List<Task> tasks, int id) {
        var task = GetTask.getId(tasks, id);
        task.setStatus(TaskStatus.COMPLETE);
        log.info("Task completada");
    }
}
