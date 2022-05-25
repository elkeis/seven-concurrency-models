package ThreadsAndLocks.philosophers;

public class Seat {
    private int number;
    private final Chopstick left;
    private final Chopstick right;
    private boolean taken = false;

    Seat(int number, Chopstick left, Chopstick right) {
        this.number = number;
        this.left = left;
        this.right = right;
    }

    public void take() {
        taken = true;
    }

    public boolean isTaken() {
        return taken;
    }

    public Chopstick getLeftChopstick() {
        return left;
    }

    public Chopstick getRightChopstick() {
        return right;
    }

    public Chopstick getFirstChopstick() {
        if (left.getId().compareTo(right.getId()) <= 0) {
            return left;
        } else {
            return right;
        }
    }

    public Chopstick getSecondChopstick() {
        if (left.getId().compareTo(right.getId()) > 0) {
            return left;
        } else {
            return right;
        }
    }

    public int getNumber() {
        return number;
    }
}
