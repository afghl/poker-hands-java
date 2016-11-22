package detectors;

import entities.Hand;
import org.junit.Assert;
import org.junit.Test;

public class DetectorTest {

    @Test
    public void detector_can_detect_straight_flush() {
        Hand h1 = Hand.createHand("2H 4H 3H 6H 5H");
        Hand h2 = Hand.createHand("2H 3D 4S 5C 6D");
        Detector<Hand> d = DetectorFactory.create();
        Hand winner = d.judge(h1, h2);
        Assert.assertEquals(winner, h1);
    }

    @Test
    public void detector_can_detect_two_starght_flush() {
        Hand h1 = Hand.createHand("2H 4H 3H 6H 5H");
        Hand h2 = Hand.createHand("1H 4H 3H 5H 2H");
        Detector<Hand> d = DetectorFactory.create();
        Hand winner = d.judge(h1, h2);
        Assert.assertEquals(winner, h1);
    }

    @Test
    public void detector_can_detect_tie() {
        Hand h1 = Hand.createHand("2H 4H 3H 6H 5H");
        Hand h2 = Hand.createHand("6H 4H 3H 5H 2H");
        Detector<Hand> d = DetectorFactory.create();
        Hand winner = d.judge(h1, h2);
        Assert.assertEquals(winner, null);
    }
}
