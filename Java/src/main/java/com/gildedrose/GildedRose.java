package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void update() {
        for (Item item : items) {
            wrappedItem wrappedItem = new wrappedItem(item);
            extracted_updateQuality(item,wrappedItem);
        }
    }

    private void extracted_updateQuality(Item item, wrappedItem wrappedItem) {
        wrappedItem.qualityUpdate(item,wrappedItem);
        wrappedItem.sellInUpdate(item,wrappedItem);
        if (wrappedItem.isExpired(item)) {
            wrappedItem.expiredProcess(item,wrappedItem);
        }
    }

}
