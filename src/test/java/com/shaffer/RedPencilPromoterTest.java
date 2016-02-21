package com.shaffer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Joel on 2/20/16.
 */
public class RedPencilPromoterTest {

    private RedPencilPromoter redPencilPromoter = new RedPencilPromoter();

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void qualifiesForPromotionReturnsFaseIfTheSameValueIsPassedIn(){
        Product product = new Product(Double.valueOf(15.00));

        boolean result = redPencilPromoter.qualifiesForPromotion(product, Double.valueOf(15.00));

        assertFalse(result);
    }

    @Test
    public void qualifiesForPromotionReturnsTrueIfAPriceIs5PercentLower(){
        Product product = new Product(Double.valueOf(10.00));

        boolean result = redPencilPromoter.qualifiesForPromotion(product, Double.valueOf(9.50));

        assertTrue(result);
    }
}