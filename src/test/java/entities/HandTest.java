package entities;

import org.junit.Assert;
import org.junit.Test;

public class HandTest {

    @Test
    public void test_can_create_hands() {
        Assert.assertNotNull(Hand.createHand("2H 3D 5S 9C KD"));
    }

//    @Test
//    public void can_detect_straight_flush() {
//        Hand h1 = Hand.createHand("2H 4H 3H 6H 5H");
//        Hand h2 = Hand.createHand("2H 3D 4S 5C 6D");
//        Assert.assertEquals("Straight Flush", h1.pattern());
//        Assert.assertNotEquals("Straight Flush", h2.pattern());
//    }
//
//    @Test
//    public void can_detect_four_of_kind() {
//        Hand h1 = Hand.createHand("2H 2H 2H 2D 5H");
//        Hand h2 = Hand.createHand("2H 3D 4S 5C 6D");
//        Assert.assertEquals("Four of a Kind", h1.pattern());
//        Assert.assertNotEquals("Four of a Kind", h2.pattern());
//    }


}
