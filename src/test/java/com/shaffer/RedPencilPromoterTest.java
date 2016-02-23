package com.shaffer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

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
        testProduct = new ProductTester(TEN_DOLLARS, redPencilPromoter);
        ((ProductTester) testProduct).setAdjustedDate(thirtyDaysInThePast.getTime());
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void qualifiesForPromotionReturnsFaseIfTheSameValueIsPassedIn(){
        redPencilPromoter.calculateRedPencilPromtionQualification(testProduct, Double.valueOf(TEN_DOLLARS));

        assertFalse(redPencilPromoter.isARedPencilPromotion());
    }

    @Test
    public void qualifiesForPromotionReturnsTrueIfnewPriceIsExactly5PercentLower(){
        redPencilPromoter.calculateRedPencilPromtionQualification(testProduct, Double.valueOf(9.50));

        assertTrue(redPencilPromoter.isARedPencilPromotion());
    }

    @Test
    public void qualifiesForPromotionReturnsFalseIfnewPriceOneCentLessThan5PercentLower(){
        redPencilPromoter.calculateRedPencilPromtionQualification(testProduct, Double.valueOf(9.51));

        assertFalse(redPencilPromoter.isARedPencilPromotion());
    }

    @Test
    public void qualifiesForPromotionReturnsFalseIfTheNewPriceIsGreaterThan30PercentLower(){
        redPencilPromoter.calculateRedPencilPromtionQualification(testProduct, Double.valueOf(6.99));

        assertFalse(redPencilPromoter.isARedPencilPromotion());
    }

    @Test
    public void qualifiesForPromotionReturnsTrueIfTheNewPriceIsExactly30PercentLower(){
        redPencilPromoter.calculateRedPencilPromtionQualification(testProduct, Double.valueOf(7.00));

        assertTrue(redPencilPromoter.isARedPencilPromotion());
    }

    @Test
    public void qualifiesForPromotionReturnsFalseIfTheNewDateIsTheSameDateAsTheOriginalPriceChangedDate(){
        setTestProductTestDays(testProduct, 0);

        redPencilPromoter.calculateRedPencilPromtionQualification(testProduct, ProductTest.INITIAL_PRICE * .90);

        assertFalse(redPencilPromoter.isARedPencilPromotion());
    }

    Timer timer;

    @Test
    public void timerTesting() throws InterruptedException{
        new Reminder(2);

        System.out.println("Task started at: " + new Date());

        Thread.sleep(3000);

        //org.mockito.internal.util.Timer
    }


    public class Reminder {
        Timer timer;

        public Reminder(int seconds){
            timer = new Timer();
            timer.schedule(new RemindMeTask(), seconds * 1000);
        }


        private class RemindMeTask extends TimerTask {

            @Override
            public void run() {
                System.out.println("Task Completed at: " + new Date());
                timer.cancel();
            }

        }
    }



    @Test
    public void isARedPencilPromotionReturnsFalseIfTheProductDoesNotQualifyForAPromotion(){
        setTestProductTestDays(testProduct, 0);

        redPencilPromoter.calculateRedPencilPromtionQualification(testProduct, ProductTest.INITIAL_PRICE * .90);

        assertFalse(redPencilPromoter.isARedPencilPromotion());
    }

    @Test
    public void isARedPencilPromotionReturnsTrueIfTheProductDoesQualifyForAPromotion(){
        redPencilPromoter.calculateRedPencilPromtionQualification(testProduct, ProductTest.INITIAL_PRICE * .90);

        assertTrue(redPencilPromoter.isARedPencilPromotion());
    }


    private void setTestProductTestDays(Product product, int days){
        GregorianCalendar cal = new GregorianCalendar();
        cal.add(GregorianCalendar.DATE, days);

        ((ProductTester) product).setAdjustedDate(cal.getTime());
    }

    private class ProductTester extends Product {

        private ProductTester(Double price, RedPencilPromoter redPencilPromoter){
            super(price, redPencilPromoter);
        }

        private GregorianCalendar adjustedDate;


        private void setAdjustedDate(Date adjustedDate){
            this.priceChangedDate = adjustedDate;
        }

    }




}