package com.gildedrose;

public class wrappedItem {
    private Item item;

    public wrappedItem(Item item) {
        this.item = item;
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
        if (item.name.equals("Aged Brie")) {
            qualityIncrease(item);
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            item.quality = 0;
        } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        } else {
            qualityDecrease(item);
        }
    }

    protected void sellInUpdate(Item item) {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        }
        item.sellIn--;
    }

    protected void qualityUpdate(Item item) {
        if (item.name.equals("Aged Brie")) {
            qualityIncrease(item);
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            qualityIncrease(item);
            if (item.sellIn < 11) {
                qualityIncrease(item);
            }
            if (item.sellIn < 6) {
                qualityIncrease(item);
            }
        } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
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
