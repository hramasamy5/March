package com.hema.cart;
import java.math.BigDecimal;

class ThreeForPriceOfTwo implements SpecialOffer {
    @Override
    public BigDecimal applyOffer(int quantity, BigDecimal price) {
        int groups = quantity / 3;
        int remaining = quantity % 3;
        return BigDecimal.valueOf(groups * 2 + remaining).multiply( price);
    }
   
    @Override
    public String toString() {
    return "ThreeForPriceOfTwo";
    }
}