package Chapter8.exercise4;

public class Exercise04 {
    public static void main(String[] args) {
        ObservableDeck4 deck = new ObservableDeck4();
        deck.addObserver(new DrawLogger1());
        deck.addObserver(new SizeStatus1());
        deck.shuffle();
        deck.draw();
        deck.draw();
    }
}