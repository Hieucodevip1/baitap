package Chapter8.exercise2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ObservableDeck2 implements DeckView {
    private final List<Card> aCards = new ArrayList<>();
    private final List<DeckObserver2> aObservers = new ArrayList<>();
    private Optional<Card> aLastDrawn = Optional.empty();

    public ObservableDeck2() {
        shuffle();
    }

    @Override
    public Card getLastDrawn() {
        return aLastDrawn.get();
    }

    public void addObserver(DeckObserver2 pObserver) {
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
        for (DeckObserver2 observer : aObservers) {
            observer.shuffled(this);
        }
    }

    public void push(Card pCard) {
        assert pCard != null;
        aCards.add(pCard);
        for (DeckObserver2 observer : aObservers) {
            observer.cardPushed(this);
        }
    }

    public Card draw() {
        assert !isEmpty();
        Card card = aCards.remove(aCards.size() - 1);
        aLastDrawn = Optional.of(card);
        for (DeckObserver2 observer : aObservers) {
            observer.cardDrawn(this);
        }
        return card;
    }

    @Override
    public boolean isEmpty() {
        return aCards.isEmpty();
    }

    @Override
    public List<Card> getCards() {
        return Collections.unmodifiableList(aCards);
    }
}