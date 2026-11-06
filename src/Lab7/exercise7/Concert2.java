package Lab7.exercise7;

import java.util.Collections;
import java.util.Iterator;

public class Concert2 implements Show2 {
    private final String title;
    private final String performer;
    private final int runningTime;

    public Concert2(String title, String performer, int runningTime) {
        this.title = title;
        this.performer = performer;
        this.runningTime = runningTime;
    }

    @Override
    public Iterator<Show2> iterator() {
        return Collections.emptyIterator();
    }

    @Override
    public String description() {
        return title + " by " + performer;
    }

    @Override
    public int runningTime() {
        return runningTime;
    }

    @Override
    public Show2 copy() {
        return new Concert2(title, performer, runningTime);
    }
}