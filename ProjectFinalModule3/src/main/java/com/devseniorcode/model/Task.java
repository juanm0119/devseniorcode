package com.devseniorcode.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Task implements Imprimable {
    private static int idIncrement = 1;
    private int id = idIncrement++;
    private String description;
    private TaskStatus status = TaskStatus.PROCESS;

    public Task(String description) {
        this.description = description;
    }

    @Override
    public void show() {
        System.out.printf(
                "ID: %d%nDescription: %s%nStatus: %s%n",
                id, description, status.name()
        );
    }
}
