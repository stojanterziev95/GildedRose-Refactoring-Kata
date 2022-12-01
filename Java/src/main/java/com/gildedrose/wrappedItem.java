package com.gildedrose;

public class wrappedItem {
    private Item item;

    public wrappedItem(Item item) {
        this.item = item;
    }

    protected static void qualityIncrease(Item item, wrappedItem wrappedItem) {
        wrappedItem.quailityIncrease(item,wrappedItem);
    }

    protected void qualityDecrease(Item item, wrappedItem wrappedItem) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    protected void quailityIncrease(Item item,wrappedItem wrappedItem) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    protected void expiredProcess(Item item, wrappedItem wrappedItem) {
        if (item.name.equals("Aged Brie")) {
            quailityIncrease(item,wrappedItem);
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            item.quality = 0;
        } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        } else {
            qualityDecrease(item, wrappedItem);
        }
    }

    protected void sellInUpdate(Item item, wrappedItem wrappedItem) {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        }
        item.sellIn--;
    }

    protected void qualityUpdate(Item item,wrappedItem wrappedItem) {
        if (item.name.equals("Aged Brie")) {
            qualityIncrease(item, this);
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            qualityIncrease(item, this);
            if (item.sellIn < 11) {
                quailityIncrease(item,wrappedItem);
            }
            if (item.sellIn < 6) {
                quailityIncrease(item,wrappedItem);
            }
        } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        } else qualityDecrease(item, this);
    }

    protected boolean isExpired(Item item) {
        return item.sellIn < 0;
    }
}
