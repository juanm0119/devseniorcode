package com.devseniorcode.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Task implements Imprimable {
    private static int idIncrement = 1;

    private int id;
    private String description;
    private TaskStatus status = TaskStatus.PROCESS;

    public Task(String description) {
        this.id = idIncrement++;
        this.description = description;
    }

    public Task(int id, String description) {
        this.id = id;
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
