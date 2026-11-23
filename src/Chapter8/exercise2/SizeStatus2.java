package Chapter8.exercise2;

public class SizeStatus2 implements DeckObserver2 {
    @Override
    public void shuffled(DeckView pDeckView) {
        System.out.println(pDeckView.size());
    }

    @Override
    public void cardDrawn(DeckView pDeckView) {
        System.out.println(pDeckView.size());
    }

    @Override
    public void cardPushed(DeckView pDeckView) {
        System.out.println(pDeckView.size());
    }
}