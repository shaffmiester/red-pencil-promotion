package com.shaffer;

import org.junit.Test;

import static org.junit.Assert.*;
import java.util.Date;
/**
 * Created by Joel on 2/20/16.
 */
public class ProductTest {



    public static Double INITIAL_PRICE = Double.valueOf("10.00");

    @Test
    public void hasAConstructorThatAllowsYouToSetThePrice(){
        Product product = new Product(INITIAL_PRICE);

        assertEquals(INITIAL_PRICE, product.getPrice());
    }

    @Test
    public void allowsYouToSetThePrice(){
        Double newPrice = Double.valueOf("15.00");
        Product product = new Product(INITIAL_PRICE);

        product.setPrice(newPrice);

        assertEquals(newPrice, product.getPrice());

    }

    @Test
    public void priceChageDateGetsSetWhenCreated() throws Exception{
        Product product = new Product(INITIAL_PRICE);

        assertNotNull(product.getPriceChangedDate());

        Thread.sleep(1000);
        assertTrue(product.getPriceChangedDate().before(new Date()));
    }

    @Test
    public void priceChageDateGetsSetWhenThePriceIsChanged() throws Exception{
        Date originalDate = new Date();

        Product product = new Product(INITIAL_PRICE);
        Date initialPriceChangeDate = product.getPriceChangedDate();
        Thread.sleep(1000);
        product.setPrice(new Double(8.00));
        Date updatedPriceChangeDate = product.getPriceChangedDate();

        assertTrue(initialPriceChangeDate.before(updatedPriceChangeDate));
    }





}