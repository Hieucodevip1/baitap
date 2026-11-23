package Chapter8.exercise4;

public interface DeckObserver1 {
    void shuffled();
    void cardDrawn(Card pCard);
    void cardPushed(Card pCard);
}