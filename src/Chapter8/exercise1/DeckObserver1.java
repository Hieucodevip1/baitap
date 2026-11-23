package Chapter8.exercise1;

public interface DeckObserver1 {
    void shuffled();
    void cardDrawn(Card pCard);
    void cardPushed(Card pCard);
}