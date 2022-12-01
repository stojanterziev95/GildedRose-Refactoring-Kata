package com.gildedrose;

public class wrappedItem {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    private Item item;

    public wrappedItem(Item item) {
        this.item = item;
    }

    public static wrappedItem create(Item item) {
        return new wrappedItem(item);
    }

    protected void qualityDecrease(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    protected void qualityIncrease(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    protected void expiredProcess(Item ite) {
        if (item.name.equals(AGED_BRIE)) {
            qualityIncrease(item);
        } else if (item.name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
            item.quality = 0;
        } else if (item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
            return;
        } else {
            qualityDecrease(item);
        }
    }

    protected void sellInUpdate(Item item) {
        if (item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
            return;
        }
        item.sellIn--;
    }

    protected void qualityUpdate(Item item) {
        if (item.name.equals(AGED_BRIE)) {
            qualityIncrease(item);
        } else if (item.name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
            qualityIncrease(item);
            if (item.sellIn < 11) {
                qualityIncrease(item);
            }
            if (item.sellIn < 6) {
                qualityIncrease(item);
            }
        } else if (item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
            return;
        } else qualityDecrease(item);
    }

    protected boolean isExpired(Item item) {
        return item.sellIn < 0;
    }

    public void update_daily() {
        qualityUpdate(item);
        sellInUpdate(item);
        if (isExpired(item)) {
            expiredProcess(item);
        }
    }
}
