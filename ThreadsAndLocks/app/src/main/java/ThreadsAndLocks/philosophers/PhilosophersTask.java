package ThreadsAndLocks.philosophers;

import java.util.Arrays;

import ThreadsAndLocks.ITask;

public class PhilosophersTask implements ITask {

    @Override
    public void run() {
        Table table = new Table();
        Chopstick[] sticks = {
                new Chopstick(),
                new Chopstick(),
                new Chopstick(),
                new Chopstick(),
                new Chopstick()
        };

        Philosopher[] philosophers = {
                new Philosopher("Aristotle"),
                new Philosopher("Confucius"),
                new Philosopher("René Descartes"),
                new Philosopher("Immanuel Kant "),
                new Philosopher("Socrates"),
        };

        philosophers[0].sit(table.prepareSeat(sticks[0], sticks[1]));
        philosophers[1].sit(table.prepareSeat(sticks[1], sticks[2]));
        philosophers[2].sit(table.prepareSeat(sticks[2], sticks[3]));
        philosophers[3].sit(table.prepareSeat(sticks[3], sticks[4]));
        philosophers[4].sit(table.prepareSeat(sticks[4], sticks[0]));

        Arrays.asList(philosophers).forEach(philosopher -> {
            Thread t = new Thread() {
                public void run() {
                    while (true) {
                        philosopher.think();
                        // philosopher.eat();
                        philosopher.eatSafely();
                        /*
                         * NOTE: eatSafely execute eating taking in account global stick order.
                         * in this case sticks are picker and locked in the order on the table, so stick
                         * zero always would be taken first
                         * and last and first philosopher can't start eat until it would be unlocked,
                         * that's why they can't block each other.
                         * 
                         */
                    }
                }
            };

            try {
                t.start();
                // t.join();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        });
    }
}
