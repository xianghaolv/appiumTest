package com.lxh.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class RankPage extends BasePage {

    private By rankTitle = By.xpath("//android.widget.TextView[@text=\"积分排行榜\"]");

    public RankPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public boolean isRankPage() {
        return driver.findElement(rankTitle).isDisplayed();
    }

    //滑动屏幕多次
    public void moveRankPage() {
        for (int i = 0; i < 5; i++) {
            moveView();
        }
    }

}
