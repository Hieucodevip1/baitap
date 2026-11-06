package Lab7.exercise7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.StringJoiner;

public class CompositeShow3 implements Show2 {
    private final List<Show2> shows = new ArrayList<>();

    public CompositeShow3(Show2... shows) {
        if (shows.length < 2 || shows.length > 5) {
            throw new IllegalArgumentException("Arguments should be between two and five shows inclusively");
        }
        this.shows.addAll(Arrays.asList(shows));
    }

    @Override
    public Iterator<Show2> iterator() {
        return Collections.unmodifiableList(shows).iterator();
    }

    @Override
    public String description() {
        StringJoiner joiner = new StringJoiner("; ", "[", "]");
        for (Show2 show : shows) {
            joiner.add(show.description());
        }
        return joiner.toString();
    }

    @Override
    public int runningTime() {
        int total = 0;
        for (Show2 show : shows) {
            total += show.runningTime();
        }
        return total;
    }

    @Override
    public Show2 copy() {
        List<Show2> copies = new ArrayList<>();
        for (Show2 show : shows) {
            copies.add(show.copy());
        }
        return new CompositeShow3(copies.toArray(new Show2[0]));
    }
}