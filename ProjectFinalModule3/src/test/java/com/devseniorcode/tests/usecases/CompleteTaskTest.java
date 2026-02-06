package com.devseniorcode.tests.usecases;

import com.devseniorcode.model.Task;
import com.devseniorcode.model.TaskNotFoundException;
import com.devseniorcode.model.TaskStatus;
import com.devseniorcode.usecases.CompleteTask;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompleteTaskTest {

    private static List<Task> tasks = List.of(
            new Task("Aseo"),
            new Task("Jugar")
    );

    @Test
    void changeStatusTaskTest() {
        CompleteTask.complete(tasks, 1);
        assertEquals(TaskStatus.COMPLETE, tasks.getFirst().getStatus());
    }

    @Test
    void taskNotFoundTest() {
        assertThrows(TaskNotFoundException.class, () -> CompleteTask.complete(tasks, 3));
    }
}