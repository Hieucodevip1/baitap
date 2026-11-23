package Chapter8.exercise1;

public class SizeStatus1 implements DeckObserver1 {
    private int aSize = -1;

    @Override
    public void shuffled() {
        aSize = 52;
        System.out.println(aSize);
    }

    @Override
    public void cardDrawn(Card pCard) {
        if (aSize >= 0) {
            aSize--;
            System.out.println(aSize);
        } else {
            System.out.println("Size unknown");
        }
    }

    @Override
    public void cardPushed(Card pCard) {
        if (aSize >= 0) {
            aSize++;
            System.out.println(aSize);
        } else {
            System.out.println("Size unknown");
        }
    }
}