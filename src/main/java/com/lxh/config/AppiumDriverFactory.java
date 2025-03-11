package com.lxh.config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

//配置文件
public class AppiumDriverFactory {

    public static AppiumDriver<MobileElement> createAppiumDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName",Constants.PLATFORM_NAME);
        capabilities.setCapability("platformVersion",Constants.PLATFORM_VERSION);
        capabilities.setCapability("deviceName",Constants.DEVICE_NAME);
        capabilities.setCapability("newCommandTimeout",Constants.NEW_COMMAND_TIMEOUT);
        capabilities.setCapability("automationName",Constants.AUTOMATION_NAME);
        capabilities.setCapability("on_reset",Constants.ON_RESET);
        capabilities.setCapability("appPackage",Constants.APP_PACKAGE);
        capabilities.setCapability("appActivity",Constants.APP_ACTIVITY);

        return new AndroidDriver<MobileElement>(new URL(Constants.DEFAULT_URL), capabilities);
    }
}
