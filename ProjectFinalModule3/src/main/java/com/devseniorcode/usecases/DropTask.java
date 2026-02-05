package com.devseniorcode.usecases;

import com.devseniorcode.model.Task;
import com.devseniorcode.model.TaskNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.UUID;

public class DropTask {

    private static final Logger LOG = LoggerFactory.getLogger(DropTask.class);

    private DropTask() {}

    public static void remove(List<Task> tasks, UUID id) {
        try {
            var task = GetTask.getId(tasks, id);
            tasks.remove(task);
        } catch (TaskNotFoundException e) {
            LOG.error(e.getMessage());
        }

    }
}
