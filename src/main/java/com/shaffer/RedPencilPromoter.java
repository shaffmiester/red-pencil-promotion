package com.shaffer;

/**
 * Created by Joel on 2/20/16.
 */
public class RedPencilPromoter {

      public boolean qualifiesForPromotion(Product product, Double newPrice){
          Double originalPrice = product.getPrice();
          return discountIsAtLeast5Percent(originalPrice, newPrice) && discountIsAtMostIs30Percent(originalPrice, newPrice);
      }

      private boolean discountIsAtLeast5Percent(Double originalPrice, Double newPrice){
          return (originalPrice * 0.95) >= newPrice;
      }

    private boolean discountIsAtMostIs30Percent(Double originalPrice, Double newPrice){
        return (originalPrice * 0.7) <= newPrice;
    }

}
