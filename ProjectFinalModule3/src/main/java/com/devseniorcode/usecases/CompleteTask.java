package com.devseniorcode.usecases;

import com.devseniorcode.model.Task;
import com.devseniorcode.model.TaskNotFoundException;
import com.devseniorcode.model.TaskStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.UUID;

public class CompleteTask {

    private static final Logger LOG = LoggerFactory.getLogger(CompleteTask.class);

    private CompleteTask() {}

    public static void complete(List<Task> tasks, UUID id) {
        try {
            var task = GetTask.getId(tasks, id);
            task.setStatus(TaskStatus.COMPLETE);
        } catch (TaskNotFoundException e) {
            LOG.error(e.getMessage());
        }
    }
}
