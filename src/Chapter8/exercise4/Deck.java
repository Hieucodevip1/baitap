package Chapter8.exercise4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private final List<Card> aCards = new ArrayList<>();

    public Deck() {
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
    }

    public Card draw() {
        assert !isEmpty();
        return aCards.remove(aCards.size() - 1);
    }

    public boolean isEmpty() {
        return aCards.isEmpty();
    }

    public List<Card> getCards() {
        return Collections.unmodifiableList(aCards);
    }
}