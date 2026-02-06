package com.devseniorcode.usecases;

import com.devseniorcode.model.Task;
import com.devseniorcode.model.TaskInvalidDataException;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

@Slf4j
public class NewTask {
    private NewTask() {}

    public static void add(Scanner reader, List<Task> tasks, Task nueva) {
        log.info("Solitando informacion");
        try {
            System.out.print("Describe la Task:");
            nueva.setDescription(reader.nextLine().strip());
        } catch (NoSuchElementException e) {
            log.error(e.getMessage());
            throw new TaskInvalidDataException("Descripcion no valida");
        }

        tasks.add(nueva);
        log.info("Task agregada");
    }
}
