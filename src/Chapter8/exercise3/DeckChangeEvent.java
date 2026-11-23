package Chapter8.exercise3;

import java.util.Optional;

public class DeckChangeEvent {
    private final DeckChangeType aChangeType;
    private final Optional<Card> aCard;

    public DeckChangeEvent(DeckChangeType pType) {
        aChangeType = pType;
        aCard = Optional.empty();
    }

    public DeckChangeEvent(DeckChangeType pType, Card pCard) {
        aChangeType = pType;
        aCard = Optional.of(pCard);
    }

    public DeckChangeType getChangeType() {
        return aChangeType;
    }

    public Optional<Card> getCard() {
        return aCard;
    }
}