package Chapter8.exercise1;

public class Exercise01 {
    public static void main(String[] args) {
        ObservableDeck1 deck = new ObservableDeck1();
        deck.addObserver(new DrawLogger1());
        deck.addObserver(new SizeStatus1());
        deck.shuffle();
        deck.draw();
        deck.draw();
    }
}