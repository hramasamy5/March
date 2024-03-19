package com.hema.cart;
import java.math.BigDecimal;

interface PricingStrategy {
    BigDecimal calculatePrice(int quantity, BigDecimal price);
}