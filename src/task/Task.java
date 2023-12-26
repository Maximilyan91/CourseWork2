package task;

import exception.InCorrectArgumentException;
import service.TaskService;
import type.Type;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;


/**
 * Класс "Задача"
 * @author Max
 */

public abstract class Task {
    private static int idGenerator = 0;
    private String title;
    private Type type;
    private int id;
    private LocalDateTime dateTime;
    private String description;

    public Task() {
    }

    public Task(String title, Type type, String description) {
        setTitle(title);
        this.type = type;
        setDescription(description);
        this.id = ++idGenerator;
        this.dateTime = LocalDateTime.now();
        TaskService.add(this);
    }

    private boolean isCorrectArgument(String arg) throws InCorrectArgumentException {
        if (arg == null || arg.isEmpty() || arg.isBlank()) {
            throw new InCorrectArgumentException("Введен неправильный аргумент ");
        } else {
            return true;
        }
    }

    public abstract LocalDateTime getNextTimeTask();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        try {
            if (isCorrectArgument(title)) {
                this.title = title;
            }
        } catch (InCorrectArgumentException e) {
            System.out.println(e.getMessage());
            this.title = "Измените заголовок задачи";
        }
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
        try {
            if (isCorrectArgument(description)) {
                this.description = description;
            }
        } catch (InCorrectArgumentException e) {
            System.out.println(e.getMessage());
            this.title = "Измените описание задачи";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task task)) return false;
        return id == task.id
                && Objects.equals(title, task.title)
                && type == task.type
                && Objects.equals(dateTime, task.dateTime)
                && Objects.equals(description, task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, type, id, dateTime, description);
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", type=" + type.getName() +
                ", id=" + id +
                ", dateTime=" + dateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")) +
                ", description='" + description + '\'' +
                '}';
    }
}

