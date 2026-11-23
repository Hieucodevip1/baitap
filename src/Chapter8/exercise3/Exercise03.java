package Chapter8.exercise3;

public class Exercise03 {
    public static void main(String[] args) {
        ObservableDeck3 deck = new ObservableDeck3();
        deck.addObserver(new DrawLogger3());
        deck.addObserver(new SizeStatus3());
        deck.shuffle();
        deck.draw();
        deck.draw();
    }
}