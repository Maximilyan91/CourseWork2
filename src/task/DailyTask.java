package task;

import type.Type;

import java.time.LocalDateTime;

public class DailyTask extends Task{

    public DailyTask(String title, Type type, String description) {
        super(title, type, description);
    }

    @Override
    public LocalDateTime getNextTimeTask() {
        return this.getDateTime().plusDays(1);
    }


}
