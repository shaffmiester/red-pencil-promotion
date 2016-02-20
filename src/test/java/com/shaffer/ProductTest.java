package com.shaffer;

import org.junit.Test;

import static org.junit.Assert.*;

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

}