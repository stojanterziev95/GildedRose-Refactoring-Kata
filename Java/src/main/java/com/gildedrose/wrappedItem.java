package com.gildedrose;

public class wrappedItem {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    protected Item item;

    public wrappedItem(Item item) {
        this.item = item;
    }

    public static wrappedItem create(Item item) {
        if (item.name.equals(AGED_BRIE))
            return new AgedBrie(item);
        if (item.name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT))
            return new BackstagePasses(item);
        return new wrappedItem(item);
    }

    protected void qualityDecrease() {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    protected void qualityIncrease() {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    protected void expiredProcess() {
        if (item.name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
            item.quality = 0;
        } else if (item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
            return;
        } else {
            qualityDecrease();
        }
    }

    protected void sellInUpdate() {
        if (item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
            return;
        }
        item.sellIn--;
    }

    protected void qualityUpdate() {
        if (item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
            return;
        } else qualityDecrease();
    }

    protected boolean isExpired() {
        return item.sellIn < 0;
    }

    public void update_daily() {
        qualityUpdate();
        sellInUpdate();
        if (isExpired()) {
            expiredProcess();
        }
    }
}
