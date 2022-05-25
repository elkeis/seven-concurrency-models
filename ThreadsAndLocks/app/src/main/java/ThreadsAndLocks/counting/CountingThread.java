package ThreadsAndLocks.counting;

public class CountingThread extends Thread {
    private Counter counter;
    private int limit;

    CountingThread(Counter counter, int limit) {
        this.counter = counter;
        this.limit = limit;
    }

    public void run() {
        for (int x = 0; x < limit; ++x) {
            counter.increment();
        }
    }
}
