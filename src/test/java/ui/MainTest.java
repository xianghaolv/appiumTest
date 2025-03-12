package ui;

import com.lxh.pages.*;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTest extends BaseTest {

    private MainPage mainPage;

    @Test
    @Description("正在测试是否从splash 进入 主页")
    @Severity(SeverityLevel.CRITICAL)
    public void gotoMain() {
        SplashPage splashPage = new SplashPage(driver);
        splashPage.gotoMain();

        mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.isMainPage(), "未能进入主页，测试失败！");
    }


    @Test
    @Description("正在测试侧边栏是否打开，并进行操作")
    @Severity(SeverityLevel.CRITICAL)
    public void isOpenDrawer() {
        //未打开
        mainPage.clickDrawerButton();
        if (!mainPage.isDrawerOpen()) {
            mainPage.clickDrawerButton();
        } else {
            Assert.assertTrue(mainPage.isDrawerOpen(), "open drawer failed....");
        }
        mainPage.gotoRankPage();

        RankPage rankPage = new RankPage(driver);
        Assert.assertTrue(rankPage.isRankPage(), "rank page failed....");
        rankPage.moveRankPage();
        mainPage.gotoBack();
    }

    @Test
    @Description("正在测试侧边栏是否打开，并进入login")
    @Severity(SeverityLevel.CRITICAL)
    public void gotoLoginPage() {
        //未打开
        if (!mainPage.isDrawerOpen()) {
            mainPage.clickDrawerButton();
        }
        mainPage.gotoLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isLogin(), "login page failed....");
    }


    @Test
    @Description("进入搜索页测试")
    @Severity(SeverityLevel.CRITICAL)
    public void gotoSearch() {
        mainPage.clickOther();//点击一下标题，如何在drawer页则回到主页
        mainPage.gotoSearchPage();

        SearchPage searchPage = new SearchPage(driver);
        Assert.assertTrue(searchPage.isSearchPage(), "search page failed....");
        mainPage.gotoBack();
    }

}
