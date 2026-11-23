package Chapter8.exercise3;

import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class DrawLogger3 implements Observer {
    @Override
    public void update(Observable pDeck, Object pEvent) {
        DeckChangeEvent event = (DeckChangeEvent) pEvent;
        if (event.getChangeType() == DeckChangeType.CARD_DRAWN) {
            System.out.println(event.getCard().get() + " drawn");
        }
    }
}