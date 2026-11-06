package Lab7.exercise7;

import java.util.Iterator;

public interface Show2 extends Iterable<Show2> {
    String description();
    int runningTime();
    Show2 copy();
}