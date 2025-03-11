package com.lxh.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private By editUsername = By.id("com.cxz.wanandroid:id/et_username");
    private By editPassword = By.id("com.cxz.wanandroid:id/et_password");
    private By loginButton = By.id("com.cxz.wanandroid:id/btn_login");
    private By registerButton = By.id("com.cxz.wanandroid:id/tv_sign_up");

    public LoginPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }


    //判断是否进入login page
    public boolean isLogin() {
        return driver.findElement(editUsername).isDisplayed();
    }

    //输入文本
    public void enterUserName(String userName) {
        enterMsg(editUsername, userName);
    }

    public void enterPassword(String password) {
        enterMsg(editPassword, password);
    }

    public void clickLogin() {
        click(loginButton);
    }

    public void clickRegister() {
        click(registerButton);
    }

    //获取toast内容
    public String toastMsg() {
        By xpath = By.xpath("//android.widget.Toast");
        MobileElement element = driver.findElement(xpath);
        return element.getText();
    }

}
