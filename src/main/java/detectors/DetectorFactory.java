package detectors;

import entities.Hand;

public abstract class DetectorFactory {
    private DetectorFactory() {}

    public static Detector<Hand> create() {
        return new StraightFlushDetector()
                .setSuccessor(new FourOfKindDetector());
    }
}
