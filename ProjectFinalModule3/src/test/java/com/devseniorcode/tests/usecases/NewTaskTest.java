package com.devseniorcode.tests.usecases;

import com.devseniorcode.model.Task;
import com.devseniorcode.usecases.NewTask;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NewTaskTest {

    private static List<Task> tasks = new ArrayList<>();

    @Test
    void addTest() {
        var task = new Task();
        task.setDescription("Aseo de la casa");
        NewTask.add(tasks, task);

        assertFalse(tasks.isEmpty());
    }
}