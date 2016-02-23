package com.shaffer;

import java.util.Date;

/**
 * Created by Joel on 2/20/16.
 */
public class Product {

    private Double price;
    protected Date priceChangedDate;
    private RedPencilPromoter redPencilPromoter;

    public Product(Double price, RedPencilPromoter redPencilPromoter){
        setRedPencilPromoter(redPencilPromoter);
        setPrice(price);
    }

    public Double getPrice(){
        return this.price;
    }

    public void setPrice(double price){
        priceChangedDate = new Date();
        this.price = price;
        redPencilPromoter.calculateRedPencilPromtionQualification(this, price);

    }

    public Date getPriceChangedDate(){
        return (Date) priceChangedDate.clone();
    }

    public void setRedPencilPromoter(RedPencilPromoter redPencilPromoter){
        if(redPencilPromoter == null){
            throw new IllegalArgumentException("redPencilPromoter: Cannot be null");
        }
        this.redPencilPromoter = redPencilPromoter;
    }
}
