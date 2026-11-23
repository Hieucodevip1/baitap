package Chapter8.exercise4;

import java.util.ArrayList;
import java.util.List;

public class ObservableDeck4 extends Deck {
    private final List<DeckObserver1> aObservers = new ArrayList<>();

    public void addObserver(DeckObserver1 pObserver) {
        assert pObserver != null;
        aObservers.add(pObserver);
    }

    @Override
    public void shuffle() {
        super.shuffle();
        for (DeckObserver1 observer : aObservers) {
            observer.shuffled();
        }
    }

    @Override
    public Card draw() {
        Card card = super.draw();
        for (DeckObserver1 observer : aObservers) {
            observer.cardDrawn(card);
        }
        return card;
    }
}