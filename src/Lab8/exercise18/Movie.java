package Lab8.exercise18;

public class Movie implements Show {
    private final String title;
    private final int year;
    private final int runningTime;

    public Movie(String title, int year, int runningTime) {
        this.title = title;
        this.year = year;
        this.runningTime = runningTime;
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
    public Show copy() {
        return new Movie(title, year, runningTime);
    }
}