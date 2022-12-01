package com.gildedrose;

public class Conjured extends wrappedItem {
    public static final String CONJURED = "Conjured";

    public Conjured(Item item) {
        super(item);
    }

    @Override
    protected void qualityDecrease() {
        item.quality = Math.max(0, item.quality-2);
    }

//    @Override
//    protected void qualityUpdate() {
//        qualityDecrease();
//        qualityDecrease();
//    }
}
