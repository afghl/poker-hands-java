package entities;

import org.junit.Assert;
import org.junit.Test;

public class HandTest {

    @Test
    public void test_can_create_hands() {
        Assert.assertNotNull(Hand.createHand("2H 3D 5S 9C KD"));
    }

    @Test
    public void test_can_get_highest_value() {
        Hand h1 = Hand.createHand("2H 3D 5S 9C KD");
        Hand h2 = Hand.createHand("5H 2D AS TC JD");
        Assert.assertEquals(h1.highestCard(), 'K');
        Assert.assertEquals(h2.highestCard(), 'A');
    }


}
