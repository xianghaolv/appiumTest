package com.lxh.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class SearchPage extends BasePage{

    private By seachLinear = By.xpath("//android.widget.ScrollView[@resource-id=\"com.cxz.wanandroid:id/search_scroll_view\"]/android.widget.LinearLayout\n");


    public SearchPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }


    /**
     * 判断是否在search page页
     * @return
     */
    public boolean isSearchPage(){
        return driver.findElement(seachLinear).isDisplayed();
    }
}
