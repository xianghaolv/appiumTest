package api;

import com.lxh.config.ApiConfig;
import com.lxh.utils.LoggerUtils;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import jdk.jfr.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.CsvDataProvider;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

public class PostApiTest {

    static {
        RestAssured.useRelaxedHTTPSValidation();
    }

    @Test(dataProvider = "postApiData", dataProviderClass = CsvDataProvider.class)
    @Description("这是api测试post测试项，测试项为登录")
    @Severity(SeverityLevel.CRITICAL)
    public void testPostApis(String urlKey, String requestBody, String expectedKey, String expectedValue) {
        String url = getUrlFromKey(urlKey);
        try {
            given()
                    .contentType(ContentType.JSON)
                    .body(requestBody)
                    .when()
                    .post(url)
                    .then()
                    .statusCode(200)
                    .body(expectedKey, equalTo(expectedValue));

            List<Map<String ,Object>> data = given()
                    .contentType(ContentType.JSON)
                    .when()
                    .post(url)
                    .then()
                    .extract()
                    .path("data");

            validateData(data,url);
            LoggerUtils.logInfo("Post API test passed for URL: " + url);
        } catch (Exception e) {
            LoggerUtils.logError("Post API test failed for URL: " + url, e.getMessage());
        }
    }

    private void validateData(List<Map<String ,Object>> data,String apiName) {
        assertNotNull(data,"Data data should not be null for url " + apiName);
        assertFalse(data.isEmpty(),"Data data should not be empty for url " + apiName);
    }

    private String getUrlFromKey(String urlKey) {
        switch (urlKey) {
            case "userLogin":
                return ApiConfig.getUserLoginUrl();

            case "userRegister":
                return ApiConfig.getUserRegisterUrl();
            default:
                throw new IllegalArgumentException("Unknown URL key = " + urlKey);
        }
    }

}
