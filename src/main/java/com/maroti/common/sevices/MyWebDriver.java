package com.maroti.common.sevices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public interface MyWebDriver {

    void javaScriptSendKeys(WebElement element, String value);
    void javaScriptClick(WebElement element);
    void actionsClick(WebElement element);
    void actionSendKeys(WebElement element, String value);
    void switchFrame(WebElement element);
    void switchFrame(int id);
    void switchFrame(String name);
    void navigateWindow(String id);
    void navigateTo(String url);
    void alertOk();
    void alertCancel();
    void alertSendKeys(String value);
    String alertCaptureText();
    void isExitsClick(WebElement element);
    void isExitsSendKeys(WebElement element, String value);
    boolean getScreenShotAs(String fileName) throws IOException;
    void visiblityExplicitWait(int second, By by);
    void clickableExplicitWait(int second, By by);
    void implicitWaite(int second);
    void goTo(String url);
    WebDriver getCurrentDriverInstance();
    void maximize();
    void minimize();
    void close();
    void quite();
}
