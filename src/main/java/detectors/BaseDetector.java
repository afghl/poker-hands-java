package detectors;

import entities.Hand;

public abstract class BaseDetector implements Detector<Hand> {
    private Detector<Hand> successor;

    public Hand judge(Hand h1, Hand h2) {
        if (condition(h1) && condition(h2)) {
            return compare(h1, h2);
        } else if (condition(h1) && !condition(h2)) {
            return h1;
        } else if (!condition(h1) && condition(h2)) {
            return h2;
        } else {
            return successor.judge(h1, h2);
        }
    }

    abstract boolean condition(Hand h2);

    abstract Hand compare(Hand h1, Hand h2);
}
