package type;

/**
 * Класс Тип задачи (личная или рабочая)
 */
public enum Type {
    WORK("рабочая"),

    PERSONAL("личная");

    private String name;

    Type(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}


