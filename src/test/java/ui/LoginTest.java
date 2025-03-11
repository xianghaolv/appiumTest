package ui;

import com.lxh.pages.LoginPage;
import com.lxh.pages.MainPage;
import com.lxh.pages.SearchPage;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.CsvDataProvider;

import java.util.concurrent.TimeUnit;

public class LoginTest extends BaseTest {

    public static Boolean isLoginPage = true;
    private MainPage mainPage;

    @Test(dataProvider = "loginData", dataProviderClass = CsvDataProvider.class)
    @Description("测试登录页面")
    @Severity(SeverityLevel.CRITICAL)
    public void testLogin(String username, String password, String expectedMsg) {
        if (isLoginPage) {
            mainPage = new MainPage(driver);
            //隐式等待5s
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            mainPage.clickDrawerButton();
            mainPage.gotoLoginPage();
            isLoginPage = false;
        }

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUserName(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        String s = loginPage.toastMsg();
        Assert.assertEquals(s, expectedMsg, "账号和密码与预期值不匹配！");
    }


}
