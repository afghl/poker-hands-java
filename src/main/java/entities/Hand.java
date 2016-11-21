package entities;

import java.util.*;

public class Hand {
    private List<HandCard> cards = new ArrayList<HandCard>();

    private Hand() {}

    public char highestCard() {
        return cards.get(0).value;
    }

    private void setCard(String c) {
        HandCard card = new HandCard();
        card.value = c.charAt(0);
        card.type = c.charAt(1);
        cards.add(card);
    }

    public static Hand createHand(String args) {
        Hand h = new Hand();
        String[] cards = args.split(" ");
        for (String c : cards)
            h.setCard(c);
        Collections.sort(h.cards, new Comparator<HandCard>() {
            public int compare(HandCard c1, HandCard c2) {
                return c2.valueOrder.indexOf(c2.value) - c1.valueOrder.indexOf(c1.value);
            }
        });
        return h;
    }

    private class HandCard {
        public char type;
        public char value;

        private final String typeOrder = "CDHS";
        private final String valueOrder = "23456789TJQKA";
    }

}
