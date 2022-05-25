package ThreadsAndLocks.counting;

public class Counter {
    private int count = 0;

    /*
     * NOTE: without this "syncronized" keyword, threads can
     * copy->add->write-back "count" variable value simultaneously
     * /in parralel, so this variable would be read two times into two different
     * processors memories,
     * then incremented in both places, then written back twice. So two processors
     * would do same job twice,
     * without actual incrementation of the variable in RAM.
     */
    public synchronized void increment() {
        ++count;
    }

    public int getCount() {
        return count;
    }
}
