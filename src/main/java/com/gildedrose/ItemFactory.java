package com.gildedrose;

class ItemFactory {
    public static ItemInventory create(Item item) {
        if (item.name.equals("Aged Brie")) return new AgedBrieItem(item);
        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) return new BackstagePassItem(item);
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) return new SulfurasItem(item);
        return new ItemInventory(item);
    }
}
