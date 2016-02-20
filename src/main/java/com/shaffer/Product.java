package com.shaffer;

/**
 * Created by Joel on 2/20/16.
 */
public class Product {

    private Double price;

    public Product(Double price){
        this.price = price;
    }

    public Double getPrice(){
        return this.price;
    }

    public void setPrice(double price){
        this.price = price;
    }
}
