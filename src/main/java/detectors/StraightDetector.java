package detectors;

import entities.Hand;

/**
 * Created by afghl on 16/11/22.
 */
public class StraightDetector extends BaseDetector implements Detector<Hand> {
    boolean condition(Hand h) {
        return h.isStraight();
    }

    Hand compare(Hand h1, Hand h2) {
        int v1 = h1.getValues().get(0);
        int v2 = h2.getValues().get(0);
        if (v1 > v2)
            return h1;
        else if (v1 < v2)
            return h2;
        else
            return null;
    }
}
