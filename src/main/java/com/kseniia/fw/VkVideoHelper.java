package com.kseniia.fw;

import com.kseniia.core.BaseHelper;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class VkVideoHelper extends BaseHelper {

    public VkVideoHelper(AndroidDriver driver) {
        super(driver);
    }

    private final By closeBtn = By.id("com.vk.vkvideo:id/close_btn_left");
    private final  By skipBtn = By.id("com.vk.vkvideo:id/fast_login_tertiary_btn");
    private final  By followBtn = By.id("com.vk.vkvideo:id/video_author_subscribe_button");


    public void closeIntroPopupsIfPresent() {
        pause(5000);

        if (isCloseIntroPresent()) {
                tapCloseIntro();
        }
        pause(2000);

        if (isSkipPresent()) {
                tapSkip();
        }
    }

    public boolean isCloseIntroPresent() {
        return isElementPresent(closeBtn);
    }

    public boolean isSkipPresent() {
        return isElementPresent(skipBtn);
    }

    public void tapCloseIntro() {
        tap(closeBtn);
    }

    public void tapSkip() {
        tap(skipBtn);
    }

    public void openFirstVideo() {
        pause(2000);
        tapWithCoordinates(547, 748);
    }

    public boolean isFollowButtonVisible() {
        return isElementPresent(followBtn);
    }

    public void tapOutsideVideoCard() {
        tapWithCoordinates(1049, 1122);
    }
}

