package com.devseniorcode.usecases;

import com.devseniorcode.model.Task;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class DropTask {
    private DropTask() {}

    public static void remove(List<Task> tasks, int id) {
        var task = GetTask.getId(tasks, id);
        tasks.remove(task);
        log.info("Task eliminada");
    }
}
