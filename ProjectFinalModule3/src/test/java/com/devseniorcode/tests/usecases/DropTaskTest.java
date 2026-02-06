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

    private static List<Task> tasks = new ArrayList<>();

    @BeforeEach
    void setUp() {
        tasks.add(new Task("Aseo"));
        tasks.add(new Task("Jugar"));
        tasks.add(new Task("Colegio"));
    }

    @Test
    void removeTaskTest() {
        var size = tasks.size();
        DropTask.remove(tasks, 1);
        assertNotEquals(size, tasks.size());
    }

    @Test
    void taskNotFoundTest() {
        assertThrows(TaskNotFoundException.class, () -> DropTask.remove(tasks, 4));
    }
}