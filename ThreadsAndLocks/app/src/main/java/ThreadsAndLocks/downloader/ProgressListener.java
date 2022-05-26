package ThreadsAndLocks.downloader;

public class ProgressListener {
    private int progress = 0;

    public void onProgress(int progress) {
        this.progress = progress;
    }

    public int getProgress() {
        return progress;
    }

}
