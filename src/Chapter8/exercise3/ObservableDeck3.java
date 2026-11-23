package Chapter8.exercise3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;

@SuppressWarnings("deprecation")
public class ObservableDeck3 extends Observable {
    private final List<Card> aCards = new ArrayList<>();

    public ObservableDeck3() {
        shuffle();
    }

    public void shuffle() {
        aCards.clear();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                aCards.add(Card.get(rank, suit));
            }
        }
        Collections.shuffle(aCards);
        setChanged();
        notifyObservers(new DeckChangeEvent(DeckChangeType.SHUFFLED));
    }

    public void push(Card pCard) {
        assert pCard != null;
        aCards.add(pCard);
        setChanged();
        notifyObservers(new DeckChangeEvent(DeckChangeType.CARD_PUSHED, pCard));
    }

    public Card draw() {
        assert !isEmpty();
        Card card = aCards.remove(aCards.size() - 1);
        setChanged();
        notifyObservers(new DeckChangeEvent(DeckChangeType.CARD_DRAWN, card));
        return card;
    }

    public boolean isEmpty() {
        return aCards.isEmpty();
    }

    public List<Card> getCards() {
        return Collections.unmodifiableList(aCards);
    }
}