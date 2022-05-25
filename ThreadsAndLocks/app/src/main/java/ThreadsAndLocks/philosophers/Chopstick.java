package ThreadsAndLocks.philosophers;

import java.util.UUID;

public class Chopstick {
    private UUID id = UUID.randomUUID();

    public UUID getId() {
        return id;
    }
}
