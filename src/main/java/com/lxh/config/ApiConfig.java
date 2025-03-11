package com.lxh.config;

import com.lxh.utils.LoggerUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 通过配置文件获取内容
 */
public class ApiConfig {

//    private static final Properties prop = new Properties();
//    static {
//        try(InputStream in = ApiConfig.class.getClassLoader().getResourceAsStream("application.properties")) {
//            prop.load(in);
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//    }
//
//    public static String getBaseUrl() {
//        return prop.getProperty("wanandroid.baseUrl");
//    }
//
//    public static String getArticleList(){
//        return getBaseUrl() + prop.getProperty("wanandroid.articleList");
//    }
//
//    public static String getBannerUrl(){
//        return getBaseUrl() + prop.getProperty("wanandroid.banner");
//    }
//
//    public static String getFriendUrl(){
//        return getBaseUrl() + prop.getProperty("wanandroid.friend");
//    }
//
//    public static String getHotKeyUrl(){
//        return getBaseUrl() + prop.getProperty("wanandroid.hotkey");
//    }
//
//    public static String getArticleTopUrl(){
//        return getBaseUrl() + prop.getProperty("wanandroid.articleTop");
//    }
//
//    public static String getUserLoginUrl(){
//        return getBaseUrl() + prop.getProperty("wanandroid.userLogin");
//    }
//
//    public static String getUserRegisterUrl(){
//        return getBaseUrl() + prop.getProperty("wanandroid.userRegister");
//    }

    private static final Properties properties = new Properties();

    static {
        try (InputStream inputStream = ApiConfig.class.getClassLoader().getResourceAsStream("application.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            LoggerUtils.logError("load application.properties Failed ...." ,e.getMessage());
        }
    }

    public static String getBaseUrl() {
        return properties.getProperty("wanandroid.baseUrl");
    }

    public static String getArticleListUrl() {
        return getBaseUrl() + properties.getProperty("wanandroid.articleList");
    }

    public static String getBannerUrl() {
        return getBaseUrl() + properties.getProperty("wanandroid.banner");
    }

    public static String getFriendUrl() {
        return getBaseUrl() + properties.getProperty("wanandroid.friend");
    }

    public static String getHotKeyUrl() {
        return getBaseUrl() + properties.getProperty("wanandroid.hotkey");
    }

    public static String getArticleTopUrl() {
        return getBaseUrl() + properties.getProperty("wanandroid.articleTop");
    }

    public static String getUserLoginUrl() {
        return getBaseUrl() + properties.getProperty("wanandroid.userLogin");
    }

    public static String getUserRegisterUrl() {
        return getBaseUrl() + properties.getProperty("wanandroid.userRegister");
    }


}
