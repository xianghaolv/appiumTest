package com.lxh.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;

import java.time.Duration;

public class MainPage extends BasePage {

    //查找view id
    private By navigationButton = By.id("com.cxz.wanandroid:id/floating_action_btn");
    private By drawerButton = By.xpath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]\n");
    private By drawerIvRank = By.id("com.cxz.wanandroid:id/iv_rank");
    private By searchButton = By.id("com.cxz.wanandroid:id/action_search");
    private By togoBack = By.xpath("//android.widget.ImageButton[@content-desc=\"转到上一层级\"]\n");
    private By drawerLoginButton = By.id("com.cxz.wanandroid:id/tv_username");

    public MainPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }


    //判断页面是否有 这个按键，从而判断是否进入主页 。从splash 进入mian页
    public boolean isMainPage() {
        return driver.findElement(navigationButton).isDisplayed();
    }

    //点击打开侧边栏
    public void clickDrawerButton() {
        click(drawerButton);
    }

    //判断drawer是否打开
    public boolean isDrawerOpen() {
        return driver.findElement(drawerIvRank).isDisplayed();
    }

    //点击去积分页
    public void gotoRankPage() {
        click(drawerIvRank);
    }

    public void gotoSearchPage() {
        click(searchButton);
    }
    public void gotoLoginPage() {
        click(drawerLoginButton);
    }




    public void gotoBack() {
        click(togoBack);
    }

    //点击其他空白位置
    public void clickOther() {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(1000, 100))
                .release()
                .perform();
    }


}
