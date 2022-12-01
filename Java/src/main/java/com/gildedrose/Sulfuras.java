package com.gildedrose;

public class Sulfuras extends wrappedItem {
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";

    public Sulfuras(Item item) {
        super(item);
    }

    @Override
    protected void expiredProcess() {}

    @Override
    protected void sellInUpdate() {}

    @Override
    protected void qualityUpdate() {}
}
