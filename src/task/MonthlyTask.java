package task;

import type.Type;

import java.time.LocalDateTime;

public class MonthlyTask extends Task{
    public MonthlyTask(String title, Type type, String description) {
        super(title, type, description);
    }
    public LocalDateTime getNextTimeTask() {
        return this.getDateTime().plusMonths(1);
    }
}
