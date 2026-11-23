package Chapter8.exercise2;

import java.util.List;

public interface DeckView {
    List<Card> getCards();
    boolean isEmpty();
    Card getLastDrawn();

    default int size() {
        return getCards().size();
    }
}