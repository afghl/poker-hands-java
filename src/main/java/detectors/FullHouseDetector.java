package detectors;

import entities.Hand;

import java.util.Collections;
import java.util.List;

public class FullHouseDetector extends BaseDetector implements Detector<Hand> {
    boolean condition(Hand h) {
        return h.isFullHouse();
    }

    Hand compare(Hand h1, Hand h2) {
        int v1 = getRankValue(h1);
        int v2 = getRankValue(h2);

        if (v1 == -1 || v2 == -1) throw new RuntimeException("exception in full house");
        if (v1 > v2) return h1;
        else if (v1 < v2) return h2;
        return null;
    }

    private int getRankValue(Hand h) {
        List<Integer> values = h.getValues();
        for (int i = 0; i < values.size(); i++) {
            if (Collections.frequency(values, values.get(i)) == 3)
                return values.get(i);
        }
        return -1;
    }
}

