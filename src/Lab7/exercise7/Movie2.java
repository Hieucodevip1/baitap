package Lab7.exercise7;

import java.util.Collections;
import java.util.Iterator;

public class Movie2 implements Show2 {
    private final String title;
    private final int year;
    private final int runningTime;

    public Movie2(String title, int year, int runningTime) {
        this.title = title;
        this.year = year;
        this.runningTime = runningTime;
    }

    @Override
    public Iterator<Show2> iterator() {
        return Collections.emptyIterator();
    }

    @Override
    public String description() {
        return title + " (" + year + ")";
    }

    @Override
    public int runningTime() {
        return runningTime;
    }

    @Override
    public Show2 copy() {
        return new Movie2(title, year, runningTime);
    }
}