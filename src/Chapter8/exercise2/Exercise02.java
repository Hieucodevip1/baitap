package Chapter8.exercise2;

public class Exercise02 {
    public static void main(String[] args) {
        ObservableDeck2 deck = new ObservableDeck2();
        deck.addObserver(new DrawLogger2());
        deck.addObserver(new SizeStatus2());
        deck.shuffle();
        deck.draw();
        deck.draw();
    }
}