package com.devseniorcode.tests.usecases;

import com.devseniorcode.exceptions.TaskStatusException;
import com.devseniorcode.model.Task;
import com.devseniorcode.exceptions.TaskNotFoundException;
import com.devseniorcode.model.TaskStatus;
import com.devseniorcode.usecases.CompleteTask;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompleteTaskTest {

    private static List<Task> tasks = new ArrayList<>();

    @BeforeEach
    void setUp() {
        tasks.add(new Task(1, "Aseo"));
        tasks.add(new Task(2, "Jugar"));
        tasks.add(new Task(3, "Colegio"));
    }

    @Test
    void testChangeStatusTaskComplete() {
        assertDoesNotThrow(() -> CompleteTask.complete(tasks, 1));
        assertEquals(TaskStatus.COMPLETE, tasks.getFirst().getStatus());
    }

    @Test
    void testTaskWasCompleteStatus() {
        var task = tasks.getFirst();
        task.setStatus(TaskStatus.COMPLETE);
        assertThrows(TaskStatusException.class, () -> CompleteTask.complete(tasks, 1));
    }

    @Test
    void testTaskNotFound() {
        assertThrows(TaskNotFoundException.class, () -> CompleteTask.complete(tasks, 4));
    }

    @AfterEach
    void tearDown() {
        tasks.clear();
    }
}