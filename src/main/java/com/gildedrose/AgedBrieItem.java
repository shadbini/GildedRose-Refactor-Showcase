package com.gildedrose;

public class AgedBrieItem extends ItemInventory {
    public AgedBrieItem(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        increaseQuality();
    }

    @Override
    protected void processItem() {
        increaseQuality();
    }
}
