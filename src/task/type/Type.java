package task.type;

/**
 * Класс Тип задачи (личная или рабочая)
 */
public enum Type {
    WORK("рабочая"),

    PERSONAL("Личная");

    private String type;

    Type(String type) {
        this.type = type;
    }
}


