package com.devseniorcode.usecases;

import com.devseniorcode.model.Task;
import com.devseniorcode.model.TaskInvalidDataException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class NewTask {

    private static final Logger LOG = LoggerFactory.getLogger(NewTask.class);

    private NewTask() {}

    public static void add(List<Task> tasks, Task nueva) {
        LOG.info("Solitando informacion");
        try(var reader = new Scanner(System.in)) {
            System.out.println("Describe la Task:");
            var description = reader.nextLine().trim();
            nueva.setDescription(description);
        } catch (NoSuchElementException e) {
            LOG.error(e.getMessage());
            throw new TaskInvalidDataException("Descripcion no valida");
        }

        tasks.add(nueva);
    }
}
