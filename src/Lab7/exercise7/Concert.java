package Lab7.exercise7;

import java.util.Collections;
import java.util.Iterator;

public class Concert implements Show {
    private final String title;
    private final String performer;
    private final int runningTime;

    public Concert(String title, String performer, int runningTime) {
        this.title = title;
        this.performer = performer;
        this.runningTime = runningTime;
    }

    @Override
    public Iterator<Show> iterator() {
        // Lớp lá không có show con, trả về empty iterator
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
    public Show copy() {
        return new Concert(title, performer, runningTime);
    }
}