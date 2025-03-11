package api;

import com.lxh.config.ApiConfig;
import com.lxh.utils.LoggerUtils;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import utils.CsvDataProvider;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

public class GetApiTest {

    static {
        RestAssured.useRelaxedHTTPSValidation();
    }

    @Test
    public void testArticleList() {
        try {
            given()
                    .contentType(ContentType.JSON)
                    .when()
                    .get(ApiConfig.getArticleListUrl())
                    .then()
                    .statusCode(200)
                    .body("errorCode", equalTo(0));

            List<Map<String ,Object>> data = given()
                    .contentType(ContentType.JSON)
                    .when()
                    .get(ApiConfig.getArticleListUrl())
                    .then()
                    .extract()
                    .path("data.datas");

            assertNotNull(data,"ArticleList data should not be bull");
            assertFalse(data.isEmpty(),"ArticleList data should not be empty");
            LoggerUtils.logInfo("Article list API test passed");
        } catch (Exception e) {
            LoggerUtils.logError("Article list API test failed", e.getMessage());
        }
    }

    @Test
    @Description("这是api测试，测试项为轮播图")
    @Severity(SeverityLevel.CRITICAL)
    public void testBanner() {
        try {
            given()
                    .contentType(ContentType.JSON)
                    .when()
                    .get(ApiConfig.getBannerUrl())
                    .then()
                    .statusCode(200)
                    .body("errorCode", equalTo(0));

            List<Map<String ,Object>> data = given()
                    .contentType(ContentType.JSON)
                    .when()
                    .get(ApiConfig.getBannerUrl())
                    .then()
                    .extract()
                    .path("data");

            assertNotNull(data,"Banner data should not be bull");
            assertFalse(data.isEmpty(),"Banner data should not be empty");

            LoggerUtils.logInfo("Banner Api test passed");
        } catch (Exception e) {
            LoggerUtils.logError("Failed Banner api test....", e.getMessage());
        }
    }

    @Test
    @Description("这是api测试，测试项为常用网站")
    @Severity(SeverityLevel.CRITICAL)
    public void testFriend() {
        try {
            given()
                    .contentType(ContentType.JSON)
                    .when()
                    .get(ApiConfig.getFriendUrl())
                    .then()
                    .statusCode(200)
                    .body("errorCode", equalTo(0));

            List<Map<String ,Object>> data = given()
                    .contentType(ContentType.JSON)
                    .when()
                    .get(ApiConfig.getFriendUrl())
                    .then()
                    .extract()
                    .path("data");

            assertNotNull(data,"Friend data should not be bull");
            assertFalse(data.isEmpty(),"Friend data should not be empty");

            LoggerUtils.logInfo("Friend Api test passed");
        } catch (Exception e) {
            LoggerUtils.logError("Failed Friend api test....", e.getMessage());
        }
    }

    @Test
    @Description("这是api测试，测试项为热词")
    @Severity(SeverityLevel.CRITICAL)
    public void testHotKey() {
        try {
            given()
                    .contentType(ContentType.JSON)
                    .when()
                    .get(ApiConfig.getHotKeyUrl())
                    .then()
                    .statusCode(200)
                    .body("errorCode", equalTo(0));

            List<Map<String ,Object>> data = given()
                    .contentType(ContentType.JSON)
                    .when()
                    .get(ApiConfig.getHotKeyUrl())
                    .then()
                    .extract()
                    .path("data");

            assertNotNull(data,"HotKey data should not be bull");
            assertFalse(data.isEmpty(),"HotKey data should not be empty");

            LoggerUtils.logInfo("HotKey Api test passed");
        } catch (Exception e) {
            LoggerUtils.logError("Failed HotKey api test....", e.getMessage());
        }
    }


    @Test
    @Description("这是api测试，测试项为置顶文章")
    @Severity(SeverityLevel.CRITICAL)
    public void testArticleTop() {
        try {
            given()
                    .contentType(ContentType.JSON)
                    .when()
                    .get(ApiConfig.getArticleTopUrl())
                    .then()
                    .statusCode(200)
                    .body("errorCode", equalTo(0));

            List<Map<String ,Object>> data = given()
                    .contentType(ContentType.JSON)
                    .when()
                    .get(ApiConfig.getArticleTopUrl())
                    .then()
                    .extract()
                    .path("data");

            assertNotNull(data,"ArticleTop data should not be bull");
            assertFalse(data.isEmpty(),"ArticleTop data should not be empty");

            LoggerUtils.logInfo("Article Top Api test passed");
        } catch (Exception e) {
            LoggerUtils.logError("Failed Article Top api test....", e.getMessage());
        }
    }

    //TODO: 这个执行失败了
    @Test(dataProvider = "getApiData", dataProviderClass = CsvDataProvider.class)
    public void testGetApisWithParams(String urlKey, String expectedKey, String expectedValue) {
        String url = getUrlFromKey(urlKey);
        try {
            given()
                    .contentType(ContentType.JSON)
                    .when()
                    .get(url)
                    .then()
                    .statusCode(200)
                    .body(expectedKey, equalTo(expectedValue));

            List<Map<String ,Object>> data = given()
                    .contentType(ContentType.JSON)
                    .when()
                    .get(url)
                    .then()
                    .extract()
                    .path("data");

            assertNotNull(data,"Data data should not be bull");
            assertFalse(data.isEmpty(),"Data data should not be empty");

            LoggerUtils.logInfo("Get Api with params test passed for url = " + url);
        } catch (Exception e) {
            LoggerUtils.logError("Failed Get Api with params test...." + url, e.getMessage());
        }
    }

    private String getUrlFromKey(String urlKey) {
        switch (urlKey) {
            case "articleList":
                return ApiConfig.getArticleListUrl();
            case "banner":
                return ApiConfig.getBannerUrl();
            case "friend":
                return ApiConfig.getFriendUrl();
            case "hotkey":
                return ApiConfig.getHotKeyUrl();
            case "articleTop":
                return ApiConfig.getArticleTopUrl();
            default:
                throw new IllegalArgumentException("Unknown URL key: " + urlKey);
        }
    }


}
