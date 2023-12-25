import service.TaskService;
import task.*;
import type.Type;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {


        var task = new OneTimeTask("  ", Type.WORK, "описание");
        var task1 = new WeeklyTask("еженедельная задача", Type.PERSONAL, "описание");
        var task2 = new DailyTask("ежедневная задача", Type.WORK, "описание");
        var task3 = new YearlyTask("годовая задача", Type.PERSONAL, "описание");
        var task4 = new MonthlyTask("ежемесячная задача", Type.WORK, "описание");

        LocalDate date = LocalDate.now();

        System.out.println(TaskService.getAllByDate(date));

        System.out.println(task4.getNextTimeTask());

//        System.out.println(TaskService.remove(8));
//        System.out.println(TaskService.remove(1));
//        System.out.println(TaskService.remove(2));

        System.out.println(TaskService.getTaskMap());
        System.out.println();
        System.out.println(TaskService.getRemovedTasks());
    }


}