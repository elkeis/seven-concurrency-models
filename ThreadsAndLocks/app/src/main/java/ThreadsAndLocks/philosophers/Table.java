package ThreadsAndLocks.philosophers;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private final static int seatsCount = 5;
    private List<Seat> seats = new ArrayList<Seat>(seatsCount);

    public Seat prepareSeat(Chopstick left, Chopstick right) {
        if (seats.size() != seatsCount) {
            Seat seat = new Seat(seats.size(), left, right);
            seats.add(seat);
            return seat;
        } else {
            return null;
        }
    }
}
