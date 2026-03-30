package com.kseniia.tests;

import com.kseniia.core.TestBase;
import com.kseniia.fw.VkVideoHelper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class VkVideoTests extends TestBase {

    VkVideoHelper vkVideoHelper;

    @BeforeMethod
    public void initHelpers() {
        vkVideoHelper = new VkVideoHelper(driver);
    }

    @Test
    public void openVideoAndShowFollowButtonPositiveTest() {
        vkVideoHelper.closeIntroPopupsIfPresent();
        vkVideoHelper.openFirstVideo();
        assertThat(vkVideoHelper.isFollowButtonVisible())
                .as("Follow button is NOT visible")
                .isTrue();
    }

    @Test
    public void notOpenVideoWhenTappedOutsideVideoCardNegativeTest() {
        vkVideoHelper.closeIntroPopupsIfPresent();
        vkVideoHelper.tapOutsideVideoCard();
        assertThat(vkVideoHelper.isFollowButtonVisible())
                .as("Follow button should NOT be visible when video is not opened")
                .isFalse();
    }
}
