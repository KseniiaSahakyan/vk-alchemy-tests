package com.kseniia.core;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.URL;
import java.time.Duration;

public class TestBase {

    protected AndroidDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");

//        ===== VK Video (эмулятор) =====
//        options.setDeviceName("emulator-5556");
//        options.setPlatformVersion("11");
//        options.setAppPackage("com.vk.vkvideo");
//        options.setAppActivity("com.vk.video.screens.main.MainActivity");

//        ===== Alchemy (реальное устройство Samsung S23) =====
        options.setDeviceName("Samsung S23");
        options.setUdid("R3CW404X08Y");
        options.setAppPackage("com.ilyin.alchemy");
        options.setNoReset(true);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

//        ===== Для Alchemy
        driver.activateApp("com.ilyin.alchemy");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}