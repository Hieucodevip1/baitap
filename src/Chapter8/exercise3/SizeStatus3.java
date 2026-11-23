package Chapter8.exercise3;

import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class SizeStatus3 implements Observer {
    @Override
    public void update(Observable pDeck, Object pEvent) {
        System.out.println(((ObservableDeck3) pDeck).getCards().size());
    }
}