package com.gildedrose;

/**
 * Represents the legendary item "Sulfuras, Hand of Ragnaros".
 * <p>
 * Sulfuras is a legendary item that:
 * <ul>
 *     <li>Never has to be sold</li>
 *     <li>Never decreases in quality</li>
 *     <li>Its sell-in value never changes</li>
 * </ul>
 * Therefore, all update operations are intentionally left empty.
 */
public class SulfurasItem extends ItemInventory {
    public SulfurasItem(Item item) {
        super(item);
    }

    /**
     * Sulfuras never has to be sold, so its sell-in value does not decrease.
     */
    @Override
    protected void updateSellIn() {
    }

    /**
     * Sulfuras never decreases in quality, so this is intentionally left blank.
     */
    @Override
    protected void updateQuality() {
    }

    /**
     * Sulfuras never degrades after expiration, so no expiration handling is required.
     */
    @Override
    protected void handleExpiredItem() {
    }
}
