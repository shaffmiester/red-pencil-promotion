package com.shaffer;

import java.util.Date;

/**
 * Created by Joel on 2/20/16.
 */
public class Product {

    private Double price;
    private Date priceChangedDate;

    public Product(Double price){
        setPrice(price);
    }

    public Double getPrice(){
        return this.price;
    }

    public void setPrice(double price){
        priceChangedDate = new Date();
        this.price = price;
    }

    public Date getPriceChangedDate(){
        return (Date) priceChangedDate.clone();
    }
}
