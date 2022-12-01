package com.gildedrose;

public class BackstagePasses extends wrappedItem {
    public static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";

    public BackstagePasses(Item item) {
        super(item);
    }

    @Override
    protected void expiredProcess() {
        item.quality = 0;
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
