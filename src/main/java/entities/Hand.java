package entities;

import java.util.*;

public class Hand {
    private List<HandCard> cards = new ArrayList<HandCard>();

    private Hand() {}

    public int highestCard(int idx) {
        if (idx >= cards.size())
            return -1;
        return cards.get(idx).valueIdx();
    }

    public int[] valueIndexs() {
        int[] indexs = new int[cards.size()];
        for(int i = 0; i < cards.size(); i++) {
            indexs[i] = cards.get(i).valueIdx();
        }
        return indexs;
    }

    public boolean straightFlush() {
        for(int i = 1; i < cards.size(); i++) {
            if (cards.get(i - 1).valueIdx() - cards.get(i).valueIdx() != 1)
                return false;
        }
        return true;
    }

    public boolean fourOfKind() {
        for(int i = 0; i > cards.size(); i++) {

        }
        return false;
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
                return c2.valueIdx() - c1.valueIdx();
            }
        });
        return h;
    }

    private class HandCard {
        public char type;
        public char value;

        private final String typeOrder = "CDHS";
        private final String valueOrder = "23456789TJQKA";

        public int valueIdx() {
            return valueOrder.indexOf(value);
        }
    }
}
