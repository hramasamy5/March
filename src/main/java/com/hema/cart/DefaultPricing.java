package com.hema.cart;
import java.math.BigDecimal;

class DefaultPricing implements PricingStrategy {
    @Override
    public BigDecimal calculatePrice(int quantity, BigDecimal price) {
        return BigDecimal.valueOf(quantity).multiply( price);
    }
   
    @Override
    public String toString() {
    return "Default pricing";
    }
}