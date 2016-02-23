package com.shaffer;

import java.util.Date;

/**
 * Created by Joel on 2/20/16.
 */
public class Product {

    private Double price;
    protected Date priceChangedDate;
    private RedPencilPromoter setRedPencilPromoter;

    public Product(){};

    public Product(Double price){
        setPrice(price);
    }

    public Double getPrice(){
        return this.price;
    }

    public void setPrice(double price){
        priceChangedDate = new Date();
        if(setRedPencilPromoter != null){
            setRedPencilPromoter.qualifiesForPromotion(this, price);
        }
        this.price = price;
    }

    public Date getPriceChangedDate(){
        return (Date) priceChangedDate.clone();
    }

    public void setSetRedPencilPromoter(RedPencilPromoter redPencilPromoter){
        this.setRedPencilPromoter = redPencilPromoter;
    }
}
