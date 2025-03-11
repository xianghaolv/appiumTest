package ui;

import com.lxh.config.AppiumDriverFactory;
import com.lxh.utils.LoggerUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.aspectj.lang.annotation.After;
import org.testng.annotations.*;

public class BaseTest {

    protected AppiumDriver<MobileElement> driver;

    @BeforeTest
    public void setUp() {
        try {
            driver = AppiumDriverFactory.createAppiumDriver();
        } catch (Exception e) {
            LoggerUtils.logError("Failed create appium driver --> ", e.getMessage());
        }
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
