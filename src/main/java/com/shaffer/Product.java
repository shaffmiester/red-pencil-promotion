package com.shaffer;

import java.util.Date;

/**
 * Created by Joel on 2/20/16.
 */
public class Product {

    private Double price;
    protected Date priceChangedDate;
    private RedPencilPromoter redPencilPromoter;

    public Product(){};

    public Product(Double price, RedPencilPromoter redPencilPromoter){
        setPrice(price);
        setRedPencilPromoter(redPencilPromoter);

    }

    public Double getPrice(){
        return this.price;
    }

    public void setPrice(double price){
        priceChangedDate = new Date();
        if(redPencilPromoter != null){
            redPencilPromoter.calculateRedPencilPromtionQualification(this, price);
        }
        this.price = price;
    }

    public Date getPriceChangedDate(){
        return (Date) priceChangedDate.clone();
    }

    public void setRedPencilPromoter(RedPencilPromoter redPencilPromoter){
        this.redPencilPromoter = redPencilPromoter;
    }
}
