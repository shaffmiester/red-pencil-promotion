package com.shaffer;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Date;
/**
 * Created by Joel on 2/20/16.
 */
@RunWith(MockitoJUnitRunner.class)
public class ProductTest {

    @Mock
    RedPencilPromoter mockRedPencilPromoter;

    public static Double INITIAL_PRICE = Double.valueOf("10.00");
    private Product product;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        product = new Product(INITIAL_PRICE, mockRedPencilPromoter);
    }


    @Test
    public void hasAConstructorThatAllowsYouToSetThePrice(){
        assertEquals(INITIAL_PRICE, product.getPrice());
    }

    @Test
    public void allowsYouToSetThePrice(){
        Double newPrice = Double.valueOf("15.00");

        product.setPrice(newPrice);

        assertEquals(newPrice, product.getPrice());

    }

    @Test
    public void priceChageDateGetsSetWhenCreated() throws Exception{
        assertNotNull(product.getPriceChangedDate());

        Thread.sleep(1000);
        assertTrue(product.getPriceChangedDate().before(new Date()));
    }

    @Test
    public void priceChageDateGetsSetWhenThePriceIsChanged() throws Exception{
        Date originalDate = new Date();

        Date initialPriceChangeDate = product.getPriceChangedDate();
        Thread.sleep(1000);
        product.setPrice(new Double(8.00));
        Date updatedPriceChangeDate = product.getPriceChangedDate();

        assertTrue(initialPriceChangeDate.before(updatedPriceChangeDate));
    }


    @Test
    public void setPriceDelegatesToRedPencilPromoterToSeeIfQualifesForThePromotions(){
        product.setPrice(new Double(8.00));

        verify(mockRedPencilPromoter, times(1)).qualifiesForPromotion(product, new Double("8.00"));
    }





}