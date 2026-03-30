package com.kseniia.tests;

import com.kseniia.core.TestBase;
import com.kseniia.fw.AlchemyHelper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AlchemyTests extends TestBase {

    AlchemyHelper alchemyHelper;

    @BeforeMethod
    public void initHelpers() {
        alchemyHelper = new AlchemyHelper(driver);
    }

    @Test
    public void getHintsPositiveTest() {
        alchemyHelper.tapPlayButton();
        alchemyHelper.pause(2000);

        alchemyHelper.tapHintsButton();
        alchemyHelper.pause(2000);

        int before = alchemyHelper.getHintsCount();

        alchemyHelper.tapWatchAdsButton();

        alchemyHelper.skipAd();

        int after = alchemyHelper.getHintsCount();

        assertThat(after)
                .as("Hints count did not increase by 2")
                .isEqualTo(before + 2);
    }

}