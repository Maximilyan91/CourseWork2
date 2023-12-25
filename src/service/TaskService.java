package service;

import exception.TaskNotFoundException;
import task.Task;

import java.time.LocalDate;
import java.util.*;

public class TaskService {

    private static Map<Integer, Task> taskMap = new HashMap<>();
    private static LinkedList<Task> removedTasks = new LinkedList<>();

    public static void add(Task task) {

        taskMap.put(task.getId(), task);
    }

    //TODO: обработать исключение
    public static Task remove(int id) throws TaskNotFoundException {
        Task removedTask = getTaskByID(id);
        taskMap.remove(id);
        removedTasks.add(removedTask);
        return removedTasks.getLast();
    }

    public static List<Task> getAllByDate(LocalDate date) {
        List<Task> allTasksByDate = new ArrayList<>();
        for (int i = 1; i <= taskMap.size(); i++) {
            if (taskMap.get(i).getDateTime().toLocalDate().isEqual(date)) {
                allTasksByDate.add(taskMap.get(i));
            }
        }
        return allTasksByDate;
    }

    public static Task getTaskByID(int id) throws TaskNotFoundException {
        Task task = taskMap.get(id);
        if (task == null) {
            throw new TaskNotFoundException(
                    " Задача с иlентификатором "
                            + id + " не найдена");
        }
        return task;
    }

    public static Map<Integer, Task> getTaskMap() {
        return taskMap;
    }

    public static LinkedList<Task> getRemovedTasks() {
        return removedTasks;
    }
}
