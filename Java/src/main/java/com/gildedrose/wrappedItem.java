package com.gildedrose;

public class wrappedItem {
    protected Item item;

    public wrappedItem(Item item) {
        this.item = item;
    }

    public static wrappedItem create(Item item) {
        if (item.name.equals(AgedBrie.AGED_BRIE))
            return new AgedBrie(item);
        if (item.name.equals(BackstagePasses.BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT))
            return new BackstagePasses(item);
        if (item.name.equals(Sulfuras.SULFURAS_HAND_OF_RAGNAROS))
            return new Sulfuras(item);
        if(item.name.equals(Conjured.CONJURED))
            return new Conjured(item);
        return new wrappedItem(item);
    }

    protected void qualityDecrease() {
        if (item.quality > 0) {
            item.quality --;
        }
    }

    protected void qualityIncrease() {
        if (item.quality < 50) {
            item.quality ++;
        }
    }

    protected void expiredProcess() {
            qualityDecrease();
    }

    protected void sellInUpdate() {
        item.sellIn--;
    }

    protected void qualityUpdate() {
        qualityDecrease();
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
