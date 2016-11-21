package detect;

import entities.Hand;


public class StraightFlushDetector implements Detector {
    public Hand judge(Hand h1, Hand h2) {
        if (isStraightFlush(h1) && !isStraightFlush(h2)) {
            return h1;
        } else if (!isStraightFlush(h1) && isStraightFlush(h2)) {
            return h2;
        } else if (isStraightFlush(h1) && isStraightFlush(h2)) {
            return compareHighestCard(h1, h2);
        } else {
//            交给successor
            return null;
        }
    }

    private Hand compareHighestCard(Hand h1, Hand h2) {
        int i = 0;

        do {
            if (h1.highestCard(i) > h2.highestCard(i))
                return h1;
            else if (h1.highestCard(i) < h2.highestCard(i))
                return h2;
            else
                i++;
        } while (h1.highestCard(i) != -1 && h2.highestCard(i) != -1);

        return null;
    }

    private boolean isStraightFlush(Hand h) {
        int[] idxs = h.valueIndexs();

        for (int i = 1; i < idxs.length; i++) {
            if (idxs[i - 1] - idxs[i] != 1)
                return false;
        }
        return true;
    }
}
