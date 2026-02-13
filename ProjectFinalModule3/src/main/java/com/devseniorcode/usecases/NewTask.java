package com.devseniorcode.usecases;

import com.devseniorcode.exceptions.TaskInvalidDataException;
import com.devseniorcode.model.Task;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class NewTask {
    private NewTask() {}

    public static void add(List<Task> tasks, Task nueva) throws TaskInvalidDataException {

        if (nueva.getDescription().isEmpty()) {
            throw new TaskInvalidDataException("Dato ingresado del Task incorrecto");
        }

        tasks.add(nueva);
        log.info("Task agregada");
    }

}
