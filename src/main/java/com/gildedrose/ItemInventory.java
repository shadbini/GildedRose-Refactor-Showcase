package com.gildedrose;

public class ItemInventory {
    protected final Item item;

    public ItemInventory(Item item) {
        this.item = item;
    }

    protected void updateItem() {
        updateQuality();
        updateSellIn();
        if (isExpired()) {
            processItem();
        }
    }

    protected void updateSellIn() {
        item.sellIn--;
    }

    protected void updateQuality() {
        decreaseQuality();
    }

    protected void processItem() {
        decreaseQuality();
    }

    protected boolean isExpired() {
        return item.sellIn < 0;
    }

    protected void increaseQuality() {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    protected void decreaseQuality() {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }
}
