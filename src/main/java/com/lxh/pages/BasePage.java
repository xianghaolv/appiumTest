package com.lxh.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;

import java.time.Duration;

public class BasePage {
    protected AppiumDriver<MobileElement> driver;

    public BasePage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public MobileElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public void click(By locator) {
        findElement(locator).click();
    }

    public void enterMsg(By locator,String msg) {
        findElement(locator).sendKeys(msg);
    }

    //滑动屏幕
    public void moveView() {
        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();

        int startX = width / 2;
        int startY = (int) (height * 0.8);

        int endY = (int) (height * 0.2);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(startX, endY))
                .release()
                .perform();

    }

}
