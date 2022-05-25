package ThreadsAndLocks.philosophers;

import java.util.Random;

public class Philosopher {
    private Seat seat;
    private String name;
    private Random random = new Random();

    Philosopher(String name) {
        this.name = name;
    }

    public boolean sit(Seat seat) {
        if (!seat.isTaken()) {
            seat.take();
            this.seat = seat;
            return true;
        } else {
            return false;
        }
    }

    /*
     * NOTE: When philosophers think fast, they can become eat at the same time so
     * they don't have enough sticks.
     * deadlocks is possible;
     */
    public void think() {
        try {
            System.out.println(this.toString() + " start Thinking...");
            Thread.sleep(random.nextInt(100));
            System.out.println(this.toString() + " finish Thinking.");
        } catch (Exception ex) {
            System.out.println(this.toString() + " Thinking is itterupted with exception: " + ex.getMessage());
        }
    }

    public void eat() {
        try {
            synchronized (seat.getLeftChopstick()) {
                synchronized (seat.getRightChopstick()) {
                    System.out.println(this.toString() + " start Eating...");
                    Thread.sleep(random.nextInt(1000));
                    System.out.println(this.toString() + " finish Eating.");
                }
            }
        } catch (InterruptedException ex) {
            System.out.println(this.toString() + " Eating is itterupted with exception: " + ex.getMessage());
        }
    }

    public void eatSafely() {
        try {
            synchronized (seat.getFirstChopstick()) {
                synchronized (seat.getSecondChopstick()) {
                    System.out.println(this.toString() + " start Eating...");
                    Thread.sleep(random.nextInt(1000));
                    System.out.println(this.toString() + " finish Eating.");
                }
            }
        } catch (InterruptedException ex) {
            System.out.println(this.toString() + " Eating is itterupted with exception: " + ex.getMessage());
        }
    }

    public String toString() {
        return "Philosopher " + name + " on seat #" + seat.getNumber();
    }
}
