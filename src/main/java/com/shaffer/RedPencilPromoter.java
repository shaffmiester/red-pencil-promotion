package com.shaffer;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Joel on 2/20/16.
 */
public class RedPencilPromoter {

      public boolean qualifiesForPromotion(Product product, Double newPrice){
          Double originalPrice = product.getPrice();
          return discountIsAtLeast5Percent(originalPrice, newPrice) && discountIsAtMostIs30Percent(originalPrice, newPrice)
                  && priceChangedDateAtLeast30DaysAgo(product);
      }

      private boolean discountIsAtLeast5Percent(Double originalPrice, Double newPrice){
          return (originalPrice * 0.95) >= newPrice;
      }

      private boolean discountIsAtMostIs30Percent(Double originalPrice, Double newPrice){
          return (originalPrice * 0.7) <= newPrice;
      }

      private boolean priceChangedDateAtLeast30DaysAgo(Product product){
          GregorianCalendar thirtyDaysInThePast = getCurrentDate();
          thirtyDaysInThePast.add(GregorianCalendar.DATE, - 30);
          return product.getPriceChangedDate().before(thirtyDaysInThePast.getTime());
      }

      protected GregorianCalendar getCurrentDate(){
            return new GregorianCalendar();
      }

}
