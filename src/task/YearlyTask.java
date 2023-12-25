package task;

import type.Type;

import java.time.LocalDateTime;

public class YearlyTask extends Task{
    public YearlyTask(String title, Type type, String description) {
        super(title, type, description);
    }

    public LocalDateTime getNextTimeTask() {
        return this.getDateTime().minusYears(1);
    }
}
