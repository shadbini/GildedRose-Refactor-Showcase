package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class GildedRoseTest {

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

}
