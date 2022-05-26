package ThreadsAndLocks.downloader;

import java.io.InputStream;
import java.io.OutputStream;

/* NOTE: There is bad example in the book. Not applicable in real life. 
    The reasonable one should work in p2p systems.
    e.g. multipeer download, where we can download the file in parralel from different sources, 
    and lock our singleton progress listener for every thread, to report right numbers. 

    TODO:   Create simple p2p network using Docker,
            with updload/list/download
            functionality and idle progress reporter, to achieve that effect.
*/
public class Downloader {
    private InputStream in;
    private OutputStream out;

}
