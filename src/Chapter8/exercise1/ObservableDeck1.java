package Chapter8.exercise1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ObservableDeck1 {
    private final List<Card> aCards = new ArrayList<>();
    private final List<DeckObserver1> aObservers = new ArrayList<>();

    public ObservableDeck1() {
        shuffle();
    }

    public void addObserver(DeckObserver1 pObserver) {
        assert pObserver != null;
        aObservers.add(pObserver);
    }

    public void shuffle() {
        aCards.clear();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                aCards.add(Card.get(rank, suit));
            }
        }
        Collections.shuffle(aCards);
        for (DeckObserver1 observer : aObservers) {
            observer.shuffled();
        }
    }

    public void push(Card pCard) {
        assert pCard != null;
        aCards.add(pCard);
        for (DeckObserver1 observer : aObservers) {
            observer.cardPushed(pCard);
        }
    }

    public Card draw() {
        assert !isEmpty();
        Card card = aCards.remove(aCards.size() - 1);
        for (DeckObserver1 observer : aObservers) {
            observer.cardDrawn(card);
        }
        return card;
    }

    public boolean isEmpty() {
        return aCards.isEmpty();
    }

    public List<Card> getCards() {
        return Collections.unmodifiableList(aCards);
    }
}