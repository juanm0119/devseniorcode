package com.devseniorcode.usecases;

import com.devseniorcode.model.Task;
import com.devseniorcode.model.TaskNotFoundException;
import com.devseniorcode.model.TaskStatus;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

@Slf4j
public class CompleteTask {
    private CompleteTask() {}

    public static void complete(Scanner reader, List<Task> tasks) {
        try {
            System.out.print("ID del Task: ");
            var task = GetTask.getId(tasks, Integer.parseInt(reader.nextLine().strip()));
            task.setStatus(TaskStatus.COMPLETE);
            log.info("Task completada");
        } catch (NoSuchElementException | TaskNotFoundException e) {
            log.error(e.getMessage());
        }
    }
}
