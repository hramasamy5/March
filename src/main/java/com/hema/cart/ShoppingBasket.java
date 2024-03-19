package com.hema.cart;
import java.util.HashMap;
import java.util.Map;
import java.math.BigDecimal;

public class ShoppingBasket {

    private Map<String, Integer> itemCounts;
    private PriceCalculator priceCalculator;

    public ShoppingBasket(PriceCalculator priceCalculator) {
        itemCounts = new HashMap<>();
        this.priceCalculator = priceCalculator;

        // Initialize item counts
        //priceCalculator.getItemPrices().keySet().forEach(item -> itemCounts.put(item, 0));
    }

    public void addItem(String item) {
        itemCounts.put(item, itemCounts.getOrDefault(item, 0) + 1);
        System.out.println("Cart items: "+ itemCounts);
    }

    public BigDecimal calculateTotal() {
        BigDecimal total = BigDecimal.valueOf(0);

        for (String item : itemCounts.keySet()) {
            int count = itemCounts.get(item);
            total = total.add(priceCalculator.calculatePrice(item, count));
        }
        return total;
    }

    public static void main(String[] args) {
        PriceCalculator priceCalculator = new PriceCalculator();
        ShoppingBasket basket = new ShoppingBasket(priceCalculator);
        basket.addItem("Apple");
        basket.addItem("Apple");
        basket.addItem("Banana");
        basket.addItem("Melon");
        basket.addItem("Melon");
        basket.addItem("Lime");
        basket.addItem("Lime");
        basket.addItem("Lime");

        BigDecimal total = basket.calculateTotal();
        System.out.println("Total cost of the basket: " + total + "p");
    }
}