package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void update() {
        for (Item item : items) {
            new wrappedItem(item).update_daily();
        }
    }

}
