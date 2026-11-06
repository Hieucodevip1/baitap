package Lab7.exercise6;

public class Exercise06 {
    private static final Concert CONCERT = new Concert("Concert 1", "Artist X", 100);
    private static final Movie MOVIE1 = new Movie("Movie 1", 2017, 120);
    private static final Movie MOVIE2 = new Movie("Movie 2", 2018, 130);

    public static void main(String[] args) {
        Show show = new CompositeShow2(CONCERT, new CompositeShow2(MOVIE1, MOVIE2));

        // Bài 6: Phải kiểm tra instanceof vì chỉ CompositeShow2 mới implements Iterable
        if (show instanceof CompositeShow2 compositeShow) {
            for (Show subshow : compositeShow) {
                System.out.println(subshow.description());
            }
        }
    }
}