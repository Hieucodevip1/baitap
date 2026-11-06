package Lab7.exercise7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.StringJoiner;

public class CompositeShow implements Show {
    private final List<Show> shows = new ArrayList<>();

    public CompositeShow(Show... shows) {
        if (shows.length < 2 || shows.length > 5) {
            throw new IllegalArgumentException("Arguments should be between two and five shows inclusively");
        }
        this.shows.addAll(Arrays.asList(shows));
    }

    @Override
    public Iterator<Show> iterator() {
        return Collections.unmodifiableList(shows).iterator();
    }

    @Override
    public String description() {
        StringJoiner joiner = new StringJoiner("; ", "[", "]");
        for (Show show : shows) {
            joiner.add(show.description());
        }
        return joiner.toString();
    }

    @Override
    public int runningTime() {
        int total = 0;
        for (Show show : shows) {
            total += show.runningTime();
        }
        return total;
    }

    @Override
    public Show copy() {
        List<Show> copies = new ArrayList<>();
        for (Show show : shows) {
            copies.add(show.copy());
        }
        return new CompositeShow(copies.toArray(new Show[0]));
    }
}