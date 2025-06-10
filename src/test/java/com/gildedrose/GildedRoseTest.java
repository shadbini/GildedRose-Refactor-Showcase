package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class GildedRoseTest {

    private static final int MAX_QUALITY = 50;
    private static final int NEAR_MAX_QUALITY = 49;
    private static final int SELL_IN_EXPIRES_TODAY = 0;

    @Test
    void givenStandardItem_qualityAndSellInDecreaseEachDay() {
        int startingSellIn = 5;
        int startingQuality = 7;
        var standardItem = new Item("Elixir of the Mongoose", startingSellIn, startingQuality);
        var gildedRose = new GildedRose(new Item[]{standardItem});

        gildedRose.updateQuality();

        assertThat(standardItem.sellIn).isEqualTo(startingSellIn - 1);
        assertThat(standardItem.quality).isEqualTo(startingQuality - 1);
    }

    @Test
    void givenMultipleStandardItems_qualityAndSellInDecreaseEachDay() {
        var firstItem = new Item("First Standard Item", 5, 4);
        var secondItem = new Item("Second Standard Item", 3, 2);
        var gildedRose = new GildedRose(new Item[]{firstItem, secondItem});

        gildedRose.updateQuality();

        assertThat(firstItem.sellIn).isEqualTo(4);
        assertThat(firstItem.quality).isEqualTo(3);
        assertThat(secondItem.sellIn).isEqualTo(2);
        assertThat(secondItem.quality).isEqualTo(1);
    }

    @Test
    void givenStandardItem_whenSellInDateInPast_thenQualityDegradesTwiceAsFast() {
        var sellInInPast = -1;
        Item item = new Item("Standard Item", sellInInPast, 4);
        var gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertThat(item.quality).isEqualTo(2);
    }

    @Test
    void givenStandardItem_whenSellInExpiresToday_thenQualityDegradesTwiceAsFast() {
        int sellInExpiresToday = 0;
        int startingQuality = 10;
        var item = new Item("Standard Item", sellInExpiresToday, startingQuality);
        var gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertThat(item.sellIn).isEqualTo(sellInExpiresToday - 1);
        assertThat(item.quality).isEqualTo(startingQuality - 2);
    }

    @Test
    void givenStandardItem_whenSellInOneDayBeforeExpiration_thenQualityDecreasesByOne() {
        var item = new Item("Standard Item", 1, 4);
        var gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertThat(item.sellIn).isEqualTo(0);
        assertThat(item.quality).isEqualTo(3);
    }


    @Test
    void givenStandardItemWithQualityOne_whenUpdated_thenQualityDegradesToZero(){
        var item = new Item("Standard Item", 4, 1);
        var gildedRose = new GildedRose(new Item[] { item });

        gildedRose.updateQuality();

        assertThat(item.quality).isZero();
    }

    @Test
    void givenStandardItemWithZeroQuality_whenUpdated_thenQualityNeverBecomesNegative(){

        var item = new Item("First Standard Item", 4, 0);
        var gildedRose = new GildedRose(new Item[] { item });

        gildedRose.updateQuality();

        assertThat(item.quality).isZero();
    }


    @Test
    void givenAgedItem_whenUpdated_thenQualityIncrease() {
        var item = new Item("Aged Brie", 5, 6);
        var gildedRose = new GildedRose(new Item[] { item });

        gildedRose.updateQuality();

        assertThat(item.sellIn).isEqualTo(4);
        assertThat(item.quality).isEqualTo(7);
    }

    @Test
    void givenAgedItem_whenQualityIsNearMaximum_thenQualityCappedAtMaximum() {
        var item = new Item("Aged Brie", 5, NEAR_MAX_QUALITY);
        var gildedRose = new GildedRose(new Item[] { item });

        gildedRose.updateQuality();

        assertThat(item.quality).isEqualTo(MAX_QUALITY);
    }

    @Test
    void givenAgedItem_whenQualityIsAtMaximum_thenQualityRemainsUnchanged() {
        var item = new Item("Aged Brie", 5, MAX_QUALITY);
        var gildedRose = new GildedRose(new Item[] { item });

        gildedRose.updateQuality();

        assertThat(item.quality).isEqualTo(MAX_QUALITY);
    }

    @Test
    void givenAgedItem_whenSellInExpiresToday_thenQualityIncreasesTwiceAsFast() {
        var item = new Item("Aged Brie", SELL_IN_EXPIRES_TODAY, 6);
        var gildedRose = new GildedRose(new Item[] { item });

        gildedRose.updateQuality();

        assertThat(item.quality).isEqualTo(8);
    }

    @Test
    void givenAgedItem_whenSellInExpiresTodayAndQualityIsMax_thenQualityRemainsUnchanged() {
        var item = new Item("Aged Brie", SELL_IN_EXPIRES_TODAY, MAX_QUALITY);
        var gildedRose = new GildedRose(new Item[]{item});

        gildedRose.updateQuality();

        assertThat(item.quality).isEqualTo(MAX_QUALITY);
    }
}
