package com.gildedrose;

public class AgedBrie extends wrappedItem {
    public static final String AGED_BRIE = "Aged Brie";

    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    protected void expiredProcess() {
        qualityIncrease();
    }

    @Override
    protected void qualityUpdate() {
        qualityIncrease();
    }
}
