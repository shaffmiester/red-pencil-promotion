package com.shaffer;

import org.junit.Test;

import static org.junit.Assert.*;
import java.util.Date;
/**
 * Created by Joel on 2/20/16.
 */
public class ProductTest {



    Double initialPrice = Double.valueOf("10.00");

    @Test
    public void hasAConstructorThatAllowsYouToSetThePrice(){
        Product product = new Product(initialPrice);

        assertEquals(initialPrice, product.getPrice());
    }

    @Test
    public void allowsYouToSetThePrice(){
        Double newPrice = Double.valueOf("15.00");
        Product product = new Product(initialPrice);

        product.setPrice(newPrice);

        assertEquals(newPrice, product.getPrice());

    }

    @Test
    public void priceChageDateGetsSetWhenCreated() throws Exception{
        Product product = new Product(initialPrice);

        assertNotNull(product.getPriceChangedDate());

        Thread.sleep(1000);
        assertTrue(product.getPriceChangedDate().before(new Date()));
    }

    @Test
    public void priceChageDateGetsSetWhenThePriceIsChanged() throws Exception{
        Date originalDate = new Date();

        Product product = new Product(initialPrice);
        Date initialPriceChangeDate = product.getPriceChangedDate();
        Thread.sleep(1000);
        product.setPrice(new Double(8.00));
        Date updatedPriceChangeDate = product.getPriceChangedDate();

        assertTrue(initialPriceChangeDate.before(updatedPriceChangeDate));
    }



}