package com.devseniorcode.tests.usecases;

import com.devseniorcode.model.Task;
import com.devseniorcode.model.TaskNotFoundException;
import com.devseniorcode.usecases.GetTask;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GetTaskTest {

    private static List<Task> tasks = List.of(
            new Task("Aseo"),
            new Task("Jugar")
    );

    @Test
    void getTaskTest() {
        assertNotNull(GetTask.getId(tasks, 1));
    }

    @Test
    void taskNotFoundTest() {
        assertThrows(TaskNotFoundException.class, () -> GetTask.getId(tasks, 3));
    }
}