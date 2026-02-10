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

    private List<Task> tasks;

    @BeforeEach
    void setUp() {
        tasks = new ArrayList<>();
        tasks.add(new Task(1, "Aseo"));
        tasks.add(new Task(2, "Jugar"));
        tasks.add(new Task(3, "Colegio"));
    }

    @Test
    void showTasksTest() {
        assertDoesNotThrow(() -> GetTask.showTasks(tasks));
    }

    @Test
    void showTasksNotFoundTest() {
        tasks.clear();
        var exception = assertThrows(TaskNotFoundException.class, () -> GetTask.showTasks(tasks));
        assertEquals("No hay tasks", exception.getMessage());
    }

    @Test
    void getTaskTest() {
        var item = GetTask.getId(tasks, 1);
        assertNotNull(item);
        assertInstanceOf(Task.class, item);
    }

    @Test
    void taskNotFoundTest() {
        tasks.clear();
        assertThrows(TaskNotFoundException.class, () -> GetTask.getId(tasks, 3));
    }
}