package com.hema.cart;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;

class PriceCalculator {
    private Map<String, BigDecimal> itemPrices;
    private Map<String, PricingStrategy> pricingStrategies;
    private Map<String, SpecialOffer> specialOffers;

    public PriceCalculator() {
        itemPrices = new HashMap<>();
        pricingStrategies = new HashMap<>();
        specialOffers = new HashMap<>();

        // Initialize item prices
        itemPrices.put("Apple", BigDecimal.valueOf(0.35));
        itemPrices.put("Banana", BigDecimal.valueOf(0.20));
        itemPrices.put("Melon", BigDecimal.valueOf(0.50));
        itemPrices.put("Lime", BigDecimal.valueOf(0.15));
        System.out.println("itemPrices\t="+ itemPrices);

        // Initialize pricing strategies
        pricingStrategies.put("Apple", new DefaultPricing());
        pricingStrategies.put("Banana", new DefaultPricing());
        //pricingStrategies.put("Melon", new DefaultPricing());
        //pricingStrategies.put("Lime", new DefaultPricing());
        System.out.println("pricingStrategies\t="+ pricingStrategies);
       
        // Initialize special offers
        specialOffers.put("Melon", new BuyOneGetOneFree());
        specialOffers.put("Lime", new ThreeForPriceOfTwo());
        System.out.println("specialOffers=\t"+ specialOffers);
    }

    public BigDecimal calculatePrice(String itemName, int quantity) {
        BigDecimal price = itemPrices.getOrDefault(itemName, BigDecimal.valueOf(0.0));
        PricingStrategy pricingStrategy = pricingStrategies.getOrDefault(itemName, new DefaultPricing());
        SpecialOffer specialOffer = specialOffers.get(itemName);

        // calculate price based on special offer
        if (specialOffer != null) {
            return specialOffer.applyOffer(quantity, price);
        } else {
        // if no special offer, use the pricing strategy
            return pricingStrategy.calculatePrice(quantity, price);
        }
    }

    // Getter for testing purposes
    public Map<String, BigDecimal> getItemPrices() {
        return itemPrices;
    }
}