package Chapter8.exercise4;

public class DrawLogger1 implements DeckObserver1 {
    @Override
    public void shuffled() {}

    @Override
    public void cardDrawn(Card pCard) {
        System.out.println(pCard + " drawn");
    }

    @Override
    public void cardPushed(Card pCard) {}
}