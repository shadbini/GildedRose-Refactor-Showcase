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
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        }
        item.sellIn--;
    }

    protected void updateQuality() {
        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            increaseQuality();

            if (item.sellIn < 11) {
                increaseQuality();
            }

            if (item.sellIn < 6) {
                increaseQuality();
            }

        } else if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        } else {
            decreaseQuality();
        }
    }

    protected void processItem() {
        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            item.quality = 0;
        } else {
            if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                return;
            }
            decreaseQuality();
        }
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
