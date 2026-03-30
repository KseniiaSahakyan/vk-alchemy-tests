package com.kseniia.fw;

import com.kseniia.core.BaseHelper;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AlchemyHelper extends BaseHelper {

    private static final Logger log = LoggerFactory.getLogger(AlchemyHelper.class);

    public AlchemyHelper(AppiumDriver driver) {
        super(driver);
    }

    private final By playBtn = By.xpath("//*[contains(@text,'Играть')]");
    private final By hintsBtn = By.xpath("(//android.widget.Button)[1]");
    private final By hintsCount = By.xpath("//android.widget.TextView[@text='Ваши подсказки']/following-sibling::android.view.View//android.widget.TextView");
    private final By watchAdsBtn = By.xpath("//android.widget.TextView[@text='Смотреть']");
    private final By rewardPopupTitle = By.xpath("//android.widget.TextView[@text='НАГРАДА ПОЛУЧЕНА']");

    private final By skipBtn = By.xpath("//android.widget.RelativeLayout[@content-desc=\"pageIndex: 1\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.ImageView");
    private final By skipBtn2 = By.xpath("//android.widget.RelativeLayout[@content-desc=\"pageIndex: 2\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.ImageView");
    private final By skipBtn3 = By.xpath("//android.widget.RelativeLayout[@content-desc=\"pageIndex: 2\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ImageView");
    private final By skipBtn4 = By.xpath("//android.widget.RelativeLayout[@content-desc=\"pageIndex: 1\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ImageView");

    private final By closeBtn = By.id("com.ilyin.alchemy:id/bigo_ad_btn_close");
    private final By closeBtn2 = By.xpath("//android.widget.RelativeLayout[@content-desc=\"pageIndex: 3\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView");


public void tapPlayButton() {
      tap(playBtn);
 }

 public void tapHintsButton() {
    tap(hintsBtn);
 }

    public int getHintsCount() {
        String text = driver.findElement(hintsCount).getText().trim();
        return Integer.parseInt(text);
    }

    public void tapWatchAdsButton() {
        tap(watchAdsBtn);
    }
    
    private By getSkipButtonOnScreen() {
        if (isElementPresent(skipBtn)) {
            return skipBtn;
        }
        if (isElementPresent(skipBtn2)) {
            return skipBtn2;
        }
        if (isElementPresent(skipBtn3)) {
            return skipBtn3;
        }
        if (isElementPresent(skipBtn4)) {
            return skipBtn4;
        }
        if (isElementPresent(closeBtn)) {
            return closeBtn;
        }
        if (isElementPresent(closeBtn2)) {
            return closeBtn2;
        }
        return null;
    }

    public void skipAd() {

        for (int i = 0; i < 5; i++) {
            log.info("try: {}", i + 1);

            By skip = getSkipButtonOnScreen();

            if (skip != null) {
                tap(skip);
                log.info("Btn found {}", skip);
                continue;
            }
            log.info("Wait 3sec");
            pause(3000);
        }

        if (isElementPresent(rewardPopupTitle)) {
            return;
        }
    }
}

