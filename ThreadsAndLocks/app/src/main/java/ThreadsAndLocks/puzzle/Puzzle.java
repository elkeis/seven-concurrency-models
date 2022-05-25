package ThreadsAndLocks.puzzle;

public class Puzzle {

    private boolean answerReady = false;
    private int answer = 0;

    public void solve() {
        answer = 42;
        answerReady = true;
    }

    public boolean isAnwerReady() {
        return answerReady;
    }

    public int getAnswer() {
        return answer;
    }

    static public class SolveThread extends Thread {
        private Puzzle puzzle;

        SolveThread(Puzzle puzzle) {
            this.puzzle = puzzle;
        }

        @Override
        public void run() {
            super.run();
            this.puzzle.solve();
        }
    }

    public static class PrintThread extends Thread {
        private Puzzle puzzle;

        PrintThread(Puzzle puzzle) {
            this.puzzle = puzzle;
        }

        @Override
        public void run() {
            super.run();
            if (this.puzzle.answerReady)
                System.out.println("The meaning of life is: " + puzzle.getAnswer());
            else
                System.out.println("I don't know the answer");
        }
    }
}
