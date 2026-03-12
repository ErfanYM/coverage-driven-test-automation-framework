package com.github.pedrovgs.problem47;

import org.junit.Before;
import org.junit.Test;
import org.junit.runners.model.TestTimedOutException;

import java.util.List;
import java.util.Arrays;

import static org.junit.Assert.*;


public class ReturnChangeManualTest {
    private ReturnChange returnChange;

    @Before
    public void setup(){
        returnChange = new ReturnChange();
    }

    @Test(expected = IllegalArgumentException.class)
    public void NotAcceptNegativeAmount() {
        returnChange.calculate(new int[]{1, 2, 5}, -10);
    }
//
//    // Expected to hang due to missing exit condition in original implementation.
//    // Timeout forces exit and exposes algorithmic bug.
//    @Test(timeout = 500, expected = TestTimedOutException.class)
//    public void shouldReturnEmptyListAllCoinsTooLarge() {
//        int[] coins = {10, 20, 50};
//        returnChange.calculate(coins, 5);
//    }
    @Test
    public void skipsLargeCoinsAndUsesSmallerOnes() {
        int[] moneys = {1, 5, 10};
        int billAmount = 6;

        List<Integer> result = returnChange.calculate(moneys, billAmount);

        assertEquals(Arrays.asList(5, 1), result);
    }
    @Test
    public void giveNormalChange() {
        int[] moneys = {1, 2, 5, 10};
        int billAmount = 18;

        List<Integer> result = returnChange.calculate(moneys, billAmount);

        assertEquals(Arrays.asList(10, 5, 2, 1), result);
    }
}
