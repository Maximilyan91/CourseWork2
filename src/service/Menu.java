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

               String title = inputTaskTitle();
                String description = inputTaskDescription();
                Type type = inputTaskType();
                int repeatability = inputRepeatability();

                if (createNewTask(title, type, description, repeatability)) {
                    System.out.println( "задача создана успешно");
                }
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

        int userChoice = 0;

        System.out.println("Укажите тип задачи:\n" +
                "1 - Личная\n" +
                "2 - Рабочая");
        try {
            userChoice = Integer.parseInt(br.readLine());
        } catch (IOException | NumberFormatException e) {
            System.out.println("ошибка ввода типа задачи. Укажите тип заново");
        }
        Type type;
        switch (userChoice) {
            case 1 -> type = Type.PERSONAL;

            case 2 -> type = Type.WORK;

            default -> type = Type.PERSONAL;
        }

        return type;
    }


    public static int inputRepeatability() {
        var br = new BufferedReader(new InputStreamReader(System.in));
        int userChoice = 0;
        System.out.println("""
                Выберите повторяемость задачи:
                1 - однократная
                2 - ежедневная
                3 - еженедельная
                4 - ежемесячная
                5 - ежегодная""");
        try {
            userChoice = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            System.out.println(
                    "ошибка ввода частоты повторяемости задачи. " +
                            "Укажите повторяемость заново");
            inputRepeatability();
        }
        if (userChoice > 0 && userChoice < 6) {
            return userChoice;
        }
        return -1;
    }


    public static boolean createNewTask(String title,
                                     Type type,
                                     String description,
                                     int repeatability ) {
        switch (repeatability) {
            case 1 -> {
                var task = new OneTimeTask(title, type, description);
                return true;
            }
            case 2 -> {
                var task = new DailyTask(title, type, description);
                return true;
            }
            case 3 -> {
                var task = new WeeklyTask(title, type, description);
                return true;
            }
            case 4 -> {
                var task = new MonthlyTask(title, type, description);
                return true;
            }
            case 5 -> {
                var task = new YearlyTask(title, type, description);
                return true;
            }
            default -> {
                System.out.println("Ошибка создания задачи");
                return false;
            }
        }
    }
}
