package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            //Item is not "Brie" and item is not "Backstage passes"
            if (!items[i].name.equals("Aged Brie")
                && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                //the quality of the i-th item is > 0
                if (items[i].quality > 0) {
                    //item is not "Sulfuras"
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        //decrease the quality of the item by 1
                        items[i].quality = items[i].quality - 1;
                    }
                }
                //item is "Brie" and "Backstage passes"
            } else {
                 //the quality of the i-th item is less than 50
                if (items[i].quality < 50) {
                    //increase the quality by 1
                    items[i].quality = items[i].quality + 1;
                    /*if item is "Backstage passes", the sellIn is less than 11 and the quality of the item
                    is less than 50 increase the quality by 1*/
                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                        /*if item is "Backstage passes, but the sellIn is less than 6 and the quality of
                        the item is less than 50 increase the quality by 1*/

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }
            //item is not "Sulfuras" decrease the sellIn by 1
            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }
            //if item's sellIn is less than 0
            if (items[i].sellIn < 0) {
                //if item is not "Brie"
                if (!items[i].name.equals("Aged Brie")) {
                    //item is not "Backstage passes"
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        //quality of item is > 0
                        if (items[i].quality > 0) {
                            //item is not "Sulfuras" decrease the quality by 1
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                        //quality is <0
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                    //item is "Brie"
                } else {
                    //quality is less than 50
                    if (items[i].quality < 50) {
                        //increase the quality by 1
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }
}
