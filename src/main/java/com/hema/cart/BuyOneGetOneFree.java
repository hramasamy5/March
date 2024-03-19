package com.hema.cart;
import java.math.BigDecimal;

class BuyOneGetOneFree implements SpecialOffer {
    @Override
    public BigDecimal applyOffer(int quantity, BigDecimal price) {
        int pairs = quantity / 2;
        int singles = quantity % 2;
        return BigDecimal.valueOf(pairs + singles).multiply( price);
    }
   
    @Override
    public String toString() {
    return "BuyOneGetOneFree";
    }
}