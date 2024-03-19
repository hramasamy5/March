package com.hema.cart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.math.BigDecimal;
import static org.hamcrest.MatcherAssert.assertThat;
import org.hamcrest.Matchers;

public class ShoppingBasketTest {

    private PriceCalculator priceCalculator;
    private ShoppingBasket basket;

    @BeforeEach
    public void setUp() {
        priceCalculator = new PriceCalculator();
        basket = new ShoppingBasket(priceCalculator);
    }

    @Test
    public void testCalculateTotal_NoSpecialOffer() {
        // Add items to the basket
        basket.addItem("Apple");
        basket.addItem("Apple");
        basket.addItem("Banana");

        // Calculate total
        BigDecimal total = basket.calculateTotal();

        System.out.println(total);
        // Expected total: (2 * .35) + .20 = .90
       assertThat(BigDecimal.valueOf(0.90),  Matchers.comparesEqualTo(total));
        
    }

    @Test
    public void testCalculateTotal_BuyOneGetOneFree() {
        // Add items to the basket
        basket.addItem("Melon");
        basket.addItem("Melon");
        basket.addItem("Melon");

        // Calculate total
        BigDecimal total = basket.calculateTotal();

        // Expected total: 2 * .50 (buy one get one free) = 1.00
        assertThat(BigDecimal.valueOf(1.0),  Matchers.comparesEqualTo(total));
    }

    @Test
    public void testCalculateTotal_ThreeForPriceOfTwo() {
        // Add items to the basket
        basket.addItem("Lime");
        basket.addItem("Lime");
        basket.addItem("Lime");
        basket.addItem("Lime");

        // Calculate total
        BigDecimal total = basket.calculateTotal();

        // Expected total: (2 * .15) + .15 = .45
        assertThat(BigDecimal.valueOf(0.45),  Matchers.comparesEqualTo(total));
    }

    @Test
    public void testPriceCalculator() {
        Map<String, BigDecimal> itemPrices = priceCalculator.getItemPrices();

        // Verify item prices        
        assertThat(BigDecimal.valueOf(0.35),  Matchers.comparesEqualTo(itemPrices.get("Apple")));
        assertThat(BigDecimal.valueOf(0.20),  Matchers.comparesEqualTo(itemPrices.get("Banana")));        
        assertThat(BigDecimal.valueOf(0.50),  Matchers.comparesEqualTo(itemPrices.get("Melon")));        
        assertThat(BigDecimal.valueOf(0.15),  Matchers.comparesEqualTo(itemPrices.get("Lime")));
    }
    
}
