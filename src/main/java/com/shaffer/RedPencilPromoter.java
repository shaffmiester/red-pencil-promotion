package com.shaffer;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Joel on 2/20/16.
 */
public class RedPencilPromoter {

    private boolean isARedPencilPromotion;
    private Date promotionStartDate;
    private Date creationDate = new Date();

      public void calculateRedPencilPromtionQualification(Product product, Double newPrice){
          Double originalPrice = product.getPrice();
          isARedPencilPromotion = discountIsAtLeast5Percent(originalPrice, newPrice) && discountIsAtMostIs30Percent(originalPrice, newPrice)
                  && priceChangedDateAtLeast30DaysAgo(product);
          if(isARedPencilPromotion){
              promotionStartDate = new Date();
          }
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

    public Date getPromotionStartDate(){
        return promotionStartDate;
    }

      public boolean isARedPencilPromotion(){
          return isARedPencilPromotion;
      }

      protected GregorianCalendar getCurrentDate(){
            return new GregorianCalendar();
      }

}
