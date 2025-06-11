package com.gildedrose;

public class BackstagePassItem extends ItemInventory {
    public BackstagePassItem(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        increaseQuality();
        if (item.sellIn < 11) {
            increaseQuality();
        }

        if (item.sellIn < 6) {
            increaseQuality();
        }
    }

    @Override
    protected void handleExpiredItem() {
        item.quality = 0;
    }
}
