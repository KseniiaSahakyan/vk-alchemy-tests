package com.kseniia.core;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;

public class BaseHelper {

    protected AppiumDriver driver;

    public BaseHelper(AppiumDriver driver) {
        this.driver = driver;
    }

    public boolean isElementPresent(By locator) {
        return !driver.findElements(locator).isEmpty();
    }

    public void tap(By locator) {
        driver.findElement(locator).click();
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void tapWithCoordinates(int x, int y) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);

        tap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(tap));
    }

    public void tapByAdb(int x, int y) {
        try {
            String command = String.format(
                    "/Users/kseniiasahakyan/Library/Android/sdk/platform-tools/adb shell input tap %d %d",
                    x, y
            );
            System.out.println("ADB COMMAND: " + command);

            Process process = Runtime.getRuntime().exec(new String[]{"bash", "-lc", command});
            int exitCode = process.waitFor();

            System.out.println("ADB EXIT CODE: " + exitCode);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void safeTap(int x, int y) {
        tapByAdb(x - 10, y + 10); // маленький оффсет
    }
}

