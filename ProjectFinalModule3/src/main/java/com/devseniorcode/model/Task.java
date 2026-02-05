package com.devseniorcode.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class Task implements Imprimable {
    private UUID id = UUID.randomUUID();
    private String description;
    private TaskStatus status = TaskStatus.NEW;

    public Task(String description) {
        this.description = description;
    }

    @Override
    public void show() {
        System.out.printf(
                "ID: %s\n Description: %s\n Status: %s\n",
                id.toString(), description, status.name()
        );
    }
}
