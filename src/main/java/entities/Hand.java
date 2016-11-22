package entities;

import java.util.*;

public class Hand {
    private final static String VALUE_ORDER = "23456789TJQKA";

    private List<Integer> values = new ArrayList<Integer>();

    private Set<Character> types = new HashSet<Character>();

    private List<Card> cards = new ArrayList<Card>();

    private Hand() {}

    public static Hand createHand(String args) {
        Hand h = new Hand();
        String[] cards = args.split(" ");
        for (String c : cards)
            h.addCard(c);

        Collections.sort(h.values);

        return h;
    }

    public List<Integer> getValues() {
        return values;
    }

    public boolean isStraightFlush() {
        return types.size() == 1 && consecutiveValues();
    }

    public boolean isFourOfKind() {
        SortedSet<Integer> valueSet = new TreeSet<Integer>(values);

        return valueSet.size() == 2 &&
                Collections.frequency(values, valueSet.first()) == 1 ||
                Collections.frequency(values, valueSet.first()) == 4;
    }

    public boolean isFullHouse() {
        SortedSet<Integer> valueSet = new TreeSet<Integer>(values);

        return valueSet.size() == 2 &&
                Collections.frequency(values, valueSet.first()) == 2 ||
                Collections.frequency(values, valueSet.first()) == 3;

    }

    public boolean isFlush() {
        return types.size() == 1;
    }

    public String pattern() {
        SortedSet<Integer> valueSet = new TreeSet<Integer>(values);

        if (isStraightFlush()) {
            return "Straight Flush";
        } else if (isFourOfKind()) {
            return "Four of a Kind";
        } else if (isFullHouse()) {
            return "Full House";
        } else if (types.size() == 1) {
            return "Flush";
        } else if (threeOfKind(valueSet)) {
            return "Three of a Kind";
        } else {
            return detectPairs(valueSet);
        }
    }

    private String detectPairs(SortedSet valueSet) {
        if (valueSet.size() == 3)
            return "Two Pairs";
        else if (values.size() == 4)
            return "Pairs";
        else
            return "High Card";
    }

    private boolean threeOfKind(SortedSet<Integer> valueSet) {
        for (int v : valueSet) {
            if (Collections.frequency(values, v) > 0)
                return true;
        }
        return false;
    }

    private boolean consecutiveValues() {
        for (int i = 1; i < values.size(); i++) {
            if (values.get(i) - values.get(i - 1) != 1)
                return false;
        }
        return true;
    }

    private void addCard(String c) {
        char type = c.charAt(1);
        int value = VALUE_ORDER.indexOf(c.charAt(0));

        types.add(type);
        values.add(value);
//        cards.add(new Card(value, type));
    }
}
