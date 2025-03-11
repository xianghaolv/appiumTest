package com.lxh.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.util.concurrent.TimeUnit;

public class SplashPage extends BasePage {

    public SplashPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }


    //跳转到主页 ，等待5s
    public void gotoMain(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}
