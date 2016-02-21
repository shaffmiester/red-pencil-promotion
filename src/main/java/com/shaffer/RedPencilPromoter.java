package com.shaffer;

/**
 * Created by Joel on 2/20/16.
 */
public class RedPencilPromoter {

      public boolean qualifiesForPromotion(Product product, Double newPrice){
          boolean returnValue = (product.getPrice() * 0.95) >= newPrice;
          return returnValue;
      }

}
