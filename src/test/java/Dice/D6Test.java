package Dice;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class D6Test {

    @Test
    public void test_roll_returns_1_to_20() {
        D6 dice = new D6();
        boolean success = true;
        for (int i = 0; i < 100; i++) {
            int roll = dice.roll();

            if (roll < 1 || roll > 20) success = false;
        }
        assertTrue(success);
    }

}