package ThreadsAndLocks;

public class HelloWorld implements ITask {

    @Override
    public void run() {
        Thread mainThread = new Thread() {
            public void run() {
                System.out.println("Hello from new Thread;");
            }
        };

        mainThread.start();
        try {
            Thread.sleep(1);
        } catch (Exception e) {
            //
        }
        System.out.println("Hello from main thread");
    }
}
