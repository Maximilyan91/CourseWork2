package task;

import type.Type;

import java.time.LocalDateTime;

public class OneTimeTask extends Task{

    public OneTimeTask(String title, Type type, String description) {
        super(title, type, description);
    }
    public LocalDateTime getNextTimeTask() {
        return getDateTime();
    }

}
