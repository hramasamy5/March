package com.hema.cart;
import java.math.BigDecimal;

interface SpecialOffer {
    BigDecimal applyOffer(int quantity, BigDecimal price);
}