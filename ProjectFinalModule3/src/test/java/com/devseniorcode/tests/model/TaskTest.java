package com.devseniorcode.tests.model;

import com.devseniorcode.model.Imprimable;
import com.devseniorcode.model.Task;
import com.devseniorcode.model.TaskStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    Task task;

    @BeforeEach
    void setUp() {
        task = new Task();
    }

    @Test
    void testTaskOnProcessStatus() {
        assertEquals(TaskStatus.PROCESS, task.getStatus());
    }

    @Test
    void testTaskOnCompleteStatus() {
        task.setStatus(TaskStatus.COMPLETE);
        assertEquals(TaskStatus.COMPLETE, task.getStatus());
    }

    @Test
    void testTaskIsImprimable() {
        assertInstanceOf(Imprimable.class, task);
    }
}