package com.shaffer;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Joel on 2/20/16.
 */
public class ProductTest {

    @Test
    public void hasAConstructorThatAllowsYouToSetThePrice(){
        Double price = Double.valueOf("10.00");

        Product product = new Product(price);

        assertEquals(price, product.getPrice());
    }

}