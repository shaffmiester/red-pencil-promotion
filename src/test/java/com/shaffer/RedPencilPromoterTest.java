package com.shaffer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

/**
 * Created by Joel on 2/20/16.
 */
public class RedPencilPromoterTest {

    private RedPencilPromoter redPencilPromoter = new RedPencilPromoter();
    private static GregorianCalendar thirtyDaysInThePast = new GregorianCalendar();
    private GregorianCalendar today = new GregorianCalendar();
    private static Double TEN_DOLLARS = Double.valueOf(10.00);

    static{
        thirtyDaysInThePast.add(GregorianCalendar.DATE, - 30);
    }

    Product testProduct;

    @Before
    public void setUp() throws Exception {
        testProduct = new ProductTester(TEN_DOLLARS);
        testProduct.setSetRedPencilPromoter(redPencilPromoter);
        ((ProductTester) testProduct).setAdjustedDate(thirtyDaysInThePast.getTime());
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void qualifiesForPromotionReturnsFaseIfTheSameValueIsPassedIn(){
        boolean result = redPencilPromoter.qualifiesForPromotion(testProduct, Double.valueOf(TEN_DOLLARS));

        assertFalse(result);
    }

    @Test
    public void qualifiesForPromotionReturnsTrueIfnewPriceIsExactly5PercentLower(){
        boolean result = redPencilPromoter.qualifiesForPromotion(testProduct, Double.valueOf(9.50));

        assertTrue(result);
    }

    @Test
    public void qualifiesForPromotionReturnsFalseIfnewPriceOneCentLessThan5PercentLower(){
        boolean result = redPencilPromoter.qualifiesForPromotion(testProduct, Double.valueOf(9.51));

        assertFalse(result);
    }

    @Test
    public void qualifiesForPromotionReturnsFalseIfTheNewPriceIsGreaterThan30PercentLower(){
        boolean result = redPencilPromoter.qualifiesForPromotion(testProduct, Double.valueOf(6.99));

        assertFalse(result);
    }

    @Test
    public void qualifiesForPromotionReturnsTrueIfTheNewPriceIsExactly30PercentLower(){
        boolean result = redPencilPromoter.qualifiesForPromotion(testProduct, Double.valueOf(7.00));

        assertTrue(result);
    }

    @Test
    public void qualifiesForPromotionReturnsFaleIfTheNewDateIsTheSameDateAsTheOriginalPriceChangedDate(){
        setTestProductTestDays(testProduct, 0);

        boolean result = redPencilPromoter.qualifiesForPromotion(testProduct, ProductTest.INITIAL_PRICE * .90);

        assertFalse(result);
    }


    private void setTestProductTestDays(Product product, int days){
        GregorianCalendar cal = new GregorianCalendar();
        cal.add(GregorianCalendar.DATE, days);

        ((ProductTester) product).setAdjustedDate(cal.getTime());
    }

    private class ProductTester extends Product {

        private ProductTester(Double price){
            super(price);
        }

        private GregorianCalendar adjustedDate;


        private void setAdjustedDate(Date adjustedDate){
            this.priceChangedDate = adjustedDate;
        }

    }




}