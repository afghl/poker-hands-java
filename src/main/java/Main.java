import entities.Hand;
import org.junit.Assert;

/**
 * Created by afghl on 16/11/21.
 */
public class Main {
    public static void main(String[] args) {
        Hand h1 = Hand.createHand("2H 2H 2H 2D 5H");
        h1.pattern();
    }
}
