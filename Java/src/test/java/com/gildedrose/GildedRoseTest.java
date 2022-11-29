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
        Item item = new Item("Aged Brie", 6, 7);
        GildedRose app = new GildedRose(new Item[] { item });

        app.updateQuality();
        assertEquals(8,item.quality);
    }

    @Test
    void item_quality_does_not_increases_from_50_to_51(){
        Item item = new Item("Aged Brie",5,50);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateQuality();
        assertEquals(50,item.quality);
    }

    @Test
    void item_quality_decreases_sellIn_decrease_each_day(){
        int start_sellIn = 6;
        int start_quality = 8;
        final Item item = new Item("Some text",start_sellIn,start_quality);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateQuality();
        assertEquals(item.sellIn,start_sellIn-1);
        assertEquals(item.quality,start_quality -1);
    }

    @Test
    void item_quality_increases_twice_fase_past_sellIn_time(){
        Item item = new Item("Aged Brie",0,7);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateQuality();

        assertEquals(9,item.quality);
    }

    @Test
    void items_decrease_each_day(){
        Item first_Item = new Item("First item text", 5,4);
        Item second_Item = new Item("Second item text",3,2);
        GildedRose app = new GildedRose(new Item[]{first_Item,second_Item});

        app.updateQuality();

        assertEquals(first_Item.sellIn,4);
        assertEquals(first_Item.quality,3);
        assertEquals(second_Item.sellIn,2);
        assertEquals(second_Item.quality,1);
    }

    @Test
    void quality_of_item_decreases_by_1_on_1_day_left(){
        Item item = new Item("Some text",1,5);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateQuality();
        assertEquals(item.quality,4);
    }

    @Test
    void item_quality_over_50_past_sellin_time_does_not_increase(){
        Item item = new Item("Aged Brie",0,50);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateQuality();
        assertEquals(50,item.quality);
    }

    @Test
    void item_quality_decreases_twice_faster_past_time_sellIn(){
        Item item = new Item("Some text",-1,5);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateQuality();
        assertEquals(item.quality,3);
    }



}
