package com.gildedrose;

public class BackstagePasses extends wrappedItem {
    public BackstagePasses(Item item) {
        super(item);
    }

    @Override
    protected void qualityUpdate() {
        qualityIncrease();
        if (item.sellIn < 11) {
            qualityIncrease();
        }
        if (item.sellIn < 6) {
            qualityIncrease();
        }
    }


}
