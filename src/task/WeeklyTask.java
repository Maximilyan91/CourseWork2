package task;

import type.Type;

import java.time.LocalDateTime;

public class WeeklyTask extends Task{

    public WeeklyTask(String title, Type type, String description) {
        super(title, type, description);
    }

    @Override
    public LocalDateTime getNextTimeTask() {
        return this.getDateTime().minusWeeks(1);
    }
}
