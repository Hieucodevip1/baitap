package Lab7.exercise7;

import java.util.Iterator;

// Show trực tiếp extends Iterable<Show>
public interface Show extends Iterable<Show> {
    String description();
    int runningTime();
    Show copy();
}