package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {



    @Test
    void item_quality_decreases_to_0() {
        Item item = new Item("Item", 4, 1);
        GildedRose app = new GildedRose(new Item[] { item });

        app.updateQuality();

        assertEquals(0,item.quality);
    }

    @Test
    void item_quality_is_not_negative() {
        Item item = new Item("Item", 4, 0);
        GildedRose app = new GildedRose(new Item[] { item });

        app.updateQuality();
        assertEquals(0,item.quality);
    }

    @Test
    void item_quality_increases() {
        Item item = new Item("Aged Brie", 5, 6);
        GildedRose app = new GildedRose(new Item[] { item });

        app.updateQuality();
        assertEquals(7,item.quality);
    }

    @Test
    void item_quality_increases_from_49_to_50(){
        Item item = new Item("Aged Brie",5,49);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateQuality();
        assertEquals(50,item.quality);
    }

    @Test
    void item_quality_does_not_exceed_50(){
        Item item = new Item("Aged Brie",5,50);
        GildedRose app = new GildedRose(new Item[] {item});

        app.updateQuality();
        assertEquals(50,item.quality);
    }

}
