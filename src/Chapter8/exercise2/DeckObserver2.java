package Chapter8.exercise2;

public interface DeckObserver2 {
    void shuffled(DeckView pDeckView);
    void cardDrawn(DeckView pDeckView);
    void cardPushed(DeckView pDeckView);
}