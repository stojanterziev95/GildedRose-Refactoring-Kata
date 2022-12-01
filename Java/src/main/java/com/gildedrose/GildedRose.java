package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void update() {
        for (Item item : items) {
            extracted_updateQuality(item);
        }
    }

    private static void extracted_updateQuality(Item item) {
        qualityUpdate(item);
        sellInUpdate(item);
        if (isExpired(item)) {
            expiredProcess(item);
        }
    }

    private static boolean isExpired(Item item) {
        return item.sellIn < 0;
    }

    private static void expiredProcess(Item item) {
        if (item.name.equals("Aged Brie")) {
            quailityIncrease(item);
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            item.quality = 0;
        } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        } else {
            qualityDecrease(item);
        }
    }

    private static void qualityDecrease(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private static void quailityIncrease(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private static void sellInUpdate(Item item) {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        }
        item.sellIn--;
    }

    private static void qualityUpdate(Item item) {
        if (item.name.equals("Aged Brie")) {
            qualityIncrease(item);
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            qualityIncrease(item);
            if (item.sellIn < 11) {
                quailityIncrease(item);
            }
            if (item.sellIn < 6) {
                quailityIncrease(item);
            }
        } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        } else qualityDecrease(item);
    }

    private static void qualityIncrease(Item item) {
        quailityIncrease(item);
    }

}
