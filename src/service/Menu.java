package service;

import task.*;
import type.Type;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {

    public static void printMenu() {
        System.out.println(
                "Добро пожаловать в ежедневник v1.0 \n" +
                        "=== Главное меню ===\n" +
                        "1 - создать новую задачу\n" +
                        "2 - получить список задач на день\n" +
                        "3 - удалить задачу\n" +
                        "4 - выход");
    }

    public static void menu() {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int choice = -1;
        try {

            choice = Integer.parseInt(br.readLine());

        } catch (IOException | NumberFormatException e) {

            System.out.println("введите число");
            menu();
        }
        switch (choice) {
            case 1 -> {

            }
        }
    }



    public static String inputTaskTitle() {
        var br = new BufferedReader(new InputStreamReader(System.in));
        String title = "";
        System.out.println("Введите заголовок задачи:");
        try {
            title = br.readLine();
        } catch (IOException e) {
            System.out.println("ошибка ввода-вывода в заголовке задачи. Введите заголовок заново");
            inputTaskTitle();
        }
        return title;
    }

    public static String inputTaskDescription() {
        var br = new BufferedReader(new InputStreamReader(System.in));
        String description = "";
        System.out.println("Введите описание задачи:");
        try {
            description = br.readLine();
        } catch (IOException e) {
            System.out.println("ошибка ввода-вывода в описании задачи. Укажите описание заново");
            inputTaskDescription();
        }
        return description;
    }

    public static Type inputTaskType() {
        var br = new BufferedReader(new InputStreamReader(System.in));
        String inputValue = "";
        Type type = null;
        System.out.println("Укажите тип задачи: Личная или Рабочая");
        try {
            inputValue = br.readLine();
        } catch (IOException e) {
            System.out.println("ошибка ввода типа задачи. Укажите тип заново");
        }
        return type = Type.valueOf(inputValue.toLowerCase());
    }

    public static Task inputRepeatability() {
        Task task = null;
        var br = new BufferedReader(new InputStreamReader(System.in));
        int repeatability = 0;
        System.out.println("""
                Выберите повторяемость задачи:
                1 - однократная
                2 - ежедневная
                3 - еженедельная
                4 - ежемесячная
                5 - ежегодная""");
        try {
            repeatability = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            System.out.println(
                    "ошибка ввода частоты повторяемости задачи. " +
                            "Укажите повторяемость заново");
            inputRepeatability();
        }
        switch (repeatability) {
            case 1 -> {
                OneTimeTask t = (OneTimeTask) task;
            }
            case 2 -> {
                DailyTask t = (DailyTask) task;
            }
            case 3 -> {
                WeeklyTask t = (WeeklyTask) task;
            }
            case 4 -> {
                MonthlyTask t = (MonthlyTask) task;
            }
            case 5 -> {
                YearlyTask t = (YearlyTask) task;
            }
        }
        return task;
    }


    public static void createNewTask() {


    }


}
