package com.devseniorcode.tests.usecases;

import com.devseniorcode.model.Task;
import com.devseniorcode.model.TaskNotFoundException;
import com.devseniorcode.usecases.DropTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DropTaskTest {

    private List<Task> tasks;

    @BeforeEach
    void setUp() {
        tasks = new ArrayList<>();
        tasks.add(new Task(1, "Aseo"));
        tasks.add(new Task(2, "Jugar"));
        tasks.add(new Task(3,"Colegio"));
    }

    @Test
    void testRemoveTask() {
        var size = tasks.size();
        DropTask.remove(tasks, 1);
        assertNotEquals(size, tasks.size());
    }

    @Test
    void testTaskNotFound() {
        assertThrows(TaskNotFoundException.class, () -> DropTask.remove(tasks, 4));
    }
}