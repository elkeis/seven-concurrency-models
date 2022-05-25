package ThreadsAndLocks.puzzle;

import ThreadsAndLocks.ITask;
import ThreadsAndLocks.puzzle.Puzzle.PrintThread;
import ThreadsAndLocks.puzzle.Puzzle.SolveThread;

public class PuzzleTask implements ITask {
    private void runPuzzle() {
        Puzzle p = new Puzzle();
        SolveThread sTh = new SolveThread(p);
        PrintThread pTh = new PrintThread(p);

        try {
            sTh.start();
            pTh.start();
            sTh.join();
            pTh.join();
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void run() {
        /*
         * NOTE: here is about two accurances of "I don't know the answer" for 1000
         * cases. The legends say that sometimes people see "The meaning of life is 0"
         * printed. But that was not seen by the author of this note.
         */
        for (int i = 0; i < 1000; i++) {
            this.runPuzzle();
        }
    }
}