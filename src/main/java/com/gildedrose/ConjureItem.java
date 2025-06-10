package com.gildedrose;

public class ConjureItem extends ItemInventory {
    public ConjureItem(Item item) {
        super(item);
    }

    @Override
    protected void decreaseQuality() {
        item.quality = Math.max(0, item.quality - 2);
    }
}
