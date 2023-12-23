package task;

import task.type.Type;

import java.time.LocalDateTime;
import java.util.Objects;


/**
 * Класс "Задача"
 */

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


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Type getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task task)) return false;
        return id == task.id && Objects.equals(title, task.title) && type == task.type && Objects.equals(dateTime, task.dateTime) && Objects.equals(description, task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, type, id, dateTime, description);
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", type=" + type +
                ", id=" + id +
                ", dateTime=" + dateTime +
                ", description='" + description + '\'' +
                '}';
    }
}

