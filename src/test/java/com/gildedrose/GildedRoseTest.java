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

}
