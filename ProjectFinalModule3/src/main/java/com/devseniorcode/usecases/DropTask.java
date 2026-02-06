package com.devseniorcode.usecases;

import com.devseniorcode.model.Task;
import com.devseniorcode.model.TaskNotFoundException;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

@Slf4j
public class DropTask {
    private DropTask() {}

    public static void remove(Scanner reader, List<Task> tasks) {
        try {
            System.out.print("ID del Task: ");
            var task = GetTask.getId(tasks, Integer.parseInt(reader.nextLine().strip()));
            tasks.remove(task);
            log.info("Task eliminada");
        } catch (NoSuchElementException | TaskNotFoundException e) {
            log.error(e.getMessage());
        }
    }
}
