package Chapter8.exercise2;

public class DrawLogger2 implements DeckObserver2 {
    @Override
    public void shuffled(DeckView pDeckView) {}

    @Override
    public void cardDrawn(DeckView pDeckView) {
        System.out.println(pDeckView.getLastDrawn() + " drawn");
    }

    @Override
    public void cardPushed(DeckView pDeckView) {}
}