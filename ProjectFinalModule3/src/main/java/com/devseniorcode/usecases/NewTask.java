package com.devseniorcode.usecases;

import com.devseniorcode.model.Task;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class NewTask {
    private NewTask() {}

    public static void add(List<Task> tasks, Task nueva) {
        log.info("Solitando informacion");
        tasks.add(nueva);
        log.info("Task agregada");
    }

}
