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

    @Test
    public void can_detect_four_of_kind() {
        Hand h1 = Hand.createHand("2H 2H 2H 2D 5H");
        Hand h2 = Hand.createHand("2H 3D 4S 5C 6D");
        Detector<Hand> d = DetectorFactory.create();
        Hand winner = d.judge(h1, h2);
        Assert.assertEquals(winner, h1);
    }

    @Test
    public void can_detect_same_four_of_kind() {
        Hand h1 = Hand.createHand("2H 2H 2H 2D 5H");
        Hand h2 = Hand.createHand("4H 4D 4S 4C 6D");
        Detector<Hand> d = DetectorFactory.create();
        Hand winner = d.judge(h1, h2);
        Assert.assertEquals(winner, h2);
    }

    @Test
    public void can_detect_full_house() {
        Hand h1 = Hand.createHand("2H 2H 2H 4D 5H");
        Hand h2 = Hand.createHand("3H 3D 3S 4C 6D");
        Detector<Hand> d = DetectorFactory.create();
        Hand winner = d.judge(h1, h2);
        Assert.assertEquals(winner, h2);
    }
}
