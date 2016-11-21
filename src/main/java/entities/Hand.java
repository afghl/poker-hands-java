package entities;

import java.util.*;

public class Hand {
    private final static String VALUE_ORDER = "23456789TJQKA";

    private final static int CARDS_NUMBER = 5;

    private int[] values = new int[CARDS_NUMBER];

    private Set<Character> types = new HashSet<Character>();

    private List<Card> cards = new ArrayList<Card>();

    private int count = 0;

    private int highest = -1;

    private Hand() {}

    public static Hand createHand(String args) {
        Hand h = new Hand();
        String[] cards = args.split(" ");
        for (String c : cards)
            h.addCard(c);

        Arrays.sort(h.values);
        return h;
    }

    public String pattern() {
        if (types.size() == 1 && consecutiveValues()) {
            return "Straight Flush";
        } else if (fourOfKind()) {
            return "Four of a Kind";
        } else if (fullHouse()) {
            return "Full House";
        } else if (types.size() == 1 && !consecutiveValues()) {
            return "Straight";
        } else if (threeOfKind()) {
            return "Three of a Kind";
        } else if (twoPairs()) {
            return "Two Pairs";
        } else if (pair()) {
            return "Pair";
        } else {
            return "No Pattern";
        }
    }

    private boolean fullHouse() {
        int count;
        boolean canBeFullHouse = false;

        for (int i = 0; i < values.length; i++) {
            count = 0;
            for (int j = 0; j < values.length; j ++) {
                if (values[i] == values[j]) count++;
            }

            // TODO: this is a bug here.
            if (count == 3 && !canBeFullHouse) {
                highest = values[i];
                canBeFullHouse = true;
            } else if (count == 2 && canBeFullHouse) {
                return true;
            } else if (count == 2 && !canBeFullHouse) {
                canBeFullHouse = true;
            } else if (count == 3 && canBeFullHouse) {
                highest = values[i];
                return true;
            }
        }
        return false;
    }

    private boolean pair() {
        int count;

        for (int i = 0; i < values.length; i++) {
            count = 0;
            for (int j = 0; j < values.length; j ++) {
                if (values[i] == values[j]) count++;
            }

            if (count == 2) {
                highest = values[i];
                return true;
            }
        }
        return false;
    }

    private boolean twoPairs() {
        int count;
        boolean canBeTwoPair = false;

        for (int i = 0; i < values.length; i++) {
            count = 0;
            for (int j = 0; j < values.length; j ++) {
                if (values[i] == values[j]) count++;
            }

            if (count == 2 && !canBeTwoPair) {
                highest = values[i];
                canBeTwoPair = true;
            } else if (count == 2 && canBeTwoPair) {
                return true;
            }
        }
        return false;
    }

    private boolean threeOfKind() {
        int count;

        for (int i = 0; i < values.length; i++) {
            count = 0;
            for (int j = 0; j < values.length; j ++) {
                if (values[i] == values[j]) count++;
            }

            if (count == 3) {
                highest = values[i];
                return true;
            }
        }
        return false;
    }

    private boolean fourOfKind() {
        int count;

        for (int i = 0; i < values.length; i++) {
            count = 0;
            for (int j = 0; j < values.length; j ++) {
                if (values[i] == values[j]) count++;
            }

            if (count == 4) {
                highest = values[i];
                return true;
            }
        }
        return false;
    }

    private boolean consecutiveValues() {
        for (int i = 1; i < values.length; i++) {
            if (values[i] - values[i - 1] != 1)
                return false;
        }
        return true;
    }

    private void addCard(String c) {
        char type = c.charAt(1);
        int value = VALUE_ORDER.indexOf(c.charAt(0));

        types.add(type);
        values[count++] = value;
        cards.add(new Card(value, type));
    }
}
