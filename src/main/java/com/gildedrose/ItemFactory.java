package com.gildedrose;

class ItemFactory {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String CONJURE = "Conjured Mana Cake";

    public static ItemInventory create(Item item) {
        if (AGED_BRIE.equals(item.name)) return new AgedBrieItem(item);
        if (BACKSTAGE_PASSES.equals(item.name)) return new BackstagePassItem(item);
        if (SULFURAS.equals(item.name)) return new SulfurasItem(item);
        if (CONJURE.equals(item.name)) return new ConjureItem(item);
        return new ItemInventory(item);
    }
}

