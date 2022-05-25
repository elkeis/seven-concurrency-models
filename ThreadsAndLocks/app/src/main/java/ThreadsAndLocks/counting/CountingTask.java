package ThreadsAndLocks.counting;

import ThreadsAndLocks.ITask;

public class CountingTask implements ITask {

    @Override
    public void run() {
        final Counter counter = new Counter();
        final CountingThread thread = new CountingThread(counter, 10_000);
        final CountingThread thread2 = new CountingThread(counter, 10_000);
        try {
            thread.start();
            thread2.start();
            thread.join();
            thread2.join();
            System.out.println("Count: " + counter.getCount());
        } catch (InterruptedException ex) {
            System.out.println("Some Threads had threwed exception");
        }
    }
}
