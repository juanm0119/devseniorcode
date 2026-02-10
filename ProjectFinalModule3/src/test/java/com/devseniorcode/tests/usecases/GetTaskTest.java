package com.devseniorcode.tests.usecases;

import com.devseniorcode.model.Task;
import com.devseniorcode.model.TaskNotFoundException;
import com.devseniorcode.usecases.GetTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GetTaskTest {

    private static List<Task> tasks = new ArrayList<>();

    @BeforeEach
    void setUp() {
        tasks.add(new Task("Aseo"));
        tasks.add(new Task("Jugar"));
        tasks.add(new Task("Colegio"));
    }

    @Test
    void showTasksTest() {
        assertDoesNotThrow(() -> GetTask.showTasks(tasks));
    }

    @Test
    void showTasksNotFoundTest() {
        var items = new ArrayList<Task>();
        var exception = assertThrows(TaskNotFoundException.class, () -> GetTask.showTasks(items));
        assertEquals("No hay tasks", exception.getMessage());
    }

    @Test
    void getTaskTest() {
        assertNotNull(GetTask.getId(tasks, 1));
    }

    @Test
    void taskNotFoundTest() {
        assertThrows(TaskNotFoundException.class, () -> GetTask.getId(tasks, 3));
    }
}