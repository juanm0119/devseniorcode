package com.devseniorcode.tests.usecases;

import com.devseniorcode.exceptions.TaskInvalidDataException;
import com.devseniorcode.model.Task;
import com.devseniorcode.usecases.NewTask;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NewTaskTest {

    private static List<Task> tasks = new ArrayList<>();

    @Test
    void testAddTaskDataInvalid() {
        var task = new Task();
        task.setDescription("");
        assertThrows(TaskInvalidDataException.class, () -> NewTask.add(tasks, task));
    }

    @Test
    void testAddSuccess() {
        var task = new Task();
        task.setDescription("Aseo");
        assertDoesNotThrow(() -> NewTask.add(tasks, task));
        assertFalse(tasks.isEmpty());
    }
}