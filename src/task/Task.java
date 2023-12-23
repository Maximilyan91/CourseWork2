package task;

import task.type.Type;

import java.time.LocalDateTime;


/** Класс "Задача" */

public abstract class Task {
    private static int idGenerator = 0;
    private String title;
    private Type type;
    private int id;
    private LocalDateTime dateTime;
    private String description;

    public Task(String title, Type type, String description) {
        this.title = title;
        this.type = type;
        this.description = description;
        this.id = ++idGenerator;
        this.dateTime = LocalDateTime.now();
    }
}

